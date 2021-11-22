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

import com.yang.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BoardApiController {

    @Autowired
    BoardService boardService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("boardList", boardService.getBoardList());
        return "forward:/blogListView";
    }

    @RequestMapping("/api/blogList")
    public String blogList(@RequestParam String searchCondition,
                                 @RequestParam String searchKeyword,
                                 Model model){
        model.addAttribute("boardList", boardService.searchBoardList(searchCondition, searchKeyword));
        return "forward:/blogListView";
    }
}
