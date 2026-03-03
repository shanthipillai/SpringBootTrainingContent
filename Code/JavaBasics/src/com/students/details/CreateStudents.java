package com.students.details;

import java.util.List;

public class CreateStudents {

	public static void main(String[] args) {

		/*
		 * Student student1=new Student("Madhuri",1); Student student2=new
		 * Student("Ram",2);
		 * 
		 * System.out.println(student1.rollno); System.out.println(student1.studname);
		 * 
		 * 
		 * System.out.println(student1.getRollno());
		 * System.out.println(student1.getStudname());
		 * 
		 * student1.setRollno(100); System.out.println(student1.getRollno());
		 * System.out.println(student1.getStudname());
		 */

		
		
		GetStudentDetails object = new GetStudentDetails();
		object.addListOfStudents();
	//	object.getStudentList();
		List<Student> studentlist=(List<Student>) object.getStudentList();
		
		
		studentlist.forEach(i->System.out.println(i.getRollno()+i.getStudname()));

	}

}
