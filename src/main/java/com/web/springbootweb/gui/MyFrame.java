package com.web.springbootweb.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @description:
 * @author: ywz
 * @time: 2024/4/13 16:40
 */
public class MyFrame extends JFrame {

    public MyFrame(){

        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.white);

        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);



        JLabel label = new JLabel("这是一个 jFrame 窗体");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(label);

        JButton button = new JButton("点我弹出对话框");
        button.setBounds(10,10,150,20);
        button.addActionListener(e->new MyJDialog(MyFrame.this).setVisible(true));

        container.add(button);

        setVisible(true);


    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
