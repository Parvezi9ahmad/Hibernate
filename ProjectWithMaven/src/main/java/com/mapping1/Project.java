package com.mapping1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {


	@Id
	private int pid;
	
	@Column(name = "project_name")
	private String projectname;
	
	@ManyToMany()
	private List<Emp> emp;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public List<Emp> getEmp() {
		return emp;
	}

	public void setEmp(List<Emp> emp) {
		this.emp = emp;
	}

	public Project(int pid, String projectname, List<Emp> emp) {
		super();
		this.pid = pid;
		this.projectname = projectname;
		this.emp = emp;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
