/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Samarth
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        //Person person= new Person("sys","admin" );
        Employee employee= new Employee("sysadmin");
        system.getEmployeeDirectory().addEmployee(employee);
        UserAccount userAccount= new UserAccount("sysadmin","sysadmin",employee, new SystemAdminRole());
        UserAccount ua = system.getUserAccountDirectory().addUserAccount(userAccount);
        System.out.println("====inside the ConfigureASystem=======");
        return system;
        
    }
    
}
