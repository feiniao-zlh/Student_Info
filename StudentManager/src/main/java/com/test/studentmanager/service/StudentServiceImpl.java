package com.test.studentmanager.service;

import com.test.studentmanager.dao.StudentDao;
import com.test.studentmanager.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> queryAll() {
        return studentDao.selectAll();
    }

    @Override
    public void removeById(Integer id) {
        //没有返回值，直接try捕捉异常
        try {
            studentDao.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("ID删除异常");
        }
    }

    @Override
    public void insertStudent(Student student) {
        try {
            studentDao.insertStudent(student);
        }catch (Exception e){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public Student queryById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public void changeStudent(Student student) {
        try {
            studentDao.updateById(student);
        }catch (Exception e){
            throw new RuntimeException("修改失败");
        }

    }
}
