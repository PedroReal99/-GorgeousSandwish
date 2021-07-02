package com.isep.gorgeoussandwich.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.isep.gorgeoussandwich.dto.OrderDTO;
import com.isep.gorgeoussandwich.dto.SandwichDTO;
import com.isep.gorgeoussandwich.dto.UserDTO;
import com.isep.gorgeoussandwich.model.Order;
import com.isep.gorgeoussandwich.repository.OrderRepository;
import com.isep.gorgeoussandwich.utils.DateUtils;
import com.isep.gorgeoussandwich.utils.PropertiesObtain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    //@Autowired
    //private SandwichRepository sandwichRepository;

    //@Autowired
    //private UserRepository userRepository;

    public HttpStatus addOrder(OrderDTO orderDTO) throws JsonProcessingException {

        //ResponseEntity<String> response = rt.getForEntity(url,String.class);

        /*ResponseEntity<Order[]> response = rt.getForEntity(url,Order[].class);
        System.out.println(((Order) response.getBody()));*/

        /*ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name = root.path("sandwichId");
        System.out.println(response.getBody());
        System.out.println("Name: "+name);*/

        RestTemplate rt = new RestTemplate();
        String url;

        //Check if sandwich exists
        for(Integer sid : orderDTO.getSandwichIdCollection()) {
            url = "http://host.docker.internal:8087/sandwich/"+sid;
            SandwichDTO sandwich = rt.getForObject(url, SandwichDTO.class);
            if (sandwich == null) {
                throw new Error("Sandwich does not exist!!");
            }
        }

        //Check if user exists
        url = "http://host.docker.internal:8086/user/"+ orderDTO.getUserId();
        UserDTO user = rt.getForObject(url, UserDTO.class);
        if (user == null) {
            throw new Error("User does not exist!!");
        }

        //Check if size of quantity is equal size of sandwiches
        if(orderDTO.getSandwichIdCollection().size()!=orderDTO.getQuantityCollection().size()){
            throw new Error("Sizes do not correspond");
        }

        //Check Dates before and after delivery date
        if(!DateUtils.isBetweenDates(orderDTO.getDeliveryDate().getDeliveryDate(),Integer.parseInt(PropertiesObtain.getPropertiesValue("minDate")),Integer.parseInt(PropertiesObtain.getPropertiesValue("maxDate")))){
            throw new Error("Invalid date inserted");
        }


        Order order = new Order(orderDTO.getUserId(),orderDTO.getSandwichIdCollection(),orderDTO.getQuantityCollection(),orderDTO.getDeliveryDate());
        orderRepository.save(order);
        return HttpStatus.OK;
    }

    public List<OrderDTO> getAllOrders(){
        List<Order> ordersList = this.orderRepository.findAll();
        List<OrderDTO> dtoList = new ArrayList<>();
        for(Order o : ordersList){
            dtoList.add(new OrderDTO(o.getUserId(),o.getSandwichIdCollection(),o.getQuantityCollection(),o.getDeliveryDate()));
        }
        return dtoList;
        //return ObjectMapperUtils.mapAll(sandwichList, SandwichDTO.class);
    }

    public HttpStatus updateOrder(long id, OrderDTO orderDTO) {

        RestTemplate rt = new RestTemplate();
        String url;

        Optional<Order> order= orderRepository.findById(id);
        if(!order.isPresent()){
            throw new Error("There is no order with this id");
        }

        //Check if size of quantity is equal size of sandwichs
        if(orderDTO.getSandwichIdCollection().size()!=orderDTO.getQuantityCollection().size()){
            throw new Error("Sizes do not correspond");
        }

        //Check if user exists
        url = "http://host.docker.internal:8086/user/"+ orderDTO.getUserId();
        UserDTO user = rt.getForObject(url, UserDTO.class);
        if (user == null) {
            throw new Error("User does not exist!!");
        }


        //Check if sandwich exists
         for(Integer sid : orderDTO.getSandwichIdCollection()) {
            url = "http://host.docker.internal:8087/sandwich/"+sid;
            SandwichDTO sandwich = rt.getForObject(url, SandwichDTO.class);
            if (sandwich == null) {
                throw new Error("Sandwich does not exist!!");
            }
        }

        //Check if its available update
        if(order.get().getDeliveryDate().getDeliveryDate().before(DateUtils.DiferenceBetween(Integer.parseInt(PropertiesObtain.getPropertiesValue("updateDays"))))){
            throw new Error("You can´t change your order");
        }

        //Order nOrder = new Order(orderDTO.getUserId(),orderDTO.getSandwichIdCollection(), orderDTO.getQuantityCollection(),orderDTO.getDeliveryDate());
        Order nOrder=order.get();
        nOrder.setUserId(orderDTO.getUserId());
        nOrder.setDate(orderDTO.getDeliveryDate());
        nOrder.setQuantityCollection(orderDTO.getQuantityCollection());
        nOrder.setSandwichIdCollection(orderDTO.getSandwichIdCollection());
        orderRepository.save(nOrder);
        return HttpStatus.OK;

    }

    public boolean getAllOrderByUserId(long userId, long sandwichId){

        List<Order> checkOrders = this.orderRepository.findByUserId(userId);
        System.out.println("Size:"+ checkOrders.size());
        int count = 0;
        for(Order o : checkOrders){
            System.out.println("ID:"+o.getSandwichIdCollection());
            if(o.getSandwichIdCollection().contains(Math.toIntExact(sandwichId))){
                count++;
            }
        }
        if(count==0){
            return false;
            //throw new Error("This user did not ordered this sandwich");
        }
        return true;
    }

}
