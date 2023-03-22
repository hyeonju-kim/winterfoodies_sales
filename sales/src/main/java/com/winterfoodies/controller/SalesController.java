package com.winterfoodies.controller;


import com.winterfoodies.dto.Sales;
import com.winterfoodies.exception.SalesInternalServerException;
import com.winterfoodies.exception.SalesRequestBodyException;
import com.winterfoodies.interceptor.LogComponent;
import com.winterfoodies.mapper.SalesMapper;
import com.winterfoodies.service.SalesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

//1. Server Exception 처리
//2. ControllerAdvice - exception을 모두 모았다.
//3. log를 남겨보자 - interceptor

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    //1. 요청이 들어옵니다.
    @PostMapping("")
    public Integer insertSales(@RequestBody @Valid Sales sales, BindingResult bindingResult){
        //2. @Valid라고 선언한 변수에 @NotNull을 만족하지 못하는 데이터가 있는경우 ex) store_id : "";
        //아래 이프절에 걸리게 된다.
        if(bindingResult.hasErrors()){
            //3. 익센션을 던진다.
            throw new SalesRequestBodyException("세일즈 누락 데이터 확인 요망",
                    HttpStatus.BAD_REQUEST);
        }
        //1.로그를 남긴다. (AOP 개념) - 2023.03.05
       // logComponent.logForSales(sales);
        //1. 인서트를 한다.
        try {
            salesService.insertSales(sales); //DB에 데이터를 넣어! 근데 이때 , DB가 꺼져있는거야!
        }catch (Exception e){

        }
        return 1;
    }

    @GetMapping("/month/{storeId}")
    public Long getMonthSalesByStoreId(@PathVariable Long storeId){
        Long salesTotalForMonth = salesService.getMonthSalesMyStoreId(storeId);
        return salesTotalForMonth;
    }

    @GetMapping("/total/{storeId}")
    public List<Sales> getAllSalesByStoreId(@PathVariable Long storeId){
        Optional<List<Sales>> optionalSalesList = salesService.getAllSalesByStoreId(storeId);
        if(optionalSalesList.isPresent()){
            return optionalSalesList.get();
        }else{
            return Collections.emptyList();
        }
    }

    //TO-BE 더 깔끔한 설계를 위해, 익셉션핸들러들을 모두 SalesControllerAdvice에 모아둔다.
    /**
    //클라이언트 - 요청한 사람의 요청이 잘 못 되었을 경우
    //4. 위에 컨트롤러에 선언되어 있는 함수에서 익셉션(SalesRequestBodyException.class) 을 던지면 이짜식이 받는다.
    //5. 파라미터로 위에서 던진 SalesRequestBodyException이 들어와진다.
    @ExceptionHandler(SalesRequestBodyException.class)
    public ResponseEntity<Map<String,String>> salesRequestBodyExceptionHandler(SalesRequestBodyException salesRequestBodyException){
        //6. 해당 익셉션으로 데이터를 만든다.
        Map<String,String> exceptionBox = Collections.singletonMap("message", salesRequestBodyException.getMessage());
        return ResponseEntity.status(salesRequestBodyException.getStatus()).body(exceptionBox);
        //7. 호출한 대상에게, 익셉션 박스를 던져준다.
    }

    //우리의 서버가 잘 못 되었을 경우
    //서비스상에서 던져진 익셉션을 잡아서, 처리해주는 익셉션 핸들러입니다.
    @ExceptionHandler(SalesInternalServerException.class)
    public ResponseEntity<Map<String,String>> salesInternalServerExceptionHandler(SalesInternalServerException salesInternalServerException){
        Map<String,String> exceptionBox = Collections.singletonMap("message", salesInternalServerException.getMessage());
        return ResponseEntity.status(salesInternalServerException.getStatus()).body(exceptionBox);
    }
    **/
}
