package com.dim.hibernate.demo;

import java.util.concurrent.ThreadFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			Student student = new Student("Udari","Vimansana","udv@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save student object
			System.out.println("saving student");
			session.save(student);
			
			//commit transaction
			System.out.println("commit student");
			session.getTransaction().commit();
			
			//get commited objects's generated Id
			int id = student.getId();
			
			//get a new session and start transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println(myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally{
			sessionFactory.close();
		}
		
	}

}
