package com.mgoportfolio2022api.mgoportfolio2022api.error.exeption;

public class AuthException extends RuntimeException {
  public  AuthException(){super();}

  public  AuthException(String message){
    super(message);
  }

  public  AuthException(String message, Throwable cause){
    super(message,cause);
  }
}
