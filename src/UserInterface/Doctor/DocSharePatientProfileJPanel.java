/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Doctor;

import Business.Doctor.Appointment;
import Business.Doctor.Doctor;
import Business.Doctor.DoctorDepartment;
import Business.EcoSystem;
import Business.EnterPrise.Enterprise;
import Business.EnterPrise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.PatientVisit.Visit;
import Business.PatientVisit.VisitDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PatientProfileShareWorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import sun.security.krb5.internal.crypto.Des3;

/**
 *
 * @author samar
 */
public class DocSharePatientProfileJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DocSharePatientProfileJPanel
     */
    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem ecoSystem;
    private Doctor currDoctor;
    private Enterprise cuurentuserEnterprise;
    private Network network;
    
    public DocSharePatientProfileJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.cuurentuserEnterprise = enterprise;
        this.userAccount = account;
        this.ecoSystem = ecoSystem;
        this.enterprise = enterprise;
        getDoctorPatientName();
        populateNetwork();
        populateHospitals();
    }
    
    private void populateNetwork()
    {
       selectNetwork.removeAllItems();
        
        for (Network network : ecoSystem.getNetworkList().getNetworkList()) {
            
                    selectNetwork.addItem(network);
        }
    }
    
    private void populateHospitals() {
        hospitalComboBox.removeAllItems();
        
        for (Network network : ecoSystem.getNetworkList().getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterPriseList()) {
                if (enterprise instanceof HospitalEnterprise) {
                    hospitalComboBox.addItem(enterprise);
                }
                
            }
        }
    }
    
    public void getDoctorPatientName() {
        System.out.println("=====inside the doctor patient record=============");
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
        VisitDirectory visitList = currDoctor.getVisitList();
        System.out.println("currDoctor.getVisitList().getVisitList().size();-->" + currDoctor.getVisitList().getVisitList().size());
        List<Integer> allPatientName = new ArrayList<>();
        for (Visit visit : visitList.getVisitList()) {
            Integer tempuserID = visit.getPatient().getPatinetID();
            allPatientName.add(tempuserID);
        }
        LinkedHashSet<Integer> uniquePatientList = new LinkedHashSet<>();
        uniquePatientList.addAll(allPatientName);
        allPatientName.clear();
        allPatientName.addAll(uniquePatientList);
        populatePatientTable(allPatientName);
        System.out.println("---all patient name--->" + allPatientName.size());
    }
    
    public void populatePatientTable(List allPatientName) {
        DefaultTableModel model = (DefaultTableModel) doctorPatientNameTable.getModel();
        model.setRowCount(0);
        System.out.println("---all patient name---in populateTabel>" + allPatientName.size());
        if (enterprise instanceof HospitalEnterprise) {
            HospitalEnterprise hospitalEnterprise = (HospitalEnterprise) enterprise;
            ArrayList<Patient> patientList = hospitalEnterprise.getPatientDirectory().getPatientList();
            for (int i = 0; i < allPatientName.size(); i++) {
                Integer patientid = (Integer) allPatientName.get(i);
                for (Patient patient : patientList) {
                    if (patient.getPatinetID() == patientid) {
                        
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
        jLabel2 = new javax.swing.JLabel();
        hospitalComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        docDepartmentcomBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        doctorNameTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        backJButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        reasonforShareTxt = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        selectNetwork = new javax.swing.JComboBox();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Share Patient Profile");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Note:-Patient profiles");

        hospitalComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        hospitalComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hospitalComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Select Hospital:");

        docDepartmentcomBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        docDepartmentcomBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docDepartmentcomBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Select Department:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Select Doctor from below Table:");

        doctorNameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Doctor Name", "Speciality"
            }
        ));
        jScrollPane2.setViewportView(doctorNameTable);

        jButton1.setText("Raise Share Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        backJButton2.setText("<< Back");
        backJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton2ActionPerformed(evt);
            }
        });

        reasonforShareTxt.setColumns(20);
        reasonforShareTxt.setRows(5);
        jScrollPane3.setViewportView(reasonforShareTxt);

        jLabel6.setText("Please Specify Reson:");

        jLabel7.setText("Select Network:");

        selectNetwork.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectNetworkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(611, 611, 611)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(452, 452, 452)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(backJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(523, 523, 523)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane3))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(621, 621, 621)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(572, 572, 572)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(39, 39, 39)
                                .addComponent(docDepartmentcomBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hospitalComboBox, 0, 173, Short.MAX_VALUE)
                                    .addComponent(selectNetwork, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(542, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(selectNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hospitalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(docDepartmentcomBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))))
        );
    }// </editor-fold>//GEN-END:initComponents
