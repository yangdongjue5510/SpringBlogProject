package com.yang.controller.user;

import com.yang.domain.BlogVO;
import com.yang.domain.UserVO;
import com.yang.service.BlogService;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserApiController {

    @Autowired
    UserService userService;

    @Autowired
    BlogService blogService;

    @PostMapping("/login")
    public String login(HttpSession session,
                        @RequestParam String id,
                        @RequestParam String password){
        UserVO user = userService.getUser(id, password);
        session.setAttribute("user", user);

        return "redirect:/";
    }
}
