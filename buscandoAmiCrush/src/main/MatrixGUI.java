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
    private LaCrush crush;
    private int tommySteps;

    public MatrixGUI() {
        setjPanel(getJButton());
        setLeftButton("L");
        setRigthButton("R");
        setUpButton("U");
        setDownButton("D");

        tommy = new Tommy();
        crush = new LaCrush();

        int selection = positionSelector();
        initTommy(selection);
        initCrush();
        refreshTommyPosition();
        refreshCrushPosition();
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

    public int getTommySteps() {
        return tommySteps;
    }

    public void setTommySteps(int tommySteps) {
        this.tommySteps = tommySteps;
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
                if (tommy.getY() >= 1) {
                    cleanLastTommyPosition();
                    tommy.setY(tommy.getY() - 1);
                    tommySteps++;
                    moveCrush();
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
        this.rigthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tommy.getY() <= jButton.length - 2) {
                    cleanLastTommyPosition();
                    tommy.setY(tommy.getY() + 1);
                    tommySteps++;
                    moveCrush();
                }
                refreshTommyPosition();
                refreshJframe();
            }
        });

    }

    public JButton getRigthButton() {
        return rigthButton;
    }

    public void setUpButton(String button) {
        this.upButton = new JButton(button);
        this.upButton.setBounds(1300, 200, 50, 50);
        this.upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tommy.getX() >= 1) {
                    cleanLastTommyPosition();
                    tommy.setX(tommy.getX() - 1);
                    tommySteps++;
                    moveCrush();
                }
                refreshTommyPosition();
                refreshJframe();
            }
        });
    }

    public JButton getUpButton() {
        return upButton;
    }

    public void setDownButton(String button) {

        this.downButton = new JButton(button);
        this.downButton.setBounds(1300, 300, 50, 50);
        this.downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tommy.getX() <= jButton.length - 2) {
                    cleanLastTommyPosition();
                    tommy.setX(tommy.getX() + 1);
                    tommySteps++;
                    moveCrush();
                }
                refreshTommyPosition();
                refreshJframe();
            }
        });
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

    public void cleanLastCrushPosition() {
        int x = crush.getX();
        int y = crush.getY();

        jButton[x][y].setText("");
        jButton[x][y].setBackground(Color.GRAY);
    }

    public void refreshTommyPosition() {
        int x = tommy.getX();
        int y = tommy.getY();

        jButton[x][y].setText(tommy.getName());
        jButton[x][y].setBackground(Color.blue);
    }

    public void refreshCrushPosition() {
        int x = crush.getX();
        int y = crush.getY();

        jButton[x][y].setText(crush.getName());
        jButton[x][y].setBackground(Color.pink);
    }

    public void refreshJframe() {
        jFrame.revalidate();
        jFrame.repaint();
    }

    /**
     * Establece la posicion inicial de Tommy sin tomar en cuenta las esquinas.
     * Norte = 1, Sur = 2, Este = 3, Oeste = 4.
     *
     * @param position
     */
    public void initTommy(int position) {
        switch (position) {
            case 0:
                tommy.setX(0);
                tommy.setY(generaNumeroAleatorio(1, jButton.length - 2));
                break;
            case 1:
                tommy.setX(jButton.length - 1);
                tommy.setY(generaNumeroAleatorio(1, jButton.length - 2));
                break;
            case 2:
                tommy.setX(generaNumeroAleatorio(1, jButton.length - 2));
                tommy.setY(jButton.length - 1);
                break;
            case 3:
                tommy.setX(generaNumeroAleatorio(1, jButton.length - 2));
                tommy.setY(0);
                break;

            default:
                System.out.println("VALOR INVALIDO PARA INICIAR");
                break;
        }
    }

    public void initCrush() {
        crush.setX(generaNumeroAleatorio(2, jButton.length - 3));
        crush.setY(generaNumeroAleatorio(2, jButton.length - 3));
    }

    /**
     * Retorna un número aleatorio dentro de un minimo y un maximo.
     *
     * @param minimo
     * @param maximo
     * @return numeroAleatorio
     */
    public int generaNumeroAleatorio(int minimo, int maximo) {
        int numeroAleatorio = 0;
        numeroAleatorio = (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return numeroAleatorio;
    }

    /**
     * Permite seleccionar la posición inicial de Tommy.
     *
     * @return selection
     */
    public int positionSelector() {

        Object options[] = {"Norte", "Sur", "Este", "Oeste"};
        //Opciones 1, 2, 3, 4
        int selection = JOptionPane.showOptionDialog(null, "Seleccione una posición para iniciar a Tommy", "Selector de Posiciones",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "opcion 3");

        return selection;
    }

    public void moveCrush() {
        if (tommySteps % 3 == 0) {
            cleanLastCrushPosition();
            crush.setX(generaNumeroAleatorio(2, jButton.length - 3));
            crush.setY(generaNumeroAleatorio(2, jButton.length - 3));
            refreshCrushPosition();
        }
    }
}
