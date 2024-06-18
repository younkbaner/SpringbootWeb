package com.web.springbootweb.gui;

import javax.swing.*;

/**
 * @description:
 * @author: ywz
 * @time: 2024/4/14 18:52
 */
public class JComboBoxTest extends JFrame {

    JPanel root;
    JLabel messageLabel;
    JComboBox comboBox;

    JScrollPane js;

    JList jList;

    public JComboBoxTest(String title){

        super(title);

        root = new JPanel();
        setContentPane(root);
        setLayout(null);

        messageLabel = new JLabel("请选择你的星座");
        messageLabel.setBounds(31,25,130,15);
        root.add(messageLabel);

        String[] constellations = {"白羊座","金牛座","双子","巨蟹","狮子","处女","天平","天蝎","射手","魔蝎","双鱼","水平"};

        comboBox = new JComboBox(constellations);
        comboBox.setBounds(130,22,100,21);
        root.add(comboBox);

        jList = new JList(constellations);
        js = new JScrollPane(jList);
        js.setBounds(130,44,100,105);
        root.add(js);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400,300,310,230);
        setVisible(true);

    }

    public static void main(String[] args) {
        new JComboBoxTest("星座");
    }
}
