package com.zzuser.securitydemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhuchenshu on 2019/1/15
 */
@Entity
@Data
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100)
    private String name;
    @ManyToMany()
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courseList = new ArrayList<>();
    @CreatedDate
    private Date created;
    @LastModifiedDate
    private Date updated;
}
