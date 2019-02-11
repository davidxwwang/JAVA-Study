package com.example.demo.springbootdemo.CommonProjectUseCompent.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.OutputStream;
import java.nio.ByteBuffer;


@RestController
@RequestMapping(value = "/valid")

// 告诉MethodValidationPostProcessor此Bean需要开启方法级别验证支持
@Validated  // 打开校验开关 只有加了这个，下面的testString入参检测才起作用
public class ValidationController {

    @Resource
    Item2 item2;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

//    @RequestMapping("/test")
//    public String doTest(@Validated Item item, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return bindingResult.getAllErrors().toString();
//        }
//        return "通过验证";
//    }

    @RequestMapping("/testString")
    public Object testString( @NotNull(message = "name不能为null") String message) {
//        if (bindingResult.hasErrors()){
//            return bindingResult.getAllErrors();
//        }

       // return item2.setName(null, "32");

//        ValidClass validClass = new ValidClass();
//        return validClass.testName(null);

        return test2(-1L);

//        Item item = new Item();
//        Thread currentThread = Thread.currentThread();
//        logger.info("当前线程信息：" + Thread.currentThread().toString());
//        return test(item);

    }

    private Item test(@Validated Item item){
        item.setId(4);
        return item;
    }

    private Long test2(@Min(value = 0, message = "最小为0") Long id){
        return  id * 2;
    }

}