public void populateDoctorList(DoctorDepartment doctorDepartment) {
        DefaultTableModel model = (DefaultTableModel) doctorNameTable.getModel();
        model.setRowCount(0);
        for (Doctor doctor : doctorDepartment.getDoctorDirectory().getDoctorList()) {
            Object row[] = new Object[3];
            row[0] = doctor;
            row[1] = doctor.getDocEducation();
            model.addRow(row);
        }
    }
    
    public void populateDoctorDepartmentComboBox(Enterprise enterprise) {
        
        docDepartmentcomBox.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof DoctorOrganization) {
                DoctorOrganization doctorOrganization = (DoctorOrganization) organization;
                for (DoctorDepartment doctorDepartment : doctorOrganization.getDoctorDepartmentCatalog().getDoctorDepartmentCatalog()) {
                    docDepartmentcomBox.addItem(doctorDepartment);
                }
                
            }
        }
    }

    public void populateHospitalEnterprise(Network network)
    {
       hospitalComboBox.removeAllItems();
       
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterPriseList()) {
                if (enterprise instanceof HospitalEnterprise) {
                    hospitalComboBox.addItem(enterprise);
                }
                
            }
         
    }    
    private void hospitalComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hospitalComboBoxActionPerformed
        enterprise = (Enterprise) hospitalComboBox.getSelectedItem();
        if (enterprise != null) {
            populateDoctorDepartmentComboBox(enterprise);
        }
    }//GEN-LAST:event_hospitalComboBoxActionPerformed

    private void docDepartmentcomBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docDepartmentcomBoxActionPerformed
        DoctorDepartment doctorDepartment = (DoctorDepartment) docDepartmentcomBox.getSelectedItem();
        if (doctorDepartment != null) {
            populateDoctorList(doctorDepartment);
        }
    }//GEN-LAST:event_docDepartmentcomBoxActionPerformed

    private void backJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton2ActionPerformed
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int patientSelectedRow = doctorPatientNameTable.getSelectedRow();
        int docSelectedRow = doctorNameTable.getSelectedRow();
        String strReasonforShareTxt = reasonforShareTxt.getText();
        
        if (patientSelectedRow >= 0) {
            
            Patient patient = (Patient) doctorPatientNameTable.getValueAt(patientSelectedRow, 0);
            
            if (docSelectedRow >= 0) {
                Doctor doctorReceive = (Doctor) doctorNameTable.getValueAt(docSelectedRow, 0);
                
                PatientProfileShareWorkRequest patientProfileShareWorkRequest = new PatientProfileShareWorkRequest();
                patientProfileShareWorkRequest.setSender(currDoctor);
                Date todaye = new Date();
                patientProfileShareWorkRequest.setRequestDate(todaye);
                patientProfileShareWorkRequest.setPatient(patient);
                patientProfileShareWorkRequest.setMessage("strReasonforShareTxt");
                patientProfileShareWorkRequest.setDoctorReceiver(doctorReceive);
                
                network = (Network) selectNetwork.getSelectedItem();
                if (network != null) {
                    patientProfileShareWorkRequest.setReceiverDoctorNetwork(network);
                }
                
                enterprise = (Enterprise) hospitalComboBox.getSelectedItem();
                if (enterprise != null) {
                    patientProfileShareWorkRequest.setReceiverDocenterprise(enterprise);
                }
                
                System.out.println(" patient mrn-->" + patient.getMrn());
                //System.out.println("patientUserAccount.getPatient().getMrn()-->"+patientUserAccount.getPatient().getMrn());

                //code to find patient user Account
                for (UserAccount patientUserAccount : cuurentuserEnterprise.getUserAccountDirectory().getUserAccountList()) {
                    System.out.println("userAccount name--->" + patientUserAccount.getUsername());
                    if (patientUserAccount.getPatient() != null) {
                        System.out.println("====================================inside the patient condition===============");
                        if (patientUserAccount.getPatient().getUsername().equalsIgnoreCase(patient.getUsername())) {
                            System.out.println("patientUserAccount.getPatient().getMrn()-->" + patientUserAccount.getPatient().getMrn());
                            patientUserAccount.getWorkQueue().getWorkRequestList().add(patientProfileShareWorkRequest);
                            System.out.println("patientUserAccount--->" + patientUserAccount.getUsername());
                            patientProfileShareWorkRequest.setReceiver(patientUserAccount);
                            JOptionPane.showMessageDialog(null, "Request Raised");
                        }
                        
                    }
                    
                }
                
                userAccount.getWorkQueue().getWorkRequestList().add(patientProfileShareWorkRequest);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a Doctor");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Please select one patient");
            
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void selectNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectNetworkActionPerformed
        network = (Network) selectNetwork.getSelectedItem();
        if (network != null) {
            populateHospitalEnterprise(network);
        }
    }//GEN-LAST:event_selectNetworkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton2;
    private javax.swing.JComboBox docDepartmentcomBox;
    private javax.swing.JTable doctorNameTable;
    private javax.swing.JTable doctorPatientNameTable;
    private javax.swing.JComboBox hospitalComboBox;
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
    private javax.swing.JTextArea reasonforShareTxt;
    private javax.swing.JComboBox selectNetwork;
    // End of variables declaration//GEN-END:variables
}
