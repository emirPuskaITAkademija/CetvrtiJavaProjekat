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
public class BankUser {
    public static void main(String[] args) {
        Bank<Master> bank1 = new Bank<>(new Master());
        bank1.pay(100);
        Bank<Visa> bank2 = new Bank<>(new Visa());
        bank2.pay(1000);
    }
}
