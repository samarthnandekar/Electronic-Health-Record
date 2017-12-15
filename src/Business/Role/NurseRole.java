/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.EnterPrise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Nurse.NurseAssistantWorkAreaJPanel;
import UserInterface.Nurse.NurseMainWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Samarth
 */
public class NurseRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new NurseMainWorkAreaJPanel(userProcessContainer,account,organization,enterprise,business);
    }
    
}
