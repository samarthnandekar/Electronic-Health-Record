/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AmbulanceReception;

import Business.EcoSystem;
import Business.EnterPrise.Enterprise;
import Business.Network.Network;
import Business.Organization.AmbulanceAssistantOrganization;
import Business.Organization.AmbulanceReceptionistOrganization;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.VitalAlertRequestToAmbulanceReception;
import Business.WorkQueue.VitalAlertTestRequestToNurse;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samar
 */
public class AmbulanceReceptionWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AmbulanceReceptionWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    private AmbulanceReceptionistOrganization AmbulanceOrganization;

    public AmbulanceReceptionWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.ecoSystem = business;
        valueLabel.setText(enterprise.getOrgName());
        populateAlertRequestTable("Sent to Amblance Receptionist");
        populateAlertRequestCombobox();
        populateCriticalAlertRequestTable("Sent to Ambulance Receptionist");
        populateCriticalAlertRequest();
    }

    public void populateAlertRequestCombobox() {
        alertRequestCombo.removeAllItems();
        alertRequestCombo.addItem("Sent to Ambulance Receptionist");
        alertRequestCombo.addItem("Sent to Nurse");
        alertRequestCombo.addItem("Sent to Ambulance Assistant");
        alertRequestCombo.addItem("Accepted by Ambulance Assistants");

    }

    public void populateCriticalAlertRequest() {
        crtiticalAlertCombox.removeAllItems();
        crtiticalAlertCombox.addItem("Sent to Ambulance Receptionist");
        crtiticalAlertCombox.addItem("Sent to Ambulance Assistant");
        crtiticalAlertCombox.addItem("Accepted by Ambulance Assistants");
    }

    public void populateAlertRequestTable(String requestStatus) {
        DefaultTableModel model = (DefaultTableModel) alertRequestTable.getModel();
        model.setRowCount(0);

        for (Organization organizationTemp : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organizationTemp instanceof AmbulanceReceptionistOrganization) {
                AmbulanceOrganization = (AmbulanceReceptionistOrganization) organizationTemp;
                System.out.println("--- in side the generateVisitPaymentRequest222222 ------------ ");
                break;

            }
        }

        System.out.println("===above the work q===");
        System.out.println("===above AmbulanceOrganization===" + AmbulanceOrganization.getOrgName());
        WorkQueue workQueue = AmbulanceOrganization.getWorkQueue();
        System.out.println("workQueue.getWorkRequestList().size()-->" + workQueue.getWorkRequestList().size());
        for (WorkRequest request : workQueue.getWorkRequestList()) {
            System.out.println("===above the instance of ===");
            if (request instanceof VitalAlertTestRequestToNurse) {
                System.out.println("===above the if condition4444===");
                VitalAlertTestRequestToNurse vATRTNurse = (VitalAlertTestRequestToNurse) request;
                System.out.println("===above the if condition===");
                System.out.println("requestStatus===" + requestStatus);
                System.out.println("vATRTNurse.getStatus==>" + vATRTNurse.getStatus());
                if (requestStatus.equalsIgnoreCase(vATRTNurse.getStatus())) {
                    Object[] row = new Object[13];
                    row[0] = vATRTNurse;
                    Date date = vATRTNurse.getRequestDate();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
                    String dateinStr = simpleDateFormat.format(date);
                    row[1] = dateinStr;
                    row[2] = vATRTNurse.getMessage();

                    Person patienttemp = vATRTNurse.getSender();
                    Patient patient = (Patient) patienttemp;
                    row[3] = patient.getMrn();
                    row[4] = vATRTNurse.getStatus();
                    if (vATRTNurse.getReceiver() != null) {
                        row[5] = vATRTNurse.getReceiver().getEmployee().getFirstName() + " " + vATRTNurse.getReceiver().getEmployee().getLastName();
                        row[6] = simpleDateFormat.format(vATRTNurse.getResolveDate());
                    }

                    System.out.println("vATRTNurse.getSecondReceiver()");
                    row[7] = vATRTNurse.getSecondReceiver();
                    if (vATRTNurse.getSecondReceiverDate() != null) {
                        Date secondResDate = vATRTNurse.getSecondReceiverDate();
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
                        String dateinStrSeconRes = simpleDateFormat1.format(secondResDate);
                        row[8] = dateinStrSeconRes;
                    }

                    row[9] = vATRTNurse.getThirdReceiver();

                    if (vATRTNurse.getThirdReceiverDate() != null) {
                        Date thirdResDate = vATRTNurse.getThirdReceiverDate();
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
                        String dateinStrThirdRes = simpleDateFormat1.format(thirdResDate);
                        row[10] = dateinStrThirdRes;
                    }
                    model.addRow(row);
                }

            }
        }
    }

    public void clearText() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        alertRequestTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        notifyNextLevelBtnOne = new javax.swing.JButton();
        viewBtn1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        respRateTxt1 = new javax.swing.JTextField();
        heartRateTxt1 = new javax.swing.JTextField();
        sysBloodPresTxt1 = new javax.swing.JTextField();
        weightInPoundsTxt1 = new javax.swing.JTextField();
        alertRequestCombo = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        criticalAlertRequestTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        respRateTxt2 = new javax.swing.JTextField();
        heartRateTxt2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        viewBtn2 = new javax.swing.JButton();
        sysBloodPresTxt2 = new javax.swing.JTextField();
        weightInPoundsTxt2 = new javax.swing.JTextField();
        crtiticalAlertCombox = new javax.swing.JComboBox();
        notifyNextLevelBtn = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alertRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient Name", "Requested Date", "Message", "PatientMRN", "Status", "Receiver Name", "Receiver Date", "Ambulance Receptionist", "Ambulance Recep Request Date", "Ambulance Assistant", "Ambulance Assistant Date"
            }
        ));
        jScrollPane2.setViewportView(alertRequestTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 1200, 90));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Ambulance Receptionist Work Request");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        notifyNextLevelBtnOne.setText("Notify to Next Level");
        notifyNextLevelBtnOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notifyNextLevelBtnOneActionPerformed(evt);
            }
        });
        add(notifyNextLevelBtnOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 150, 35));

        viewBtn1.setText("View");
        viewBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtn1ActionPerformed(evt);
            }
        });
        add(viewBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 830, 90, 35));

        jLabel6.setText("Respiratory Rate:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 710, 120, -1));

        jLabel7.setText("Heart Rate:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 750, 100, -1));

        jLabel8.setText("Systolic blood Pressure:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 710, 140, -1));

        jLabel9.setText("Weight in Pounds:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 760, 110, -1));

        respRateTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respRateTxt1ActionPerformed(evt);
            }
        });
        add(respRateTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 710, 120, -1));
        add(heartRateTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 750, 120, -1));
        add(sysBloodPresTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 710, 120, -1));
        add(weightInPoundsTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 760, 120, -1));

        alertRequestCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        alertRequestCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alertRequestComboActionPerformed(evt);
            }
        });
        add(alertRequestCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 520, 160, 35));

        criticalAlertRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient Name", "Requested Date", "Message", "PatientMRN", "Status", "Ambulance Receptionist", "Receiver Date", "Ambulance Assistant", "Ambulance Recep Request Date"
            }
        ));
        jScrollPane3.setViewportView(criticalAlertRequestTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 123, 1190, 90));

        jLabel10.setText("Respiratory Rate:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 273, 120, -1));

        jLabel11.setText("Heart Rate:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 313, 100, -1));

        jLabel12.setText("Systolic blood Pressure:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 273, 140, -1));

        jLabel13.setText("Weight in Pounds:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 323, 110, -1));

        respRateTxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respRateTxt2ActionPerformed(evt);
            }
        });
        add(respRateTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 273, 120, -1));
        add(heartRateTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 313, 120, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Critical Alert Work Request from Patient, based on Vital Sign:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        viewBtn2.setText("View");
        viewBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtn2ActionPerformed(evt);
            }
        });
        add(viewBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 90, 35));
        add(sysBloodPresTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 273, 120, -1));
        add(weightInPoundsTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 323, 120, -1));

        crtiticalAlertCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        crtiticalAlertCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crtiticalAlertComboxActionPerformed(evt);
            }
        });
        add(crtiticalAlertCombox, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 70, 230, 35));

        notifyNextLevelBtn.setText("Notify to Next Level");
        notifyNextLevelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notifyNextLevelBtnActionPerformed(evt);
            }
        });
        add(notifyNextLevelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 830, 150, 35));

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 60, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Welcome to");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("EnterPrise");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Normal WorkRequest from Patient, based on Vital Sign:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void notifyNextLevelBtnOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notifyNextLevelBtnOneActionPerformed

        int selectedRow = criticalAlertRequestTable.getSelectedRow();
        if (selectedRow >= 0) {
            VitalAlertRequestToAmbulanceReception vATRTN = (VitalAlertRequestToAmbulanceReception) criticalAlertRequestTable.getValueAt(selectedRow, 0);
            Organization org = null;

            for (Organization organizationTemp : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organizationTemp instanceof AmbulanceAssistantOrganization) {
                    org = organizationTemp;
                    System.out.println("--- in side the generateVisitPaymentRequest222222 ------------ ");
                    break;

                }
            }
            if (org != null) {
                System.out.println("--- in side the generateVisitPaymentRequest3333 ------------ ");
                Date date = new Date();
                vATRTN.setResolveDate(date);
                vATRTN.setReceiver(userAccount);
                vATRTN.setStatus("Sent to Ambulance Assistant");
                org.getWorkQueue().getWorkRequestList().add(vATRTN);
                JOptionPane.showMessageDialog(null, "Request Sent to Amblance Assistant");
                //userAccount.getWorkQueue().getWorkRequestList().add(cVCWR);
                clearTextCriticalRequest();
                System.out.println("workQueue.getWorkRequestList().size()-->" + org.getWorkQueue().getWorkRequestList().size());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select the request first");
        }
    }//GEN-LAST:event_notifyNextLevelBtnOneActionPerformed

    public void clearTextCriticalRequest() {
        respRateTxt2.setText("");
        sysBloodPresTxt2.setText("");
        heartRateTxt2.setText("");
        weightInPoundsTxt2.setText("");
    }
    private void viewBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtn1ActionPerformed

        int selectedRow = alertRequestTable.getSelectedRow();
        if (selectedRow >= 0) {
            VitalAlertTestRequestToNurse vATRTN = (VitalAlertTestRequestToNurse) alertRequestTable.getValueAt(selectedRow, 0);
            respRateTxt1.setText(String.valueOf(vATRTN.getVitalSign().getRespiratoryRate()));
            heartRateTxt1.setText(String.valueOf(vATRTN.getVitalSign().getHeartRate()));
            sysBloodPresTxt1.setText(String.valueOf(vATRTN.getVitalSign().getBloodPressure()));
            weightInPoundsTxt1.setText(String.valueOf(vATRTN.getVitalSign().getWeight()));

        } else {
            JOptionPane.showMessageDialog(null, "Please select the request first");
        }
    }//GEN-LAST:event_viewBtn1ActionPerformed

    private void respRateTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respRateTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_respRateTxt1ActionPerformed

    private void alertRequestComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alertRequestComboActionPerformed
        String requestStatus = (String) alertRequestCombo.getSelectedItem();
        System.out.println("requestStatus-->" + requestStatus);
        // below if condition to save from null value
        if (requestStatus != null) {
            if (requestStatus.equalsIgnoreCase("Sent to Ambulance Receptionist")) {
                notifyNextLevelBtn.setVisible(true);
            } else {
                notifyNextLevelBtn.setVisible(false);
            }
            if (requestStatus != null) {
                populateAlertRequestTable(requestStatus);
                System.out.println("-------Inside the select combo box========");
            }
        }
    }//GEN-LAST:event_alertRequestComboActionPerformed

    private void respRateTxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respRateTxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_respRateTxt2ActionPerformed

    private void viewBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtn2ActionPerformed

        int selectedRow = criticalAlertRequestTable.getSelectedRow();
        if (selectedRow >= 0) {
            VitalAlertRequestToAmbulanceReception vATRTN = (VitalAlertRequestToAmbulanceReception) criticalAlertRequestTable.getValueAt(selectedRow, 0);
            respRateTxt2.setText(String.valueOf(vATRTN.getVitalSign().getRespiratoryRate()));
            heartRateTxt2.setText(String.valueOf(vATRTN.getVitalSign().getHeartRate()));
            sysBloodPresTxt2.setText(String.valueOf(vATRTN.getVitalSign().getBloodPressure()));
            weightInPoundsTxt2.setText(String.valueOf(vATRTN.getVitalSign().getWeight()));

        } else {
            JOptionPane.showMessageDialog(null, "Please select the request first");
        }
    }//GEN-LAST:event_viewBtn2ActionPerformed

    public void populateCriticalAlertRequestTable(String requestStatus) {
        DefaultTableModel model = (DefaultTableModel) criticalAlertRequestTable.getModel();

        model.setRowCount(0);

        for (Organization organizationTemp : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organizationTemp instanceof AmbulanceReceptionistOrganization) {
                AmbulanceOrganization = (AmbulanceReceptionistOrganization) organizationTemp;
                System.out.println("--- in side the generateVisitPaymentRequest222222 ------------ ");
                break;

            }
        }

        WorkQueue workQueue = organization.getWorkQueue();
        System.out.println("workQueue.getWorkRequestList() size-->" + workQueue.getWorkRequestList().size());
        for (WorkRequest request : workQueue.getWorkRequestList()) {
            if (request instanceof VitalAlertRequestToAmbulanceReception) {
                VitalAlertRequestToAmbulanceReception vARTAbmuRecep = (VitalAlertRequestToAmbulanceReception) request;
                System.out.println("workQueue.getWorkRequestList() size--1111-->" + workQueue.getWorkRequestList().size());
                if (requestStatus.equals(vARTAbmuRecep.getStatus())) {
                    System.out.println("workQueue.getWorkRequestList() size--222-->" + workQueue.getWorkRequestList().size());
                    Object[] row = new Object[13];
                    row[0] = vARTAbmuRecep;
                    Date date = vARTAbmuRecep.getRequestDate();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
                    String dateinStr = simpleDateFormat.format(date);
                    row[1] = dateinStr;
                    row[2] = vARTAbmuRecep.getMessage();

                    Person patienttemp = vARTAbmuRecep.getSender();
                    Patient patient = (Patient) patienttemp;
                    row[3] = patient.getMrn();
                    row[4] = vARTAbmuRecep.getStatus();
                    if (vARTAbmuRecep.getReceiver() != null) {
                        row[5] = vARTAbmuRecep.getReceiver().getEmployee().getFirstName() + " " + vARTAbmuRecep.getReceiver().getEmployee().getLastName();
                        row[6] = simpleDateFormat.format(vARTAbmuRecep.getResolveDate());
                    }

                    row[7] = vARTAbmuRecep.getSecondReceiver();

                    if (vARTAbmuRecep.getSecondReceiverDate() != null) {
                        Date dateSecond = vARTAbmuRecep.getSecondReceiverDate();
                        SimpleDateFormat simpleDateFormatSeconnd = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
                        row[8] = simpleDateFormatSeconnd.format(dateSecond);
                    }

                    model.addRow(row);
                }

            }
        }
    }

    public void clearTextNoraml() {
        respRateTxt1.setText("");
        heartRateTxt1.setText("");
        sysBloodPresTxt1.setText("");
        weightInPoundsTxt1.setText("");
    }

    private void crtiticalAlertComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crtiticalAlertComboxActionPerformed

        String requestStatus = (String) crtiticalAlertCombox.getSelectedItem();
        System.out.println("requestStatus-->" + requestStatus);
        // below if condition to save from null value
        if (requestStatus != null) {
            if (requestStatus.equalsIgnoreCase("Sent to Ambulance Receptionist")) {
                notifyNextLevelBtnOne.setVisible(true);
            } else {
                notifyNextLevelBtnOne.setVisible(false);
            }
            populateCriticalAlertRequestTable(requestStatus);
            clearTextNoraml();
        }
    }//GEN-LAST:event_crtiticalAlertComboxActionPerformed

    private void notifyNextLevelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notifyNextLevelBtnActionPerformed
        int selectedRow = alertRequestTable.getSelectedRow();
        if (selectedRow >= 0) {
            VitalAlertTestRequestToNurse vATRTNurse = (VitalAlertTestRequestToNurse) alertRequestTable.getValueAt(selectedRow, 0);
            Organization org = null;

            for (Organization organizationTemp : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organizationTemp instanceof AmbulanceAssistantOrganization) {
                    org = organizationTemp;
                    System.out.println("--- in side the generateVisitPaymentRequest222222 ------------ ");
                    break;

                }
            }
            if (org != null) {
                System.out.println("--- in side the generateVisitPaymentRequest3333 ------------ ");
                Date date = new Date();
                vATRTNurse.setSecondReceiverDate(date);
                vATRTNurse.setSecondReceiver(userAccount);
                vATRTNurse.setStatus("Sent to Ambulance Assistant");
                org.getWorkQueue().getWorkRequestList().add(vATRTNurse);
                JOptionPane.showMessageDialog(null, "Request Sent to Amblance Assistant");
                //userAccount.getWorkQueue().getWorkRequestList().add(cVCWR);

                System.out.println("workQueue.getWorkRequestList().size()-->" + org.getWorkQueue().getWorkRequestList().size());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select the request first");
        }
    }//GEN-LAST:event_notifyNextLevelBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox alertRequestCombo;
    private javax.swing.JTable alertRequestTable;
    private javax.swing.JTable criticalAlertRequestTable;
    private javax.swing.JComboBox crtiticalAlertCombox;
    private javax.swing.JTextField heartRateTxt1;
    private javax.swing.JTextField heartRateTxt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton notifyNextLevelBtn;
    private javax.swing.JButton notifyNextLevelBtnOne;
    private javax.swing.JTextField respRateTxt1;
    private javax.swing.JTextField respRateTxt2;
    private javax.swing.JTextField sysBloodPresTxt1;
    private javax.swing.JTextField sysBloodPresTxt2;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JButton viewBtn1;
    private javax.swing.JButton viewBtn2;
    private javax.swing.JTextField weightInPoundsTxt1;
    private javax.swing.JTextField weightInPoundsTxt2;
    // End of variables declaration//GEN-END:variables
}
