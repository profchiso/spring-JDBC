package com.gbt.springJDBC.service;


import com.gbt.springJDBC.model.Student;
import com.gbt.springJDBC.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class StudentService {
   private StudentRepository studentRepository;

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }
    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
       return studentRepository.findAll();
    }
}
