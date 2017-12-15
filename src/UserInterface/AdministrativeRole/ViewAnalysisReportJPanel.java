/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeRole;

import Business.Doctor.Doctor;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.EnterPrise.Enterprise;
import Business.EnterPrise.HospitalEnterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.VisitPayment.VisitCharges;
import Business.VisitPayment.VisitPaymentList;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samar
 */
public class ViewAnalysisReportJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAnalysisReportJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    private UserAccount userAccount;
    private Organization organization;

    public ViewAnalysisReportJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization org, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        this.organization = org;
        this.userAccount = userAccount;
        calculateOrgEmployee();
        calculateTotalPatient();
        calulateDoctorsVisit();
        calculatePatientVisits();
        calculatepatientBill();
        calculateNoOFAppointsofPatients();

    }

    public void calculateNoOFAppointsofPatients() {
        DefaultTableModel dtm = (DefaultTableModel) patientNoofVisits.getModel();
        dtm.setRowCount(0);

        if (enterprise instanceof HospitalEnterprise) {
            HospitalEnterprise hospitalEnterprise = (HospitalEnterprise) enterprise;
            for (Patient patient : hospitalEnterprise.getPatientDirectory().getPatientList()) {
                Object row[] = new Object[2];
                row[0] = patient.getFirstName() + " " + patient.getLastName();
                row[1] = patient.getAppointmentDirectory().getAppointmentList().size();
                dtm.addRow(row);
            }

        }

    }

    public void calculateOrgEmployee() {
        DefaultTableModel dtm = (DefaultTableModel) noOfEmpInOrgTable.getModel();
        dtm.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            Object row[] = new Object[2];
            row[0] = organization.getOrgName();
            row[1] = organization.getUserAccountDirectory().getUserAccountList().size();
            dtm.addRow(row);
        }
    }

    public void calculateTotalPatient() {
        DefaultTableModel dtm = (DefaultTableModel) totalNoPatientTable.getModel();
        dtm.setRowCount(0);

        if (enterprise instanceof HospitalEnterprise) {
            HospitalEnterprise hospitalEnterprise = (HospitalEnterprise) enterprise;

            Object row[] = new Object[2];
            row[0] = hospitalEnterprise.getPatientDirectory().getPatientList().size();
            dtm.addRow(row);
        }

    }

    public void calulateDoctorsVisit() {
        DefaultTableModel dtm = (DefaultTableModel) doctorVisitTable.getModel();
        dtm.setRowCount(0);

        if (enterprise instanceof HospitalEnterprise) {
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof DoctorOrganization) {
                    for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                        Employee emp = userAccount.getEmployee();
                        Doctor doctor = (Doctor) emp;

                        Object row[] = new Object[2];
                        row[0] = doctor;
                        row[1] = doctor.getVisitList().getVisitList().size();
                        dtm.addRow(row);
                    }
                }
            }

        }

    }

    public void calculatePatientVisits() {
        DefaultTableModel dtm = (DefaultTableModel) PatientVisitCount.getModel();
        dtm.setRowCount(0);
        if (enterprise instanceof HospitalEnterprise) {
            HospitalEnterprise hospitalEnterprise = (HospitalEnterprise) enterprise;
            for (Patient patient : hospitalEnterprise.getPatientDirectory().getPatientList()) {
                Object row[] = new Object[2];
                row[0] = patient.getFirstName() + " " + patient.getLastName();
                row[1] = patient.getVisitDirectory().getVisitList().size();
                dtm.addRow(row);
            }
        }
    }

    public void calculatepatientBill() {
        DefaultTableModel dtm = (DefaultTableModel) patientBillPaymentTable.getModel();
        dtm.setRowCount(0);
        int totalbill = 0;
        if (enterprise instanceof HospitalEnterprise) {
            HospitalEnterprise hospitalEnterprise = (HospitalEnterprise) enterprise;
            for (Patient patient : hospitalEnterprise.getPatientDirectory().getPatientList()) {
                Object row[] = new Object[2];
                row[0] = patient.getFirstName() + " " + patient.getLastName();
                System.out.println("patient.getVisitPaymentList().getVisitPaymentList()-->"+patient.getVisitPaymentList().getVisitPaymentList().size());
                for (VisitCharges visitCharges : patient.getVisitPaymentList().getVisitPaymentList()) {
                    totalbill = totalbill + visitCharges.getPatientVisitCharge();
                    System.out.println("visitCharges.getPatientVisitCharge()-->"+visitCharges.getPatientVisitCharge());
                }
                row[1] = totalbill;
                dtm.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        totalNoPatientTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        noOfEmpInOrgTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        doctorVisitTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        PatientVisitCount = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        patientBillPaymentTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        patientNoofVisits = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Analytics Report");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        totalNoPatientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Number Of Patient"
            }
        ));
        jScrollPane1.setViewportView(totalNoPatientTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 160, 100));

        noOfEmpInOrgTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name Organization", "Number Of Emp"
            }
        ));
        jScrollPane2.setViewportView(noOfEmpInOrgTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Number Of Employees in Organization");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Number Of patient:-");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, 20));

        doctorVisitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Doctor Name", "No of Visits"
            }
        ));
        jScrollPane3.setViewportView(doctorVisitTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 460, 100));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Number of Visits of each Doctor:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Number of Visit of each Patients:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 500, -1, 20));

        PatientVisitCount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Patient Name", "No of Visits"
            }
        ));
        jScrollPane4.setViewportView(PatientVisitCount);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 530, -1, 100));

        patientBillPaymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "patient Name", "Money Paid"
            }
        ));
        jScrollPane5.setViewportView(patientBillPaymentTable);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, -1, 100));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Patient payment Details");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, -1, -1));

        patientNoofVisits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Patient Name", "No of visits"
            }
        ));
        jScrollPane6.setViewportView(patientNoofVisits);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, -1, 100));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Number of Appointments of each Patient");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 300, -1, -1));

        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, 100, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PatientVisitCount;
    private javax.swing.JTable doctorVisitTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable noOfEmpInOrgTable;
    private javax.swing.JTable patientBillPaymentTable;
    private javax.swing.JTable patientNoofVisits;
    private javax.swing.JTable totalNoPatientTable;
    // End of variables declaration//GEN-END:variables
}
