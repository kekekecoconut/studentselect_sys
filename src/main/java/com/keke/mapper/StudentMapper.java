package com.keke.mapper;

import com.keke.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

    public List<Student> showAllStudents();

    public Student studentLogin(String sno, String spassword);

    public List<Student> selectsByDept(String sdept);

    public List<Student> selectsBySno(String sno);

    public void deleteStudent(String sno);

    public void insertStudent(Student student);

    public void updateStudent(Student student);

}
