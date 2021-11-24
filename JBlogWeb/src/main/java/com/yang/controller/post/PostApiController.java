package com.yang.controller.post;

import com.yang.domain.BlogVO;
import com.yang.domain.CategoryVO;
import com.yang.domain.PostVO;
import com.yang.service.BlogService;
import com.yang.service.CategoryService;
import com.yang.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostApiController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    PostService postService;

    @GetMapping("/blogAdminPost/{blogId}")
    public String blogAdminPost(@PathVariable int blogId, Model model) {

        BlogVO blog = blogService.getBlog(blogId);
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", categoryService.getCategoryList(blog));
        return "forward:/blogAdminPostView";
    }

    @PostMapping("/insertPost/{blogId}")
    public String insertPost(@ModelAttribute PostVO post,
                             @PathVariable int blogId,
                             Model model) {
        postService.insertPost(post);
        blogService.forwardBlogView(blogId, model);
        return "forward:/blogMainView";
    }

}
