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
public class MedicationList {
    
    private ArrayList<Medication> medicationList;
     
    public MedicationList()
    {
       medicationList= new ArrayList<>();
    }
    
    public ArrayList<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(ArrayList<Medication> medicationList) {
        this.medicationList = medicationList;
    }
    
    public Medication addMedication(Medication medication)
    {
       medicationList.add(medication);
       return medication;
    }
    
    public void removeMedication(Medication medication)
    {
       medicationList.remove(medication);
    }
}
