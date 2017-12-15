/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientVisit;

import Business.Doctor.Doctor;

/**
 *
 * @author Samarth
 */
public class Medication {
    
    private String startDate;
    private Doctor doctor;
    private String endDate;
    private String medicationName;
    private String dose;
    private int totalNumberOfMedicine;
    private int forNoOfDays;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getTotalNumberOfMedicine() {
        return totalNumberOfMedicine;
    }

    public void setTotalNumberOfMedicine(int totalNumberOfMedicine) {
        this.totalNumberOfMedicine = totalNumberOfMedicine;
    }

    public int getForNoOfDays() {
        return forNoOfDays;
    }

    public void setForNoOfDays(int forNoOfDays) {
        this.forNoOfDays = forNoOfDays;
    }
    
    
    
    @Override
    public String toString()
    {
        return medicationName;
    }
    
}
