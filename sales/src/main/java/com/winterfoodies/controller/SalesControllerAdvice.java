package com.winterfoodies.controller;


import com.winterfoodies.exception.SalesInternalServerException;
import com.winterfoodies.exception.SalesRequestBodyException;
import com.winterfoodies.interceptor.LogComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class SalesControllerAdvice {

    private final LogComponent logComponent;

    //클라이언트 - 요청한 사람의 요청이 잘 못 되었을 경우
    //4. 위에 컨트롤러에 선언되어 있는 함수에서 익셉션(SalesRequestBodyException.class) 을 던지면 이짜식이 받는다.
    //5. 파라미터로 위에서 던진 SalesRequestBodyException이 들어와진다.
    @ExceptionHandler(SalesRequestBodyException.class)
    public ResponseEntity<Map<String,String>> salesRequestBodyExceptionHandler(SalesRequestBodyException salesRequestBodyException){
        //6. 해당 익셉션으로 데이터를 만든다.
        Map<String,String> exceptionBox = Collections.singletonMap("message", salesRequestBodyException.getMessage());
        logComponent.logForSalesRequestBodyException(salesRequestBodyException);
        return ResponseEntity.status(salesRequestBodyException.getStatus()).body(exceptionBox);
    }

    //우리의 서버가 잘 못 되었을 경우
    //서비스상에서 던져진 익셉션을 잡아서, 처리해주는 익셉션 핸들러입니다.
    @ExceptionHandler(SalesInternalServerException.class)
    public ResponseEntity<Map<String,String>> salesInternalServerExceptionHandler(SalesInternalServerException salesInternalServerException){
        Map<String,String> exceptionBox = Collections.singletonMap("message", salesInternalServerException.getMessage());
        logComponent.logForSalesInternalServerException(salesInternalServerException);
        return ResponseEntity.status(salesInternalServerException.getStatus()).body(exceptionBox);
    }

}
