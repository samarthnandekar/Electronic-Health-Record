/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author Samarth 
 */
public class Person {
    public String firstName;
    public String lastName;
    public String gender;
    public String dob;
    public String phoneNo;
    public String emailID;
    public String insuranceCode;
    public int insuranceCoverageLimit;
    public int personID;
    public static int count=0;
    public String username;
    public String password;
    public double latitude;
    public double longitude;

   
    public Person()
    {
        count++;
        personID=count;
    }
    public Person(String fname,String lname)
    {
     firstName=fname;
     lastName=lname;
    }
    public Person(String name)
    {
        firstName=name;
    }
    /*
    public String getFisrtName() {
        return firstName;
    }

    public void setFisrtName(String fisrtName) {
        this.firstName = fisrtName;
    }
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    public int getInsuranceCoverageLimit() {
        return insuranceCoverageLimit;
    }

    public void setInsuranceCoverageLimit(int insuranceCoverageLimit) {
        this.insuranceCoverageLimit = insuranceCoverageLimit;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    

    
    
    
    @Override
    public String toString() {
        return firstName+ " "+ lastName;
    }
    
    
}
