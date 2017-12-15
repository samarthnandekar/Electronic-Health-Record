/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import Business.Role.AmbulanceReceptionistRole;
import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class OrganizationDirectory {
 
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory()
            {
                organizationList= new ArrayList<>();
            }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
 public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Nurse.getValue())){
            organization = new NurseOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Receptionist.getValue())){
            organization = new ReceptionistOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Pharmacist.getValue())){
            organization = new PharmacistOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Cashier.getValue())){
            organization = new CashierOrganization();
            organizationList.add(organization);
        }
          else if (type.getValue().equals(Type.FieldDrive.getValue())){
            organization = new FieldDriveOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.AmbulanceAssistant.getValue())){
            organization = new AmbulanceAssistantOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.AmbulanceReceptionist.getValue())){
            organization = new AmbulanceReceptionistOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
}
