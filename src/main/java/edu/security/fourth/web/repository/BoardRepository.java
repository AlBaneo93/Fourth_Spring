package edu.security.fourth.web.repository;


import edu.security.fourth.web.vo.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;


@EnableJpaRepositories
public interface BoardRepository extends JpaRepository<Board, Long> {
  Optional<Board> findBoardById(Long id);
}