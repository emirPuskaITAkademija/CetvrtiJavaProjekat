/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.four;

/**
 *
 * @author Grupa2
 */
public class Company implements Observer{

    public Company(Observable observable) {
        observable.registerObserver(this);
    }

    
    
    @Override
    public void update() {
        System.out.println("Kompanija je dobila notifikaciju od novina");
    }
    
}
