package com.sol.demo.member.service;

import com.sol.demo.member.Member;
import com.sol.demo.member.repository.ActionEntity;
import com.sol.demo.member.repository.MemberEntity;

import java.util.List;

public interface MemberService {
	//첫 로그인 -> 추후 return 바꿔줘야함.
	MemberEntity set(String deviceId);

	//
	void update(Member.MemberUpdateDto updateDto);

	//첫 로그인시
	boolean isUser(String id);

	List<ActionEntity> getAction(String userId);
}
