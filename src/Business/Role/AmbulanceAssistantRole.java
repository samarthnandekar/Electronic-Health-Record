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
import UserInterface.AmbulanceAssistant.AmbulanceAssistantWorkAreaJPanel;
import UserInterface.AmbulanceReception.AmbulanceReceptionWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author samar
 */
public class AmbulanceAssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return  new AmbulanceAssistantWorkAreaJPanel(userProcessContainer,account,organization,enterprise,business);
    }
    
}
