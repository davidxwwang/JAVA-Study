package com.example.demo.GirlsJpaThymeleaf;

import com.example.demo.GirlOperation.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GirlController2 {

    @Autowired
    private GirlService girlService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Girl> users=girlService.getGirlList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Integer id) {
        Girl user=girlService.findGirlById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/toAdd")
    public String toAdd(ModelMap map) {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(Girl user) {
        girlService.save(user);
        return "redirect:/list";
    }

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlService.getGirlList();
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
        return girlService.save(girl);

    }

//    @GetMapping(value = "/edit/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        girlService.delete(id);
//        return "redirect:/list";
//    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id){
        girlService.deleteGirlById(id);
        return "redirect:/list";
    }

}

// "user/userEdit"; 代表会直接去resources目录下找相关的文件。
//         "redirect:/list"; 代表转发到对应的controller，这个示例就相当于删除内容之后自动调整到list请求，然后再输出到页面。
//
