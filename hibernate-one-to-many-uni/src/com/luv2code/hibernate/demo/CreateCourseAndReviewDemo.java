package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Instructor.class)
				                  .addAnnotatedClass(InstructorDetail.class)
				                  .addAnnotatedClass(Course.class)
				                  .addAnnotatedClass(Review.class)
				                  .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
		    session.beginTransaction();
		    
		    //create a course
		    Course tempCourse = new Course("Pacman - how to score");
		    
		    
		    //add a some reviews
		    tempCourse.addReview(new Review("Great Course"));
		    tempCourse.addReview(new Review("This so funny"));
		    tempCourse.addReview(new Review("I loved it!"));
		    
		    //save the course...and leverage the cascade all 
		    System.out.println("SAving the course");
		    System.out.println(tempCourse);
		    System.out.println(tempCourse.getReviews());
		    
		    session.save(tempCourse);
		    
			//commit transaction
		    session.getTransaction().commit();
		    
		    System.out.println("Done!");
			
		}
		finally{
			//add clean up code
			session.close();
			
			factory.close();
		}
	}

}
