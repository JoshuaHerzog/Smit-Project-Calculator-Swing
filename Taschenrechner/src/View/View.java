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
    /*private JTextField txtEingabe = new JTextField(3);
    private JButton btnBerechnen = new JButton("Berechnen >");
    private JTextField txtErgebnis = new JTextField(5);
    private JButton btnClearall = new JButton("Clear All");
    private JButton btnBack = new JButton("Back");*/
    
    public View()
    {
        
        InitForm();
    }
    
    private void InitForm()
    {
        this.setSize(200, 300);
        GridLayout glTextField = new GridLayout(2, 1);
        GridLayout glButtonsLeft = new GridLayout(6, 2);
        GridLayout glButtonTopRight = new GridLayout(1, 1);
        GridLayout glButtonsMiddleRight = new GridLayout(3, 2);
        GridLayout glButtonsBottomMiddle = new GridLayout(2, 1);
        GridLayout glButtonBottomRight = new GridLayout(1, 1);
        
        JPanel pnlTop = new JPanel();
        pnlTop.setLayout(glTextField);
        pnlTop.setBounds(0, 0, 180, 80);
        pnlTop.add(new JTextField());
        pnlTop.add(new JTextField());
        
        JLayeredPane pnlBottom = new JLayeredPane();
        pnlBottom.setBounds(new Rectangle(0, 300));
        JPanel pnlLeft = new JPanel(glButtonsLeft);
        JPanel pnlRight = new JPanel();
        pnlRight.setSize(100, 264);
        pnlLeft.setSize(100, 264);
        pnlBottom.add(pnlLeft);
        pnlBottom.add(pnlRight);
        JPanel pnlTopRight = new JPanel(glButtonTopRight);
        JPanel pnlMiddleRight = new JPanel(glButtonsMiddleRight);
        JPanel pnlBottomMiddle = new JPanel(glButtonsBottomMiddle);
        JPanel pnlBottomRight = new JPanel(glButtonBottomRight);
        pnlRight.add(pnlTopRight);
        pnlRight.add(pnlMiddleRight);
        pnlRight.add(pnlBottomMiddle);
        pnlRight.add(pnlBottomRight);
        
        JButton button0 = new JButton();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();
        JButton button5 = new JButton();
        JButton button6 = new JButton();
        JButton button7 = new JButton();
        JButton button8 = new JButton();
        JButton button9 = new JButton();
        JButton buttonAdd = new JButton();
        JButton buttonSubtract = new JButton();
        JButton buttonMultiply = new JButton();
        JButton buttonDivide = new JButton();
        JButton buttonSinus = new JButton();
        JButton buttonCosinus = new JButton();
        JButton buttonTangens = new JButton();
        JButton buttonInvert = new JButton();
        JButton buttonPoint = new JButton();
        JButton buttonBackspace = new JButton();
        JButton buttonClearAll = new JButton();
        JButton buttonEquals = new JButton();
        
        pnlLeft.add(button0);
        pnlLeft.add(button1);
        pnlLeft.add(button2);
        pnlLeft.add(button4);
        pnlLeft.add(button5);
        pnlLeft.add(button7);
        pnlLeft.add(button8);
        pnlLeft.add(buttonMultiply);
        pnlLeft.add(buttonDivide);
        pnlLeft.add(buttonSubtract);
        pnlLeft.add(buttonAdd);
        pnlLeft.add(buttonInvert);
        
        pnlBottom.add(pnlLeft, new Integer(1), 0);
        pnlBottom.add(pnlTopRight, new Integer(1), 0);
        pnlBottom.add(pnlMiddleRight, new Integer(1), 0);
        pnlBottom.add(pnlBottomMiddle, new Integer(1), 0);
        pnlBottom.add(pnlBottomRight, new Integer(1), 0);
        
        this.add(pnlTop);
        this.add(pnlBottom);
        pnlBottom.setVisible(true);
    }
    
    private void AddComponentsToPane(Container pane)
    {
                
    }
    
    public void ResetEingabe()
    {
        
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
        return "";
    }
    
    public void SetErgebnis(String ferg)
    {
        
    }
    
    public void setBerechnenListener(ActionListener fl)
    {
        
    }
    
    public void setResetListener(ActionListener fl)
    {
        
    }
    
    public void setButtonClickListener(ActionListener fl)
    {
        
    }
    
    public void setDeleteListener(ActionListener fl)
    {
        
    }
}
