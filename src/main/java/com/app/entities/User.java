package com.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empName;
    private String email;
    private String joiningDate;
    private double basicSalary;
    private int allowance;
    private int tax;
    private int insurance;
    private long otherDeduction;
    private double netSalary;
    public String username;
    public String password;

    public User() {
    	super();
    }

    public User(Long id, String empName, String email, String joiningDate, double basicSalary, int allowance, int tax,
                int insurance, long otherDeduction, String username, String password) {
        this.id = id;
        this.empName = empName;
        this.email = email;
        this.joiningDate = joiningDate;
        this.basicSalary = basicSalary;
        this.allowance = allowance;
        this.tax = tax;
        this.insurance = insurance;
        this.otherDeduction = otherDeduction;
        this.netSalary = calculateNetSalary();
        this.username=username;
        this.password=password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
        this.netSalary = calculateNetSalary();
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
        this.netSalary = calculateNetSalary();
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
        this.netSalary = calculateNetSalary();
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
        this.netSalary = calculateNetSalary();
    }

    public long getOtherDeduction() {
        return otherDeduction;
    }

    public void setOtherDeduction(long otherDeduction) {
        this.otherDeduction = otherDeduction;
        this.netSalary = calculateNetSalary();
    }
    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    private double calculateNetSalary() {
        return basicSalary + allowance - (tax + insurance + otherDeduction);
    }

    
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", empName=" + empName + ", email=" + email + ", joiningDate=" + joiningDate
				+ ", basicSalary=" + basicSalary + ", allowance=" + allowance + ", tax=" + tax + ", insurance="
				+ insurance + ", otherDeduction=" + otherDeduction + ", netSalary=" + netSalary + ", username="
				+ username + ", password=" + password + "]";
	}

	
}
