package com.yang.controller.blog;

import com.yang.domain.BlogVO;
import com.yang.domain.CategoryVO;
import com.yang.domain.UserVO;
import com.yang.service.BlogService;
import com.yang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        List<BlogVO> list = blogService.getBlogList();
        model.addAttribute("blogList", list);
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
        blogService.insertBlog(blogName, user);

        int userId = user.getUserId();
        CategoryVO category = new CategoryVO();
        category.setCategoryName("분류없음");
        category.setBlogId(userId);
        category.setDisplayType("제목+내용");
        categoryService.insertCategory(category);

        return "redirect:/blogMain/{userId}";
    }
}
