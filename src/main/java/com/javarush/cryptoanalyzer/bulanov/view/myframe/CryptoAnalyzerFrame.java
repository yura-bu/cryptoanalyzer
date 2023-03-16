package com.javarush.cryptoanalyzer.bulanov.view.myframe;

import javax.swing.*;

public class CryptoAnalyzerFrame extends JFrame{
    public static JButton jButtonEncode;
    public static JButton jButtonDecode;
    public static JButton jButtonBruteForce;
    public static JLabel jLabelResult;
    public static JLabel jLabelKey;
    public static final String[] parameters = new String[4];

    public CryptoAnalyzerFrame(){
        initComponentsCryptoAnalyzerFrame();
        actionJButtonEncode();
        actionJButtonDecode();
        actionJButtonBruteForce();
    }
    private void initComponentsCryptoAnalyzerFrame(){

        this.setSize(600, 300);

        JLabel jLabelStart = new JLabel();
        jLabelStart.setText("Выберите режим работы программы:");
        jLabelStart.setBounds(150,50, 350, 40);
        this.add(jLabelStart);

        jButtonEncode = new JButton("Encode");
        jButtonEncode.setBounds(45, 100, 150, 40);
        this.add(jButtonEncode);

        jButtonDecode = new JButton("Decode");
        jButtonDecode.setBounds(215, 100, 150, 40);
        this.add(jButtonDecode);

        jButtonBruteForce = new JButton("Brute Force");
        jButtonBruteForce.setBounds(385, 100, 150, 40);
        this.add(jButtonBruteForce);

        jLabelResult = new JLabel();
        jLabelResult.setBounds(50, 150, 450, 40);
        this.add(jLabelResult);

        jLabelKey = new JLabel();
        jLabelKey.setBounds(50, 200, 250, 20);
        this.add(jLabelKey);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);

    }
    private void actionJButtonEncode(){
        jButtonEncode.addActionListener(e ->{
            var encodeFrame = new EncodeFrame();
            jButtonEncode.setEnabled(false);
            encodeFrame.actionJButtonEnterOne();
            parameters[0] = "1";
        });
    }
    private void actionJButtonDecode(){
        jButtonDecode.addActionListener(e ->{
            jLabelKey.setText("");
            jLabelResult.setText("");
            var decodeFrame = new DecodeFrame();
            jButtonDecode.setEnabled(false);
            decodeFrame.actionJButtonEnterOne();
            parameters[0] = "2";
        });
    }
    private void actionJButtonBruteForce(){
        jButtonBruteForce.addActionListener(e ->{
            jLabelKey.setText("");
            jLabelResult.setText("");
            var bruteForceFrame = new BruteForceFrame();
            jButtonBruteForce.setEnabled(false);
            bruteForceFrame.actionJButtonEnterOne();
            parameters[0] = "3";
        });
    }
}

