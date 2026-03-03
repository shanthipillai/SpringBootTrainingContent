package com.students.details;

public class Student {

	
	private String studname;
	 private int rollno;
	//Default Constructor
	Student()
	{
		System.out.println("Default Constructor");
	}
	
	Student(String studname, int rollno)
	{
		this.studname=studname;
		this.rollno=rollno;
	}

	

	public void setStudname(String studname) {
		this.studname = studname;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public int getRollno() {
		return rollno;
	}

	public String getStudname() {
		return studname;
	}
	
	
	
	
}
