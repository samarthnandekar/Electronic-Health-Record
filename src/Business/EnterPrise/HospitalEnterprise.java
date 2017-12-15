/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EnterPrise;

import Business.EnterPrise.Enterprise.EnterpriseType;
import Business.FieldDrive.FieldDriveForPatientsList;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class HospitalEnterprise extends Enterprise{
    
    private PatientDirectory patientDirectory;
    private FieldDriveForPatientsList fieldDriveForPatientsList;
    
    public HospitalEnterprise(String name) {
        super(name, EnterpriseType.Hospital);
        patientDirectory= new PatientDirectory();
        fieldDriveForPatientsList= new FieldDriveForPatientsList();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public FieldDriveForPatientsList getFieldDriveForPatientsList() {
        return fieldDriveForPatientsList;
    }

    public void setFieldDriveForPatientsList(FieldDriveForPatientsList fieldDriveForPatientsList) {
        this.fieldDriveForPatientsList = fieldDriveForPatientsList;
    }


    
    
}
