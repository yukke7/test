package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name = "employeeinfo")
@Repository
public class employee {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "busyo")
	private String busyo;
	
	@Column(name = "person_name")
	private String person_name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "telno")
	private String telno;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusyo() {
		return busyo;
	}

	public void setBusyo(String busyo) {
		this.busyo = busyo;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}
	
	

}
