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
public class Bank<C extends ICard>{
    
    private final C card;
    
    public Bank(C card){
        this.card = card;
    }
    public void pay(double amount){
        card.validate();
        card.getMoney(amount);
    }
}
