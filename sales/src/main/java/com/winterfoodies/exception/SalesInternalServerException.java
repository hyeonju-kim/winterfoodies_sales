package com.winterfoodies.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class SalesInternalServerException extends RuntimeException{

    private String message;
    private HttpStatus status;
}
