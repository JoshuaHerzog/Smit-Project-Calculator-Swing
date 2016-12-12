/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import View.*;

/**
 *
 * @author Joshua Herzog
 */
public class Controller 
{
   private Model fModel;
   private View fView;
   
   public Controller()
   {
       this.fModel = new Model();
       this.fView = new View();
       
       addListener();
   }
   
   public void showView()
   {
       this.fView.setVisible(true);
   }
   
   private void addListener()
   {
     this.fView.setBerechnenListener(new BerechnenListener());
     this.fView.setButtonClickListener(new ButtonClickListener());
     this.fView.setDeleteListener(new DeleteListener());
     this.fView.setResetListener(new ResetListener());
   }
   
   class BerechnenListener implements ActionListener
   {
       @Override
       public void actionPerformed(ActionEvent aE)
       {
           String lEingabe = fView.getEingabe();
           fView.SetErgebnis(String.valueOf(fModel.Berechne(lEingabe)));
       }      
   }
   
   class ButtonClickListener implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent aE)
      {
          fView.ButtonClick(aE);       
      }        
   }
   
   class DeleteListener implements ActionListener
   {
     @Override
      public void actionPerformed(ActionEvent aE)
      {
          fView.DeleteLastCharacter();
      }     
   }
   
   class ResetListener implements ActionListener
   {
       @Override
      public void actionPerformed(ActionEvent aE)
      {
          fView.ResetEingabe();
          fModel.ClearAll();
      }     
   }
   
   
   
   
}
