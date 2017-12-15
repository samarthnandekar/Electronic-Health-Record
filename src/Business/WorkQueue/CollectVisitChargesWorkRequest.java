/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.PatientVisit.Visit;
import Business.VisitPayment.VisitCharges;

/**
 *
 * @author samar
 */
public class CollectVisitChargesWorkRequest extends WorkRequest {

    private Visit visit;
    private VisitCharges VisitCharges;
    public CollectVisitChargesWorkRequest() {
        visit = new Visit();
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

}
