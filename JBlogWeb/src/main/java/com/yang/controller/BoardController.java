/*
 * BoardController.java
 *
 * 2021-11-22
 *
 * copyright by yangdongjue5510
 * all rights reserved.
 */
package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 보드 관련 컨트롤러
 */
@Controller
public class BoardController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/blogCreateView")
    public String blogCreateView(){
        return "blogcreate";
    }

    @GetMapping("/blogMainView")
    public String blogMainView(){
        return "blogmain";
    }

}
