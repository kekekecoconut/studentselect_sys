package com.keke.service;

import com.keke.domain.Student;
import com.keke.domain.Teacher;
import com.keke.mapper.StudentMapper;
import com.keke.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher teacherLogin(String tno, String tpassword){
        return teacherMapper.teacherLogin(tno,tpassword);
    }

    public List<Teacher> showAllTeacher(){
        return teacherMapper.showAllTeacher();
    }

    public List<Teacher> selecttByTno(String tno){
        return teacherMapper.selecttByTno(tno);
    }

    public List<Teacher> selecttByTcoll(String tcoll){
        return teacherMapper.selecttByTcoll(tcoll);
    }

    public List<Teacher> selecttByTname(String tname){
        return teacherMapper.selecttByTname(tname);
    }

    public void deleteTeacher(String tno){
        teacherMapper.deleteTeacher(tno);
    }

    public void insertTeacher(Teacher teacher){
        teacherMapper.insertTeacher(teacher);
    }

    public void updateTeacher(Teacher teacher){
        teacherMapper.updateTeacher(teacher);
    }
}
