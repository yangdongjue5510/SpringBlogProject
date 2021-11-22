package com.yang.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    @RequestMapping("/indexView")
    public String indexView(){
        return "index";
    }
}
