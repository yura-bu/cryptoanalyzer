package com.javarush.cryptoanalyzer.bulanov.view.myframe;

import com.javarush.cryptoanalyzer.bulanov.view.Entry;

import javax.swing.*;

import static com.javarush.cryptoanalyzer.bulanov.constants.ConstantsIO.ENTER_DECRYPTED_FILE_PATH;
import static com.javarush.cryptoanalyzer.bulanov.constants.ConstantsIO.ENTER_ENCRYPTED_FILE_PATH;

public class BruteForceFrame extends JFrame{
    private JButton jButtonEnterOne;
    private JTextField jTextFieldOne;
    private JButton jButtonEnterTwo;
    private JTextField jTextFieldTwo;
    private JButton jButtonStart;
    public BruteForceFrame(){
        initJFrameBruteForce();
    }
    private void initJFrameBruteForce(){

        this.setSize(600, 300);

        JLabel jLabelOne = new JLabel();
        jLabelOne.setBounds(45, 25, 550, 40);
        jLabelOne.setText("<html>" + ENTER_ENCRYPTED_FILE_PATH + "</html>");
        this.add(jLabelOne);

        jButtonEnterOne = new JButton("Enter");
        jButtonEnterOne.setBounds(410, 65, 100, 20);
        this.add(jButtonEnterOne);


        jTextFieldOne = new JTextField();
        jTextFieldOne.setBounds(45,65, 350, 20);
        this.add(jTextFieldOne);

        JLabel jLabelTwo = new JLabel();
        jLabelTwo.setBounds(45, 100, 550, 40);
        jLabelTwo.setText("<html>" + ENTER_DECRYPTED_FILE_PATH + "</html>");
        this.add(jLabelTwo);

        jTextFieldTwo = new JTextField();
        jTextFieldTwo.setBounds(45,140, 350, 20);
        this.add(jTextFieldTwo);

        jButtonEnterTwo = new JButton("Enter");
        jButtonEnterTwo.setBounds(410, 140, 100, 20);
        this.add(jButtonEnterTwo);

        jButtonStart = new JButton("Start");
        jButtonStart.setBounds(250, 230, 100, 20);
        this.add(jButtonStart);

        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }
    public void actionJButtonEnterOne(){

        jButtonEnterOne.addActionListener(e -> {
            String text = jTextFieldOne.getText();
            jButtonEnterOne.setEnabled(false);
            jTextFieldOne.setEnabled(false);
            if(text.isEmpty()){
                CryptoAnalyzerFrame.parameters[1] = "encoded.txt";
            }else CryptoAnalyzerFrame.parameters[1] = text;
            actionJButtonEnterTwo();
        });
    }
    public void actionJButtonEnterTwo(){
        jButtonEnterTwo.addActionListener(e -> {
            String text = jTextFieldTwo.getText();
            jButtonEnterTwo.setEnabled(false);
            jTextFieldTwo.setEnabled(false);
            if(text.isEmpty()){
                CryptoAnalyzerFrame.parameters[2] = "output.txt";
            }else CryptoAnalyzerFrame.parameters[2] = text;
            actionJButtonStart();
        });
    }
    public void actionJButtonStart(){
        jButtonStart.addActionListener(e -> {
            jButtonStart.setEnabled(false);
            new Entry().entry(CryptoAnalyzerFrame.parameters);
            this.dispose();
            CryptoAnalyzerFrame.jButtonBruteForce.setEnabled(true);
        });
    }
}
