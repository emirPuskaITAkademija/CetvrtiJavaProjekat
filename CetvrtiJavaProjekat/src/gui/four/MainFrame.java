package gui.four;

import gui.four.table.SelectionTablePanel;
import gui.four.table.SimpleTablePanel;
import gui.three.ComboBoxPanel2;
import gui.three.ComboBoxPicturePanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

    private final JComponent component;

    public MainFrame(String title, JComponent component) {
        super(title);
        this.component = component;
    }

    public void showFrame() {
        add(component);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        ComboBoxPanel2 comboBoxPanel2 = new ComboBoxPanel2();
        JButton button = new JButton("Ja sam u MainFrame");
        //
        ComboBoxPicturePanel comboBoxPicturePanel = new ComboBoxPicturePanel();
        //
        SimpleTablePanel simpleTablePanel = new SimpleTablePanel();
        SelectionTablePanel selectionTablePanel = new SelectionTablePanel();
        MainFrame mainFrame = new MainFrame("ComboBox with picture", selectionTablePanel);
        SwingUtilities.invokeLater(mainFrame::showFrame);
    }
}
