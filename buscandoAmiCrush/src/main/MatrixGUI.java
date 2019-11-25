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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Luis Andrés Fallas Valenciano
 */
public class MatrixGUI extends JFrame {

    private JFrame jFrame = this;
    private JPanel jPanel;
    private JButton[][] jButton;
    private JButton leftButton;
    private JButton rigthButton;
    private JButton upButton;
    private JButton downButton;
    private Tommy tommy;

    public MatrixGUI() {
        setjPanel(getJButton());
        setLeftButton("L");
        setRigthButton("R");
        setUpButton("U");
        setDownButton("D");
        tommy = new Tommy();
        refreshTommyPosition();
        this.add(leftButton);
        this.add(rigthButton);
        this.add(upButton);
        this.add(downButton);
        this.add(jPanel);

        getJFrame();
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
            this.jPanel.setBounds(10, 10, 1200, 800);
        }
        jPanel.setVisible(true);

        return jPanel;
    }

    public void getJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1450, 880);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Buscando a mi Crush");
    }

    public JButton[][] getJButton() {
        if (jButton == null) {
            jButton = new JButton[20][20];
            llenaMatriz(jButton, 0, 0);
        }
        return jButton;
    }

    /**
     * Usa recursividad para llenar la matriz.
     *
     * @param matriz
     * @param i
     * @param j
     */
    public JButton[][] llenaMatriz(JButton[][] matriz, int i, int j) {
        jButton[i][j] = new JButton();
        jButton[i][j].setName(i + "," + j);
        jButton[i][j].setContentAreaFilled(false);
        jButton[i][j].setBackground(Color.GRAY);
        jButton[i][j].setOpaque(true);

        //Mientras las filas no lleguen a su tope -1 y las columnas no sean igual al tope de filas -1 de la matriz
        if (i != matriz.length - 1 || j != matriz[i].length - 1) {
            //Si el número de columna es igual al tope de filas -1 de la matriz
            if (j == matriz[i].length - 1) {
                i++;
                j = 0;

            } else {
                j++;
            }

            llenaMatriz(matriz, i, j);
        }
        return jButton;
    }

    public void setLeftButton(String button) {
        this.leftButton = new JButton(button);
        this.leftButton.setBounds(1250, 250, 50, 50);
        this.leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cleanLastTommyPosition();
                tommy.setY(tommy.getY() - 1);
                if (tommy.getY() < 0) {
                    tommy.setY(jButton.length - 1);
                }
                refreshTommyPosition();
                refreshJframe();
            }
        });
    }

    public JButton getLeftButton() {

        return leftButton;

    }

    public void setRigthButton(String button) {

        this.rigthButton = new JButton(button);
        this.rigthButton.setBounds(1350, 250, 50, 50);

    }

    public JButton getRigthButton() {

        return rigthButton;

    }

    public void setUpButton(String button) {

        this.upButton = new JButton(button);
        this.upButton.setBounds(1300, 200, 50, 50);
    }

    public JButton getUpButton() {

        return upButton;

    }

    public void setDownButton(String button) {

        this.downButton = new JButton(button);
        this.downButton.setBounds(1300, 300, 50, 50);
    }

    public JButton getDownButton() {

        return downButton;

    }

    public void cleanLastTommyPosition() {
        int x = tommy.getX();
        int y = tommy.getY();

        jButton[x][y].setText("");
        jButton[x][y].setBackground(Color.GRAY);
    }

    public void refreshTommyPosition() {
        int x = tommy.getX();
        int y = tommy.getY();

        jButton[x][y].setText("Tommy");
        jButton[x][y].setBackground(Color.red);
    }

    public void refreshJframe() {
        jFrame.revalidate();
        jFrame.repaint();
    }
}
