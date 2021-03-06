package edu.security.fourth.web.service;

import edu.security.fourth.web.vo.Board;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {


  private BoardRepository repository;

  @Override
  public Board save(Board board) {
    return repository.save(board);
  }

  @Override
  public List<Board> findAll() {
    return repository.findAll();
  }

  @Override
  public Board find(Board board) {
    return repository.find();
  }

  @Override
  public Board update(Board board) {
    Board tmpBoard = repository.find(board.getId());


    return repository.save(
        Board.builder()
             .id(board.getId())
             .createDate(board.getCreateDate())
             .title(board.getTitle())
             .writer(board.getWriter())
             .modifyDate(board.getModifyDate())
             .build()
    );
  }

  @Override
  public void delete(Board board) {
    repository.delete(board);
  }
}