package com.company;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Main extends JFrame {

        Main(String s, int w, int h) {
            super(s);
            setSize(w, h);
            setVisible(true);
            setLocationRelativeTo(null);
            setLayout(null);

            Label first = new Label("Введіть першу сторону трикутника:");
            first.setForeground(Color.BLUE);
            first.setFont(new Font("Serif", Font.ITALIC, 20));
            first.setBounds(30,40,325,30);
            add(first);

            Label second = new Label("Введіть другу сторону трикутника:");
            second.setForeground(Color.BLUE);
            second.setFont(new Font("Serif", Font.ITALIC, 20));
            second.setBounds(30,130,325,30);
            add(second);

            Label third = new Label("Введіть третю сторону трикутника:");
            third.setForeground(Color.BLUE);
            third.setFont(new Font("Serif", Font.ITALIC, 20));
            third.setBounds(30,220,330,30);
            add(third);

            TextField firstSide = new TextField("");
            firstSide.setBounds(400,40,100,30);
            firstSide.setFont(new Font("Serif", Font.PLAIN, 20));
            add(firstSide);

            TextField secondSide = new TextField("");
            secondSide.setBounds(400,130,100,30);
            secondSide.setFont(new Font("Serif", Font.PLAIN, 20));
            add(secondSide);

            TextField thirdSide = new TextField("");
            thirdSide.setBounds(400,220,100,30);
            thirdSide.setFont(new Font("Serif", Font.PLAIN, 20));
            add(thirdSide);

            Button submit = new Button("Розрахувати");
            submit.setForeground(Color.black);
            submit.setBackground(Color.YELLOW);
            submit.setFont(new Font("Serif", Font.PLAIN, 17));
            submit.setBounds(210,280,150,35);
            add(submit);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double a = Double.parseDouble(firstSide.getText());
                    double b = Double.parseDouble(secondSide.getText());
                    double c = Double.parseDouble(thirdSide.getText());
                    double P = a + b + c;
                    double p = (a + b + c)/2;
                    double Square = Math.sqrt(p*(p-a)*(p-b)*(p-c));
                    solve solver = new solve(P,Square,a,b,c);
                }
            });
        }

         class solve extends JFrame {
             JFrame frame = new JFrame("Window 2");

             public solve(double P, double Square, double a, double b, double c) {
                 frame.setSize(500, 230);
                 frame.setVisible(true);
                 frame.setLocationRelativeTo(null);
                 frame.addWindowListener(new WindowAdapter() {
                     public void windowClosing(WindowEvent ev) {
                         System.exit(0);
                     }
                 });

                 JPanel draw = new JPanel();
                 draw.setBackground(new Color(223, 186, 155));
                 draw.setBounds(10,10,400,230);
                 frame.add(draw);

                 if ((a+b) <= c || (b+c) <= a || (c+a) <= b) {
                     Label exception = new Label("* Трикутник із заданими сторонами не існує *");
                     Label exception2 = new Label("** Сума двох сторін менша або '=' третій стороні **");
                     Label exception3 = new Label("*** Введіть правильні значення ***");
                     exception.setForeground(new Color(140, 0, 0));
                     exception2.setForeground(new Color(140, 0, 0));
                     exception3.setForeground(new Color(140, 0, 0));
                     exception.setFont(new Font("Arial", Font.PLAIN, 19));
                     exception2.setFont(new Font("Arial", Font.PLAIN, 19));
                     exception3.setFont(new Font("Arial", Font.PLAIN, 19));
                     draw.add(exception);
                     draw.add(exception2);
                     draw.add(exception3);
                 }
                 else {
                     Label perimeter = new Label("Периметр трикутника = " + P);
                     perimeter.setForeground(Color.BLUE);
                     perimeter.setFont(new Font("Arial", Font.PLAIN, 22));
                     draw.add(perimeter);

                     Label SUM = new Label("Площа трикутника = " + Square);
                     SUM.setForeground(new Color(0, 96, 0));
                     SUM.setFont(new Font("Arial", Font.PLAIN, 22));
                     draw.add(SUM);
                 }
             }
         }

    public static void main(String[] args) {
        Main Frame = new Main("Window 1", 600, 390);
        Frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
    }
}
