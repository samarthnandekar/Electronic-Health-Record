/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class PersonDirectory {
    
    public ArrayList<Person> personList;

    public PersonDirectory()
    {
        personList= new ArrayList<>();
    }
    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
     public Person authenticateUser(String username, String password){
        for (Person person : personList)
            if (person.getUsername().equals(username) && person.getPassword().equals(password)){
                return person;
            }
        return null;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (Person person : personList){
            if (person.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
    public Person addPerson(Person person)
    {
        System.out.println("====inside add person ===============");
      personList.add(person);
      return person;
        
    }
}
