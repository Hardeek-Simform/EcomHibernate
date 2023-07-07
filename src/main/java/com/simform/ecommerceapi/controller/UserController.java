package com.simform.ecommerceapi.controller;

import com.simform.ecommerceapi.dto.DtoForUserJson;
import com.simform.ecommerceapi.dto.UserDto;
import com.simform.ecommerceapi.service.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
        UserDto userById = userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.FOUND);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody DtoForUserJson dtoForUserJson) {
        /*
        add = age,name,orderList, membership
        */
        UserDto userDto = userService.addUser(dtoForUserJson.getUser(), dtoForUserJson.getOrdersList());
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody DtoForUserJson dto) {
        /*
        update = age,name,orderList
        */
        log.info(dto.getOrdersList().toString());
        UserDto userDto = userService.updateUser(dto.getUser(), dto.getOrdersList());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("Deleted user", HttpStatus.NO_CONTENT);
    }

}
