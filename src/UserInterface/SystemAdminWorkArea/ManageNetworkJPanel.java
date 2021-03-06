/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Network.Network;
import com.socket.ServerFrame;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samarth
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageNetworkJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    
    public ManageNetworkJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateNetworkTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        networkJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        networkTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 99, 35));

        networkJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Network Name"
            }
        ));
        jScrollPane1.setViewportView(networkJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, 96));

        jLabel1.setText("Nework Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        jButton2.setText("Create");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 100, 35));
        add(networkTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 116, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manager Network");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        jButton3.setText("Start Server for Chat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, -1, 35));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Note:-Please start the server for communication");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 630, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) networkJTable.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList().getNetworkList()) {
            Object[] row = new Object[1];
            row[0] = network.getName();
            model.addRow(row);
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String networkName = networkTxt.getText();
        boolean isUserInputValid=checkUserInput(networkName); 
        boolean isValidNetworkName=checkValidNetWorkName(networkName);
        if(isUserInputValid && isValidNetworkName)
        {
            Network network=new Network();
            Network network1 = system.getNetworkList().addNetwork(network);
            network1.setName(networkName.trim());
            networkTxt.setText("");
            populateNetworkTable();  
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       ServerFrame serverFrame= new ServerFrame();
       serverFrame.setVisible(true);
       serverFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton3ActionPerformed

    public boolean checkValidNetWorkName(String networkName)
    {
       for(Network network:system.getNetworkList().getNetworkList())
       {
           if(network.getName().equals(networkName))
           {
               JOptionPane.showMessageDialog(null, "Netowrk Name already Present");
                return false;
           }
                   
       }
       return true;
    }
    
    
    public boolean checkUserInput(String networkName)
    {
        String validationerror = "Please correct the following error:";
        
         if ((networkName.trim()).equals("")) {
            validationerror = validationerror + "\n" + "Please enter the Name";
         }
        if (!(networkName.trim()).equals("") && !(networkName.trim()).equals("null")
                && !((networkName.trim()).matches("[a-zA-Z0-9 ]*"))) {
            validationerror = validationerror + "\n" + "Name should "
                    + "contain Alphabet and numbers only";
        }
        if((!(networkName.trim()).equals("")) && (!(networkName.trim().length()<10)))
          {
        validationerror = validationerror + "\n" + "Name"
                                                     + " lenght should be less than 10";           
          }
        
        if (validationerror.equals("Please correct the following error:")) {
            validationerror = "Thanks for details";
            //JOptionPane.showMessageDialog(null, validationerror);
            return true;
        }
        else
        {
         JOptionPane.showMessageDialog(null, validationerror);
         return false;
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable networkJTable;
    private javax.swing.JTextField networkTxt;
    // End of variables declaration//GEN-END:variables
}
