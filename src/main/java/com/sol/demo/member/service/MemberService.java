package com.sol.demo.member.service;

import com.sol.demo.member.Member;
import com.sol.demo.member.repository.MemberEntity;

public interface MemberService {
	//첫 로그인 -> 추후 return 바꿔줘야함.
	MemberEntity set(Member member);

	//
	void update(Member.MemberUpdateDto updateDto);

	//첫 로그인시
	boolean isUser(String id);

	Member getAction(String userId);
}
