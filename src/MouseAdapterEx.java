import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseAdapterEx extends JFrame {
    private JLabel la = new JLabel("hi");

    public MouseAdapterEx() {
        setTitle("마우스예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        la.setSize(50, 20);
        la.setLocation(30, 30);
        c.add(la);

        c.addMouseListener(new MyMouseAdapter());

        setSize(250, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);
        }
    }

    public static void main(String[] args) {
        new MouseAdapterEx();
    }
}