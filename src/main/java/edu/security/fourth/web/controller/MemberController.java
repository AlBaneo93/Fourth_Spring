package edu.security.fourth.web.controller;

import edu.security.fourth.web.exception.UserNotFoundException;
import edu.security.fourth.web.service.MemberService;
import edu.security.fourth.web.vo.Member;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MemberController {

  private MemberService service;

  @GetMapping("/member")
  public ResponseEntity<Map<String, Object>> find(@RequestBody Member member) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.read(member));
    } catch (UserNotFoundException e) {
      log.error(e.getMessage());
    }
    return ResponseEntity.ok(map);
  }

  @GetMapping("/members")
  public ResponseEntity<Map<String, Object>> findAll() {
    Map<String, Object> map = new HashMap<>();
    map.put("result", service.readAll());
    return ResponseEntity.ok(map);
  }

  @PostMapping("/member")
  public ResponseEntity<Map<String, Object>> save(Member member) {
    log.info("User Sign Up : " + member.toString());
    Map<String, Object> map = new HashMap<>();
    map.put("result", service.save(member));
    return ResponseEntity.ok(map);
  }

  @PutMapping("/member")
  public ResponseEntity<Map<String, Object>> update(Member member) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.update(member));
    } catch (UserNotFoundException e) {
      log.error(e.getMessage());
    }
    return ResponseEntity.ok(map);
  }

  @DeleteMapping("/member")
  public ResponseEntity<Map<String, Object>> delete(Member member) {
    Map<String, Object> map = new HashMap<>();
    service.delete(member);
    map.put("result", "Delete Complete");
    return ResponseEntity.ok(map);
  }
}