/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Doctor;

import Business.Patient.Patient;
import Business.PatientGraphReport.GraphicReport;
import Business.PatientGraphReport.GraphicReportList;
import Business.PatientRoomVitalSign.PatientRoomVitalSign;
import Business.PatientVisit.Allergy;
import Business.PatientVisit.Medication;
import Business.PatientVisit.Prescription;
import Business.PatientVisit.Visit;
import Business.PatientVisit.VitalSign;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author samar
 */
public class DoctorViewPatientVisitDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorViewPatientVisitDetailsJPanel
     */
    private JPanel userProcessContailer;
    private Patient patient;
    private UserAccount userAccount;
    private int personyears;

    public DoctorViewPatientVisitDetailsJPanel(JPanel userProcessContainer, UserAccount userAccount, Patient patient) {
        initComponents();
        this.userProcessContailer = userProcessContainer;
        this.patient = patient;
        this.userAccount = userAccount;
        populatePatientVisit();
        populatePatientVitalSignList();
        populatePatientAllergyList();
        populateRoomVitalSignTable();
        populatePatientRecord();
    }
    
    public void populatePatientRecord()
    {
            patientNameTxt.setText(patient.getFirstName() + " " + patient.getLastName());
            patientPhoneNO.setText(patient.getPhoneNo());
            System.out.println("phone no-->" + patient.getPhoneNo());
            patientEmailID.setText(patient.getEmailID());
            patientGenderTxt.setText(patient.getGender());
            System.out.println("---gender-->" + patient.getGender());
            patientDoBTxt.setText(patient.getDob());
            patientInsuranceCode.setText(patient.getInsuranceCode());
            patientInsuranceLimit.setText(String.valueOf(patient.getInsuranceCoverageLimit()));
            patientMRNTxt.setText(patient.getMrn()); 
            
            try {
                String dobString = patient.getDob();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

                Date birthDateChange = simpleDateFormat.parse(dobString);
                System.out.println("birthDateChange--->" + birthDateChange);
                Calendar birthDay = Calendar.getInstance();
                birthDay.setTimeInMillis(birthDateChange.getTime());

                long currentTime = System.currentTimeMillis();
                Calendar now = Calendar.getInstance();
                now.setTimeInMillis(currentTime);
                int years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);

                patientAgeTxt.setText(String.valueOf(years));
            } catch (ParseException exp) {
                patientAgeTxt.setText("in catch section");
            }   
            
    }
    

    public void populatePatientVisit() {
        DefaultTableModel model = (DefaultTableModel) patientVisitTable.getModel();
        model.setRowCount(0);
        for (Visit visit : patient.getVisitDirectory().getVisitList()) {
            Object[] row = new Object[4];
            row[0] = visit;
            row[1] = visit.getVisitType();
            row[2] = visit.getDoctor();
            model.addRow(row);
        }

    }

    // populate PAtient Room vital Sign table
    public void populateRoomVitalSignTable() {
        DefaultTableModel model = (DefaultTableModel) patientRoomVitalSignTable.getModel();
        model.setRowCount(0);
        for (PatientRoomVitalSign patientRVS : patient.getPatientRoomVitalSignList().getPatientRoomVitalSignList()) {
            Object[] row = new Object[6];
            row[0] = patientRVS;
            row[1] = patientRVS.getCleanness();
            row[2] = patientRVS.getTemperature();
            row[3] = patientRVS.getHumidity();
            row[4] = patientRVS.getAirChangesPerHour();
            Date crrDate=patientRVS.getCaptureDate();
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/YYYY");
            String capDate = sdf1.format(crrDate);
            row[5] = capDate;
            model.addRow(row);
        }

    }

    public void populatePatientVitalSignList() {
        DefaultTableModel model = (DefaultTableModel) patientVitalSignTable.getModel();
        model.setRowCount(0);
        for (VitalSign vitalSign : patient.getVitalList().getVitalList()) {
            Object[] row = new Object[6];
            row[0] = vitalSign;
            row[1] = vitalSign.getRespiratoryRate();
            row[2] = vitalSign.getHeartRate();
            row[3] = vitalSign.getBloodPressure();
            row[4] = vitalSign.getWeight();
            model.addRow(row);
        }

    }

    public void populatePatientAllergyList() {
        DefaultTableModel model = (DefaultTableModel) patientAllergyList.getModel();
        model.setRowCount(0);
        for (Allergy allergy : patient.getAllergyList().getAllergylist()) {
            Object[] row = new Object[3];
            row[0] = allergy;
            row[1] = allergy.getEffectiveDate();
            model.addRow(row);
        }

    }

    /**
     * patientAllergyList This method is called from within the constructor to
     * initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientVisitTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        medicationTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        docCommentTxt = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        visitTypeTxt = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        allergyNameTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        respiratetextfield = new javax.swing.JTextField();
        heartratetextfield = new javax.swing.JTextField();
        bloodpresstextfield = new javax.swing.JTextField();
        waighttextfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        patientVitalSignTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        patientAllergyList = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        patientRoomVitalSignTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        graphicaReportTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        patientNameTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        patientPhoneNO = new javax.swing.JTextField();
        patientEmailID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        patientGenderTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        patientDoBTxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        patientInsuranceCode = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        patientInsuranceLimit = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        patientMRNTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        patientAgeTxt = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        airChangePerHTxt1 = new javax.swing.JTextField();
        temperaTxt1 = new javax.swing.JTextField();
        cleanTxt1 = new javax.swing.JTextField();
        airQuaIndexTxt1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        humidityTxt1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable1);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patientVisitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Visit Date", "Doctor Name", "Visit Type"
            }
        ));
        jScrollPane1.setViewportView(patientVisitTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 73, -1, 96));

        jLabel1.setText("Patient Visits:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 39, -1, -1));

        jButton1.setText("View Visit Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, 35));

        jLabel10.setText("Visit Type:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 240, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Visit Details");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));

        medicationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Medicine Name", "Dose", "Start Date", "End Date", "No of Days", "Total No of medicine"
            }
        ));
        jScrollPane2.setViewportView(medicationTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, -1, 90));

        docCommentTxt.setColumns(20);
        docCommentTxt.setRows(5);
        jScrollPane3.setViewportView(docCommentTxt);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 540, 290, 50));

        jLabel9.setText("Doctor Comment:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, -1, -1));
        add(visitTypeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1226, 240, 80, -1));

        allergyNameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(allergyNameTable);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, -1, 97));

        jLabel8.setText("Respiratory rate:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 660, -1, -1));

        jLabel11.setText("Heart Rate:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 710, -1, -1));

        jLabel12.setText("Systolic blood Pressure:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 750, -1, -1));

        jLabel13.setText("Weight in pounds:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 790, -1, -1));

        respiratetextfield.setEditable(false);
        add(respiratetextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 130, 35));

        heartratetextfield.setEditable(false);
        add(heartratetextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 700, 130, 35));

        bloodpresstextfield.setEditable(false);
        add(bloodpresstextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 740, 130, 35));

        waighttextfield.setEditable(false);
        add(waighttextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 780, 130, 35));

        jLabel3.setText("Medecine Name List:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, -1, -1));

        jLabel4.setText("Allergy Names:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, -1, -1));

        patientVitalSignTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Respiratory Rate", "Heart Rate", "Blood Pressure", "Weight In Pounds"
            }
        ));
        jScrollPane4.setViewportView(patientVitalSignTable);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 520, 100));

        jLabel5.setText("Vital Sign List:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        jLabel6.setText("Note:-This is vital sing is not only related with a visit, above table shows complete vital sign List.");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        jButton2.setText("Generate Graph");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 140, 35));

        patientAllergyList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Allergy Name", "Effective Date"
            }
        ));
        jScrollPane7.setViewportView(patientAllergyList);
        if (patientAllergyList.getColumnModel().getColumnCount() > 0) {
            patientAllergyList.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, -1, 100));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 910, 100, 35));

        patientRoomVitalSignTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Air Quality index", "Cleanness", "Temperature", "Humidity", "AirChangesPerHour", "Capture Date"
            }
        ));
        jScrollPane8.setViewportView(patientRoomVitalSignTable);

        add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 710, 710, 100));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Patient Room Vital Sign");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 680, -1, -1));

        graphicaReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Date"
            }
        ));
        jScrollPane9.setViewportView(graphicaReportTable);

        add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 300, 210, 100));

        jButton3.setText("View Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 440, 130, 35));

        jLabel14.setText("Patinet Name");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, -1));
        add(patientNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 80, -1));

        jLabel15.setText("Patient Phone No");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, -1, -1));

        jLabel16.setText("Patient Email ID");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, -1, -1));
        add(patientPhoneNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, 80, -1));
        add(patientEmailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 180, 80, -1));

        jLabel17.setText("Patient Gender:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 90, -1, -1));
        add(patientGenderTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 90, 80, -1));

        jLabel18.setText("Patient Date Of Birth:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 140, -1, -1));
        add(patientDoBTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 140, 80, -1));

        jLabel19.setText("Insurance Code:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 180, -1, -1));
        add(patientInsuranceCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 180, 80, -1));

        jLabel20.setText("Insurance Limit:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 90, -1, -1));
        add(patientInsuranceLimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 90, 60, -1));

        jLabel21.setText("Patient MRN:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 140, -1, -1));
        add(patientMRNTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 140, 60, -1));

        jLabel22.setText("Patient Age:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 180, -1, -1));
        add(patientAgeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 180, 60, -1));

        jButton4.setText("view Vital");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 100, 35));

        jButton5.setText("View Room Vital");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 840, 200, 35));

        jLabel23.setText("Air Quality index:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 640, -1, -1));

        jLabel24.setText("Cleanness:");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 690, -1, -1));

        jLabel25.setText("Temperature:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 740, -1, -1));

        jLabel26.setText("Humidity:");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 790, -1, -1));
        add(airChangePerHTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 840, 120, 35));
        add(temperaTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 740, 120, 35));
        add(cleanTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 690, 120, 35));
        add(airQuaIndexTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 640, 120, 35));

        jLabel27.setText("Air Changes Per Hour:");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 840, -1, -1));
        add(humidityTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 790, 120, 35));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Room Vital Sign");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 590, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Patient Vital Sign");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 620, -1, -1));

        jButton6.setText("Respiratory Graph");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 910, 180, 35));

        jButton7.setText("Heart Rate");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 910, -1, 35));

        jButton8.setText("BlodPressure Graph");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 910, -1, 35));

        jButton9.setText("Weight Graph");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 910, -1, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int selectedRow = patientVisitTable.getSelectedRow();

        if (selectedRow >= 0) {

            DefaultTableModel model = (DefaultTableModel) allergyNameTable.getModel();
            model.setRowCount(0);

            DefaultTableModel model1 = (DefaultTableModel) medicationTable.getModel();
            model1.setRowCount(0);

            DefaultTableModel model2 = (DefaultTableModel) graphicaReportTable.getModel();
            model2.setRowCount(0);

            Visit visit = (Visit) patientVisitTable.getValueAt(selectedRow, 0);

            // visitTypeTxt.setText(visit.getVisitType());
            Prescription prescription = visit.getPrescription();
            for (Medication medication : prescription.getMedicationList().getMedicationList()) {
                Object[] row = new Object[6];
                row[0] = medication;
                row[1] = medication.getEndDate();
                row[2] = medication.getStartDate();
                row[3] = medication.getDose();
                row[4] = medication.getForNoOfDays();
                row[5] = medication.getTotalNumberOfMedicine();
                model1.addRow(row);
            }

            for (Allergy allergy : visit.getAllergyList().getAllergylist()) {
                Object[] row = new Object[3];
                row[0] = allergy;
                row[1] = allergy.getEffectiveDate();
                model.addRow(row);
            }
            docCommentTxt.setText(visit.getComment());
            visitTypeTxt.setText(visit.getVisitType().getValue());
            
            
            // code to find the age
            int years=0;
            try {
                String dobString = patient.getDob();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

                Date birthDateChange = simpleDateFormat.parse(dobString);
                System.out.println("birthDateChange--->" + birthDateChange);
                Calendar birthDay = Calendar.getInstance();
                birthDay.setTimeInMillis(birthDateChange.getTime());

                long currentTime = System.currentTimeMillis();
                Calendar now = Calendar.getInstance();
                now.setTimeInMillis(currentTime);
                years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);

                patientAgeTxt.setText(String.valueOf(years));
            } catch (ParseException exp) {
                patientAgeTxt.setText("in catch section");
            }
   
            VitalSign vitalSign = visit.getPvitalSign();
            if (vitalSign != null);
            {  
                if (((years >= 1 && years <= 3) && ((vitalSign.getRespiratoryRate() >= 20) && (vitalSign.getRespiratoryRate()<= 30)))
                    || ((years == 4 || years == 5) && ((vitalSign.getRespiratoryRate()>= 20) && (vitalSign.getRespiratoryRate() <= 30)))
                    || ((years >= 6 && years <= 12) && ((vitalSign.getRespiratoryRate() >= 20) && (vitalSign.getRespiratoryRate() <= 30)))
                    || ((years >= 13) && ((vitalSign.getRespiratoryRate() >= 12) && (vitalSign.getRespiratoryRate() <= 20)))) {
                System.out.println("inside color condition" + vitalSign.getRespiratoryRate());
                Color color = Color.GREEN;
                respiratetextfield.setBackground(color);
            } else {
                Color color = Color.RED;
                respiratetextfield.setBackground(color);
            }

                //Color code for Heart_rate
            if (((years >= 1 && years <= 3) && ((vitalSign.getHeartRate()>= 80) && (vitalSign.getHeartRate() <= 130)))
                    || ((years == 4 || years == 5) && ((vitalSign.getHeartRate() >= 80) && (vitalSign.getHeartRate() <= 120)))
                    || ((years >= 6 && years <= 12) && ((vitalSign.getHeartRate() >= 70) && (vitalSign.getHeartRate() <= 110)))
                    || ((years >= 13) && ((vitalSign.getHeartRate() >= 55) && (vitalSign.getHeartRate() <= 105)))) {
                System.out.println("inside color condition" + vitalSign.getHeartRate());
                Color color = Color.GREEN;
                heartratetextfield.setBackground(color);
            } else {
                Color color = Color.RED;
                heartratetextfield.setBackground(color);
            }
            
           // color code for Blood pressure
            if (((years >= 1 && years <= 3) && ((vitalSign.getBloodPressure()>= 80) && (vitalSign.getBloodPressure() <= 110)))
                    || ((years == 4 || years == 5) && ((vitalSign.getBloodPressure() >= 80) && (vitalSign.getBloodPressure() <= 110)))
                    || ((years >= 6 && years <= 12) && ((vitalSign.getBloodPressure() >= 70) && (vitalSign.getBloodPressure() <= 120)))
                    || ((years >= 13) && ((vitalSign.getBloodPressure() >= 110) && (vitalSign.getBloodPressure() <= 120)))) {
                Color color = Color.GREEN;
                bloodpresstextfield.setBackground(color);
            } else {
                Color color = Color.RED;
                bloodpresstextfield.setBackground(color);
            }
            //color code for pounds
            if (((years >= 1 && years <= 3) && ((vitalSign.getWeight()>= 22) && (vitalSign.getWeight() <= 31)))
                    || ((years == 4 || years == 5) && ((vitalSign.getWeight() >= 31) && (vitalSign.getWeight() <= 40)))
                    || ((years >= 6 && years <= 12) && ((vitalSign.getWeight() >= 41) && (vitalSign.getWeight() <= 92)))
                    || ((years >= 13) && (vitalSign.getWeight() >= 110))) {
                System.out.println("inside color condition" + vitalSign.getWeight());
                Color color = Color.GREEN;
                waighttextfield.setBackground(color);
            } else {
                Color color = Color.RED;
                waighttextfield.setBackground(color);
            }          
                
  
                respiratetextfield.setText(String.valueOf(vitalSign.getRespiratoryRate()));
                heartratetextfield.setText(String.valueOf(vitalSign.getHeartRate()));
                bloodpresstextfield.setText(String.valueOf(vitalSign.getBloodPressure()));
                waighttextfield.setText(String.valueOf(vitalSign.getWeight()));
            }

            // code to generate the graphical report table
            GraphicReportList graphicReportList = visit.getGraphicReportList();
            System.out.println("visit.getGraphicReportList()-->" + visit.getGraphicReportList().getGraphicReportList().size());
            for (GraphicReport graphicReport : graphicReportList.getGraphicReportList()) {
                Object[] row = new Object[3];
                if (graphicReport.getImageName() != "") {
                    row[0] = graphicReport;
                }
                model2.addRow(row);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select patient visit first");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContailer.remove(this);
        CardLayout layout = (CardLayout) userProcessContailer.getLayout();
        layout.previous(userProcessContailer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = graphicaReportTable.getSelectedRow();

        if (selectedRow >= 0) {
            GraphicReport graphicReport = (GraphicReport) graphicaReportTable.getValueAt(selectedRow, 0);
            String filePath = graphicReport.getImageWithPath();
            System.out.println("filePath====>" + filePath);

            JFrame frame = new JFrame();
            ImageIcon icon = new ImageIcon(filePath);
            JLabel label = new JLabel(icon);
            frame.add(label);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);

            frame.setSize(500, 500);
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Please select a record first");  
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selectedRow = patientVitalSignTable.getSelectedRow();

        if (selectedRow >= 0) {
            VitalSign vitalSign = (VitalSign) patientVitalSignTable.getValueAt(selectedRow, 0);
            
            // code to find the age
            int years=0;
            try {
                String dobString = patient.getDob();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

                Date birthDateChange = simpleDateFormat.parse(dobString);
                System.out.println("birthDateChange--->" + birthDateChange);
                Calendar birthDay = Calendar.getInstance();
                birthDay.setTimeInMillis(birthDateChange.getTime());

                long currentTime = System.currentTimeMillis();
                Calendar now = Calendar.getInstance();
                now.setTimeInMillis(currentTime);
                years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);

                patientAgeTxt.setText(String.valueOf(years));
            } catch (ParseException exp) {
                patientAgeTxt.setText("in catch section");
            }
            
            // color code for vital Sign
            if (((years >= 1 && years <= 3) && ((vitalSign.getRespiratoryRate() >= 20) && (vitalSign.getRespiratoryRate()<= 30)))
                    || ((years == 4 || years == 5) && ((vitalSign.getRespiratoryRate()>= 20) && (vitalSign.getRespiratoryRate() <= 30)))
                    || ((years >= 6 && years <= 12) && ((vitalSign.getRespiratoryRate() >= 20) && (vitalSign.getRespiratoryRate() <= 30)))
                    || ((years >= 13) && ((vitalSign.getRespiratoryRate() >= 12) && (vitalSign.getRespiratoryRate() <= 20)))) {
                System.out.println("inside color condition" + vitalSign.getRespiratoryRate());
                Color color = Color.GREEN;
                respiratetextfield.setBackground(color);
            } else {
                Color color = Color.RED;
                respiratetextfield.setBackground(color);
            }

                //Color code for Heart_rate
            if (((years >= 1 && years <= 3) && ((vitalSign.getHeartRate()>= 80) && (vitalSign.getHeartRate() <= 130)))
                    || ((years == 4 || years == 5) && ((vitalSign.getHeartRate() >= 80) && (vitalSign.getHeartRate() <= 120)))
                    || ((years >= 6 && years <= 12) && ((vitalSign.getHeartRate() >= 70) && (vitalSign.getHeartRate() <= 110)))
                    || ((years >= 13) && ((vitalSign.getHeartRate() >= 55) && (vitalSign.getHeartRate() <= 105)))) {
                System.out.println("inside color condition" + vitalSign.getHeartRate());
                Color color = Color.GREEN;
                heartratetextfield.setBackground(color);
            } else {
                Color color = Color.RED;
                heartratetextfield.setBackground(color);
            }
            
           // color code for Blood pressure
            if (((years >= 1 && years <= 3) && ((vitalSign.getBloodPressure()>= 80) && (vitalSign.getBloodPressure() <= 110)))
                    || ((years == 4 || years == 5) && ((vitalSign.getBloodPressure() >= 80) && (vitalSign.getBloodPressure() <= 110)))
                    || ((years >= 6 && years <= 12) && ((vitalSign.getBloodPressure() >= 70) && (vitalSign.getBloodPressure() <= 120)))
                    || ((years >= 13) && ((vitalSign.getBloodPressure() >= 110) && (vitalSign.getBloodPressure() <= 120)))) {
                Color color = Color.GREEN;
                bloodpresstextfield.setBackground(color);
            } else {
                Color color = Color.RED;
                bloodpresstextfield.setBackground(color);
            }
            //color code for pounds
            if (((years >= 1 && years <= 3) && ((vitalSign.getWeight()>= 22) && (vitalSign.getWeight() <= 31)))
                    || ((years == 4 || years == 5) && ((vitalSign.getWeight() >= 31) && (vitalSign.getWeight() <= 40)))
                    || ((years >= 6 && years <= 12) && ((vitalSign.getWeight() >= 41) && (vitalSign.getWeight() <= 92)))
                    || ((years >= 13) && (vitalSign.getWeight() >= 110))) {
                System.out.println("inside color condition" + vitalSign.getWeight());
                Color color = Color.GREEN;
                waighttextfield.setBackground(color);
            } else {
                Color color = Color.RED;
                waighttextfield.setBackground(color);
            }
                respiratetextfield.setText(String.valueOf(vitalSign.getRespiratoryRate()));
                heartratetextfield.setText(String.valueOf(vitalSign.getHeartRate()));
                bloodpresstextfield.setText(String.valueOf(vitalSign.getBloodPressure()));
                waighttextfield.setText(String.valueOf(vitalSign.getWeight())); 
            
        }
        else
        {
         JOptionPane.showMessageDialog(null, "Please select a record first");   
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        int selectedRow = patientRoomVitalSignTable.getSelectedRow();
        if (selectedRow >= 0) {
            PatientRoomVitalSign patientRoomVitalSign = (PatientRoomVitalSign) patientRoomVitalSignTable.getValueAt(selectedRow, 0);
            
            //code for Air Quality Index
            if(patientRoomVitalSign.getAirQualityIndex()>=0 && patientRoomVitalSign.getAirQualityIndex()<=100)
            {
                Color color = Color.GREEN;
                airQuaIndexTxt1.setBackground(color);
            } else if(patientRoomVitalSign.getAirQualityIndex()>=101 && patientRoomVitalSign.getAirQualityIndex()<=150)
                    {
                Color color = Color.ORANGE;
               airQuaIndexTxt1.setBackground(color);
            }
            else
            {  Color color = Color.red;
               airQuaIndexTxt1.setBackground(color); 
            }
            
            // code for cleanness
            if(patientRoomVitalSign.getCleanness()>=70)
            {
                cleanTxt1.setBackground(Color.GREEN);
            }
            else if(patientRoomVitalSign.getCleanness()>=50 && patientRoomVitalSign.getCleanness()<=69)
            {
                cleanTxt1.setBackground(Color.ORANGE);
            }
            else
            {
              cleanTxt1.setBackground(Color.red);
            }
            
            // code for humidity
            if(patientRoomVitalSign.getHumidity()<=20)
            {
                humidityTxt1.setBackground(Color.GREEN);
            }
            else if(patientRoomVitalSign.getCleanness()>=21 && patientRoomVitalSign.getCleanness()<=30)
            {
                humidityTxt1.setBackground(Color.ORANGE);
            }
            else
            {
              humidityTxt1.setBackground(Color.red);
            }
            
            // code for Temparature
            if(patientRoomVitalSign.getTemperature()<=30)
            {
                temperaTxt1.setBackground(Color.GREEN);
            }
            else if(patientRoomVitalSign.getTemperature()>=31 && patientRoomVitalSign.getTemperature()<=50)
            {
                temperaTxt1.setBackground(Color.ORANGE);
            }
            else
            {
              temperaTxt1.setBackground(Color.red);
            }
            
             // code for Air Changes Per Hour
            if(patientRoomVitalSign.getTemperature()<=48)
            {
                airChangePerHTxt1.setBackground(Color.GREEN);
            }
            else if(patientRoomVitalSign.getTemperature()>=60 && patientRoomVitalSign.getTemperature()<=90)
            {
                airChangePerHTxt1.setBackground(Color.ORANGE);
            }
            else
            {
              airChangePerHTxt1.setBackground(Color.red);
            }
            
            
            
            airQuaIndexTxt1.setText(String.valueOf(patientRoomVitalSign.getAirQualityIndex()));
            cleanTxt1.setText(String.valueOf(patientRoomVitalSign.getCleanness()));
            temperaTxt1.setText(String.valueOf(patientRoomVitalSign.getTemperature()));
            humidityTxt1.setText(String.valueOf(patientRoomVitalSign.getHumidity()));
            airChangePerHTxt1.setText(String.valueOf(patientRoomVitalSign.getAirChangesPerHour()));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "please select a record first");
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

      public void calculateAge() {
        try {
            String dobString = patient.getDob();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

            Date birthDateChange = simpleDateFormat.parse(dobString);
            System.out.println("birthDateChange--->" + birthDateChange);
            Calendar birthDay = Calendar.getInstance();
            birthDay.setTimeInMillis(birthDateChange.getTime());

            long currentTime = System.currentTimeMillis();
            Calendar now = Calendar.getInstance();
            now.setTimeInMillis(currentTime);
            personyears = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);

        } catch (ParseException exp) {
            System.out.println("====parse exception");
        }
    }
    
    
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        DefaultCategoryDataset barchart = new DefaultCategoryDataset();

        for (VitalSign vs : patient.getVitalList().getVitalList()) {
            System.out.println("((personyears >= 1 && personyears <= 3) && ((vitalSign.getRespiratoryRate() >= 20) && (vitalSign.getRespiratoryRate() <= 30))"
                + ((personyears >= 1 && personyears <= 3) && ((vs.getRespiratoryRate() >= 20) && (vs.getRespiratoryRate() <= 30))));
            System.out.println("2nd==>" + ((personyears == 4 || personyears == 5) && ((vs.getRespiratoryRate() >= 20) && (vs.getRespiratoryRate() <= 30))));

            System.out.println("personyears-->" + personyears);
            System.out.println("vitalSign.getRespiratoryRate()-->" + vs.getRespiratoryRate());

            System.out.println("3rd -->" + ((personyears >= 6 && personyears <= 12) && ((vs.getRespiratoryRate() >= 20) && (vs.getRespiratoryRate() <= 30))));
            System.out.println("4th-->" + ((personyears >= 13) && ((vs.getRespiratoryRate() >= 12) && (vs.getRespiratoryRate() <= 20))));

            Boolean isNormal = ((personyears >= 1 && personyears <= 3) && ((vs.getRespiratoryRate() >= 20) && (vs.getRespiratoryRate() <= 30)))
            || ((personyears == 4 || personyears == 5) && ((vs.getRespiratoryRate() >= 20) && (vs.getRespiratoryRate() <= 30)))
            || ((personyears >= 6 && personyears <= 12) && ((vs.getRespiratoryRate() >= 20) && (vs.getRespiratoryRate() <= 30)))
            || ((personyears >= 13) && ((vs.getRespiratoryRate() >= 12) && (vs.getRespiratoryRate() <= 20)));
            System.out.println("isNormal--->" + isNormal);
            if (isNormal) {
                barchart.setValue(vs.getRespiratoryRate(), "Noraml", vs.getVitalCapDate());
                System.out.println("======inside if condition----------" + vs.getVitalCapDate());
                continue;
            } else {
                barchart.setValue(vs.getRespiratoryRate(), "AbNoraml", vs.getVitalCapDate());
                System.out.println(" in side else condition--------");
                System.out.println("======inside if condition----------" + vs.getVitalCapDate());
            }

        }
        //((BarRenderer) cplot.getRenderer()).setBarPainter(new StandardBarPainter());

        JFreeChart bar = ChartFactory.createBarChart3D("Respiratory Rate", "Records", "R per minutes", barchart, PlotOrientation.VERTICAL, true, true, true);

        CategoryPlot cplot = (CategoryPlot) bar.getPlot();
        cplot.setBackgroundPaint(SystemColor.black);

        BarRenderer r = (BarRenderer) bar.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0, Color.red);
        r.setSeriesPaint(1, Color.green);

        CategoryPlot p1 = bar.getCategoryPlot();
        p1.setRangeGridlinePaint(Color.white);
        ChartFrame frame = new ChartFrame("barchart", bar);
        frame.setVisible(true);
        frame.setSize(450, 350);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultCategoryDataset barchart = new DefaultCategoryDataset();

        for (VitalSign vs : patient.getVitalList().getVitalList()) {

            if (((personyears >= 1 && personyears <= 3) && ((vs.getHeartRate() >= 80) && (vs.getHeartRate() <= 130)))
                || ((personyears == 4 || personyears == 5) && ((vs.getHeartRate() >= 80) && (vs.getHeartRate() <= 120)))
                || ((personyears >= 6 && personyears <= 12) && ((vs.getHeartRate() >= 70) && (vs.getHeartRate() <= 110)))
                || ((personyears >= 13) && ((vs.getHeartRate() >= 55) && (vs.getHeartRate() <= 105)))) {
                barchart.setValue(vs.getHeartRate(), "Noraml", vs.getVitalCapDate());
                System.out.println("======inside if condition----------" + vs.getVitalCapDate());
            } else {
                barchart.setValue(vs.getHeartRate(), "AbNoraml", vs.getVitalCapDate());

                System.out.println(" in side else condition--------");
                System.out.println("======inside if condition----------" + vs.getVitalCapDate());
            }

        }
        JFreeChart bar = ChartFactory.createBarChart3D("Heart Rate", "Records", "H per minutes", barchart, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot p1 = bar.getCategoryPlot();

        CategoryPlot cplot = (CategoryPlot) bar.getPlot();
        cplot.setBackgroundPaint(SystemColor.black);

        BarRenderer r = (BarRenderer) bar.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0, Color.red);
        r.setSeriesPaint(1, Color.green);

        p1.setRangeGridlinePaint(Color.white);
        ChartFrame frame = new ChartFrame("barchart", bar);
        frame.setVisible(true);
        frame.setSize(450, 350);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        DefaultCategoryDataset barchart = new DefaultCategoryDataset();

        for (VitalSign vs : patient.getVitalList().getVitalList()) {

            if (((personyears >= 1 && personyears <= 3) && ((vs.getBloodPressure() >= 80) && (vs.getBloodPressure() <= 110)))
                || ((personyears == 4 || personyears == 5) && ((vs.getBloodPressure() >= 80) && (vs.getBloodPressure() <= 110)))
                || ((personyears >= 6 && personyears <= 12) && ((vs.getBloodPressure() >= 70) && (vs.getBloodPressure() <= 120)))
                || ((personyears >= 13) && ((vs.getBloodPressure() >= 110) && (vs.getBloodPressure() <= 120)))) {
                barchart.setValue(vs.getBloodPressure(), "Noraml", vs.getVitalCapDate());
                System.out.println("======inside if condition----------" + vs.getVitalCapDate());
                continue;
            } else {
                barchart.setValue(vs.getBloodPressure(), "AbNoraml", vs.getVitalCapDate());

                System.out.println(" in side else condition--------");
                System.out.println("======inside if condition----------" + vs.getVitalCapDate());
            }

        }
        JFreeChart bar = ChartFactory.createBarChart3D("Blood Pressure", "Records", "B per minutes", barchart, PlotOrientation.VERTICAL, true, true, true);

        CategoryPlot cplot = (CategoryPlot) bar.getPlot();
        cplot.setBackgroundPaint(SystemColor.black);

        BarRenderer r = (BarRenderer) bar.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0, Color.red);
        r.setSeriesPaint(1, Color.green);

        CategoryPlot p1 = bar.getCategoryPlot();
        p1.setRangeGridlinePaint(Color.white);
        ChartFrame frame = new ChartFrame("barchart", bar);
        frame.setVisible(true);
        frame.setSize(450, 350);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        DefaultCategoryDataset barchart = new DefaultCategoryDataset();

        for (VitalSign vs : patient.getVitalList().getVitalList()) {
            boolean isNormal=((personyears >= 1 && personyears <= 3) && ((vs.getWeight() >= 22) && (vs.getWeight() <= 31)))
            || ((personyears == 4 || personyears == 5) && ((vs.getWeight() >= 31) && (vs.getWeight() <= 40)))
            || ((personyears >= 6 && personyears <= 12) && ((vs.getWeight() >= 41) && (vs.getWeight() <= 92)))
            || ((personyears >= 13) && (vs.getWeight() >= 110));
            System.out.println("isNormal--->"+isNormal);
            if (isNormal) {
                barchart.setValue(vs.getWeight(), "Noraml", vs.getVitalCapDate());
                System.out.println("======inside if condition----------" + vs.getVitalCapDate());
                continue;
            } else {
                barchart.setValue(vs.getWeight(), "AbNoraml", vs.getVitalCapDate());

                System.out.println(" in side else condition--------");
                System.out.println("======inside else condition----------" + vs.getVitalCapDate());
            }

        }
        JFreeChart bar = ChartFactory.createBarChart3D("Weight", "Records", "Time", barchart, PlotOrientation.VERTICAL, true, true, true);

        CategoryPlot cplot = (CategoryPlot) bar.getPlot();
        cplot.setBackgroundPaint(SystemColor.black);

        BarRenderer r = (BarRenderer) bar.getCategoryPlot().getRenderer();
        r.setSeriesPaint(1, Color.green);
        r.setSeriesPaint(0, Color.red);

        CategoryPlot p1 = bar.getCategoryPlot();
        p1.setRangeGridlinePaint(Color.white);
        ChartFrame frame = new ChartFrame("barchart", bar);
        frame.setVisible(true);
        frame.setSize(450, 350);
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField airChangePerHTxt1;
    private javax.swing.JTextField airQuaIndexTxt1;
    private javax.swing.JTable allergyNameTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField bloodpresstextfield;
    private javax.swing.JTextField cleanTxt1;
    private javax.swing.JTextArea docCommentTxt;
    private javax.swing.JTable graphicaReportTable;
    private javax.swing.JTextField heartratetextfield;
    private javax.swing.JTextField humidityTxt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable medicationTable;
    private javax.swing.JTextField patientAgeTxt;
    private javax.swing.JTable patientAllergyList;
    private javax.swing.JTextField patientDoBTxt;
    private javax.swing.JTextField patientEmailID;
    private javax.swing.JTextField patientGenderTxt;
    private javax.swing.JTextField patientInsuranceCode;
    private javax.swing.JTextField patientInsuranceLimit;
    private javax.swing.JTextField patientMRNTxt;
    private javax.swing.JTextField patientNameTxt;
    private javax.swing.JTextField patientPhoneNO;
    private javax.swing.JTable patientRoomVitalSignTable;
    private javax.swing.JTable patientVisitTable;
    private javax.swing.JTable patientVitalSignTable;
    private javax.swing.JTextField respiratetextfield;
    private javax.swing.JTextField temperaTxt1;
    private javax.swing.JTextField visitTypeTxt;
    private javax.swing.JTextField waighttextfield;
    // End of variables declaration//GEN-END:variables
}
