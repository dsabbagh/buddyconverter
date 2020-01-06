/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author Diego
 */
public class MyComboBoxUI extends javax.swing.plaf.basic.BasicComboBoxUI {
    
    Color myLightGrey = new Color(135,135,135);    
    
    BufferedImage cbIcon = null;
    InputStream cbIconStream = getClass().getResourceAsStream("cbButton.png");
    
    
    public static ComponentUI createUI(JComponent c) {
        return new MyComboBoxUI();
    }
    
    @Override
    protected JButton createArrowButton() {
        
        try{
           cbIcon = ImageIO.read(cbIconStream); 
        } catch (IOException e) {
            System.out.println("An error occured while trying to retrieve arrow button image for combo boxes:");
            System.out.println(e);
        }
        
        JButton button = new JButton(new ImageIcon(cbIcon));
        button.setIcon(new ImageIcon(cbIcon.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        
        button.setName("ComboBox.arrowButton");
        return button;
    }
    
    
    @Override
    protected ComboPopup createPopup() {
        BasicComboPopup bcp = (BasicComboPopup)super.createPopup(); // dropdown menu (list)
        bcp.setBorder(BorderFactory.createLineBorder(myLightGrey, 1));// outer border
        JList list = bcp.getList();
        list.setBorder(BorderFactory.createLineBorder(Color.green, 0));// inner border
        Component c = ((Container) bcp).getComponent(0);
        if (c instanceof JScrollPane){
            JScrollPane spane = (JScrollPane) c;
            JScrollBar scrollBar = spane .getVerticalScrollBar();
            Dimension dim = new Dimension(0, scrollBar.getPreferredSize().height);
            scrollBar.setPreferredSize(dim);
        }
        
        return bcp;
    }


    


    
    
    
    
    
    
    
    
    
}
