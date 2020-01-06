/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.border.Border;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.JOptionPane;



// @author Diego Sabbagh
 
public class bcGUI extends javax.swing.JFrame {

    Color myDarkGrey = new Color(35,35,35);
    Color myLightGrey = new Color(135,135,135);
    Color myGold = new Color(255,215,0);
    
    int xMouse; // used to
    int yMouse; // drag frame
    
    double deselectedOOM=1; //to change unit
    double selectedOOM=1;   //in comboBox
    int evtCount=0;         //evt is launched twice
    
    BufferedImage convertIcon = null;
    InputStream convertIconStream = getClass().getResourceAsStream("convertIcon.png");
    InputStream convertIconStream2 = getClass().getResourceAsStream("convertIcon2.png");
    
    // format the numbers in scientific notation
    Locale engLocale = new Locale("en", "UK");
    DecimalFormatSymbols dfs = new DecimalFormatSymbols(engLocale);
    //dfs.setDecimalSeparator('.'); //if put in bcGUI() it works, outside it doesn't
    NumberFormat formatter = new DecimalFormat("0.0000000E0",dfs);
    
    // <editor-fold defaultstate="collapsed" desc="Declaration of components arrays">
    // JTextFiled
    protected JTextField[] enerTFarray = new JTextField[10];
    protected JTextField[] presTFarray = new JTextField[6];
    protected JTextField[] lengTFarray = new JTextField[9];
    protected JTextField[] areaTFarray = new JTextField[7];
    protected JTextField[] voluTFarray = new JTextField[10];
    protected JTextField[] timeTFarray = new JTextField[7];
    protected JTextField[] spdTFarray = new JTextField[6];
    protected JTextField[] flowTFarray = new JTextField[7];
    protected JTextField[] tempTFarray = new JTextField[3];
    protected JTextField[] angTFarray = new JTextField[3];
    protected JTextField[] consTFarray = new JTextField[30];
    protected JTextField[][] tfArray = new JTextField[][]{enerTFarray, presTFarray, lengTFarray, areaTFarray, voluTFarray, timeTFarray, spdTFarray, flowTFarray, tempTFarray, angTFarray};
    
    // JRadioButton
    protected JRadioButton[] enerRBarray = new JRadioButton[10];
    protected JRadioButton[] presRBarray = new JRadioButton[6];
    protected JRadioButton[] lengRBarray = new JRadioButton[9];
    protected JRadioButton[] areaRBarray = new JRadioButton[7];
    protected JRadioButton[] voluRBarray = new JRadioButton[10];
    protected JRadioButton[] timeRBarray = new JRadioButton[7];
    protected JRadioButton[] spdRBarray = new JRadioButton[6];
    protected JRadioButton[] flowRBarray = new JRadioButton[7];
    protected JRadioButton[] tempRBarray = new JRadioButton[3];
    protected JRadioButton[] angRBarray = new JRadioButton[3];
    protected JRadioButton[][] rbArray = new JRadioButton[][]{enerRBarray, presRBarray, lengRBarray, areaRBarray, voluRBarray, timeRBarray, spdRBarray, flowRBarray, tempRBarray, angRBarray};
    
    protected ButtonGroup enerButtonGroup = new ButtonGroup();
    protected ButtonGroup presButtonGroup = new ButtonGroup();
    protected ButtonGroup lengButtonGroup = new ButtonGroup();
    protected ButtonGroup areaButtonGroup = new ButtonGroup();
    protected ButtonGroup voluButtonGroup = new ButtonGroup();
    protected ButtonGroup timeButtonGroup = new ButtonGroup();
    protected ButtonGroup spdButtonGroup = new ButtonGroup();
    protected ButtonGroup flowButtonGroup = new ButtonGroup();
    protected ButtonGroup tempButtonGroup = new ButtonGroup();
    protected ButtonGroup angButtonGroup = new ButtonGroup();
    
    // JComboBox
    protected JComboBox[] enerCBarray = new JComboBox[10];
    protected JComboBox[] presCBarray = new JComboBox[6];
    protected JComboBox[] lengCBarray = new JComboBox[9];
    protected JComboBox[] areaCBarray = new JComboBox[7];
    protected JComboBox[] voluCBarray = new JComboBox[10];
    protected JComboBox[] timeCBarray = new JComboBox[7];
    protected JComboBox[] spdCBarray = new JComboBox[6];
    protected JComboBox[] flowCBarray = new JComboBox[7];
    protected JComboBox[] tempCBarray = new JComboBox[3];
    protected JComboBox[] angCBarray = new JComboBox[3];
    protected JComboBox[][] cbArray = new JComboBox[][]{enerCBarray, presCBarray, lengCBarray, areaCBarray, voluCBarray, timeCBarray, spdCBarray, flowCBarray, tempCBarray, angCBarray};
    
    
     //</editor-fold>
    
