package nine.reference;

//1. Strong reference

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

//2. Weak reference 
//3. Soft reference
//4. Phantom reference
public class ReferenceExecutor {
    
    public static void main(String[] args) {
        Person p1 = new Person(); // strong reference
        p1.setName("Mirzad");
        System.out.println(p1.toString());
        WeakReference<Person> weakReferenceOfp1 = new WeakReference<>(p1);//weak reference
        System.out.println(weakReferenceOfp1.get());//
        System.gc();
        System.out.println(weakReferenceOfp1.get());
        SoftReference<Person> softReference = new SoftReference<>(p1); // soft
       // PhantomReference<Person> phantomReference = new PhantomReference<Person>(p1);
    }
}
