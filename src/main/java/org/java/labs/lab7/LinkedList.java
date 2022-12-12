package org.java.labs.lab7;

import java.util.*;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> node;
    private Node<T> tail;
    private int size = 0;
    public LinkedList(){
        this.head = null;
        this.node = null;
        this.tail = null;
    }

    public LinkedList(T t){
        this.add(t);
    }

    public LinkedList(Collection<? extends T> c){
        this.addAll(c);
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !(this.size > 0);
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (current.getData() == o) {
                return true;
            } else {
                current = current.getNext();
            }
        }
        return false;
    }

    @Override
    public CustomIterator<T> iterator() {
        return new CustomIterator<>(new Node<>(null, this.node));
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        Node<T> current = this.head;
        for (int i = 0; i < this.size; i++) {
            array[i] = current.getData();
            current = current.getNext();
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        for (int i = 0; i < this.size; i++) {
            a[i] = (T1) this.get(i);
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        Node<T> current = this.head;
        Node<T> newNode = new Node<>(t, null);

        for (int i = 0; i < this.size; i++) {
            if (i == this.size - 1) {
                current.setNext(newNode);
            } else {
                current = current.getNext();
            }
        }

        if (this.size == 0) {
            this.head = newNode;
            this.node = newNode;
        }

        this.tail = newNode;
        this.size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> previous = null;
        Node<T> current = this.head;
        Node<T> next = this.head.getNext();

        for (int i = 0; i < this.size; i++) {
            if (current.getData() == o) {
                if (previous == null)
                    this.head = next;
                else
                    previous.setNext(next);
                this.size--;
                return true;
            } else {
                previous = current;
                current = current.getNext();
                next = next.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!this.contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Node<T> previous;
        Node<T> current = this.head;
        if (current == null) {
            addAllCollection(c, null);
        } else {
            for (int i = 0; i < this.size; i++) {
                if (i == this.size - 1) {
                    previous = current;
                    addAllCollection(c, previous);
                } else {
                    current = current.getNext();
                }
            }
        }

        this.size += c.size();
        return true;
    }

    private void addAllCollection(Collection<? extends T> c, Node<T> previous){
        for (T t: c) {
            Node<T> current = new Node<>(t, null);
            this.tail = current;
            if (this.head == null) {
                this.head = current;
                this.node = this.head;
            }
            if (previous != null) previous.setNext(current);
            previous = current;
        }
    }
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Node<T> previous = null;
        Node<T> current = this.head;
        Node<T> newNode;

        for (int i = 0; i < this.size; i++) {
            if (index == i) {
                for (T t: c) {
                    newNode = new Node<>(t, null);
                    if (previous != null) {
                        previous.setNext(newNode);
                        previous = previous.getNext();
                    }
                }
                if (previous != null) previous.setNext(current);
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        this.size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object element: c) {
            int index = this.indexOf(element);
            if (index >= 0) {
                this.remove(index);
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < this.size; i++) {
            if (!c.contains(this.get(i))) {
                this.remove(this.get(i));
                i--;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head = null;
        this.node = null;
        this.tail = null;
    }

    @Override
    public T get(int index) {
        Node<T> current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                break;
            } else {
                current = current.getNext();
            }
        }

        return current.getData();
    }

    @Override
    public T set(int index, T element) {
        Node<T> current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                current.setData(element);
                break;
            } else {
                current = current.getNext();
            }
        }
        return current.getData();
    }

    @Override
    public void add(int index, T element) {
        Node<T> previous = null;
        Node<T> current = this.head;

        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                if (previous != null) previous.setNext(new Node<>(element, current));
                else this.head = new Node<>(element, current);
                this.size++;
                break;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
    }

    @Override
    public T remove(int index) {
        Node<T> previous = null;
        Node<T> current = this.head;
        Node<T> next = this.head.getNext();

        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                if (previous == null)
                    this.head = next;
                else
                    previous.setNext(next);
                this.size--;
                break;
            } else {
                previous = current;
                current = current.getNext();
                next = next.getNext();
            }
        }

        return current.getData();
    }

    @Override
    public int indexOf(Object o) {
        Node<T> current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (current.getData() == o) {
                return i;
            } else {
                current = current.getNext();
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> current = this.head;
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (current.getData() == o) {
                index = i;
            } else {
                current = current.getNext();
            }
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subList = new LinkedList<>();
        Node<T> current = this.head;

        for (int i = 0; i <= toIndex; i++) {
            if (i >= fromIndex) {
                subList.add(current.getData());
            }
            current = current.getNext();
        }

        return subList;
    }
}
