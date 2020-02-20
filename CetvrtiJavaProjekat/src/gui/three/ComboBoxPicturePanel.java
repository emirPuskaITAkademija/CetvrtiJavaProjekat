package gui.three;

import gui.two.RadioButtonPanel;
import java.awt.BorderLayout;
import java.awt.Component;
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

public class ComboBoxPicturePanel extends JPanel {

    private ImageIcon[] images;
    private String[] petStrings = {"Bird", "Cat", "Dog", "Pig", "Rabbit"};

    public ComboBoxPicturePanel() {
        super(new BorderLayout());
        images = new ImageIcon[petStrings.length];
        Integer[] imageNumberArray = new Integer[petStrings.length];
        for(int i = 0; i<petStrings.length; i++){
            imageNumberArray[i] = i;
            images[i] = createImageIcon(petStrings[i]);
        }
        JComboBox<Integer> petList = new JComboBox<>();
        petList.setRenderer(new ComboBoxRenderer());
        add(petList, BorderLayout.PAGE_START);
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

    class ComboBoxRenderer extends JLabel implements ListCellRenderer<Integer> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Integer> list, Integer value, int index, boolean isSelected, boolean cellHasFocus) {
            int selectedIndex = value;
            if(isSelected){
                
            }
            
            ImageIcon imageIcon = images[index];
            String itemText = petStrings[index];
            setIcon(imageIcon);
            setText(itemText);
            return this;
        }
    }
    
        private static void createAndShowGUI() {
        //1. PROZOR ili JFRAME
        JFrame frame = new JFrame("Combo box editabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //2. kreirati kontrole i pobacati kako nam kaže neki manager LayoutManager
        JComponent comboBoxPanel = new ComboBoxPicturePanel();
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
