/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsultacije;

import java.util.Iterator;

/**
 *
 * @author Grupa2
 */
public class GenericExecutor<T extends Number> implements Iterable<T> {

    private T[] elements;

    public GenericExecutor(int size) {
        elements = (T[]) new Number[size];
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public static void main(String[] args) {
        Number[] numbers = new Number[3];
        numbers[0] = new Integer(10);
        numbers[1] = new Float(1f);
        GenericExecutor kontejner1 = new GenericExecutor(23);
        Iterator iterator1 = kontejner1.iterator();
        Integer numbers1 = (Integer) iterator1.next();

        GenericExecutor<Integer> kontejner = new GenericExecutor<>(12);
        Iterator<Integer> iterator = kontejner.iterator();
        Integer number2 = iterator.next();

    }
}
