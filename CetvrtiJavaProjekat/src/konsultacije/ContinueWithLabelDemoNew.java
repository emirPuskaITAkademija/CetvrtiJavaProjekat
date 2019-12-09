/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsultacije;
// NE BROJI DOBRO

import javax.swing.JOptionPane;

public class ContinueWithLabelDemoNew {

    public static void main(String[] args) {
        String recenica = JOptionPane.showInputDialog("Unesi rečenicu");
        String rijec = JOptionPane.showInputDialog("Unesi riječ");
        int brojac = 0;
        int max = recenica.length() - rijec.length();
        labeliranaPetlja:
        for (int i = 0; i <=max; i++) {
            int k = i;
            for (int j = 0; j < rijec.length(); j++) {
                if (recenica.charAt(k++) != rijec.charAt(j)) {
                    continue labeliranaPetlja;
                }
            }
            brojac++;
        }
        JOptionPane.showMessageDialog(null, "Riječ " + rijec + " se  pojavljuje " + brojac + " puta");
    }
}
