package com.zzuser.securitydemo.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuchenshu on 2019/1/15
 */
@Entity
@Data
@Table(name = "teacher")
@EntityListeners(AuditingEntityListener.class)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100)
    private String name;
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses = new HashSet<>();
}
