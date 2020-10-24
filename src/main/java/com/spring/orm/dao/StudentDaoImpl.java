package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDaoImpl implements StudentDao{

	HibernateTemplate hibernateTemplate;
    @Transactional
	public int insert(Student student) {
		// insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
    
    public Student getStudent(int studentId) {
		// read single object
    	Student student = this.hibernateTemplate.get(Student.class,studentId);
		return student;
	}
    
    public List<Student> getAllStudents() {
		// read all object
    	List<Student> all = this.hibernateTemplate.loadAll(Student.class);
		return all;
	}
    @Transactional
    public void deleteStudent(int studentId) {
		// delete opertion
    	Student student = this.hibernateTemplate.get(Student.class,studentId);
    	this.hibernateTemplate.delete(student);
		
	}
    @Transactional
    public void updateStudent(Student student) {
		// update
    	this.hibernateTemplate.update(student);
		
	}	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	
	
}
