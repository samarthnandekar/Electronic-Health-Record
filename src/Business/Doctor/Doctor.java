/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

import Business.Employee.Employee;
import Business.PatientVisit.Visit;
import Business.PatientVisit.VisitDirectory;
import Business.Person.Person;
import Business.VisitPayment.VisitCharges;
import Business.VisitPayment.VisitPaymentList;
import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class Doctor extends Employee{

    private String docEducation;
    private String docDepartment;
    private int doctorID;
    private static int doccount = 0;
    private VisitDirectory visitList;
    private AppointmentDirectory appointmentList;
    private String docUserName;
    private VisitPaymentList visitPaymentList;

    public Doctor() {
        doccount++;
        doctorID = doccount;
        appointmentList = new AppointmentDirectory();
        visitList = new VisitDirectory();
        visitPaymentList = new VisitPaymentList();

    }

    public String getDocEducation() {
        return docEducation;
    }

    public void setDocEducation(String docEducation) {
        this.docEducation = docEducation;
    }

    public String getDocDepartment() {
        return docDepartment;
    }

    public void setDocDepartment(String docDepartment) {
        this.docDepartment = docDepartment;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public VisitDirectory getVisitList() {
        return visitList;
    }

    public void setVisitList(VisitDirectory visitList) {
        this.visitList = visitList;
    }

    public AppointmentDirectory getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(AppointmentDirectory appointmentList) {
        this.appointmentList = appointmentList;
    }

    public String getDocUserName() {
        return docUserName;
    }

    public void setDocUserName(String docUserName) {
        this.docUserName = docUserName;
    }

    @Override
    public String toString() {
        return getFirstName();
    }
    // check above code
}
