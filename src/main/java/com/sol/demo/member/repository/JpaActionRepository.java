package com.sol.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaActionRepository extends JpaRepository<ActionEntity, Long> {

  List<ActionEntity> findAllByUserId(Long userId);
  ActionEntity findByUserIdAndActionNum(Long userId, Long actionNum);

}


