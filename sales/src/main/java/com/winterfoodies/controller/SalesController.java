package com.winterfoodies.controller;


import com.winterfoodies.dto.Sales;
import com.winterfoodies.mapper.SalesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SalesController {

    private final SalesMapper salesMapper;

    // 매출 데이터 insert
    @PostMapping("/insert")
    public Integer insertSales(@RequestBody Sales sales){
        System.out.println("매출 데이터 인서트 요청이 들어왔습니다.");
        System.out.println(sales);
        try {
            salesMapper.insertSales(sales);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    //전체 매출 데이터 조회
    @GetMapping("/getall/{storeId}")
    public List<Sales> getAllSalesByStoreId(@PathVariable Long storeId){
        System.out.println("매출 데이터 전체 요청이 들어왔습니다.");
        System.out.println(storeId);
        try {
            salesMapper.getAllSalesByStoreId(storeId);
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    //이달의 매출
    @GetMapping("/monthsalesstoreid/{storeId}")
    public Long getAllSalesByMonth(@PathVariable Long storeId){
        System.out.println("이달의 매출 계산 요청이 들어왔습니다.");
        System.out.println(storeId);
        try {
            salesMapper.getAllSalesByMonth(storeId);
        } catch (Exception e) {
            return 0L;
        }
        return 1L;
    }

    // 올해의 매출
    @GetMapping("/yearsalesstoreid/{storeId}")
    public Long getAllSalesByYear(@PathVariable Long storeId){
        System.out.println("올해의 매출 계산 요청이 들어왔습니다.");
        System.out.println(storeId);
        try {
            salesMapper.getAllSalesByYear(storeId);
        } catch (Exception e) {
            return 0L;
        }
        return 1L;
    }

    // 어제의 매출
    @GetMapping("/yesterdaysalesstoreid/{storeId}")
    public Long getYesterDaySales(@PathVariable Long storeId){
        System.out.println("어제의 매출 계산 요청이 들어왔습니다.");
        System.out.println(storeId);
        try {
            salesMapper.getYesterDaySales(storeId);
        } catch (Exception e) {
            return 0L;
        }
        return 1L;
    }

    // 총 누적 주문건수
    @GetMapping("/totalsalesstoreid/{storeId}")
    public Long getTotalOrdersCount(@PathVariable Long storeId){
        System.out.println("총 누적 주문건수 요청이 들어왔습니다.");
        System.out.println(storeId);
        try {
            salesMapper.getTotalOrdersCount(storeId);
        } catch (Exception e) {
            return 0L;
        }
        return 1L;
    }

}
