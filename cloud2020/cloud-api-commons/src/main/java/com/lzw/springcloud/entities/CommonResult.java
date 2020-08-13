package com.lzw.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName cloud2020
 * @ClassName CommonResult
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/9 17:52
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T date;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
