import javax.swing.*;
import java.awt.*;

class DrawingComponent extends JPanel {
    private int x[] = Graph.x;
    private int y[] = Graph.y;
    private int n = Graph.n;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.drawLine(280, 400, 280, 10);
        graphics2D.drawLine(-200, 340, 500, 340);
        graphics2D.drawPolyline(x, y, n);
    }
}

public class Graph extends JFrame {
    public static int[] x = {-400, -200, 0, 300};
    public static int[] y = {-200, 0, 400, -100};
    public static int n = 4;

    public Graph() {

        super("Графiк по точкам");
        for (int i = 0; i < n; i++) {
            y[i]*=-1;
            y[i]+=420;
            x[i]+=280;
        }
        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponent(), BorderLayout.CENTER);
        jcp.setBackground(Color.gray);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
