package com.isep.gorgeoussandwich.service;


import com.isep.gorgeoussandwich.dto.ReviewDTO;
import com.isep.gorgeoussandwich.dto.UserDTO;
import com.isep.gorgeoussandwich.model.Review;
import com.isep.gorgeoussandwich.model.Sandwich;
import com.isep.gorgeoussandwich.repository.ReviewRepository;
import com.isep.gorgeoussandwich.repository.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.isep.gorgeoussandwich.utils.PropertiesObtain;
import org.springframework.web.client.RestTemplate;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private SandwichRepository sandwichRepository;

    //@Autowired
    //private UserRepository userRepository;

    //@Autowired
    //private OrderRepository orderRepository;

    public HttpStatus addReview(ReviewDTO reviewDTO) {

        RestTemplate rt = new RestTemplate();
        String url;
        //Check if sandwich exists
        Optional<Sandwich> sandwich = this.sandwichRepository.findById(reviewDTO.getSandwichId());
        if(!sandwich.isPresent()){
            throw new Error("This sandwich does not exist");
        }

        //Check if user exists
        url = "http://host.docker.internal:8086/user/"+ reviewDTO.getUserId();
        UserDTO user = rt.getForObject(url, UserDTO.class);
        if (user == null) {
            throw new Error("User does not exist!!");
        }

        //Check if user did not review yet
        List<Review> checkReview = this.reviewRepository.findByUserIdAndSandwichId(reviewDTO.getUserId(),reviewDTO.getSandwichId());
        if(checkReview.size()>0){
            throw new Error("This user already rated this sandwich");
        }



        //Check if user ordered this sandwich

        url = "http://host.docker.internal:8088/order/user/"+reviewDTO.getUserId()+"/sandwich/"+reviewDTO.getSandwichId();
        boolean flag = rt.getForObject(url,boolean.class);
        System.out.println("Flag:"+flag);
        if(flag==false){
            throw new Error("This user did not ordered this sandwich");
        }

        /*
        List<Order> checkOrders = this.orderRepository.findByUserId(reviewDTO.getUserId());
        System.out.println("Size:"+ checkOrders.size());
        int count = 0;
        for(Order o : checkOrders){
            System.out.println("ID:"+o.getSandwichIdCollection());
            if(o.getSandwichIdCollection().contains(Math.toIntExact(reviewDTO.getSandwichId()))){
                count++;
            }
        }
        if(count==0){
            throw new Error("This user did not ordered this sandwich");
        }*/

        //Check if its between the parameters
        if(reviewDTO.getGrade().getGrade()< Double.parseDouble(PropertiesObtain.getPropertiesValue("minGrade")) || reviewDTO.getGrade().getGrade()> Double.parseDouble(PropertiesObtain.getPropertiesValue("maxGrade"))){
            throw new Error("Grade invalid");
        }

        Review review = new Review(reviewDTO.getGrade(),reviewDTO.getSandwichId(),reviewDTO.getUserId());
        reviewRepository.save(review);
        return HttpStatus.OK;
    }

    public List<ReviewDTO> getAllReviews(){
        List<Review> reviewList = this.reviewRepository.findAll();
        List<ReviewDTO> dtoList = new ArrayList<>();
        for(Review r : reviewList){
            dtoList.add(new ReviewDTO(r.getGrade(),r.getSandwichId(),r.getUserId()));
        }
        return dtoList;
    }

    public HttpStatus deleteReview(long id) {
        Optional<Review> review = this.reviewRepository.findById(id);
        if(!review.isPresent()){
            throw new Error("This review do not exist");
        }
        this.reviewRepository.delete(review.get());
        return HttpStatus.OK;
    }

    public List<ReviewDTO> getAllReviewsOfSandwich(long sandwichId){

        //Check if sandwich exists
        Optional<Sandwich> sandwich = this.sandwichRepository.findById(sandwichId);
        if(!sandwich.isPresent()){
            throw new Error("This sandwich does not exist");
        }
        List<ReviewDTO> dtoList = new ArrayList<>();
        List<Review> listRev = this.reviewRepository.findBySandwichId(sandwichId);
        for(Review r : listRev){
            dtoList.add(new ReviewDTO(r.getGrade(),r.getSandwichId(),r.getSandwichId()));
        }
        return dtoList;
    }

}
