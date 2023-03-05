package com.winterfoodies.exception;

import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesRequestBodyException extends RuntimeException{
    private String message;
    private HttpStatus status;
}
