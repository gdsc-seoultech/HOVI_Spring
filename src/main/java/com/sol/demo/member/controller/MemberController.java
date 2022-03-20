package com.sol.demo.member.controller;

import com.sol.demo.member.Member;
import com.sol.demo.member.dto.JsonResponse;
import com.sol.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.sol.demo.member.dto.JsonResponse.okWithData;
import static com.sol.demo.member.dto.JsonResponse.ok;

@RestController
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;

	@GetMapping("/user/{deviceId}")
	public ResponseEntity<?> isUser(@PathVariable String deviceId){
		return okWithData(memberService.isUser(deviceId), "member present check");
	}

	@PostMapping("/set/{deviceId}")
	public ResponseEntity<?> set(@PathVariable String deviceId){

		return okWithData(memberService.set(deviceId), "user register success");
	}

	@GetMapping("/user_action/{deviceId}")
	public ResponseEntity<?> getAction(@PathVariable String deviceId ){
		return okWithData(memberService.getAction(deviceId), "user all action");
	}

	@PostMapping("/update")
	public ResponseEntity<?> modify(@RequestBody Member.MemberUpdateDto updateDto){
		memberService.update(updateDto);
		return ok("user action update success");
	}
}
