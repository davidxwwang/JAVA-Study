package com.example.demo.RedisRelated;

import com.mysql.jdbc.log.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SpringSessionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/springSession")
    public @ResponseBody String putSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        logger.info(session.getClass().toString());
        logger.info(session.getId());
        session.setAttribute("user","david");
        return "hi," + "david";
    }
}
