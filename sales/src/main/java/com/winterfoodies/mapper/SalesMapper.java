package com.winterfoodies.mapper;

import com.winterfoodies.dto.Sales;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SalesMapper {

    //가게의 총 판매 데이터를 구해주는 함수입니다.
    List<Sales> getAllSalesByStoreId(Long storeId);

    //가게의 이달의 매출을 구해주는 함수입니다.
    Long getMonthSalesMyStoreId(Long storeId);

    //가게의 매출을 입력해주는 함수입니다.
    void insertSales(Sales sales);
}
