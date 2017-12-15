/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Doctor.Doctor;
import Business.EnterPrise.Enterprise;
import Business.Network.Network;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author samar
 */
public class PatientProfileShareWorkRequest extends WorkRequest{
    
    private Patient patient;
    
    
    private String patientApproveStatus;
    
    private UserAccount secondReceiver;
    private Date secondReceiverDate;
    private String secondApproverStatus;
    
    private UserAccount thirdReceiver;
    private Date thirdReceiverDate;  
    private String thirdApproverStatus;
    
    private String finalDocReceiverStatus;
    private Doctor doctorReceiver;
    private Date finalDocReceivedDate;
    
    private Enterprise receiverDocenterprise;
    private Network receiverDoctorNetwork;
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public UserAccount getSecondReceiver() {
        return secondReceiver;
    }

    public void setSecondReceiver(UserAccount secondReceiver) {
        this.secondReceiver = secondReceiver;
    }

    public Date getSecondReceiverDate() {
        return secondReceiverDate;
    }

    public void setSecondReceiverDate(Date secondReceiverDate) {
        this.secondReceiverDate = secondReceiverDate;
    }

    public UserAccount getThirdReceiver() {
        return thirdReceiver;
    }

    public void setThirdReceiver(UserAccount thirdReceiver) {
        this.thirdReceiver = thirdReceiver;
    }

    public Date getThirdReceiverDate() {
        return thirdReceiverDate;
    }

    public void setThirdReceiverDate(Date thirdReceiverDate) {
        this.thirdReceiverDate = thirdReceiverDate;
    }

    public Doctor getDoctorReceiver() {
        return doctorReceiver;
    }

    public void setDoctorReceiver(Doctor doctorReceiver) {
        this.doctorReceiver = doctorReceiver;
    }

 
    
    
    public String getPatientApproveStatus() {
        return patientApproveStatus;
    }

    public void setPatientApproveStatus(String patientApproveStatus) {
        this.patientApproveStatus = patientApproveStatus;
    }

    public String getSecondApproverStatus() {
        return secondApproverStatus;
    }

    public void setSecondApproverStatus(String secondApproverStatus) {
        this.secondApproverStatus = secondApproverStatus;
    }

    public String getThirdApproverStatus() {
        return thirdApproverStatus;
    }

    public void setThirdApproverStatus(String thirdApproverStatus) {
        this.thirdApproverStatus = thirdApproverStatus;
    }

    public String getFinalDocReceiverStatus() {
        return finalDocReceiverStatus;
    }

    public void setFinalDocReceiverStatus(String finalDocReceiverStatus) {
        this.finalDocReceiverStatus = finalDocReceiverStatus;
    }

 

    public Date getFinalDocReceivedDate() {
        return finalDocReceivedDate;
    }

    public void setFinalDocReceivedDate(Date finalDocReceivedDate) {
        this.finalDocReceivedDate = finalDocReceivedDate;
    }

    public Enterprise getReceiverDocenterprise() {
        return receiverDocenterprise;
    }

    public void setReceiverDocenterprise(Enterprise receiverDocenterprise) {
        this.receiverDocenterprise = receiverDocenterprise;
    }

    public Network getReceiverDoctorNetwork() {
        return receiverDoctorNetwork;
    }

    public void setReceiverDoctorNetwork(Network receiverDoctorNetwork) {
        this.receiverDoctorNetwork = receiverDoctorNetwork;
    }
    
    
    
    
    
    
      @Override
    public String toString()
    {
        return super.getSender().toString();
       
    }

    
    
    
}
