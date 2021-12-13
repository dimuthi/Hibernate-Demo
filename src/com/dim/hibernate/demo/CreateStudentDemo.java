package com.dim.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			Student student = new Student("dimuthi","tharaka","dimu@gmail.com");
			
			//start transaction
			session.beginTransaction();
			System.out.println("saving student");
			//save student object
			session.save(student);
			System.out.println("commit student");
			//commit transaction
			session.getTransaction().commit();
		}finally{
			sessionFactory.close();
		}
		
	}

}
