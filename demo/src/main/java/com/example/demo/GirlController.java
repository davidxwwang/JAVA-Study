package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.Servlet;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;

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
                        @RequestParam("age") Integer age,
                        @RequestParam("email") String email
                        ){

        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setEmail(email);

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


    // 根据年龄查找女生,分页
    // Pageable是接口，PageRequest是接口实现
    @GetMapping(value = "/girls/{age}")
    public void girlsFindByAgePageable(@PathVariable("age") Integer age) {

        int page = 0, size = 5;
        Sort sort = new Sort(Direction.DESC, "age");
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Girl> girlsPage = girlRepositoty.findByAge(age, pageable);

        System.out.println(girlsPage.getTotalElements());
//按照当前分页大小，总页数
System.out.println(girlsPage.getTotalPages());
//按照当前页数、分页大小，查出的分页结果集合
//  for (Customer customer: page.getContent()) {
//    System.out.println(customer.toString());
// 
//  System.out.println("-------------------------------------------");
//
    }

}
