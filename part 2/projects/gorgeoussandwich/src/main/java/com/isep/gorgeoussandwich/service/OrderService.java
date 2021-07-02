package com.isep.gorgeoussandwich.service;


import com.isep.gorgeoussandwich.dto.OrderDTO;
import com.isep.gorgeoussandwich.model.Order;
import com.isep.gorgeoussandwich.model.Sandwich;
import com.isep.gorgeoussandwich.model.User;
import com.isep.gorgeoussandwich.repository.OrderRepository;
import com.isep.gorgeoussandwich.repository.SandwichRepository;
import com.isep.gorgeoussandwich.repository.UserRepository;
import com.isep.gorgeoussandwich.utils.DateUtils;
import com.isep.gorgeoussandwich.utils.PropertiesObtain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SandwichRepository sandwichRepository;

    @Autowired
    private UserRepository userRepository;

    public HttpStatus addOrder(OrderDTO orderDTO) {

        //Check if sandwich exists
        for(Integer sid : orderDTO.getSandwichIdCollection()) {
            long sidLong = Long.valueOf(sid);
            Optional<Sandwich> sandwich = this.sandwichRepository.findById(sidLong);
            if (!sandwich.isPresent()) {
                throw new Error("This sandwich does not exist");
            }
        }

        //Check if user exists
        Optional<User> user = this.userRepository.findById(orderDTO.getUserId());
        if(!user.isPresent()){
            throw new Error("This user does not exist");
        }

        //Check if size of quantity is equal size of sandwichs
        if(orderDTO.getSandwichIdCollection().size()!=orderDTO.getQuantityCollection().size()){
            throw new Error("Sizes do not correspond");
        }

        //Check Dates before and after delivery date
        if(!DateUtils.isBetweenDates(orderDTO.getDeliveryDate(),Integer.parseInt(PropertiesObtain.getPropertiesValue("minDate")),Integer.parseInt(PropertiesObtain.getPropertiesValue("maxDate")))){
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

        Optional<Order> order= orderRepository.findById(id);
        if(!order.isPresent()){
            throw new Error("There is no order with this id");
        }

        //Check if size of quantity is equal size of sandwichs
        if(orderDTO.getSandwichIdCollection().size()!=orderDTO.getQuantityCollection().size()){
            throw new Error("Sizes do not correspond");
        }

        //Check if user exists
        Optional<User> user = this.userRepository.findById(orderDTO.getUserId());
        if(!user.isPresent()){
            throw new Error("This user does not exist");
        }

        //Check if sandwich exists
        for(Integer sid : orderDTO.getSandwichIdCollection()) {
            long sidLong = Long.valueOf(sid);
            Optional<Sandwich> sandwich = this.sandwichRepository.findById(sidLong);
            if (!sandwich.isPresent()) {
                throw new Error("This sandwich does not exist");
            }
        }

        //Check if its available update
        if(order.get().getDeliveryDate().before(DateUtils.DiferenceBetween(Integer.parseInt(PropertiesObtain.getPropertiesValue("updateDays"))))){
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

}
