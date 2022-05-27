package com.bitc.board3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

// 엔티티 : jpa프로바이더를 이용하여 실제 데이터 테이블을 생성, 수정
// mybatis의 dto 클래스와 같은 기능을 하는 클래스

// @Entity : 해당 클래스가 JPA 엔티티임을 나타내는 어노테이션
// @Table : DB의 테이블와 연동
@Entity
@Table(name = "t_jpa_board")
@NoArgsConstructor
@Data
public class BoardEntity {
//  @Id : 해당 멤버변수가 해당 테이블의 기본키임을 나타내는 어노테이션
//  @GeneratedValue : 기본키의 값 생성 방식을 지정
//  GenerationType.AUTO을 사용하면 DB에서 설정된 방식을 사용함
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int boardIdx;

//  @Column : 해당 멤버변수가 테이블의 컬럼임을 나타내는 어노테이션
//  nullable = false : null 값을 허용할지 여부, true : null 사용, false : not null
//  @Column(name = "컬럼이름") : 실제 데이터 테이블에서 사용할 컬럼명과 멤버변수의 이름을 연동
  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String contents;

//  멤버 변수를 선언 시 초기화하면 데이터베이스의 컬럼에 기본값으로 설정함
  @Column(nullable = false)
  private int hitCnt = 0;

  @Column(nullable = false)
  private String createId;

//  기본값으로 현재 시간을 사용
//  시간을 사용하기 위한 포맷 설정
  @Column(nullable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
  private LocalDateTime createDate = LocalDateTime.now();

  private String updateId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
  private LocalDateTime updateDate;

//  @OneToMany : 데이터 베이스 테이블에서 1:N관계 나타내는 어노테이션
//  @JoinColumn : 테이블끼리 관계가 설정되어 있을 경우 해당 테이블의 기본키를 설정
  @OneToMany
  @JoinColumn(name = "board_idx")
  private Collection<BoardFileEntity> fileList;
}
