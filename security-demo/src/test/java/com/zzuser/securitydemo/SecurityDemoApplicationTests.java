package com.zzuser.securitydemo;

import com.zzuser.securitydemo.domain.Course;
import com.zzuser.securitydemo.domain.Student;
import com.zzuser.securitydemo.domain.Teacher;
import com.zzuser.securitydemo.repository.CourseRepository;
import com.zzuser.securitydemo.repository.StudentRepository;
import com.zzuser.securitydemo.repository.TeacherRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testTeacherAndCourse() {
        Teacher teacher = new Teacher();
        teacher.setName("氧量");
        teacherRepository.save(teacher);
        Course course = new Course();
        course.setName("软件工厂");
        course.setTeacher(teacher);
        Course course1 = courseRepository.save(course);

        Teacher teacher1 = teacherRepository.findByIdIs(course1.getTeacher().getId());
        Assert.assertEquals(teacher1.getCourses().size(), 1);
        Optional<Course> course2 = courseRepository.findById(course1.getId());
        Assert.assertEquals(course1.getTeacher().getName(), "氧量");
    }

    @Test
    public void testStudentCourse() {
        Teacher teacher = new Teacher();
        teacher.setName("氧量");
        teacherRepository.save(teacher);
        Course course = new Course();
        course.setName("软件工厂");
        course.setTeacher(teacher);
        Course course1 = courseRepository.save(course);
        Student student = new Student();
        student.setName("zhuchenshu");
        ArrayList<Course> courseArrayList = new ArrayList<>();
        courseArrayList.add(course1);
        student.setCourseList(courseArrayList);
        Student student1 = studentRepository.save(student);
        Assert.assertEquals(student1.getCourseList().size(), 1);
        Course course2 = courseRepository.findByIdIs(course1.getId());
    }

}
