package com.roy.controller;

import com.roy.entity.Student;
import com.roy.entity.Teacher;
import com.roy.entity.TeacherCopy;
import com.roy.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/** description： author：dingyawu date：created in 23:34 2020/11/21 history: */
@RequestMapping("/user3")
@RestController
@Slf4j
public class UserController3 {

  @RequestMapping("/save")
  public String save(@RequestBody User user) {
    System.out.println(user.getBirthday());
    return "success";
  }

  /**
   * beanutils.copyProperties
   *
   * @return {@link String}
   */
  @GetMapping("/copy")
  public String beanCopy() {
    Teacher teacher = new Teacher();
    teacher.setName("dingyawu");
    teacher.setAge(29);
    Student student = new Student();
    student.setName("wuyinwei");
    student.setAge("29");
    teacher.setStudents(Collections.singletonList(student));
    TeacherCopy teacherCopy = new TeacherCopy();
    BeanUtils.copyProperties(teacher, teacherCopy);
    log.info("获取teacherCopy：{}", teacherCopy);
    return "ok";
  }
}
