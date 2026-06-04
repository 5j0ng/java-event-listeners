import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyListenerEx extends JFrame {
    private JLabel[] keyMessage;

    public KeyListenerEx() {
        setTitle("KeyListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // 1. 먼저 JLabel 배열과 컴포넌트를 초기화합니다.
        keyMessage = new JLabel[3];
        keyMessage[0] = new JLabel(" getKeyCode() ");
        keyMessage[1] = new JLabel(" getKeyChar() ");
        keyMessage[2] = new JLabel(" getKeyText() ");

        for (int i = 0; i < keyMessage.length; i++) {
            // 컴포넌트의 배경색을 표시하려면 setOpaque(true)가 필수입니다.
            keyMessage[i].setOpaque(true);
            keyMessage[i].setBackground(Color.YELLOW);
            c.add(keyMessage[i]);
        }

        // 2. 컴포넌트가 준비된 후 리스너를 등록합니다.
        c.addKeyListener(new MyKeyListener());

        c.setFocusable(true);
        c.requestFocus();
        
        setVisible(true);
    }

    // 3. 내부 클래스로 리스너 정의
    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            char keyChar = e.getKeyChar();

            keyMessage[0].setText(Integer.toString(keyCode));
            keyMessage[1].setText(Character.toString(keyChar));
            keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
        }
    }

    public static void main(String[] args) {
        new KeyListenerEx();
    }
}