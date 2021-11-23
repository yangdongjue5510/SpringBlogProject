package com.yang.controller.blog;

import com.yang.domain.BlogVO;
import com.yang.domain.UserVO;
import com.yang.service.BlogService;
import com.yang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BlogApiController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) {
        if (model.getAttribute("blogList") == null){
            List<BlogVO> list = blogService.getBlogList();
            model.addAttribute("blogList", list);
        }
        return "forward:/indexView";
    }

    @RequestMapping("/searchBlog")
    public String searchBlog(@RequestParam String searchCondition,
                             @RequestParam String searchKeyword,
                             Model model) {
        List<BlogVO> blogList = blogService.searchBlog(searchCondition, searchKeyword);
        model.addAttribute("blogList", blogList);
        return "forward:/indexView";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "forward:/";
    }

    @PostMapping("/blogCreate")
    public String blogCreate(@RequestParam String blogName,
                             HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        BlogVO blog = blogService.getBlog(user);
        if (blog == null) {
            blogService.insertBlog(blogName, user);
        }
        return "redirect:/";
    }

    @RequestMapping("/deleteBlog/{blogId}")
    public String blogDelete(@PathVariable int blogId) {
        blogService.deleteBlog(blogId);
        return "redirect:/";
    }

    @RequestMapping("/blogMain/{blogId}")
    public String blogMain(@PathVariable int blogId, Model model) {
        UserVO user = new UserVO();
        user.setUserId(blogId);
        BlogVO blog = blogService.getBlog(user);
        model.addAttribute("blog", blog);
        return "forward:/blogMainView";
    }
}
