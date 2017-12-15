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
public class VitalSign {

     private float RespiratoryRate;
     private float HeartRate;
     private float bloodPressure;
     private float weight;
     private String vitalCapDate;
     public double latitude;
    public double longitude;
             
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

    public String getVitalCapDate() {
        return vitalCapDate;
    }

    public void setVitalCapDate(String vitalCapDate) {
        this.vitalCapDate = vitalCapDate;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    

   @Override
   public String toString()
   {
       return vitalCapDate;
   }
    
}
