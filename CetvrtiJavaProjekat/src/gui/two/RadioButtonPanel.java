package gui.two;

import gui.one.CheckBoxPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class RadioButtonPanel extends JPanel implements ActionListener {

    static final String BIRD_NAME = "Bird";
    static final String CAT_NAME = "Cat";
    static final String DOG_NAME = "Dog";
    static final String PIG_NAME = "Pig";
    static final String RABBIT_NAME = "Rabbit";

    private final JLabel pictureLabel;

    public RadioButtonPanel() {
        super(new BorderLayout());
        //kreirati radio button
        //PTICA BIRD
        JRadioButton birdButton = new JRadioButton(BIRD_NAME);
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand(BIRD_NAME);
        birdButton.setSelected(true);
        //CAT ili mačka
        JRadioButton catButton = new JRadioButton(CAT_NAME);
        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand(CAT_NAME);
        //DOG
        JRadioButton dogButton = new JRadioButton(DOG_NAME);
        dogButton.setMnemonic(KeyEvent.VK_D);
        dogButton.setActionCommand(DOG_NAME);
        //PIG
        JRadioButton pigButton = new JRadioButton(PIG_NAME);
        pigButton.setMnemonic(KeyEvent.VK_P);
        pigButton.setActionCommand(PIG_NAME);
        //RABBIT
        JRadioButton rabbitButton = new JRadioButton(RABBIT_NAME);
        rabbitButton.setMnemonic(KeyEvent.VK_R);
        rabbitButton.setActionCommand(RABBIT_NAME);
        //GRUPU RADIO BUTTON
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(birdButton);
        buttonGroup.add(catButton);
        buttonGroup.add(dogButton);
        buttonGroup.add(pigButton);
        buttonGroup.add(rabbitButton);
        //ACTION LISTENERS
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        pigButton.addActionListener(this);
        rabbitButton.addActionListener(this);

        //PICTURE
        pictureLabel = new JLabel(createImageIcon(BIRD_NAME));
        Dimension dimension = new Dimension(187, 122);
        pictureLabel.setPreferredSize(dimension);

        JPanel radioButtonPanel = new JPanel(new GridLayout(0, 1));
        radioButtonPanel.add(birdButton);
        radioButtonPanel.add(catButton);
        radioButtonPanel.add(dogButton);
        radioButtonPanel.add(pigButton);
        radioButtonPanel.add(rabbitButton);
        
        add(radioButtonPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
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
    
    private static void createAndShowGUI(){
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
        SwingUtilities.invokeLater(()->createAndShowGUI());
    }
}
