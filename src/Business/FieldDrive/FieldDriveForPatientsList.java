/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FieldDrive;

import java.util.ArrayList;

/**
 *
 * @author samar
 */
public class FieldDriveForPatientsList {
 
    private ArrayList<FieldDriveForPatients> fdForPatientsList;
    
    public FieldDriveForPatientsList()
    {
        fdForPatientsList= new ArrayList<>();
    }

    public ArrayList<FieldDriveForPatients> getFdForPatientsList() {
        return fdForPatientsList;
    }

    public void setFdForPatientsList(ArrayList<FieldDriveForPatients> fdForPatientsList) {
        this.fdForPatientsList = fdForPatientsList;
    }
    
    public FieldDriveForPatients addFieldDrives()
    {
        FieldDriveForPatients filedDriveForPatients= new FieldDriveForPatients();
        fdForPatientsList.add(filedDriveForPatients);
        return filedDriveForPatients;
    }
    
}
