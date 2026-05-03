package com.students;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class StudentDao {
	
	
	@Autowired
	SessionFactory sf;
	public Student getStudent(int id)
	{
		Session s=sf.getCurrentSession();
		Student stu=s.find(Student.class, id);
		return stu;
	}
	public void insertStudent()
	{
		Session session=sf.getCurrentSession();
		Student st1=new Student(1000,"Nandan",91);
		session.persist(st1);
		System.out.println("Data Inserted Successfully!!!!!");
	}
	
	public void deleteStudent(int id)
	{
		Session s=sf.getCurrentSession();
		Student student = s.find(Student.class,id);
		s.remove(student);
		System.out.println("Data Deleted Sucessfully!!!");
	}
	public Student updateStudent(int id)
	{
		Session s=sf.getCurrentSession();
		Student student = s.find(Student.class, id);
		student.setSname("Hari Hara Nandan");
		s.merge(student);
		return student;
	}
	
	

}
