package com.improve1.freemp_sproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SproductResponse {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
}

