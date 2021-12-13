package com.dim.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
		
			//start transaction
			session.beginTransaction();
			
			//retrive all students
			List<Student> theStudents = session.createQuery("from Student").list();
			displayStudents(theStudents);
			
			// Query students with last name is Doe
			List<Student> doeStudents = session.createQuery("from Student where lastName='Doe'").list();
			displayStudents(doeStudents);
			
			//query students with last name is doe or first name is mary
			List<Student> thetudents = session.createQuery("from Student where lastName='Doe' OR firstName='Mary'").list();
			displayStudents(thetudents);
			
			//commit transaction
			session.getTransaction().commit();
		}finally{
			sessionFactory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
