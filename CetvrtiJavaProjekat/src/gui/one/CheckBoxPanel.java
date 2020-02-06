package gui.one;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * preduvjet : 16 fajlova odnosno sličica: 4 na 2 = 16
 * 
 * geek-----.gif
 * geek-c---.gif -> chinCheckBox
 * geek--g--.gif -> glassCheckBox
 * geek-cght.gif-> chinCheckBox, glassesCheckBox, hairCheckBox, teethCheckBox
 * 
 * @author Grupa2
 */
public class CheckBoxPanel extends JPanel implements ItemListener{
    private JCheckBox chinCheckBox;
    private JCheckBox glassesCheckBox;
    private JCheckBox hairCheckBox;
    private JCheckBox teethCheckBox;
    
    private JLabel pictureLabel;
    private StringBuffer pictureName;

    public CheckBoxPanel() {
        super(new BorderLayout());
        //create check boxes
        chinCheckBox = new JCheckBox("Chin");
        chinCheckBox.setMnemonic(KeyEvent.VK_C);
        chinCheckBox.setSelected(true);
        glassesCheckBox = new JCheckBox("Glasses");
        glassesCheckBox.setMnemonic(KeyEvent.VK_G);
        glassesCheckBox.setSelected(true);
        hairCheckBox = new JCheckBox("Hair");
        hairCheckBox.setMnemonic(KeyEvent.VK_H);
        hairCheckBox.setSelected(true);
        teethCheckBox = new JCheckBox("Teeth");
        teethCheckBox.setMnemonic(KeyEvent.VK_T);
        teethCheckBox.setSelected(true);
        //pridruziti listener
        chinCheckBox.addItemListener(this);
        glassesCheckBox.addItemListener(this);
        hairCheckBox.addItemListener(this);
        teethCheckBox.addItemListener(this);
        //ime slike
        pictureName = new StringBuffer("cght");
        //picture labela
        pictureLabel = new JLabel();
        pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));
        updatePicture();
        
        //Trebamo pobacati check boxes u JPanel koji se nalazi LINE_START
        JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));
        checkBoxPanel.add(chinCheckBox);
        checkBoxPanel.add(glassesCheckBox);
        checkBoxPanel.add(hairCheckBox);
        checkBoxPanel.add(teethCheckBox);
        
        add(checkBoxPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
        
    }
    
    
//cght
    @Override
    public void itemStateChanged(ItemEvent e) {
        int index = 0;
        char c = '-';
        Object source = e.getItemSelectable();
        if(source == chinCheckBox){
            index = 0;
            c = 'c';
        }else if(source == glassesCheckBox){
            index = 1;
            c = 'g';
        }else if( source == hairCheckBox){
            index = 2;
            c = 'h';
        }else if(source == teethCheckBox){
            index = 3;
            c = 't';
        }
        if(e.getStateChange() == ItemEvent.DESELECTED){
            c = '-';
        }
        pictureName.setCharAt(index, c);
        updatePicture();
    }

    private void updatePicture() {
        String fileName = "geek-"+pictureName.toString()+".gif";
        ImageIcon imageIcon = createImageIcon(fileName);
        pictureLabel.setIcon(imageIcon);
        pictureLabel.setToolTipText(pictureName.toString());
        if(imageIcon == null){
            pictureLabel.setText("Missing Image Icon file");
        }else{
            pictureLabel.setText(null);
        }
    }
    
     //URL -> Uniform Resource Location
    private ImageIcon createImageIcon(String fileName) {
        URL imageURL = CheckBoxPanel.class.getResource(fileName);
        System.out.println(imageURL);
        if (imageURL != null) {
            return new ImageIcon(imageURL);
        } else {
            System.err.printf("Ne mogu pronaći ikonicu u tvom projektu koja se zove '%s'%n", fileName);
            return null;
        }
    }
    
    /**
     * *create an show UI*
     */
    static void createAndShowGUI() {
        JFrame frame = new JFrame("Demonstracija korištenja check box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CheckBoxPanel checkBoxPanel = new CheckBoxPanel();
        checkBoxPanel.setOpaque(true);
        frame.setContentPane(checkBoxPanel);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(CheckBoxPanel::createAndShowGUI);
    }
}
