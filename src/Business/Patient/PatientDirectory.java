/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class PatientDirectory {
    
    private ArrayList<Patient> patientList;

    public PatientDirectory()
    {
        patientList=new ArrayList<>();
    }
    
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }
    public Patient addpatPatient(Patient patient)
    {
        patientList.add(patient);
        return patient;
    }
    
}
