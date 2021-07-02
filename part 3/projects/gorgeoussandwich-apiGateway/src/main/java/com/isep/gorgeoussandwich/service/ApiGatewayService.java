package com.isep.gorgeoussandwich.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApiGatewayService {


    public ResponseEntity<String> getAllSandwiches(){
        RestTemplate rt = new RestTemplate();
        String url = "http://host.docker.internal:8087/sandwich";
        return rt.getForEntity(url,String.class);
    }

    public ResponseEntity<String> getSandwichDetails(long id){
        RestTemplate rt = new RestTemplate();
        String url = "http://host.docker.internal:8087/sandwich/details/"+id;
        return rt.getForEntity(url,String.class);
    }

    public ResponseEntity<String> getSandwichComments(long id){
        RestTemplate rt = new RestTemplate();
        String url = "http://host.docker.internal:8087/comment/sandwich/"+id;
        return rt.getForEntity(url,String.class);
    }

    public ResponseEntity<String> getSandwichReviews(long id){
        RestTemplate rt = new RestTemplate();
        String url = "http://host.docker.internal:8087/review/sandwich/"+id;
        return rt.getForEntity(url,String.class);
    }

    public ResponseEntity<String> getSandwichInfo(long id){
        RestTemplate rt = new RestTemplate();
        String url = "http://host.docker.internal:8087/sandwich/"+id;
        return rt.getForEntity(url,String.class);
    }



    /*public HttpStatus addUser(UserDTO userDTO) {
        User user = new User(userDTO.getName(),userDTO.getDescription(),userDTO.getIsUser());
        userRepository.save(user);
        return HttpStatus.OK;
    }

    public UserDTO getUserById(long userId) {
        Optional<User> userDB = this.userRepository.findById(userId);
        if (userDB.isPresent()) {
            return new UserDTO(userDB.get().getName(),userDB.get().getDescription(),userDB.get().getIsUser());
        } else {
            System.out.println("Error!! User not found");
            return null;
        }
    }*/



}
