/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsultacije;

/**
 *
 * @author Grupa2
 */
public class Visa implements ICard {

    @Override
    public void getMoney(double money) {
        System.out.println("Digao money = " + money);
    }

    @Override
    public boolean validate() {
        return true;
    }

}
