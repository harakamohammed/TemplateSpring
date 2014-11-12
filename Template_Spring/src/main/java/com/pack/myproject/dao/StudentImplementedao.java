package com.pack.myproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pack.myproject.entities.Student;

@Transactional
public class StudentImplementedao implements StudentInterfacedao {
   
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void AddStudent(Student s) {
		// TODO Auto-generated method stub
        em.persist(s);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> FeshAllStudents() {
		 
		return em.createQuery("select s from Student s").getResultList();
				
	}
   
	@Override
	public Student FindByCneStudent(String Cne) {
		// TODO Auto-generated method stub
		List<Student> ListeStudents;
		Query req=em.createQuery("select s from Student s");
		 
		ListeStudents=req.getResultList();
		boolean tr=false;
		for(int i=0;i<ListeStudents.size();i++)
		{
			if(ListeStudents.get(i).getCne().equals(Cne))
			{
				return ListeStudents.get(i);
			}
		}
		return null;
	}

	@Override
	public void UpdateStudent(Student s) {
		// TODO Auto-generated method stub
		 
		 	em.persist(s);
	}

}
