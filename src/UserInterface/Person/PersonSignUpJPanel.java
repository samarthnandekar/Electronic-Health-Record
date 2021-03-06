/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Person;

import Business.EcoSystem;
import Business.EnterPrise.Enterprise;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.UserAccount.UserAccount;
import UserInterface.Patient.PatientMainWorkAreaJPanel;
import UserInterface.Patient.PatientViewAndTakeAppointment;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Samarth
 */
public class PersonSignUpJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PersonSignUpJPanel
     */
    public JPanel userProcessContainer;
    public EcoSystem ecoSystem;
    public Organization organization;
    public Enterprise enterprise;
    public UserAccount userAccount;

    public PersonSignUpJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        ecoSystem = system;

        populateGenderCombox();

    }

    public void populateGenderCombox() {
        selectGenderCombox.removeAllItems();
        selectGenderCombox.addItem("Male");
        selectGenderCombox.addItem("Female");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lNametxt = new javax.swing.JTextField();
        fNametxt = new javax.swing.JTextField();
        phoneNotxt = new javax.swing.JTextField();
        emailidtxt = new javax.swing.JTextField();
        insuranceCodeTxt = new javax.swing.JTextField();
        insuranceCoverLimitxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        userPassword = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dobPicker = new org.jdesktop.swingx.JXDatePicker();
        selectGenderCombox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        locationLongTxt = new javax.swing.JTextField();
        locationLatiTxt = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("PLease provide the below details");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        jLabel2.setText("First Name:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        jLabel3.setText("Last Name:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jLabel4.setText("Gender:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 60, -1));

        jLabel5.setText("Date of Birth:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        jLabel6.setText("Phone No:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, -1));

        jLabel7.setText("Email ID:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, -1));

        jLabel9.setText("Insurance Code:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        jLabel10.setText("Insurance Coverage Limit:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, -1, -1));
        add(lNametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 120, 35));
        add(fNametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 120, 35));
        add(phoneNotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 120, 35));
        add(emailidtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 120, 35));
        add(insuranceCodeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 120, 35));
        add(insuranceCoverLimitxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 120, 35));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 830, 100, 35));
        add(userPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 580, 120, 35));

        jLabel11.setText("Password:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, -1, -1));
        add(userNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 120, 35));

        jLabel12.setText("User Name:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, -1, -1));
        add(dobPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, -1, 35));

        selectGenderCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(selectGenderCombox, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 120, 35));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Sign Up Page");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jLabel13.setText("Note:- All the above fileds are mandatory.");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 780, -1, -1));

        jLabel14.setText("location latitude:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 650, -1, -1));

        jLabel15.setText("Location longitude:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 720, -1, -1));
        add(locationLongTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 710, 120, 35));
        add(locationLatiTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 640, 120, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String firstName = (fNametxt.getText()).trim();
        String lastName = (lNametxt.getText()).trim();

        String gender = (String) selectGenderCombox.getSelectedItem();

        Date date1 = dobPicker.getDate();

        String userPhone = (phoneNotxt.getText()).trim();
        String Uemails = (emailidtxt.getText()).trim();

        String insurcenCode = (insuranceCodeTxt.getText()).trim();
        String insuranceCover = (insuranceCoverLimitxt.getText()).trim();

        char[] passwordCharArray = userPassword.getPassword();
        String uPassword = String.valueOf(passwordCharArray);

        String userName = (userNameTxt.getText()).trim();
        String latitude = (locationLatiTxt.getText()).trim();
        String longitude = (locationLongTxt.getText()).trim();

        boolean isUserInputValid = checkUserInput(firstName, lastName, date1, userPhone, Uemails, insurcenCode, insuranceCover, userName, uPassword, latitude, longitude);

        try {
            Double.parseDouble(latitude.trim());
            Double.parseDouble(longitude.trim());
            System.out.println("==== in side the try block----");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "please enter valid value for latitude and longitude");
            isUserInputValid=false;
        }

        if (isUserInputValid) {

            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/YYYY");
            String doBirth = sdf1.format(date1);

            int insuranceLimit = Integer.parseInt(insuranceCover);
            Boolean userinput = searchForPerson(userName);
            if (userinput) {
       //String userinsurance=(String)selectHasInsuValueCombox.getSelectedItem();     

                Person person = new Person();

                PersonDirectory pd = ecoSystem.getPersonDirectory();
                System.out.println("person name-->" + person.getFirstName());

                pd.addPerson(person);
                String temppersonname = firstName.trim();
                person.setFirstName(temppersonname);
                person.setLastName(lastName);
                person.setGender(gender);
                person.setDob(doBirth);
                person.setPhoneNo(userPhone);
                person.setEmailID(Uemails);
                // person.setHasInsurance(userinsurance);
                person.setInsuranceCode(insurcenCode);
                person.setInsuranceCoverageLimit(insuranceLimit);
                person.setUsername(userName);
                person.setPassword(uPassword.trim());
                person.setLatitude(Double.parseDouble(latitude.trim()));
                person.setLongitude(Double.parseDouble(longitude.trim()));
                PersonViewAndTakeAppointment panel = new PersonViewAndTakeAppointment(userProcessContainer, enterprise, person, ecoSystem);
                userProcessContainer.add("PersonViewAndTakeAppointment", panel);
                CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
                cardLayout.next(userProcessContainer);

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cearText() {
        fNametxt.setText("");
        lNametxt.setText("");
        phoneNotxt.setText("");
        emailidtxt.setText("");
        insuranceCodeTxt.setText("");
        insuranceCoverLimitxt.setText("");
        userNameTxt.setText("");
        userPassword.setText("");
        locationLatiTxt.setText("");
        locationLongTxt.setText("");
    }

    public boolean checkUserInput(String firstName, String lastName, Date dobDate, String userPhone, String Uemails, String insurcenCode, String insuranceLimit, String userName, String uPassword, String latitude, String longitude) {
        String validationerror = "Please correct the following error:";

        // validation for First Name
        if ((firstName.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the First name";
        }
        if (!(firstName.trim()).equals("") && !(firstName.trim()).equals("null")
                && !((firstName.trim()).matches("[a-zA-Z]*"))) {
            validationerror = validationerror + "\n" + "First name should "
                    + "contain characters only";
        }

        // validation for Last Name
        if ((lastName.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Last name";
        }
        if (!(lastName.trim()).equals("") && !(lastName.trim()).equals("null")
                && !((lastName.trim()).matches("[a-zA-Z]*"))) {
            validationerror = validationerror + "\n" + "Last name should "
                    + "contain characters only";
        }

        // validation for user Phone Number
        if ((userPhone.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Phone Number";
        }
        if (!(userPhone.trim()).equals("") && !(userPhone.trim()).equals("null")
                && !((userPhone.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "Phone Number should "
                    + "contain numbers only";
        }
        if ((!(userPhone.trim()).equals("")) && (!(userPhone.trim().length() == 10))) {
            validationerror = validationerror + "\n" + "Please enter the valid"
                    + " phone no, lenght should be Ten";
        }
        // validation for user Date of birth(dobDate)
        if (dobDate == null) {
            validationerror = validationerror + "\n" + "Please enter the Date of Birth";
        }

        // validation for Uemails
        if ((Uemails.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the email id";
        }

         // validation for insurcenCode
        if ((insurcenCode.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Insurance Code";
        }
        if (!(insurcenCode.trim()).equals("") && !(insurcenCode.trim()).equals("null")
                && !((insurcenCode.trim()).matches("[a-zA-Z0-9]*"))) {
            validationerror = validationerror + "\n" + "Insurance Code should "
                    + "contain Alphabet and numbers only";
        }
        if ((!(insurcenCode.trim()).equals("")) && (!(insurcenCode.trim().length() < 10))) {
            validationerror = validationerror + "\n" + "Please enter the valid"
                    + " Insurance Code, lenght should be less than 10";
        }

        //validation for insuranceLimit
        if ((insuranceLimit.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Insurance Coverage limit";
        }
        if (!(insuranceLimit.trim()).equals("") && !(insuranceLimit.trim()).equals("null")
                && !((insuranceLimit.trim()).matches("[0-9]*"))) {
            validationerror = validationerror + "\n" + "Insurance Coverage limit should "
                    + "contain numbers only";
        }
        if ((!(insuranceLimit.trim()).equals("")) && (!(insuranceLimit.trim().length() < 10))) {
            validationerror = validationerror + "\n" + "Please enter the valid"
                    + " Insurance Coverage limit, lenght should be less than 10";
        }

        // validation for userName
        if ((userName.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the User Name";
        }

        if (!(userName.trim()).equals("") && !(userName.trim()).equals("null")
                && !((userName.trim()).matches("[a-zA-Z0-9]*"))) {
            validationerror = validationerror + "\n" + "userName should "
                    + "contain Alphabet and numbers only";
        }

        if ((!(userName.trim()).equals("")) && (!(userName.trim().length() < 10))) {
            validationerror = validationerror + "\n" + "Please enter the valid"
                    + " Insurance Coverage limit, lenght should be less than 10";
        }

        //validation for user password
        if ((uPassword.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Password";
        }
        if ((!(uPassword.trim()).equals("")) && (!(uPassword.trim().length() < 10))) {
            validationerror = validationerror + "\n" + "Please enter the valid"
                    + " password, lenght should be less than 10";
        }

        //validation for latitude
        if ((latitude.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the latitude";
        }
        if ((!(latitude.trim()).equals("")) && (!(latitude.trim().length() < 25))) {
            validationerror = validationerror + "\n" + "latitude value can not be more than 25, please enter valid number";
        }

        //validation for longitude
        if ((longitude.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the longitude";
        }
        if ((!(longitude.trim()).equals("")) && (!(longitude.trim().length() < 25))) {
            validationerror = validationerror + "\n" + "longitude value can not be more than 25, please enter valid number";
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

    public Boolean searchForPerson(String currUserName) {
        PersonDirectory personDirectory = ecoSystem.getPersonDirectory();
        for (Person personloop : personDirectory.getPersonList()) {
            if (personloop.getUsername().equalsIgnoreCase(currUserName)) {
                JOptionPane.showMessageDialog(null, "User Name already Present,Please select any other name");
                return false;
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker dobPicker;
    private javax.swing.JTextField emailidtxt;
    private javax.swing.JTextField fNametxt;
    private javax.swing.JTextField insuranceCodeTxt;
    private javax.swing.JTextField insuranceCoverLimitxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lNametxt;
    private javax.swing.JTextField locationLatiTxt;
    private javax.swing.JTextField locationLongTxt;
    private javax.swing.JTextField phoneNotxt;
    private javax.swing.JComboBox selectGenderCombox;
    private javax.swing.JTextField userNameTxt;
    private javax.swing.JPasswordField userPassword;
    // End of variables declaration//GEN-END:variables
}
