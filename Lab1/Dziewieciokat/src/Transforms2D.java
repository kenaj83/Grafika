import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.*;




public class Transforms2D extends JPanel {

    private class Display extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.translate(300,300);
            int whichTransform = transformSelect.getSelectedIndex();

//            	// Zdefiniowanie wspó³rzêdnych dziewiêciok¹ta
            int [] punktX = { 0,125,200,175,75,-75,-175,-200,-125};
    		int [] punktY = { 200,150,25,-100,-190,-190,-100,25,150};
           
            
         
            
            switch(whichTransform)
            {
                case 0: break; //widok podstawowy
                case 1: // pomniejszenie figury podstawowej
                    g2.scale(0.5,0.5);
                    break;

                case 2:
                    g2.rotate(0.5);
                    break;

                case 3:
                    g2.scale(0.5,0.8);
                    g2.rotate(Math.toRadians(180));
                    //g2.translate(0,90);
              
                   
                    break;

                case 4:
                    g2.shear(0.35,0);
                    break;

                case 5:
                    g2.scale(1,0.3);
                    g2.translate(0,-800);
                    break;

                case 6:
                    g2.shear(0,-0.5);
                    g2.rotate(Math.PI / 2);
                    break;

                case 7:
                	
                    g2.scale(0.5, 1);
                    g2.rotate(Math.PI);
                    break;

                case 8:
                    g2.rotate(Math.toRadians(30));
                    g2.scale(1,0.3);
                    g2.translate(0,200);
                    break;

                case 9:
                    g2.translate(100, 0);
                    g2.shear(0, 0.25);
                    g2.rotate(Math.PI);
                    break;

            }
            Polygon dziewiêciok¹t = new Polygon(punktX, punktY, 9);
            g2.setColor(Color.BLACK);
            g2.fillPolygon(dziewiêciok¹t);

        }
    }

    private Display display;
    private BufferedImage pic;
    private JComboBox<String> transformSelect;

    public Transforms2D() throws IOException {

        display = new Display();
        display.setBackground(Color.yellow);
        display.setPreferredSize(new Dimension(600,600));
        transformSelect = new JComboBox<String>();
        transformSelect.addItem("None");
        for (int i = 1; i < 10; i++) {
            transformSelect.addItem("No. " + i);
        }
        transformSelect.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.repaint();
            }
        });
        setLayout(new BorderLayout(3,3));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER));
        top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        top.add(new JLabel("Transform: "));
        top.add(transformSelect);
        add(display,BorderLayout.CENTER);
        add(top,BorderLayout.NORTH);
    }


    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("2D Transforms");
        window.setContentPane(new Transforms2D());
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
        window.setVisible(true);
    }

}