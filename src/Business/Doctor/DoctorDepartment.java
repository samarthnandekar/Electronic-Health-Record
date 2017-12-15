/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

/**
 *
 * @author Samarth
 */
public class DoctorDepartment {
 
    public String doctorDepartmentName;
    public DoctorDirectory doctorDirectory;

    
    public DoctorDepartment(String name)
    {
     doctorDepartmentName=name;
     doctorDirectory= new DoctorDirectory ();
    }
    public String getDoctorDepartmentName() {
        return doctorDepartmentName;
    }

    public void setDoctorDepartmentName(String doctorDepartmentName) {
        this.doctorDepartmentName = doctorDepartmentName;
    }

    public DoctorDirectory getDoctorDirectory() {
        return doctorDirectory;
    }

    public void setDoctorDirectory(DoctorDirectory doctorDirectory) {
        this.doctorDirectory = doctorDirectory;
    }

    @Override
    public String toString() {
        return doctorDepartmentName ;
    }
    
    
}
