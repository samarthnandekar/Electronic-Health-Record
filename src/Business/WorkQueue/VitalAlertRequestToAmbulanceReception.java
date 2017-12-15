/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.PatientVisit.VitalSign;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author samar
 */
public class VitalAlertRequestToAmbulanceReception extends WorkRequest {
 
    private VitalSign vitalSign;
    private UserAccount secondReceiver;
    private Date secondReceiverDate;
    
     public VitalAlertRequestToAmbulanceReception()
    {
       vitalSign= new VitalSign();
       secondReceiver= new UserAccount();
    }

    public VitalSign getVitalSign() {
        return vitalSign;
    }

    public void setVitalSign(VitalSign vitalSign) {
        this.vitalSign = vitalSign;
    }

    public UserAccount getSecondReceiver() {
        return secondReceiver;
    }

    public void setSecondReceiver(UserAccount secondReceiver) {
        this.secondReceiver = secondReceiver;
    }

    public Date getSecondReceiverDate() {
        return secondReceiverDate;
    }

    public void setSecondReceiverDate(Date secondReceiverDate) {
        this.secondReceiverDate = secondReceiverDate;
    }
     
    
     @Override
    public String toString()
    {
        return super.getSender().toString();
       
    }
    
     
}
