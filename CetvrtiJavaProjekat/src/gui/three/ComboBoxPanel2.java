package gui.three;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ComboBoxPanel2 extends JPanel implements ActionListener {

    private String currentPattern;
    private JLabel dateTimeViewResultLabel;

    public ComboBoxPanel2() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //pattern koji se koristi prilikom rada s formatiranjem vremena
        String[] patterns = {
            "dd MMMMM yyyy",
            "dd.MM.yy",
            "MM/dd/yy",
            "yyyy.MM.dd G 'at' hh:mm:ss z",
            "EEE, MMM d, \"yy",
            "h::mm a",
            "H:mm:ss:SSS",
            "K:mm a,z",
            "yyyy.MMMMM.dd GGG hh:mm aaa"
        };
        currentPattern = patterns[0];
        //labele da korisnik zna šta mu je činiti
        JLabel comboBoxLabel1 = new JLabel("Enter pattern as string or");
        JLabel comboBoxLabel2 = new JLabel("select one from the list");

        JComboBox<String> patternListComboBox = new JComboBox<>(patterns);
        patternListComboBox.setEditable(true);
        patternListComboBox.addActionListener(this);

        //CREATE UI za prikazivanje vremena po odabranom patternu u combo boxu
        JLabel dateViewLabel = new JLabel("Current Date/Time", JLabel.LEADING);//LEFT
        dateTimeViewResultLabel = new JLabel("");

        //POSLOZIT OVO SVE U PANELE
        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.PAGE_AXIS));
        patternPanel.add(comboBoxLabel1);
        patternPanel.add(comboBoxLabel2);
        patternListComboBox.setAlignmentX(LEFT_ALIGNMENT);
        patternPanel.add(patternListComboBox);

        JPanel dateTimeViewPanel = new JPanel();
        dateTimeViewPanel.setLayout(new GridLayout(0, 1));
        dateTimeViewPanel.add(dateViewLabel);
        dateTimeViewPanel.add(dateTimeViewResultLabel);
        dateTimeViewResultLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        patternPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dateTimeViewPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        add(patternPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(dateTimeViewPanel);

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        reformat();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
        String newPattern = (String) comboBox.getSelectedItem();
        currentPattern = newPattern;
        reformat();
    }

    private void reformat() {
        Date today = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat(currentPattern);

        String formattedToday = dateFormatter.format(today);
        dateTimeViewResultLabel.setText(formattedToday);
    }

    private static void createAndShowGUI() {
        //1. PROZOR ili JFRAME
        JFrame frame = new JFrame("Combo box editabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //2. kreirati kontrole i pobacati kako nam kaže neki manager LayoutManager
        JComponent comboBoxPanel = new ComboBoxPanel2();
        comboBoxPanel.setOpaque(true);
        frame.setContentPane(comboBoxPanel);

        //3. prikazati prozor
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
