/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import javax.swing.UIDefaults;


/**
 *
 * @author Diego
 */
public class DarkGoldLAF extends com.sun.java.swing.plaf.windows.WindowsLookAndFeel{
    
    
    @Override
    protected void initClassDefaults(UIDefaults table) {
        super.initClassDefaults(table);

        table.put("TabbedPaneUI", "AppPackage.MyTabbedPaneUI");
    }







}// end of DGLAF
