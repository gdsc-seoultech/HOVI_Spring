package com.sol.demo.member.controller;

import com.sol.demo.member.Member;
import com.sol.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;

	@GetMapping("/user/{id}")
	public boolean isUser(@PathVariable String id){
		return memberService.isUser(id);
	}

	@GetMapping("/user_action/{id}")
	public Member getAction(@PathVariable String id ){
		return memberService.getAction(id);
	}


	@PostMapping("/set")
	public Member set(@RequestBody Member member){

		memberService.set(member);
		return member;
	}

	@PostMapping("/update")
	public Member.MemberUpdateDto modify(@RequestBody Member.MemberUpdateDto updateDto){
		memberService.update(updateDto);
		return updateDto;
	}
}
