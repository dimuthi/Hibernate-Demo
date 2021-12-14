package com.dim.hibernate.demo;

import java.util.concurrent.ThreadFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			
		//	int id = 1;	
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
		//	Student myStudent = session.get(Student.class, id);
		//	session.delete(myStudent);
			session.createQuery("delete from Student where id =2").executeUpdate();
			session.getTransaction().commit();
			
			
			
		}finally{
			sessionFactory.close();
		}
		
	}

}
