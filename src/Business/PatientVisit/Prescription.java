/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientVisit;

import Business.Doctor.Doctor;
import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class Prescription {
    
    private MedicationList medicationList;
    private String date;
    private Doctor doctor;

    public MedicationList getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(MedicationList medicationList) {
        this.medicationList = medicationList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
 
    
}
