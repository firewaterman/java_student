package com.hyf.action;

public class Student {
    public String name;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String infos) {
		this.sno = infos;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String sex;
    public String sno;
    public String grade;

	@Override
	public String toString() {
		return name+"\t"+sex+"\t"+sno+"\t"+grade;
	}

	
}
