package com.priya.jpa.hibernate.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.priya.jpa.hibernate.demo.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entityManager;
//	@PersistenceContext
//	EntityManager entityManager;

	//public Course findById(Long id)
	
	//public void deleteById(Long id) --n> delete by using id
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	//public Course save(Course course) --> insert or update
	
	public Course save(Course course) {
		if(course.getId()==null) {
			//insert
			 entityManager.persist(course);
		}
		else {
		//update
		entityManager.merge(course);
	}
	return course;
	}

	//public void deleteById(Long id) --n> delete by using id
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	public void playWithEntityManager() {
		logger.info("playWithEntityManager - start");
		//create and insert
		Course course1 = new Course("Web Services in 100 Steps");
		entityManager.persist(course1);
		// make changes to database
		entityManager.flush();
		
		//update
		course1.setName("Web services in 100 Steps - Updated");
		entityManager.flush();
		

		
		Course course2 = new Course("Angular Js in 100 Steps");
		entityManager.persist(course2);
		entityManager.flush();
		entityManager.detach(course2);
		
		course2.setName("Angular Js in 100 Steps - Updated");
		
		entityManager.refresh(course2); // -> retrieves values from db and updated one will no longer be avail to entity manager
		entityManager.flush();
	
	}


}
