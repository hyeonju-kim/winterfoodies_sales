package com.winterfoodies.service;

import com.winterfoodies.dto.Sales;
import com.winterfoodies.exception.SalesInternalServerException;
import com.winterfoodies.mapper.SalesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService{

    private final SalesMapper salesMapper;

    @Override
    public Optional<List<Sales>> getAllSalesByStoreId(Long storeId) {
        //1. DB에서 전체 매출 데이터를 조회해 온다.
        List<Sales> totalSales = null;
        try {
            totalSales = salesMapper.getAllSalesByStoreId(storeId);
        }catch (Exception e){
            return Optional.empty();
        }
        return Optional.of(totalSales);
    }

    @Override
    public void insertSales(Sales sales) {
        salesMapper.insertSales(sales); //DB에 데이터를 넣어! 근데 이때 , DB가 꺼져있는거야!
    }

    @Override
    public Long getMonthSalesMyStoreId(Long storeId) throws SalesInternalServerException {
        try {
            Long salesTotalForMonth = salesMapper.getMonthSalesMyStoreId(storeId);
            int[] a = new int[]{};
            salesTotalForMonth += a[0];
            return salesTotalForMonth;
        }catch (Exception e){
            throw new SalesInternalServerException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
