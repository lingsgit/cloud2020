package com.lzw.springboot.exception;

public class UserNotExistExption extends RuntimeException{
    public UserNotExistExption() {
        super("用户不存在！");
    }
}
