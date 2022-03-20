package com.sol.demo.member.repository;


import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Table(name = "action")
public class ActionEntity extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;

  private Long actionNum;

  @Setter
  private String actionBody;

}
