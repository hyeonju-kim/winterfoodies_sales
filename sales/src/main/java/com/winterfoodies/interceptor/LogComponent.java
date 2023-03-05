package com.winterfoodies.interceptor;


import com.winterfoodies.dto.Sales;
import com.winterfoodies.exception.SalesInternalServerException;
import com.winterfoodies.exception.SalesRequestBodyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

// 로그 찍는 코드 모음!!
@Component
@Slf4j
public class LogComponent{

    // 로그 출력을 StringBuilder에 담아서, log.info를 찍어준다. 조금 더 깔끔한 코드로!
    public  void logForSales(Sales sales){
        StringBuilder logMessageBuilder = new StringBuilder();
        logMessageBuilder.append("[매출데이터로그]<<<");
        logMessageBuilder.append("SALES_ID: " + sales.getSales_id()+ " ");
        logMessageBuilder.append("ORDER_AT: " + sales.getOrder_at()+ " ");
        logMessageBuilder.append("STORE_ID: " + sales.getStore_id()+ " ");
        logMessageBuilder.append("TOTAL_PRC: " + sales.getTotal_price()+ " ");
        logMessageBuilder.append("CUSTOMER_ID: " + sales.getCustomer_id()+ " ");
        logMessageBuilder.append("PRODUCT_ID: " + sales.getProduct_id()+ " ");
        logMessageBuilder.append(">>>");
        log.info(logMessageBuilder.toString());
    }

    public void logForSalesRequestBodyException(SalesRequestBodyException salesRequestBodyException){
        StringBuilder logMessageBuilder = new StringBuilder();
        logMessageBuilder.append("[SALES_REQUESTBODY_EXCEPTION 로그]<<<");
        logMessageBuilder.append("EXCEPTION_MESSAGE: " + salesRequestBodyException.getMessage()+ " ");
        logMessageBuilder.append("EXCEPTION_STATUS: " + salesRequestBodyException.getStatus()+ " ");
        logMessageBuilder.append(">>>");
        log.info(logMessageBuilder.toString());
    }

    public void logForSalesInternalServerException(SalesInternalServerException salesInternalServerException){
        StringBuilder logMessageBuilder = new StringBuilder();
        logMessageBuilder.append("[SALES_INTERNAL_SERVER_EXCEPTION 로그]<<<");
        logMessageBuilder.append("EXCEPTION_MESSAGE: " + salesInternalServerException.getMessage()+ " ");
        logMessageBuilder.append("EXCEPTION_STATUS: " + salesInternalServerException.getStatus()+ " ");
        logMessageBuilder.append(">>>");
        log.info(logMessageBuilder.toString());

    }
}
