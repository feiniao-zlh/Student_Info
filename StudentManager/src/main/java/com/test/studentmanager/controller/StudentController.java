package com.test.studentmanager.controller;


import com.test.studentmanager.pojo.Student;
import com.test.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
@RequestMapping(value = "/student",method = RequestMethod.GET)
public class StudentController {
    @Autowired
    private StudentService studentService;
    //全查
    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<Student> list = studentService.queryAll();

        //存入model中
        model.addAttribute("list",list);
        //控制跳转
        return "showAll";
    }
    //根据ID删除学生信息
    @RequestMapping("removeById")
    public String removeById(Integer id){
        try {
            studentService.removeById(id);
            System.out.println("删除");
            return "redirect:/student/queryAll";
        }catch (Exception e){
            return "/error";
        }
    }
    //添加学生信息
    @RequestMapping("addStudent")
    public String addStudent(Student student){
        try {
            studentService.insertStudent(student);
            return "redirect:/student/queryAll";
        }catch (Exception e){
            //异常打印
            e.printStackTrace();
            return "/error";
        }
    }

    //根据ID查询学生信息
    @RequestMapping("queryById")
    public String queryById(Integer id, ModelMap modelMap){
//        System.out.println("sdasa");
        Student student = studentService.queryById(id);
        modelMap.addAttribute("student",student);
//        System.out.println("sdasa");
        return "update";
    }

    //修改学生信息
    @RequestMapping("changeStudent")
    public String changeStudent(Student student){
        try {
//            System.out.println("sdasa");
            studentService.changeStudent(student);
            return "redirect:/student/queryAll";
        }catch (Exception e){
            return "error";
        }
    }

}
