package advanced.one;

public class Util {

    //Generički tip na nivou statičke funkcije
    public static <S, U> boolean comparePair(Pair<S, U> pair1, Pair<S, U> pair2) {
        return pair1.getKey().equals(pair2.getKey()) &&
                pair1.getValue().equals(pair2.getValue());
    }
}
