/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionListenerPractice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Max
 */
public class ActionListenerThreePart
{
    private JFrame frame;
    private JButton button;
    private JTextField field;
    private JLabel label;
    
    public void PrepareGUI()
    {
        frame = new JFrame();
        frame.setLayout(new GridLayout(3,1));
        button = new JButton("Click me");
        field = new JTextField();
        label = new JLabel();
        frame.setSize(400, 400);
        frame.add(button);
        frame.add(field);
        frame.add(label);
        button.addActionListener(new CustomActionListener());
        frame.setVisible(true);
    }
    
    class CustomActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            label.setText(field.getText());
        }
    }
}
