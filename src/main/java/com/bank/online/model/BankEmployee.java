 package com.bank.online.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class BankEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;

    @NotNull(message = "Name cannot be null")
    private String employeeName;
    
    @NotNull(message = "Password cannot be null")
    private String employeePassword;
    
    @NotNull(message = "Role cannot be null")
    private String employeeRole;

    public BankEmployee(){
        this.employeeId = 12;
        this.employeeName = "employee";
        this.employeePassword = "employee";
        this.employeeRole = "admin";
    }

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	
	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	@Override
	public String toString() {
		return "BankEmployee [employeeName=" + employeeName + ", employeeRole=" + employeeRole + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
		result = prime * result + ((employeeRole == null) ? 0 : employeeRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankEmployee other = (BankEmployee) obj;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeePassword == null) {
			if (other.employeePassword != null)
				return false;
		} else if (!employeePassword.equals(other.employeePassword))
			return false;
		if (employeeRole == null) {
			if (other.employeeRole != null)
				return false;
		} else if (!employeeRole.equals(other.employeeRole))
			return false;
		return true;
	}    
}
