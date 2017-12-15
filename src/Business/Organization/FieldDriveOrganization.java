/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FieldDriverRole;
import Business.Role.NurseRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author samar
 */
public class FieldDriveOrganization extends Organization{

    public FieldDriveOrganization() {
         super(Organization.Type.FieldDrive.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new FieldDriverRole());
        return roles;
    }
    
}
