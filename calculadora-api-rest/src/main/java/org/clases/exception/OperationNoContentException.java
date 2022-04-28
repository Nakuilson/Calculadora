package org.clases.exception;


public class OperationNoContentException extends MyExceptionBase {


  public OperationNoContentException(String message) {
    super(message);
  }


  public OperationNoContentException(String message, Throwable cause) {
    super(message, cause);
  }


  public OperationNoContentException(Throwable cause) {
    super(cause);
  }


  protected OperationNoContentException(String message, Throwable cause, boolean enableSuppression,
                                        boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
