import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

import java.awt.Desktop;
import java.io.*;

public class PockerCards extends JPanel {

    private static final long serialVersionUID = 1L;

    private JPanel[][] squares;
    JButton button = new JButton("Shuffle");
    String cardsName[][];

    public PockerCards() {
        try {
            GridLayout gridLay = new GridLayout(0, 13); 
            setLayout(gridLay);
            squares = new JPanel[4][13];

            setPreferredSize(new Dimension(20 * 4, 20 * 13));
            cardsName = new String[4][13];
            String faces[] = new String[] { "C", "D", "H", "S" };
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++) {
                    if (j == 0) {
                        cardsName[i][j] = "A" + faces[i] + ".png";
                    } else if (j == 10) {
                        cardsName[i][j] = "J" + faces[i] + ".png";
                    } else if (j == 11) {
                        cardsName[i][j] = "Q" + faces[i] + ".png";
                    } else if (j == 12) {
                        cardsName[i][j] = "K" + faces[i] + ".png";
                    } else {
                        cardsName[i][j] = (j + 1) + faces[i] + ".png";
                    }

                }
            }
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {
                    ImageIcon icon = new ImageIcon("src\\cards\\" + cardsName[i][j]);
                    Image scaleImage = icon.getImage().getScaledInstance(55, 75, Image.SCALE_DEFAULT);
                    JLabel wIcon = new JLabel(new ImageIcon(scaleImage));

                    squares[i][j] = new JPanel();
                    squares[i][j].add(wIcon);

                    add(squares[i][j]);
                    squares[i][j].setBackground(new Color(10, 108, 3));

                }
            }
            
            // comment this out if you want to 
            add(button);
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    Random rand = new Random();
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 13; j++) {
                            int row = rand.nextInt(4);
                            int col = rand.nextInt(13);

                            int row1 = rand.nextInt(4);
                            int col1 = rand.nextInt(13);

                            String name = cardsName[row][col];
                            cardsName[row][col] = cardsName[row1][col1];
                            cardsName[row1][col1] = name;

                            squares[i][j].removeAll();
                            ImageIcon icon = new ImageIcon("src\\cards\\" + cardsName[i][j]);
                            Image scaleImage = icon.getImage().getScaledInstance(55, 75, Image.SCALE_DEFAULT);
                            JLabel wIcon = new JLabel(new ImageIcon(scaleImage));
                            squares[i][j].add(wIcon);
                            squares[i][j].repaint();
                        }
                    }
                    revalidate();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayCards(){
        JFrame window = new JFrame();
        window.setSize(1500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.getContentPane().add(new PockerCards());
        window.setVisible(true);


    }

    public static void main(String[] a) {  
        displayCards();

    }
}
