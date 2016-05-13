package com.min.job;
/**
 教师类是用来创建教师对象的，教师对象用来存储教师信息
 */
 public class Teacher
 {
	 private long id;
	 private String name;
	 private int age;
	 private String course;
	 public Teacher( long id,String name,int age,String course)
		 
	 {
		this.id=id;
		this.name=name;
		this.age=age;
		this.course=course;

	 }
	 public void setId(long id)
		{
		 this.id=id;
	 }
	 public Long getId()
		
	 {
		 return this.id;
	 }
	 public void setName(String name)
		
	 {
		 this.name=name;
	 }
	 public String getName()
		
	 {
		 return this.name;
	 }
	 public void setAge(int age)
		
	 {
		 this.age=age;
	 }
	 public int getAge()
		
	 {
		 return this.age;
	 }
	 public void setCourse(String course)
		
	 {
		 this.course=course;
	 }
	 public String getCourse()
		
	 {
		 return this.course;
	 }
	 public String toString()
	 {
	 return "Teacher [id: "+this.id+",name"+this.name+",age"+this.age+",course"+this.course+"]";
	 }
	 
 }