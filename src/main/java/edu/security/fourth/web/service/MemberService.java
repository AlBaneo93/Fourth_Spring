package edu.security.fourth.web.service;

import edu.security.fourth.web.exception.UserNotFoundException;
import edu.security.fourth.web.vo.Member;

import java.util.List;

public interface MemberService {
  Member save(Member member);

  Member update(Member member) throws UserNotFoundException;

  void delete(Member member);

  Member read(Member member) throws UserNotFoundException;

  List<Member> readAll();

}