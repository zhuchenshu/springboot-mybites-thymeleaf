package com.zzuser.securitydemo.service;

import com.zzuser.securitydemo.domain.Teacher;

/**
 * 类 名:
 * 描 述:
 * 作 者: zhuchenshu
 * 创 建: 2019/1/17 11:04
 * 邮 箱: zhuchenshu@foxmail.com
 */
public interface TeacherService {
    Teacher findById(Long id);
}
