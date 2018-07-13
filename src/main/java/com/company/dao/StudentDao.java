package com.company.dao;

import com.company.Student;

import java.util.List;

public interface StudentDao {
    public Student create();
    public Student read(int key);
    public void update(Student student);
    public void delete(Student student);
    public List<Student> getAll();
}
