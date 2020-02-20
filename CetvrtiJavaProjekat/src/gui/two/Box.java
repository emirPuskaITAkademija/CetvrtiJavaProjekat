/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.two;
//1. bounded i unbounded -> genericki tipovi
//2. WILDCARDS - dzokerski tipovi
//2.1 unbounded 
//2.2 upper bounded
//2.3 lower bounded
import java.util.Collection;
import java.util.List;

public class Box<T> {
    private T field;
    //private ? field1;
    
    
    //metoda
    public List<? extends Collection> getList(){
        return null;
    }
}
