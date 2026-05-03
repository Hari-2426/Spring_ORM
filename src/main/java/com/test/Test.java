package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.configu.Config;
import com.students.Student;
import com.students.StudentDao;

public class Test {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ap=new AnnotationConfigApplicationContext(Config.class);
		StudentDao bean = ap.getBean("studentDao",StudentDao.class);
		
		//Inserting Data
//		bean.insertStudent();
		
		//Finding Data
		Student student = bean.getStudent(1001);
		System.out.println(student);
		
		// Updating Data
//		Student updateStudent = bean.updateStudent(1000);
//		System.out.println(updateStudent);
		
	}

}
