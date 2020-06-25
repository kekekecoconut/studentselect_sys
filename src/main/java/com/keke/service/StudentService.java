package com.keke.service;

import com.keke.domain.Student;
import com.keke.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> showAllStudents(){
        return studentMapper.showAllStudents();
    }

    public Student studentLogin(String sno, String spassword){
        return studentMapper.studentLogin(sno,spassword);
    }

    public List<Student> selectsByDept(String sdept){
        return studentMapper.selectsByDept(sdept);
    }

    public List<Student> selectsBySno(String sno){
        return studentMapper.selectsBySno(sno);
    }

    public void deleteStudent(String sno){
        studentMapper.deleteStudent(sno);
    }

    public void insertStudent(Student student){
        studentMapper.insertStudent(student);
    }

    public void updateStudent(Student student){
        studentMapper.updateStudent(student);
    }

}
