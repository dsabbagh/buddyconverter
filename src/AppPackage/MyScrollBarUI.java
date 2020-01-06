/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Diego
 */
public class MyScrollBarUI extends BasicScrollBarUI{
    
    Color myDarkGrey = new Color(35,35,35);
    Color myLightGrey = new Color(135,135,135);
    Color myGold = new Color(255,215,0);
    
    BufferedImage arrowIcon = null;
    InputStream arrowIconStream = getClass().getResourceAsStream("cbButton.png");
    BufferedImage arrowIcon2 = null;
    InputStream arrowIconStream2 = getClass().getResourceAsStream("cbButtonRotated.png");
    
    // Creating scrollbar buttons
    private JButton upButton = new JButton() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(17, 17);
        }
            };
    
    private JButton downButton = new JButton() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(17, 17);
        }
            };
    
    
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(myDarkGrey);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);

        if(trackHighlight == DECREASE_HIGHLIGHT)        {
            paintDecreaseHighlight(g);
        }
        else if(trackHighlight == INCREASE_HIGHLIGHT)           {
            paintIncreaseHighlight(g);
        }
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {

        if(thumbBounds.isEmpty() || !scrollbar.isEnabled())     {
            return;
        }

        int w = thumbBounds.width;
        int h = thumbBounds.height;

        g.translate(thumbBounds.x, thumbBounds.y);

        //g.setColor(myDarkGrey);
        g.drawRect(0+2, 0, w, h);
        g.setColor(myLightGrey);
        g.fillRect(0+2, 0, w, h);

        /*
        g.setColor(myDarkGrey);
        g.drawLine(1, 1, 1, h-2);
        g.drawLine(2, 1, w-3, 1);

        g.setColor(myDarkGrey);
        g.drawLine(2, h-2, w-2, h-2);
        g.drawLine(w-2, 1, w-2, h-3);
        */

        g.translate(-thumbBounds.x, -thumbBounds.y);
        
    }
    
    @Override
    protected JButton createIncreaseButton(int orientation){
        
        try{
           arrowIcon = ImageIO.read(arrowIconStream); 
        } catch (IOException e) {
            System.out.println("An error occured while trying to retrieve the increase-button image for the scroll bar:");
            System.out.println(e);
        }
        
        downButton.setIcon(new ImageIcon(arrowIcon.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        //b.setFocusable(false);
        return downButton;
    }
    
    @Override
    protected JButton createDecreaseButton(int orientation){
        
        try{
           arrowIcon2 = ImageIO.read(arrowIconStream2); 
        } catch (IOException e) {
            System.out.println("An error occured while trying to retrieve the decrease-button image for the scroll bar:");
            System.out.println(e);
        }
        
        upButton.setIcon(new ImageIcon(arrowIcon2.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        //b.setFocusable(false);
        return upButton;
    }
    
}
