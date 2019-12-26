/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced.four.io;

/**
 *
 * @author Grupa2
 */
public class DemoExecutor {
    public static void main(String[] args) {
        //1. 1.7 je prisutan ARM-Automatic Resource Managment
        //2. <1.7
         //TRY-WITH-RESOURCE
        try(Demo demo = new Demo()){

        }catch(Exception e){
            System.out.println();
        }
    }
}
