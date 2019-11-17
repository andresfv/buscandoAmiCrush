/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

//import javax.swing.JFrame;
//import javax.swing.JTable;
//import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Luis Andrés Fallas Valenciano
 */
public class MatrixGUI extends JFrame {

    private JPanel jPanel;
    private JButton[][] jButton;

    public MatrixGUI() {
        //buildMatrix();
        setjPanel(getJButton());
        add(jPanel);
        setTommy();
        iniciarJFrame();

    }

    public JPanel setjPanel(JButton[][] matriz) {
        if (jPanel == null) {
            jPanel = new JPanel();
            jPanel.setBorder(new LineBorder(new Color(255, 165, 0)));
            jPanel.setBackground(Color.WHITE);
            jPanel.setLayout(new GridLayout(20, 20));
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    jPanel.add(matriz[i][j]);

                }
            }
            this.jPanel.setBounds(10, 10, 1550, 920);
        }
        jPanel.setVisible(true);

        return jPanel;
    }

    public void iniciarJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1600, 1000);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Buscando a mi Crush");
    }

    public JButton[][] getJButton() {
        if (jButton == null) {
            jButton = new JButton[20][20];
            for (int i = 0; i < jButton.length; i++) {
                for (int j = 0; j < jButton.length; j++) {
                    jButton[i][j] = new JButton();
                    jButton[i][j].setName(i + "," + j);
                    jButton[i][j].setContentAreaFilled(false);
                    jButton[i][j].setBackground(Color.GRAY);
                    jButton[i][j].setOpaque(true);
                }
            }
        }
        return jButton;
    }

    public void setTommy() {
        jButton[10][10].setText("Tommy");
        jButton[10][10].setOpaque(true);
        jButton[10][10].setBackground(Color.red);

    }

    public void moveTommy() {

    }

}
