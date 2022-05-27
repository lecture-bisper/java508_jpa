package com.bitc.board3.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_jpa_file")
@NoArgsConstructor
@Data
public class BoardFileEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idx;

  @Column(nullable = false)
  private String originalFileName;

  @Column(nullable = false)
  private String storedFilePath;

  @Column(nullable = false)
  private long fileSize;

  @Column(nullable = false)
  private String createId;

  @Column(nullable = false)
  private LocalDateTime createDate = LocalDateTime.now();

  private String updateId;

  private LocalDateTime updateDate;
}
