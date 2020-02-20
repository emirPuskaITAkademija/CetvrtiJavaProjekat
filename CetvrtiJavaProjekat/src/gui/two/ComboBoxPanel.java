package gui.two;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
//1. JFrame   GLAVNI PRVI DIO 
// GLAVNI DRUGI DIO
//2. u okno sa sadržajem JPanel
//3. u JPanel ubacujemo kontrole
//4. JButton, JLabel, JComboBox, JCheckBox...->kontrole
//GLAVNI TRECI DIO - kako ubaciti te kontrole u taj panel ??? horizontalno, vertikalno, grid, border
//LayoutManager
//5. LayoutManager(BorderLayout, BoxLayout, GridLayout)

public class ComboBoxPanel extends JPanel implements ActionListener {

    private final JLabel pictureLabel;

    public ComboBoxPanel() throws SQLException {
        super(new BorderLayout());
        PetDAO petDAO = new PetDAO();
        String[] petNames = petDAO.getAll().stream()//Stream<Pet>
                .map(Pet::getName)//Stream<String>
                .toArray(String[]::new);//String[] 
        //{"Bird", "Cat", "Dog", "Pig", "Rabbit"};
        //JComponent
        JComboBox<String> petComboBox = new JComboBox<>(petNames);
        petComboBox.setSelectedIndex(4);
        petComboBox.addActionListener(this);

        this.pictureLabel = new JLabel();
        updatePictureLabel(petNames[petComboBox.getSelectedIndex()]);

        //
        add(petComboBox, BorderLayout.PAGE_START);
        add(pictureLabel, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //poziv ovog bloka koda će biti kroz padajući meni
        JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
        String petName = (String) comboBox.getSelectedItem();
        updatePictureLabel(petName);
    }

    private void updatePictureLabel(String petName) {
        ImageIcon imageIcon = createImageIcon(petName);
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

    private static void createAndShowGUI() throws SQLException {
        //1. PROZOR ili JFRAME
        JFrame frame = new JFrame("Combo box demonstration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //2. kreirati kontrole i pobacati kako nam kaže neki manager LayoutManager
        JComponent comboBoxPanel = new ComboBoxPanel();
        comboBoxPanel.setOpaque(true);
        frame.setContentPane(comboBoxPanel);

        //3. prikazati prozor
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (SQLException ex) {
                Logger.getLogger(ComboBoxPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
