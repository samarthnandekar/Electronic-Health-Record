/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Rules;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samarth
 */
public class RuleDirectory {
    
    private static RuleDirectory ruleDirectory;
    private List<Rule> ruleList;

    public static RuleDirectory getInstance() {
        if (ruleDirectory == null) {
            ruleDirectory = new RuleDirectory();
        }
        return ruleDirectory;
    }

    private RuleDirectory() {
        ruleList= new ArrayList<>();
    }
    
    
    public List<Rule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(ArrayList<Rule> ruleList) {
        this.ruleList = ruleList;
    }
    
    
}
