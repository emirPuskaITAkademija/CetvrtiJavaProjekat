package gui.three;

import gui.two.RadioButtonPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 * 1. JFrame 2. Controls -> JButton, JComboBox, JCheckBox.. 3. LayoutManager
 *
 * - Programiraj u interfejs a ne u konkretnu klasu
 *
 * @author Grupa2
 */
public class ComboBoxPicturePanel extends JPanel {

    private ImageIcon[] images;
    private String[] petStrings = {"Bird", "Cat", "Dog", "Pig", "Rabbit"};

    public ComboBoxPicturePanel() {
        super(new BorderLayout());
        images = new ImageIcon[petStrings.length];
        Integer[] intArray = new Integer[petStrings.length];
        for (int i = 0; i < petStrings.length; i++) {
            intArray[i] = i;
            images[i] = createImageIcon(petStrings[i]);
        }
        JComboBox<Integer> petComboBox = new JComboBox<>(intArray);
        ComboBoxRenderer renderer = new ComboBoxRenderer();
        renderer.setPreferredSize(new Dimension(200, 130));
        petComboBox.setRenderer(renderer);
        add(petComboBox, BorderLayout.PAGE_START);
        setOpaque(true);
    }

    public ImageIcon createImageIcon(String pictureName) {
        String fileName = pictureName + ".gif";//Bird.gif, Cat.gif, Dog.gif
        URL imageURL = ComboBoxPicturePanel.class.getResource(fileName);
        System.out.println(imageURL);
        if (imageURL != null) {
            return new ImageIcon(imageURL);
        } else {
            System.err.printf("Ne mogu pronaći ikonicu u tvom projektu koja se zove '%s'%n", fileName);
            return null;
        }
    }

    private class ComboBoxRenderer extends JLabel implements ListCellRenderer<Integer> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Integer> list, Integer value, int index, boolean isSelected, boolean cellHasFocus) {
            //index parametar nije uvijek validan
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            ImageIcon imageIcon = images[value];
            String itemText = petStrings[value];
            if (imageIcon != null) {
                setIcon(imageIcon);
                setText(itemText);
            }else{
                setText("Ne postoji slika");
            }

            return this;
        }
    }
}
