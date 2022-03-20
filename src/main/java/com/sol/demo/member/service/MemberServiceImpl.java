package com.sol.demo.member.service;

import com.sol.demo.member.Member;
import com.sol.demo.member.repository.ActionEntity;
import com.sol.demo.member.repository.JpaActionRepository;
import com.sol.demo.member.repository.JpaMemberRepository;
import com.sol.demo.member.repository.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final JpaMemberRepository memberRepository;
  private final JpaActionRepository actionRepository;

  //legacy
//  private final MemberRepository memberRepository;

  //추후 음성 파일을 return 해주는 식으로 각 핸드폰에 넘겨줘야 할듯하다.
  @Override
  public MemberEntity set(String deviceId) {

    //todo :: device Id 이미 있는짖 확인

    var user = memberRepository.save(
      new MemberEntity(-1L, deviceId)
    );

    var defaultAction1 = new ActionEntity(-1L, user.getId(), 1L, "water please");
    var defaultAction2 = new ActionEntity(-1L, user.getId(), 2L, "hungry");

    actionRepository.save(defaultAction1);
    actionRepository.save(defaultAction2);

    return user;
  }

  @Override
  public void update(Member.MemberUpdateDto updateDto) {
    var userId = memberRepository.findByDeviceId(updateDto.getDeviceId())
      .orElseThrow(RuntimeException::new).getId();

    var actionEntity = actionRepository.findByUserIdAndActionNum(userId, updateDto.getActionNum());
    actionEntity.setActionBody(updateDto.getNewAction());

    actionRepository.save(actionEntity);

  }

  @Override
  public boolean isUser(String deviceId) {
    var entityIfExist = memberRepository.findByDeviceId(deviceId);

    if (entityIfExist.isPresent()) return true;
    return false;
  }

  @Override
  public List<ActionEntity> getAction(String deviceId) {

    Long userId = memberRepository.findByDeviceId(deviceId).orElseThrow(RuntimeException::new).getId();

    return actionRepository.findAllByUserId(userId);

  }

}
