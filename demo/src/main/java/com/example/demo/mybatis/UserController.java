package com.example.demo.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapperXML userMapper;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers(){
        List<UserEntity> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(Long id){
        UserEntity user = userMapper.getOne(id);
        return user;
    }

//    @RequestMapping("/add")
//    public void save(UserEntity user){
//        userMapper.insert(user);
//    }

    @RequestMapping("/update")
    public void update(UserEntity user){
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userMapper.delete(id);
    }


}
