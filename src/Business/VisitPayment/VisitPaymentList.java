/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VisitPayment;

import java.util.ArrayList;

/**
 *
 * @author samar
 */
public class VisitPaymentList {
    
    private ArrayList<VisitCharges> visitPaymentList;

    public VisitPaymentList()
    {
        visitPaymentList= new ArrayList<>();
    }
    
    public ArrayList<VisitCharges> getVisitPaymentList() {
        return visitPaymentList;
    }

    public void setVisitPaymentList(ArrayList<VisitCharges> visitPaymentList) {
        this.visitPaymentList = visitPaymentList;
    }
    
    public VisitCharges addVisitPayment(VisitCharges visitPayment)
    {
        visitPaymentList.add(visitPayment);
        return visitPayment;
    }
    
}
