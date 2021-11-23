package com.yang.controller.blog;

import com.yang.domain.BlogVO;
import com.yang.domain.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BlogController {

    @RequestMapping("/indexView")
    public String indexView(){
        return "index";
    }

    @RequestMapping("/blogCreateView")
    public String blogCreateView(HttpSession session) {
        return "blogcreate";
    }
}
