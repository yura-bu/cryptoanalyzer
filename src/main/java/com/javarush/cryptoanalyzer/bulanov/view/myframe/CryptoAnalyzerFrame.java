package com.javarush.cryptoanalyzer.bulanov.view.myframe;

import javax.swing.*;

import static com.javarush.cryptoanalyzer.bulanov.constants.FrameConstants.*;
import static com.javarush.cryptoanalyzer.bulanov.constants.FunctionConstants.*;

public class CryptoAnalyzerFrame extends JFrame{
    public static JButton jButtonEncode;
    public static JButton jButtonDecode;
    public static JButton jButtonBruteForce;
    public static JButton jButtonExit;
    public static JLabel jLabelResult;
    public static JLabel jLabelKey;
    public static final String[] parameters = new String[4];

    public CryptoAnalyzerFrame(){
        initComponentsCryptoAnalyzerFrame();
        actionJButtonEncode();
        actionJButtonDecode();
        actionJButtonBruteForce();
        actionJButtonExit();
    }
    private void initComponentsCryptoAnalyzerFrame(){

        this.setSize(600, 300);

        JLabel jLabelStart = new JLabel();
        jLabelStart.setText(LABEL_START_INFO);
        jLabelStart.setBounds(150,50, 350, 40);
        this.add(jLabelStart);

        jButtonEncode = new JButton(BUTTON_ENCODE);
        jButtonEncode.setBounds(45, 100, 150, 40);
        this.add(jButtonEncode);

        jButtonDecode = new JButton(BUTTON_DECODE);
        jButtonDecode.setBounds(215, 100, 150, 40);
        this.add(jButtonDecode);

        jButtonBruteForce = new JButton(BUTTON_BRUTE_FORCE);
        jButtonBruteForce.setBounds(385, 100, 150, 40);
        this.add(jButtonBruteForce);

        jLabelResult = new JLabel();
        jLabelResult.setBounds(50, 150, 450, 40);
        this.add(jLabelResult);

        jLabelKey = new JLabel();
        jLabelKey.setBounds(50, 200, 250, 20);
        this.add(jLabelKey);

        jButtonExit = new JButton(BUTTON_EXIT);
        jButtonExit.setBounds(215, 220, 150, 40);
        this.add(jButtonExit);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);

    }
    private void actionJButtonEncode(){
        jButtonEncode.addActionListener(e ->{
            var encodeFrame = new EncodeFrame();
            jButtonEncode.setEnabled(false);
            encodeFrame.actionJButtonEnterOne();
            parameters[0] = ENCODE_NUMBER;
        });
    }
    private void actionJButtonDecode(){
        jButtonDecode.addActionListener(e ->{
            jLabelKey.setText(LABEL_EMPTY);
            jLabelResult.setText(LABEL_EMPTY);
            var decodeFrame = new DecodeFrame();
            jButtonDecode.setEnabled(false);
            decodeFrame.actionJButtonEnterOne();
            parameters[0] = DECODE_NUMBER;
        });
    }
    private void actionJButtonBruteForce(){
        jButtonBruteForce.addActionListener(e ->{
            jLabelKey.setText(LABEL_EMPTY);
            jLabelResult.setText(LABEL_EMPTY);
            var bruteForceFrame = new BruteForceFrame();
            jButtonBruteForce.setEnabled(false);
            bruteForceFrame.actionJButtonEnterOne();
            parameters[0] = BRUTE_FORCE_NUMBER;
        });
    }
    private void actionJButtonExit(){
        jButtonExit.addActionListener(e -> this.dispose());
    }
}

