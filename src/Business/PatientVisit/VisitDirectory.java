/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientVisit;

import java.util.ArrayList;

/**
 *
 * @author Samarth
 */
public class VisitDirectory {
 
    private ArrayList<Visit> visitList;
    
    public VisitDirectory()
    {
       visitList= new ArrayList<>();
    }

    public ArrayList<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(ArrayList<Visit> visitList) {
        this.visitList = visitList;
    }
    
    public void addVisit(Visit visit)
    {
       visitList.add(visit);
    }
}
