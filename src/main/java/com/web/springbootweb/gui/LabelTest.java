package com.web.springbootweb.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @description:  要求：首先将窗口标题修改为 “添加标签”，然后创建一个带有指定文本的标签对象，并为标签添加一幅图像，设置标签内容的显示位置，
 *                     最后将标签设置为不可用，并设置标签在不可用的情况下显示另一幅图像。
 *
 *                下面的代码运行时会显示射箭的图标，
 *                在射箭不可用的情况下，文字标签也会显示撑灰色(不可用)
 *
 *                如果将 label.setDisabledIcon(new ImageIcon("src/main/resources/射箭.png")); 注释掉，会显示灰色的自行车图标
 *
 *                如果我们将 label.setEnabled(false); 设置成 true，会显示彩色的自行车图标
 *
 *                这就是 JLabel 标签显示文本和图片的基本使用方法
 * @author:
 * @time: 2024/4/13 17:37
 */
public class LabelTest extends JFrame {
    JLabel label;

    public LabelTest(){
        setTitle("添加标签");

        label = new JLabel("我是一个 jlabel",JLabel.CENTER);

        label.setIcon(new ImageIcon("src/main/resources/自行车.png"));

        label.setHorizontalAlignment(JLabel.CENTER);

        label.setVerticalTextPosition(JLabel.BOTTOM);

        label.setEnabled(false);

        label.setDisabledIcon(new ImageIcon("src/main/resources/射箭.png"));

        add(label);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400,300,800,650);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LabelTest();
    }
}
