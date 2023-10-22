package in.attiead.notice.common.handler;

import in.attiead.notice.adapter.in.dto.ResponseDto;
import in.attiead.notice.common.Meta;
import in.attiead.notice.common.MetaCode;
import in.attiead.notice.common.exception.BaseHttpException;
import in.attiead.notice.common.exception.ConflictException;
import in.attiead.notice.common.exception.InternalServerException;
import in.attiead.notice.common.exception.InvalidException;
import in.attiead.notice.common.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(
      {
          InvalidException.class,
          ConflictException.class,
          NotFoundException.class,
          InternalServerException.class
      }
  )
  public ResponseEntity<ResponseDto<Object>> handleBaseHttpException(BaseHttpException error) {

    HttpStatus status;

    if (error instanceof InvalidException) {
      status = HttpStatus.BAD_REQUEST;
    } else if (error instanceof ConflictException) {
      status = HttpStatus.CONFLICT;
    } else if (error instanceof NotFoundException) {
      status = HttpStatus.NOT_FOUND;
    } else if (error instanceof InternalServerException) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    } else {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    return createErrorResponse(status, error.getMessage(), error.getData());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseDto<Object>> handleUnhandledException(Exception error) {
    log.error(error.getMessage(), error);

    return createErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        error.getMessage(),
        null
    );
  }

  private ResponseEntity<ResponseDto<Object>> createErrorResponse(
      HttpStatus statusCode,
      String message,
      Object data
  ) {
    MetaCode dtoMetaCode = MetaCode.valueFrom(statusCode);
    ResponseDto<Object> response = new ResponseDto<>(
        new Meta(
            dtoMetaCode,
            dtoMetaCode.name(),
            message
        ),
        data
    );
    return new ResponseEntity<>(response, statusCode);
  }
}
