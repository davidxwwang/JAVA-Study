package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class TestConfigController {

    @Autowired
    private MyConfig myConfig;

   // @RequestMapping("/config")
    @GetMapping(value = "/config")
    public Object getConfig() {
        return myConfig.getServers();
    }
}

