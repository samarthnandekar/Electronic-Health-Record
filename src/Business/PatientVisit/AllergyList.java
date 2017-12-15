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
public class AllergyList {
    
    private ArrayList<Allergy> allergylist;
    
    public AllergyList()
    {
    allergylist= new ArrayList<>();
    }
    
    public ArrayList<Allergy> getAllergylist() {
        return allergylist;
    }

    public void setAllergylist(ArrayList<Allergy> allergylist) {
        this.allergylist = allergylist;
    }
    
    public Allergy addAllergy(Allergy allergy)
    {
        allergylist.add(allergy);
        return allergy;
    }
    
}
