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
import UserInterface.Cashier.CashierWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author samar
 */
public class CashierRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CashierWorkAreaJPanel(userProcessContainer,account,organization,enterprise,business);
    }
    
}
