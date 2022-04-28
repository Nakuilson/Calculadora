package org.clases.controller.error;


import org.clases.exception.OperationNoContentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * The type Clase error handler.
 */
@ControllerAdvice
public class ClaseErrorHandler {

  @ExceptionHandler(value = {OperationNoContentException.class})
  public ResponseEntity<ErrorMessage> handleOperationException(RuntimeException ex,
      WebRequest e) {
    ErrorMessage message = new ErrorMessage();
    message.setError(ex.getMessage());
    message.setDescription("No se ha podido realizar la operación");
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
  }


}
