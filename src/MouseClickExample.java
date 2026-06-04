import java.awt.event.*;
import javax.swing.*;

public class MouseClickExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame jf = new JFrame("mouse click 예제");
            jf.setSize(300, 200);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel label = new JLabel("마우스를 클릭하세요", SwingConstants.CENTER);

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label.setText("마우스가 클릭되었습니다!");
                }

                @Override
                public void mouseEntered(MouseEvent e) {}

                @Override
                public void mouseExited(MouseEvent e) {}

                @Override
                public void mousePressed(MouseEvent e) {}
            });

            jf.add(label);
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);
        });
    }
}