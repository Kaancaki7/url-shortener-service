package com.kaan.urlshortener.errorhandler.handler;

import com.kaan.urlshortener.errorhandler.exception.ApplicationException;
import com.kaan.urlshortener.errorhandler.ErrorCode;
import com.kaan.urlshortener.errorhandler.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

        ErrorDto errorDto;
        HttpStatus httpStatus;
        if (ex instanceof ApplicationException) {
            ApplicationException appException = (ApplicationException) ex;
            errorDto = new ErrorDto(appException.getErrorCode(), appException.getErrorMessage());
            httpStatus = appException.getHttpStatus();
        } else {
            errorDto = new ErrorDto(ErrorCode.ERROR_INTERNAL_SERVER.toString(), "Internal server error");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(errorDto, httpStatus);
    }
}
