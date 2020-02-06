package gui.one;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener {
    
    private final JButton leftButton;
    private final JButton middleButton;
    private final JButton rightButton;
    
    public ButtonPanel() {
        ImageIcon leftButtonIcon = createImageIcon("right.gif");
        leftButton = new JButton("Disable button in the middle", leftButtonIcon);
        leftButton.setVerticalTextPosition(AbstractButton.CENTER);
        leftButton.setHorizontalTextPosition(AbstractButton.LEADING);
        leftButton.setMnemonic(KeyEvent.VK_D);
        leftButton.setActionCommand("disable");
        leftButton.addActionListener(this);
        
        ImageIcon middleButonIcon = createImageIcon("middle.gif");
        middleButton = new JButton("Victim/Middle", middleButonIcon);
        middleButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        middleButton.setHorizontalTextPosition(AbstractButton.CENTER);
        middleButton.addActionListener(this);
        
        ImageIcon rightImageIcon = createImageIcon("left.gif");
        rightButton = new JButton("Enable button in the middle", rightImageIcon);
        rightButton.setMnemonic(KeyEvent.VK_E);
        rightButton.setActionCommand("enable");
        rightButton.addActionListener(this);
        
        add(leftButton);
        add(middleButton);
        add(rightButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if ("disable".equals(actionCommand)) {
            middleButton.setEnabled(false);
            leftButton.setEnabled(false);
            rightButton.setEnabled(true);
        } else if("enable".equals(actionCommand)){
            middleButton.setEnabled(true);
            rightButton.setEnabled(false);
            leftButton.setEnabled(true);
        }else{
            System.out.println("Sigurno je žrtva pozvala ovaj action listener a ona nema pravo glasa. Zato i jeste zrtva");
        }
    }

    //URL -> Uniform Resource Location
    private ImageIcon createImageIcon(String fileName) {
        URL imageURL = ButtonPanel.class.getResource(fileName);
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
        JFrame frame = new JFrame("Demonstracija korištenja dugmića");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setOpaque(true);
        frame.setContentPane(buttonPanel);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(ButtonPanel::createAndShowGUI);
    }
}
