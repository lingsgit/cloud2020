package com.lzw.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName cloud2020
 * @ClassName Payment
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/9 17:50
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;

    private String serial;


}
