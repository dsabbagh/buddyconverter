/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

/**
 *
 * @author Diego
 */
public class Converter {
    
    double newvalues[] = null;
    
    // Energy
    static final double JOULE_TO_CAL = 0.2390057361376673;
    static final double JOULE_TO_ERG = 1e7;
    static final double JOULE_TO_HERTZ = 1/(6.626070040e-34);
    static final double JOULE_TO_EV = 1/(1.602176621e-19);
    static final double JOULE_TO_M1 = 1/(6.626070040e-34*2.99792458e8);
    static final double JOULE_TO_K = 1/(1.38064852e-23);
    static final double JOULE_TO_KG = 1/(2.99792458e8*2.99792458e8);
    static final double JOULE_TO_WH = 1/3600.0;
    
    
    
    
    public double[] convert(int tab, int radioButton, int comboBox, double value){
        
        switch (tab){
            case 0:
                newvalues = enerConverter(radioButton, comboBox, value); break;
            case 1:
                //newvalues = presConverter(radioButton, comboBox); break;
            case 2:
                //newvalues = lengConverter(radioButton, comboBox); break;
            case 3:
                //newvalues = areaConverter(radioButton, comboBox); break;
            case 4:
                //newvalues = voluConverter(radioButton, comboBox); break;
            case 5:
                //newvalues = timeConverter(radioButton, comboBox); break;
            case 6:
                //newvalues = speedConverter(radioButton, comboBox); break;
            case 7:
                //newvalues = flowConverter(radioButton, comboBox); break;
            case 8:
                //newvalues = tempConverter(radioButton, comboBox); break;
            case 9:
                //newvalues = angConverter(radioButton, comboBox); break;
            default: break;
            
        }
        
        return newvalues;
     
    }
    
    private double[] enerConverter(int rb, int cb, double value){
        
        double enervalues[] = new double[10];
        double jouleValue=0;
        
        switch(rb){
            case 0: jouleValue = value; break;
            case 1: jouleValue = value/JOULE_TO_CAL; break;
            case 2: jouleValue = value/JOULE_TO_ERG; break;
            case 3: jouleValue = value/JOULE_TO_HERTZ; break;
            case 4: jouleValue = value/JOULE_TO_EV; break;
            case 5: jouleValue = 1/(value*1e-9*JOULE_TO_M1); break;
            case 6: jouleValue = value/JOULE_TO_K; break;
            case 7: jouleValue = value/JOULE_TO_KG; break;
            case 8: jouleValue = value*1e2/JOULE_TO_M1; break;
            case 9: jouleValue = value/JOULE_TO_WH; break;
            default: System.out.println("Error converting energy units."); break;
        }
        
        enervalues[0] = jouleValue;
        enervalues[1] = jouleValue*JOULE_TO_CAL;
        enervalues[2] = jouleValue*JOULE_TO_ERG;
        enervalues[3] = jouleValue*JOULE_TO_HERTZ;
        enervalues[4] = jouleValue*JOULE_TO_EV;
        enervalues[5] = 1e9/(jouleValue*JOULE_TO_M1);
        enervalues[6] = jouleValue*JOULE_TO_K;
        enervalues[7] = jouleValue*JOULE_TO_KG;
        enervalues[8] = jouleValue*JOULE_TO_M1*1e-2;
        enervalues[9] = jouleValue*JOULE_TO_WH;
        
        return enervalues;
        
        
    }//end enerConverter
    /*
    private double[] presConverter(int rb, int cb){
        
    }
    
    private double[] lengConverter(int rb, int cb){
        
    }
    
    private double[] areaConverter(int rb, int cb){
        
        
    }
    
    private double[] voluConverter(int rb, int cb){
        
    }
    
    private double[] timeConverter(int rb, int cb){
        
    }
    
    private double[] speedConverter(int rb, int cb){
        
    }
    
    private double[] flowConverter(int rb, int cb){
        
    }
    
    private double[] tempConverter(int rb, int cb){
        
    }
    
    private double[] angConverter(int rb, int cb){
        
    }
    */
    
}
