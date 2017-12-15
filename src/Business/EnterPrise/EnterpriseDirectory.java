/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EnterPrise;

import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterPriseList;

    public EnterpriseDirectory() {
        enterPriseList = new ArrayList<>();
    }
    
    public ArrayList<Enterprise> getEnterPriseList() {
        return enterPriseList;
    }

    public void setEnterPriseList(ArrayList<Enterprise> enterPriseList) {
        this.enterPriseList = enterPriseList;
    }
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Hospital){
            enterprise = new HospitalEnterprise(name);
            enterPriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.Ambulance)
          {
            enterprise = new AmbulanceEnterprise(name);
            enterPriseList.add(enterprise);       
          }
        return enterprise;
    }
    
}
