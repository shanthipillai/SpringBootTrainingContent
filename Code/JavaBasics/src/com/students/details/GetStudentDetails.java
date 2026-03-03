package com.students.details;

import java.util.ArrayList;
import java.util.List;

public class GetStudentDetails {
	List<Student> studentlist=new ArrayList<>();

	Student student1=new Student("Madhuri",1);
	Student student2=new Student("Ram",2);
	
	public void addListOfStudents()
	{
		//Java Collections
		
		
		studentlist.add(student1);
		studentlist.add(student2);
		
	}
	
	public List<Student> getStudentList()
	{
		//studentlist.forEach(System.out::println);
		return studentlist;
		
	}
}
