package com.srcsys;
public class Mybean
{
    private int contactid;
    private String name;
    private String address;
    private String email;
    private int contactno;
    
    public int getContactId() {
        return contactid;
    }
    public void setContactId(int contactid) {
        this.contactid = contactid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }      
    public String getEmail() {
    	return email;
    }
    public void setEmail(String email) {
    	this.email=email;
    } 
    public int getContactNo() {
    	return contactno;
    }
    public void setContactNo(int contactno) {
    	this.contactno=contactno;
    }
}