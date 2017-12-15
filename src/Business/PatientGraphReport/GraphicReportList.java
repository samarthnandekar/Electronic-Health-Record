/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientGraphReport;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author samar
 */
public class GraphicReportList {
    
    private ArrayList<GraphicReport> GraphicReportList;
 
    public GraphicReportList()
    {
       GraphicReportList=new ArrayList<>(); 
    }

    public ArrayList<GraphicReport> getGraphicReportList() {
        return GraphicReportList;
    }

    public void setGraphicReportList(ArrayList<GraphicReport> GraphicReportList) {
        this.GraphicReportList = GraphicReportList;
    }
    
    public GraphicReport addGraphicReporttoList(GraphicReport graphicReport)
    {
        GraphicReportList.add(graphicReport);
        return graphicReport;
    }
}
