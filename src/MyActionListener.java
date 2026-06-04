import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyActionListener extends JFrame {
    private JButton btn;

    public MyActionListener() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        btn = new JButton("Action");
        btn.addActionListener(new MyActionListenerInner());
        c.add(btn);

        setSize(350, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class MyActionListenerInner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (b.getText().equals("Action")) {
                b.setText("액션");
            } else {
                b.setText("Action");
            }
            MyActionListener.this.setTitle(b.getText());
        }
    }
}