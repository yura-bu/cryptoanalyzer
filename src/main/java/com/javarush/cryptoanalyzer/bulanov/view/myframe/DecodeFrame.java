package com.javarush.cryptoanalyzer.bulanov.view.myframe;

import com.javarush.cryptoanalyzer.bulanov.view.Entry;
import javax.swing.*;
import static com.javarush.cryptoanalyzer.bulanov.constants.ConstantsIO.*;

public class DecodeFrame extends JFrame{
    private JButton jButtonEnterOne;
    private JTextField jTextFieldOne;
    private JButton jButtonEnterTwo;
    private JTextField jTextFieldTwo;
    private JButton jButtonStart;
    private JTextField key;
    private JButton jButtonKey;
    private JLabel jLabelMessage;
    public DecodeFrame(){
        initJFrameDecode();
    }
    private void initJFrameDecode(){

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

        key = new JTextField();
        key.setBounds(100, 180, 40, 20);
        this.add(key);

        JLabel jLabelKey = new JLabel("Ключ");
        jLabelKey.setBounds(45, 180, 60, 20);
        this.add(jLabelKey);

        jButtonKey = new JButton("Enter");
        jButtonKey.setBounds(180,180, 100,20);
        this.add(jButtonKey);

        jLabelMessage = new JLabel();
        jLabelMessage.setBounds(45, 210, 550, 20);
        this.add(jLabelMessage);

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
            actionJButtonKey();
        });
    }

    public  void actionJButtonKey(){
        jButtonKey.addActionListener(e->{
            if(!isNumeric(key.getText())) {
                jLabelMessage.setText("Введите число больше 0 !!!");
            }else if(isNumeric(key.getText())){
            jLabelMessage.setText("");
            CryptoAnalyzerFrame.parameters[3] = key.getText();
            jButtonKey.setEnabled(false);
            }
            actionJButtonStart();
        });
    }
    public void actionJButtonStart(){
        jButtonStart.addActionListener(e -> {
            jButtonStart.setEnabled(false);
            new Entry().entry(CryptoAnalyzerFrame.parameters);
            this.dispose();
            CryptoAnalyzerFrame.jButtonDecode.setEnabled(true);
        });
    }
    public  boolean isNumeric(String str) {
        return str.matches("^\\d+");
    }
}
