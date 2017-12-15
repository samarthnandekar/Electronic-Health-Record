/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Person.Person;

/**
 *
 * @author Samarth
 */
public class Employee extends Person{
    
    //private Person person;
    private int empID;
    private String status;
    private static int count1;
    
    public Employee()
    {
        count1++;
        empID=count1;
    }
    public Employee(String name)
    {
      super(name);
       count1++;
       empID=count1; 
       
    }
    /*
   public Employee(Person person,String status)
   {
       this.person=person;
       this.status=status;
       
   }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
*/
    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString()
    {
        return super.getFirstName()+" "+super.getLastName();
    }
}
