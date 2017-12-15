/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Doctor;

import Business.EcoSystem;
import Business.EnterPrise.Enterprise;
import Business.Organization.Organization;
import Business.PatientVisit.Medication;
import Business.PatientVisit.Prescription;
import Business.PatientVisit.Visit;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CollectVisitChargesWorkRequest;
import Business.WorkQueue.MedicineWorkRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samar
 */
public class DoctorViewWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorViewWorkRequestJPanel
     */
    
    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem ecoSystem;
    
    public DoctorViewWorkRequestJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.ecoSystem = ecoSystem;
        
        populateStatusCombobox();
        populateStatusComboboxForCharge();
        
        populateMedicineWorkRequestTable("Sent");
        populateTableforVisitCharges("BillGenerated");
    }
    
     public void populateStatusCombobox()
    {
      requestStatusComboBox.removeAllItems();
      requestStatusComboBox.addItem("Sent");
      requestStatusComboBox.addItem("Completed");
    }
    
     public void populateStatusComboboxForCharge()
    {
      requestStatusComboBoxCash.removeAllItems();
      //requestStatusComboBox.addItem("");
      requestStatusComboBoxCash.addItem("BillGenerated");
      requestStatusComboBoxCash.addItem("BillReceived");
    
    }
    
    public void populateMedicineWorkRequestTable(String requestStatus)
    {
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        WorkQueue workQueue=userAccount.getWorkQueue();
        for(WorkRequest request : workQueue.getWorkRequestList())
        {
            if(request instanceof MedicineWorkRequest)
           {
            MedicineWorkRequest meWorkReq=(MedicineWorkRequest)request;
            
            if(requestStatus.equals(meWorkReq.getStatus()))
            {
            Object[] row = new Object[8];
            row[0] = meWorkReq;
            Date date=meWorkReq.getRequestDate();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/YYYY");
            String dateinStr=simpleDateFormat.format(date);
            row[1] = dateinStr;
            row[2] = meWorkReq.getStatus();
            row[3] = meWorkReq.getVisit().getPatient().getFirstName()+" "+meWorkReq.getVisit().getPatient().getFirstName();
            row[4] = meWorkReq.getVisit().getPatient().getMrn();
            if(meWorkReq.getReceiver()!=null)
            {
             row[5] = meWorkReq.getReceiver().getEmployee().getFirstName()+" " +meWorkReq.getReceiver().getEmployee().getLastName();
             row[6] = meWorkReq.getResolveDate();
            }          
            model.addRow(row); 
            
            }
            DefaultTableModel modelOne = (DefaultTableModel)medicationTable.getModel();
            modelOne.setRowCount(0);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        requestStatusComboBox = new javax.swing.JComboBox();
        backJButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestCashRequestJTable = new javax.swing.JTable();
        requestStatusComboBoxCash = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        medicationTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Doctor Name", "Requested Date", "Status", "Patient Name", "patient MRN", "Receiver Name", "Received Date"
            }
        ));
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 920, 96));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Doctor Work Requests");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 230, 45));

        requestStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        requestStatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestStatusComboBoxActionPerformed(evt);
            }
        });
        add(requestStatusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 140, 35));

        backJButton2.setText("<< Back");
        backJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton2ActionPerformed(evt);
            }
        });
        add(backJButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 800, -1, 35));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Medicine Work Request:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Visit Charges Work Request:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, -1, -1));

        workRequestCashRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Doctor Name", "Requested Date", "Requested Status", "Patient Name", "Patient MRN", "Receiver Name", "received Date", "Visit Charges"
            }
        ));
        jScrollPane2.setViewportView(workRequestCashRequestJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 630, 910, 90));

        requestStatusComboBoxCash.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        requestStatusComboBoxCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestStatusComboBoxCashActionPerformed(evt);
            }
        });
        add(requestStatusComboBoxCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 560, 130, 35));

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
        jScrollPane3.setViewportView(medicationTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 920, 90));

        jButton1.setText("View Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 300, -1, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void requestStatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestStatusComboBoxActionPerformed
       String strMedReqStatus = (String) requestStatusComboBox.getSelectedItem();
       if(strMedReqStatus!=null)
       {
         populateMedicineWorkRequestTable(strMedReqStatus);
       }
    }//GEN-LAST:event_requestStatusComboBoxActionPerformed

    private void backJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton2ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton2ActionPerformed

    private void requestStatusComboBoxCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestStatusComboBoxCashActionPerformed

        String requestStatusCash = (String) requestStatusComboBoxCash.getSelectedItem();
        System.out.println("requestStatus-->"+requestStatusCash);
        // below if condition to save from null value
        if(requestStatusCash!= null)
        {
          populateTableforVisitCharges(requestStatusCash);
        }
    }//GEN-LAST:event_requestStatusComboBoxCashActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel model = (DefaultTableModel)medicationTable.getModel();

        model.setRowCount(0);

        int selectedRow=workRequestJTable.getSelectedRow();
        if(selectedRow>=0)
        {
            MedicineWorkRequest medicineWorkRequest =(MedicineWorkRequest)workRequestJTable.getValueAt(selectedRow,0);
            Prescription prescription= medicineWorkRequest.getVisit().getPrescription();
            for(Medication medication:prescription.getMedicationList().getMedicationList())
            {
                Object[] row = new Object[8];
                row[0] = medication;
                row[1] = medication.getDose();
                row[2] = medication.getStartDate();
                row[3] = medication.getEndDate();
                row[4] = medication.getForNoOfDays();
                row[5] = medication.getTotalNumberOfMedicine();
                model.addRow(row);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select the request first");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

        public void populateTableforVisitCharges(String requestStatus)
    {
        DefaultTableModel model = (DefaultTableModel)workRequestCashRequestJTable.getModel();
        System.out.println("=== inside populate table=== cash");
        model.setRowCount(0);
        WorkQueue workQueue=userAccount.getWorkQueue();
        for(WorkRequest request : workQueue.getWorkRequestList())
        {
          if(request instanceof CollectVisitChargesWorkRequest)
           {
            CollectVisitChargesWorkRequest cVCW=(CollectVisitChargesWorkRequest)request;
            System.out.println("=== inside populate table=== cash2222");
            Visit visit=cVCW.getVisit();
           
           String billStatus=visit.getVisitCharges().getPaymentStatus().getValue();
            if(requestStatus.equals(billStatus))
            {
                System.out.println("=== inside populate table=== cash33333");
            Object[] row = new Object[9];
            row[0] = cVCW;
            Date date=cVCW.getRequestDate();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/YYYY");
            String dateinStr=simpleDateFormat.format(date);
            row[1] = dateinStr;
            row[2] = cVCW.getStatus();
            row[3] = cVCW.getVisit().getPatient().getFirstName()+" "+cVCW.getVisit().getPatient().getFirstName();
            row[4] = cVCW.getVisit().getPatient().getMrn();
            if(cVCW.getReceiver()!=null)
            {
             row[5] = cVCW.getReceiver().getEmployee().getFirstName()+" " +cVCW.getReceiver().getEmployee().getLastName();
 
             row[6] = simpleDateFormat.format(cVCW.getResolveDate()); 
             row[7] = cVCW.getVisit().getVisitCharges().getPatientVisitCharge();
            }
       
            model.addRow(row); 
            }
            }
 
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable medicationTable;
    private javax.swing.JComboBox requestStatusComboBox;
    private javax.swing.JComboBox requestStatusComboBoxCash;
    private javax.swing.JTable workRequestCashRequestJTable;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
