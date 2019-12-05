/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced.one;


public class BoxUser {
    public static void main(String[] args) {
        Box<String> fadilBox = new Box<>();
        fadilBox.setObject("Fadil is on the phone");
        fadilBox.inspect(23);
    }
}
