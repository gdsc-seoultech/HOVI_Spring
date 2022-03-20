package com.sol.demo.member.repository;

import com.sol.demo.member.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//@Repository
@Component
public class MemoryMemberRepository implements MemberRepository {

	private static Map<String, ArrayList<String>> store = new HashMap<>();

	@Override
	public void save(Member member) {
		ArrayList<String> actionList = new ArrayList<>();
		actionList.add(member.getAction1());
		actionList.add(member.getAction2());
		store.put(member.getId(), actionList);
		print(member.getId());
	}

	@Override
	public void update(Member.MemberUpdateDto updateDto) {
		store.get(updateDto.getId()).set(updateDto.getNum(), updateDto.getNewAction());
		print(updateDto.getId());
	}

	@Override
	public boolean isUser(String id) {
		return store.containsKey(id);
	}

	@Override
	public Member getAction(String userId) {
		ArrayList<String> actions = store.get(userId);
		Member member = new Member();
		member.setId(userId);
		member.setAction1(actions.get(0));
		member.setAction1(actions.get(1));

		return member;
	}

//	@Override
//	public String getAction(Member member, int num) {
//		return store.get(member.getId()).get(num);
//	}

	public void print(String id){
		System.out.println("id : " + id);
		for (int i = 0; i < store.get(id).size() ; i++) {
			System.out.println(store.get(id).get(i));
		}
	}
}
