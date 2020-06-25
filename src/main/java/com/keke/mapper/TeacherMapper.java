package com.keke.mapper;

import com.keke.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    public Teacher teacherLogin(String tno, String tpassword);

    public List<Teacher> showAllTeacher();

    public List<Teacher> selecttByTno(String tno);

    public List<Teacher> selecttByTcoll(String tcoll);

    public List<Teacher> selecttByTname(String tname);

    public void deleteTeacher(String tno);

    public void insertTeacher(Teacher teacher);

    public void updateTeacher(Teacher teacher);

}
