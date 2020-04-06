package gui.two;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.stream.Stream;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
//DRY-Don't Repeat Yourself
//Postoji princip: razdvojiti kreiranje objekata od njihovog korištenja
public class RadioButtonPanel extends JPanel implements ActionListener {

    private final JLabel pictureLabel;
    private final ButtonGroup buttonGroup;
    private final JPanel buttonPanel;

    public RadioButtonPanel() {
        super(new BorderLayout());
        buttonGroup = new ButtonGroup();
        buttonPanel = new JPanel(new GridLayout(0, 1));
        Stream.of(AnimalButtonEnum.values()).forEach(this::createRadioButton);
        pictureLabel = new JLabel(createImageIcon(AnimalButtonEnum.BIRD.getName()));
        pictureLabel.setPreferredSize(new Dimension(187, 122));
        add(buttonPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
    }

    private JRadioButton createRadioButton(AnimalButtonEnum animalButton) {
        JRadioButton radioButton = new JRadioButton(animalButton.getName());
        radioButton.setMnemonic(animalButton.getMnemonic());
        radioButton.setActionCommand(animalButton.getCommand());
        radioButton.setSelected(animalButton.isSelected());
        radioButton.addActionListener(this);
        buttonGroup.add(radioButton);
        buttonPanel.add(radioButton);
        return radioButton;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String pictureName = event.getActionCommand();
        ImageIcon imageIcon = createImageIcon(pictureName);
        pictureLabel.setIcon(imageIcon);
    }

    public ImageIcon createImageIcon(String pictureName) {
        String fileName = pictureName + ".gif";//Bird.gif
        URL imageURL = RadioButtonPanel.class.getResource(fileName);
        System.out.println(imageURL);
        if (imageURL != null) {
            return new ImageIcon(imageURL);
        } else {
            System.err.printf("Ne mogu pronaći ikonicu u tvom projektu koja se zove '%s'%n", fileName);
            return null;
        }
    }

    private static void createAndShowGUI() {
        //1. PROZOR ili JFRAME
        JFrame frame = new JFrame("Radio button demonstration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //2. kreirati kontrole i pobacati kako nam kaže neki manager LayoutManager
        JComponent radioButtonPanel = new RadioButtonPanel();
        radioButtonPanel.setOpaque(true);
        frame.setContentPane(radioButtonPanel);

        //3. prikazati prozor
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
