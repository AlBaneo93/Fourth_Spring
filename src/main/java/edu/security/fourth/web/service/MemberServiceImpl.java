package edu.security.fourth.web.service;

import edu.security.fourth.web.exception.UserNotFoundException;
import edu.security.fourth.web.repository.MemberRepository;
import edu.security.fourth.web.vo.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

  private MemberRepository memberRepository;

  @Override
  public Member save(Member member) {
    return memberRepository.save(member);
  }

  @Override
  public Member update(Member member) throws UserNotFoundException {
    Member tmp = memberRepository.findByEmail(member.getEmail()).orElseThrow(() -> new UserNotFoundException(member.getEmail()));

    return memberRepository.save(Member.builder()
                                       .id(tmp.getId())
                                       .email(member.getEmail())
                                       .password(member.getPassword())
                                       .name(member.getName())
                                       .build());
  }

  @Override
  public void delete(Member member) {
    memberRepository.delete(member);
  }

  @Override
  public Member read(Member member) throws UserNotFoundException {
    return memberRepository.findByEmail(member.getEmail()).orElseThrow(() -> new UserNotFoundException(member.getEmail()));
  }

  @Override
  public List<Member> readAll() {
    return memberRepository.findAll();
  }
}