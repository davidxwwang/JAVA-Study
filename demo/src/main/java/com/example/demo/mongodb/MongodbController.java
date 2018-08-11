package com.example.demo.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@RestController
public class MongodbController {

    @Autowired
    private UserDaoMongodbImpl userDaoMongodbImpl;


    private Long id;

    private String userName;

    private String passWord;

    @GetMapping(value = "/saveUser2Mongodb/{id}/{userName}/{passWord}")
    public String saveUser(@PathVariable("id") Long id,
                         @PathVariable("userName") String userName,
                         @PathVariable("passWord") String passWord) {

        UserEntityMongodb userEntity = new UserEntityMongodb();
        userEntity.setId(id);
        userEntity.setUserName(userName);
        userEntity.setPassWord(passWord);
        userDaoMongodbImpl.saveUser(userEntity);
        return "david";


    }


    @GetMapping(value = "/getDateById/{id}")
    public UserEntityMongodb saveUser(@PathVariable("id") Long id) {

        UserEntityMongodb userEntity = userDaoMongodbImpl.findUserByUserId(id);
        return userEntity;

    }


}
