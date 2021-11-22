package com.yang.controller.blog;

import com.yang.domain.BlogVO;
import com.yang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogApiController {
    @Autowired
    BlogService blogService;

    @RequestMapping("/")
    public String index(Model model){
        List<BlogVO> list = blogService.getBlogList();
        model.addAttribute("blogList", list);
        return "forward:/indexView";
    }
}
