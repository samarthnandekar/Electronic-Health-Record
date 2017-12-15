/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samarth
 */
public class AppointmentDirectory {
    
    private ArrayList<Appointment> appointmentList;

    
    public AppointmentDirectory()
    {
        appointmentList= new ArrayList<Appointment>();
    }
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(ArrayList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
    
    public Appointment addAppointment(Appointment appointment)
    {
       appointmentList.add(appointment);
       return appointment;
    }
   
    
}
