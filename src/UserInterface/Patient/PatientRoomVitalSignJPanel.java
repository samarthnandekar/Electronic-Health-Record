/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Patient;

import Business.EcoSystem;
import Business.EnterPrise.Enterprise;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.PatientRoomVitalSign.PatientRoomVitalSign;
import Business.PatientVisit.Visit;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.VitalTestWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author samar
 */
public class PatientRoomVitalSignJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientRoomVitalSignJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Organization organization;
    private EcoSystem ecoSystem;
    private Patient patient;
    public PatientRoomVitalSignJPanel(JPanel upc,UserAccount userAccount,Organization org, Enterprise enterprise, EcoSystem ecoSystem)
    {
        initComponents();
        patient=userAccount.getPatient();
        userProcessContainer=upc;
        this.userAccount=userAccount;
        this.organization=org;
        this.enterprise=enterprise;
        this.ecoSystem=ecoSystem;
        
        populateRoomVitalSignTable();
    }

    
    public void populateRoomVitalSignTable()
    {
        DefaultTableModel model = (DefaultTableModel) patientRoomVitalSignTable.getModel();
        model.setRowCount(0);
        for(PatientRoomVitalSign patientRVS : patient.getPatientRoomVitalSignList().getPatientRoomVitalSignList())
        {
            Object[] row = new Object[6];
            row[0] = patientRVS;
            row[1] = patientRVS.getCleanness();
            row[2] = patientRVS.getTemperature();
            row[3] = patientRVS.getHumidity();
            row[4] = patientRVS.getAirChangesPerHour();
            row[5] = patientRVS.getCaptureDate();
            model.addRow(row);
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
        patientRoomVitalSignTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        airChangePerHTxt = new javax.swing.JTextField();
        temperaTxt = new javax.swing.JTextField();
        cleanTxt = new javax.swing.JTextField();
        airQuaIndexTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        humidityTxt = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        airChangePerHTxt1 = new javax.swing.JTextField();
        temperaTxt1 = new javax.swing.JTextField();
        cleanTxt1 = new javax.swing.JTextField();
        airQuaIndexTxt1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        humidityTxt1 = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Patient Room Vital Sign");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

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
        jScrollPane1.setViewportView(patientRoomVitalSignTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 800, 100));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 100, 35));

        jLabel2.setText("Air Quality index:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        jLabel3.setText("Cleanness:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        jLabel4.setText("Temperature:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, -1));

        jLabel5.setText("Humidity:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, -1));
        add(airChangePerHTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, 120, 35));
        add(temperaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 120, 35));
        add(cleanTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 120, 35));
        add(airQuaIndexTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 120, 35));

        jLabel6.setText("Air Changes Per Hour:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, -1, -1));
        add(humidityTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 120, 35));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 740, -1, 35));

        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 500, 100, 35));

        jLabel7.setText("Air Quality index:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 230, -1, -1));

        jLabel8.setText("Cleanness:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 280, -1, -1));

        jLabel9.setText("Temperature:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 330, -1, -1));

        jLabel10.setText("Humidity:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, -1, -1));
        add(airChangePerHTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 430, 120, 35));
        add(temperaTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 330, 120, 35));
        add(cleanTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, 120, 35));
        add(airQuaIndexTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 230, 120, 35));

        jLabel11.setText("Air Changes Per Hour:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, -1, -1));
        add(humidityTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 380, 120, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        String AirQuality =airQuaIndexTxt.getText();
        String cleanNess=cleanTxt.getText();
        String tempString=temperaTxt.getText();
        String humidityStr= humidityTxt.getText();
        String airChange=airChangePerHTxt.getText();
 
        boolean isUserInutvalid=checkUserInput(AirQuality,cleanNess,tempString,humidityStr,airChange);
           if(isUserInutvalid)
           {
               PatientRoomVitalSign patientRoomVitalSign= new PatientRoomVitalSign();
               
               patientRoomVitalSign.setAirQualityIndex(Float.parseFloat(AirQuality));
               patientRoomVitalSign.setCleanness(Float.parseFloat(cleanNess));
               patientRoomVitalSign.setTemperature(Float.parseFloat(tempString));
               patientRoomVitalSign.setHumidity(Float.parseFloat(humidityStr));
               patientRoomVitalSign.setAirChangesPerHour(Float.parseFloat(airChange));
               
               Date todayDate= new Date();
               patientRoomVitalSign.setCaptureDate(todayDate);
               patient.getPatientRoomVitalSignList().addPatientRoomVitalSign(patientRoomVitalSign);
               populateRoomVitalSignTable();
               clearText();
           }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void clearText()
    {
        airQuaIndexTxt.setText("");
        cleanTxt.setText("");
        temperaTxt.setText("");
        humidityTxt.setText("");
        airChangePerHTxt.setText("");
    }
    public boolean checkUserInput(String AirQuality,String cleanNess,String tempatureString,String humidityStr,String airChange)
    {
        
        String validationerror = "Please correct the following error:";

        
        // validation for Air Quality
        if ((AirQuality.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the First name";
        }
        if (!(AirQuality.trim()).equals("") && !(AirQuality.trim()).equals("null")
                && !((AirQuality.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "First name should "
                    + "contain characters only";
        }
       
         if(!(AirQuality.equals("")) && ((AirQuality.toString().trim()).matches("[0-9]*")))
        {
            Float floatAirQuality=Float.parseFloat(AirQuality);
            if( (!((floatAirQuality>0) && (floatAirQuality<500))))
            {
              validationerror = validationerror + "\n" + "Blood pressure can not be  "
                    + "less than 30 and greater than 580";   
            }
          
        }
        
          // validation for Cleanness
        if ((cleanNess.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Cleanness";
        }
        if (!(cleanNess.trim()).equals("") && !(cleanNess.trim()).equals("null")
                && !((cleanNess.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "Cleanness should "
                    + "contain number only";
        }
       
         if(!(cleanNess.equals("")) && ((cleanNess.toString().trim()).matches("[0-9]*")))
        {
            Float floatcleanNess=Float.parseFloat(cleanNess);
            if( (!((floatcleanNess>9) && (floatcleanNess<=100))))
            {
              validationerror = validationerror + "\n" + "Cleanness can not be  "
                    + "less than 10 and greater than 100";   
            }
          
        }
          // validation for Temperature
        if ((tempatureString.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Temperature";
        }
        if (!(tempatureString.trim()).equals("") && !(tempatureString.trim()).equals("null")
                && !((tempatureString.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "Temperature should "
                    + "contain number only";
        }
       
         if(!(tempatureString.equals("")) && ((tempatureString.toString().trim()).matches("[0-9]*")))
        {
            Float floattempatureString=Float.parseFloat(tempatureString);
            if( (!((floattempatureString>-51) && (floattempatureString<60))))
            {
              validationerror = validationerror + "\n" + "Temperature can not be  "
                    + "less than -50 and greater than 60";   
            }
          
        }
         
          // validation for humidity 
        if ((humidityStr.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Humidity";
        }
        if (!(humidityStr.trim()).equals("") && !(humidityStr.trim()).equals("null")
                && !((humidityStr.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "Humidity should "
                    + "contain Number only";
        }
       
         if(!(humidityStr.equals("")) && ((humidityStr.toString().trim()).matches("[0-9]*")))
        {
            Float floathumidityStr=Float.parseFloat(humidityStr);
            if( (!((floathumidityStr>0) && (floathumidityStr<101))))
            {
              validationerror = validationerror + "\n" + "Humidity can not be  "
                    + "less than 0 and greater than 100";   
            }
          
        }
         
          // validation for Air Changes Per Hour
        if ((airChange.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Air Changes Per Hour";
        }
        if (!(airChange.trim()).equals("") && !(airChange.trim()).equals("null")
                && !((airChange.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "Air Changes Per Hour should "
                    + "contain number only";
        }
       
         if(!(airChange.equals("")) && ((airChange.toString().trim()).matches("[0-9]*")))
        {
            Float floatairChange=Float.parseFloat(airChange);
            if( (!((floatairChange>5) && (floatairChange<=240))))
            {
              validationerror = validationerror + "\n" + "Air Changes Per Hour can not be  "
                    + "less than 5 and greater than 240";   
            }
          
        }
      
        if (validationerror.equals("Please correct the following error:")) {
            validationerror = "Thanks for details";
            //JOptionPane.showMessageDialog(null, validationerror);
            return true;
        }
        else
        {
         JOptionPane.showMessageDialog(null, validationerror);
         return false;
        }
    }
    
    /*
    1) Air Quality Index
    0-50	Good
    51-100	Moderate
    101-150	Unhealthy for Sensitive Groups
    151 to 200	Unhealthy	
    201 to 300	Very Unhealthy	
    301 to 500	Hazardous
    
    2) Cleanness
      10-100
    
    3) Temperature
    
    
    4)Humidity
    0-100
    
    5) Air Changes Per Hour- 
    Range-
    5 – 48, 60 – 90, 150 – 240,
    
    */
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
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
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField airChangePerHTxt;
    private javax.swing.JTextField airChangePerHTxt1;
    private javax.swing.JTextField airQuaIndexTxt;
    private javax.swing.JTextField airQuaIndexTxt1;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField cleanTxt;
    private javax.swing.JTextField cleanTxt1;
    private javax.swing.JTextField humidityTxt;
    private javax.swing.JTextField humidityTxt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientRoomVitalSignTable;
    private javax.swing.JTextField temperaTxt;
    private javax.swing.JTextField temperaTxt1;
    // End of variables declaration//GEN-END:variables
}