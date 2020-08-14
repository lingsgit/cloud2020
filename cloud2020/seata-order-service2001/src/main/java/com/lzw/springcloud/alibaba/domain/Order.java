package com.lzw.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ProjectName cloud2020
 * @ClassName Order
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/15 0:19
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long uesrId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;
}
