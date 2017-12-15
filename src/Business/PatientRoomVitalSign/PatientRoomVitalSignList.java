/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientRoomVitalSign;

import java.util.ArrayList;

/**
 *
 * @author samar
 */
public class PatientRoomVitalSignList {
    
    private ArrayList<PatientRoomVitalSign> patientRoomVitalSignList;
    
    public PatientRoomVitalSignList()
    {
        patientRoomVitalSignList= new ArrayList<>();
    }

    public ArrayList<PatientRoomVitalSign> getPatientRoomVitalSignList() {
        return patientRoomVitalSignList;
    }

    public void setPatientRoomVitalSignList(ArrayList<PatientRoomVitalSign> patientRoomVitalSignList) {
        this.patientRoomVitalSignList = patientRoomVitalSignList;
    }
    
    public PatientRoomVitalSign addPatientRoomVitalSign(PatientRoomVitalSign patientRoomVitalSign)
    {
        patientRoomVitalSignList.add(patientRoomVitalSign);
        return patientRoomVitalSign;
    }
    
    
}
