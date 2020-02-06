package advanced.seven;

/**
 * Singleton - još ga zovu antipatternom jer koristi statičku metodu
 * Closed for modification and open for extension.
 * @author Grupa2
 */
public enum SingletonFadil {
    FADIL_TOSKIC;

    public static SingletonFadil get() {
        return FADIL_TOSKIC;
    }
}
