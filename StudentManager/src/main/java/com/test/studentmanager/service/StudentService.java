package com.test.studentmanager.service;

import com.test.studentmanager.pojo.Student;

import java.util.List;

public interface StudentService {
    //全查学生信息
    public List<Student> queryAll();

    //根据id删除学生信息
    public void removeById(Integer id);

    //添加学生信息
    public void insertStudent(Student student);

    //根据ID查询学生信息
    public Student queryById(Integer id);

    //修改学生信息
    public void changeStudent(Student student);
}
