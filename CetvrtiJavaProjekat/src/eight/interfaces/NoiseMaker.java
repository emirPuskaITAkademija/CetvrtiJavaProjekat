package eight.interfaces;
//1. sva polja moraju biti public static final 
//2. interface ne moze imati definiciju public final interface 
//3. sve funkcije u interfejsu(skoro sve) su public abstract

public interface NoiseMaker {

    //polja
     String name = "Making noise";

    //public abstract se podrazumijeva
    String makeNoise();
  
    
    //Java >= 1.8
    default void printNoise(){
        System.out.println("Noise printing: " +  makeNoise());
    }
    
    public static void something(){
        
    }
}
