package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Instructor.class)
				                  .addAnnotatedClass(InstructorDetail.class)
				                  .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
		    session.beginTransaction();
		    
		  //create the objects
			/*
		    Instructor tempInstructor = 
					new Instructor("Fernando","Delgado","fdbautista90@gmail.com");
	        
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.luv2code.com/t1t4n","Luv 2 code!");
			*/
		    //create new object
		    
		    Instructor tempInstructor = 
					new Instructor("Marcio","Schoenfelder","marcio.prof.ti@gmail.com");
	        
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.luv2code.com/marcioprofti","He's luv 2 code!");
		    
			//associate the ocjects
			tempInstructor.setIsntructorDetail(tempInstructorDetail);
			
			// save the instructor
			//
			// note: this will save ALSO save the details object
			//because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
		    session.getTransaction().commit();
		    
		    System.out.println("Done!");
			
		}
		finally{
			factory.close();
		}
	}

}
