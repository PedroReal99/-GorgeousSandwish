package com.isep.gorgeoussandwich.service;


import com.isep.gorgeoussandwich.dto.SandwichDTO;
import com.isep.gorgeoussandwich.dto.UserDTO;
import com.isep.gorgeoussandwich.model.Sandwich;
import com.isep.gorgeoussandwich.model.User;
import com.isep.gorgeoussandwich.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers(){
        List<User> userList = this.userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();
        for(User user : userList){
            dtoList.add(new UserDTO(user.getName(),user.getDescription(),user.getIsUser()));
        }
        return dtoList;
        //return ObjectMapperUtils.mapAll(sandwichList, SandwichDTO.class);
    }

    public HttpStatus addUser(UserDTO userDTO) {
        User user = new User(userDTO.getName(),userDTO.getDescription(),userDTO.getIsUser());
        userRepository.save(user);
        return HttpStatus.OK;
    }

}
