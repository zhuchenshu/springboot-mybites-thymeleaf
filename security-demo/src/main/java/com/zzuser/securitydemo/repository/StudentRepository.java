package com.zzuser.securitydemo.repository;

import com.zzuser.securitydemo.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhuchenshu on 2019/1/16
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
}
