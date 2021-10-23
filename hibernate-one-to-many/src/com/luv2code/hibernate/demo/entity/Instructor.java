package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//annotate the class as an entity and map to db table
@Entity
@Table(name="instructor")
public class Instructor {
	

	//define the fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//annotate the fields with db column names
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	public Instructor() {
		
	}
	
	@OneToMany(mappedBy="instructor",
			   cascade = {CascadeType.PERSIST, CascadeType.MERGE,
		                   CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;
	
	//set up mapping to InstructorDetail
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail isntructorDetail;
	

	//create constructor
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	//generate getter/setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getIsntructorDetail() {
		return isntructorDetail;
	}

	public void setIsntructorDetail(InstructorDetail isntructorDetail) {
		this.isntructorDetail = isntructorDetail;
	}

	//generate toString() method
	@Override
	public String toString() {
		return "Instructor [isntructorDetail=" + isntructorDetail + ", id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	//add convenience methods for bi-directional relationship
	
	public void add(Course tempCourse) {
		
		if (courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(tempCourse);
		
		tempCourse.setInstructor(this);
	}
	

	

	
	
	
	
	

}
