/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Patient.Patient;
import Business.PatientVisit.Prescription;
import Business.PatientVisit.Visit;

/**
 *
 * @author samar
 */
public class MedicineWorkRequest extends WorkRequest{
    
    private Prescription prescription;
    private Visit visit;
    
    public MedicineWorkRequest() {
        prescription= new Prescription();
        visit= new Visit();
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
   
    
    
}
