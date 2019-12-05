package advanced.one;
// 2. bounded generic type -> MULTIPLE BOUNDING

import java.util.List;

// uvijek navodimo prvo klasu pa onda interfejse
public class BoundedBox<E, T extends String & List<E>> {

}
