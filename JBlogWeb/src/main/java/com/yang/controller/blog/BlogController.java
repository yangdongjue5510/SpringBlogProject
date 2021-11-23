package com.yang.controller.blog;

import com.yang.domain.BlogVO;
import com.yang.domain.UserVO;
import com.yang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping("/indexView")
    public String indexView(HttpSession session, Model model){
        UserVO user = (UserVO) session.getAttribute("user");
        if (user != null) {
            BlogVO blog = blogService.getBlog(user);
            model.addAttribute("blog", blog.getBlogId());
        }
        return "index";
    }

    @RequestMapping("/blogCreateView")
    public String blogCreateView(HttpSession session) {
        return "blogcreate";
    }
}
