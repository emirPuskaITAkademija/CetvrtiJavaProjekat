package gui.seven;

import gui.two.RadioButtonPanel;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestFrame extends JFrame {

    private JPanel panel;

    public TestFrame(JPanel panel)  {
        this.panel = panel;
    }

    public void showFrame() {
        setTitle("Test"); 
        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        JPanel animalPanel = new RadioButtonPanel();
        TestFrame testFrame = new TestFrame(animalPanel);
        SwingUtilities.invokeLater(testFrame::showFrame);
    }
}