    //Creates new form bcGUI
    public bcGUI(){
                        
        compAppearence();
        initComponents(); // created by NetBeans
        
        tabbedPane.setUI(new MyTabbedPaneUI()); // custom LAF for JTabbedPane
        scrollOnTab();
        
        consScrollPane.getViewport().setBackground(myDarkGrey);
        JScrollBar vScrollBar = consScrollPane.getVerticalScrollBar();
        vScrollBar.setUI(new MyScrollBarUI());
        vScrollBar.setUnitIncrement(5);
                
        double num = 123956;
        jouleTextField.setText((String)formatter.format(num).toLowerCase());// TEMPORARY COMMANDS. DELETE THEM
        
        orgTextFields();
        orgRadioButtons();
        orgComboBoxes();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //Generated by Netbeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        minimiseLabel = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        scrollUpLabel = new javax.swing.JLabel();
        scrollDownLabel = new javax.swing.JLabel();
        convertLabel = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        enerPanel = new javax.swing.JPanel();
        enerUnitPanel = new javax.swing.JPanel();
        jouleTextField = new javax.swing.JTextField();
        calTextField = new javax.swing.JTextField();
        ergTextField = new javax.swing.JTextField();
        hertzTextField = new javax.swing.JTextField();
        eVTextField = new javax.swing.JTextField();
        nmTextField = new javax.swing.JTextField();
        kelvTextField = new javax.swing.JTextField();
        kgTextField = new javax.swing.JTextField();
        cm1TextField = new javax.swing.JTextField();
        watthTextField = new javax.swing.JTextField();
        jouleComboBox = new javax.swing.JComboBox<>();
        calComboBox = new javax.swing.JComboBox<>();
        ergComboBox = new javax.swing.JComboBox<>();
        hertzComboBox = new javax.swing.JComboBox<>();
        eVComboBox = new javax.swing.JComboBox<>();
        nmComboBox = new javax.swing.JComboBox<>();
        kelvComboBox = new javax.swing.JComboBox<>();
        kgComboBox = new javax.swing.JComboBox<>();
        cm1ComboBox = new javax.swing.JComboBox<>();
        watthComboBox = new javax.swing.JComboBox<>();
        jouleRadioButton = new javax.swing.JRadioButton();
        calRadioButton = new javax.swing.JRadioButton();
        ergRadioButton = new javax.swing.JRadioButton();
        hertzRadioButton = new javax.swing.JRadioButton();
        eVRadioButton = new javax.swing.JRadioButton();
        nmRadioButton = new javax.swing.JRadioButton();
        kelvRadioButton = new javax.swing.JRadioButton();
        kgRadioButton = new javax.swing.JRadioButton();
        cm1RadioButton = new javax.swing.JRadioButton();
        watthRadioButton = new javax.swing.JRadioButton();
        enerTipsPanel = new javax.swing.JPanel();
        presPanel = new javax.swing.JPanel();
        presUnitPanel = new javax.swing.JPanel();
        pascTextField = new javax.swing.JTextField();
        torrTextField = new javax.swing.JTextField();
        barTextField = new javax.swing.JTextField();
        atmTextField = new javax.swing.JTextField();
        psiTextField = new javax.swing.JTextField();
        baryeTextField = new javax.swing.JTextField();
        pascComboBox = new javax.swing.JComboBox<>();
        torrComboBox = new javax.swing.JComboBox<>();
        barComboBox = new javax.swing.JComboBox<>();
        atmComboBox = new javax.swing.JComboBox<>();
        psiComboBox = new javax.swing.JComboBox<>();
        baryeComboBox = new javax.swing.JComboBox<>();
        pascRadioButton = new javax.swing.JRadioButton();
        torrRadioButton = new javax.swing.JRadioButton();
        barRadioButton = new javax.swing.JRadioButton();
        atmRadioButton = new javax.swing.JRadioButton();
        psiRadioButton = new javax.swing.JRadioButton();
        baryeRadioButton = new javax.swing.JRadioButton();
        presTipsPanel = new javax.swing.JPanel();
        lengPanel = new javax.swing.JPanel();
        lengUnitPanel = new javax.swing.JPanel();
        meterTextField = new javax.swing.JTextField();
        inchTextField = new javax.swing.JTextField();
        footTextField = new javax.swing.JTextField();
        mileTextField = new javax.swing.JTextField();
        nmileTextField = new javax.swing.JTextField();
        yardTextField = new javax.swing.JTextField();
        lyearTextField = new javax.swing.JTextField();
        aunitTextField = new javax.swing.JTextField();
        parsecTextField = new javax.swing.JTextField();
        meterComboBox = new javax.swing.JComboBox<>();
        inchComboBox = new javax.swing.JComboBox<>();
        footComboBox = new javax.swing.JComboBox<>();
        mileComboBox = new javax.swing.JComboBox<>();
        nmileComboBox = new javax.swing.JComboBox<>();
        yardComboBox = new javax.swing.JComboBox<>();
        lyearComboBox = new javax.swing.JComboBox<>();
        aunitComboBox = new javax.swing.JComboBox<>();
        parsecComboBox = new javax.swing.JComboBox<>();
        meterRadioButton = new javax.swing.JRadioButton();
        inchRadioButton = new javax.swing.JRadioButton();
        footRadioButton = new javax.swing.JRadioButton();
        mileRadioButton = new javax.swing.JRadioButton();
        nmileRadioButton = new javax.swing.JRadioButton();
        yardRadioButton = new javax.swing.JRadioButton();
        lyearRadioButton = new javax.swing.JRadioButton();
        aunitRadioButton = new javax.swing.JRadioButton();
        parsecRadioButton = new javax.swing.JRadioButton();
        lengTipsPanel = new javax.swing.JPanel();
        areaPanel = new javax.swing.JPanel();
        areaUnitPanel = new javax.swing.JPanel();
        sqmeterTextField = new javax.swing.JTextField();
        sqinchTextField = new javax.swing.JTextField();
        sqfootTextField = new javax.swing.JTextField();
        sqmileTextField = new javax.swing.JTextField();
        hectareTextField = new javax.swing.JTextField();
        sqyardTextField = new javax.swing.JTextField();
        barnTextField = new javax.swing.JTextField();
        sqmeterComboBox = new javax.swing.JComboBox<>();
        sqinchComboBox = new javax.swing.JComboBox<>();
        sqfootComboBox = new javax.swing.JComboBox<>();
        sqmileComboBox = new javax.swing.JComboBox<>();
        hectareComboBox = new javax.swing.JComboBox<>();
        sqyardComboBox = new javax.swing.JComboBox<>();
        barnComboBox = new javax.swing.JComboBox<>();
        sqmeterRadioButton = new javax.swing.JRadioButton();
        sqinchRadioButton = new javax.swing.JRadioButton();
        sqfootRadioButton = new javax.swing.JRadioButton();
        sqmileRadioButton = new javax.swing.JRadioButton();
        hectareRadioButton = new javax.swing.JRadioButton();
        sqyardRadioButton = new javax.swing.JRadioButton();
        barnRadioButton = new javax.swing.JRadioButton();
        areaTipsPanel = new javax.swing.JPanel();
        voluPanel = new javax.swing.JPanel();
        voluUnitPanel = new javax.swing.JPanel();
        cubmeterTextField = new javax.swing.JTextField();
        cubinchTextField = new javax.swing.JTextField();
        cubfootTextField = new javax.swing.JTextField();
        cubmileTextField = new javax.swing.JTextField();
        literTextField = new javax.swing.JTextField();
        galTextField = new javax.swing.JTextField();
        pintTextField = new javax.swing.JTextField();
        cupTextField = new javax.swing.JTextField();
        tbspTextField = new javax.swing.JTextField();
        teaspTextField = new javax.swing.JTextField();
        cubmeterComboBox = new javax.swing.JComboBox<>();
        cubinchComboBox = new javax.swing.JComboBox<>();
        cubfootComboBox = new javax.swing.JComboBox<>();
        cubmileComboBox = new javax.swing.JComboBox<>();
        literComboBox = new javax.swing.JComboBox<>();
        galComboBox = new javax.swing.JComboBox<>();
        pintComboBox = new javax.swing.JComboBox<>();
        cupComboBox = new javax.swing.JComboBox<>();
        tbspComboBox = new javax.swing.JComboBox<>();
        teaspComboBox = new javax.swing.JComboBox<>();
        cubmeterRadioButton = new javax.swing.JRadioButton();
        cubinchRadioButton = new javax.swing.JRadioButton();
        cubfootRadioButton = new javax.swing.JRadioButton();
        cubmileRadioButton = new javax.swing.JRadioButton();
        literRadioButton = new javax.swing.JRadioButton();
        galRadioButton = new javax.swing.JRadioButton();
        pintRadioButton = new javax.swing.JRadioButton();
        cupRadioButton = new javax.swing.JRadioButton();
        tbspRadioButton = new javax.swing.JRadioButton();
        teaspRadioButton = new javax.swing.JRadioButton();
        voluTipsPanel = new javax.swing.JPanel();
        timePanel = new javax.swing.JPanel();
        timeUnitPanel = new javax.swing.JPanel();
        secTextField = new javax.swing.JTextField();
        minTextField = new javax.swing.JTextField();
        hourTextField = new javax.swing.JTextField();
        dayTextField = new javax.swing.JTextField();
        weekTextField = new javax.swing.JTextField();
        monthTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        secComboBox = new javax.swing.JComboBox<>();
        minComboBox = new javax.swing.JComboBox<>();
        hourComboBox = new javax.swing.JComboBox<>();
        dayComboBox = new javax.swing.JComboBox<>();
        weekComboBox = new javax.swing.JComboBox<>();
        monthComboBox = new javax.swing.JComboBox<>();
        yearComboBox = new javax.swing.JComboBox<>();
        secRadioButton = new javax.swing.JRadioButton();
        minRadioButton = new javax.swing.JRadioButton();
        hourRadioButton = new javax.swing.JRadioButton();
        dayRadioButton = new javax.swing.JRadioButton();
        weekRadioButton = new javax.swing.JRadioButton();
        monthRadioButton = new javax.swing.JRadioButton();
        yearRadioButton = new javax.swing.JRadioButton();
        timeTipsPanel = new javax.swing.JPanel();
        spdPanel = new javax.swing.JPanel();
        spdUnitPanel = new javax.swing.JPanel();
        msTextField = new javax.swing.JTextField();
        kmhTextField = new javax.swing.JTextField();
        mphTextField = new javax.swing.JTextField();
        knotTextField = new javax.swing.JTextField();
        ftsTextField = new javax.swing.JTextField();
        machTextField = new javax.swing.JTextField();
        msComboBox = new javax.swing.JComboBox<>();
        kmhComboBox = new javax.swing.JComboBox<>();
        mphComboBox = new javax.swing.JComboBox<>();
        knotComboBox = new javax.swing.JComboBox<>();
        ftsComboBox = new javax.swing.JComboBox<>();
        machComboBox = new javax.swing.JComboBox<>();
        msRadioButton = new javax.swing.JRadioButton();
        kmhRadioButton = new javax.swing.JRadioButton();
        mphRadioButton = new javax.swing.JRadioButton();
        knotRadioButton = new javax.swing.JRadioButton();
        ftsRadioButton = new javax.swing.JRadioButton();
        machRadioButton = new javax.swing.JRadioButton();
        spdTipsPanel = new javax.swing.JPanel();
        flowPanel = new javax.swing.JPanel();
        flowUnitPanel = new javax.swing.JPanel();
        cubmsTextField = new javax.swing.JTextField();
        cubmhTextField = new javax.swing.JTextField();
        litsTextField = new javax.swing.JTextField();
        litmTextField = new javax.swing.JTextField();
        cubftsTextField = new javax.swing.JTextField();
        sccmTextField = new javax.swing.JTextField();
        galminTextField = new javax.swing.JTextField();
        cubmsComboBox = new javax.swing.JComboBox<>();
        cubmhComboBox = new javax.swing.JComboBox<>();
        litsComboBox = new javax.swing.JComboBox<>();
        litmComboBox = new javax.swing.JComboBox<>();
        cubftsComboBox = new javax.swing.JComboBox<>();
        sccmComboBox = new javax.swing.JComboBox<>();
        galminComboBox = new javax.swing.JComboBox<>();
        cubmsRadioButton = new javax.swing.JRadioButton();
        cubmhRadioButton = new javax.swing.JRadioButton();
        litsRadioButton = new javax.swing.JRadioButton();
        litmRadioButton = new javax.swing.JRadioButton();
        cubftsRadioButton = new javax.swing.JRadioButton();
        sccmRadioButton = new javax.swing.JRadioButton();
        galminRadioButton = new javax.swing.JRadioButton();
        flowTipsPanel = new javax.swing.JPanel();
        tempPanel = new javax.swing.JPanel();
        tempUnitPanel = new javax.swing.JPanel();
        kelvinTextField = new javax.swing.JTextField();
        celsTextField = new javax.swing.JTextField();
        fahrTextField = new javax.swing.JTextField();
        kelvinComboBox = new javax.swing.JComboBox<>();
        celsComboBox = new javax.swing.JComboBox<>();
        fahrComboBox = new javax.swing.JComboBox<>();
        kelvinRadioButton = new javax.swing.JRadioButton();
        celsRadioButton = new javax.swing.JRadioButton();
        fahrRadioButton = new javax.swing.JRadioButton();
        tempTipsPanel = new javax.swing.JPanel();
        angPanel = new javax.swing.JPanel();
        angUnitPanel = new javax.swing.JPanel();
        radTextField = new javax.swing.JTextField();
        degTextField = new javax.swing.JTextField();
        gradTextField = new javax.swing.JTextField();
        radComboBox = new javax.swing.JComboBox<>();
        degComboBox = new javax.swing.JComboBox<>();
        gradComboBox = new javax.swing.JComboBox<>();
        radRadioButton = new javax.swing.JRadioButton();
        degRadioButton = new javax.swing.JRadioButton();
        gradRadioButton = new javax.swing.JRadioButton();
        angTipsPanel = new javax.swing.JPanel();
        consPanel = new javax.swing.JPanel();
        consScrollPane = new javax.swing.JScrollPane();
        consinnerPanel = new javax.swing.JPanel();
        lightspdTextField = new javax.swing.JTextField();
        newtonTextField = new javax.swing.JTextField();
        plankTextField = new javax.swing.JTextField();
        redplankTextField = new javax.swing.JTextField();
        cosmoTextField = new javax.swing.JTextField();
        einsteinTextField = new javax.swing.JTextField();
        hubbleTextField = new javax.swing.JTextField();
        permeabTextField = new javax.swing.JTextField();
        permitTextField = new javax.swing.JTextField();
        vacimpedTextField = new javax.swing.JTextField();
        chargeTextField = new javax.swing.JTextField();
        elmassTextField = new javax.swing.JTextField();
        protmassTextField = new javax.swing.JTextField();
        neutmassTextField = new javax.swing.JTextField();
        amuTextField = new javax.swing.JTextField();
        bohrmagTextField = new javax.swing.JTextField();
        nuclmagTextField = new javax.swing.JTextField();
        finestrTextField = new javax.swing.JTextField();
        rydbergTextField = new javax.swing.JTextField();
        bohrradTextField = new javax.swing.JTextField();
        avogadroTextField = new javax.swing.JTextField();
        gasTextField = new javax.swing.JTextField();
        boltzmannTextField = new javax.swing.JTextField();
        faradayTextField1 = new javax.swing.JTextField();
        stefboltzTextField = new javax.swing.JTextField();
        condqTextField = new javax.swing.JTextField();
        fluxqTextField = new javax.swing.JTextField();
        josephTextField = new javax.swing.JTextField();
        wienTextField = new javax.swing.JTextField();
        gravaccTextField = new javax.swing.JTextField();
        lightspdComboBox = new javax.swing.JComboBox<>();
        newtonComboBox = new javax.swing.JComboBox<>();
        plankComboBox = new javax.swing.JComboBox<>();
        redplankComboBox = new javax.swing.JComboBox<>();
        cosmoComboBox = new javax.swing.JComboBox<>();
        einsteinComboBox = new javax.swing.JComboBox<>();
        hubbleComboBox = new javax.swing.JComboBox<>();
        permeabComboBox = new javax.swing.JComboBox<>();
        permitComboBox = new javax.swing.JComboBox<>();
        vacimpedComboBox = new javax.swing.JComboBox<>();
        chargeComboBox = new javax.swing.JComboBox<>();
        elmassComboBox = new javax.swing.JComboBox<>();
        protmassComboBox = new javax.swing.JComboBox<>();
        neutmassComboBox = new javax.swing.JComboBox<>();
        amuComboBox = new javax.swing.JComboBox<>();
        bohrmagComboBox = new javax.swing.JComboBox<>();
        nuclmagComboBox = new javax.swing.JComboBox<>();
        finestrComboBox = new javax.swing.JComboBox<>();
        rydbergComboBox = new javax.swing.JComboBox<>();
        bohrradComboBox = new javax.swing.JComboBox<>();
        avogadroComboBox = new javax.swing.JComboBox<>();
        gasComboBox = new javax.swing.JComboBox<>();
        boltzmannComboBox = new javax.swing.JComboBox<>();
        faradayComboBox = new javax.swing.JComboBox<>();
        stefboltzComboBox = new javax.swing.JComboBox<>();
        condqComboBox = new javax.swing.JComboBox<>();
        fluxqComboBox = new javax.swing.JComboBox<>();
        josephComboBox = new javax.swing.JComboBox<>();
        wienComboBox = new javax.swing.JComboBox<>();
        gravaccComboBox = new javax.swing.JComboBox<>();
        phantomconsLabel = new javax.swing.JLabel();
        lightspdLabel = new javax.swing.JLabel();
        newtonLabel = new javax.swing.JLabel();
        plankLabel = new javax.swing.JLabel();
        redplankLabel = new javax.swing.JLabel();
        cosmoLabel = new javax.swing.JLabel();
        einsteinLabel = new javax.swing.JLabel();
        hubbleLabel = new javax.swing.JLabel();
        permeabLabel = new javax.swing.JLabel();
        premitLabel = new javax.swing.JLabel();
        vacimpedLabel = new javax.swing.JLabel();
        chargeLabel = new javax.swing.JLabel();
        elmassLabel = new javax.swing.JLabel();
        protmassLabel = new javax.swing.JLabel();
        neutmassLabel = new javax.swing.JLabel();
        amuLabel = new javax.swing.JLabel();
        bohrmagLabel = new javax.swing.JLabel();
        nuclmagLabel = new javax.swing.JLabel();
        finestrLabel = new javax.swing.JLabel();
        rydbergLabel = new javax.swing.JLabel();
        bohrradLabel = new javax.swing.JLabel();
        avogadroLabel = new javax.swing.JLabel();
        gasLabel = new javax.swing.JLabel();
        boltzmannLabel = new javax.swing.JLabel();
        faradayLabel = new javax.swing.JLabel();
        stefboltzLabel = new javax.swing.JLabel();
        condqLabel = new javax.swing.JLabel();
        fluxqLabel = new javax.swing.JLabel();
        josephLabel = new javax.swing.JLabel();
        wienLabel = new javax.swing.JLabel();
        gravaccLabel = new javax.swing.JLabel();
        consTipsPanel = new javax.swing.JPanel();
        phantomPanel = new javax.swing.JPanel();
        bugLabel1 = new javax.swing.JLabel();
        bugLabel2 = new javax.swing.JLabel();
        bugLabel3 = new javax.swing.JLabel();
        bkgPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buddy Converter");
        setMinimumSize(new java.awt.Dimension(730, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimiseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/minimiseIcon.png"))); // NOI18N
        minimiseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimiseLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimiseLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimiseLabelMouseExited(evt);
            }
        });
        getContentPane().add(minimiseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, -1, -1));

        closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/closeIcon.png"))); // NOI18N
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeLabelMouseExited(evt);
            }
        });
        getContentPane().add(closeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        titleLabel.setFont(new java.awt.Font("Roboto Slab", 1, 12)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/labelBackground.png"))); // NOI18N
        titleLabel.setText("Buddy Converter");
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titleLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleLabelMouseDragged(evt);
            }
        });
        titleLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleLabelMousePressed(evt);
            }
        });
        getContentPane().add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 20));

        scrollUpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/scrollUp.png"))); // NOI18N
        scrollUpLabel.setText("jLabel1");
        scrollUpLabel.setPreferredSize(new java.awt.Dimension(60, 20));
        scrollUpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollUpLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scrollUpLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scrollUpLabelMouseExited(evt);
            }
        });
        getContentPane().add(scrollUpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 450, -1, -1));

        scrollDownLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/scrollDown.png"))); // NOI18N
        scrollDownLabel.setText("jLabel1");
        scrollDownLabel.setPreferredSize(new java.awt.Dimension(60, 20));
        scrollDownLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollDownLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scrollDownLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scrollDownLabelMouseExited(evt);
            }
        });
        getContentPane().add(scrollDownLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 470, -1, -1));

        convertLabel.setForeground(new java.awt.Color(255, 255, 255));
        convertLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/convertIcon.png"))); // NOI18N
        convertLabel.setToolTipText("Convert");
        convertLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 215, 0)));
        convertLabel.setPreferredSize(new java.awt.Dimension(60, 60));
        convertLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                convertLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                convertLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                convertLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                convertLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                convertLabelMouseReleased(evt);
            }
        });
        getContentPane().add(convertLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 361, -1, -1));

        versionLabel.setFont(new java.awt.Font("Roboto Slab", 1, 12)); // NOI18N
        versionLabel.setForeground(new java.awt.Color(135, 135, 135));
        versionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        versionLabel.setText("<html><body style='text-align: right'>v0.6beta<br>14Apr2019</html>");
        versionLabel.setFocusable(false);
        versionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        versionLabel.setPreferredSize(new java.awt.Dimension(62, 34));
        getContentPane().add(versionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 444, -1, -1));

        tabbedPane.setBackground(new java.awt.Color(35, 35, 35));
        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedPane.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N

        enerPanel.setBackground(new java.awt.Color(35, 35, 35));
        enerPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        enerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enerUnitPanel.setBackground(new java.awt.Color(35, 35, 35));
        enerUnitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Units", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        enerUnitPanel.setForeground(new java.awt.Color(255, 255, 255));
        enerUnitPanel.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        enerUnitPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        enerUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jouleTextField.setEditable(false);
        jouleTextField.setBackground(new java.awt.Color(35, 35, 35));
        jouleTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        jouleTextField.setForeground(new java.awt.Color(255, 255, 255));
        jouleTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jouleTextField.setText("99.99e-19");
        jouleTextField.setToolTipText("Joules");
        jouleTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        jouleTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        enerUnitPanel.add(jouleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 25));

        calTextField.setEditable(false);
        calTextField.setBackground(new java.awt.Color(35, 35, 35));
        calTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        calTextField.setForeground(new java.awt.Color(255, 255, 255));
        calTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        calTextField.setText("99.99e-19");
        calTextField.setToolTipText("Calories");
        calTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        calTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        enerUnitPanel.add(calTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 25));

        ergTextField.setEditable(false);
        ergTextField.setBackground(new java.awt.Color(35, 35, 35));
        ergTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        ergTextField.setForeground(new java.awt.Color(255, 255, 255));
        ergTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ergTextField.setText("99.99e-19");
        ergTextField.setToolTipText("");
        ergTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        ergTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        enerUnitPanel.add(ergTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 100, 25));

        hertzTextField.setEditable(false);
        hertzTextField.setBackground(new java.awt.Color(35, 35, 35));
        hertzTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        hertzTextField.setForeground(new java.awt.Color(255, 255, 255));
        hertzTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        hertzTextField.setText("99.99e-19");
        hertzTextField.setToolTipText("Hertz");
        hertzTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        hertzTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        enerUnitPanel.add(hertzTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 100, 25));

        eVTextField.setEditable(false);
        eVTextField.setBackground(new java.awt.Color(35, 35, 35));
        eVTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        eVTextField.setForeground(new java.awt.Color(255, 255, 255));
        eVTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        eVTextField.setText("99.99e-19");
        eVTextField.setToolTipText("ElectronVolts");
        eVTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        eVTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        enerUnitPanel.add(eVTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 100, 25));

        nmTextField.setEditable(false);
        nmTextField.setBackground(new java.awt.Color(35, 35, 35));
        nmTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        nmTextField.setForeground(new java.awt.Color(255, 255, 255));
        nmTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nmTextField.setText("99.99e-19");
        nmTextField.setToolTipText("Nanometers");
        nmTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        nmTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        enerUnitPanel.add(nmTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 100, 25));

        kelvTextField.setEditable(false);
        kelvTextField.setBackground(new java.awt.Color(35, 35, 35));
        kelvTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        kelvTextField.setForeground(new java.awt.Color(255, 255, 255));
        kelvTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        kelvTextField.setText("99.99e-19");
        kelvTextField.setToolTipText("Kelvin");
        kelvTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        kelvTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        enerUnitPanel.add(kelvTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 100, 25));

        kgTextField.setEditable(false);
        kgTextField.setBackground(new java.awt.Color(35, 35, 35));
        kgTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        kgTextField.setForeground(new java.awt.Color(255, 255, 255));
        kgTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        kgTextField.setText("99.99e-19");
        kgTextField.setToolTipText("Kilograms");
        kgTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        kgTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        enerUnitPanel.add(kgTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 100, 25));

        cm1TextField.setEditable(false);
        cm1TextField.setBackground(new java.awt.Color(35, 35, 35));
        cm1TextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cm1TextField.setForeground(new java.awt.Color(255, 255, 255));
        cm1TextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cm1TextField.setText("99.99e-19");
        cm1TextField.setCaretColor(new java.awt.Color(255, 255, 255));
        cm1TextField.setPreferredSize(new java.awt.Dimension(100, 25));
        enerUnitPanel.add(cm1TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 100, 25));

        watthTextField.setEditable(false);
        watthTextField.setBackground(new java.awt.Color(35, 35, 35));
        watthTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        watthTextField.setForeground(new java.awt.Color(255, 255, 255));
        watthTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        watthTextField.setText("99.99e-19");
        watthTextField.setToolTipText("Watthour");
        watthTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        watthTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        enerUnitPanel.add(watthTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 100, 25));

        jouleComboBox.setBackground(new java.awt.Color(35, 35, 35));
        jouleComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        jouleComboBox.setMaximumRowCount(4);
        jouleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J", "mJ", "kJ", "MJ" }));
        jouleComboBox.setFocusable(false);
        jouleComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        jouleComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jouleComboBoxItemStateChanged(evt);
            }
        });
        enerUnitPanel.add(jouleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 65, -1));

        calComboBox.setBackground(new java.awt.Color(35, 35, 35));
        calComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        calComboBox.setMaximumRowCount(2);
        calComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cal", "kcal" }));
        calComboBox.setFocusable(false);
        calComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        calComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                calComboBoxItemStateChanged(evt);
            }
        });
        enerUnitPanel.add(calComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 65, -1));

        ergComboBox.setBackground(new java.awt.Color(35, 35, 35));
        ergComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        ergComboBox.setMaximumRowCount(3);
        ergComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "erg", "kerg", "Merg" }));
        ergComboBox.setFocusable(false);
        ergComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        ergComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ergComboBoxItemStateChanged(evt);
            }
        });
        enerUnitPanel.add(ergComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 65, -1));

        hertzComboBox.setBackground(new java.awt.Color(35, 35, 35));
        hertzComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        hertzComboBox.setMaximumRowCount(5);
        hertzComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hz", "kHz", "MHz", "GHz", "THz" }));
        hertzComboBox.setFocusable(false);
        hertzComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        hertzComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hertzComboBoxItemStateChanged(evt);
            }
        });
        enerUnitPanel.add(hertzComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 65, -1));

        eVComboBox.setBackground(new java.awt.Color(35, 35, 35));
        eVComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        eVComboBox.setMaximumRowCount(6);
        eVComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "eV", "meV", "keV", "MeV", "GeV", "TeV" }));
        eVComboBox.setFocusable(false);
        eVComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        eVComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                eVComboBoxItemStateChanged(evt);
            }
        });
        enerUnitPanel.add(eVComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 65, -1));

        nmComboBox.setBackground(new java.awt.Color(35, 35, 35));
        nmComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        nmComboBox.setMaximumRowCount(3);
        nmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nm", "um", "mm" }));
        nmComboBox.setFocusable(false);
        nmComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        nmComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nmComboBoxItemStateChanged(evt);
            }
        });
        enerUnitPanel.add(nmComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 65, -1));

        kelvComboBox.setBackground(new java.awt.Color(35, 35, 35));
        kelvComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        kelvComboBox.setMaximumRowCount(1);
        kelvComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K" }));
        kelvComboBox.setFocusable(false);
        kelvComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        kelvComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kelvComboBoxItemStateChanged(evt);
            }
        });
        enerUnitPanel.add(kelvComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 65, -1));

        kgComboBox.setBackground(new java.awt.Color(35, 35, 35));
        kgComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        kgComboBox.setMaximumRowCount(2);
        kgComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kg", "g" }));
        kgComboBox.setFocusable(false);
        kgComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        kgComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kgComboBoxItemStateChanged(evt);
            }
        });
        enerUnitPanel.add(kgComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 65, -1));

        cm1ComboBox.setBackground(new java.awt.Color(35, 35, 35));
        cm1ComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cm1ComboBox.setMaximumRowCount(1);
        cm1ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1/cm" }));
        cm1ComboBox.setFocusable(false);
        cm1ComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        cm1ComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cm1ComboBoxItemStateChanged(evt);
            }
        });
        enerUnitPanel.add(cm1ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 65, -1));

        watthComboBox.setBackground(new java.awt.Color(35, 35, 35));
        watthComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        watthComboBox.setMaximumRowCount(3);
        watthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wh", "kWh", "MWh" }));
        watthComboBox.setFocusable(false);
        watthComboBox.setMinimumSize(new java.awt.Dimension(61, 25));
        watthComboBox.setName(""); // NOI18N
        watthComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                watthComboBoxItemStateChanged(evt);
            }
        });
        enerUnitPanel.add(watthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 65, -1));

        jouleRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        jouleRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        jouleRadioButton.setSelected(true);
        jouleRadioButton.setActionCommand("0");
        jouleRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jouleRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        jouleRadioButton.setRolloverEnabled(false);
        enerUnitPanel.add(jouleRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        calRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        calRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        calRadioButton.setActionCommand("1");
        calRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        calRadioButton.setRolloverEnabled(false);
        enerUnitPanel.add(calRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        ergRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        ergRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        ergRadioButton.setActionCommand("2");
        ergRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ergRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        ergRadioButton.setRolloverEnabled(false);
        enerUnitPanel.add(ergRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        hertzRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        hertzRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        hertzRadioButton.setActionCommand("3");
        hertzRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hertzRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        hertzRadioButton.setRolloverEnabled(false);
        enerUnitPanel.add(hertzRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        eVRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        eVRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        eVRadioButton.setActionCommand("4");
        eVRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eVRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        eVRadioButton.setRolloverEnabled(false);
        enerUnitPanel.add(eVRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        nmRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        nmRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        nmRadioButton.setActionCommand("5");
        nmRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nmRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        nmRadioButton.setRolloverEnabled(false);
        enerUnitPanel.add(nmRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        kelvRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        kelvRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        kelvRadioButton.setActionCommand("6");
        kelvRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kelvRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        kelvRadioButton.setRolloverEnabled(false);
        enerUnitPanel.add(kelvRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        kgRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        kgRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        kgRadioButton.setActionCommand("7");
        kgRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kgRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        kgRadioButton.setRolloverEnabled(false);
        enerUnitPanel.add(kgRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        cm1RadioButton.setBackground(new java.awt.Color(35, 35, 35));
        cm1RadioButton.setForeground(new java.awt.Color(35, 35, 35));
        cm1RadioButton.setActionCommand("8");
        cm1RadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cm1RadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        cm1RadioButton.setRolloverEnabled(false);
        enerUnitPanel.add(cm1RadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        watthRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        watthRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        watthRadioButton.setActionCommand("9");
        watthRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        watthRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        watthRadioButton.setRolloverEnabled(false);
        enerUnitPanel.add(watthRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        enerPanel.add(enerUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        enerTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        enerTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        enerTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        enerTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        enerTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        enerPanel.add(enerTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), enerPanel, "Energy"); // NOI18N

        presPanel.setBackground(new java.awt.Color(35, 35, 35));
        presPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        presPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        presUnitPanel.setBackground(new java.awt.Color(35, 35, 35));
        presUnitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Units", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        presUnitPanel.setForeground(new java.awt.Color(255, 255, 255));
        presUnitPanel.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        presUnitPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        presUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pascTextField.setEditable(false);
        pascTextField.setBackground(new java.awt.Color(35, 35, 35));
        pascTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        pascTextField.setForeground(new java.awt.Color(255, 255, 255));
        pascTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pascTextField.setText("99.99e-19");
        pascTextField.setToolTipText("Pascal");
        pascTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        pascTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        presUnitPanel.add(pascTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 25));

        torrTextField.setEditable(false);
        torrTextField.setBackground(new java.awt.Color(35, 35, 35));
        torrTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        torrTextField.setForeground(new java.awt.Color(255, 255, 255));
        torrTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        torrTextField.setText("99.99e-19");
        torrTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        torrTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        presUnitPanel.add(torrTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 25));

        barTextField.setEditable(false);
        barTextField.setBackground(new java.awt.Color(35, 35, 35));
        barTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        barTextField.setForeground(new java.awt.Color(255, 255, 255));
        barTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        barTextField.setText("99.99e-19");
        barTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        barTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        presUnitPanel.add(barTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 100, 25));

        atmTextField.setEditable(false);
        atmTextField.setBackground(new java.awt.Color(35, 35, 35));
        atmTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        atmTextField.setForeground(new java.awt.Color(255, 255, 255));
        atmTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        atmTextField.setText("99.99e-19");
        atmTextField.setToolTipText("Atmospheres");
        atmTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        atmTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        presUnitPanel.add(atmTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 100, 25));

        psiTextField.setEditable(false);
        psiTextField.setBackground(new java.awt.Color(35, 35, 35));
        psiTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        psiTextField.setForeground(new java.awt.Color(255, 255, 255));
        psiTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        psiTextField.setText("99.99e-19");
        psiTextField.setToolTipText("Pounds per square inch");
        psiTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        psiTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        presUnitPanel.add(psiTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 100, 25));

        baryeTextField.setEditable(false);
        baryeTextField.setBackground(new java.awt.Color(35, 35, 35));
        baryeTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        baryeTextField.setForeground(new java.awt.Color(255, 255, 255));
        baryeTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        baryeTextField.setText("99.99e-19");
        baryeTextField.setToolTipText("Barye");
        baryeTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        baryeTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        presUnitPanel.add(baryeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 100, 25));

        pascComboBox.setBackground(new java.awt.Color(35, 35, 35));
        pascComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        pascComboBox.setMaximumRowCount(5);
        pascComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pa", "mPa", "hPa", "kPa", "MPa" }));
        pascComboBox.setFocusable(false);
        pascComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        pascComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pascComboBoxItemStateChanged(evt);
            }
        });
        presUnitPanel.add(pascComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        torrComboBox.setBackground(new java.awt.Color(35, 35, 35));
        torrComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        torrComboBox.setMaximumRowCount(2);
        torrComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Torr", "mTorr" }));
        torrComboBox.setFocusable(false);
        torrComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        torrComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                torrComboBoxItemStateChanged(evt);
            }
        });
        presUnitPanel.add(torrComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        barComboBox.setBackground(new java.awt.Color(35, 35, 35));
        barComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        barComboBox.setMaximumRowCount(2);
        barComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bar", "mbar" }));
        barComboBox.setFocusable(false);
        barComboBox.setMinimumSize(new java.awt.Dimension(50, 25));
        barComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                barComboBoxItemStateChanged(evt);
            }
        });
        presUnitPanel.add(barComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 64, -1));

        atmComboBox.setBackground(new java.awt.Color(35, 35, 35));
        atmComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        atmComboBox.setMaximumRowCount(1);
        atmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "atm" }));
        atmComboBox.setFocusable(false);
        atmComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        atmComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                atmComboBoxItemStateChanged(evt);
            }
        });
        presUnitPanel.add(atmComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        psiComboBox.setBackground(new java.awt.Color(35, 35, 35));
        psiComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        psiComboBox.setMaximumRowCount(1);
        psiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "psi" }));
        psiComboBox.setFocusable(false);
        psiComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        psiComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                psiComboBoxItemStateChanged(evt);
            }
        });
        presUnitPanel.add(psiComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        baryeComboBox.setBackground(new java.awt.Color(35, 35, 35));
        baryeComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        baryeComboBox.setMaximumRowCount(1);
        baryeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ba" }));
        baryeComboBox.setFocusable(false);
        baryeComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        baryeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                baryeComboBoxItemStateChanged(evt);
            }
        });
        presUnitPanel.add(baryeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        pascRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        pascRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        pascRadioButton.setActionCommand("0");
        pascRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pascRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        pascRadioButton.setRolloverEnabled(false);
        presUnitPanel.add(pascRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        torrRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        torrRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        torrRadioButton.setActionCommand("1");
        torrRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        torrRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        torrRadioButton.setRolloverEnabled(false);
        presUnitPanel.add(torrRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        barRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        barRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        barRadioButton.setActionCommand("2");
        barRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        barRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        barRadioButton.setRolloverEnabled(false);
        presUnitPanel.add(barRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        atmRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        atmRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        atmRadioButton.setActionCommand("3");
        atmRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        atmRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        atmRadioButton.setRolloverEnabled(false);
        presUnitPanel.add(atmRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        psiRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        psiRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        psiRadioButton.setActionCommand("4");
        psiRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        psiRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        psiRadioButton.setRolloverEnabled(false);
        presUnitPanel.add(psiRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        baryeRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        baryeRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        baryeRadioButton.setActionCommand("5");
        baryeRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        baryeRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        baryeRadioButton.setRolloverEnabled(false);
        presUnitPanel.add(baryeRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        presPanel.add(presUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        presTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        presTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        presTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        presTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        presTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        presPanel.add(presTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), presPanel, "Pressure"); // NOI18N

        lengPanel.setBackground(new java.awt.Color(35, 35, 35));
        lengPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        lengPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lengUnitPanel.setBackground(new java.awt.Color(35, 35, 35));
        lengUnitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Units", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        lengUnitPanel.setForeground(new java.awt.Color(255, 255, 255));
        lengUnitPanel.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lengUnitPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        lengUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        meterTextField.setEditable(false);
        meterTextField.setBackground(new java.awt.Color(35, 35, 35));
        meterTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        meterTextField.setForeground(new java.awt.Color(255, 255, 255));
        meterTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        meterTextField.setText("99.99e-19");
        meterTextField.setToolTipText("Meters");
        meterTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        meterTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        lengUnitPanel.add(meterTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 25));

        inchTextField.setEditable(false);
        inchTextField.setBackground(new java.awt.Color(35, 35, 35));
        inchTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        inchTextField.setForeground(new java.awt.Color(255, 255, 255));
        inchTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inchTextField.setText("99.99e-19");
        inchTextField.setToolTipText("Inches");
        inchTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        inchTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        lengUnitPanel.add(inchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 25));

        footTextField.setEditable(false);
        footTextField.setBackground(new java.awt.Color(35, 35, 35));
        footTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        footTextField.setForeground(new java.awt.Color(255, 255, 255));
        footTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        footTextField.setText("99.99e-19");
        footTextField.setToolTipText("Feet");
        footTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        footTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        lengUnitPanel.add(footTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 100, 25));

        mileTextField.setEditable(false);
        mileTextField.setBackground(new java.awt.Color(35, 35, 35));
        mileTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        mileTextField.setForeground(new java.awt.Color(255, 255, 255));
        mileTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        mileTextField.setText("99.99e-19");
        mileTextField.setToolTipText("Miles");
        mileTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        mileTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        lengUnitPanel.add(mileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 100, 25));

        nmileTextField.setEditable(false);
        nmileTextField.setBackground(new java.awt.Color(35, 35, 35));
        nmileTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        nmileTextField.setForeground(new java.awt.Color(255, 255, 255));
        nmileTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nmileTextField.setText("99.99e-19");
        nmileTextField.setToolTipText("Nautical miles");
        nmileTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        nmileTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        lengUnitPanel.add(nmileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 100, 25));

        yardTextField.setEditable(false);
        yardTextField.setBackground(new java.awt.Color(35, 35, 35));
        yardTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        yardTextField.setForeground(new java.awt.Color(255, 255, 255));
        yardTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        yardTextField.setText("99.99e-19");
        yardTextField.setToolTipText("Yards");
        yardTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        yardTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        lengUnitPanel.add(yardTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 100, 25));

        lyearTextField.setEditable(false);
        lyearTextField.setBackground(new java.awt.Color(35, 35, 35));
        lyearTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        lyearTextField.setForeground(new java.awt.Color(255, 255, 255));
        lyearTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lyearTextField.setText("99.99e-19");
        lyearTextField.setToolTipText("Light-years");
        lyearTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        lyearTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        lengUnitPanel.add(lyearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 100, 25));

        aunitTextField.setEditable(false);
        aunitTextField.setBackground(new java.awt.Color(35, 35, 35));
        aunitTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        aunitTextField.setForeground(new java.awt.Color(255, 255, 255));
        aunitTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        aunitTextField.setText("99.99e-19");
        aunitTextField.setToolTipText("Astronomical units");
        aunitTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        aunitTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        lengUnitPanel.add(aunitTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 100, 25));

        parsecTextField.setEditable(false);
        parsecTextField.setBackground(new java.awt.Color(35, 35, 35));
        parsecTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        parsecTextField.setForeground(new java.awt.Color(255, 255, 255));
        parsecTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        parsecTextField.setText("99.99e-19");
        parsecTextField.setToolTipText("Parsec");
        parsecTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        parsecTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        lengUnitPanel.add(parsecTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 100, 25));

        meterComboBox.setBackground(new java.awt.Color(35, 35, 35));
        meterComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        meterComboBox.setMaximumRowCount(7);
        meterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m", "cm", "mm", "µm", "nm", "Å", "km" }));
        meterComboBox.setFocusable(false);
        meterComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        meterComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                meterComboBoxItemStateChanged(evt);
            }
        });
        lengUnitPanel.add(meterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        inchComboBox.setBackground(new java.awt.Color(35, 35, 35));
        inchComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        inchComboBox.setMaximumRowCount(1);
        inchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "in" }));
        inchComboBox.setFocusable(false);
        inchComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        inchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inchComboBoxItemStateChanged(evt);
            }
        });
        lengUnitPanel.add(inchComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        footComboBox.setBackground(new java.awt.Color(35, 35, 35));
        footComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        footComboBox.setMaximumRowCount(1);
        footComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ft" }));
        footComboBox.setFocusable(false);
        footComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        footComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                footComboBoxItemStateChanged(evt);
            }
        });
        lengUnitPanel.add(footComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        mileComboBox.setBackground(new java.awt.Color(35, 35, 35));
        mileComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        mileComboBox.setMaximumRowCount(1);
        mileComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mi" }));
        mileComboBox.setFocusable(false);
        mileComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        mileComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mileComboBoxItemStateChanged(evt);
            }
        });
        lengUnitPanel.add(mileComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        nmileComboBox.setBackground(new java.awt.Color(35, 35, 35));
        nmileComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        nmileComboBox.setMaximumRowCount(1);
        nmileComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nmi" }));
        nmileComboBox.setFocusable(false);
        nmileComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        nmileComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nmileComboBoxItemStateChanged(evt);
            }
        });
        lengUnitPanel.add(nmileComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        yardComboBox.setBackground(new java.awt.Color(35, 35, 35));
        yardComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        yardComboBox.setMaximumRowCount(1);
        yardComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "yd" }));
        yardComboBox.setFocusable(false);
        yardComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        yardComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yardComboBoxItemStateChanged(evt);
            }
        });
        lengUnitPanel.add(yardComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        lyearComboBox.setBackground(new java.awt.Color(35, 35, 35));
        lyearComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        lyearComboBox.setMaximumRowCount(1);
        lyearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ly" }));
        lyearComboBox.setFocusable(false);
        lyearComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        lyearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lyearComboBoxItemStateChanged(evt);
            }
        });
        lengUnitPanel.add(lyearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        aunitComboBox.setBackground(new java.awt.Color(35, 35, 35));
        aunitComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        aunitComboBox.setMaximumRowCount(1);
        aunitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "au" }));
        aunitComboBox.setFocusable(false);
        aunitComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        aunitComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                aunitComboBoxItemStateChanged(evt);
            }
        });
        lengUnitPanel.add(aunitComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        parsecComboBox.setBackground(new java.awt.Color(35, 35, 35));
        parsecComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        parsecComboBox.setMaximumRowCount(2);
        parsecComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pc", "Mpc" }));
        parsecComboBox.setFocusable(false);
        parsecComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        parsecComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                parsecComboBoxItemStateChanged(evt);
            }
        });
        lengUnitPanel.add(parsecComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, -1));

        meterRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        meterRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        meterRadioButton.setActionCommand("0");
        meterRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meterRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        meterRadioButton.setRolloverEnabled(false);
        lengUnitPanel.add(meterRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        inchRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        inchRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        inchRadioButton.setActionCommand("1");
        inchRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inchRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        inchRadioButton.setRolloverEnabled(false);
        lengUnitPanel.add(inchRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        footRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        footRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        footRadioButton.setActionCommand("2");
        footRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        footRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        footRadioButton.setRolloverEnabled(false);
        lengUnitPanel.add(footRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        mileRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        mileRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        mileRadioButton.setActionCommand("3");
        mileRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mileRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        mileRadioButton.setRolloverEnabled(false);
        lengUnitPanel.add(mileRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        nmileRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        nmileRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        nmileRadioButton.setActionCommand("4");
        nmileRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nmileRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        nmileRadioButton.setRolloverEnabled(false);
        lengUnitPanel.add(nmileRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        yardRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        yardRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        yardRadioButton.setActionCommand("5");
        yardRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yardRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        yardRadioButton.setRolloverEnabled(false);
        lengUnitPanel.add(yardRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        lyearRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        lyearRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        lyearRadioButton.setActionCommand("6");
        lyearRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lyearRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        lyearRadioButton.setRolloverEnabled(false);
        lengUnitPanel.add(lyearRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        aunitRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        aunitRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        aunitRadioButton.setActionCommand("7");
        aunitRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aunitRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        aunitRadioButton.setRolloverEnabled(false);
        lengUnitPanel.add(aunitRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        parsecRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        parsecRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        parsecRadioButton.setActionCommand("8");
        parsecRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parsecRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        parsecRadioButton.setRolloverEnabled(false);
        lengUnitPanel.add(parsecRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        lengPanel.add(lengUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        lengTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        lengTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        lengTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        lengTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        lengTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        lengPanel.add(lengTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), lengPanel, "Length"); // NOI18N

        areaPanel.setBackground(new java.awt.Color(35, 35, 35));
        areaPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        areaPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        areaUnitPanel.setBackground(new java.awt.Color(35, 35, 35));
        areaUnitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Units", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        areaUnitPanel.setForeground(new java.awt.Color(255, 255, 255));
        areaUnitPanel.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        areaUnitPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        areaUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sqmeterTextField.setEditable(false);
        sqmeterTextField.setBackground(new java.awt.Color(35, 35, 35));
        sqmeterTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sqmeterTextField.setForeground(new java.awt.Color(255, 255, 255));
        sqmeterTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sqmeterTextField.setText("99.99e-19");
        sqmeterTextField.setToolTipText("Square meters");
        sqmeterTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        sqmeterTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        areaUnitPanel.add(sqmeterTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 25));

        sqinchTextField.setEditable(false);
        sqinchTextField.setBackground(new java.awt.Color(35, 35, 35));
        sqinchTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sqinchTextField.setForeground(new java.awt.Color(255, 255, 255));
        sqinchTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sqinchTextField.setText("99.99e-19");
        sqinchTextField.setToolTipText("Square inches");
        sqinchTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        sqinchTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        areaUnitPanel.add(sqinchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 25));

        sqfootTextField.setEditable(false);
        sqfootTextField.setBackground(new java.awt.Color(35, 35, 35));
        sqfootTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sqfootTextField.setForeground(new java.awt.Color(255, 255, 255));
        sqfootTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sqfootTextField.setText("99.99e-19");
        sqfootTextField.setToolTipText("Square feet");
        sqfootTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        sqfootTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        areaUnitPanel.add(sqfootTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 100, 25));

        sqmileTextField.setEditable(false);
        sqmileTextField.setBackground(new java.awt.Color(35, 35, 35));
        sqmileTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sqmileTextField.setForeground(new java.awt.Color(255, 255, 255));
        sqmileTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sqmileTextField.setText("99.99e-19");
        sqmileTextField.setToolTipText("Square miles");
        sqmileTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        sqmileTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        areaUnitPanel.add(sqmileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 100, 25));

        hectareTextField.setEditable(false);
        hectareTextField.setBackground(new java.awt.Color(35, 35, 35));
        hectareTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        hectareTextField.setForeground(new java.awt.Color(255, 255, 255));
        hectareTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        hectareTextField.setText("99.99e-19");
        hectareTextField.setToolTipText("Hectares");
        hectareTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        hectareTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        areaUnitPanel.add(hectareTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 100, 25));

        sqyardTextField.setEditable(false);
        sqyardTextField.setBackground(new java.awt.Color(35, 35, 35));
        sqyardTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sqyardTextField.setForeground(new java.awt.Color(255, 255, 255));
        sqyardTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sqyardTextField.setText("99.99e-19");
        sqyardTextField.setToolTipText("Square yards");
        sqyardTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        sqyardTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        areaUnitPanel.add(sqyardTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 100, 25));

        barnTextField.setEditable(false);
        barnTextField.setBackground(new java.awt.Color(35, 35, 35));
        barnTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        barnTextField.setForeground(new java.awt.Color(255, 255, 255));
        barnTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        barnTextField.setText("99.99e-19");
        barnTextField.setToolTipText("Barns");
        barnTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        barnTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        areaUnitPanel.add(barnTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 100, 25));

        sqmeterComboBox.setBackground(new java.awt.Color(35, 35, 35));
        sqmeterComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sqmeterComboBox.setMaximumRowCount(7);
        sqmeterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m²", "cm²", "mm²", "µm²", "nm²", "Å²", "km²" }));
        sqmeterComboBox.setFocusable(false);
        sqmeterComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        sqmeterComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sqmeterComboBoxItemStateChanged(evt);
            }
        });
        areaUnitPanel.add(sqmeterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        sqinchComboBox.setBackground(new java.awt.Color(35, 35, 35));
        sqinchComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sqinchComboBox.setMaximumRowCount(1);
        sqinchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "in²" }));
        sqinchComboBox.setFocusable(false);
        sqinchComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        sqinchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sqinchComboBoxItemStateChanged(evt);
            }
        });
        areaUnitPanel.add(sqinchComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        sqfootComboBox.setBackground(new java.awt.Color(35, 35, 35));
        sqfootComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sqfootComboBox.setMaximumRowCount(1);
        sqfootComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ft²" }));
        sqfootComboBox.setFocusable(false);
        sqfootComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        sqfootComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sqfootComboBoxItemStateChanged(evt);
            }
        });
        areaUnitPanel.add(sqfootComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        sqmileComboBox.setBackground(new java.awt.Color(35, 35, 35));
        sqmileComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sqmileComboBox.setMaximumRowCount(2);
        sqmileComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mi²", "ac" }));
        sqmileComboBox.setFocusable(false);
        sqmileComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        sqmileComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sqmileComboBoxItemStateChanged(evt);
            }
        });
        areaUnitPanel.add(sqmileComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        hectareComboBox.setBackground(new java.awt.Color(35, 35, 35));
        hectareComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        hectareComboBox.setMaximumRowCount(2);
        hectareComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ha", "a" }));
        hectareComboBox.setFocusable(false);
        hectareComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        hectareComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hectareComboBoxItemStateChanged(evt);
            }
        });
        areaUnitPanel.add(hectareComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        sqyardComboBox.setBackground(new java.awt.Color(35, 35, 35));
        sqyardComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sqyardComboBox.setMaximumRowCount(1);
        sqyardComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "yd²" }));
        sqyardComboBox.setFocusable(false);
        sqyardComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        sqyardComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sqyardComboBoxItemStateChanged(evt);
            }
        });
        areaUnitPanel.add(sqyardComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        barnComboBox.setBackground(new java.awt.Color(35, 35, 35));
        barnComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        barnComboBox.setMaximumRowCount(3);
        barnComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "b", "mb", "µb" }));
        barnComboBox.setToolTipText("");
        barnComboBox.setFocusable(false);
        barnComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        barnComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                barnComboBoxItemStateChanged(evt);
            }
        });
        areaUnitPanel.add(barnComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        sqmeterRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        sqmeterRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        sqmeterRadioButton.setActionCommand("0");
        sqmeterRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sqmeterRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        sqmeterRadioButton.setRolloverEnabled(false);
        areaUnitPanel.add(sqmeterRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        sqinchRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        sqinchRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        sqinchRadioButton.setActionCommand("1");
        sqinchRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sqinchRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        sqinchRadioButton.setRolloverEnabled(false);
        areaUnitPanel.add(sqinchRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        sqfootRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        sqfootRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        sqfootRadioButton.setActionCommand("2");
        sqfootRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sqfootRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        sqfootRadioButton.setRolloverEnabled(false);
        areaUnitPanel.add(sqfootRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        sqmileRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        sqmileRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        sqmileRadioButton.setActionCommand("3");
        sqmileRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sqmileRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        sqmileRadioButton.setRolloverEnabled(false);
        areaUnitPanel.add(sqmileRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        hectareRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        hectareRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        hectareRadioButton.setActionCommand("4");
        hectareRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hectareRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        hectareRadioButton.setRolloverEnabled(false);
        areaUnitPanel.add(hectareRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        sqyardRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        sqyardRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        sqyardRadioButton.setActionCommand("5");
        sqyardRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sqyardRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        sqyardRadioButton.setRolloverEnabled(false);
        areaUnitPanel.add(sqyardRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        barnRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        barnRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        barnRadioButton.setActionCommand("6");
        barnRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        barnRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        barnRadioButton.setRolloverEnabled(false);
        areaUnitPanel.add(barnRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        areaPanel.add(areaUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        areaTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        areaTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        areaTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        areaTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        areaTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        areaPanel.add(areaTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), areaPanel, "Area"); // NOI18N

        voluPanel.setBackground(new java.awt.Color(35, 35, 35));
        voluPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        voluPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        voluUnitPanel.setBackground(new java.awt.Color(35, 35, 35));
        voluUnitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Units", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        voluUnitPanel.setForeground(new java.awt.Color(255, 255, 255));
        voluUnitPanel.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        voluUnitPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        voluUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cubmeterTextField.setEditable(false);
        cubmeterTextField.setBackground(new java.awt.Color(35, 35, 35));
        cubmeterTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubmeterTextField.setForeground(new java.awt.Color(255, 255, 255));
        cubmeterTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cubmeterTextField.setText("99.99e-19");
        cubmeterTextField.setToolTipText("Cubic meters");
        cubmeterTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        cubmeterTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        voluUnitPanel.add(cubmeterTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 25));

        cubinchTextField.setEditable(false);
        cubinchTextField.setBackground(new java.awt.Color(35, 35, 35));
        cubinchTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubinchTextField.setForeground(new java.awt.Color(255, 255, 255));
        cubinchTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cubinchTextField.setText("99.99e-19");
        cubinchTextField.setToolTipText("Cubic inches");
        cubinchTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        cubinchTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        voluUnitPanel.add(cubinchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 25));

        cubfootTextField.setEditable(false);
        cubfootTextField.setBackground(new java.awt.Color(35, 35, 35));
        cubfootTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubfootTextField.setForeground(new java.awt.Color(255, 255, 255));
        cubfootTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cubfootTextField.setText("99.99e-19");
        cubfootTextField.setToolTipText("Cubic feet");
        cubfootTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        cubfootTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        voluUnitPanel.add(cubfootTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 100, 25));

        cubmileTextField.setEditable(false);
        cubmileTextField.setBackground(new java.awt.Color(35, 35, 35));
        cubmileTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubmileTextField.setForeground(new java.awt.Color(255, 255, 255));
        cubmileTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cubmileTextField.setText("99.99e-19");
        cubmileTextField.setToolTipText("Cubic miles");
        cubmileTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        cubmileTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        voluUnitPanel.add(cubmileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 100, 25));

        literTextField.setEditable(false);
        literTextField.setBackground(new java.awt.Color(35, 35, 35));
        literTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        literTextField.setForeground(new java.awt.Color(255, 255, 255));
        literTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        literTextField.setText("99.99e-19");
        literTextField.setToolTipText("Liters");
        literTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        literTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        voluUnitPanel.add(literTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 100, 25));

        galTextField.setEditable(false);
        galTextField.setBackground(new java.awt.Color(35, 35, 35));
        galTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        galTextField.setForeground(new java.awt.Color(255, 255, 255));
        galTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        galTextField.setText("99.99e-19");
        galTextField.setToolTipText("Gallons (US) / Barrel (US)");
        galTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        galTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        voluUnitPanel.add(galTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 100, 25));

        pintTextField.setEditable(false);
        pintTextField.setBackground(new java.awt.Color(35, 35, 35));
        pintTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        pintTextField.setForeground(new java.awt.Color(255, 255, 255));
        pintTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pintTextField.setText("99.99e-19");
        pintTextField.setToolTipText("Pints");
        pintTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        pintTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        voluUnitPanel.add(pintTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 100, 25));

        cupTextField.setEditable(false);
        cupTextField.setBackground(new java.awt.Color(35, 35, 35));
        cupTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cupTextField.setForeground(new java.awt.Color(255, 255, 255));
        cupTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cupTextField.setText("99.99e-19");
        cupTextField.setToolTipText("Cups");
        cupTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        cupTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        voluUnitPanel.add(cupTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 100, 25));

        tbspTextField.setEditable(false);
        tbspTextField.setBackground(new java.awt.Color(35, 35, 35));
        tbspTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        tbspTextField.setForeground(new java.awt.Color(255, 255, 255));
        tbspTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tbspTextField.setText("99.99e-19");
        tbspTextField.setToolTipText("Table spoons");
        tbspTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        tbspTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        voluUnitPanel.add(tbspTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 100, 25));

        teaspTextField.setEditable(false);
        teaspTextField.setBackground(new java.awt.Color(35, 35, 35));
        teaspTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        teaspTextField.setForeground(new java.awt.Color(255, 255, 255));
        teaspTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        teaspTextField.setText("99.99e-19");
        teaspTextField.setToolTipText("Tea spoons");
        teaspTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        teaspTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        voluUnitPanel.add(teaspTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 100, 25));

        cubmeterComboBox.setBackground(new java.awt.Color(35, 35, 35));
        cubmeterComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubmeterComboBox.setMaximumRowCount(6);
        cubmeterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m³", "cm³", "mm³", "µm³", "nm³", "km³" }));
        cubmeterComboBox.setFocusable(false);
        cubmeterComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        cubmeterComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cubmeterComboBoxItemStateChanged(evt);
            }
        });
        voluUnitPanel.add(cubmeterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        cubinchComboBox.setBackground(new java.awt.Color(35, 35, 35));
        cubinchComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubinchComboBox.setMaximumRowCount(1);
        cubinchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "in³" }));
        cubinchComboBox.setFocusable(false);
        cubinchComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        cubinchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cubinchComboBoxItemStateChanged(evt);
            }
        });
        voluUnitPanel.add(cubinchComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        cubfootComboBox.setBackground(new java.awt.Color(35, 35, 35));
        cubfootComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubfootComboBox.setMaximumRowCount(1);
        cubfootComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ft³" }));
        cubfootComboBox.setFocusable(false);
        cubfootComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        cubfootComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cubfootComboBoxItemStateChanged(evt);
            }
        });
        voluUnitPanel.add(cubfootComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        cubmileComboBox.setBackground(new java.awt.Color(35, 35, 35));
        cubmileComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubmileComboBox.setMaximumRowCount(1);
        cubmileComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mi³" }));
        cubmileComboBox.setFocusable(false);
        cubmileComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        cubmileComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cubmileComboBoxItemStateChanged(evt);
            }
        });
        voluUnitPanel.add(cubmileComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        literComboBox.setBackground(new java.awt.Color(35, 35, 35));
        literComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        literComboBox.setMaximumRowCount(4);
        literComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "l", "dl", "cl", "ml" }));
        literComboBox.setFocusable(false);
        literComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        literComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                literComboBoxItemStateChanged(evt);
            }
        });
        voluUnitPanel.add(literComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        galComboBox.setBackground(new java.awt.Color(35, 35, 35));
        galComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        galComboBox.setMaximumRowCount(2);
        galComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "gal", "bbl" }));
        galComboBox.setFocusable(false);
        galComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        galComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                galComboBoxItemStateChanged(evt);
            }
        });
        voluUnitPanel.add(galComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        pintComboBox.setBackground(new java.awt.Color(35, 35, 35));
        pintComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        pintComboBox.setMaximumRowCount(1);
        pintComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pt" }));
        pintComboBox.setFocusable(false);
        pintComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        pintComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pintComboBoxItemStateChanged(evt);
            }
        });
        voluUnitPanel.add(pintComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        cupComboBox.setBackground(new java.awt.Color(35, 35, 35));
        cupComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cupComboBox.setMaximumRowCount(1);
        cupComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cups" }));
        cupComboBox.setFocusable(false);
        cupComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        cupComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cupComboBoxItemStateChanged(evt);
            }
        });
        voluUnitPanel.add(cupComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        tbspComboBox.setBackground(new java.awt.Color(35, 35, 35));
        tbspComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        tbspComboBox.setMaximumRowCount(1);
        tbspComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tbsp" }));
        tbspComboBox.setFocusable(false);
        tbspComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        tbspComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tbspComboBoxItemStateChanged(evt);
            }
        });
        voluUnitPanel.add(tbspComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, -1));

        teaspComboBox.setBackground(new java.awt.Color(35, 35, 35));
        teaspComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        teaspComboBox.setMaximumRowCount(1);
        teaspComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tsp" }));
        teaspComboBox.setFocusable(false);
        teaspComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        teaspComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                teaspComboBoxItemStateChanged(evt);
            }
        });
        voluUnitPanel.add(teaspComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        cubmeterRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        cubmeterRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        cubmeterRadioButton.setActionCommand("0");
        cubmeterRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cubmeterRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        cubmeterRadioButton.setRolloverEnabled(false);
        voluUnitPanel.add(cubmeterRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        cubinchRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        cubinchRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        cubinchRadioButton.setActionCommand("1");
        cubinchRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cubinchRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        cubinchRadioButton.setRolloverEnabled(false);
        voluUnitPanel.add(cubinchRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        cubfootRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        cubfootRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        cubfootRadioButton.setActionCommand("2");
        cubfootRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cubfootRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        cubfootRadioButton.setRolloverEnabled(false);
        voluUnitPanel.add(cubfootRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        cubmileRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        cubmileRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        cubmileRadioButton.setActionCommand("3");
        cubmileRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cubmileRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        cubmileRadioButton.setRolloverEnabled(false);
        voluUnitPanel.add(cubmileRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        literRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        literRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        literRadioButton.setActionCommand("4");
        literRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        literRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        literRadioButton.setRolloverEnabled(false);
        voluUnitPanel.add(literRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        galRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        galRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        galRadioButton.setActionCommand("5");
        galRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        galRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        galRadioButton.setRolloverEnabled(false);
        voluUnitPanel.add(galRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        pintRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        pintRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        pintRadioButton.setActionCommand("6");
        pintRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pintRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        pintRadioButton.setRolloverEnabled(false);
        voluUnitPanel.add(pintRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        cupRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        cupRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        cupRadioButton.setActionCommand("7");
        cupRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cupRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        cupRadioButton.setRolloverEnabled(false);
        voluUnitPanel.add(cupRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        tbspRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        tbspRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        tbspRadioButton.setActionCommand("8");
        tbspRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbspRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        tbspRadioButton.setRolloverEnabled(false);
        voluUnitPanel.add(tbspRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        teaspRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        teaspRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        teaspRadioButton.setActionCommand("9");
        teaspRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teaspRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        teaspRadioButton.setRolloverEnabled(false);
        voluUnitPanel.add(teaspRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        voluPanel.add(voluUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        voluTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        voluTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        voluTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        voluTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        voluTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        voluPanel.add(voluTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), voluPanel, "Volume"); // NOI18N

        timePanel.setBackground(new java.awt.Color(35, 35, 35));
        timePanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        timePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeUnitPanel.setBackground(new java.awt.Color(35, 35, 35));
        timeUnitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Units", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        timeUnitPanel.setForeground(new java.awt.Color(255, 255, 255));
        timeUnitPanel.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        timeUnitPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        timeUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        secTextField.setEditable(false);
        secTextField.setBackground(new java.awt.Color(35, 35, 35));
        secTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        secTextField.setForeground(new java.awt.Color(255, 255, 255));
        secTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        secTextField.setText("99.99e-19");
        secTextField.setToolTipText("Seconds");
        secTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        secTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        timeUnitPanel.add(secTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 25));

        minTextField.setEditable(false);
        minTextField.setBackground(new java.awt.Color(35, 35, 35));
        minTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        minTextField.setForeground(new java.awt.Color(255, 255, 255));
        minTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        minTextField.setText("99.99e-19");
        minTextField.setToolTipText("Minutes");
        minTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        minTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        timeUnitPanel.add(minTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 25));

        hourTextField.setEditable(false);
        hourTextField.setBackground(new java.awt.Color(35, 35, 35));
        hourTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        hourTextField.setForeground(new java.awt.Color(255, 255, 255));
        hourTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        hourTextField.setText("99.99e-19");
        hourTextField.setToolTipText("Hours");
        hourTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        hourTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        timeUnitPanel.add(hourTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 100, 25));

        dayTextField.setEditable(false);
        dayTextField.setBackground(new java.awt.Color(35, 35, 35));
        dayTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        dayTextField.setForeground(new java.awt.Color(255, 255, 255));
        dayTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dayTextField.setText("99.99e-19");
        dayTextField.setToolTipText("Days");
        dayTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        dayTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        timeUnitPanel.add(dayTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 100, 25));

        weekTextField.setEditable(false);
        weekTextField.setBackground(new java.awt.Color(35, 35, 35));
        weekTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        weekTextField.setForeground(new java.awt.Color(255, 255, 255));
        weekTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        weekTextField.setText("99.99e-19");
        weekTextField.setToolTipText("Weeks");
        weekTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        weekTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        timeUnitPanel.add(weekTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 100, 25));

        monthTextField.setEditable(false);
        monthTextField.setBackground(new java.awt.Color(35, 35, 35));
        monthTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        monthTextField.setForeground(new java.awt.Color(255, 255, 255));
        monthTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        monthTextField.setText("99.99e-19");
        monthTextField.setToolTipText("Months");
        monthTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        monthTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        timeUnitPanel.add(monthTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 100, 25));

        yearTextField.setEditable(false);
        yearTextField.setBackground(new java.awt.Color(35, 35, 35));
        yearTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        yearTextField.setForeground(new java.awt.Color(255, 255, 255));
        yearTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        yearTextField.setText("99.99e-19");
        yearTextField.setToolTipText("Years");
        yearTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        yearTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        timeUnitPanel.add(yearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 100, 25));

        secComboBox.setBackground(new java.awt.Color(35, 35, 35));
        secComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        secComboBox.setMaximumRowCount(7);
        secComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "s", "ms", "µs", "ns", "ps", "fs", "as" }));
        secComboBox.setFocusable(false);
        secComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        secComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                secComboBoxItemStateChanged(evt);
            }
        });
        timeUnitPanel.add(secComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        minComboBox.setBackground(new java.awt.Color(35, 35, 35));
        minComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        minComboBox.setMaximumRowCount(1);
        minComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "min" }));
        minComboBox.setFocusable(false);
        minComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        timeUnitPanel.add(minComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        hourComboBox.setBackground(new java.awt.Color(35, 35, 35));
        hourComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        hourComboBox.setMaximumRowCount(1);
        hourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "h" }));
        hourComboBox.setFocusable(false);
        hourComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        timeUnitPanel.add(hourComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        dayComboBox.setBackground(new java.awt.Color(35, 35, 35));
        dayComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        dayComboBox.setMaximumRowCount(1);
        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "d" }));
        dayComboBox.setFocusable(false);
        dayComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        timeUnitPanel.add(dayComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        weekComboBox.setBackground(new java.awt.Color(35, 35, 35));
        weekComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        weekComboBox.setMaximumRowCount(1);
        weekComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "weeks" }));
        weekComboBox.setFocusable(false);
        weekComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        timeUnitPanel.add(weekComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        monthComboBox.setBackground(new java.awt.Color(35, 35, 35));
        monthComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        monthComboBox.setMaximumRowCount(1);
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "months" }));
        monthComboBox.setFocusable(false);
        monthComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        timeUnitPanel.add(monthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        yearComboBox.setBackground(new java.awt.Color(35, 35, 35));
        yearComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        yearComboBox.setMaximumRowCount(1);
        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "years" }));
        yearComboBox.setFocusable(false);
        yearComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        timeUnitPanel.add(yearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        secRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        secRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        secRadioButton.setActionCommand("0");
        secRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        secRadioButton.setRolloverEnabled(false);
        timeUnitPanel.add(secRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        minRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        minRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        minRadioButton.setActionCommand("1");
        minRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        minRadioButton.setRolloverEnabled(false);
        timeUnitPanel.add(minRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        hourRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        hourRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        hourRadioButton.setActionCommand("2");
        hourRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hourRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        hourRadioButton.setRolloverEnabled(false);
        timeUnitPanel.add(hourRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        dayRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        dayRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        dayRadioButton.setActionCommand("3");
        dayRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        dayRadioButton.setRolloverEnabled(false);
        timeUnitPanel.add(dayRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        weekRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        weekRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        weekRadioButton.setActionCommand("4");
        weekRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weekRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        weekRadioButton.setRolloverEnabled(false);
        timeUnitPanel.add(weekRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        monthRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        monthRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        monthRadioButton.setActionCommand("5");
        monthRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monthRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        monthRadioButton.setRolloverEnabled(false);
        timeUnitPanel.add(monthRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        yearRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        yearRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        yearRadioButton.setActionCommand("6");
        yearRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        yearRadioButton.setRolloverEnabled(false);
        timeUnitPanel.add(yearRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        timePanel.add(timeUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        timeTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        timeTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        timeTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        timeTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        timeTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        timePanel.add(timeTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), timePanel, "Time"); // NOI18N

        spdPanel.setBackground(new java.awt.Color(35, 35, 35));
        spdPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        spdPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spdUnitPanel.setBackground(new java.awt.Color(35, 35, 35));
        spdUnitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Units", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        spdUnitPanel.setForeground(new java.awt.Color(255, 255, 255));
        spdUnitPanel.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        spdUnitPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        spdUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        msTextField.setEditable(false);
        msTextField.setBackground(new java.awt.Color(35, 35, 35));
        msTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        msTextField.setForeground(new java.awt.Color(255, 255, 255));
        msTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        msTextField.setText("99.99e-19");
        msTextField.setToolTipText("Meters per second");
        msTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        msTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        spdUnitPanel.add(msTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 25));

        kmhTextField.setEditable(false);
        kmhTextField.setBackground(new java.awt.Color(35, 35, 35));
        kmhTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        kmhTextField.setForeground(new java.awt.Color(255, 255, 255));
        kmhTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        kmhTextField.setText("99.99e-19");
        kmhTextField.setToolTipText("Kilometers per hour");
        kmhTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        kmhTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        spdUnitPanel.add(kmhTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 25));

        mphTextField.setEditable(false);
        mphTextField.setBackground(new java.awt.Color(35, 35, 35));
        mphTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        mphTextField.setForeground(new java.awt.Color(255, 255, 255));
        mphTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        mphTextField.setText("99.99e-19");
        mphTextField.setToolTipText("Miles per hour");
        mphTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        mphTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        spdUnitPanel.add(mphTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 100, 25));

        knotTextField.setEditable(false);
        knotTextField.setBackground(new java.awt.Color(35, 35, 35));
        knotTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        knotTextField.setForeground(new java.awt.Color(255, 255, 255));
        knotTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        knotTextField.setText("99.99e-19");
        knotTextField.setToolTipText("Knots");
        knotTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        knotTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        spdUnitPanel.add(knotTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 100, 25));

        ftsTextField.setEditable(false);
        ftsTextField.setBackground(new java.awt.Color(35, 35, 35));
        ftsTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        ftsTextField.setForeground(new java.awt.Color(255, 255, 255));
        ftsTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftsTextField.setText("99.99e-19");
        ftsTextField.setToolTipText("Feet per second");
        ftsTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        ftsTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        spdUnitPanel.add(ftsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 100, 25));

        machTextField.setEditable(false);
        machTextField.setBackground(new java.awt.Color(35, 35, 35));
        machTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        machTextField.setForeground(new java.awt.Color(255, 255, 255));
        machTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        machTextField.setText("99.99e-19");
        machTextField.setToolTipText("Mach");
        machTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        machTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        spdUnitPanel.add(machTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 100, 25));

        msComboBox.setBackground(new java.awt.Color(35, 35, 35));
        msComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        msComboBox.setMaximumRowCount(7);
        msComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m/s", "cm/s", "mm/s", "µm/s", "nm/s", "Å/s", "km/s" }));
        msComboBox.setFocusable(false);
        msComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        msComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                msComboBoxItemStateChanged(evt);
            }
        });
        spdUnitPanel.add(msComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        kmhComboBox.setBackground(new java.awt.Color(35, 35, 35));
        kmhComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        kmhComboBox.setMaximumRowCount(1);
        kmhComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "km/h" }));
        kmhComboBox.setFocusable(false);
        kmhComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        kmhComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kmhComboBoxItemStateChanged(evt);
            }
        });
        spdUnitPanel.add(kmhComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        mphComboBox.setBackground(new java.awt.Color(35, 35, 35));
        mphComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        mphComboBox.setMaximumRowCount(1);
        mphComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mph" }));
        mphComboBox.setFocusable(false);
        mphComboBox.setMinimumSize(new java.awt.Dimension(50, 25));
        mphComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        mphComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mphComboBoxItemStateChanged(evt);
            }
        });
        spdUnitPanel.add(mphComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        knotComboBox.setBackground(new java.awt.Color(35, 35, 35));
        knotComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        knotComboBox.setMaximumRowCount(1);
        knotComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kn" }));
        knotComboBox.setFocusable(false);
        knotComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        spdUnitPanel.add(knotComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        ftsComboBox.setBackground(new java.awt.Color(35, 35, 35));
        ftsComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        ftsComboBox.setMaximumRowCount(1);
        ftsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ft/s" }));
        ftsComboBox.setFocusable(false);
        ftsComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        spdUnitPanel.add(ftsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        machComboBox.setBackground(new java.awt.Color(35, 35, 35));
        machComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        machComboBox.setMaximumRowCount(1);
        machComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ma" }));
        machComboBox.setFocusable(false);
        machComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        spdUnitPanel.add(machComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        msRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        msRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        msRadioButton.setActionCommand("0");
        msRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        msRadioButton.setRolloverEnabled(false);
        spdUnitPanel.add(msRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        kmhRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        kmhRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        kmhRadioButton.setActionCommand("1");
        kmhRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kmhRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        kmhRadioButton.setRolloverEnabled(false);
        spdUnitPanel.add(kmhRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        mphRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        mphRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        mphRadioButton.setActionCommand("2");
        mphRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mphRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        mphRadioButton.setRolloverEnabled(false);
        spdUnitPanel.add(mphRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        knotRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        knotRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        knotRadioButton.setActionCommand("3");
        knotRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        knotRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        knotRadioButton.setRolloverEnabled(false);
        spdUnitPanel.add(knotRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        ftsRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        ftsRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        ftsRadioButton.setActionCommand("4");
        ftsRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ftsRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        ftsRadioButton.setRolloverEnabled(false);
        spdUnitPanel.add(ftsRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        machRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        machRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        machRadioButton.setActionCommand("5");
        machRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        machRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        machRadioButton.setRolloverEnabled(false);
        spdUnitPanel.add(machRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        spdPanel.add(spdUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        spdTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        spdTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        spdTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        spdTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        spdTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        spdPanel.add(spdTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), spdPanel, "Speed"); // NOI18N

        flowPanel.setBackground(new java.awt.Color(35, 35, 35));
        flowPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        flowPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        flowUnitPanel.setBackground(new java.awt.Color(35, 35, 35));
        flowUnitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Units", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        flowUnitPanel.setForeground(new java.awt.Color(255, 255, 255));
        flowUnitPanel.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        flowUnitPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        flowUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cubmsTextField.setEditable(false);
        cubmsTextField.setBackground(new java.awt.Color(35, 35, 35));
        cubmsTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubmsTextField.setForeground(new java.awt.Color(255, 255, 255));
        cubmsTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cubmsTextField.setText("99.99e-19");
        cubmsTextField.setToolTipText("Cubic meters per second");
        cubmsTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        cubmsTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        flowUnitPanel.add(cubmsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 25));

        cubmhTextField.setEditable(false);
        cubmhTextField.setBackground(new java.awt.Color(35, 35, 35));
        cubmhTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubmhTextField.setForeground(new java.awt.Color(255, 255, 255));
        cubmhTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cubmhTextField.setText("99.99e-19");
        cubmhTextField.setToolTipText("Cubic meters per hour");
        cubmhTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        cubmhTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        flowUnitPanel.add(cubmhTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 25));

        litsTextField.setEditable(false);
        litsTextField.setBackground(new java.awt.Color(35, 35, 35));
        litsTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        litsTextField.setForeground(new java.awt.Color(255, 255, 255));
        litsTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        litsTextField.setText("99.99e-19");
        litsTextField.setToolTipText("Liters per second");
        litsTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        litsTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        flowUnitPanel.add(litsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 100, 25));

        litmTextField.setEditable(false);
        litmTextField.setBackground(new java.awt.Color(35, 35, 35));
        litmTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        litmTextField.setForeground(new java.awt.Color(255, 255, 255));
        litmTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        litmTextField.setText("99.99e-19");
        litmTextField.setToolTipText("Liters per minute");
        litmTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        litmTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        flowUnitPanel.add(litmTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 100, 25));

        cubftsTextField.setEditable(false);
        cubftsTextField.setBackground(new java.awt.Color(35, 35, 35));
        cubftsTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubftsTextField.setForeground(new java.awt.Color(255, 255, 255));
        cubftsTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cubftsTextField.setText("99.99e-19");
        cubftsTextField.setToolTipText("Cubic feet per second");
        cubftsTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        cubftsTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        flowUnitPanel.add(cubftsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 100, 25));

        sccmTextField.setEditable(false);
        sccmTextField.setBackground(new java.awt.Color(35, 35, 35));
        sccmTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sccmTextField.setForeground(new java.awt.Color(255, 255, 255));
        sccmTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sccmTextField.setText("99.99e-19");
        sccmTextField.setToolTipText("Standard cubic centimeters per minute");
        sccmTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        sccmTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        flowUnitPanel.add(sccmTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 100, 25));

        galminTextField.setEditable(false);
        galminTextField.setBackground(new java.awt.Color(35, 35, 35));
        galminTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        galminTextField.setForeground(new java.awt.Color(255, 255, 255));
        galminTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        galminTextField.setText("99.99e-19");
        galminTextField.setToolTipText("Gallons (US) per minute");
        galminTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        galminTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        flowUnitPanel.add(galminTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 100, 25));

        cubmsComboBox.setBackground(new java.awt.Color(35, 35, 35));
        cubmsComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubmsComboBox.setMaximumRowCount(3);
        cubmsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m³/s", "cm³/s", "mm³/s" }));
        cubmsComboBox.setFocusable(false);
        cubmsComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        cubmsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cubmsComboBoxItemStateChanged(evt);
            }
        });
        flowUnitPanel.add(cubmsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        cubmhComboBox.setBackground(new java.awt.Color(35, 35, 35));
        cubmhComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubmhComboBox.setMaximumRowCount(3);
        cubmhComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m³/h", "cm³/h", "mm³/h" }));
        cubmhComboBox.setFocusable(false);
        cubmhComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        cubmhComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cubmhComboBoxItemStateChanged(evt);
            }
        });
        flowUnitPanel.add(cubmhComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        litsComboBox.setBackground(new java.awt.Color(35, 35, 35));
        litsComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        litsComboBox.setMaximumRowCount(4);
        litsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "l/s", "dl/s", "cl/s", "ml/s" }));
        litsComboBox.setFocusable(false);
        litsComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        litsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                litsComboBoxItemStateChanged(evt);
            }
        });
        flowUnitPanel.add(litsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        litmComboBox.setBackground(new java.awt.Color(35, 35, 35));
        litmComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        litmComboBox.setMaximumRowCount(4);
        litmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "l/min", "dl/min", "cl/min", "ml/min" }));
        litmComboBox.setFocusable(false);
        litmComboBox.setMinimumSize(new java.awt.Dimension(50, 25));
        litmComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        litmComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                litmComboBoxItemStateChanged(evt);
            }
        });
        flowUnitPanel.add(litmComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        cubftsComboBox.setBackground(new java.awt.Color(35, 35, 35));
        cubftsComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cubftsComboBox.setMaximumRowCount(1);
        cubftsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ft³/s" }));
        cubftsComboBox.setToolTipText("");
        cubftsComboBox.setFocusable(false);
        cubftsComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        flowUnitPanel.add(cubftsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        sccmComboBox.setBackground(new java.awt.Color(35, 35, 35));
        sccmComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        sccmComboBox.setMaximumRowCount(1);
        sccmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sccm" }));
        sccmComboBox.setFocusable(false);
        sccmComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        flowUnitPanel.add(sccmComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        galminComboBox.setBackground(new java.awt.Color(35, 35, 35));
        galminComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        galminComboBox.setMaximumRowCount(2);
        galminComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "gal/min", "bbl/min" }));
        galminComboBox.setFocusable(false);
        galminComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        galminComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                galminComboBoxItemStateChanged(evt);
            }
        });
        flowUnitPanel.add(galminComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 80, -1));

        cubmsRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        cubmsRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        cubmsRadioButton.setActionCommand("0");
        cubmsRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cubmsRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        cubmsRadioButton.setRolloverEnabled(false);
        flowUnitPanel.add(cubmsRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        cubmhRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        cubmhRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        cubmhRadioButton.setActionCommand("1");
        cubmhRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cubmhRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        cubmhRadioButton.setRolloverEnabled(false);
        flowUnitPanel.add(cubmhRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        litsRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        litsRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        litsRadioButton.setActionCommand("2");
        litsRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        litsRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        litsRadioButton.setRolloverEnabled(false);
        flowUnitPanel.add(litsRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        litmRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        litmRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        litmRadioButton.setActionCommand("3");
        litmRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        litmRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        litmRadioButton.setRolloverEnabled(false);
        flowUnitPanel.add(litmRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        cubftsRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        cubftsRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        cubftsRadioButton.setActionCommand("4");
        cubftsRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cubftsRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        cubftsRadioButton.setRolloverEnabled(false);
        flowUnitPanel.add(cubftsRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        sccmRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        sccmRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        sccmRadioButton.setActionCommand("5");
        sccmRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sccmRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        sccmRadioButton.setRolloverEnabled(false);
        flowUnitPanel.add(sccmRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        galminRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        galminRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        galminRadioButton.setActionCommand("6");
        galminRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        galminRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        galminRadioButton.setRolloverEnabled(false);
        flowUnitPanel.add(galminRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        flowPanel.add(flowUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        flowTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        flowTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        flowTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        flowTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        flowTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        flowPanel.add(flowTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), flowPanel, "Flow"); // NOI18N

        tempPanel.setBackground(new java.awt.Color(35, 35, 35));
        tempPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        tempPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tempUnitPanel.setBackground(new java.awt.Color(35, 35, 35));
        tempUnitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Units", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        tempUnitPanel.setForeground(new java.awt.Color(255, 255, 255));
        tempUnitPanel.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        tempUnitPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        tempUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kelvinTextField.setEditable(false);
        kelvinTextField.setBackground(new java.awt.Color(35, 35, 35));
        kelvinTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        kelvinTextField.setForeground(new java.awt.Color(255, 255, 255));
        kelvinTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        kelvinTextField.setText("99.99e-19");
        kelvinTextField.setToolTipText("Kelvin");
        kelvinTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        kelvinTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        tempUnitPanel.add(kelvinTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 25));

        celsTextField.setEditable(false);
        celsTextField.setBackground(new java.awt.Color(35, 35, 35));
        celsTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        celsTextField.setForeground(new java.awt.Color(255, 255, 255));
        celsTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        celsTextField.setText("99.99e-19");
        celsTextField.setToolTipText("Celsius");
        celsTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        celsTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        tempUnitPanel.add(celsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 25));

        fahrTextField.setEditable(false);
        fahrTextField.setBackground(new java.awt.Color(35, 35, 35));
        fahrTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        fahrTextField.setForeground(new java.awt.Color(255, 255, 255));
        fahrTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fahrTextField.setText("99.99e-19");
        fahrTextField.setToolTipText("Fahrenheit");
        fahrTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        fahrTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        tempUnitPanel.add(fahrTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 100, 25));

        kelvinComboBox.setBackground(new java.awt.Color(35, 35, 35));
        kelvinComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        kelvinComboBox.setMaximumRowCount(2);
        kelvinComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K", "mK" }));
        kelvinComboBox.setFocusable(false);
        kelvinComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        tempUnitPanel.add(kelvinComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        celsComboBox.setBackground(new java.awt.Color(35, 35, 35));
        celsComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        celsComboBox.setMaximumRowCount(1);
        celsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "°C" }));
        celsComboBox.setFocusable(false);
        celsComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        tempUnitPanel.add(celsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        fahrComboBox.setBackground(new java.awt.Color(35, 35, 35));
        fahrComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        fahrComboBox.setMaximumRowCount(1);
        fahrComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "°F" }));
        fahrComboBox.setFocusable(false);
        fahrComboBox.setMinimumSize(new java.awt.Dimension(50, 25));
        fahrComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        tempUnitPanel.add(fahrComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        kelvinRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        kelvinRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        kelvinRadioButton.setActionCommand("0");
        kelvinRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kelvinRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        kelvinRadioButton.setRolloverEnabled(false);
        tempUnitPanel.add(kelvinRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        celsRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        celsRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        celsRadioButton.setActionCommand("1");
        celsRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        celsRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        celsRadioButton.setRolloverEnabled(false);
        tempUnitPanel.add(celsRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        fahrRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        fahrRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        fahrRadioButton.setActionCommand("2");
        fahrRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fahrRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        fahrRadioButton.setRolloverEnabled(false);
        tempUnitPanel.add(fahrRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        tempPanel.add(tempUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        tempTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        tempTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        tempTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        tempTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        tempTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tempPanel.add(tempTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), tempPanel, "Temperature"); // NOI18N

        angPanel.setBackground(new java.awt.Color(35, 35, 35));
        angPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        angPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        angUnitPanel.setBackground(new java.awt.Color(35, 35, 35));
        angUnitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Units", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        angUnitPanel.setForeground(new java.awt.Color(255, 255, 255));
        angUnitPanel.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        angUnitPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        angUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        radTextField.setEditable(false);
        radTextField.setBackground(new java.awt.Color(35, 35, 35));
        radTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        radTextField.setForeground(new java.awt.Color(255, 255, 255));
        radTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        radTextField.setText("99.99e-19");
        radTextField.setToolTipText("Radians");
        radTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        radTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        angUnitPanel.add(radTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 25));

        degTextField.setEditable(false);
        degTextField.setBackground(new java.awt.Color(35, 35, 35));
        degTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        degTextField.setForeground(new java.awt.Color(255, 255, 255));
        degTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        degTextField.setText("99.99e-19");
        degTextField.setToolTipText("Degrees");
        degTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        degTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        angUnitPanel.add(degTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 25));

        gradTextField.setEditable(false);
        gradTextField.setBackground(new java.awt.Color(35, 35, 35));
        gradTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        gradTextField.setForeground(new java.awt.Color(255, 255, 255));
        gradTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gradTextField.setText("99.99e-19");
        gradTextField.setToolTipText("Gradians");
        gradTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        gradTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        angUnitPanel.add(gradTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 100, 25));

        radComboBox.setBackground(new java.awt.Color(35, 35, 35));
        radComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        radComboBox.setMaximumRowCount(1);
        radComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(rad)" }));
        radComboBox.setFocusable(false);
        radComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        angUnitPanel.add(radComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        degComboBox.setBackground(new java.awt.Color(35, 35, 35));
        degComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        degComboBox.setMaximumRowCount(1);
        degComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "°" }));
        degComboBox.setFocusable(false);
        degComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        angUnitPanel.add(degComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        gradComboBox.setBackground(new java.awt.Color(35, 35, 35));
        gradComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        gradComboBox.setMaximumRowCount(1);
        gradComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "grad" }));
        gradComboBox.setFocusable(false);
        gradComboBox.setMinimumSize(new java.awt.Dimension(50, 25));
        gradComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        angUnitPanel.add(gradComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        radRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        radRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        radRadioButton.setActionCommand("0");
        radRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        radRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        radRadioButton.setRolloverEnabled(false);
        angUnitPanel.add(radRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        degRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        degRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        degRadioButton.setActionCommand("1");
        degRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        degRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        degRadioButton.setRolloverEnabled(false);
        angUnitPanel.add(degRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        gradRadioButton.setBackground(new java.awt.Color(35, 35, 35));
        gradRadioButton.setForeground(new java.awt.Color(35, 35, 35));
        gradRadioButton.setActionCommand("2");
        gradRadioButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradRadioButton.setPreferredSize(new java.awt.Dimension(25, 25));
        gradRadioButton.setRolloverEnabled(false);
        angUnitPanel.add(gradRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        angPanel.add(angUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        angTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        angTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        angTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        angTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        angTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        angPanel.add(angTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), angPanel, "Angle"); // NOI18N

        consPanel.setBackground(new java.awt.Color(35, 35, 35));
        consPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        consPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consScrollPane.setBackground(new java.awt.Color(35, 35, 35));
        consScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Constants", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        consScrollPane.setForeground(new java.awt.Color(255, 255, 255));
        consScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        consScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        consScrollPane.setAutoscrolls(true);
        consScrollPane.setDoubleBuffered(true);
        consScrollPane.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        consScrollPane.setMinimumSize(new java.awt.Dimension(100, 100));
        consScrollPane.setPreferredSize(new java.awt.Dimension(245, 165));

        consinnerPanel.setBackground(new java.awt.Color(35, 35, 35));
        consinnerPanel.setFont(new java.awt.Font("Roboto Slab", 0, 10)); // NOI18N
        consinnerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lightspdTextField.setEditable(false);
        lightspdTextField.setBackground(new java.awt.Color(35, 35, 35));
        lightspdTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        lightspdTextField.setForeground(new java.awt.Color(255, 255, 255));
        lightspdTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lightspdTextField.setText("2.99792458e8");
        lightspdTextField.setToolTipText("Speed of light");
        lightspdTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        lightspdTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(lightspdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 19, 120, 25));

        newtonTextField.setEditable(false);
        newtonTextField.setBackground(new java.awt.Color(35, 35, 35));
        newtonTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        newtonTextField.setForeground(new java.awt.Color(255, 255, 255));
        newtonTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        newtonTextField.setText("6.67408e-11");
        newtonTextField.setToolTipText("Gravitational constant");
        newtonTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        newtonTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(newtonTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 69, 120, 25));

        plankTextField.setEditable(false);
        plankTextField.setBackground(new java.awt.Color(35, 35, 35));
        plankTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        plankTextField.setForeground(new java.awt.Color(255, 255, 255));
        plankTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        plankTextField.setText("6.626070040e-34");
        plankTextField.setToolTipText("Planck constant");
        plankTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        plankTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(plankTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 119, 120, 25));

        redplankTextField.setEditable(false);
        redplankTextField.setBackground(new java.awt.Color(35, 35, 35));
        redplankTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        redplankTextField.setForeground(new java.awt.Color(255, 255, 255));
        redplankTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        redplankTextField.setText("1.054571800e-34");
        redplankTextField.setToolTipText("Reduced Planck constant");
        redplankTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        redplankTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(redplankTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 169, 120, 25));

        cosmoTextField.setEditable(false);
        cosmoTextField.setBackground(new java.awt.Color(35, 35, 35));
        cosmoTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cosmoTextField.setForeground(new java.awt.Color(255, 255, 255));
        cosmoTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cosmoTextField.setText("1.11e-52");
        cosmoTextField.setToolTipText("Cosmological constant");
        cosmoTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        cosmoTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(cosmoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 219, 120, 25));

        einsteinTextField.setEditable(false);
        einsteinTextField.setBackground(new java.awt.Color(35, 35, 35));
        einsteinTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        einsteinTextField.setForeground(new java.awt.Color(255, 255, 255));
        einsteinTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        einsteinTextField.setText("1.866e-26");
        einsteinTextField.setToolTipText("Einstein constant");
        einsteinTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        einsteinTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(einsteinTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 269, 120, 25));

        hubbleTextField.setEditable(false);
        hubbleTextField.setBackground(new java.awt.Color(35, 35, 35));
        hubbleTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        hubbleTextField.setForeground(new java.awt.Color(255, 255, 255));
        hubbleTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        hubbleTextField.setText("2.326860841e-18");
        hubbleTextField.setToolTipText("Hubble constant");
        hubbleTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        hubbleTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(hubbleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 319, 120, 25));

        permeabTextField.setEditable(false);
        permeabTextField.setBackground(new java.awt.Color(35, 35, 35));
        permeabTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        permeabTextField.setForeground(new java.awt.Color(255, 255, 255));
        permeabTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        permeabTextField.setText("1.256637061e-6");
        permeabTextField.setToolTipText("Vacuum permeability");
        permeabTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        permeabTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(permeabTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 369, 120, 25));

        permitTextField.setEditable(false);
        permitTextField.setBackground(new java.awt.Color(35, 35, 35));
        permitTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        permitTextField.setForeground(new java.awt.Color(255, 255, 255));
        permitTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        permitTextField.setText("8.854187817e-12");
        permitTextField.setToolTipText("Vacuum permittivity");
        permitTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        permitTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(permitTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 419, 120, 25));

        vacimpedTextField.setEditable(false);
        vacimpedTextField.setBackground(new java.awt.Color(35, 35, 35));
        vacimpedTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        vacimpedTextField.setForeground(new java.awt.Color(255, 255, 255));
        vacimpedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        vacimpedTextField.setText("3.767303135e2");
        vacimpedTextField.setToolTipText("Vacuum impedance");
        vacimpedTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        vacimpedTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(vacimpedTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 469, 120, 25));

        chargeTextField.setEditable(false);
        chargeTextField.setBackground(new java.awt.Color(35, 35, 35));
        chargeTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        chargeTextField.setForeground(new java.awt.Color(255, 255, 255));
        chargeTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        chargeTextField.setText("1.602176621e-19");
        chargeTextField.setToolTipText("Elementary charge");
        chargeTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        chargeTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(chargeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 519, 120, 25));

        elmassTextField.setEditable(false);
        elmassTextField.setBackground(new java.awt.Color(35, 35, 35));
        elmassTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        elmassTextField.setForeground(new java.awt.Color(255, 255, 255));
        elmassTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        elmassTextField.setText("9.10938356e-31");
        elmassTextField.setToolTipText("Electron mass");
        elmassTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        elmassTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(elmassTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 569, 120, 25));

        protmassTextField.setEditable(false);
        protmassTextField.setBackground(new java.awt.Color(35, 35, 35));
        protmassTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        protmassTextField.setForeground(new java.awt.Color(255, 255, 255));
        protmassTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        protmassTextField.setText("1.672621898e-27");
        protmassTextField.setToolTipText("Proton mass");
        protmassTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        protmassTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(protmassTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 619, 120, 25));

        neutmassTextField.setEditable(false);
        neutmassTextField.setBackground(new java.awt.Color(35, 35, 35));
        neutmassTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        neutmassTextField.setForeground(new java.awt.Color(255, 255, 255));
        neutmassTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        neutmassTextField.setText("1.674927471e-27");
        neutmassTextField.setToolTipText("Neutron mass");
        neutmassTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        neutmassTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(neutmassTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 669, 120, 25));

        amuTextField.setEditable(false);
        amuTextField.setBackground(new java.awt.Color(35, 35, 35));
        amuTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        amuTextField.setForeground(new java.awt.Color(255, 255, 255));
        amuTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        amuTextField.setText("1.660539040e-27");
        amuTextField.setToolTipText("Atomic mass unit");
        amuTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        amuTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(amuTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 719, 120, 25));

        bohrmagTextField.setEditable(false);
        bohrmagTextField.setBackground(new java.awt.Color(35, 35, 35));
        bohrmagTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        bohrmagTextField.setForeground(new java.awt.Color(255, 255, 255));
        bohrmagTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        bohrmagTextField.setText("9.274009994e-24");
        bohrmagTextField.setToolTipText("Bohr magneton");
        bohrmagTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        bohrmagTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(bohrmagTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 19, 120, 25));

        nuclmagTextField.setEditable(false);
        nuclmagTextField.setBackground(new java.awt.Color(35, 35, 35));
        nuclmagTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        nuclmagTextField.setForeground(new java.awt.Color(255, 255, 255));
        nuclmagTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nuclmagTextField.setText("5.050783699e-27");
        nuclmagTextField.setToolTipText("Nuclear magneton");
        nuclmagTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        nuclmagTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(nuclmagTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 69, 120, 25));

        finestrTextField.setEditable(false);
        finestrTextField.setBackground(new java.awt.Color(35, 35, 35));
        finestrTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        finestrTextField.setForeground(new java.awt.Color(255, 255, 255));
        finestrTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        finestrTextField.setText("7.297352566e-3");
        finestrTextField.setToolTipText("Fine-structure constant");
        finestrTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        finestrTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(finestrTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 119, 120, 25));

        rydbergTextField.setEditable(false);
        rydbergTextField.setBackground(new java.awt.Color(35, 35, 35));
        rydbergTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        rydbergTextField.setForeground(new java.awt.Color(255, 255, 255));
        rydbergTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        rydbergTextField.setText("1.097373156e7");
        rydbergTextField.setToolTipText("Rydberg constant");
        rydbergTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        consinnerPanel.add(rydbergTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 169, 120, 25));

        bohrradTextField.setEditable(false);
        bohrradTextField.setBackground(new java.awt.Color(35, 35, 35));
        bohrradTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        bohrradTextField.setForeground(new java.awt.Color(255, 255, 255));
        bohrradTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        bohrradTextField.setText("5.291772107e-11");
        bohrradTextField.setToolTipText("Bohr radius");
        bohrradTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        bohrradTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(bohrradTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 219, 120, 25));

        avogadroTextField.setEditable(false);
        avogadroTextField.setBackground(new java.awt.Color(35, 35, 35));
        avogadroTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        avogadroTextField.setForeground(new java.awt.Color(255, 255, 255));
        avogadroTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        avogadroTextField.setText("6.022140857e23");
        avogadroTextField.setToolTipText("Avogadro constant");
        avogadroTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        avogadroTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(avogadroTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 269, 120, 25));

        gasTextField.setEditable(false);
        gasTextField.setBackground(new java.awt.Color(35, 35, 35));
        gasTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        gasTextField.setForeground(new java.awt.Color(255, 255, 255));
        gasTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gasTextField.setText("8.3144598");
        gasTextField.setToolTipText("Gas constant");
        gasTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        gasTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(gasTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 319, 120, 25));

        boltzmannTextField.setEditable(false);
        boltzmannTextField.setBackground(new java.awt.Color(35, 35, 35));
        boltzmannTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        boltzmannTextField.setForeground(new java.awt.Color(255, 255, 255));
        boltzmannTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boltzmannTextField.setText("1.38064852e-23");
        boltzmannTextField.setToolTipText("Boltzmann constant");
        boltzmannTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        boltzmannTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(boltzmannTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 369, 120, 25));

        faradayTextField1.setEditable(false);
        faradayTextField1.setBackground(new java.awt.Color(35, 35, 35));
        faradayTextField1.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        faradayTextField1.setForeground(new java.awt.Color(255, 255, 255));
        faradayTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        faradayTextField1.setText("9.648533289e4");
        faradayTextField1.setToolTipText("Faraday constant");
        faradayTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        faradayTextField1.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(faradayTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 419, 120, 25));

        stefboltzTextField.setEditable(false);
        stefboltzTextField.setBackground(new java.awt.Color(35, 35, 35));
        stefboltzTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        stefboltzTextField.setForeground(new java.awt.Color(255, 255, 255));
        stefboltzTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stefboltzTextField.setText("5.670367e-8");
        stefboltzTextField.setToolTipText("Stefan-Boltzmann constant");
        stefboltzTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        stefboltzTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(stefboltzTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 469, 120, 25));

        condqTextField.setEditable(false);
        condqTextField.setBackground(new java.awt.Color(35, 35, 35));
        condqTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        condqTextField.setForeground(new java.awt.Color(255, 255, 255));
        condqTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        condqTextField.setText("7.748091731e-5");
        condqTextField.setToolTipText("Conductance quantum");
        condqTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        condqTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(condqTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 519, 120, 25));

        fluxqTextField.setEditable(false);
        fluxqTextField.setBackground(new java.awt.Color(35, 35, 35));
        fluxqTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        fluxqTextField.setForeground(new java.awt.Color(255, 255, 255));
        fluxqTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fluxqTextField.setText("2.067833831e-15");
        fluxqTextField.setToolTipText("Magnetic flux quantum");
        fluxqTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        fluxqTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(fluxqTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 569, 120, 25));

        josephTextField.setEditable(false);
        josephTextField.setBackground(new java.awt.Color(35, 35, 35));
        josephTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        josephTextField.setForeground(new java.awt.Color(255, 255, 255));
        josephTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        josephTextField.setText("4.835978525e14");
        josephTextField.setToolTipText("Josephson constant");
        josephTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        josephTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(josephTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 619, 120, 25));

        wienTextField.setEditable(false);
        wienTextField.setBackground(new java.awt.Color(35, 35, 35));
        wienTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        wienTextField.setForeground(new java.awt.Color(255, 255, 255));
        wienTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        wienTextField.setText("2.8977729e-3");
        wienTextField.setToolTipText("Wien displacement law constant");
        wienTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        wienTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(wienTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 669, 120, 25));

        gravaccTextField.setEditable(false);
        gravaccTextField.setBackground(new java.awt.Color(35, 35, 35));
        gravaccTextField.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        gravaccTextField.setForeground(new java.awt.Color(255, 255, 255));
        gravaccTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gravaccTextField.setText("9.80665");
        gravaccTextField.setToolTipText("Standard acceleration of gravity");
        gravaccTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        gravaccTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        consinnerPanel.add(gravaccTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 719, 120, 25));

        lightspdComboBox.setBackground(new java.awt.Color(35, 35, 35));
        lightspdComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        lightspdComboBox.setMaximumRowCount(2);
        lightspdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m/s", "km/s" }));
        lightspdComboBox.setFocusable(false);
        lightspdComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        lightspdComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lightspdComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(lightspdComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 19, 69, -1));

        newtonComboBox.setBackground(new java.awt.Color(35, 35, 35));
        newtonComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        newtonComboBox.setMaximumRowCount(2);
        newtonComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m³/(kg s²)", "N m²/kg²" }));
        newtonComboBox.setFocusable(false);
        newtonComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        consinnerPanel.add(newtonComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 69, 69, -1));

        plankComboBox.setBackground(new java.awt.Color(35, 35, 35));
        plankComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        plankComboBox.setMaximumRowCount(2);
        plankComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J s", "eV s" }));
        plankComboBox.setFocusable(false);
        plankComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        plankComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                plankComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(plankComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 119, 69, -1));

        redplankComboBox.setBackground(new java.awt.Color(35, 35, 35));
        redplankComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        redplankComboBox.setMaximumRowCount(2);
        redplankComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J s", "eV s" }));
        redplankComboBox.setFocusable(false);
        redplankComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        redplankComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                redplankComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(redplankComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 169, 69, -1));

        cosmoComboBox.setBackground(new java.awt.Color(35, 35, 35));
        cosmoComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cosmoComboBox.setMaximumRowCount(1);
        cosmoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1/m²" }));
        cosmoComboBox.setFocusable(false);
        cosmoComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        consinnerPanel.add(cosmoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 219, 69, -1));

        einsteinComboBox.setBackground(new java.awt.Color(35, 35, 35));
        einsteinComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        einsteinComboBox.setMaximumRowCount(2);
        einsteinComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m/kg", "m/J" }));
        einsteinComboBox.setFocusable(false);
        einsteinComboBox.setName(""); // NOI18N
        einsteinComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                einsteinComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(einsteinComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 269, 69, -1));

        hubbleComboBox.setBackground(new java.awt.Color(35, 35, 35));
        hubbleComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        hubbleComboBox.setMaximumRowCount(2);
        hubbleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1/s", "km/(s Mpc)" }));
        hubbleComboBox.setFocusable(false);
        hubbleComboBox.setMinimumSize(new java.awt.Dimension(65, 25));
        hubbleComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        hubbleComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hubbleComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(hubbleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 319, 80, -1));

        permeabComboBox.setBackground(new java.awt.Color(35, 35, 35));
        permeabComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        permeabComboBox.setMaximumRowCount(1);
        permeabComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A²" }));
        permeabComboBox.setFocusable(false);
        permeabComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        consinnerPanel.add(permeabComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 369, 69, -1));

        permitComboBox.setBackground(new java.awt.Color(35, 35, 35));
        permitComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        permitComboBox.setMaximumRowCount(1);
        permitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F/m" }));
        permitComboBox.setFocusable(false);
        permitComboBox.setName(""); // NOI18N
        consinnerPanel.add(permitComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 419, 69, -1));

        vacimpedComboBox.setBackground(new java.awt.Color(35, 35, 35));
        vacimpedComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        vacimpedComboBox.setMaximumRowCount(1);
        vacimpedComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ω" }));
        vacimpedComboBox.setFocusable(false);
        vacimpedComboBox.setName(""); // NOI18N
        consinnerPanel.add(vacimpedComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 469, 69, -1));

        chargeComboBox.setBackground(new java.awt.Color(35, 35, 35));
        chargeComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        chargeComboBox.setMaximumRowCount(1);
        chargeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C" }));
        chargeComboBox.setFocusable(false);
        chargeComboBox.setName(""); // NOI18N
        consinnerPanel.add(chargeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 519, 69, -1));

        elmassComboBox.setBackground(new java.awt.Color(35, 35, 35));
        elmassComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        elmassComboBox.setMaximumRowCount(2);
        elmassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kg", "MeV/c²" }));
        elmassComboBox.setFocusable(false);
        elmassComboBox.setName(""); // NOI18N
        elmassComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                elmassComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(elmassComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 569, 69, -1));

        protmassComboBox.setBackground(new java.awt.Color(35, 35, 35));
        protmassComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        protmassComboBox.setMaximumRowCount(2);
        protmassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kg", "MeV/c²" }));
        protmassComboBox.setFocusable(false);
        protmassComboBox.setName(""); // NOI18N
        protmassComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                protmassComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(protmassComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 619, 69, -1));

        neutmassComboBox.setBackground(new java.awt.Color(35, 35, 35));
        neutmassComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        neutmassComboBox.setMaximumRowCount(2);
        neutmassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kg", "MeV/c²" }));
        neutmassComboBox.setFocusable(false);
        neutmassComboBox.setName(""); // NOI18N
        neutmassComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                neutmassComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(neutmassComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 669, 69, -1));

        amuComboBox.setBackground(new java.awt.Color(35, 35, 35));
        amuComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        amuComboBox.setMaximumRowCount(2);
        amuComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kg", "MeV/c²" }));
        amuComboBox.setFocusable(false);
        amuComboBox.setName(""); // NOI18N
        amuComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                amuComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(amuComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 719, 69, -1));

        bohrmagComboBox.setBackground(new java.awt.Color(35, 35, 35));
        bohrmagComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        bohrmagComboBox.setMaximumRowCount(2);
        bohrmagComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J/T", "eV/T" }));
        bohrmagComboBox.setFocusable(false);
        bohrmagComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        bohrmagComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bohrmagComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(bohrmagComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 19, 69, -1));

        nuclmagComboBox.setBackground(new java.awt.Color(35, 35, 35));
        nuclmagComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        nuclmagComboBox.setMaximumRowCount(2);
        nuclmagComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J/T", "eV/T" }));
        nuclmagComboBox.setFocusable(false);
        nuclmagComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        nuclmagComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nuclmagComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(nuclmagComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 69, 69, -1));

        finestrComboBox.setBackground(new java.awt.Color(35, 35, 35));
        finestrComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        finestrComboBox.setMaximumRowCount(0);
        finestrComboBox.setFocusable(false);
        finestrComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        consinnerPanel.add(finestrComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 119, 69, -1));

        rydbergComboBox.setBackground(new java.awt.Color(35, 35, 35));
        rydbergComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        rydbergComboBox.setMaximumRowCount(1);
        rydbergComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1/m" }));
        rydbergComboBox.setFocusable(false);
        rydbergComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        consinnerPanel.add(rydbergComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 169, 69, -1));

        bohrradComboBox.setBackground(new java.awt.Color(35, 35, 35));
        bohrradComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        bohrradComboBox.setMaximumRowCount(2);
        bohrradComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m", "nm" }));
        bohrradComboBox.setFocusable(false);
        bohrradComboBox.setName(""); // NOI18N
        bohrradComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bohrradComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(bohrradComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 219, 69, -1));

        avogadroComboBox.setBackground(new java.awt.Color(35, 35, 35));
        avogadroComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        avogadroComboBox.setMaximumRowCount(1);
        avogadroComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1/mol" }));
        avogadroComboBox.setFocusable(false);
        avogadroComboBox.setName(""); // NOI18N
        consinnerPanel.add(avogadroComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 269, 69, -1));

        gasComboBox.setBackground(new java.awt.Color(35, 35, 35));
        gasComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        gasComboBox.setMaximumRowCount(1);
        gasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J/(mol K)" }));
        gasComboBox.setFocusable(false);
        gasComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        consinnerPanel.add(gasComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 319, 69, -1));

        boltzmannComboBox.setBackground(new java.awt.Color(35, 35, 35));
        boltzmannComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        boltzmannComboBox.setMaximumRowCount(2);
        boltzmannComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J/K", "eV/K" }));
        boltzmannComboBox.setFocusable(false);
        boltzmannComboBox.setPreferredSize(new java.awt.Dimension(65, 25));
        boltzmannComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boltzmannComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(boltzmannComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 369, 69, -1));

        faradayComboBox.setBackground(new java.awt.Color(35, 35, 35));
        faradayComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        faradayComboBox.setMaximumRowCount(1);
        faradayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C/mol" }));
        faradayComboBox.setFocusable(false);
        faradayComboBox.setName(""); // NOI18N
        consinnerPanel.add(faradayComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 419, 69, -1));

        stefboltzComboBox.setBackground(new java.awt.Color(35, 35, 35));
        stefboltzComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        stefboltzComboBox.setMaximumRowCount(1);
        stefboltzComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<html><nobr>W/(m² K<sup><font size=2>4</font></sup>)</nobr></html>" }));
        stefboltzComboBox.setFocusable(false);
        stefboltzComboBox.setName(""); // NOI18N
        consinnerPanel.add(stefboltzComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 469, 69, 25));

        condqComboBox.setBackground(new java.awt.Color(35, 35, 35));
        condqComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        condqComboBox.setMaximumRowCount(1);
        condqComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S" }));
        condqComboBox.setFocusable(false);
        condqComboBox.setName(""); // NOI18N
        consinnerPanel.add(condqComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 519, 69, -1));

        fluxqComboBox.setBackground(new java.awt.Color(35, 35, 35));
        fluxqComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        fluxqComboBox.setMaximumRowCount(1);
        fluxqComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wb" }));
        fluxqComboBox.setFocusable(false);
        fluxqComboBox.setName(""); // NOI18N
        consinnerPanel.add(fluxqComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 569, 69, -1));

        josephComboBox.setBackground(new java.awt.Color(35, 35, 35));
        josephComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        josephComboBox.setMaximumRowCount(1);
        josephComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hz/V" }));
        josephComboBox.setFocusable(false);
        josephComboBox.setName(""); // NOI18N
        consinnerPanel.add(josephComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 619, 69, -1));

        wienComboBox.setBackground(new java.awt.Color(35, 35, 35));
        wienComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        wienComboBox.setMaximumRowCount(2);
        wienComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m K", "Hz/K" }));
        wienComboBox.setFocusable(false);
        wienComboBox.setName(""); // NOI18N
        wienComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                wienComboBoxItemStateChanged(evt);
            }
        });
        consinnerPanel.add(wienComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 669, 69, -1));

        gravaccComboBox.setBackground(new java.awt.Color(35, 35, 35));
        gravaccComboBox.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        gravaccComboBox.setMaximumRowCount(1);
        gravaccComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m/s²" }));
        gravaccComboBox.setFocusable(false);
        gravaccComboBox.setName(""); // NOI18N
        consinnerPanel.add(gravaccComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 719, 69, -1));

        phantomconsLabel.setText(" ");
        consinnerPanel.add(phantomconsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 750, -1, -1));

        lightspdLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        lightspdLabel.setForeground(new java.awt.Color(255, 255, 255));
        lightspdLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lightspdLabel.setText("<html><body style='text-align: right'><i>c </i>=</html>");
        consinnerPanel.add(lightspdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 22, 50, -1));

        newtonLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        newtonLabel.setForeground(new java.awt.Color(255, 255, 255));
        newtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newtonLabel.setText("<html><body style='text-align: right'><i>G </i>=</html>");
        consinnerPanel.add(newtonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 72, 50, -1));

        plankLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        plankLabel.setForeground(new java.awt.Color(255, 255, 255));
        plankLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        plankLabel.setText("<html><body style='text-align: right'><i>h </i>=</html>");
        consinnerPanel.add(plankLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 122, 50, -1));

        redplankLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        redplankLabel.setForeground(new java.awt.Color(255, 255, 255));
        redplankLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        redplankLabel.setText("<html><body style='text-align: right'><i>ħ </i>=</html>");
        redplankLabel.setToolTipText("<html>= <i>h</i>/2π</html>");
        consinnerPanel.add(redplankLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 172, 50, -1));

        cosmoLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        cosmoLabel.setForeground(new java.awt.Color(255, 255, 255));
        cosmoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cosmoLabel.setText("<html><body style='text-align: right'>Λ =</html>");
        consinnerPanel.add(cosmoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 222, 50, -1));

        einsteinLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        einsteinLabel.setForeground(new java.awt.Color(255, 255, 255));
        einsteinLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        einsteinLabel.setText("<html><body style='text-align: right'>κ =</html>");
        einsteinLabel.setToolTipText("<html>= 8π<i>G</i>/<i>c</i>² or 8π<i>G</i>/<i>c</i><sup><font size=2>4</font></sup></html>");
        consinnerPanel.add(einsteinLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 272, 50, -1));

        hubbleLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        hubbleLabel.setForeground(new java.awt.Color(255, 255, 255));
        hubbleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hubbleLabel.setText("<html><body style='text-align: right'>H<sub>0</sub> =</html>");
        consinnerPanel.add(hubbleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 322, 50, -1));

        permeabLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        permeabLabel.setForeground(new java.awt.Color(255, 255, 255));
        permeabLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        permeabLabel.setText("<html><body style='text-align: right'>μ<sub>0</sub> =</html>");
        permeabLabel.setToolTipText("<html>= 4π⋅10<sup><font size=2>-7</font></sup> N/A²</html>");
        consinnerPanel.add(permeabLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 372, 50, -1));

        premitLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        premitLabel.setForeground(new java.awt.Color(255, 255, 255));
        premitLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        premitLabel.setText("<html><body style='text-align: right'>ε<sub>0</sub> =</html>");
        premitLabel.setToolTipText("<html>= 1/μ<sub>0</sub><i>c</i>²</html>");
        consinnerPanel.add(premitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 422, 50, -1));

        vacimpedLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        vacimpedLabel.setForeground(new java.awt.Color(255, 255, 255));
        vacimpedLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vacimpedLabel.setText("<html><body style='text-align: right'><i>Z</i><sub>0</sub> =</html>");
        vacimpedLabel.setToolTipText("<html>= μ<sub>0</sub><i>c</i></html>");
        consinnerPanel.add(vacimpedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 472, 50, -1));

        chargeLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        chargeLabel.setForeground(new java.awt.Color(255, 255, 255));
        chargeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        chargeLabel.setText("<html><body style='text-align: right'><i>e </i>=</html>");
        consinnerPanel.add(chargeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 522, 50, -1));

        elmassLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        elmassLabel.setForeground(new java.awt.Color(255, 255, 255));
        elmassLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        elmassLabel.setText("<html><body style='text-align: right'><i>m</i><sub>e</sub> =</html>");
        consinnerPanel.add(elmassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 572, 50, -1));

        protmassLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        protmassLabel.setForeground(new java.awt.Color(255, 255, 255));
        protmassLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        protmassLabel.setText("<html><body style='text-align: right'><i>m</i><sub>p</sub> =</html>");
        consinnerPanel.add(protmassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 622, 50, -1));

        neutmassLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        neutmassLabel.setForeground(new java.awt.Color(255, 255, 255));
        neutmassLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        neutmassLabel.setText("<html><body style='text-align: right'><i>m</i><sub>n</sub> =</html>");
        consinnerPanel.add(neutmassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 672, 50, -1));

        amuLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        amuLabel.setForeground(new java.awt.Color(255, 255, 255));
        amuLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        amuLabel.setText("<html><body style='text-align: right'><i>m</i><sub>u</sub> =</html>");
        amuLabel.setToolTipText("<html>= <i>m</i>(¹²C)/12</html>");
        consinnerPanel.add(amuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 722, 50, -1));

        bohrmagLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        bohrmagLabel.setForeground(new java.awt.Color(255, 255, 255));
        bohrmagLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bohrmagLabel.setText("<html><body style='text-align: right'>μ<sub>B</sub> =</html>");
        bohrmagLabel.setToolTipText("<html>= <i>eħ</i>/2<i>m</i><sub>e</sub></html>");
        consinnerPanel.add(bohrmagLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 22, 50, -1));

        nuclmagLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        nuclmagLabel.setForeground(new java.awt.Color(255, 255, 255));
        nuclmagLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nuclmagLabel.setText("<html><body style='text-align: right'>μ<sub>N</sub> =</html>");
        nuclmagLabel.setToolTipText("<html>= <i>eħ</i>/2<i>m</i><sub>p</sub></html>");
        consinnerPanel.add(nuclmagLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 72, 50, -1));

        finestrLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        finestrLabel.setForeground(new java.awt.Color(255, 255, 255));
        finestrLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        finestrLabel.setText("<html><body style='text-align: right'>α =</html>");
        finestrLabel.setToolTipText("<html>= μ<sub>0</sub><i>e</i>²<i>c</i>/2<i>h</i> =  <i>e</i>²/4πε<sub>0</sub><i>ħc</i></html>");
        consinnerPanel.add(finestrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 122, 50, -1));

        rydbergLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        rydbergLabel.setForeground(new java.awt.Color(255, 255, 255));
        rydbergLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rydbergLabel.setText("<html><body style='text-align: right'><i>R</i><sub>∞</sub> =</html>");
        rydbergLabel.setToolTipText("<html>= α²<i>m</i><sub>e</sub><i>c</i>/2<i>h</i></html>");
        consinnerPanel.add(rydbergLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 172, 50, -1));

        bohrradLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        bohrradLabel.setForeground(new java.awt.Color(255, 255, 255));
        bohrradLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bohrradLabel.setText("<html><body style='text-align: right'><i>a</i><sub>0</sub> =</html>");
        bohrradLabel.setToolTipText("<html>= α/4π<i>R</i><sub>∞</sub></html>");
        consinnerPanel.add(bohrradLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 222, 50, -1));

        avogadroLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        avogadroLabel.setForeground(new java.awt.Color(255, 255, 255));
        avogadroLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        avogadroLabel.setText("<html><body style='text-align: right'><i>N</i><sub>A</sub> =</html>");
        consinnerPanel.add(avogadroLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 272, 50, -1));

        gasLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        gasLabel.setForeground(new java.awt.Color(255, 255, 255));
        gasLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gasLabel.setText("<html><body style='text-align: right'><i>R </i>=</html>");
        consinnerPanel.add(gasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 322, 50, -1));

        boltzmannLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        boltzmannLabel.setForeground(new java.awt.Color(255, 255, 255));
        boltzmannLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        boltzmannLabel.setText("<html><body style='text-align: right'><i>k</i><sub>B</sub> =</html>");
        boltzmannLabel.setToolTipText("<html>= <i>R</i>/<i>N</i><sub>A</sub></html>");
        consinnerPanel.add(boltzmannLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 372, 50, -1));

        faradayLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        faradayLabel.setForeground(new java.awt.Color(255, 255, 255));
        faradayLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        faradayLabel.setText("<html><body style='text-align: right'><i>F </i>=</html>");
        faradayLabel.setToolTipText("<html>= <i>N</i><sub>A</sub><i>e</i></html>");
        consinnerPanel.add(faradayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 422, 50, -1));

        stefboltzLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        stefboltzLabel.setForeground(new java.awt.Color(255, 255, 255));
        stefboltzLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stefboltzLabel.setText("<html><body style='text-align: right'>σ =</html>");
        stefboltzLabel.setToolTipText("<html>= π²k<sub>B</sub><sup><font size=2>4</font></sup>/60<i>ħ</i>³<i>c</i>²</html>");
        consinnerPanel.add(stefboltzLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 472, 50, -1));

        condqLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        condqLabel.setForeground(new java.awt.Color(255, 255, 255));
        condqLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        condqLabel.setText("<html><body style='text-align: right'><i>G</i><sub>0</sub> =</html>");
        condqLabel.setToolTipText("<html>= 2<i>e</i>²/<i>h</i></html>");
        consinnerPanel.add(condqLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 522, 50, -1));

        fluxqLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        fluxqLabel.setForeground(new java.awt.Color(255, 255, 255));
        fluxqLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fluxqLabel.setText("<html><body style='text-align: right'>Φ<sub>0</sub> =</html>");
        fluxqLabel.setToolTipText("<html>= <i>h</i>/2<i>e</i></html>");
        consinnerPanel.add(fluxqLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 572, 50, -1));

        josephLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        josephLabel.setForeground(new java.awt.Color(255, 255, 255));
        josephLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        josephLabel.setText("<html><body style='text-align: right'><i>K</i><sub>J</sub> =</html>");
        josephLabel.setToolTipText("<html>= 2<i>e</i>/<i>h</i></html");
        consinnerPanel.add(josephLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 622, 50, -1));

        wienLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        wienLabel.setForeground(new java.awt.Color(255, 255, 255));
        wienLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wienLabel.setText("<html><body style='text-align: right'><i>b </i>=</html>");
        consinnerPanel.add(wienLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 672, 50, -1));

        gravaccLabel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        gravaccLabel.setForeground(new java.awt.Color(255, 255, 255));
        gravaccLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gravaccLabel.setText("<html><body style='text-align: right'><i>g </i>=</html>");
        consinnerPanel.add(gravaccLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 722, 50, -1));

        consScrollPane.setViewportView(consinnerPanel);

        consPanel.add(consScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 620, 300));

        consTipsPanel.setBackground(new java.awt.Color(35, 35, 35));
        consTipsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tips", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Slab", 1, 14), new java.awt.Color(255, 215, 0))); // NOI18N
        consTipsPanel.setForeground(new java.awt.Color(255, 255, 255));
        consTipsPanel.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        consTipsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        consPanel.add(consTipsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 125));

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/AppPackage/voidS.png")), consPanel, "Constants"); // NOI18N

        phantomPanel.setBackground(new java.awt.Color(35, 35, 35));
        phantomPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bugLabel1.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        bugLabel1.setForeground(new java.awt.Color(255, 255, 255));
        bugLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bugLabel1.setText("This text was not supposed to appear.");
        phantomPanel.add(bugLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 570, 30));

        bugLabel2.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        bugLabel2.setForeground(new java.awt.Color(255, 255, 255));
        bugLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bugLabel2.setText("If you read this, it means there is a bug with the mouse wheel scrolling.");
        phantomPanel.add(bugLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 570, 30));

        bugLabel3.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        bugLabel3.setForeground(new java.awt.Color(255, 255, 255));
        bugLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bugLabel3.setText("Please select another tab manually. Sorry for that...");
        phantomPanel.add(bugLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 570, 30));

        tabbedPane.addTab("tab12", phantomPanel);

        getContentPane().add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 710, 460));

        bkgPanel.setBackground(new java.awt.Color(35, 35, 35));
        bkgPanel.setPreferredSize(new java.awt.Dimension(730, 490));
        getContentPane().add(bkgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    // <editor-fold defaultstate="collapsed" desc="Pre-init custom appearence of components">
    private void compAppearence(){
        
        UIManager.put("TabbedPane.shadow", myGold);     // temp colors shown
        UIManager.put("TabbedPane.highlight", myGold);  // only when the form
        UIManager.put("TabbedPane.darkShadow", myGold); // is launched
        //UIManager.put("TabbedPaneUI", "AppPackage.MyTabbedPaneUI"); // not perfect cause of scroll buttons
        UIManager.put("TabbedPane.selectedTabPadInsets", new Insets(2,2,2,1) ); // left,top,right,bottom extra pixels for selected tab
        
        UIManager.put("ToolTip.background", myDarkGrey);
        UIManager.put("ToolTip.foreground", myGold);
        Border goldBorder = BorderFactory.createLineBorder(myGold);
        UIManager.put("ToolTip.border", goldBorder);
        
        UIManager.put("TitledBorder.border", goldBorder); // for title-bordered panels
        
        UIManager.put("TextField.selectionBackground", myLightGrey);
        Border lightGreyBorder = BorderFactory.createLineBorder(myLightGrey);
        UIManager.put("TextField.border", lightGreyBorder);
        
        UIManager.put("ComboBox.background", myDarkGrey);
        UIManager.put("ComboBox.buttonBackground", myDarkGrey);
        UIManager.put("ComboBox.foreground", Color.WHITE);
        Border darkGreyBorder = BorderFactory.createLineBorder(myDarkGrey);
        UIManager.put("ComboBox.border", darkGreyBorder);
        UIManager.put("ComboBox.selectionBackground", myLightGrey);
        UIManager.put("ComboBoxUI", "AppPackage.MyComboBoxUI");
        
        
    }
    //</editor-fold>
    
    static boolean checkFont(){
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts =g.getAvailableFontFamilyNames();
        
        boolean fontFound = false;
        
        for (int i = 0; i < fonts.length; i++) {
            //System.out.println(fonts[i]);
            if(fonts[i].equals("Roboto Slab")){
                System.out.println("Font Roboto Slab found.");
                fontFound = true;
                // i = fonts.length-1; //to stop the for loop?
            }     
        }
        //System.out.println(fontFound);
        return fontFound;
    }
    
    private void orgTextFields(){
        // Energy
        enerTFarray[0] = jouleTextField; jouleTextField.setEditable(true);
        enerTFarray[1] = calTextField;
        enerTFarray[2] = ergTextField;
        enerTFarray[3] = hertzTextField;
        enerTFarray[4] = eVTextField;
        enerTFarray[5] = nmTextField;
        enerTFarray[6] = kelvTextField;
        enerTFarray[7] = kgTextField;
        enerTFarray[8] = cm1TextField;
        enerTFarray[9] = watthTextField;
        
        // Pressure
        presTFarray[0] = pascTextField;
        presTFarray[1] = torrTextField;
        presTFarray[2] = barTextField;
        presTFarray[3] = atmTextField;
        presTFarray[4] = psiTextField;
        presTFarray[5] = baryeTextField;
        
        // Length
        lengTFarray[0] = meterTextField;
        lengTFarray[1] = inchTextField;
        lengTFarray[2] = footTextField;
        lengTFarray[3] = mileTextField;
        lengTFarray[4] = nmileTextField;
        lengTFarray[5] = yardTextField;
        lengTFarray[6] = lyearTextField;
        lengTFarray[7] = aunitTextField;
        lengTFarray[8] = parsecTextField;
        
        // Area
        areaTFarray[0] = sqmeterTextField;
        areaTFarray[1] = sqinchTextField;
        areaTFarray[2] = sqfootTextField;
        areaTFarray[3] = sqmileTextField;
        areaTFarray[4] = hectareTextField;
        areaTFarray[5] = sqyardTextField;
        //areaTFarray[6] = acreTextField;
        areaTFarray[6] = barnTextField;
        
        // Volume
        voluTFarray[0] = cubmeterTextField;
        voluTFarray[1] = cubinchTextField;
        voluTFarray[2] = cubfootTextField;
        voluTFarray[3] = cubmileTextField;
        voluTFarray[4] = literTextField;
        voluTFarray[5] = galTextField;
        voluTFarray[6] = pintTextField;
        voluTFarray[7] = cupTextField;
        voluTFarray[8] = tbspTextField;
        voluTFarray[9] = teaspTextField;
        
        // Time
        timeTFarray[0] = secTextField;
        timeTFarray[1] = minTextField;
        timeTFarray[2] = hourTextField;
        timeTFarray[3] = dayTextField;
        timeTFarray[4] = weekTextField;
        timeTFarray[5] = monthTextField;
        timeTFarray[6] = yearTextField;
        
        // Speed
        spdTFarray[0] = msTextField;
        spdTFarray[1] = kmhTextField;
        spdTFarray[2] = mphTextField;
        spdTFarray[3] = knotTextField;
        spdTFarray[4] = ftsTextField;
        spdTFarray[5] = machTextField;
        
        // Flow
        flowTFarray[0] = cubmsTextField;
        flowTFarray[1] = cubmhTextField;
        flowTFarray[2] = litsTextField;
        flowTFarray[3] = litmTextField;
        flowTFarray[4] = cubftsTextField;
        flowTFarray[5] = sccmTextField;
        flowTFarray[6] = galminTextField;
        
        // Temperature
        tempTFarray[0] = kelvinTextField;
        tempTFarray[1] = celsTextField;
        tempTFarray[2] = fahrTextField;
        
        // Angle
        angTFarray[0] = radTextField;
        angTFarray[1] = degTextField;
        angTFarray[2] = gradTextField;
        
        // Constants
        
        
    }
    private void orgRadioButtons(){
        // Energy
        enerRBarray[0] = jouleRadioButton;
        enerRBarray[1] = calRadioButton;
        enerRBarray[2] = ergRadioButton;
        enerRBarray[3] = hertzRadioButton;
        enerRBarray[4] = eVRadioButton;
        enerRBarray[5] = nmRadioButton;
        enerRBarray[6] = kelvRadioButton;
        enerRBarray[7] = kgRadioButton;
        enerRBarray[8] = cm1RadioButton;
        enerRBarray[9] = watthRadioButton;
        
        for(int j=0; j<10; j++){
            enerButtonGroup.add(enerRBarray[j]);
        }
        
        // Set as not-editable every JTextField but the one next to the JRadioButton selected
        for(int i=0; i<enerRBarray.length; i++){
            enerRBarray[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    JRadioButton tempRB = (JRadioButton)actionEvent.getSource();
                    int k = Integer.parseInt(tempRB.getActionCommand());
                     for(int j=0; j<enerTFarray.length; j++) enerTFarray[j].setEditable(false);
                    enerTFarray[k].setEditable(true);
                }
            });
        }
        
        // Pressure
        presRBarray[0] = pascRadioButton;
        presRBarray[1] = torrRadioButton;
        presRBarray[2] = barRadioButton;
        presRBarray[3] = atmRadioButton;
        presRBarray[4] = psiRadioButton;
        presRBarray[5] = baryeRadioButton;
        
        for(int j=0; j<6; j++){
            presButtonGroup.add(presRBarray[j]);
        }
        
        for(int i=0; i<presRBarray.length; i++){
            presRBarray[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    JRadioButton tempRB = (JRadioButton)actionEvent.getSource();
                    int k = Integer.parseInt(tempRB.getActionCommand());
                     for(int j=0; j<presTFarray.length; j++) presTFarray[j].setEditable(false);
                    presTFarray[k].setEditable(true);
                }
            });
        }
        
        // Length
        lengRBarray[0] = meterRadioButton;
        lengRBarray[1] = inchRadioButton;
        lengRBarray[2] = footRadioButton;
        lengRBarray[3] = mileRadioButton;
        lengRBarray[4] = nmileRadioButton;
        lengRBarray[5] = yardRadioButton;
        lengRBarray[6] = lyearRadioButton;
        lengRBarray[7] = aunitRadioButton;
        lengRBarray[8] = parsecRadioButton;
        
        for(int j=0; j<9; j++){
            lengButtonGroup.add(lengRBarray[j]);
        }
        
        for(int i=0; i<lengRBarray.length; i++){
            lengRBarray[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    JRadioButton tempRB = (JRadioButton)actionEvent.getSource();
                    int k = Integer.parseInt(tempRB.getActionCommand());
                     for(int j=0; j<lengTFarray.length; j++) lengTFarray[j].setEditable(false);
                    lengTFarray[k].setEditable(true);
                }
            });
        }
        
        // Area
        areaRBarray[0] = sqmeterRadioButton;
        areaRBarray[1] = sqinchRadioButton;
        areaRBarray[2] = sqfootRadioButton;
        areaRBarray[3] = sqmileRadioButton;
        areaRBarray[4] = hectareRadioButton;
        areaRBarray[5] = sqyardRadioButton;
        //areaRBarray[6] = acreRadioButton;
        areaRBarray[6] = barnRadioButton;
        
        for(int j=0; j<7; j++){
            areaButtonGroup.add(areaRBarray[j]);
        }
        
        for(int i=0; i<areaRBarray.length; i++){
            areaRBarray[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    JRadioButton tempRB = (JRadioButton)actionEvent.getSource();
                    int k = Integer.parseInt(tempRB.getActionCommand());
                     for(int j=0; j<areaTFarray.length; j++) areaTFarray[j].setEditable(false);
                    areaTFarray[k].setEditable(true);
                }
            });
        }
        
        // Volume
        voluRBarray[0] = cubmeterRadioButton;
        voluRBarray[1] = cubinchRadioButton;
        voluRBarray[2] = cubfootRadioButton;
        voluRBarray[3] = cubmileRadioButton;
        voluRBarray[4] = literRadioButton;
        voluRBarray[5] = galRadioButton;
        voluRBarray[6] = pintRadioButton;
        voluRBarray[7] = cupRadioButton;
        voluRBarray[8] = tbspRadioButton;
        voluRBarray[9] = teaspRadioButton;
        
        for(int j=0; j<10; j++){
            voluButtonGroup.add(voluRBarray[j]);
        }
        
        // Set as not-editable every JTextField but the one next to the JRadioButton selected
        for(int i=0; i<voluRBarray.length; i++){
            voluRBarray[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    JRadioButton tempRB = (JRadioButton)actionEvent.getSource();
                    int k = Integer.parseInt(tempRB.getActionCommand());
                     for(int j=0; j<voluTFarray.length; j++) voluTFarray[j].setEditable(false);
                    voluTFarray[k].setEditable(true);
                }
            });
        }
        
        // Time
        timeRBarray[0] = secRadioButton;
        timeRBarray[1] = minRadioButton;
        timeRBarray[2] = hourRadioButton;
        timeRBarray[3] = dayRadioButton;
        timeRBarray[4] = weekRadioButton;
        timeRBarray[5] = monthRadioButton;
        timeRBarray[6] = yearRadioButton;
        
        for(int j=0; j<7; j++){
            timeButtonGroup.add(timeRBarray[j]);
        }
        
        for(int i=0; i<timeRBarray.length; i++){
            timeRBarray[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    JRadioButton tempRB = (JRadioButton)actionEvent.getSource();
                    int k = Integer.parseInt(tempRB.getActionCommand());
                     for(int j=0; j<timeTFarray.length; j++) timeTFarray[j].setEditable(false);
                    timeTFarray[k].setEditable(true);
                }
            });
        }
        
        // Speed
        spdRBarray[0] = msRadioButton;
        spdRBarray[1] = kmhRadioButton;
        spdRBarray[2] = mphRadioButton;
        spdRBarray[3] = knotRadioButton;
        spdRBarray[4] = ftsRadioButton;
        spdRBarray[5] = machRadioButton;
        
        for(int j=0; j<6; j++){
            spdButtonGroup.add(spdRBarray[j]);
        }
        
        for(int i=0; i<spdRBarray.length; i++){
            spdRBarray[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    JRadioButton tempRB = (JRadioButton)actionEvent.getSource();
                    int k = Integer.parseInt(tempRB.getActionCommand());
                     for(int j=0; j<spdTFarray.length; j++) spdTFarray[j].setEditable(false);
                    spdTFarray[k].setEditable(true);
                }
            });
        }
        
        // Flow
        flowRBarray[0] = cubmsRadioButton;
        flowRBarray[1] = cubmhRadioButton;
        flowRBarray[2] = litsRadioButton;
        flowRBarray[3] = litmRadioButton;
        flowRBarray[4] = cubftsRadioButton;
        flowRBarray[5] = sccmRadioButton;
        flowRBarray[6] = galminRadioButton;
        
        for(int j=0; j<7; j++){
            flowButtonGroup.add(flowRBarray[j]);
        }
        
        for(int i=0; i<flowRBarray.length; i++){
            flowRBarray[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    JRadioButton tempRB = (JRadioButton)actionEvent.getSource();
                    int k = Integer.parseInt(tempRB.getActionCommand());
                     for(int j=0; j<flowTFarray.length; j++) flowTFarray[j].setEditable(false);
                    flowTFarray[k].setEditable(true);
                }
            });
        }
        
        // Temperature
        tempRBarray[0] = kelvinRadioButton;
        tempRBarray[1] = celsRadioButton;
        tempRBarray[2] = fahrRadioButton;
        
        for(int j=0; j<3; j++){
            tempButtonGroup.add(tempRBarray[j]);
        }
        
        for(int i=0; i<tempRBarray.length; i++){
            tempRBarray[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    JRadioButton tempRB = (JRadioButton)actionEvent.getSource();
                    int k = Integer.parseInt(tempRB.getActionCommand());
                     for(int j=0; j<tempTFarray.length; j++) tempTFarray[j].setEditable(false);
                    tempTFarray[k].setEditable(true);
                }
            });
        }
        
        // Angle
        angRBarray[0] = radRadioButton;
        angRBarray[1] = degRadioButton;
        angRBarray[2] = gradRadioButton;
        
        for(int j=0; j<3; j++){
            angButtonGroup.add(angRBarray[j]);
        }
        
        for(int i=0; i<angRBarray.length; i++){
            angRBarray[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    JRadioButton tempRB = (JRadioButton)actionEvent.getSource();
                    int k = Integer.parseInt(tempRB.getActionCommand());
                     for(int j=0; j<angTFarray.length; j++) angTFarray[j].setEditable(false);
                    angTFarray[k].setEditable(true);
                }
            });
        }
        
    }
    private void orgComboBoxes(){
        
        // Energy
        enerCBarray[0] = jouleComboBox;
        enerCBarray[1] = calComboBox;
        enerCBarray[2] = ergComboBox;
        enerCBarray[3] = hertzComboBox;
        enerCBarray[4] = eVComboBox;
        enerCBarray[5] = nmComboBox;
        enerCBarray[6] = kelvComboBox;
        enerCBarray[7] = kgComboBox;
        enerCBarray[8] = cm1ComboBox;
        enerCBarray[9] = watthComboBox;
        
        // Pressure
        presCBarray[0] = pascComboBox;
        presCBarray[1] = torrComboBox;
        presCBarray[2] = barComboBox;
        presCBarray[3] = atmComboBox;
        presCBarray[4] = psiComboBox;
        presCBarray[5] = baryeComboBox;
        
        // Length
        lengCBarray[0] = meterComboBox;
        lengCBarray[1] = inchComboBox;
        lengCBarray[2] = footComboBox;
        lengCBarray[3] = mileComboBox;
        lengCBarray[4] = nmileComboBox;
        lengCBarray[5] = yardComboBox;
        lengCBarray[6] = lyearComboBox;
        lengCBarray[7] = aunitComboBox;
        lengCBarray[8] = parsecComboBox;
        
        // Area
        areaCBarray[0] = sqmeterComboBox;
        areaCBarray[1] = sqinchComboBox;
        areaCBarray[2] = sqfootComboBox;
        areaCBarray[3] = sqmileComboBox;
        areaCBarray[4] = hectareComboBox;
        areaCBarray[5] = sqyardComboBox;
        areaCBarray[6] = barnComboBox;
        
        // Volume
        voluCBarray[0] = cubmeterComboBox;
        voluCBarray[1] = cubinchComboBox;
        voluCBarray[2] = cubfootComboBox;
        voluCBarray[3] = cubmileComboBox;
        voluCBarray[4] = literComboBox;
        voluCBarray[5] = galComboBox;
        voluCBarray[6] = pintComboBox;
        voluCBarray[7] = cupComboBox;
        voluCBarray[8] = tbspComboBox;
        voluCBarray[9] = teaspComboBox;
        
        // Time
        timeCBarray[0] = secComboBox;
        timeCBarray[1] = minComboBox;
        timeCBarray[2] = hourComboBox;
        timeCBarray[3] = dayComboBox;
        timeCBarray[4] = weekComboBox;
        timeCBarray[5] = monthComboBox;
        timeCBarray[6] = yearComboBox;
        
        // Speed
        spdCBarray[0] = msComboBox;
        spdCBarray[1] = kmhComboBox;
        spdCBarray[2] = mphComboBox;
        spdCBarray[3] = knotComboBox;
        spdCBarray[4] = ftsComboBox;
        spdCBarray[5] = machComboBox;
        
        // Flow
        flowCBarray[0] = cubmsComboBox;
        flowCBarray[1] = cubmhComboBox;
        flowCBarray[2] = litsComboBox;
        flowCBarray[3] = litmComboBox;
        flowCBarray[4] = cubftsComboBox;
        flowCBarray[5] = sccmComboBox;
        flowCBarray[6] = galminComboBox;
        
        // Temperature
        tempCBarray[0] = kelvinComboBox;
        tempCBarray[1] = celsComboBox;
        tempCBarray[2] = fahrComboBox;
        
        // Angle
        angCBarray[0] = radComboBox;
        angCBarray[1] = degComboBox;
        angCBarray[2] = gradComboBox;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Clicks on close/minimise buttons">
    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeLabelMouseClicked

    private void minimiseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseLabelMouseClicked
        this.setState(bcGUI.ICONIFIED);
    }//GEN-LAST:event_minimiseLabelMouseClicked
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Drag Frame">
    private void titleLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLabelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_titleLabelMouseDragged
        
    private void titleLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLabelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_titleLabelMousePressed
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Appearence of close/minimise buttons">
    private void closeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseEntered
        closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/closeIcon2.png")));
    }//GEN-LAST:event_closeLabelMouseEntered
    private void minimiseLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseLabelMouseEntered
        minimiseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/minimiseIcon2.png")));
    }//GEN-LAST:event_minimiseLabelMouseEntered
    private void closeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseExited
        closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/closeIcon.png")));
    }//GEN-LAST:event_closeLabelMouseExited
    private void minimiseLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseLabelMouseExited
        minimiseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/minimiseIcon.png")));
    }//GEN-LAST:event_minimiseLabelMouseExited
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Mouse events on scroll buttons">
    private void scrollUpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollUpLabelMouseClicked
        int current = tabbedPane.getSelectedIndex();
          if(current>0){ tabbedPane.setSelectedIndex(current-1);
          }
          else{ }
    }//GEN-LAST:event_scrollUpLabelMouseClicked

    private void scrollDownLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollDownLabelMouseClicked
        int current = tabbedPane.getSelectedIndex();
          if (current < 10){ tabbedPane.setSelectedIndex(current+1);
          }
          else if(current==10){ // needed to avoid overlapping with scroll button
           tabbedPane.setSelectedIndex(current+1); // select the phantom tab
           tabbedPane.setSelectedIndex(10);        // and go back to the last tab
          } else{ }
          
    }//GEN-LAST:event_scrollDownLabelMouseClicked

    private void scrollUpLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollUpLabelMouseEntered
        scrollUpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/scrollUp_over.png")));
    }//GEN-LAST:event_scrollUpLabelMouseEntered

    private void scrollUpLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollUpLabelMouseExited
        scrollUpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/scrollUp.png")));
    }//GEN-LAST:event_scrollUpLabelMouseExited

    private void scrollDownLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollDownLabelMouseEntered
        scrollDownLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/scrollDown_over.png")));
    }//GEN-LAST:event_scrollDownLabelMouseEntered

    private void scrollDownLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollDownLabelMouseExited
        scrollDownLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/scrollDown.png")));
    }//GEN-LAST:event_scrollDownLabelMouseExited
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Mouse events on convert button">
    private void convertLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_convertLabelMouseEntered
        convertLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/convertIcon2.png")));
    }//GEN-LAST:event_convertLabelMouseEntered

    private void convertLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_convertLabelMouseExited
        convertLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/convertIcon.png")));
    }//GEN-LAST:event_convertLabelMouseExited

    private void convertLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_convertLabelMouseClicked
        
        /*
        try{
            double temp = Double.parseDouble(jouleTextField.getText());
            System.out.println(temp);
            double temp2 = temp/2;
            System.out.println(temp2);
            //jouleTextField.setText((String)formatter.format(temp2).toLowerCase());
        }
        catch (Exception e){
            System.out.println("An error occurred when the convert button was pressed:");
            System.out.println(e);
        }
        */
        
        
        
        
        int selectedTab = tabbedPane.getSelectedIndex();
            if (selectedTab>9){
                System.out.println("No valid tab is selected.");
                return;
            }
        int selectedRButton = checkRBSelection(selectedTab);
            System.out.println(selectedRButton);
       
        int selectedCBindex = checkCBSelection(selectedTab,selectedRButton);
            System.out.println("index: "+selectedCBindex);
            
        cbArray[selectedTab][selectedRButton].setSelectedIndex(0);
            
        double selValue = Double.parseDouble(tfArray[selectedTab][selectedRButton].getText());
            System.out.println("value: "+selValue);
        
        Converter buddy = new Converter();
        double convertedValues[] = buddy.convert(selectedTab, selectedRButton, selectedCBindex, selValue);
        for(int k=0; k<convertedValues.length; k++){
            System.out.println(convertedValues[k]);
        }
        
        cbArray[selectedTab][selectedRButton].setSelectedIndex(selectedCBindex);
        
        // write here the code to set the textFields to the new values
     
        
    }//GEN-LAST:event_convertLabelMouseClicked

    private void convertLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_convertLabelMousePressed
        
        convertLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/convertIcon.png")));        
        
    }//GEN-LAST:event_convertLabelMousePressed

    private void convertLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_convertLabelMouseReleased
        
        convertLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/convertIcon2.png")));
        
    }//GEN-LAST:event_convertLabelMouseReleased
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="ItemListeners on ComboBoxes">
    // <editor-fold defaultstate="collapsed" desc="Constants Panel">
    private void lightspdComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lightspdComboBoxItemStateChanged
        
        int i = lightspdComboBox.getSelectedIndex();
        if (i == 1) lightspdTextField.setText("2.99792458e5");
        else lightspdTextField.setText("2.99792458e8");
        
    }//GEN-LAST:event_lightspdComboBoxItemStateChanged

    private void plankComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_plankComboBoxItemStateChanged
        
        int i = plankComboBox.getSelectedIndex();
        if (i == 1) plankTextField.setText("4.135667662e-15");
        else plankTextField.setText("6.626070040e-34");
        
    }//GEN-LAST:event_plankComboBoxItemStateChanged

    private void redplankComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_redplankComboBoxItemStateChanged
        
        int i = redplankComboBox.getSelectedIndex();
        if (i == 1) redplankTextField.setText("6.582119514e-16");
        else redplankTextField.setText("1.054571800e-34");
        
    }//GEN-LAST:event_redplankComboBoxItemStateChanged

    private void einsteinComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_einsteinComboBoxItemStateChanged
        
        int i = einsteinComboBox.getSelectedIndex();
        if (i == 1) einsteinTextField.setText("2.076579e-43");
        else einsteinTextField.setText("1.866e-26");
        
    }//GEN-LAST:event_einsteinComboBoxItemStateChanged

    private void hubbleComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hubbleComboBoxItemStateChanged
        
        int i = hubbleComboBox.getSelectedIndex();
        if (i == 1) hubbleTextField.setText("71.9");
        else hubbleTextField.setText("2.326860841e-18");
        
    }//GEN-LAST:event_hubbleComboBoxItemStateChanged

    private void elmassComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_elmassComboBoxItemStateChanged
        
        int i = elmassComboBox.getSelectedIndex();
        if (i == 1) elmassTextField.setText("0.510998946");
        else elmassTextField.setText("9.10938356e-31");
        
    }//GEN-LAST:event_elmassComboBoxItemStateChanged

    private void protmassComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_protmassComboBoxItemStateChanged
        
        int i = protmassComboBox.getSelectedIndex();
        if (i == 1) protmassTextField.setText("9.382720813e2");
        else protmassTextField.setText("1.672621898e-27");
        
    }//GEN-LAST:event_protmassComboBoxItemStateChanged

    private void neutmassComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_neutmassComboBoxItemStateChanged
        
        int i = neutmassComboBox.getSelectedIndex();
        if (i == 1) neutmassTextField.setText("9.395654133e2");
        else neutmassTextField.setText("1.674927471e-27");
        
    }//GEN-LAST:event_neutmassComboBoxItemStateChanged

    private void amuComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_amuComboBoxItemStateChanged
        
        int i = amuComboBox.getSelectedIndex();
        if (i == 1) amuTextField.setText("9.314940954e2");
        else amuTextField.setText("1.660539040e-27");
        
    }//GEN-LAST:event_amuComboBoxItemStateChanged

    private void bohrmagComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bohrmagComboBoxItemStateChanged
        
        int i = bohrmagComboBox.getSelectedIndex();
        if (i == 1) bohrmagTextField.setText("5.788381801e-5");
        else bohrmagTextField.setText("9.274009994e-24");
        
    }//GEN-LAST:event_bohrmagComboBoxItemStateChanged

    private void nuclmagComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nuclmagComboBoxItemStateChanged
        
        int i = nuclmagComboBox.getSelectedIndex();
        if (i == 1) nuclmagTextField.setText("3.152451255e-8");
        else nuclmagTextField.setText("5.050783699e-27");
        
    }//GEN-LAST:event_nuclmagComboBoxItemStateChanged

    private void bohrradComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bohrradComboBoxItemStateChanged
        
        int i = bohrradComboBox.getSelectedIndex();
        if (i == 1) bohrradTextField.setText("5.291772107e-2");
        else bohrradTextField.setText("5.291772107e-11");
        
    }//GEN-LAST:event_bohrradComboBoxItemStateChanged

    private void boltzmannComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boltzmannComboBoxItemStateChanged
        
        int i = boltzmannComboBox.getSelectedIndex();
        if (i == 1) boltzmannTextField.setText("8.617330637e-5");
        else boltzmannTextField.setText("1.38064852e-23");
        
    }//GEN-LAST:event_boltzmannComboBoxItemStateChanged

    private void wienComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_wienComboBoxItemStateChanged
        
        int i = wienComboBox.getSelectedIndex();
        if (i == 1) wienTextField.setText("5.8789238e10");
        else wienTextField.setText("2.8977729e-3");
        
    }//GEN-LAST:event_wienComboBoxItemStateChanged
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Energy Panel">
    private void jouleComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jouleComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(jouleTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "J": deselectedOOM = 1; break;
                case "mJ": deselectedOOM = 1e-3; break;
                case "kJ": deselectedOOM = 1e3; break;
                case "MJ": deselectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "J": selectedOOM = 1; break;
                case "mJ": selectedOOM = 1e-3; break;
                case "kJ": selectedOOM = 1e3; break;
                case "MJ": selectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            jouleTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
      
    }//GEN-LAST:event_jouleComboBoxItemStateChanged

    private void calComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_calComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(calTextField.getText());            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "cal": deselectedOOM = 1; break;                
                case "kcal": deselectedOOM = 1e3; break;                
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "cal": selectedOOM = 1; break;                
                case "kcal": selectedOOM = 1e3; break;                
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            calTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_calComboBoxItemStateChanged

    private void ergComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ergComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(ergTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "erg": deselectedOOM = 1; break;                
                case "kerg": deselectedOOM = 1e3; break;
                case "Merg": deselectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "erg": selectedOOM = 1; break;                
                case "kerg": selectedOOM = 1e3; break;
                case "Merg": selectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            ergTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_ergComboBoxItemStateChanged

    private void hertzComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hertzComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(hertzTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "Hz": deselectedOOM = 1; break;                
                case "kHz": deselectedOOM = 1e3; break;
                case "MHz": deselectedOOM = 1e6; break;
                case "GHz": deselectedOOM = 1e9; break;
                case "THz": deselectedOOM = 1e12; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "Hz": selectedOOM = 1; break;                
                case "kHz": selectedOOM = 1e3; break;
                case "MHz": selectedOOM = 1e6; break;
                case "GHz": selectedOOM = 1e9; break;
                case "THz": selectedOOM = 1e12; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            hertzTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_hertzComboBoxItemStateChanged

    private void eVComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_eVComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(eVTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "eV": deselectedOOM = 1; break;
                case "meV": deselectedOOM = 1e-3; break;
                case "keV": deselectedOOM = 1e3; break;
                case "MeV": deselectedOOM = 1e6; break;
                case "GeV": deselectedOOM = 1e9; break;
                case "TeV": deselectedOOM = 1e12; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "eV": selectedOOM = 1; break;
                case "meV": selectedOOM = 1e-3; break;
                case "keV": selectedOOM = 1e3; break;
                case "MeV": selectedOOM = 1e6; break;
                case "GeV": selectedOOM = 1e9; break;
                case "TeV": selectedOOM = 1e12; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            eVTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_eVComboBoxItemStateChanged

    private void nmComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nmComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(nmTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "nm": deselectedOOM = 1; break;                
                case "um": deselectedOOM = 1e3; break;
                case "mm": deselectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "nm": selectedOOM = 1; break;                
                case "um": selectedOOM = 1e3; break;
                case "mm": selectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            nmTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_nmComboBoxItemStateChanged

    private void kelvComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kelvComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_kelvComboBoxItemStateChanged

    private void kgComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kgComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(kgTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "kg": deselectedOOM = 1; break;                
                case "g": deselectedOOM = 1e-3; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "kg": selectedOOM = 1; break;                
                case "g": selectedOOM = 1e-3; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            kgTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_kgComboBoxItemStateChanged

    private void cm1ComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cm1ComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cm1ComboBoxItemStateChanged

    private void watthComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_watthComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(watthTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "Wh": deselectedOOM = 1; break;                
                case "kWh": deselectedOOM = 1e3; break;
                case "MWh": deselectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "Wh": selectedOOM = 1; break;                
                case "kWh": selectedOOM = 1e3; break;
                case "MWh": selectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            watthTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_watthComboBoxItemStateChanged

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Pressure Panel">
    private void pascComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pascComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(pascTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "Pa": deselectedOOM = 1; break;
                case "mPa": deselectedOOM = 1e-3; break;
                case "hPa": deselectedOOM = 1e2; break;
                case "kPa": deselectedOOM = 1e3; break;
                case "MPa": deselectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "Pa": selectedOOM = 1; break;
                case "mPa": selectedOOM = 1e-3; break;
                case "hPa": selectedOOM = 1e2; break;
                case "kPa": selectedOOM = 1e3; break;
                case "MPa": selectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            pascTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
        
    }//GEN-LAST:event_pascComboBoxItemStateChanged

    private void torrComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_torrComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(torrTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "Torr": deselectedOOM = 1; break;
                case "mTorr": deselectedOOM = 1e-3; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "Torr": selectedOOM = 1; break;
                case "mTorr": selectedOOM = 1e-3; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            torrTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_torrComboBoxItemStateChanged

    private void barComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_barComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(barTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "bar": deselectedOOM = 1; break;
                case "mbar": deselectedOOM = 1e-3; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "bar": selectedOOM = 1; break;
                case "mbar": selectedOOM = 1e-3; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            barTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_barComboBoxItemStateChanged

    private void atmComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_atmComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_atmComboBoxItemStateChanged

    private void psiComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_psiComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_psiComboBoxItemStateChanged

    private void baryeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_baryeComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_baryeComboBoxItemStateChanged
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Length Panel">
    private void meterComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_meterComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(meterTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "m": deselectedOOM = 1; break;
                case "cm": deselectedOOM = 1e-2; break;
                case "mm": deselectedOOM = 1e-3; break;
                case "µm": deselectedOOM = 1e-6; break;
                case "nm": deselectedOOM = 1e-9; break;
                case "Å": deselectedOOM = 1e-10; break;
                case "km": deselectedOOM = 1e3; break;                
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "m": selectedOOM = 1; break;
                case "cm": selectedOOM = 1e-2; break;
                case "mm": selectedOOM = 1e-3; break;
                case "µm": selectedOOM = 1e-6; break;
                case "nm": selectedOOM = 1e-9; break;
                case "Å": selectedOOM = 1e-10; break;
                case "km": selectedOOM = 1e3; break; 
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            meterTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_meterComboBoxItemStateChanged

    private void inchComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inchComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_inchComboBoxItemStateChanged

    private void footComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_footComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_footComboBoxItemStateChanged

    private void mileComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mileComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_mileComboBoxItemStateChanged

    private void nmileComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nmileComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_nmileComboBoxItemStateChanged

    private void yardComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yardComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_yardComboBoxItemStateChanged

    private void lyearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lyearComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lyearComboBoxItemStateChanged

    private void aunitComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_aunitComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_aunitComboBoxItemStateChanged

    private void parsecComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_parsecComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(parsecTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "pc": deselectedOOM = 1; break;
                case "Mpc": deselectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "pc": selectedOOM = 1; break;
                case "Mpc": selectedOOM = 1e6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            parsecTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_parsecComboBoxItemStateChanged
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Area Panel">
    private void sqmeterComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sqmeterComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(sqmeterTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "m²": deselectedOOM = 1; break;
                case "cm²": deselectedOOM = 1e-4; break;
                case "mm²": deselectedOOM = 1e-6; break;
                case "µm²": deselectedOOM = 1e-12; break;
                case "nm²": deselectedOOM = 1e-18; break;
                case "Å²": deselectedOOM = 1e-20; break;
                case "km²": deselectedOOM = 1e6; break;                
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "m²": selectedOOM = 1; break;
                case "cm²": selectedOOM = 1e-4; break;
                case "mm²": selectedOOM = 1e-6; break;
                case "µm²": selectedOOM = 1e-12; break;
                case "nm²": selectedOOM = 1e-18; break;
                case "Å²": selectedOOM = 1e-20; break;
                case "km²": selectedOOM = 1e6; break; 
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            sqmeterTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_sqmeterComboBoxItemStateChanged

    private void sqinchComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sqinchComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_sqinchComboBoxItemStateChanged

    private void sqfootComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sqfootComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_sqfootComboBoxItemStateChanged

    private void sqmileComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sqmileComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(sqmileTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "mi²": deselectedOOM = 640; break;
                case "ac": deselectedOOM = 1; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "mi²": selectedOOM = 640; break;
                case "ac": selectedOOM = 1; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            sqmileTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_sqmileComboBoxItemStateChanged

    private void hectareComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hectareComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(hectareTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "ha": deselectedOOM = 1e2; break;
                case "a": deselectedOOM = 1; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "ha": selectedOOM = 1e2; break;
                case "a": selectedOOM = 1; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            hectareTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_hectareComboBoxItemStateChanged

    private void sqyardComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sqyardComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_sqyardComboBoxItemStateChanged

    private void barnComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_barnComboBoxItemStateChanged
         double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(barnTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "b": deselectedOOM = 1; break;
                case "mb": deselectedOOM = 1e-3; break;
                case "µb": deselectedOOM = 1e-6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "b": selectedOOM = 1; break;
                case "mb": selectedOOM = 1e-3; break;
                case "µb": selectedOOM = 1e-6; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            barnTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
        
    }//GEN-LAST:event_barnComboBoxItemStateChanged
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Volume Panel">
    private void cubmeterComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cubmeterComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(cubmeterTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "m³": deselectedOOM = 1; break;
                case "cm³": deselectedOOM = 1e-6; break;
                case "mm³": deselectedOOM = 1e-9; break;
                case "µm³": deselectedOOM = 1e-18; break;
                case "nm³": deselectedOOM = 1e-27; break;
                case "km³": deselectedOOM = 1e6; break;                
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "m³": selectedOOM = 1; break;
                case "cm³": selectedOOM = 1e-6; break;
                case "mm³": selectedOOM = 1e-9; break;
                case "µm³": selectedOOM = 1e-18; break;
                case "nm³": selectedOOM = 1e-27; break;
                case "km³": selectedOOM = 1e6; break;  
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            cubmeterTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_cubmeterComboBoxItemStateChanged

    private void cubinchComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cubinchComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cubinchComboBoxItemStateChanged

    private void cubfootComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cubfootComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cubfootComboBoxItemStateChanged

    private void cubmileComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cubmileComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cubmileComboBoxItemStateChanged

    private void literComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_literComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(literTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "l": deselectedOOM = 1; break;
                case "dl": deselectedOOM = 1e-1; break;
                case "cl": deselectedOOM = 1e-2; break;
                case "ml": deselectedOOM = 1e-3; break;              
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "l": selectedOOM = 1; break;
                case "dl": selectedOOM = 1e-1; break;
                case "cl": selectedOOM = 1e-2; break;
                case "ml": selectedOOM = 1e-3; break; 
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            literTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_literComboBoxItemStateChanged

    private void galComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_galComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(galTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "gal": deselectedOOM = 1; break;
                case "bbl": deselectedOOM = 42; break;             
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "gal": selectedOOM = 1; break;
                case "bbl": selectedOOM = 42; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            galTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_galComboBoxItemStateChanged

    private void pintComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pintComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_pintComboBoxItemStateChanged

    private void cupComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cupComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cupComboBoxItemStateChanged

    private void tbspComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tbspComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tbspComboBoxItemStateChanged

    private void teaspComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_teaspComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_teaspComboBoxItemStateChanged
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Time Panel">
    private void secComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_secComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(secTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "s": deselectedOOM = 1; break;
                case "ms": deselectedOOM = 1e-3; break;
                case "µs": deselectedOOM = 1e-6; break;
                case "ns": deselectedOOM = 1e-9; break;
                case "ps": deselectedOOM = 1e-12; break;
                case "fs": deselectedOOM = 1e-15; break;
                case "as": deselectedOOM = 1e-18; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "s": selectedOOM = 1; break;
                case "ms": selectedOOM = 1e-3; break;
                case "µs": selectedOOM = 1e-6; break;
                case "ns": selectedOOM = 1e-9; break;
                case "ps": selectedOOM = 1e-12; break;
                case "fs": selectedOOM = 1e-15; break;
                case "as": selectedOOM = 1e-18; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            secTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_secComboBoxItemStateChanged
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Speed Panel">
    private void msComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_msComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(msTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "m/s": deselectedOOM = 1; break;
                case "cm/s": deselectedOOM = 1e-2; break;
                case "mm/s": deselectedOOM = 1e-3; break;
                case "µm/s": deselectedOOM = 1e-6; break;
                case "nm/s": deselectedOOM = 1e-9; break;
                case "Å/s": deselectedOOM = 1e-10; break;
                case "km/s": deselectedOOM = 1e3; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "m/s": selectedOOM = 1; break;
                case "cm/s": selectedOOM = 1e-2; break;
                case "mm/s": selectedOOM = 1e-3; break;
                case "µm/s": selectedOOM = 1e-6; break;
                case "nm/s": selectedOOM = 1e-9; break;
                case "Å/s": selectedOOM = 1e-10; break;
                case "km/s": selectedOOM = 1e3; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            msTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_msComboBoxItemStateChanged

    private void kmhComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kmhComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_kmhComboBoxItemStateChanged

    private void mphComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mphComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_mphComboBoxItemStateChanged
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Flow Panel">
    private void cubmsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cubmsComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(cubmsTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "m³/s": deselectedOOM = 1; break;
                case "cm³/s": deselectedOOM = 1e-6; break;
                case "mm³/s": deselectedOOM = 1e-9; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "m³/s": selectedOOM = 1; break;
                case "cm³/s": selectedOOM = 1e-6; break;
                case "mm³/s": selectedOOM = 1e-9; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            cubmsTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_cubmsComboBoxItemStateChanged

    private void cubmhComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cubmhComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(cubmhTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "m³/h": deselectedOOM = 1; break;
                case "cm³/h": deselectedOOM = 1e-6; break;
                case "mm³/h": deselectedOOM = 1e-9; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "m³/h": selectedOOM = 1; break;
                case "cm³/h": selectedOOM = 1e-6; break;
                case "mm³/h": selectedOOM = 1e-9; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            cubmhTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_cubmhComboBoxItemStateChanged

    private void litsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_litsComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(litsTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "l/s": deselectedOOM = 1; break;
                case "dl/s": deselectedOOM = 1e-1; break;
                case "cl/s": deselectedOOM = 1e-2; break;
                case "ml/s": deselectedOOM = 1e-3; break;              
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "l/s": selectedOOM = 1; break;
                case "dl/s": selectedOOM = 1e-1; break;
                case "cl/s": selectedOOM = 1e-2; break;
                case "ml/s": selectedOOM = 1e-3; break; 
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            litsTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_litsComboBoxItemStateChanged

    private void litmComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_litmComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(litmTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "l/min": deselectedOOM = 1; break;
                case "dl/min": deselectedOOM = 1e-1; break;
                case "cl/min": deselectedOOM = 1e-2; break;
                case "ml/min": deselectedOOM = 1e-3; break;              
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "l/min": selectedOOM = 1; break;
                case "dl/min": selectedOOM = 1e-1; break;
                case "cl/min": selectedOOM = 1e-2; break;
                case "ml/min": selectedOOM = 1e-3; break; 
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            litmTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_litmComboBoxItemStateChanged

    private void galminComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_galminComboBoxItemStateChanged
        
        double previousValue=0;
        
        try{
            previousValue = Double.parseDouble(galminTextField.getText());
            //System.out.println("previous value "+previousValue);
            
        }
        catch (Exception e){
            System.out.println("An error occurred when parsing the input value:");
            System.out.println(e);
        }
        
        //BOTH evt ARE THROWN!!!
        if (evt.getStateChange() == evt.DESELECTED) {
            
            String deselectedString = evt.getItem().toString();
            switch(deselectedString){
                case "gal/min": deselectedOOM = 1; break;
                case "bbl/min": deselectedOOM = 42; break;             
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        } 
        else if (evt.getStateChange() == evt.SELECTED) {
            
            String selectedString = evt.getItem().toString();
            switch(selectedString){
                case "gal/min": selectedOOM = 1; break;
                case "bbl/min": selectedOOM = 42; break;
                default: System.out.println("An error has occurred while changing unit."); break;
            }
        }
        
        double ratio = deselectedOOM/selectedOOM;
        
        evtCount= evtCount+1;
        if(evtCount==2){//update the value only when evt is thrown twice
            galminTextField.setText((String)formatter.format(previousValue*ratio).toLowerCase());
            evtCount=0;
        }
        
    }//GEN-LAST:event_galminComboBoxItemStateChanged
    // </editor-fold>
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Scroll tabs with mouse wheel">
    private void scrollOnTab(){
        
        tabbedPane.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                JTabbedPane pane = (JTabbedPane) e.getSource();
                int units = e.getWheelRotation();
                
                int x = e.getX();
                if (x <= 60){
                
                    int oldIndex = pane.getSelectedIndex();
                    int lastIndex = pane.getTabCount();
                    int newIndex = oldIndex + units;
                    if (newIndex < 0)
                        pane.setSelectedIndex(0);
                    else if (newIndex >= lastIndex)
                        pane.setSelectedIndex(pane.getTabCount() - 1);
                    else if (newIndex == 11){
                        pane.setSelectedIndex(11);
                        pane.setSelectedIndex(10);
                    }
                    else
                        pane.setSelectedIndex(newIndex);
                }
            }
        });
    }
    //</editor-fold>
    
    private int checkRBSelection(int tabIndex){
    
        int radioIndex = 0;
        
        for(int k=0; k<rbArray[tabIndex].length; k++ ){
            if (rbArray[tabIndex][k].isSelected()) radioIndex = k;
        }
        //System.out.println(radioIndex);
        
        return radioIndex;
    }
    
    private int checkCBSelection(int tabIndex, int radioIndex){
        
        int comboBoxIndex = cbArray[tabIndex][radioIndex].getSelectedIndex();
        
        return comboBoxIndex;
    }
    
    
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                boolean fontFound = checkFont();
                if(!fontFound){System.out.println("Font Roboto Slab not found.");}
                boolean launchFlag = false;
                //int answer=-1; //answer to popup message asking for font installation
                
                if (fontFound){
                    launchFlag = true;
                }else if(!fontFound){
                    String[] buttons = { "I have the font file", "Go to font webpage", "Launch without font"}; // corresponding to rc = 0,1,2
                    int rc = JOptionPane.showOptionDialog(null, "Font Roboto Slab not found. Launching the application without it could cause some issues.\n"
                            + "Please install it manually from the provided file or download it from the Google Fonts page.\n ",
                                                         "Error", 0, JOptionPane.WARNING_MESSAGE, null, buttons, buttons[0]);
                    
                  switch (rc) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "BuddyConverter will now quit. Launch it again once the font has been installed.");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "BuddyConverter will now quit. Launch it again once the font has been installed.");
                        String url = "https://fonts.google.com/specimen/Roboto+Slab";
                        String currentOS = System.getProperty("os.name").toLowerCase();
                        System.out.println("Running operating system: " + currentOS);
                        Runtime rt = Runtime.getRuntime();
                        try {
                            if(currentOS.contains("win")){
                                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
                            }else if(currentOS.contains("mac")){
                                rt.exec("open" + url);
                            }else if(currentOS.contains("nix")||currentOS.contains("nux")||currentOS.indexOf("aix")>0){
                                rt.exec("xdg-open" + url);
                            }else{
                                System.out.println("Error: cannot determine current operating system.");
                            }
                        }catch (IOException ex) {
                            //Logger.getLogger(bcGUI.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error: unable to launch brower.");
                        }
                        break;
                    case 2:
                        launchFlag=true;
                        break;
                    default:
                        System.out.println("Error: unable to get answer from font pop-up message.");
                        break;
                    }
                }else{
                    System.out.println("Error: unable to check font.");
                }
                
                //Run the program
                if (launchFlag){
                    new bcGUI().setVisible(true);
                    String version = "0.6beta";
                    String date = "Apr 14th 2019";
                
                    System.out.println("*****************************");
                    System.out.println("*****  Buddy Converter  *****");
                    System.out.println("Author:        Diego Sabbagh");
                    System.out.println("Build version: " + version);
                    System.out.println("Build date:    " + date);
                    System.out.println();
                    System.out.println("Catch statements:");
                    System.out.println();
                }
                
            }
        });
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="NetBeans variable declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> amuComboBox;
    private javax.swing.JLabel amuLabel;
    private javax.swing.JTextField amuTextField;
    private javax.swing.JPanel angPanel;
    private javax.swing.JPanel angTipsPanel;
    private javax.swing.JPanel angUnitPanel;
    private javax.swing.JPanel areaPanel;
    private javax.swing.JPanel areaTipsPanel;
    private javax.swing.JPanel areaUnitPanel;
    private javax.swing.JComboBox<String> atmComboBox;
    private javax.swing.JRadioButton atmRadioButton;
    private javax.swing.JTextField atmTextField;
    private javax.swing.JComboBox<String> aunitComboBox;
    private javax.swing.JRadioButton aunitRadioButton;
    private javax.swing.JTextField aunitTextField;
    private javax.swing.JComboBox<String> avogadroComboBox;
    private javax.swing.JLabel avogadroLabel;
    private javax.swing.JTextField avogadroTextField;
    private javax.swing.JComboBox<String> barComboBox;
    private javax.swing.JRadioButton barRadioButton;
    private javax.swing.JTextField barTextField;
    private javax.swing.JComboBox<String> barnComboBox;
    private javax.swing.JRadioButton barnRadioButton;
    private javax.swing.JTextField barnTextField;
    private javax.swing.JComboBox<String> baryeComboBox;
    private javax.swing.JRadioButton baryeRadioButton;
    private javax.swing.JTextField baryeTextField;
    private javax.swing.JPanel bkgPanel;
    private javax.swing.JComboBox<String> bohrmagComboBox;
    private javax.swing.JLabel bohrmagLabel;
    private javax.swing.JTextField bohrmagTextField;
    private javax.swing.JComboBox<String> bohrradComboBox;
    private javax.swing.JLabel bohrradLabel;
    private javax.swing.JTextField bohrradTextField;
    private javax.swing.JComboBox<String> boltzmannComboBox;
    private javax.swing.JLabel boltzmannLabel;
    private javax.swing.JTextField boltzmannTextField;
    private javax.swing.JLabel bugLabel1;
    private javax.swing.JLabel bugLabel2;
    private javax.swing.JLabel bugLabel3;
    private javax.swing.JComboBox<String> calComboBox;
    private javax.swing.JRadioButton calRadioButton;
    private javax.swing.JTextField calTextField;
    private javax.swing.JComboBox<String> celsComboBox;
    private javax.swing.JRadioButton celsRadioButton;
    private javax.swing.JTextField celsTextField;
    private javax.swing.JComboBox<String> chargeComboBox;
    private javax.swing.JLabel chargeLabel;
    private javax.swing.JTextField chargeTextField;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JComboBox<String> cm1ComboBox;
    private javax.swing.JRadioButton cm1RadioButton;
    private javax.swing.JTextField cm1TextField;
    private javax.swing.JComboBox<String> condqComboBox;
    private javax.swing.JLabel condqLabel;
    private javax.swing.JTextField condqTextField;
    private javax.swing.JPanel consPanel;
    private javax.swing.JScrollPane consScrollPane;
    private javax.swing.JPanel consTipsPanel;
    private javax.swing.JPanel consinnerPanel;
    private javax.swing.JLabel convertLabel;
    private javax.swing.JComboBox<String> cosmoComboBox;
    private javax.swing.JLabel cosmoLabel;
    private javax.swing.JTextField cosmoTextField;
    private javax.swing.JComboBox<String> cubfootComboBox;
    private javax.swing.JRadioButton cubfootRadioButton;
    private javax.swing.JTextField cubfootTextField;
    private javax.swing.JComboBox<String> cubftsComboBox;
    private javax.swing.JRadioButton cubftsRadioButton;
    private javax.swing.JTextField cubftsTextField;
    private javax.swing.JComboBox<String> cubinchComboBox;
    private javax.swing.JRadioButton cubinchRadioButton;
    private javax.swing.JTextField cubinchTextField;
    private javax.swing.JComboBox<String> cubmeterComboBox;
    private javax.swing.JRadioButton cubmeterRadioButton;
    private javax.swing.JTextField cubmeterTextField;
    private javax.swing.JComboBox<String> cubmhComboBox;
    private javax.swing.JRadioButton cubmhRadioButton;
    private javax.swing.JTextField cubmhTextField;
    private javax.swing.JComboBox<String> cubmileComboBox;
    private javax.swing.JRadioButton cubmileRadioButton;
    private javax.swing.JTextField cubmileTextField;
    private javax.swing.JComboBox<String> cubmsComboBox;
    private javax.swing.JRadioButton cubmsRadioButton;
    private javax.swing.JTextField cubmsTextField;
    private javax.swing.JComboBox<String> cupComboBox;
    private javax.swing.JRadioButton cupRadioButton;
    private javax.swing.JTextField cupTextField;
    private javax.swing.JComboBox<String> dayComboBox;
    private javax.swing.JRadioButton dayRadioButton;
    private javax.swing.JTextField dayTextField;
    private javax.swing.JComboBox<String> degComboBox;
    private javax.swing.JRadioButton degRadioButton;
    private javax.swing.JTextField degTextField;
    private javax.swing.JComboBox<String> eVComboBox;
    private javax.swing.JRadioButton eVRadioButton;
    private javax.swing.JTextField eVTextField;
    private javax.swing.JComboBox<String> einsteinComboBox;
    private javax.swing.JLabel einsteinLabel;
    private javax.swing.JTextField einsteinTextField;
    private javax.swing.JComboBox<String> elmassComboBox;
    private javax.swing.JLabel elmassLabel;
    private javax.swing.JTextField elmassTextField;
    private javax.swing.JPanel enerPanel;
    private javax.swing.JPanel enerTipsPanel;
    private javax.swing.JPanel enerUnitPanel;
    private javax.swing.JComboBox<String> ergComboBox;
    private javax.swing.JRadioButton ergRadioButton;
    private javax.swing.JTextField ergTextField;
    private javax.swing.JComboBox<String> fahrComboBox;
    private javax.swing.JRadioButton fahrRadioButton;
    private javax.swing.JTextField fahrTextField;
    private javax.swing.JComboBox<String> faradayComboBox;
    private javax.swing.JLabel faradayLabel;
    private javax.swing.JTextField faradayTextField1;
    private javax.swing.JComboBox<String> finestrComboBox;
    private javax.swing.JLabel finestrLabel;
    private javax.swing.JTextField finestrTextField;
    private javax.swing.JPanel flowPanel;
    private javax.swing.JPanel flowTipsPanel;
    private javax.swing.JPanel flowUnitPanel;
    private javax.swing.JComboBox<String> fluxqComboBox;
    private javax.swing.JLabel fluxqLabel;
    private javax.swing.JTextField fluxqTextField;
    private javax.swing.JComboBox<String> footComboBox;
    private javax.swing.JRadioButton footRadioButton;
    private javax.swing.JTextField footTextField;
    private javax.swing.JComboBox<String> ftsComboBox;
    private javax.swing.JRadioButton ftsRadioButton;
    private javax.swing.JTextField ftsTextField;
    private javax.swing.JComboBox<String> galComboBox;
    private javax.swing.JRadioButton galRadioButton;
    private javax.swing.JTextField galTextField;
    private javax.swing.JComboBox<String> galminComboBox;
    private javax.swing.JRadioButton galminRadioButton;
    private javax.swing.JTextField galminTextField;
    private javax.swing.JComboBox<String> gasComboBox;
    private javax.swing.JLabel gasLabel;
    private javax.swing.JTextField gasTextField;
    private javax.swing.JComboBox<String> gradComboBox;
    private javax.swing.JRadioButton gradRadioButton;
    private javax.swing.JTextField gradTextField;
    private javax.swing.JComboBox<String> gravaccComboBox;
    private javax.swing.JLabel gravaccLabel;
    private javax.swing.JTextField gravaccTextField;
    private javax.swing.JComboBox<String> hectareComboBox;
    private javax.swing.JRadioButton hectareRadioButton;
    private javax.swing.JTextField hectareTextField;
    private javax.swing.JComboBox<String> hertzComboBox;
    private javax.swing.JRadioButton hertzRadioButton;
    private javax.swing.JTextField hertzTextField;
    private javax.swing.JComboBox<String> hourComboBox;
    private javax.swing.JRadioButton hourRadioButton;
    private javax.swing.JTextField hourTextField;
    private javax.swing.JComboBox<String> hubbleComboBox;
    private javax.swing.JLabel hubbleLabel;
    private javax.swing.JTextField hubbleTextField;
    private javax.swing.JComboBox<String> inchComboBox;
    private javax.swing.JRadioButton inchRadioButton;
    private javax.swing.JTextField inchTextField;
    private javax.swing.JComboBox<String> josephComboBox;
    private javax.swing.JLabel josephLabel;
    private javax.swing.JTextField josephTextField;
    private javax.swing.JComboBox<String> jouleComboBox;
    private javax.swing.JRadioButton jouleRadioButton;
    private javax.swing.JTextField jouleTextField;
    private javax.swing.JComboBox<String> kelvComboBox;
    private javax.swing.JRadioButton kelvRadioButton;
    private javax.swing.JTextField kelvTextField;
    private javax.swing.JComboBox<String> kelvinComboBox;
    private javax.swing.JRadioButton kelvinRadioButton;
    private javax.swing.JTextField kelvinTextField;
    private javax.swing.JComboBox<String> kgComboBox;
    private javax.swing.JRadioButton kgRadioButton;
    private javax.swing.JTextField kgTextField;
    private javax.swing.JComboBox<String> kmhComboBox;
    private javax.swing.JRadioButton kmhRadioButton;
    private javax.swing.JTextField kmhTextField;
    private javax.swing.JComboBox<String> knotComboBox;
    private javax.swing.JRadioButton knotRadioButton;
    private javax.swing.JTextField knotTextField;
    private javax.swing.JPanel lengPanel;
    private javax.swing.JPanel lengTipsPanel;
    private javax.swing.JPanel lengUnitPanel;
    private javax.swing.JComboBox<String> lightspdComboBox;
    private javax.swing.JLabel lightspdLabel;
    private javax.swing.JTextField lightspdTextField;
    private javax.swing.JComboBox<String> literComboBox;
    private javax.swing.JRadioButton literRadioButton;
    private javax.swing.JTextField literTextField;
    private javax.swing.JComboBox<String> litmComboBox;
    private javax.swing.JRadioButton litmRadioButton;
    private javax.swing.JTextField litmTextField;
    private javax.swing.JComboBox<String> litsComboBox;
    private javax.swing.JRadioButton litsRadioButton;
    private javax.swing.JTextField litsTextField;
    private javax.swing.JComboBox<String> lyearComboBox;
    private javax.swing.JRadioButton lyearRadioButton;
    private javax.swing.JTextField lyearTextField;
    private javax.swing.JComboBox<String> machComboBox;
    private javax.swing.JRadioButton machRadioButton;
    private javax.swing.JTextField machTextField;
    private javax.swing.JComboBox<String> meterComboBox;
    private javax.swing.JRadioButton meterRadioButton;
    private javax.swing.JTextField meterTextField;
    private javax.swing.JComboBox<String> mileComboBox;
    private javax.swing.JRadioButton mileRadioButton;
    private javax.swing.JTextField mileTextField;
    private javax.swing.JComboBox<String> minComboBox;
    private javax.swing.JRadioButton minRadioButton;
    private javax.swing.JTextField minTextField;
    private javax.swing.JLabel minimiseLabel;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JRadioButton monthRadioButton;
    private javax.swing.JTextField monthTextField;
    private javax.swing.JComboBox<String> mphComboBox;
    private javax.swing.JRadioButton mphRadioButton;
    private javax.swing.JTextField mphTextField;
    private javax.swing.JComboBox<String> msComboBox;
    private javax.swing.JRadioButton msRadioButton;
    private javax.swing.JTextField msTextField;
    private javax.swing.JComboBox<String> neutmassComboBox;
    private javax.swing.JLabel neutmassLabel;
    private javax.swing.JTextField neutmassTextField;
    private javax.swing.JComboBox<String> newtonComboBox;
    private javax.swing.JLabel newtonLabel;
    private javax.swing.JTextField newtonTextField;
    private javax.swing.JComboBox<String> nmComboBox;
    private javax.swing.JRadioButton nmRadioButton;
    private javax.swing.JTextField nmTextField;
    private javax.swing.JComboBox<String> nmileComboBox;
    private javax.swing.JRadioButton nmileRadioButton;
    private javax.swing.JTextField nmileTextField;
    private javax.swing.JComboBox<String> nuclmagComboBox;
    private javax.swing.JLabel nuclmagLabel;
    private javax.swing.JTextField nuclmagTextField;
    private javax.swing.JComboBox<String> parsecComboBox;
    private javax.swing.JRadioButton parsecRadioButton;
    private javax.swing.JTextField parsecTextField;
    private javax.swing.JComboBox<String> pascComboBox;
    private javax.swing.JRadioButton pascRadioButton;
    private javax.swing.JTextField pascTextField;
    private javax.swing.JComboBox<String> permeabComboBox;
    private javax.swing.JLabel permeabLabel;
    private javax.swing.JTextField permeabTextField;
    private javax.swing.JComboBox<String> permitComboBox;
    private javax.swing.JTextField permitTextField;
    private javax.swing.JPanel phantomPanel;
    private javax.swing.JLabel phantomconsLabel;
    private javax.swing.JComboBox<String> pintComboBox;
    private javax.swing.JRadioButton pintRadioButton;
    private javax.swing.JTextField pintTextField;
    private javax.swing.JComboBox<String> plankComboBox;
    private javax.swing.JLabel plankLabel;
    private javax.swing.JTextField plankTextField;
    private javax.swing.JLabel premitLabel;
    private javax.swing.JPanel presPanel;
    private javax.swing.JPanel presTipsPanel;
    private javax.swing.JPanel presUnitPanel;
    private javax.swing.JComboBox<String> protmassComboBox;
    private javax.swing.JLabel protmassLabel;
    private javax.swing.JTextField protmassTextField;
    private javax.swing.JComboBox<String> psiComboBox;
    private javax.swing.JRadioButton psiRadioButton;
    private javax.swing.JTextField psiTextField;
    private javax.swing.JComboBox<String> radComboBox;
    private javax.swing.JRadioButton radRadioButton;
    private javax.swing.JTextField radTextField;
    private javax.swing.JComboBox<String> redplankComboBox;
    private javax.swing.JLabel redplankLabel;
    private javax.swing.JTextField redplankTextField;
    private javax.swing.JComboBox<String> rydbergComboBox;
    private javax.swing.JLabel rydbergLabel;
    private javax.swing.JTextField rydbergTextField;
    private javax.swing.JComboBox<String> sccmComboBox;
    private javax.swing.JRadioButton sccmRadioButton;
    private javax.swing.JTextField sccmTextField;
    private javax.swing.JLabel scrollDownLabel;
    private javax.swing.JLabel scrollUpLabel;
    private javax.swing.JComboBox<String> secComboBox;
    private javax.swing.JRadioButton secRadioButton;
    private javax.swing.JTextField secTextField;
    private javax.swing.JPanel spdPanel;
    private javax.swing.JPanel spdTipsPanel;
    private javax.swing.JPanel spdUnitPanel;
    private javax.swing.JComboBox<String> sqfootComboBox;
    private javax.swing.JRadioButton sqfootRadioButton;
    private javax.swing.JTextField sqfootTextField;
    private javax.swing.JComboBox<String> sqinchComboBox;
    private javax.swing.JRadioButton sqinchRadioButton;
    private javax.swing.JTextField sqinchTextField;
    private javax.swing.JComboBox<String> sqmeterComboBox;
    private javax.swing.JRadioButton sqmeterRadioButton;
    private javax.swing.JTextField sqmeterTextField;
    private javax.swing.JComboBox<String> sqmileComboBox;
    private javax.swing.JRadioButton sqmileRadioButton;
    private javax.swing.JTextField sqmileTextField;
    private javax.swing.JComboBox<String> sqyardComboBox;
    private javax.swing.JRadioButton sqyardRadioButton;
    private javax.swing.JTextField sqyardTextField;
    private javax.swing.JComboBox<String> stefboltzComboBox;
    private javax.swing.JLabel stefboltzLabel;
    private javax.swing.JTextField stefboltzTextField;
    private static javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JComboBox<String> tbspComboBox;
    private javax.swing.JRadioButton tbspRadioButton;
    private javax.swing.JTextField tbspTextField;
    private javax.swing.JComboBox<String> teaspComboBox;
    private javax.swing.JRadioButton teaspRadioButton;
    private javax.swing.JTextField teaspTextField;
    private javax.swing.JPanel tempPanel;
    private javax.swing.JPanel tempTipsPanel;
    private javax.swing.JPanel tempUnitPanel;
    private javax.swing.JPanel timePanel;
    private javax.swing.JPanel timeTipsPanel;
    private javax.swing.JPanel timeUnitPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> torrComboBox;
    private javax.swing.JRadioButton torrRadioButton;
    private javax.swing.JTextField torrTextField;
    private javax.swing.JComboBox<String> vacimpedComboBox;
    private javax.swing.JLabel vacimpedLabel;
    private javax.swing.JTextField vacimpedTextField;
    private javax.swing.JLabel versionLabel;
    private javax.swing.JPanel voluPanel;
    private javax.swing.JPanel voluTipsPanel;
    private javax.swing.JPanel voluUnitPanel;
    private javax.swing.JComboBox<String> watthComboBox;
    private javax.swing.JRadioButton watthRadioButton;
    private javax.swing.JTextField watthTextField;
    private javax.swing.JComboBox<String> weekComboBox;
    private javax.swing.JRadioButton weekRadioButton;
    private javax.swing.JTextField weekTextField;
    private javax.swing.JComboBox<String> wienComboBox;
    private javax.swing.JLabel wienLabel;
    private javax.swing.JTextField wienTextField;
    private javax.swing.JComboBox<String> yardComboBox;
    private javax.swing.JRadioButton yardRadioButton;
    private javax.swing.JTextField yardTextField;
    private javax.swing.JComboBox<String> yearComboBox;
    private javax.swing.JRadioButton yearRadioButton;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}//</editor-fold>
