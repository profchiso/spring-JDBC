package com.gbt.springJDBC;

import com.gbt.springJDBC.model.Student;
import com.gbt.springJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

	    ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student student = context.getBean(Student.class);
		StudentService studentService = context.getBean(StudentService.class);
		student.setRegno(101);
		student.setName("chinedu");
		student.setMarks(100);

		studentService.addStudent(student);
		List<Student> students= studentService.getStudents();
		System.out.println(students);
	}

}
