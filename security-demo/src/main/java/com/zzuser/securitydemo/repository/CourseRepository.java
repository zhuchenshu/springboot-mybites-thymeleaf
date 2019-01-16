package com.zzuser.securitydemo.repository;

import com.zzuser.securitydemo.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhuchenshu on 2019/1/15
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findByIdIs(long l);
}
