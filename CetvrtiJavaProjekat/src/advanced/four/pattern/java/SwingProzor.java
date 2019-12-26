package advanced.four.pattern.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

//OBSERVER
public class SwingProzor {

    private JFrame frame;

    public void show() {
        frame = new JFrame("Demonstracija OBSERVER korištenja u Java swing paketu");
        JButton button = new JButton("Should I do it ? ");
        button.setSize(200, 200);
        Font font = new Font("Ubuntu", Font.PLAIN, 18);
        button.setFont(font);
        AngelListener angelListener = new AngelListener();
        DevilListener devilListener = new DevilListener();
        ActionListener lambdaAngel = this::glasAndjela;
        ActionListener lambdaDevil = this::glasDjavola;
        button.addActionListener(angelListener);
        button.addActionListener(devilListener);
        button.addActionListener(lambdaAngel);
        button.addActionListener(lambdaDevil);
        frame.getContentPane().add(BorderLayout.PAGE_END, button);
        //frame.getContentPane().add(button);
        frame.setSize(400, 400);
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    
    private void glasAndjela(ActionEvent e){
        System.out.println("Nemoj bolan");
    }
    
    private void glasDjavola(ActionEvent e){
        System.out.println("Ma uradi to. Pusti kajanje");
    }

    class AngelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Živ bio nemoj to radit. Pokajaćeš se!!!");
        }
    }

    class DevilListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Uradi to a pusti ba kajanje!!!");
        }
    }
}
