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
        GridLayout glCalc = new GridLayout(3, 1);
        GridLayout glTextField = new GridLayout(2, 1);
        GridLayout glMidButtons = new GridLayout(2, 5);
        GridLayout glBotButtons = new GridLayout(4, 3);
        
        JPanel pnlTop = new JPanel(glTextField);
        JPanel pnlMidButtons = new JPanel(glMidButtons);
        JPanel pnlBotButtons = new JPanel(glBotButtons);
        
        JTextField tfInput = new JTextField();
        JTextField tfOutput = new JTextField();
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
    
    public View()
    {
        
        InitForm();
    }
    
    private void InitForm()
    {
        this.setSize(450, 600);
        pnlTop.add(tfInput);
        pnlTop.add(tfOutput);
        tfOutput.setEditable(false);
        
        InitializeButtons();
        PlaceButtonsOnPanels();
        
        
        this.setLayout(glCalc);
        this.add(pnlTop);
        this.add(pnlMidButtons);
        this.add(pnlBotButtons);
        pnlTop.setVisible(true);
        pnlMidButtons.setVisible(true);
        pnlBotButtons.setVisible(true);
        this.setVisible(true);
    }
    
    private void PlaceButtonsOnPanels()
    {
        pnlMidButtons.add(buttonCosinus);
        pnlMidButtons.add(buttonSinus);
        pnlMidButtons.add(buttonClearAll);
        pnlMidButtons.add(buttonMultiply);
        pnlMidButtons.add(buttonDivide);
        pnlMidButtons.add(buttonAdd);
        pnlMidButtons.add(buttonSubtract);
        pnlMidButtons.add(buttonBackspace);
        pnlMidButtons.add(buttonTangens);
        pnlMidButtons.add(buttonEquals);
        pnlBotButtons.add(button7);
        pnlBotButtons.add(button8);
        pnlBotButtons.add(button9);
        pnlBotButtons.add(button4);
        pnlBotButtons.add(button5);
        pnlBotButtons.add(button6);
        pnlBotButtons.add(button1);
        pnlBotButtons.add(button2);
        pnlBotButtons.add(button3);
        pnlBotButtons.add(buttonInvert);
        pnlBotButtons.add(button0);
        pnlBotButtons.add(buttonPoint);
    }
    
    private void InitializeButtons()
    {
        button0.setText("0");
        button0.setSize(40, 40);    
        button1.setText("1");
        button1.setSize(40, 40);    
        button2.setText("2");
        button2.setSize(40, 40);    
        button3.setText("3");
        button3.setSize(40, 40);    
        button4.setText("4");
        button4.setSize(40, 40);    
        button5.setText("5");
        button5.setSize(40, 40);    
        button6.setText("6");
        button6.setSize(40, 40);    
        button7.setText("7");
        button7.setSize(40, 40);    
        button8.setText("8");
        button8.setSize(40, 40);    
        button9.setText("9");
        button9.setSize(40, 40);    
        buttonAdd.setText("+");
        buttonAdd.setSize(40, 40);    
        buttonSubtract.setText("-");
        buttonSubtract.setSize(40, 40);    
        buttonMultiply.setText("*");
        buttonMultiply.setSize(40, 40);    
        buttonDivide.setText("/");
        buttonDivide.setSize(40, 40);    
        buttonSinus.setText("sin");
        buttonSinus.setSize(40, 40);    
        buttonCosinus.setText("cos");
        buttonCosinus.setSize(40, 40);    
        buttonTangens.setText("tan");
        buttonTangens.setSize(40, 40);    
        buttonInvert.setText("+-");
        buttonInvert.setSize(40, 40);    
        buttonPoint.setText(".");
        buttonPoint.setSize(40, 40);    
        buttonBackspace.setText("<-");
        buttonBackspace.setSize(80, 40);    
        buttonClearAll.setText("Clear All");
        buttonClearAll.setSize(40, 40);    
        buttonEquals.setText("=");
        buttonEquals.setSize(40, 80);        
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
