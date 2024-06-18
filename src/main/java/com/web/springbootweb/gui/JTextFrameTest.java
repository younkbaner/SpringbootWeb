package com.web.springbootweb.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @description:
 * @author: ywz
 * @time: 2024/4/14 17:48
 */
public class JTextFrameTest extends JFrame {

    JPanel root;
    JLabel userNameLabel,passwordLabel;
    JTextField userTextField;

    JPasswordField passWordTextField;
    JButton enterButton,closeButton;

    JTextArea textArea;

    public JTextFrameTest(){
        root = new JPanel();
        setContentPane(root);
        setLayout(null);

        userNameLabel = new JLabel("用户名：");
        userNameLabel.setBounds(52,33,54,15);
        root.add(userNameLabel);

        userTextField=new JTextField(12);
        userTextField.setBounds(116,30,139,21);
        root.add(userTextField);


        passwordLabel=new JLabel("密码：");
        passwordLabel.setBounds(52,74,54,15);
        root.add(passwordLabel);

        passWordTextField=new JPasswordField(12);
        passWordTextField.setBounds(116,71,139,21);
        passWordTextField.setBackground(Color.GRAY);
        passWordTextField.setEchoChar('*');
        root.add(passWordTextField);

        //登录按钮
        enterButton = new JButton("登录");
        enterButton.setBounds(64,116,69,23);
        root.add(enterButton);

        //退出按钮
        closeButton = new JButton("退出");
        closeButton.setBounds(174,116,69,23);
        root.add(closeButton);

        textArea = new JTextArea("测试文本");
        textArea.setBounds(50,155,210,92);
        textArea.setLineWrap(true);
        root.add(textArea);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400,300,340,256);
        setVisible(true);

    }

    public static void main(String[] args) {
        new JTextFrameTest();
    }
}
