package com.yang.controller.post;

import com.yang.domain.BlogVO;
import com.yang.service.BlogService;
import com.yang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostApiController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/blogAdminPost/{blogId}")
    public String blogAdminPost(@PathVariable int blogId, Model model) {

        BlogVO blog = blogService.getBlog(blogId);
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", categoryService.getCategoryList(blog));
        return "forward:/blogAdminPostView";
    }
}
