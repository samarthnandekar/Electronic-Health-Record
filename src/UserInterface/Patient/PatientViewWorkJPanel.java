/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Patient;

import Business.Doctor.Doctor;
import Business.EcoSystem;
import Business.EnterPrise.Enterprise;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PatientProfileShareWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samar
 */
public class PatientViewWorkJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientViewWorkJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    private UserAccount userAccount;
    private Organization organization;

    public PatientViewWorkJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization org, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        this.organization = org;
        this.userAccount = userAccount;

        populatePatientWorkRequest();
    }

    public void populatePatientWorkRequest() {

        DefaultTableModel model = (DefaultTableModel) patientWorkRequestTable.getModel();
        System.out.println("--above the set sezo---------");
        model.setRowCount(0);
        System.out.println("userAccount.getWorkQueue()----->"+userAccount.getUsername());
        System.out.println("userAccount.getWorkQueue().getWorkRequestList()-->"+userAccount.getWorkQueue().getWorkRequestList().size());
        for (WorkRequest workRequest : userAccount.getWorkQueue().getWorkRequestList()) {
            Object row[] = new Object[14];
            if(workRequest instanceof PatientProfileShareWorkRequest)
            {
            
            PatientProfileShareWorkRequest patientProfileShareWorkRequest=(PatientProfileShareWorkRequest)workRequest;
            
            row[0] = patientProfileShareWorkRequest;
            row[1] = patientProfileShareWorkRequest.getRequestDate();
            
            // patient approve details
            row[2] = patientProfileShareWorkRequest.getPatient();
            row[3] = patientProfileShareWorkRequest.getResolveDate();
            row[4] = patientProfileShareWorkRequest.getPatientApproveStatus();
            
            // Second Approver Details
            row[5] = patientProfileShareWorkRequest.getSecondReceiver();
            row[6] = patientProfileShareWorkRequest.getSecondReceiverDate();
            row[7] = patientProfileShareWorkRequest.getSecondApproverStatus();
            
            // Third Approver Dateils
            //row[8] = patientProfileShareWorkRequest.getThirdReceiver();
            row[8] = patientProfileShareWorkRequest.getThirdReceiverDate();
            row[9] = patientProfileShareWorkRequest.getThirdApproverStatus();
            
            // final doctor Details
            row[10] = patientProfileShareWorkRequest.getDoctorReceiver();
            row[11] = patientProfileShareWorkRequest.getFinalDocReceiverStatus();
            row[12] = patientProfileShareWorkRequest.getFinalDocReceivedDate();
            
          
            model.addRow(row);
            }
        }
    }
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientWorkRequestTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Patient Work Request");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        patientWorkRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Request Raised by", "Raised Date", "Patient Profile name", "Patient approval Date", "Patient Status", "Hospital Enterprise Approver Date", "Approve Date", "Enterprise Status", "Eco System approver Date", "Eco System approver Status", "Receiver Doctor ", "Status", "Receiver Doctor Date"
            }
        ));
        jScrollPane1.setViewportView(patientWorkRequestTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1620, 100));

        jButton1.setText("Approve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 100, 35));

        jButton2.setText("Reject");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 100, 35));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 638, 101, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int patientSelectedRow = patientWorkRequestTable.getSelectedRow();
        if (patientSelectedRow >= 0) {

            PatientProfileShareWorkRequest patientProfileShareWorkRequest= (PatientProfileShareWorkRequest) patientWorkRequestTable.getValueAt(patientSelectedRow, 0);
            if(patientProfileShareWorkRequest.getPatientApproveStatus()==null)
            {
            Date todayDate= new Date();
            patientProfileShareWorkRequest.setPatientApproveStatus("Approved");
            patientProfileShareWorkRequest.setResolveDate(todayDate);
            
            enterprise.getWorkQueue().getWorkRequestList().add(patientProfileShareWorkRequest);
            System.out.println("enterprise--->"+enterprise.getOrgName());
            System.out.println("enterprise.getWorkQueue().getWorkRequestList()-->"+enterprise.getWorkQueue().getWorkRequestList().size());
            JOptionPane.showMessageDialog(null, "Request approved");
            populatePatientWorkRequest(); 
            }
            else
            {
                JOptionPane.showMessageDialog(null, "This is already processed request");
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a Request");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int patientSelectedRow = patientWorkRequestTable.getSelectedRow();
        if (patientSelectedRow >= 0) {

            PatientProfileShareWorkRequest patientProfileShareWorkRequest= (PatientProfileShareWorkRequest) patientWorkRequestTable.getValueAt(patientSelectedRow, 0);
            if(patientProfileShareWorkRequest.getPatientApproveStatus()==null)
            {
              Date todayDate= new Date();
            patientProfileShareWorkRequest.setPatientApproveStatus("Reject");
            patientProfileShareWorkRequest.setResolveDate(todayDate);
             JOptionPane.showMessageDialog(null, "Request Rejected");
             populatePatientWorkRequest();  
            }
            else
            {
              JOptionPane.showMessageDialog(null, "This is already processed request");  
            }
            
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Please select a Request");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientWorkRequestTable;
    // End of variables declaration//GEN-END:variables
}
