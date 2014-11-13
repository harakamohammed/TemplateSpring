package com.pack.myproject.controlles;

import java.util.Map;

import javax.persistence.MappedSuperclass;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.myproject.entities.Student;
import com.pack.myproject.metier.StudentInterfaceMetier;

@Controller
@RequestMapping(value="/GS")
public class GestionStudentController {
 
	@Autowired
	private StudentInterfaceMetier metier;
	
	@RequestMapping(value="/PS")
	public String index(Model model)
	{  
		model.addAttribute("student", new Student());
		model.addAttribute("listestudent",metier.FeshAllStudents());
		return "PageStudent";
	}
	
	/*@RequestMapping(value="/STUD")
	public String STUD(Model model,Student s,BindingResult  bindi)
	{  
		
		if(bindi.hasErrors())
		{
			  return "PageStudent";
		}
		metier.AddStudent(s);
		
		model.addAttribute("student", new Student());
		model.addAttribute("listestudent",metier.FeshAllStudents());
		return "PageStudent";
	}*/
	
	
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student s, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Student studentResult = new Student();
		if(result.hasErrors())
		{
			  return "PageStudent";
		}
		if(action.toLowerCase().equals("add"))
		{
			metier.AddStudent(s);
		}
		if(action.toLowerCase().equals("edit"))
		{   
			//Student E=new Student(s.getNom(),s.getPrenom(),s.getCne());
			//E.setID(s.);
		  
			  
			 metier.UpdateStudent(s);
			 
		}
		 
		if(action.toLowerCase().equals("delete"))
		{  
			
			  Student E=new Student(s.getNom(),s.getPrenom(),s.getCne());
			 metier.DeleteStudent(E);
			 
		}
		if(action.toLowerCase().equals("search"))
		{  
			 
			   map.put("student", metier.FindByCneStudent(s.getCne()));
				map.put("listestudent",metier.FeshAllStudents());
				return "PageStudent";
		}
		
	/*	switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			studentService.add(student);
			studentResult = student;
			break;
		case "edit":
			studentService.edit(student);
			studentResult = student;
			break;
		case "delete":
			studentService.delete(student.getStudentId());
			studentResult = new Student();
			break;
		case "search":
			Student searchedStudent = studentService.getStudent(student.getStudentId());
			studentResult = searchedStudent!=null ? searchedStudent : new Student();
			break;
		}*/
		map.put("student", new Student());
		map.put("listestudent",metier.FeshAllStudents());
		return "PageStudent";
	}
	
}
