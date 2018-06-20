package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component      //加这个注解的话, 把application.properties中的配置映射为一个java对象
@ConfigurationProperties(prefix = "my")  // 配置文件中的前缀
public class MyConfig {

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    private List<String> servers = new ArrayList<String>();
    public List<String> getServers() {
        return this.servers;
    }

}
