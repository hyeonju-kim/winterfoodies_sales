package com.winterfoodies.interceptor;


import com.winterfoodies.dto.Sales;
import com.winterfoodies.exception.SalesInternalServerException;
import com.winterfoodies.exception.SalesRequestBodyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogComponent{

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
        logMessageBuilder.append("[클라이언트 요청 에러 로그]<<<");
        logMessageBuilder.append("STATUS: " + salesRequestBodyException.getStatus()+ " ");
        logMessageBuilder.append("MESSAGE: " + salesRequestBodyException.getMessage()+ " ");
        logMessageBuilder.append(">>>");
        log.error(logMessageBuilder.toString());
    }
    public void logForSalesInternalServerException(SalesInternalServerException salesInternalServerException){
        StringBuilder logMessageBuilder = new StringBuilder();
        logMessageBuilder.append("[서버 에러 로그]<<<");
        logMessageBuilder.append("STATUS: " + salesInternalServerException.getStatus()+ " ");
        logMessageBuilder.append("MESSAGE: " + salesInternalServerException.getMessage()+ " ");
        logMessageBuilder.append(">>>");
        log.error(logMessageBuilder.toString());
    }
}
