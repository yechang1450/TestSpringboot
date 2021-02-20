package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/")
    public String index() {
//        System.out.println("加载 Login 页面");
        return "index";
    }

    @RequestMapping("/{ip}")
    public String ip(@PathVariable String ip) {
//        System.out.println("加载 " + ip + " 页面");
        return "" + ip + "";
    }
}
