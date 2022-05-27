package com.bitc.board3.service;

import com.bitc.board3.entity.BoardEntity;
import com.bitc.board3.repository.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {

  @Autowired
  private JpaBoardRepository jpaBoardRepository;

  @Override
  public List<BoardEntity> selectBoardList() throws Exception {
    return jpaBoardRepository.findAllByOrderByBoardIdxDesc();
  }

  @Override
  public void saveBoard(BoardEntity board) throws Exception {
    jpaBoardRepository.save(board);
  }

  @Override
  public BoardEntity selectBoardDetail(int boardIdx) throws Exception {
//    Optional : 자바 8 부터 지원한 클래스로 데이터 로드 시 null을 반환하여 발생할 수 있는 NullPointerException 을 부분을 예방해주는 클래스
    Optional<BoardEntity> board = jpaBoardRepository.findById(boardIdx);
    return board.get();
  }
}
