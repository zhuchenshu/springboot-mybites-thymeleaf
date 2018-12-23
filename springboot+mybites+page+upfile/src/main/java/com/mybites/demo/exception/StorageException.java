package com.mybites.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Description: 将异常映射为状态码
 * @param
 * @return 
 * @author zhuchenshu
 * @date 2018/12/23 20:51 
 */ 
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "file not found")
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
