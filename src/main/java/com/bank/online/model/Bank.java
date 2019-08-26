package com.bank.online.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table
public class Bank {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long bankId;
    
    @Column
    private String bankName;
    
    @Column
    private String branchName;
    
    @Column
    private String ifscCode;
    
    @Column
    private long phoneNo;
    
    @Column
    private String state;
    
    @Column
    private String city;
    
    @Column
    private String street;
    
    @Column
    private String country;

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhone(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", branchName=" + branchName + ", ifscCode="
                + ifscCode + ", phoneNo=" + phoneNo + ", state=" + state + ", city=" + city + ", street=" + street
                + ", country=" + country + "]";
    }

    


}
