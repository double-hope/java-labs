package org.java.labs.lab7;

import java.util.Iterator;

public class CustomIterator<E> implements Iterator<E> {
    Node<E> node;

    public CustomIterator(Node<E> node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return this.node.getNext() != null;
    }

    @Override
    public E next() {
        this.node = this.node.getNext();
        return this.node.getData();
    }

}
