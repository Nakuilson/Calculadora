package org.clases.exception;

/**
 * The type My exception base.
 */
public class MyExceptionBase extends RuntimeException{

  public MyExceptionBase(String message){
    super(message);
  }
  public MyExceptionBase(String message, Throwable cause) {
    super(message, cause);
  }

  public MyExceptionBase(Throwable cause) {
    super(cause);
  }

  protected MyExceptionBase(String message, Throwable cause,
      boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
