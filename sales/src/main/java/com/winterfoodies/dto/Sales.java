package com.winterfoodies.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class Sales {
    private Long sales_id;
    private Long product_id;
    private Long customer_id;
    private Long store_id;
    private String order_at;
    private Long total_price;
}
