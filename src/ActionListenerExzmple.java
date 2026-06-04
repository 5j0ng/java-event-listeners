import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ActionListenerExzmple extends JFrame {
    static JLabel label;

    public ActionListenerExzmple() {
        this.setTitle("이벤트 처리 예제");
        this.setSize(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(20, 10));

        ActionListener listener = new ActionListener() { // 리스너 등록
            @Override
            public void actionPerformed(ActionEvent e) { // 이벤트 리스너
                String command = e.getActionCommand();

                if (command.equals("저장")) {
                    label.setText("저장: 저장을 실행!\n");
                } else if (command.equals("취소")) {
                    label.setText("취소: 작업을 취소!\n");
                }
            }
        };

        JButton saveButton = new JButton("저장");
        JButton cancelButton = new JButton("취소");
        saveButton.addActionListener(listener);
        cancelButton.addActionListener(listener);

        label = new JLabel("버튼을 클릭해 보세요.");
        this.add(saveButton, BorderLayout.WEST);
        this.add(cancelButton, BorderLayout.EAST);
        this.add(label, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ActionListenerExzmple());
    }
}