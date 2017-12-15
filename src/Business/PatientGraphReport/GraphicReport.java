/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientGraphReport;

/**
 *
 * @author samar
 */
public class GraphicReport {
    
    private String imageName;
    private String imageWithPath;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageWithPath() {
        return imageWithPath;
    }

    public void setImageWithPath(String imageWithPath) {
        this.imageWithPath = imageWithPath;
    }

    @Override
    public String toString() {
        return imageName;
    }
    
    
}
