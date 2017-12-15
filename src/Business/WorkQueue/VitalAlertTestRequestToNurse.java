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
public class VitalAlertTestRequestToNurse extends WorkRequest{
    
    
    private VitalSign vitalSign;
    private UserAccount secondReceiver;
    private Date secondReceiverDate;
    private UserAccount thirdReceiver;
    private Date thirdReceiverDate;   
    
    public VitalAlertTestRequestToNurse()
    {
       vitalSign= new VitalSign();
       secondReceiver= new UserAccount();
       thirdReceiver= new UserAccount();
       
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

    public UserAccount getThirdReceiver() {
        return thirdReceiver;
    }

    public void setThirdReceiver(UserAccount thirdReceiver) {
        this.thirdReceiver = thirdReceiver;
    }

    public Date getThirdReceiverDate() {
        return thirdReceiverDate;
    }

    public void setThirdReceiverDate(Date thirdReceiverDate) {
        this.thirdReceiverDate = thirdReceiverDate;
    }
 
    
    @Override
    public String toString()
    {
        return super.getSender().toString();
       
    }
    
}
