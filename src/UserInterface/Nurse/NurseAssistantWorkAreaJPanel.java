/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Nurse;

import Business.EcoSystem;
import Business.EnterPrise.Enterprise;
import Business.Network.Network;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.PatientGraphReport.GraphicReport;
import Business.PatientVisit.Visit;
import Business.PatientVisit.VitalSign;
import Business.PatientVisit.VitalSignList;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.GraphicalReportToNurse;
import Business.WorkQueue.VitalTestWorkRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samarth
 */
public class NurseAssistantWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NurseAssistantWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    private NurseOrganization nurseOrganization;
    private Network network;
    private Visit visit;
    private Patient currPatient;

    public NurseAssistantWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        userAccount = account;
        this.enterprise = enterprise;
        this.ecoSystem = business;

        if (organization instanceof NurseOrganization) {
            nurseOrganization = (NurseOrganization) organization;
        }
        populateStatusCombobox();
        saveBtn.setVisible(true);
        populateTable("Sent");
        //populateAlertRequestTable("Sent to Nurse");
        populateGraPhicRequestStatusComboBox();
        populateGrapicReportTable("Sent");
    }

    public void populateGrapicReportTable(String requestStatus) {
        DefaultTableModel model = (DefaultTableModel) graphicalWorkRequestJTable.getModel();
        model.setRowCount(0);
        WorkQueue workQueue = nurseOrganization.getWorkQueue();
        System.out.println("===inside graphocal 11======");
        for (WorkRequest request : workQueue.getWorkRequestList()) {
            System.out.println("===inside graphocal 222======");
            if (request instanceof GraphicalReportToNurse) {
                System.out.println("===inside graphocal 33333======");
                GraphicalReportToNurse graphReTNurse = (GraphicalReportToNurse) request;
                System.out.println("requestStatus--->" + requestStatus);
                System.out.println("graphReTNurse.getStatus()-->" + graphReTNurse.getStatus());
                if (requestStatus.equals(graphReTNurse.getStatus())) {
                    System.out.println("======Graph report 4444---");
                    Object[] row = new Object[8];
                    row[0] = graphReTNurse;
                    Date date = graphReTNurse.getRequestDate();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YYYY");
                    String dateinStr = simpleDateFormat.format(date);
                    row[1] = dateinStr;
                    row[2] = graphReTNurse.getStatus();
                    row[3] = graphReTNurse.getVisit().getPatient().getFirstName() + " " + graphReTNurse.getVisit().getPatient().getFirstName();
                    row[4] = graphReTNurse.getVisit().getPatient().getMrn();
                    if (graphReTNurse.getReceiver() != null) {
                        row[5] = graphReTNurse.getReceiver().getEmployee().getFirstName() + " " + graphReTNurse.getReceiver().getEmployee().getLastName();
                        row[6] = simpleDateFormat.format(graphReTNurse.getResolveDate());
                    }
                    model.addRow(row);

                }
            }
        }
    }

    public void populateStatusCombobox() {
        requestStatusComboBox.removeAllItems();
        //requestStatusComboBox.addItem("");
        requestStatusComboBox.addItem("Sent");
        requestStatusComboBox.addItem("Completed");

    }

    public void populateGraPhicRequestStatusComboBox() {
        graPhicRequestStatusComboBox.removeAllItems();
        graPhicRequestStatusComboBox.addItem("Sent");
        graPhicRequestStatusComboBox.addItem("Completed");
    }

    public void populateTable(String requestStatus) {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        WorkQueue workQueue = nurseOrganization.getWorkQueue();
        for (WorkRequest request : workQueue.getWorkRequestList()) {
            if (request instanceof VitalTestWorkRequest) {
                VitalTestWorkRequest vworkr = (VitalTestWorkRequest) request;

                if (requestStatus.equals(vworkr.getStatus())) {
                    Object[] row = new Object[8];
                    row[0] = vworkr;
                    Date date = vworkr.getRequestDate();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YYYY");
                    String dateinStr = simpleDateFormat.format(date);
                    row[1] = dateinStr;
                    row[2] = vworkr.getStatus();
                    row[3] = vworkr.getVisit().getPatient().getFirstName() + " " + vworkr.getVisit().getPatient().getFirstName();
                    row[4] = vworkr.getVisit().getPatient().getMrn();
                    if (vworkr.getReceiver() != null) {
                        row[5] = vworkr.getReceiver().getEmployee().getFirstName() + " " + vworkr.getReceiver().getEmployee().getLastName();
                        row[6] = simpleDateFormat.format(vworkr.getResolveDate());
                    }
                    model.addRow(row);
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

        saveBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        requestStatusComboBox = new javax.swing.JComboBox();
        viewBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        respRateTxt = new javax.swing.JTextField();
        heartRateTxt = new javax.swing.JTextField();
        sysBloodPresTxt = new javax.swing.JTextField();
        weightInPoundsTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        graphicalWorkRequestJTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        selectFileTxt = new javax.swing.JTextField();
        saveBtnSec = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        graPhicRequestStatusComboBox = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveBtn.setText("save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 100, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Nurse Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        requestStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        requestStatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestStatusComboBoxActionPerformed(evt);
            }
        });
        add(requestStatusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 50, 140, 35));

        viewBtn.setText("View");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });
        add(viewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, 100, 30));

        jLabel2.setText("Respiratory Rate:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, 10));

        jLabel3.setText("Heart Rate:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, -1, 10));

        jLabel4.setText("Systolic blood Pressure:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, -1, 10));

        jLabel5.setText("Weight in Pounds:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 300, -1, 10));

        respRateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respRateTxtActionPerformed(evt);
            }
        });
        add(respRateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 80, 35));
        add(heartRateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 80, 35));
        add(sysBloodPresTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 240, 80, 35));
        add(weightInPoundsTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 290, 80, 35));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Request from Doctor to take vital Sign");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, -1, 35));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Doctor Name", "Requested Date", "Requested Status", "Patient Name", "Patient MRN", "Receiver Name", "received Date"
            }
        ));
        jScrollPane2.setViewportView(workRequestJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 940, 120));

        graphicalWorkRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Doctor Name", "Requested Date", "Requested Status", "Patient Name", "Patient MRN", "Receiver Name", "received Date"
            }
        ));
        jScrollPane3.setViewportView(graphicalWorkRequestJTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 940, 130));

        jButton1.setText("Upload Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 600, -1, 35));

        selectFileTxt.setEnabled(false);
        add(selectFileTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 600, 350, 35));

        saveBtnSec.setText("Save");
        saveBtnSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnSecActionPerformed(evt);
            }
        });
        add(saveBtnSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 740, 100, 35));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Note:- Only .jpg and .ngp files accepts.");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, -1, -1));

        graPhicRequestStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        graPhicRequestStatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graPhicRequestStatusComboBoxActionPerformed(evt);
            }
        });
        add(graPhicRequestStatusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 380, 130, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void requestStatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestStatusComboBoxActionPerformed

        String requestStatus = (String) requestStatusComboBox.getSelectedItem();
        System.out.println("requestStatus-->" + requestStatus);
        // below if condition to save from null value
        if (requestStatus != null) {
            if (requestStatus.equals("Sent")) {
                saveBtn.setVisible(true);
                viewBtn.setVisible(false);
            } else {
                saveBtn.setVisible(false);
                viewBtn.setVisible(true);
            }
            if (requestStatus != null) {
                populateTable(requestStatus);
                clearText();
            }

        }

    }//GEN-LAST:event_requestStatusComboBoxActionPerformed

    private void respRateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respRateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_respRateTxtActionPerformed

    public boolean checkUserInputValue(String respiratory, String heartRate, String strSysBloodPree, String strWeightInPounds) {
        String validationerror = "Please correct the following error:";

        System.out.println("--- inside the checkusrInputValidation======");

        // validation for respiratory
        if (respiratory.trim().equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Respiratory Rate";
        }
        if (!(respiratory.trim()).equals("") && !(respiratory.trim()).equals("null")
                && !((respiratory.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "Respiratory Rate should "
                    + "contain Number only";
        }
        if (!(respiratory.equals("")) && ((respiratory.toString().trim()).matches("[0-9]*"))) {
            Float floatrespiratory = Float.parseFloat(respRateTxt.getText());
            if ((!((floatrespiratory >= 10) && (floatrespiratory <= 60)))) {
                validationerror = validationerror + "\n" + "Respiratory Rate can not be  "
                        + "less than 10 and greater than 60";
            }

        }

        // validation for heartRate
        if (heartRate.trim().equals("")) {
            validationerror = validationerror + "\n" + "Please enter the heart Rate";
        }
        if (!(heartRate.trim()).equals("") && !(heartRate.trim()).equals("null")
                && !((heartRate.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "Heart Rate should "
                    + "contain Number only";
        }
        if (!(heartRate.equals("")) && ((heartRate.toString().trim()).matches("[0-9]*"))) {
            Float floatheartRate = Float.parseFloat(heartRateTxt.getText());
            if ((!((floatheartRate >= 30) && (floatheartRate <= 300)))) {
                validationerror = validationerror + "\n" + "Heart Rate can not be  "
                        + "less than 30 and greater than 130";
            }

        }

        // validation for strSysBloodPree
        if (strSysBloodPree.trim().equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Blood pressure Rate";
        }
        if (!(strSysBloodPree.trim()).equals("") && !(strSysBloodPree.trim()).equals("null")
                && !((strSysBloodPree.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "Blood pressure should "
                    + "contain Number only";
        }
        if (!(strSysBloodPree.equals("")) && ((strSysBloodPree.toString().trim()).matches("[0-9]*"))) {
            Float floatSysBloodPree = Float.parseFloat(sysBloodPresTxt.getText());
            if ((!((floatSysBloodPree >= 40) && (floatSysBloodPree <= 400)))) {
                validationerror = validationerror + "\n" + "Blood pressure can not be  "
                        + "less than 40 and greater than 400";
            }

        }
        // validation for strWeightInPounds
        if (strWeightInPounds.trim().equals("")) {
            validationerror = validationerror + "\n" + "Please enter the weight Rate";
        }
        if (!(strWeightInPounds.trim()).equals("") && !(strWeightInPounds.trim()).equals("null")
                && !((strWeightInPounds.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "weight should "
                    + "contain Number only";
        }
        if (!(strWeightInPounds.equals("")) && ((strWeightInPounds.toString().trim()).matches("[0-9]*"))) {
            Float floatWeightInPounds = Float.parseFloat(weightInPoundsTxt.getText());
            if ((!((floatWeightInPounds >= 15) && (floatWeightInPounds <= 350)))) {
                validationerror = validationerror + "\n" + "Weight can not be  "
                        + "less than 15 and greater than 350";
            }

        }

        if (validationerror.equals("Please correct the following error:")) {
            validationerror = "Thanks for details";
            //JOptionPane.showMessageDialog(null, validationerror);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, validationerror);
            return false;
        }

    }

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            //Boolean userinputstatus=checkuserinput(respRate.getText(),hRate.getText(),sysBloodPres.getText(),weightInPounds.getText());

            boolean isUserInputValid = checkUserInputValue(respRateTxt.getText(), heartRateTxt.getText(), sysBloodPresTxt.getText(), weightInPoundsTxt.getText());

            if (isUserInputValid) {
                Float respiratory = Float.parseFloat(respRateTxt.getText());
                Float heartRate = Float.parseFloat(heartRateTxt.getText());
                Float strSysBloodPree = Float.parseFloat(sysBloodPresTxt.getText());
                Float strWeightInPounds = Float.parseFloat(weightInPoundsTxt.getText());
                System.out.println(" ----above function call------");

                VitalTestWorkRequest vitalTestWorkRequest = (VitalTestWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
                vitalTestWorkRequest.setBloodPressure(strSysBloodPree);
                vitalTestWorkRequest.setHeartRate(heartRate);
                vitalTestWorkRequest.setRespiratoryRate(respiratory);
                vitalTestWorkRequest.setWeight(strWeightInPounds);
                vitalTestWorkRequest.setStatus("Completed");
                Date resTodayDate = new Date();
                vitalTestWorkRequest.setResolveDate(resTodayDate);
                vitalTestWorkRequest.setReceiver(userAccount);

                Visit visit = vitalTestWorkRequest.getVisit();
                VitalSign vitalSign = visit.getPvitalSign();
                vitalSign.setBloodPressure(strSysBloodPree);
                vitalSign.setHeartRate(heartRate);
                vitalSign.setRespiratoryRate(respiratory);
                vitalSign.setWeight(strWeightInPounds);

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
                String currDate = sdf.format(date);

                vitalSign.setVitalCapDate(currDate);
                Patient patient = visit.getPatient();
                VitalSignList viSignList = patient.getVitalList();
                viSignList.addVitalSign(vitalSign);
                populateTable("Sent");
                clearText();

            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select the request first");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    public void clearText() {
        respRateTxt.setText("");
        heartRateTxt.setText("");
        sysBloodPresTxt.setText("");
        weightInPoundsTxt.setText("");
    }
    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            VitalTestWorkRequest vitalTestWorkRequest = (VitalTestWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            respRateTxt.setText(String.valueOf(vitalTestWorkRequest.getRespiratoryRate()));
            heartRateTxt.setText(String.valueOf(vitalTestWorkRequest.getHeartRate()));
            sysBloodPresTxt.setText(String.valueOf(vitalTestWorkRequest.getBloodPressure()));
            weightInPoundsTxt.setText(String.valueOf(vitalTestWorkRequest.getWeight()));

        } else {
            JOptionPane.showMessageDialog(null, "Please select the request first");
        }
    }//GEN-LAST:event_viewBtnActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            String filename = file.getAbsolutePath();

            int a = filename.lastIndexOf(".");
            String fileExtention = filename.substring(a, filename.length());
            System.out.println("fileExtention---->" + fileExtention);
            if (fileExtention.equalsIgnoreCase(".jpg") || fileExtention.equalsIgnoreCase(".png")) {
                selectFileTxt.setText(filename);
            } else {
                selectFileTxt.setText("");
                JOptionPane.showMessageDialog(null, "Please upload jpg and ngp file");

            }
            // need to pleace validation here

        } catch (Exception e) {
            System.out.println(" in catch section of file choose");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveBtnSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnSecActionPerformed

        int selectedRow = graphicalWorkRequestJTable.getSelectedRow();

        if (selectedRow >= 0) {

            GraphicalReportToNurse graphicalReportToNurse = (GraphicalReportToNurse) graphicalWorkRequestJTable.getValueAt(selectedRow, 0);
            if (!graphicalReportToNurse.getStatus().equalsIgnoreCase("Completed")) {

                String strFilePath = selectFileTxt.getText();
                if (!(strFilePath.equals(""))) {

                    graphicalReportToNurse.setReceiver(userAccount);
                    Date date = new Date();
                    graphicalReportToNurse.setResolveDate(date);
                    visit = graphicalReportToNurse.getVisit();
                    currPatient = visit.getPatient();
                    String userName = currPatient.getUsername();

                    String filename = selectFileTxt.getText();
                    if (filename != null) {
                        BufferedImage image = null;
                        File f = null;

                        // code to read the file
                        try {
                            System.out.println(filename);
                            f = new File(filename); //image file path
                            image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
                            image = ImageIO.read(f);
                            System.out.println("Reading complete.");
                        } catch (IOException e) {
                            System.out.println("Error: " + e);
                            JOptionPane.showMessageDialog(null, "Something went wrong, file not uploaded. please send the file by mail");
                        }

                        try {

                            // code to create foler folder first time 
                            File file = new File("C:\\Directory1");
                            if (!file.exists()) {
                                if (file.mkdir()) {
                                    System.out.println("Directory is created!");
                                } else {
                                    System.out.println("Failed to create directory!");
                                }
                            }

                            // Code to create folder for patient
                            String patientFolder = "C:\\Directory1\\" + userName + "\\";
                            File patientFile = new File(patientFolder);
                            if (!patientFile.exists()) {
                                if (patientFile.mkdir()) {
                                    System.out.println("Directory is created!");
                                } else {
                                    System.out.println("Failed to create directory!");
                                }
                            }

                            // code to check no of files in foler and according to set the file name
                            File[] noOFfiles = patientFile.listFiles();
                            int fileCount = 0;
                            if (noOFfiles != null) {
                                fileCount = noOFfiles.length;
                                System.out.println("value of a--->" + fileCount);
                            }

                            int lastone = filename.lastIndexOf("\\");
                            System.out.println(filename.length());

                            //  code to find the image name
                            String imageName = filename.substring(lastone + 1, filename.length());
                            System.out.println("tempString-->" + imageName);

                            //set new name to image
                            String changedImageName = userName + "_" + fileCount + imageName;
                            System.out.println("tempString---->" + changedImageName);

                            //final file name with full path
                            String finalImagePath = patientFolder + changedImageName;

                            // code to save file names in vital sign
                            GraphicReport graphicReport = new GraphicReport();
                            graphicReport.setImageName(changedImageName);
                            graphicReport.setImageWithPath(finalImagePath);
                            visit.getGraphicReportList().addGraphicReporttoList(graphicReport);

                            File outPutfile = new File(finalImagePath);  //output file path
                            ImageIO.write(image, "jpg", outPutfile);
                            System.out.println("Writing complete.");
                            JOptionPane.showMessageDialog(null, "Image uploaded successfully");
                            graphicalReportToNurse.setStatus("Completed");
                            System.out.println("== at the end of the function of === ");
                            selectFileTxt.setText("");
                        } catch (IOException e) {
                            System.out.println("Error: " + e);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "please select file to upload");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Request Status is already Comepleted, can not upload the report in the same request");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select the request first");
        }


    }//GEN-LAST:event_saveBtnSecActionPerformed

    private void graPhicRequestStatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graPhicRequestStatusComboBoxActionPerformed

        String requestStatus = (String) graPhicRequestStatusComboBox.getSelectedItem();
        System.out.println("requestStatus-->" + requestStatus);
        // below if condition to save from null value
        if (requestStatus != null) {
            if (requestStatus.equals("Sent")) {
                saveBtnSec.setVisible(true);

            } else {
                //saveBtnSec.setVisible(false);

            }
            if (requestStatus != null) {
                populateGrapicReportTable(requestStatus);

            }

        }
    }//GEN-LAST:event_graPhicRequestStatusComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox graPhicRequestStatusComboBox;
    private javax.swing.JTable graphicalWorkRequestJTable;
    private javax.swing.JTextField heartRateTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox requestStatusComboBox;
    private javax.swing.JTextField respRateTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton saveBtnSec;
    private javax.swing.JTextField selectFileTxt;
    private javax.swing.JTextField sysBloodPresTxt;
    private javax.swing.JButton viewBtn;
    private javax.swing.JTextField weightInPoundsTxt;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
