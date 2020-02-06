/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced.seven;

import java.lang.reflect.Constructor;

public class SingletonReflectionExecutor {

    public static void main(String[] args) throws Exception {
        SingletonExecutor singletonExecutor = new SingletonExecutor();
        SingletonExecutor.ObjectPrinter printer = singletonExecutor.new ObjectPrinter();
        //SINGLETON LAZY
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        printer.print("singleton lazy1", singletonLazy1);
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        printer.print("singleton lazy2", singletonLazy2);
        //REFLEKSIJA
        //Class clazz = Class.forName("advanced.seven.SingletonLazy");
        Class clazz = SingletonLazy.class;
        Constructor<SingletonLazy> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonLazy singletonLazyDuplikatFadilov = constructor.newInstance();
        printer.print("duplikat", singletonLazyDuplikatFadilov);

        //
        System.out.println("IDE EAGER singleton");
        //SINGLETON EAGER
        SingletonEager singleton1 = SingletonEager.getInstance();
        printer.print("singleton1", singleton1);
        SingletonEager singleton2 = SingletonEager.getInstance();
        printer.print("singleton2", singleton2);
        Class clazz1 = singleton1.getClass();
        Constructor<SingletonEager> constructorEagerToskic = clazz1.getDeclaredConstructor();
        constructorEagerToskic.setAccessible(true);
        SingletonEager drugiToskic = constructorEagerToskic.newInstance();
        printer.print("drugi toskic", drugiToskic);
    }
}
