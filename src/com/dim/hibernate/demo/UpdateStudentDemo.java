package com.dim.hibernate.demo;

import java.util.concurrent.ThreadFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			
			int id = 1;	
			//get a new session and start transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("update a student");
			Student myStudent = session.get(Student.class, id);
			myStudent.setFirstName("Kasun");
			//commit transaction
			session.getTransaction().commit();
			
			//new transcation
			System.out.println("updating all students");
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
		}finally{
			sessionFactory.close();
		}
		
	}

}
