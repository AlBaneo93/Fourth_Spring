package edu.security.fourth.web.exception;

public class UserNotFoundException extends Exception{
  public UserNotFoundException(String message) {
    super(message);
  }
}