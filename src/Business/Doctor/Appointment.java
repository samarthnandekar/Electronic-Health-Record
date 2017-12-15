/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

import Business.Patient.Patient;

/**
 *
 * @author Samarth
 */
public class Appointment {

    private Doctor doctor;
    private String timeSlot;
    private String date;
    private AppointmentStatus appointmentStatus;
    private Patient patient;
    private static int appCounter = 0;
    private int appoinmentID;

    public Appointment() {
        appCounter++;
        appoinmentID=appCounter;
    }

    public enum AppointmentStatus {

        Open("Open"),
        Submitted("Submitted"),
        Booked("Booked"),
        Canceled("Canceled");

        private String value;

        private AppointmentStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getAppoinmentID() {
        return appoinmentID;
    }

    public void setAppoinmentID(int appoinmentID) {
        this.appoinmentID = appoinmentID;
    }

    @Override
    public String toString() {
        return date;
    }

}
