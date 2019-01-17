package com.zzuser.securitydemo.service;

import com.zzuser.securitydemo.domain.Teacher;
import com.zzuser.securitydemo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类 名:
 * 描 述:
 * 作 者: zhuchenshu
 * 创 建: 2019/1/17 11:05
 * 邮 箱: zhuchenshu@foxmail.com
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findByIdIs(id);
    }
}
