package com.zzuser.securitydemo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100)
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToMany()
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> studentList = new ArrayList<>();
    @CreatedDate
    private Date created;
    @LastModifiedDate
    private Date updated;
}
