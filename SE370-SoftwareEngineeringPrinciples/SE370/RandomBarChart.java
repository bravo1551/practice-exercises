import java.util.Random;
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class RandomBarChart extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        int rows = 10;
        int cols = 10;
        
        int originX = 40;
        int originY = 40;
        int cellSide = 30;
        
        Random rand = new Random();
        Color[] colorArr = {Color.RED,Color.WHITE,Color.BLUE,Color.YELLOW,Color.PINK,Color.GREEN};

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);

        for (int i = 0; i < rows+1; i++){
            g2.draw(new Line2D.Double(originX, originY + i * cellSide, originX + cols * cellSide, originY + i * cellSide));
        }
        for (int i = 0; i < cols+1; i++){
            g2.draw(new Line2D.Double(originX + i * cellSide, originY, originX + i * cellSide, originY + rows * cellSide));
        }
        
        g2.setStroke(new BasicStroke(10));
        for(int i = 0; i < 12; i++){
            g2.setColor(colorArr[rand.nextInt(colorArr.length)]);
            g2.draw(new Line2D.Double(i*25+50, 335-rand.nextInt(275), i*25+50, 335));
        }
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        JButton redraw = new JButton("Redraw");
        redraw.setSize(50, 50);
        RandomBarChart rbc = new RandomBarChart();
        JFrame jf = new JFrame();
        
        jf.setTitle("Random Bar Chart");
        jf.setSize(400, 450);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jf.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.PAGE_START; //top of space
        c.ipady = 20;      //make this component tall
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        jf.add(rbc, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.gridx = 0;
        c.gridy = 1;
        jf.add(redraw, c);
    }
}
