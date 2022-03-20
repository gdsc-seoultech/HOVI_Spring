package com.sol.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<MemberEntity, Long> {

  Optional<MemberEntity> findByDeviceId(String deviceId);

}


