package com.sol.demo.member.repository;

import com.sol.demo.member.Member;

public interface MemberRepository {

	void save(Member member);
	void update(Member.MemberUpdateDto updateDto);
//	String getAction(Member member, int num);
	boolean isUser(String id);

	Member getAction(String userId);
}
