package com.sol.demo.member.service;

import com.sol.demo.member.Member;
import com.sol.demo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

	//추후 음성 파일을 return 해주는 식으로 각 핸드폰에 넘겨줘야 할듯하다.
	@Override
	public void set(Member member) {
		memberRepository.save(member);
	}

	@Override
	public void update(Member.MemberUpdateDto updateDto) {
		memberRepository.update(updateDto);
	}

	@Override
	public boolean isUser(String id) {
		return memberRepository.isUser(id);
	}

	@Override
	public Member getAction(String userId) {
		return memberRepository.getAction(userId);
	}

}
