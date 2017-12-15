/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AmbulanceAssistantRole;
import Business.Role.NurseRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author samar
 */
public class AmbulanceAssistantOrganization extends Organization{

    public AmbulanceAssistantOrganization() {
        super(Organization.Type.AmbulanceAssistant.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AmbulanceAssistantRole());
        return roles;
    }
    
}
