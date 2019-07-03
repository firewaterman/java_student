package com.hyf.action;

public class admin {

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String name;
	public String ano;
	public String sex;
	public String grade;
	@Override
	public String toString() {
		return name+"\t"+ano+"\t"+sex+"\t"+grade;
	}
}
