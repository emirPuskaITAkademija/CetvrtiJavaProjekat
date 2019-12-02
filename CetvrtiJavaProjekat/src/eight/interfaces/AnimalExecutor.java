package eight.interfaces;

import javax.swing.JOptionPane;

public class AnimalExecutor {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        makeNoise(dog);
        makeNoise(cat);
        eatFood(dog);
        eatFood(cat);
        
        dogExecutor(dog);
        //dogExecutor(cat);
        JOptionPane.showInputDialog("Unesite nesto");
        
    }
    static void dogExecutor(Dog dog){
        System.out.println("Ja sam pas i ponosan sam na to");
    }

    static void makeNoise(NoiseMaker noiseMaker) {
        System.out.println("Noise maker making noise: " + noiseMaker.makeNoise());
    }

    static void eatFood(FoodEater foodEater) {
        System.out.println("Food eater eating food: ");
        foodEater.eat();
    }
}
