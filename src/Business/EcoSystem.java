/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Network.NetworkDirectory;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class EcoSystem extends Organization {
    
    private static EcoSystem ecoSystem;
    private NetworkDirectory networkList;
    private PersonDirectory personDirectory;
    
    public static EcoSystem getInstance() {
        if (ecoSystem == null) {
            ecoSystem = new EcoSystem();
            System.out.println("===inside the eco get Instance=======");
        }
        return ecoSystem;
    }
    
    private EcoSystem() {
      super(null);
        networkList = new NetworkDirectory();
        personDirectory = new PersonDirectory();
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

   

    public static EcoSystem getEcoSystem() {
        return ecoSystem;
    }

    public static void setEcoSystem(EcoSystem ecoSystem) {
        EcoSystem.ecoSystem = ecoSystem;
    }

    public NetworkDirectory getNetworkList() {
        return networkList;
    }

    public void setNetworkList(NetworkDirectory networkList) {
        this.networkList = networkList;
    }

   
   
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    
    
    
    
}
