package com.isep.gorgeoussandwich.controller;


import com.isep.gorgeoussandwich.dto.OrderDTO;
import com.isep.gorgeoussandwich.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        List<OrderDTO> ordersList = orderService.getAllOrders();
        return ResponseEntity.ok().body(ordersList);
    }

    @PostMapping("/order")
    public ResponseEntity<HttpStatus> addOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok().body(this.orderService.addOrder(orderDTO));
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<HttpStatus> updateOrder(@PathVariable long id, @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok().body(this.orderService.updateOrder(id, orderDTO));
    }

}
