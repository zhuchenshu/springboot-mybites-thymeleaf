package com.zzuser.securitydemo.controller;

import com.zzuser.securitydemo.domain.Teacher;
import com.zzuser.securitydemo.repository.TeacherRepository;
import com.zzuser.securitydemo.service.TeacherService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类 名: TeacherConreoller
 * 描 述: 教师实体相关api
 * 作 者: zhuchenshu
 * 创 建: 2019/1/17 11:03
 * 邮 箱: zhuchenshu@foxmail.com
 */
@RestController
@RequestMapping("/teacher")
public class TeacherConreoller {
    private final static Logger log = LoggerFactory.getLogger(TeacherConreoller.class);

    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherRepository teacherRepository;
    @GetMapping("/{id}")
    @ApiOperation(value="获取教师详细信息", notes="根据url的id来获取教师详细信息")
    @ApiImplicitParam(name = "id", value = "教师ID", required = true, dataType = "long", paramType = "path")
    public Teacher findById(@PathVariable(value = "id") Long id) {
        log.info("获取教师详细信息,id = " + id);
        log.error("获取教师详细信息,id = " + id);
        return teacherService.findById(id);
    }

    @PostMapping
    @ApiOperation(value="保存教师", notes="保存教师")
    @ApiImplicitParam(name = "teacher", value = "教师", required = true, dataType = "Teacher")
    public Teacher save(@RequestBody Teacher teacher) {
        log.info("保存教师");
        log.error("保存教师");
        return teacherRepository.save(teacher);
    }
}
