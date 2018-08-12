package com.example.demo.RedisRelated;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.ResponseBody;

//error
@Controller
@RequestMapping("/strredis")

public class StringRedisTemplateDemo {
    @Autowired
    private StringRedisTemplate redisClient;


    @RequestMapping(value = "/setget/{value}.html")
    @ResponseBody
    public String env(@PathVariable("value") String para) throws Exception{
        redisClient.opsForValue().set("testenv" ,para);
        String str = redisClient.opsForValue().get("testenv");

        redisClient.convertAndSend("news",str);

        return str;

    }

}
