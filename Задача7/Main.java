import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException{
        JFrame frame = buildFrame();
        final BufferedImage image = ImageIO.read(new File("C:\\Users\\malik\\Desktop\\УП1\\IceCream.png"));
        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 20, 20, null);
            }
        };
        frame.add(pane);
    }
    private static JFrame buildFrame() {
        JFrame frame = new JFrame("Бокал с мороженным");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
        return frame;
    }
}
