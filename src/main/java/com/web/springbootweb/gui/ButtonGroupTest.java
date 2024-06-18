package com.web.springbootweb.gui;

import javax.swing.*;

/**
 * @description: 下面的代码是构建一个窗口，里面增加了四个按钮，借助按钮组实现按钮的单选功能，在选中一个按钮的时候，其他按钮自动取消勾选
 * @author: ywz
 * @time: 2024/4/14 16:43
 */
public class ButtonGroupTest extends JFrame {

    JPanel root;

    JRadioButton radioButton,jRadioButton_1,jRadioButton_2,jRadioButton_3;

    public ButtonGroupTest(){


        root = new JPanel();  //定义面板容器

        setContentPane(root);   //设置面板为绝对布局

        setLayout(null);

        //构造四个按钮
        radioButton = new JRadioButton("按键 ");

        jRadioButton_1 = new JRadioButton("按键 1");

        jRadioButton_2 = new JRadioButton("按键 2");

        jRadioButton_3 = new JRadioButton("按键 2");

        radioButton.setBounds(45,29,73,23);

        jRadioButton_1.setBounds(134,29,121,23);

        jRadioButton_2.setBounds(45,74,72,23);

        jRadioButton_3.setBounds(134,74,121,23);

        root.add(radioButton);
        root.add(jRadioButton_1);
        root.add(jRadioButton_2);
        root.add(jRadioButton_3);

        ButtonGroup buttonGroup = new ButtonGroup();

        buttonGroup.add(radioButton);

        buttonGroup.add(jRadioButton_1);

        buttonGroup.add(jRadioButton_2);

        buttonGroup.add(jRadioButton_3);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setBounds(400,300,271,161);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonGroupTest();
    }
}
