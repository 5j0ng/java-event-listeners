import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ItemListenerExample extends JFrame {
    public ItemListenerExample() {
        this.setTitle("Item 이벤트 리스너 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        this.setSize(300, 150);

        JCheckBox agreeCheckBox = new JCheckBox("동의");
        JButton finishButton = new JButton("완료");
        finishButton.setEnabled(false); // 초기에는 버튼 비활성화

        agreeCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 체크박스의 상태에 따라 버튼 활성화/비활성화
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    finishButton.setEnabled(true);
                } else {
                    finishButton.setEnabled(false);
                }
            }
        });
        this.add(agreeCheckBox);
        this.add(finishButton);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ItemListenerExample());
    }
}