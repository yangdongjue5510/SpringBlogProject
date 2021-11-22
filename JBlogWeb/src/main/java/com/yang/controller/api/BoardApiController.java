/*
 * BoardApiController.java
 *
 * 2021-11-22
 *
 * copyright by yangdongjue5510
 * all rights reserved.
 */

package com.yang.controller.api;

import com.yang.domain.BlogVO;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardApiController {

    @RequestMapping("/api/blogList")
    public List<BlogVO> blogList(Model model){
        return null;
    }
}
