import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DesktopApplication {

    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Java Desktop Application");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton button = new JButton("Open the doors!");
      
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Close the dooors!");
            }
        });

        frame.getContentPane().add(button);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}