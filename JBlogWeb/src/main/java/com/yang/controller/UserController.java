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

@Controller
public class UserController {

    @GetMapping("/loginView")
    public String loginView(){
        return "bloglogin";
    }
}
