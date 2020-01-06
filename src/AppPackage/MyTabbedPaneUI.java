/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 *
 * @author Diego
 */
public class MyTabbedPaneUI extends javax.swing.plaf.basic.BasicTabbedPaneUI {
    
    
    public static ComponentUI createUI(JComponent c) {
        return new MyTabbedPaneUI();
    }
    
    //Icon iconTemp = new javax.swing.ImageIcon(getClass().getResource("/AppPackage/tabTemp.png"));
    
    // <editor-fold defaultstate="collapsed" desc="Set color properties">
    public void setShadow(Color shadow) {
        this.shadow = shadow;
    }
    
    public void setLightHighlight(Color lightHighlight) {
        this.lightHighlight = lightHighlight;
    }
    
    public void setDarkShadow(Color darkShadow) {
        this.darkShadow = darkShadow;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Find default scroll buttons">
    private Component findBackwardButton() {
            Component[] comps = tabPane.getComponents();
            for(Component comp:comps) {
                if(comp instanceof BasicArrowButton) {
                    int direction = ((BasicArrowButton)comp).getDirection();
                    if(tabPane.getTabPlacement() == LEFT || tabPane.getTabPlacement() == RIGHT) {
                        if(direction == NORTH) {
                            return comp;
                        }
                    }
                } else {
                }
            }
            return null;
    }
    
    private Component findForwardButton() {
            Component[] comps = tabPane.getComponents();
            for(Component comp:comps) {
                if(comp instanceof BasicArrowButton) {
                    int direction = ((BasicArrowButton)comp).getDirection();
                    if(tabPane.getTabPlacement() == LEFT || tabPane.getTabPlacement() == RIGHT) {
                        if(direction == SOUTH) {
                            return comp;
                        }
                    }
                } else {
                }
            }
            return null;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="paintTab">
    @Override
    protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, 
               int tabIndex, Rectangle iconRect, Rectangle textRect) {
       
      this.setShadow(new Color(35,35,35));          // colors used to
      this.setDarkShadow(new Color(255,215,0));     // paint the borders
      this.setLightHighlight(new Color(255,215,0)); // of each tab
        
      if (tabIndex <= 10){
      
        Color savedColor = g.getColor();
        g.setColor(new Color(35,35,35)); //myDarkGrey
        g.fillRect(rects[tabIndex].x, rects[tabIndex].y, 
               rects[tabIndex].width, rects[tabIndex].height);
        g.setColor(new Color(255,215,0));  //myGold
        g.drawRect(rects[tabIndex].x, rects[tabIndex].y, 
               rects[tabIndex].width, rects[tabIndex].height);
        g.setColor(savedColor);
      } else {
      
        Color savedColor = g.getColor();
        g.setColor(new Color(35,35,35)); //myDarkGrey
        g.fillRect(rects[tabIndex].x, rects[tabIndex].y, 
               rects[tabIndex].width, 0);
        g.setColor(new Color(255,215,0));  //myGold
        g.drawRect(rects[tabIndex].x, rects[tabIndex].y, 
               rects[tabIndex].width, 0);
        g.setColor(savedColor);
      
        }
      
      // Find default scroll buttons, move them in background and set them invisible
      Component downArrow = findBackwardButton();
      Component upArrow = findForwardButton();
            downArrow.setBounds(30, 420, 10, 20);
            upArrow.setBounds(30, 440, 10, 20);
            downArrow.setEnabled(false);
            upArrow.setEnabled(false);
            downArrow.setVisible(false);
            upArrow.setVisible(false);
            
      stickIcon(g, rects, tabIndex); // call the mothod delegated to paint the tab icons
        
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Tab dimensions">
    @Override
    protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
        return 60;
    }
    
    @Override
    protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
        if (tabIndex <= 10){ return 60;
        } else{ return 9; // phantom tab
          }
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="stick icons to tabs">
    public void stickIcon(Graphics g, Rectangle[] rects, int tabIndex){
        
        int selectedIndex = tabPane.getSelectedIndex();
        boolean isSelected = selectedIndex == tabIndex;
        
        switch(tabIndex){
            case 0:
                BufferedImage enerIconTab = null;
                InputStream selectedEner = getClass().getResourceAsStream("enerIcon2.png");
                InputStream unselectedEner = getClass().getResourceAsStream("enerIcon.png");
                
                if(isSelected){
                try {
                     //enerIconTab = ImageIO.read(new File("C:\\Users\\Diego\\Documents\\NetBeansProjects\\BuddyConverter\\src\\AppPackage\\enerIcon2.png"));
                     enerIconTab = ImageIO.read(selectedEner);
                     g.drawImage(enerIconTab.getScaledInstance(enerIconTab.getWidth()/2,enerIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                    System.out.println("An error occured while trying to retrieve the energy-tab image for the scroll bar:");
                    System.out.println(e);
                    }
                }else{
                    try {
                     enerIconTab = ImageIO.read(unselectedEner);
                     g.drawImage(enerIconTab.getScaledInstance(enerIconTab.getWidth()/2,enerIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the energy-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            case 1:
                BufferedImage presIconTab = null;
                InputStream selectedPres = getClass().getResourceAsStream("presIcon2.png");
                InputStream unselectedPres = getClass().getResourceAsStream("presIcon.png");
                if(isSelected){
                try {
                     presIconTab = ImageIO.read(selectedPres);
                     g.drawImage(presIconTab.getScaledInstance(presIconTab.getWidth()/2,presIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the pressure-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }else{
                    try {
                     presIconTab = ImageIO.read(unselectedPres);
                     g.drawImage(presIconTab.getScaledInstance(presIconTab.getWidth()/2,presIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the pressure-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            case 2:
                BufferedImage lengIconTab = null;
                InputStream selectedLeng = getClass().getResourceAsStream("lengIcon2.png");
                InputStream unselectedLeng = getClass().getResourceAsStream("lengIcon.png");
                if(isSelected){
                try {
                     lengIconTab = ImageIO.read(selectedLeng);
                     g.drawImage(lengIconTab.getScaledInstance(lengIconTab.getWidth()/2,lengIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the length-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }else{
                    try {
                     lengIconTab = ImageIO.read(unselectedLeng);
                     g.drawImage(lengIconTab.getScaledInstance(lengIconTab.getWidth()/2,lengIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the length-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            case 3:
                BufferedImage areaIconTab = null;
                InputStream selectedArea = getClass().getResourceAsStream("areaIcon2.png");
                InputStream unselectedArea = getClass().getResourceAsStream("areaIcon.png");
                if(isSelected){
                try {
                     areaIconTab = ImageIO.read(selectedArea);
                     g.drawImage(areaIconTab.getScaledInstance(areaIconTab.getWidth()/2,areaIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the area-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }else{
                    try {
                     areaIconTab = ImageIO.read(unselectedArea);
                     g.drawImage(areaIconTab.getScaledInstance(areaIconTab.getWidth()/2,areaIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the area-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            case 4:
                BufferedImage voluIconTab = null;
                InputStream selectedVolu = getClass().getResourceAsStream("voluIcon2.png");
                InputStream unselectedVolu = getClass().getResourceAsStream("voluIcon.png");
                if(isSelected){
                try {
                     voluIconTab = ImageIO.read(selectedVolu);
                     g.drawImage(voluIconTab.getScaledInstance(voluIconTab.getWidth()/2,voluIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the volume-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }else{
                    try {
                     voluIconTab = ImageIO.read(unselectedVolu);
                     g.drawImage(voluIconTab.getScaledInstance(voluIconTab.getWidth()/2,voluIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the volume-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            case 5:
                BufferedImage timeIconTab = null;
                InputStream selectedTime = getClass().getResourceAsStream("timeIcon2.png");
                InputStream unselectedTime = getClass().getResourceAsStream("timeIcon.png");
                if(isSelected){
                try {
                     timeIconTab = ImageIO.read(selectedTime);
                     g.drawImage(timeIconTab.getScaledInstance(timeIconTab.getWidth()/2,timeIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the time-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }else{
                    try {
                     timeIconTab = ImageIO.read(unselectedTime);
                     g.drawImage(timeIconTab.getScaledInstance(timeIconTab.getWidth()/2,timeIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the time-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            case 6:
                BufferedImage spdIconTab = null;
                InputStream selectedSpd = getClass().getResourceAsStream("spdIcon2.png");
                InputStream unselectedSpd = getClass().getResourceAsStream("spdIcon.png");
                if(isSelected){
                try {
                     spdIconTab = ImageIO.read(selectedSpd);
                     g.drawImage(spdIconTab.getScaledInstance(spdIconTab.getWidth()/2,spdIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the speed-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }else{
                    try {
                     spdIconTab = ImageIO.read(unselectedSpd);
                     g.drawImage(spdIconTab.getScaledInstance(spdIconTab.getWidth()/2,spdIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the speed-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            case 7:
                BufferedImage flowIconTab = null;
                InputStream selectedFlow = getClass().getResourceAsStream("flowIcon2.png");
                InputStream unselectedFlow = getClass().getResourceAsStream("flowIcon.png");
                if(isSelected){
                try {
                     flowIconTab = ImageIO.read(selectedFlow);
                     g.drawImage(flowIconTab.getScaledInstance(flowIconTab.getWidth()/2,flowIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the flow-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }else{
                    try {
                     flowIconTab = ImageIO.read(unselectedFlow);
                     g.drawImage(flowIconTab.getScaledInstance(flowIconTab.getWidth()/2,flowIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the flow-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            case 8:
                BufferedImage tempIconTab = null;
                InputStream selectedTemp = getClass().getResourceAsStream("tempIcon2.png");
                InputStream unselectedTemp = getClass().getResourceAsStream("tempIcon.png");
                if(isSelected){
                try {
                     tempIconTab = ImageIO.read(selectedTemp);
                     g.drawImage(tempIconTab.getScaledInstance(tempIconTab.getWidth()/2,tempIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the temperature-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }else{
                    try {
                     tempIconTab = ImageIO.read(unselectedTemp);
                     g.drawImage(tempIconTab.getScaledInstance(tempIconTab.getWidth()/2,tempIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the temperature-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            case 9:
                BufferedImage angIconTab = null;
                InputStream selectedAng = getClass().getResourceAsStream("angIcon2.png");
                InputStream unselectedAng = getClass().getResourceAsStream("angIcon.png");
                if(isSelected){
                try {
                     angIconTab = ImageIO.read(selectedAng);
                     g.drawImage(angIconTab.getScaledInstance(angIconTab.getWidth()/2,angIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the angle-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }else{
                    try {
                     angIconTab = ImageIO.read(unselectedAng);
                     g.drawImage(angIconTab.getScaledInstance(angIconTab.getWidth()/2,angIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the angle-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            case 10:
                BufferedImage consIconTab = null;
                InputStream selectedCons = getClass().getResourceAsStream("consIcon2.png");
                InputStream unselectedCons = getClass().getResourceAsStream("consIcon.png");
                if(isSelected){
                try {
                     consIconTab = ImageIO.read(selectedCons);
                     g.drawImage(consIconTab.getScaledInstance(consIconTab.getWidth()/2,consIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the constants-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }else{
                    try {
                     consIconTab = ImageIO.read(unselectedCons);
                     g.drawImage(consIconTab.getScaledInstance(consIconTab.getWidth()/2,consIconTab.getHeight()/2,
                             Image.SCALE_SMOOTH) , rects[tabIndex].x+2, rects[tabIndex].y+2, null);
                } catch (IOException e) {
                   System.out.println("An error occured while trying to retrieve the constants-tab image for the scroll bar:");
                   System.out.println(e);
                   }
                }
                break;
            default:
        }
        
        
    }
    //</editor-fold>
   
     
  }
