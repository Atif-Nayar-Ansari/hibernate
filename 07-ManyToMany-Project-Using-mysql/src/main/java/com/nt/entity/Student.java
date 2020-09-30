package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_tab")
public class Student {

	
	@Id
	private Integer sid;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name = "stu_cour_tab", 
	                                 joinColumns = @JoinColumn(name = "sidfk"), 
	                                 inverseJoinColumns = @JoinColumn(name = "cidfk"))
	private Set<Course> course = new HashSet<>();

	
	
	
	
	
	
	
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", course=" + course + "]";
	}
}
