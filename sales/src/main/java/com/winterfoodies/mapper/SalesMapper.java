package com.winterfoodies.mapper;

import com.winterfoodies.dto.Sales;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SalesMapper {
    List<Sales> getAllSalesByStoreId(Long storeId);

    void insertSales(Sales sales);

    Long getAllSalesByMonth(Long storeId);

    Long getAllSalesByYear(Long storeId);

    Long getYesterDaySales(Long storeId);

    Long getTotalOrdersCount(Long storeId);
}
