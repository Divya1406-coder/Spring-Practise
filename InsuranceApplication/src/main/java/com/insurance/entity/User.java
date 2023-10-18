package com.insurance.entity;


public class User {
	private String Name;
	private Integer Age;
	private String Gender;
	private Double Height;

	public User(String Name, Integer Age, String Gender, Double Height) {
		this.Name = Name;
		this.Age = Age;
		this.Gender = Gender;
		this.Height = Height;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Double getHeight() {
		return Height;
	}

	public void setHeight(Double height) {
		Height = height;
	}

	@Override
	public String toString() {
		return "Name=" + Name + ", Age=" + Age + ", Gender=" + Gender + ", Height=" + Height;
	}

}
