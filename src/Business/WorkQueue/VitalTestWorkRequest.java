/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.PatientVisit.Visit;

/**
 *
 * @author Samarth
 */
public class VitalTestWorkRequest extends WorkRequest{
    
    private float RespiratoryRate;
    private float HeartRate;
    private float bloodPressure;
    private float weight;
    private Visit visit;
    
    public VitalTestWorkRequest()
    {
        visit= new Visit();
    }
    public float getRespiratoryRate() {
        return RespiratoryRate;
    }

    public void setRespiratoryRate(float RespiratoryRate) {
        this.RespiratoryRate = RespiratoryRate;
    }

    public float getHeartRate() {
        return HeartRate;
    }

    public void setHeartRate(float HeartRate) {
        this.HeartRate = HeartRate;
    }

    public float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
    
     @Override
    public String toString()
    {
        return super.getSender().getFirstName()+" "+super.getSender().getLastName();
    }
    
}
