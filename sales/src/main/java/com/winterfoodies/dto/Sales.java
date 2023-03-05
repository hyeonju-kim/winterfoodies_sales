package com.winterfoodies.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@ToString
@Setter
public class Sales {
    @NotNull
    private Long sales_id;
    @NotNull
    private Long product_id;
    @NotNull
    private Long customer_id;
    @NotNull
    private Long store_id;
    @NotNull
    private String order_at;
    @NotNull
    private Long total_price;
}
