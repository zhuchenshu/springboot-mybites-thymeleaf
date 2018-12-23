package com.mybites.demo.controller;

import com.mybites.demo.exception.StorageException;
import com.mybites.demo.exception.StorageFileNotFoundException;
import org.apache.coyote.Response;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * * Created with IntelliJ IDEA.
 * * User: zhuchenshu
 * * Date: 2018/12/23
 * * Time: 20:52
 * * Description: 统一处理异常
 */
@ControllerAdvice
public class AppWideException {
    @ExceptionHandler({StorageException.class, StorageFileNotFoundException.class})
    public String fileUpException(Model model) {
        model.addAttribute("message", "上传文件不能为空");
        return "error/fileUpException";
    }
}
