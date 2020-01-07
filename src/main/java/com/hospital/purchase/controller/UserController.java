package com.hospital.purchase.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.purchase.domain.User;
import com.hospital.purchase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/findAll")
    public String findAll(String username, String password, Model model) {
        User user = userService.seleAll(username, password);
        if (user != null) {
            model.addAttribute("msg", "登录成功");
            return "login";
        } else {
            model.addAttribute("msg", "账号密码出错");
            return "index";
        }


//        if ("admin".equals(username) && "123456".equals(password)) {
//            //设置账号为：admin，密码为：123456
//            //redirect是重定向
//            return "redirect:/login.html";
//        } else {
//            //账号或者密码错误，返回主页面
//            model.addAttribute("msg","账号密码出错");
//            return "index";



    }
    @RequestMapping("/all")
    public String all(){
        return "purchase_order";
    }
}
