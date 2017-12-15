/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeRole;

import Business.Doctor.Doctor;
import Business.Doctor.DoctorDepartment;
import Business.Doctor.DoctorDepartmentCatalog;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.EnterPrise.AmbulanceEnterprise;
import Business.EnterPrise.Enterprise;
import Business.EnterPrise.HospitalEnterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Person.Person;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samarth
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEmployeeJPanel
     */
    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    //private Organization organization;
    private DoctorOrganization doctorOrganization;
    private Enterprise enterprise;
    private DoctorDepartment doctorDepartment;

    public ManageEmployeeJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDir = enterprise.getOrganizationDirectory();
        this.enterprise = enterprise;
        ecoSystem = system;
        populateOrganizationComboBox();
        populateOrganizationEmpComboBox();
        populatePersonTable();
        populateDocDepartmentTable();

        showAndHideDoccreationFields();

    }

    public void showAndHideDoccreationFields() {

        if (enterprise instanceof HospitalEnterprise) {

            //panelDocTable.setVisible(true);
            docDepTXt.setVisible(true);
            docdepartTxt.setVisible(true);
            addDocDepartmentBtn.setVisible(true);
            addDocBtn.setVisible(true);
            addDocDepartmentBtn.setVisible(true);
            noteLabel.setVisible(true);
        } else if (enterprise instanceof AmbulanceEnterprise) {

            panelDocTable.setVisible(false);
            docDepTXt.setVisible(false);
            docdepartTxt.setVisible(false);
            addDocDepartmentBtn.setVisible(false);
            addDocBtn.setVisible(false);
            addDocDepartmentBtn.setVisible(false);
            noteLabel.setVisible(false);
        }
    }

    public void populatePersonTable() {
        DefaultTableModel model = (DefaultTableModel) allpersonProfileTable.getModel();
        model.setRowCount(0);
        for (Person person : ecoSystem.getPersonDirectory().getPersonList()) {
            Object[] row = new Object[5];
            row[0] = person;
            row[1] = person.getPersonID();
            row[2] = person.getPhoneNo();
            row[3] = person.getEmailID();

            //row[1] = employee.getFirstName();
            model.addRow(row);
        }

    }

    public void populatePersonTable1() {
        DefaultTableModel model = (DefaultTableModel) docDepartmentTable.getModel();
        model.setRowCount(0);
        for (Person person : ecoSystem.getPersonDirectory().getPersonList()) {
            Object[] row = new Object[3];
            row[0] = person.getFirstName();
            row[1] = person.getLastName();
            //row[1] = employee.getFirstName();
            model.addRow(row);
        }
    }

    public void populateOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : organizationDir.getOrganizationList()) {
            organizationJComboBox.addItem(organization);
        }
    }

    public void populateOrganizationEmpComboBox() {
        organizationEmpJComboBox.removeAllItems();

        for (Organization organization : organizationDir.getOrganizationList()) {

            organizationEmpJComboBox.addItem(organization);
        }
    }

    private void populateTable(Organization organization) {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        model.setRowCount(0);
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            Object[] row = new Object[2];
            row[0] = employee.getEmpID();
            row[1] = employee.getFirstName() + " " + employee.getLastName();
            model.addRow(row);
        }
        if (organization instanceof DoctorOrganization) {
            DoctorOrganization doctorOrganization = (DoctorOrganization) organization;
            for (DoctorDepartment doctorDepartment : doctorOrganization.getDoctorDepartmentCatalog().getDoctorDepartmentCatalog()) {
                for (Doctor doctor : doctorDepartment.getDoctorDirectory().getDoctorList()) {
                    Object[] row = new Object[2];
                    row[0] = doctor.getEmpID();
                    row[1] = doctor.getFirstName() + " " + doctor.getLastName();
                    //row[1] = employee.getFirstName();
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

        jPanel1 = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();
        docDepTXt = new javax.swing.JLabel();
        docdepartTxt = new javax.swing.JTextField();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        addDocBtn = new javax.swing.JButton();
        addDocDepartmentBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        allpersonProfileTable = new javax.swing.JTable();
        panelDocTable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        docDepartmentTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        noteLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 930, 100, 35));

        docDepTXt.setText("Doc Department:");
        add(docDepTXt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 320, -1, -1));
        add(docdepartTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 310, 126, 35));

        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationEmpJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationEmpJComboBoxActionPerformed(evt);
            }
        });
        add(organizationEmpJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 190, 35));

        jLabel3.setText("Organization");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, -1, -1));

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Number", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 122, 630, 140));

        addJButton.setText("Create Employee");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 650, -1, 35));

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 180, 35));

        jLabel1.setText("Organization");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        addDocBtn.setText("Add Doctor");
        addDocBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDocBtnActionPerformed(evt);
            }
        });
        add(addDocBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 490, 100, 35));

        addDocDepartmentBtn.setText("Add Doc Department");
        addDocDepartmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDocDepartmentBtnActionPerformed(evt);
            }
        });
        add(addDocDepartmentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 400, -1, 35));

        allpersonProfileTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Person Name", "person Id", "Phone No", "Email ID"
            }
        ));
        jScrollPane3.setViewportView(allpersonProfileTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 640, 150));

        docDepartmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Doctor Department Name"
            }
        ));
        jScrollPane2.setViewportView(docDepartmentTable);

        javax.swing.GroupLayout panelDocTableLayout = new javax.swing.GroupLayout(panelDocTable);
        panelDocTable.setLayout(panelDocTableLayout);
        panelDocTableLayout.setHorizontalGroup(
            panelDocTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDocTableLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelDocTableLayout.setVerticalGroup(
            panelDocTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocTableLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        add(panelDocTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 110, 230, 190));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manage Employee");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        noteLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        noteLabel.setText("Note:- please select \"Add doctor\" button to add new doctor, Doctor can not create from bolow button.");
        add(noteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 560, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

        int selectedRow = allpersonProfileTable.getSelectedRow();

        if (selectedRow >= 0) {
            Person person = (Person) allpersonProfileTable.getValueAt(selectedRow, 0);
            Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
            
            if(!(organization instanceof DoctorOrganization))
            {
              Doctor employee = new Doctor();
            employee.setFirstName(person.getFirstName());
            employee.setLastName(person.getLastName());
            employee.setDob(person.getDob());
            employee.setEmailID(person.getEmailID());
            employee.setGender(person.getGender());
            employee.setInsuranceCode(person.getInsuranceCode());
            employee.setPersonID(person.getPersonID());
            employee.setPhoneNo(person.getPhoneNo());
            employee.setInsuranceCoverageLimit(person.getInsuranceCoverageLimit());
            organization.getEmployeeDirectory().addEmployee(employee);  
            }
            else {
            JOptionPane.showMessageDialog(null, "Select Doctor department and click on Add Doctor button to create Doctor,Can't create doctor from here");
        }
            
        } else {
            JOptionPane.showMessageDialog(null, "Please select row first");
        }


    }//GEN-LAST:event_addJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null) {
            populateTable(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void addDocDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocDepartmentBtnActionPerformed
        String docDepartment = docdepartTxt.getText();
        boolean isValid = checkuserInput(docDepartment);
        if (isValid) {
            Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
            if (organization instanceof DoctorOrganization) {
                DoctorOrganization docOrg = (DoctorOrganization) organization;
                doctorOrganization = docOrg;
                boolean isDepartmentPresent = checkDepartmentName(docDepartment, docOrg);
                if (isDepartmentPresent) {
                    DoctorDepartment docdepart = new DoctorDepartment(docDepartment);
                    DoctorDepartmentCatalog docDepCata = docOrg.getDoctorDepartmentCatalog();
                    docDepCata.addDocDepartment(docdepart);
                    populateDocDepartmentTable();
                    docdepartTxt.setText("");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please select doctor Organization");
            }
        }

    }//GEN-LAST:event_addDocDepartmentBtnActionPerformed

    //check department name aleady present
    public boolean checkDepartmentName(String departmentName, DoctorOrganization docOrg) {
        for (DoctorDepartment doctorDepartment : docOrg.getDoctorDepartmentCatalog().getDoctorDepartmentCatalog()) {
            if (doctorDepartment.getDoctorDepartmentName().equals(departmentName)) {
                JOptionPane.showMessageDialog(null, "Please Department Name already present");
                return false;
            }
        }
        return true;
    }

    // validate user input
    public boolean checkuserInput(String departmentName) {

        String validationerror = "Please correct the following error:";
        // validation for userName
        if ((departmentName.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Doctor Department Name ";
        }

        if (!(departmentName.trim()).equals("") && !(departmentName.trim()).equals("null")
                && !((departmentName.trim()).matches("[a-zA-Z0-9]*"))) {
            validationerror = validationerror + "\n" + "Department Name should "
                    + "contain Alphabet and numbers only";
        }

        if ((!(departmentName.trim()).equals("")) && (!(departmentName.trim().length() < 10))) {
            validationerror = validationerror + "\n" + " Department Name lenght should be less than 10";
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


    private void addDocBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocBtnActionPerformed

        int selectedRow = docDepartmentTable.getSelectedRow();

        if (selectedRow >= 0) {
            if(doctorOrganization!=null)
            {
             doctorDepartment = (DoctorDepartment) docDepartmentTable.getValueAt(selectedRow, 0);
            CreateDoctorWorkAreaJPanel createDoctorWorkAreaJPanel = new CreateDoctorWorkAreaJPanel(userProcessContainer, doctorDepartment, ecoSystem, doctorOrganization);
            userProcessContainer.add("CreateDoctorWorkAreaJPanel", createDoctorWorkAreaJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);   
            }
            else
            {
              JOptionPane.showMessageDialog(null, "Please select Doctor Organization");  
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Please select row first");
        }

    }//GEN-LAST:event_addDocBtnActionPerformed

    private void organizationEmpJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationEmpJComboBoxActionPerformed
        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        if (organization instanceof DoctorOrganization) {
            DoctorOrganization docOrg = (DoctorOrganization) organization;
            doctorOrganization = docOrg;
        }
    }//GEN-LAST:event_organizationEmpJComboBoxActionPerformed
    public void populateDocDepartmentTable() {
        DefaultTableModel model = (DefaultTableModel) docDepartmentTable.getModel();
        model.setRowCount(0);
        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        if (organization instanceof DoctorOrganization) {
            DoctorOrganization docOrg = (DoctorOrganization) organization;
            DoctorDepartmentCatalog docDepCata = docOrg.getDoctorDepartmentCatalog();
            for (DoctorDepartment docdepart : docDepCata.getDoctorDepartmentCatalog()) {
                Object[] row = new Object[2];
                row[0] = docdepart;
                //row[1] = employee.getFirstName();
                model.addRow(row);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDocBtn;
    private javax.swing.JButton addDocDepartmentBtn;
    private javax.swing.JButton addJButton;
    private javax.swing.JTable allpersonProfileTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel docDepTXt;
    private javax.swing.JTable docDepartmentTable;
    private javax.swing.JTextField docdepartTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JPanel panelDocTable;
    // End of variables declaration//GEN-END:variables
}
