/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public abstract class Organization {
 
    private String orgName;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int count;
    
    public enum Type{
        Admin("AdminOrganization"),
        Doctor("DoctorOrganization"),
        Nurse("NurseOrganization"),
        Receptionist("ReceptionistOrganization"),
        Pharmacist("PharmacistOrganization"),
        Cashier("CashierOrganization"),
        FieldDrive("FieldDriveOrganization"),
        AmbulanceAssistant("AmbulanceAssistantOrganization"),
        AmbulanceReceptionist("AmbulanceReceptionistOrganization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public Organization(String name)
    {
        orgName=name;
        workQueue= new WorkQueue();
        employeeDirectory= new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        count++;
        organizationID=count;        
    }
    
    public abstract ArrayList<Role> getSupportedRole();
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    @Override
    public String toString() {
        return orgName;
    }
    
    
    
}
