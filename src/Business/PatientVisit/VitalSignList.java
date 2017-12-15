/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientVisit;

import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class VitalSignList {
 
    private ArrayList<VitalSign> vitalList;

    public VitalSignList()
    {
        vitalList= new ArrayList<>();
    }
    public ArrayList<VitalSign> getVitalList() {
        return vitalList;
    }

    public void setVitalList(ArrayList<VitalSign> vitalList) {
        this.vitalList = vitalList;
    }
    
    public void addVitalSign(VitalSign vitalSign)
    {
        vitalList.add(vitalSign);
    }
}
