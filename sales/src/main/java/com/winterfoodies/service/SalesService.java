package com.winterfoodies.service;

import com.winterfoodies.dto.Sales;
import com.winterfoodies.exception.SalesInternalServerException;

import java.util.List;
import java.util.Optional;

/**
 * 인터페이스에, 어떠한 서비스를 명시할 것인지 미리 작성해줘.
 * 강제성 -> 상속받는 클래스에게.
 */
public interface SalesService {
    //가게의 총 판매 데이터를 구해주는 서비스함수를 만든다.
    Optional<List<Sales>> getAllSalesByStoreId(Long storeId);

    //매출 데이터를 인서트 해주는 서비스 함수
    void insertSales(Sales sales);

    //한달 매출 전체 액수를 구해주는 서비스 함수
    Long getMonthSalesMyStoreId(Long storeId) throws SalesInternalServerException;
}
