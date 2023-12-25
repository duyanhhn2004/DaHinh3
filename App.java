import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.*;

public class App {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Da Hinh 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(640, 480);

        Layer layer = new Layer();
        layer.addShape(new Circle(new Point(50, 50), 30, Color.RED, true, 5, 5));
        layer.addShape(new Circle(new Point(300, 150), 30, Color.RED, true, 5, 5));
        layer.addShape(new Rectangle(new Point(400, 100), 100, 70, Color.BLUE, true, 5, 5));
        layer.addShape(new Square(new Point(300, 300), 100, Color.YELLOW, true, 5, 5));
        frame.add(layer);

        Timer timer = new Timer(15, e -> layer.move(frame.getWidth(), frame.getHeight()));
        timer.start();

        frame.setVisible(true);
    }
}
