/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author bbsuser
 */
public class View extends JFrame
{ 
    private JTextField txtEingabe = new JTextField(3);
    private JButton btnBerechnen = new JButton("Berechnen >");
    private JTextField txtErgebnis = new JTextField(5);
    private JButton btnClearall = new JButton("Clear All");
    private JButton btnBack = new JButton("Back");
    
    public View()
    {
        GridLayout gridLayout = new GridLayout(3, 3);
        
        InitForm();
    }
    
    private void InitForm()
    {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(new FlowLayout());
       this.setBounds(200, 200, 500, 100);
       
       this.add(txtEingabe);
       this.add(btnBerechnen);
       this.add(txtErgebnis);
       this.add(btnClearall);
       this.add(btnBack);     
    }
    
    private void AddComponentsToPane(Container pane)
    {
        JButton button = new JButton();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        
    }
    
    public void ResetEingabe()
    {
      this.txtEingabe.setText("");
      this.txtErgebnis.setText("");   
    }
    
    public void DeleteLastCharacter()
    {
      JOptionPane.showMessageDialog(null, "Test", "Test Titel", JOptionPane.OK_CANCEL_OPTION);      
    }
    
    public void ButtonClick(ActionEvent aE)
    {
        
    }
    
    public String getEingabe()
    {
        return this.txtEingabe.getText();
    }
    
    public void SetErgebnis(String ferg)
    {
       this.txtErgebnis.setText(ferg);      
    }
    
    public void setBerechnenListener(ActionListener fl)
    {
      this.btnBerechnen.addActionListener(fl);
    }
    
    public void setResetListener(ActionListener fl)
    {
      this.btnClearall.addActionListener(fl);
    }
    
    public void setButtonClickListener(ActionListener fl)
    {
        
    }
    
    public void setDeleteListener(ActionListener fl)
    {
      this.btnBack.addActionListener(fl);
    }
}
