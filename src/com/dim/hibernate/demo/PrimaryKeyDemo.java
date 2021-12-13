package com.dim.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			Student student1 = new Student("John","Doe","john@gmail.com");
			Student student2 = new Student("Mary","Public","mar@gmail.com");
			Student student3 = new Student("Bonita","Apple","boni@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save student object
			System.out.println("saving student");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//commit transaction
			System.out.println("commit student");
			session.getTransaction().commit();
		}finally{
			sessionFactory.close();
		}
		

	}

}
