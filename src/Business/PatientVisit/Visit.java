/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientVisit;

import Business.Doctor.Doctor;
import Business.Patient.Patient;
import Business.PatientGraphReport.GraphicReportList;
import Business.VisitPayment.VisitCharges;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samarth
 */
public class Visit {
    //List<VitalSign> vitals = new ArrayList();
    private Prescription prescription;
    private VitalSign pvitalSign;
    private AllergyList allergyList;
    //private MedicationList medicationList;
    private String comment;
    private VisitType visitType;
    private String admitDate;
    private String dischargeDate;
    private String appointmentDate;
    private Doctor doctor;
    private Patient patient;
    private VisitCharges visitCharges;
    private GraphicReportList graphicReportList;
    
    public Visit() {
       prescription= new Prescription();
      allergyList= new AllergyList();
      pvitalSign= new VitalSign();
      visitCharges= new VisitCharges();
      graphicReportList= new GraphicReportList();
    }
   
    public enum VisitType{
        IP("InPatient"),
        ER("Emergency"),
        OP("OutPatient");
        
        private String value;
        private VisitType(String value){
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

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public VitalSign getPvitalSign() {
        return pvitalSign;
    }

    public void setPvitalSign(VitalSign pvitalSign) {
        this.pvitalSign = pvitalSign;
    }

    public AllergyList getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(AllergyList allergyList) {
        this.allergyList = allergyList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public VisitType getVisitType() {
        return visitType;
    }

    public void setVisitType(VisitType visitType) {
        this.visitType = visitType;
    }

    public String getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(String admitDate) {
        this.admitDate = admitDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public VisitCharges getVisitCharges() {
        return visitCharges;
    }

    public void setVisitCharges(VisitCharges visitCharges) {
        this.visitCharges = visitCharges;
    }

    public GraphicReportList getGraphicReportList() {
        return graphicReportList;
    }

    public void setGraphicReportList(GraphicReportList graphicReportList) {
        this.graphicReportList = graphicReportList;
    }

   
    
    
    
    @Override
    public String toString()
    {
        return appointmentDate;
    }
}
