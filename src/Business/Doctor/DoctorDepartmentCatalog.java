/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class DoctorDepartmentCatalog {
    
    private ArrayList<DoctorDepartment> doctorDepartmentCatalog;
    
    public DoctorDepartmentCatalog()
    {
        doctorDepartmentCatalog= new ArrayList<>();
    }

    public ArrayList<DoctorDepartment> getDoctorDepartmentCatalog() {
        return doctorDepartmentCatalog;
    }

    public void setDoctorDepartmentCatalog(ArrayList<DoctorDepartment> doctorDepartmentCatalog) {
        this.doctorDepartmentCatalog = doctorDepartmentCatalog;
    }
    
    public DoctorDepartment addDocDepartment(DoctorDepartment doctorDepartment)
    {
       doctorDepartmentCatalog.add(doctorDepartment);
       return doctorDepartment;
    }
    
}
