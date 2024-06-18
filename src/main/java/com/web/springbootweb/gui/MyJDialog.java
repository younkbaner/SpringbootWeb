package com.web.springbootweb.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @description:
 * @author: ywz
 * @time: 2024/4/13 16:36
 */
public class MyJDialog extends JDialog {

    public MyJDialog(MyFrame frame) {
        super(frame, "JDialog窗体");

        Container container = getContentPane();

        container.add(new JLabel("这是一个对话框"));

        setBounds(120, 120, 150, 100);
    }
}
