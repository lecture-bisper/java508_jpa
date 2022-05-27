package com.bitc.board3.controller;

import com.bitc.board3.entity.BoardEntity;
import com.bitc.board3.service.JpaBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

  @Autowired
  private JpaBoardService jpaBoardService;

  @RequestMapping("/")
  public String index() throws Exception {
    return "index";
  }

  @RequestMapping(value = "/jpa/board", method = RequestMethod.GET)
  public ModelAndView openBoardList() throws Exception {
    ModelAndView mv = new ModelAndView("jpa/bsBoardList");

    List<BoardEntity> itemList = jpaBoardService.selectBoardList();
    mv.addObject("itemList", itemList);

    return mv;
  }

  @RequestMapping(value = "/jpa/board/write", method = RequestMethod.GET)
  public String boardWrite() throws Exception {
    return "jpa/bsBoardWrite";
  }

  @RequestMapping(value = "/jpa/board/write", method = RequestMethod.POST)
  public String boardInsert(BoardEntity board) throws Exception {
    jpaBoardService.saveBoard(board);
    return "redirect:/jpa/board";
  }

  @RequestMapping(value = "/jpa/board/{boardIdx}", method = RequestMethod.GET)
  public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("jpa/bsBoardDetail");

    BoardEntity board = jpaBoardService.selectBoardDetail(boardIdx);
    mv.addObject("board", board);

    return mv;
  }
}
