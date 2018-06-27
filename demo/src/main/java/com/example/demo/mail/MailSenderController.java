package com.example.demo.mail;


import com.example.demo.mybatis.UserEntity;
import com.example.demo.mybatis.UserMapper;
import com.example.demo.rabbitmq.MessagesReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.ITemplateContext;

import javax.naming.Context;
import java.util.List;

@RestController
public class MailSenderController {

    @Autowired
    private MailServiceImpl mailServiceImpl;

    @Autowired
    private TemplateEngine templateEngine;

    @RequestMapping("/SimpleMail")
    public void sendMail(){
       mailServiceImpl.sendSimpleMail("xwwang_0102@qq.com","ff","david");
    }

    @RequestMapping("/HtmlMail")
        public void sendHtmlMail(){
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailServiceImpl.sendHtmlMail("xwwang_0102@qq.com","html",content);

    }

    @RequestMapping("/AttachmentsMail")
        public void sendAttachmentsMail(){
        String filePath="/Users/david/Desktop/JAVA学习/spring-boot-examples-master/spring-boot-mail/src/main/java/com/neo/service/impl/MailServiceImpl.java";
        mailServiceImpl.sendAttachmentsMail("xwwang_0102@qq.com","attach","ss",filePath);
    }

    @RequestMapping("/InlineResourceMail")
        public void sendInlineResourceMail(){
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "/Users/david/Desktop/私人文件夹/快乐的照片/照片/281506562697_.pic.jpg";

        mailServiceImpl.sendInlineResourceMail("xwwang_0102@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


    @RequestMapping("/TemplateMail")
    public void sendTemplateMail(){
        //创建邮件正文
        final IContext context = new org.thymeleaf.context.Context();
        ((org.thymeleaf.context.Context) context).setVariable("id","david");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailServiceImpl.sendHtmlMail("xwwang_0102@qq.com","主题：这是模板邮件",emailContent);
    }

}
