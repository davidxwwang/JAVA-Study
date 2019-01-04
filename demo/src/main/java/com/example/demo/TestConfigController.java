package com.example.demo;

import com.example.demo.EnumANDException.EnumExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class TestConfigController {

    @Autowired
    private MyConfig myConfig;

    @Autowired
    private DavidProperties davidProperties;

   // @RequestMapping("/config")
    @GetMapping(value = "/config")
    public Object getConfig() {
        return myConfig.getServers();
    }


    // @RequestMapping("/config")
    @GetMapping(value = "/david")
    public Object getDavidConfig() {
        return davidProperties.getDescription();
    }
}

