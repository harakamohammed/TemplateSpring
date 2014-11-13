package com.pack.myproject.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pack.myproject.dao.StudentInterfacedao;
import com.pack.myproject.entities.Student;


public class StudentImplementMetier implements StudentInterfaceMetier {
   
	private StudentInterfacedao dao;
	public void setDao(StudentInterfacedao dao) {
		this.dao = dao;
	}

	@Override
	public void AddStudent(Student s) {

             dao.AddStudent(s);

	}

	@Override
	public List<Student> FeshAllStudents() {
		 
		return dao.FeshAllStudents();
	}

	@Override
	public Student FindByCneStudent(String Cne) {
		 
		return dao.FindByCneStudent(Cne);
	}

	@Override
	public void UpdateStudent(Student s) {
		// TODO Auto-generated method stub
		 
		  s.setID(dao.FindByCneStudent(s.getCne()).getID());
		 dao.UpdateStudent(s);
		 
		// dao.DeleteStudent(S);
		 
		//dao.AddStudent(s); 
	}

	@Override
	public void DeleteStudent(Student s) {
		// TODO Auto-generated method stub
		dao.DeleteStudent(s);
	}

}
