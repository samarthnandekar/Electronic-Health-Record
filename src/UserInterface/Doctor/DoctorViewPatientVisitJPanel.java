/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Doctor;

import Business.Doctor.Appointment;
import Business.Doctor.AppointmentDirectory;
import Business.Doctor.Doctor;
import Business.Doctor.DoctorDepartment;
import Business.EcoSystem;
import Business.EnterPrise.Enterprise;
import Business.EnterPrise.HospitalEnterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.PatientVisit.MedicationList;
import Business.PatientVisit.Visit;
import Business.PatientVisit.VisitDirectory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samar
 */
public class DoctorViewPatientVisitJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorViewPatientVisitJPanel
     */
    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem ecoSystem;
    private Doctor currDoctor;
    private MedicationList medicationList;
    private Patient patient;

    public DoctorViewPatientVisitJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.ecoSystem = ecoSystem;

        getDoctorPatientName();
    }

    public void getDoctorPatientName() {
        String currUserString = userAccount.getUsername();
        if (organization instanceof DoctorOrganization) {
            DoctorOrganization doctorOrganization = (DoctorOrganization) organization;
            for (DoctorDepartment doctorDepartment : doctorOrganization.getDoctorDepartmentCatalog().getDoctorDepartmentCatalog()) {
                System.out.println("docdepatment Name--->" + doctorDepartment.getDoctorDepartmentName());
                for (Doctor doctor : doctorDepartment.getDoctorDirectory().getDoctorList()) {
                    System.out.println("doc name--->" + doctor.getDocUserName());
                    System.out.println("user account name-->" + userAccount.getUsername());
                    if (doctor.getDocUserName() != null) {
                        if (doctor.getDocUserName().equals(userAccount.getUsername())) {
                            currDoctor = doctor;
                        }
                    }

                }
            }

        }

        AppointmentDirectory AppointmentList = currDoctor.getAppointmentList();
        System.out.println("currDoctor.getVisitList().getVisitList().size();-->" + currDoctor.getVisitList().getVisitList().size());
        //List<Integer> allPatientName = new ArrayList<>();
        List<String> allPatientName = new ArrayList<>();
        for (Appointment appointment : AppointmentList.getAppointmentList()) {
            if (appointment.getPatient() != null) {
                String tempUserName = appointment.getPatient().getUsername();
                allPatientName.add(tempUserName);
            }

        }
        LinkedHashSet<String> uniquePatientList = new LinkedHashSet<>();
        uniquePatientList.addAll(allPatientName);
        allPatientName.clear();
        allPatientName.addAll(uniquePatientList);

        populatePatientTable(allPatientName);
    }

    public void populatePatientTable(List allPatientName) {
        DefaultTableModel model = (DefaultTableModel) doctorPatientNameTable.getModel();
        model.setRowCount(0);
        if (enterprise instanceof HospitalEnterprise) {
            HospitalEnterprise hospitalEnterprise = (HospitalEnterprise) enterprise;
            ArrayList<Patient> patientList = hospitalEnterprise.getPatientDirectory().getPatientList();
            for (int i = 0; i < allPatientName.size(); i++) {
                String patientUserName = (String) allPatientName.get(i);
                for (Patient patient : patientList) {
                    if (patient.getUsername().equalsIgnoreCase(patientUserName)) {

                        Object[] row = new Object[5];
                        row[0] = patient;
                        row[1] = patient.getMrn();
                        row[2] = patient.getPhoneNo();
                        row[3] = patient.getEmailID();
                        model.addRow(row);
                    }
                }
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
        doctorPatientNameTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Select Patient Record to View Patient History");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 51, 427, 33));

        doctorPatientNameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Patient Name", "MRN", "Mobile No", "Email ID"
            }
        ));
        jScrollPane1.setViewportView(doctorPatientNameTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 153, 699, 128));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 638, 101, 35));

        jButton1.setText("View Patient Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 375, -1, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int selectedRow = doctorPatientNameTable.getSelectedRow();

        if (selectedRow >= 0) {
            patient = (Patient) doctorPatientNameTable.getValueAt(selectedRow, 0);
        } else {
            JOptionPane.showMessageDialog(null, "Please select Appointment first");
        }

        DoctorViewPatientVisitDetailsJPanel doctorViewPatientVisitDetailsJPanel = new DoctorViewPatientVisitDetailsJPanel(userProcessContainer, userAccount, patient);
        userProcessContainer.add("DoctorViewPatientVisitDetailsJPanel", doctorViewPatientVisitDetailsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTable doctorPatientNameTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
