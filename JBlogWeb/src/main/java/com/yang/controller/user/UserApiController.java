package com.yang.controller.user;

import com.yang.domain.UserVO;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserApiController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session,
                        @RequestParam String id,
                        @RequestParam String password){
        UserVO user = userService.getUser(id, password);
        session.setAttribute("user", user);

        return "redirect:/";
    }
}
