package JavaAdvanced.Generics.Exercise.CustomListIterator_09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T>{

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }
    public void add (T element) {
        this.data.add(element);
    }
    public T remove (int index) {
        checkIndex(index);
        return this.data.remove(index);
    }
    public boolean contains (T element) {
        return this.data.contains(element);
    }
    public void swap (int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);

        T firstElement = this.data.get(firstIndex);
        T secondElement = this.data.get(secondIndex);

        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }
    public int countGreaterThan(T element) {
        int count = 0;

        for (T elements : this.data) {
            if (elements.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }
    public T getMax() {
        checkEmpty();

        T max = this.data.get(0);
        for (T elements : this.data) {
            if (elements.compareTo(max) > 0) {
                max = elements;
            }
        }
        return max;
    }
    public T getMin() {
        checkEmpty();

        T min = this.data.get(0);
        for (T elements : this.data) {
            if (elements.compareTo(min) < 0) {
                min = elements;
            }
        }
        return min;
    }
    public void forEach(Consumer<? super T> consumer) {
        this.data.forEach(consumer);
    }
    public int getSize() {
        return this.data.size();
    }
    public T get(int index) {
        checkIndex(index);
        return this.data.get(index);

    }

    private void checkEmpty() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.data.size()) {
            throw  new IndexOutOfBoundsException(
                    String.format("Index %d is out of bounds for size %d", index, this.data.size()));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
