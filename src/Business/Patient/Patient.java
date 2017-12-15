/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Doctor.AppointmentDirectory;
import Business.PatientRoomVitalSign.PatientRoomVitalSignList;
import Business.PatientVisit.AllergyList;
import Business.PatientVisit.VisitDirectory;
import Business.PatientVisit.VitalSignList;
import Business.Person.Person;
import Business.VisitPayment.VisitPaymentList;
import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class Patient extends Person{
 
    private VisitDirectory visitDirectory;
    private AllergyList allergyList;
    private int patinetID;
    private static int patientCount=0;
    private String mrn;
    private VitalSignList vitalList;
    private AppointmentDirectory appointmentDirectory;   
    private VisitPaymentList visitPaymentList;
    private PatientRoomVitalSignList patientRoomVitalSignList;
    
    
    public Patient()
    {
        patientCount=patientCount++;
        patinetID=patientCount;
        mrn="A"+patientCount;
        appointmentDirectory = new AppointmentDirectory();
        allergyList= new AllergyList();
        visitDirectory= new VisitDirectory();
        vitalList= new VitalSignList();
        visitPaymentList= new VisitPaymentList();
        patientRoomVitalSignList= new PatientRoomVitalSignList();
    }

    public VitalSignList getVitalList() {
        return vitalList;
    }

    public void setVitalList(VitalSignList vitalList) {
        this.vitalList = vitalList;
    }

    
    public VisitDirectory getVisitDirectory() {
        return visitDirectory;
    }

    public void setVisitDirectory(VisitDirectory visitDirectory) {
        this.visitDirectory = visitDirectory;
    }

    public AllergyList getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(AllergyList allergyList) {
        this.allergyList = allergyList;
    }

    public int getPatinetID() {
        return patinetID;
    }

    public void setPatinetID(int patinetID) {
        this.patinetID = patinetID;
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public AppointmentDirectory getAppointmentDirectory() {
        return appointmentDirectory;
    }

    public void setAppointmentDirectory(AppointmentDirectory appointmentDirectory) {
        this.appointmentDirectory = appointmentDirectory;
    }

    public VisitPaymentList getVisitPaymentList() {
        return visitPaymentList;
    }

    public void setVisitPaymentList(VisitPaymentList visitPaymentList) {
        this.visitPaymentList = visitPaymentList;
    }

    public PatientRoomVitalSignList getPatientRoomVitalSignList() {
        return patientRoomVitalSignList;
    }

    public void setPatientRoomVitalSignList(PatientRoomVitalSignList patientRoomVitalSignList) {
        this.patientRoomVitalSignList = patientRoomVitalSignList;
    }
    
    
}
