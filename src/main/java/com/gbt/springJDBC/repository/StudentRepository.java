package com.gbt.springJDBC.repository;

import com.gbt.springJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(Student student) {
        String sql = "insert into student (regno,name,marks) values(?,?,?)";
        int rowAffected = jdbcTemplate.update(sql,student.getRegno(),student.getName(),student.getMarks());
        if(rowAffected>0){
          System.out.println(rowAffected + " is affected");
        }else{
          System.out.println("Something went wrong while adding a student");
        }

    }

    public List<Student> findAll() {
        String sql= "select * from student";
        RowMapper<Student> rowMapper = new RowMapper<>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setRegno(rs.getInt("regno"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getInt("marks"));
                return student;
            }
        };
      List<Student> students = jdbcTemplate.query(sql,rowMapper);
        return students;
    }
}
