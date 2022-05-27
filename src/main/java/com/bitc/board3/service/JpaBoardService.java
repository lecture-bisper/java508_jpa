package com.bitc.board3.service;

import com.bitc.board3.entity.BoardEntity;

import java.util.List;

public interface JpaBoardService {
  List<BoardEntity> selectBoardList() throws Exception;

  void saveBoard(BoardEntity board) throws Exception;

  BoardEntity selectBoardDetail(int boardIdx) throws Exception;


}
