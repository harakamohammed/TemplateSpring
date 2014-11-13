package com.pack.myproject.metier.TESTEs;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pack.myproject.entities.Student;
import com.pack.myproject.metier.StudentImplementMetier;

public class TESTJPA {

	private static ClassPathXmlApplicationContext context;
	private static  StudentImplementMetier students;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		students=(StudentImplementMetier) context.getBean("metier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
/*
	@Test
	public void testAddStudent() {
		System.out.println("*******************************");
	try{	
		List<Student> Liste1=students.FeshAllStudents();
		students.AddStudent(new Student("HARAKA","MOHAMMEd","BB564578"));
		students.AddStudent(new Student("FIKRI","ZINEB","EMM"));
		List<Student> Liste2=students.FeshAllStudents();
		assertTrue(Liste1.size()+2==Liste2.size());
	}
	catch(Exception e){assertTrue(e.getMessage(),false);}
	System.out.println("*******************************");
	}
*/
@Test
	public void testFeshAllStudents() {
		 
		List<Student> ListeStudents=students.FeshAllStudents();
		assertNotNull(ListeStudents);
		assertTrue(ListeStudents.size()>=0);
		System.out.println("*******************************");
		System.out.println(ListeStudents);
		System.out.println("*******************************");
		
	}
@Test
public void testUpdate() {
	
	
	students.UpdateStudent(new Student("AMINE","AMAL","BB564578"));
	
}
 
	@Test
	public void testFindByCneStudent() {
		Student E=students.FindByCneStudent("BB564578");
		assertNotNull(E);
		System.out.println("***********FIND********************");
		System.out.println(E);
		System.out.println("*******************************");
	} 

}
