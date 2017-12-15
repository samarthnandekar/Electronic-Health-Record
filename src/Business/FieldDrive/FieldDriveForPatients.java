/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FieldDrive;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author samar
 */
public class FieldDriveForPatients {
    
    private int fieldDriveID;
    private static int counterID = 1;
    private String drivename;
    private ArrayList<UserAccount> userfdList;
    private Date drivestartDate;
    private Date driveendDate;
    
    public FieldDriveForPatients() {
        fieldDriveID = counterID++;
        userfdList = new ArrayList<UserAccount>();
    }

    public int getFieldDriveID() {
        return fieldDriveID;
    }

    public void setFieldDriveID(int fieldDriveID) {
        this.fieldDriveID = fieldDriveID;
    }

    public String getDrivename() {
        return drivename;
    }

    public void setDrivename(String drivename) {
        this.drivename = drivename;
    }

    public ArrayList<UserAccount> getUserfdList() {
        return userfdList;
    }

    public void setUserfdList(ArrayList<UserAccount> userfdList) {
        this.userfdList = userfdList;
    }

    public Date getDrivestartDate() {
        return drivestartDate;
    }

    public void setDrivestartDate(Date drivestartDate) {
        this.drivestartDate = drivestartDate;
    }

    public Date getDriveendDate() {
        return driveendDate;
    }

    public void setDriveendDate(Date driveendDate) {
        this.driveendDate = driveendDate;
    }

    @Override
    public String toString() {
        return  drivename;
    }
    
    
}
