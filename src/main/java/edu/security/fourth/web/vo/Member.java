package edu.security.fourth.web.vo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String email;

  private String password;

  private String name;

  private String role;
}