package edu.security.fourth.web.repository;

import edu.security.fourth.web.vo.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface MemberRepository extends JpaRepository<Member, Long> {

  Optional<Member> findByEmail(String email);
}