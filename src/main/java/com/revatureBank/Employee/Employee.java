package com.revatureBank.Employee;

public class Employee {
	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	private long employeePhone;
	private String password;
	private String employeeAddress;
	private String employeeAadharNo;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public long getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(long employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

public String getEmployeeAadharNo() {
	return employeeAadharNo;
}
public void setEmployeeAadharNo(String employeeAadharNo) {
	this.employeeAadharNo = employeeAadharNo;
}
@Override
	public String toString() {
		return "Customer [customerId=" + employeeId + ", employeeName=" + employeeName + ",  employeeEmail=" + employeeEmail + ",employeePhone="
				+ employeePhone + ", password=" + password + ", employeeAddress=" + employeeAddress +  ", employeeAadhar=" + employeeAadharNo + ",]";
	}
}
