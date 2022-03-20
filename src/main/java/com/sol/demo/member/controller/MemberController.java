package com.sol.demo.member.controller;

import com.sol.demo.member.Member;
import com.sol.demo.member.dto.JsonResponse;
import com.sol.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.sol.demo.member.dto.JsonResponse.okWithData;
import static org.springframework.http.ResponseEntity.ok;

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
	public ResponseEntity<?> set(@RequestBody Member member){

		return okWithData(memberService.set(member), "유저 등록 성공");
	}

	@PostMapping("/update")
	public Member.MemberUpdateDto modify(@RequestBody Member.MemberUpdateDto updateDto){
		memberService.update(updateDto);
		return updateDto;
	}
}
