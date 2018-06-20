package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {


    @Autowired
    private GirlRepositoty girlRepositoty;


    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepositoty.findAll();
    }

    @PostMapping(value = "/girls")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){

        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepositoty.save(girl);

    }

    // 根据id查找女生
//    @GetMapping(value = "/girls/{id}")
//    public List<Girl> girlFindOne(@PathVariable("id") Integer id){
//        return girlRepositoty.findOne(id);
//    }

    // 根据年龄查找女生
    @GetMapping(value = "/girls/girl/{age}")
    public List<Girl> girlsFindByAge(@PathVariable("age") Integer age){
        return girlRepositoty.findByAge(age);
    }

}
