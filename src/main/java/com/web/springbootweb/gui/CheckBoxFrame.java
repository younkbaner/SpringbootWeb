package com.web.springbootweb.gui;

import javax.swing.*;

/**
 * @description:
 * @author: ywz
 * @time: 2024/4/14 17:39
 */
public class CheckBoxFrame extends JFrame {

    JPanel root;

    JCheckBox checkBox,checkBox_1,checkBox_2,checkBox_3;

    public CheckBoxFrame(){
        root = new JPanel();
        setContentPane(root);
        setLayout(null);

        checkBox = new JCheckBox("C语言");
        checkBox_1 = new JCheckBox("C++");
        checkBox_2 = new JCheckBox("Java");
        checkBox_3 = new JCheckBox("Python");

        //设置复选框显示位置和大小
        checkBox.setBounds(31, 28, 100, 23);
        checkBox_1.setBounds(132, 28, 100, 23);
        checkBox_2.setBounds(31, 75, 100, 23);
        checkBox_3.setBounds(132, 75, 100, 23);

        root.add(checkBox);
        root.add(checkBox_1);
        root.add(checkBox_2);
        root.add(checkBox_3);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400,300,271,161);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxFrame();
    }
}
