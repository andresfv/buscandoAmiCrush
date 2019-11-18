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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    public MatrixGUI() {
        setjPanel(getJButton());
        setKeyPressEvent();
        this.add(jPanel);
        setTommy();
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
            this.jPanel.setBounds(10, 10, 1550, 920);
        }
        jPanel.setVisible(true);

        return jPanel;
    }

    public void getJFrame() {
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

    public void setTommy() {
        jButton[10][10].setText("Tommy");
        jButton[10][10].setOpaque(true);
        jButton[10][10].setBackground(Color.red);
    }

    public JButton getTommy() {
        return jButton[10][10];
    }

    public void moveTommy() {
        //Permite detectar el presionado de tecla

    }

    public void setKeyPressEvent() {
        jPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    getTommy().setBackground(Color.blue);
                    jFrame.revalidate();
                    jFrame.repaint();
                    System.out.println("ENTER!!!");
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

}
