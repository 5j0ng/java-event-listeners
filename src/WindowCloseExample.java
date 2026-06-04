import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowCloseExample extends JFrame {

    public WindowCloseExample() {
        this.setTitle("버튼으로 종료");
        this.setSize(300, 150);
        // 창의 X 버튼을 눌러도 즉시 종료되지 않도록 설정
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JButton exitButton = new JButton("프로그램 종료");
        
        // 버튼 클릭 시 종료 확인창 호출
        exitButton.addActionListener(e -> checkAndClose());

        // 창의 X 버튼 클릭 시 종료 확인창 호출
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                checkAndClose();
            }
        });

        this.add(exitButton);
        this.setVisible(true);
    }

    private void checkAndClose() {
        // 종료 확인 팝업창
        int result = JOptionPane.showConfirmDialog(
                this, 
                "정말로 프로그램을 종료하시겠어요?", 
                "종료 확인", 
                JOptionPane.YES_NO_OPTION
        );

        // 사용자가 '예'를 선택한 경우
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();    // 현재 프레임 자원 해제
            System.exit(0);    // 프로그램 전체 종료
        }
    }

    public static void main(String[] args) {
        // Swing 프로그램은 이벤트 디스패치 스레드(EDT)에서 실행하는 것이 안전합니다.
        SwingUtilities.invokeLater(() -> new WindowCloseExample());
    }
}