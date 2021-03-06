package edu.security.fourth.web.service;


import edu.security.fourth.web.vo.Board;

import java.util.List;

public interface BoardService {
  Board save(Board board);

  List<Board> findAll();

  Board find(Board board);

  Board update(Board board);

  void delete(Board board);
}