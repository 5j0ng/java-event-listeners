import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseMotionExample extends JFrame {
    // 인스턴스 멤버로 변경하여 접근성 향상 (static 불필요)
    private JLabel infoLabel;

    public MouseMotionExample() {
        this.setTitle("MouseMotionListener 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLayout(new BorderLayout());

        infoLabel = new JLabel("마우스를 클릭하세요.");
        JPanel trackingPanel = new JPanel();
        trackingPanel.setBackground(new Color(255, 255, 200));

        // MouseMotionAdapter를 사용하면 필요한 메서드만 오버라이드 가능합니다.
        trackingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                infoLabel.setText("이동: (X: " + e.getX() + ", Y: " + e.getY() + ")");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                infoLabel.setText("드래그: (X: " + e.getX() + ", Y: " + e.getY() + ")");
            }
        });

        this.add(trackingPanel, BorderLayout.CENTER);
        this.add(infoLabel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MouseMotionExample());
    }
}