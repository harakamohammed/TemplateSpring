package com.pack.myproject.dao;

import java.util.List;

import com.pack.myproject.entities.Student;

public interface StudentInterfacedao {
 
	public void AddStudent(Student s);
	public List<Student> FeshAllStudents();
	public Student FindByCneStudent(String Cne);
	public void UpdateStudent(Student s);
}
