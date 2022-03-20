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

  private final JpaMemberRepository jpaMemberRepository;

  //legacy
  private final MemberRepository memberRepository;

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
  public boolean isUser(String deviceId) {
    var entityIfExist = jpaMemberRepository.findByDeviceId(deviceId);

    if(entityIfExist.isPresent()) return true;
    return false;
  }

  @Override
  public MemberEntity getAction(String deviceId) {

    return jpaMemberRepository.findByDeviceId(deviceId).orElseThrow(RuntimeException::new);
  }

}
