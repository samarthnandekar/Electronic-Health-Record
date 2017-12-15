/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Patient.Patient;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Samarth
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private Patient patient;
    private UserAccountStatus userAccountStatus;
    
    public UserAccount() {
        workQueue = new WorkQueue();
        userAccountStatus=UserAccountStatus.Active;
    }
    
    public UserAccount(String username, String password, Employee employee, Role role) {
        this.username=username;
        this.password=password;
        this.employee=employee;
        this.role=role;
        workQueue = new WorkQueue();
        userAccountStatus=UserAccountStatus.Active;
    }

    
       public enum UserAccountStatus{
        Active("Active"),
        Deactivate("Deactivate"),
        Blocked("Blocked");
        
        
        private String value;
        private UserAccountStatus(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public UserAccountStatus getUserAccountStatus() {
        return userAccountStatus;
    }

    public void setUserAccountStatus(UserAccountStatus userAccountStatus) {
        this.userAccountStatus = userAccountStatus;
    }
    
    @Override
    public String toString()
    {
        return username;
    }
    
}
