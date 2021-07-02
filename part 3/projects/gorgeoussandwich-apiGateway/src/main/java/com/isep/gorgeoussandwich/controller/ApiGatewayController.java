package com.isep.gorgeoussandwich.controller;


import com.isep.gorgeoussandwich.service.ApiGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiGatewayController {

    @Autowired
    private ApiGatewayService apiGatewayService;

    @GetMapping("/gateway/sandwich")
    public ResponseEntity<String> getAllSandwiches(){
        return apiGatewayService.getAllSandwiches();
    }

    @GetMapping("/gateway/sandwich/details/{id}")
    public ResponseEntity<String> getSandwichDetails(@PathVariable long id){
        return apiGatewayService.getSandwichDetails(id);
    }

    @GetMapping("/gateway/comments/{id}")
    public ResponseEntity<String> getSandwichComments(@PathVariable long id){
        return apiGatewayService.getSandwichComments(id);
    }

    @GetMapping("/gateway/reviews/{id}")
    public ResponseEntity<String> getSandwichReviews(@PathVariable long id){
        return apiGatewayService.getSandwichReviews(id);
    }

    @GetMapping("/gateway/sandwich/{id}")
    public ResponseEntity<String> getSandwichInfo(@PathVariable long id){
        return apiGatewayService.getSandwichInfo(id);
    }




    /*@PostMapping("/user")
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserDTO userDto){
        System.out.println("Nome:"+userDto.getName());
        return ResponseEntity.ok().body(this.apiGatewayService.addUser(userDto));
       //return null;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id){
        UserDTO sandwichDTO = apiGatewayService.getUserById(id);
        return ResponseEntity.ok().body(sandwichDTO);
    }*/

}
