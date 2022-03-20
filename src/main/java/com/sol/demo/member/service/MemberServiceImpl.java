package com.sol.demo.member.service;

import com.sol.demo.member.Member;
import com.sol.demo.member.repository.JpaMemberRepository;
import com.sol.demo.member.repository.MemberEntity;
import com.sol.demo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
  private final MemberRepository memberRepository;
  private final JpaMemberRepository jpaMemberRepository;

  //추후 음성 파일을 return 해주는 식으로 각 핸드폰에 넘겨줘야 할듯하다.
  @Override
  public MemberEntity set(Member member) {
    return jpaMemberRepository.save(
      new MemberEntity(-1L, member.getId(), member.getAction1(), member.getAction2())
    );
  }

  @Override
  public void update(Member.MemberUpdateDto updateDto) {
    var entity = jpaMemberRepository.findByDeviceId(updateDto.getDeviceId())
      .orElseThrow(RuntimeException::new);

    if(updateDto.getNum() == 1) {
      entity.setAction1(updateDto.getNewAction());
    } else if(updateDto.getNum() == 2)
      entity.setAction2(updateDto.getNewAction());

    jpaMemberRepository.save(entity);
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
