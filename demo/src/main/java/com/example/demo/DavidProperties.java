package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

// 自定义配置
@Component
public class DavidProperties {
    @Value("${com.david.home}")
    private String home;

    @Value("${com.david.description}")
    private String description;

    @Value("${com.david.logo}")
    private String logo;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }




}
