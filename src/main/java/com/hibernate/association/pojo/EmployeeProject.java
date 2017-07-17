package com.hibernate.association.pojo;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee_proj")
@AssociationOverrides({
		@AssociationOverride(name = "id.employee", joinColumns = @JoinColumn(name = "employee_id")),
		@AssociationOverride(name = "id.project", joinColumns = @JoinColumn(name = "project_id")) })
public class EmployeeProject {
	@EmbeddedId
	private EmployeeProjectPK id = new EmployeeProjectPK();

	@Column(name = "acitve")
	private boolean active;

	@Column(name = "is_deleted")
	private boolean deleted;

	public EmployeeProjectPK getId() {
		return id;
	}

	public void setId(EmployeeProjectPK id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Employee getEmployee() {
		return getId().getEmployee();
	}

	public void setEmployee(Employee employee) {
		getId().setEmployee(employee);
	}

	public Project getProject() {
		return getId().getProject();
	}

	public void setProject(Project project) {
		getId().setProject(project);
	}

}
