/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author Maximilian Frerichs, Joshua Herzog
 * 
 * The View have 
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
        GridLayout glMidButtons = new GridLayout(4, 3);
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
        JButton buttonParenthesisOpen = new JButton();
        JButton buttonParenthesisClosed = new JButton();
    
    //Constructor
    public View()
    {   
        InitForm();
    }
    
    //Initialisation Method/build the form with gridlayout
    private void InitForm()
    {
        this.setSize(450, 600);
        tfInput.setFont(new Font("Arial", 1, 28));
        tfOutput.setFont(new Font("Arial", 1, 28));
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
        pnlMidButtons.add(buttonAdd);
        pnlMidButtons.add(buttonSinus);
        pnlMidButtons.add(buttonParenthesisOpen);
        pnlMidButtons.add(buttonSubtract);
        pnlMidButtons.add(buttonCosinus);
        pnlMidButtons.add(buttonParenthesisClosed);
        pnlMidButtons.add(buttonMultiply);
        pnlMidButtons.add(buttonTangens);
        pnlMidButtons.add(buttonBackspace);
        pnlMidButtons.add(buttonDivide);
        pnlMidButtons.add(buttonClearAll);
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
        button1.setText("1");
        button2.setText("2");
        button3.setText("3");
        button4.setText("4");
        button5.setText("5");
        button6.setText("6");
        button7.setText("7");
        button8.setText("8");
        button9.setText("9");
        buttonAdd.setText("+");  
        buttonSubtract.setText("-");
        buttonMultiply.setText("*");
        buttonDivide.setText("/");
        buttonSinus.setText("sin");   
        buttonCosinus.setText("cos");
        buttonTangens.setText("tan");
        buttonInvert.setText("+-");
        buttonPoint.setText(".");  
        buttonBackspace.setText("<-");
        buttonClearAll.setText("Clear All");
        buttonEquals.setText("="); 
        buttonParenthesisOpen.setText("(");
        buttonParenthesisClosed.setText(")");
    }
    
    public void ResetEingabe()
    {
      tfInput.setText("");
      tfOutput.setText("");
    }
    
    public void DeleteLastCharacter()
    {
      String leingabe = tfInput.getText();
      if (!leingabe.isEmpty())
      {
        Pattern lp = Pattern.compile("\\d$"); //Check for numbers
        Matcher lm = lp.matcher(leingabe);
            
        if(lm.find())
            leingabe = leingabe.substring(0, lm.start());
        else
        {
          lp = Pattern.compile("sin\\($|cos\\($|tan\\($");
          lm = lp.matcher(leingabe);
          if(lm.find())
            leingabe = leingabe.substring(0, lm.start());
          else
          {
            lm = Pattern.compile("\\+$|-$|\\*$|/$|\\($|\\)$|.$").matcher(leingabe);
            if (lm.find())
              leingabe = leingabe.substring(0, lm.start());    
          }             
        } 
        tfInput.setText(leingabe);
      }
     }
    
    public void ButtonClick(ActionEvent aE)
    {
      String lEingabe = aE.getActionCommand();
      if ("+-".equals(lEingabe))
        lEingabe = "-";
      if ("sin".equals(lEingabe) || "cos".equals(lEingabe) || "tan".equals(lEingabe))
          lEingabe = lEingabe + "(";
      tfInput.setText(tfInput.getText() + lEingabe);
    }
    
    public String getEingabe()
    {
        return tfInput.getText();
    }
    
    public void SetErgebnis(String aErg)
    {
       tfOutput.setText(aErg);
    }
    
    //From here link the Actionlisteners with the Components
    public void setBerechnenListener(ActionListener al)
    {
      this.buttonEquals.addActionListener(al);
    }
    
    public void setResetListener(ActionListener al)
    {
      this.buttonClearAll.addActionListener(al);
    }
    
    public void setButtonClickListener(ActionListener al)
    {
      this.button0.addActionListener(al);
      this.button1.addActionListener(al);
      this.button2.addActionListener(al);
      this.button3.addActionListener(al);
      this.button4.addActionListener(al);
      this.button5.addActionListener(al);
      this.button6.addActionListener(al);
      this.button7.addActionListener(al);
      this.button8.addActionListener(al);
      this.button9.addActionListener(al);
      this.buttonCosinus.addActionListener(al);
      this.buttonDivide.addActionListener(al);
      this.buttonInvert.addActionListener(al);
      this.buttonMultiply.addActionListener(al);
      this.buttonPoint.addActionListener(al);
      this.buttonSinus.addActionListener(al);
      this.buttonSubtract.addActionListener(al);
      this.buttonTangens.addActionListener(al);
      this.buttonAdd.addActionListener(al);
      this.buttonParenthesisClosed.addActionListener(al);
      this.buttonParenthesisOpen.addActionListener(al);
    }
    
    public void setDeleteListener(ActionListener al)
    {
      this.buttonBackspace.addActionListener(al);
    }
}
