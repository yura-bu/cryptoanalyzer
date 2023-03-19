package com.javarush.cryptoanalyzer.bulanov.view.myframe;

import com.javarush.cryptoanalyzer.bulanov.utility.RandomOffset;
import com.javarush.cryptoanalyzer.bulanov.view.Entry;
import javax.swing.*;
import static com.javarush.cryptoanalyzer.bulanov.constants.ConstantsIO.*;
import static com.javarush.cryptoanalyzer.bulanov.constants.FilePathConstants.*;
import static com.javarush.cryptoanalyzer.bulanov.constants.FrameConstants.*;


public class EncodeFrame extends JFrame{
    private JButton jButtonEnterOne;
    private JTextField jTextFieldOne;
    private JButton jButtonEnterTwo;
    private JTextField jTextFieldTwo;
    private JButton jButtonStart;

    public EncodeFrame(){
        initJFrameEncode();
    }
    private void initJFrameEncode(){

        this.setSize(600, 300);

        JLabel jLabelOne = new JLabel();
        jLabelOne.setBounds(45, 25, 350, 40);
        jLabelOne.setText("<html>" + ENTER_ORIG_FILE_PATH + "</html>");
        this.add(jLabelOne);

        jButtonEnterOne = new JButton(BUTTON_ENTER);
        jButtonEnterOne.setBounds(410, 65, 100, 20);
        this.add(jButtonEnterOne);


        jTextFieldOne = new JTextField();
        jTextFieldOne.setBounds(45,65, 350, 20);
        this.add(jTextFieldOne);

        JLabel jLabelTwo = new JLabel();
        jLabelTwo.setBounds(45, 100, 450, 40);
        jLabelTwo.setText("<html>" + ENTER_CRYPT_FILE_PATH + "</html>");
        this.add(jLabelTwo);

        jTextFieldTwo = new JTextField();
        jTextFieldTwo.setBounds(45,140, 350, 20);
        this.add(jTextFieldTwo);

        jButtonEnterTwo = new JButton(BUTTON_ENTER);
        jButtonEnterTwo.setBounds(410, 140, 100, 20);
        this.add(jButtonEnterTwo);

        jButtonStart = new JButton(BUTTON_START);
        jButtonStart.setBounds(250, 200, 100, 20);
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
              CryptoAnalyzerFrame.parameters[1] = ORIGINAL_FILE;
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
                  CryptoAnalyzerFrame.parameters[2] = ENCODED_FILE;
            }else CryptoAnalyzerFrame.parameters[2] = text;
            actionJButtonStart();
        });
    }
    public void actionJButtonStart(){
        jButtonStart.addActionListener(e -> {
            jButtonStart.setEnabled(false);
            CryptoAnalyzerFrame.parameters[3] = RandomOffset.randomOffset();
            new Entry().entry(CryptoAnalyzerFrame.parameters);
            CryptoAnalyzerFrame.jLabelKey.setText(KEY + CryptoAnalyzerFrame.parameters[3]);
            this.dispose();
            CryptoAnalyzerFrame.jButtonEncode.setEnabled(true);
        });
    }
}
