package com.sol.demo.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Member {
	private String id;
	private String action1;
	private String action2;

	public String getAction1() {
		return action1;
	}

	public String getAction2() {
		return action2;
	}

	public Member(String id, String action1, String action2) {
		this.id = id;
		this.action1 = action1;
		this.action2 = action2;
	}

	public String getId() {
		return id;
	}


	@Getter
	@Setter
	@NoArgsConstructor
	public static class MemberUpdateDto{
		String deviceId;
		int num;
		String newAction;
	}

	@Getter
	@Setter
	@NoArgsConstructor
	public static class IsMemberDto{
		String id;
	}
}

enum Action{
	Action1, Action2
}