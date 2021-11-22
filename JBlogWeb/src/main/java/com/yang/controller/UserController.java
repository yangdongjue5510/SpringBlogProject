/*
 * UserController.java
 *
 * 2021-11-22
 *
 * copyright by yangdongjue5510
 * all rights reserved.
 */
package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 사용자 관련 컨트롤러
 */
@Controller
public class UserController {

    @GetMapping("/loginView")
    public String loginView(){
        return "bloglogin";
    }
}
