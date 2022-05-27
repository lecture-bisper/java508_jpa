package com.bitc.board3.repository;

import com.bitc.board3.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


// Spring Data의 JPA를 사용하면 리포지토리 인터페이스를 기준으로 동적으로 실행할 수 있는 메서드를 자동 생성함
// mybatis 사용 시의 mapper 파일과 동일한 기능을 함

// CrudRepository를 상속받으면 Create, Read, Update, Delete 기능을 자동으로 생성함
// 실제 데이터 테이블과 연동된 클래스인 BoardEntity를 사용하고, BoardEntity의 기본키인 boardIdx의 자료형인 Integer를 사용
public interface JpaBoardRepository extends CrudRepository<BoardEntity, Integer> {
  List<BoardEntity> findAllByOrderByBoardIdxDesc();
}
