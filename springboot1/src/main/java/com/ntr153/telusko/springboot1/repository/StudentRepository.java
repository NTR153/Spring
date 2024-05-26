package com.ntr153.telusko.springboot1.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.ntr153.telusko.springboot1.model.Student;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    public void save(Student student) {
        String sql = "insert into student (s_id, s_name, marks) values (?,?,?)";
        int rowsAffected = jdbcTemplate.update(sql, student.getStudentNo(), student.getStudentName(), student.getStudentMarks());
        System.out.println("rows affected = " + rowsAffected);
    }

    public List<Student> findAll() {

        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            @Nullable
            public Student mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {

                Student s = new Student();
                s.setStudentNo(rs.getInt("S_ID"));
                s.setStudentName(rs.getString("S_NAME"));
                s.setStudentMarks(rs.getInt("MARKS"));

                return s;
            }
        };

        List<Student> students = jdbcTemplate.query("SELECT * FROM STUDENT", rowMapper);
        return students;
    }

    public JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

}
