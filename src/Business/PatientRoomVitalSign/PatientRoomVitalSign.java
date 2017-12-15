/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientRoomVitalSign;

import java.util.Date;

/**
 *
 * @author samar
 */
public class PatientRoomVitalSign {
    
    private Float AirQualityIndex;
    private float Cleanness;
    private float Temperature;
    private float Humidity;
    private float AirChangesPerHour;
    private Date captureDate;
    
    public float getAirQualityIndex() {
        return AirQualityIndex;
    }

    public void setAirQualityIndex(float AirQualityIndex) {
        this.AirQualityIndex = AirQualityIndex;
    }

    public float getCleanness() {
        return Cleanness;
    }

    public void setCleanness(float Cleanness) {
        this.Cleanness = Cleanness;
    }

    public float getTemperature() {
        return Temperature;
    }

    public void setTemperature(float Temperature) {
        this.Temperature = Temperature;
    }

    public float getHumidity() {
        return Humidity;
    }

    public void setHumidity(float Humidity) {
        this.Humidity = Humidity;
    }

    public float getAirChangesPerHour() {
        return AirChangesPerHour;
    }

    public void setAirChangesPerHour(float AirChangesPerHour) {
        this.AirChangesPerHour = AirChangesPerHour;
    }

 

    public Date getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }

    

@Override
public String toString()
{
    return AirQualityIndex.toString();
}

}
