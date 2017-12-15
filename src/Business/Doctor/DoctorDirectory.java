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
public class DoctorDirectory {
    
    public ArrayList<Doctor> doctorList;

    
    DoctorDirectory()
    {
        doctorList= new ArrayList<Doctor>();
    }
    
    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

   public Doctor addDoctor(Doctor doctor)
   {
       doctorList.add(doctor);
       return doctor;
   }
    
    
}
