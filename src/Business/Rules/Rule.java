/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Rules;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Samarth
 */
public class Rule {
    
    private String ruleName;
    private HashMap<String,ArrayList<String>> detailRule;

    
    public Rule()
    {
        detailRule=new HashMap<>();
    }
    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public HashMap<String, ArrayList<String>> getDetailRule() {
        return detailRule;
    }

    public void setDdetailRule(HashMap<String, ArrayList<String>> rule) {
        this.detailRule = rule;
    }
    
    @Override
    public String toString()
    {
        return ruleName;
    }
    
}
