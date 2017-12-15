/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Doctor.Doctor;
import Business.Doctor.DoctorDepartmentCatalog;
import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.Role;
import Business.Rules.RuleDirectory;
import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class DoctorOrganization extends Organization{

    private DoctorDepartmentCatalog doctorDepartmentCatalog;
    private RuleDirectory ruleDirectory;
    
    
    
    public DoctorOrganization() {
        super(Organization.Type.Doctor.getValue());
        doctorDepartmentCatalog= new DoctorDepartmentCatalog();
        ruleDirectory= RuleDirectory.getInstance();
    }   
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DoctorRole());
        return roles;
    }

    public DoctorDepartmentCatalog getDoctorDepartmentCatalog() {
        return doctorDepartmentCatalog;
    }

    public void setDoctorDepartmentCatalog(DoctorDepartmentCatalog doctorDepartmentCatalog) {
        this.doctorDepartmentCatalog = doctorDepartmentCatalog;
    }

    public RuleDirectory getRuleDirectory() {
        return ruleDirectory;
    }

    public void setRuleDirectory(RuleDirectory ruleDirectory) {
        this.ruleDirectory = ruleDirectory;
    }
    
    
    
}
