package com.hibernate.association.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.hibernate.association.dao.EmployeeDAO;
import com.hibernate.association.pojo.Employee;
import com.hibernate.association.pojo.EmployeeProject;
import com.hibernate.association.pojo.Project;

public class EmployeeService {
	public static void main(String[] args) {
		Employee employee = new Employee();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// employee details
			employee.setDoj(sdf.parse("2014-08-28"));
			employee.setFirstName("Tony");
			employee.setLastName("Jha");

			// project details
			Project project1 = new Project();
			project1.setProjectName("MARS");
			project1.setStartDate(sdf.parse("2013-01-01"));
			project1.setExpectedEndDate(sdf.parse("2015-08-28"));

			EmployeeDAO.save(project1);


			EmployeeProject employeeProject = new EmployeeProject();
			employeeProject.setActive(true);
			employeeProject.setDeleted(false);
			employeeProject.setProject(project1);
			employeeProject.setEmployee(employee);
			
			employee.getEmployeeProjects().add(employeeProject);
			// calling save method of EmployeeDAO
			System.out.println(EmployeeDAO.save(employee));

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
