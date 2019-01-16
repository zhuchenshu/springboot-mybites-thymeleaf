package com.zzuser.securitydemo.repository;

import com.zzuser.securitydemo.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhuchenshu on 2019/1/15
 */
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Teacher findByIdIs(long l);
    Teacher findByName(String name);
}
