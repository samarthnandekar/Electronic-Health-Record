/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.PatientVisit.Visit;

/**
 *
 * @author samar
 */
public class GraphicalReportToNurse extends WorkRequest{
    
    private Visit visit;
    
   public GraphicalReportToNurse()
    {
        visit= new Visit();
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
     @Override
    public String toString()
    {
        return super.getSender().getFirstName()+" "+super.getSender().getLastName();
    }
    
}
