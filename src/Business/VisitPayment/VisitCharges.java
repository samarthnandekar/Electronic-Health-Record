/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VisitPayment;

import Business.PatientVisit.Visit;

/**
 *
 * @author samar
 */
public class VisitCharges {
 
    private Visit visit;
    private String paymentDate;
    private PaymentStatus paymentStatus;
    private String billGenerateDate;
    private int patientVisitCharge;

    
    public enum PaymentStatus{
        BillGenerated("BillGenerated"),
        BillReceived("BillReceived");
        
        private String value;
        private PaymentStatus(String value){
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
 
    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    
    

    public String getBillGenerateDate() {
        return billGenerateDate;
    }

    public void setBillGenerateDate(String billGenerateDate) {
        this.billGenerateDate = billGenerateDate;
    }

    public int getPatientVisitCharge() {
        return patientVisitCharge;
    }

    public void setPatientVisitCharge(int patientVisitCharge) {
        this.patientVisitCharge = patientVisitCharge;
    }
    
    
}
