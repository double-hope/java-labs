package org.java.labs;

import org.java.labs.lab7.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
    LinkedList<Integer> list1;
    LinkedList<Integer> list2;
    LinkedList<Integer> list3;

    @Before
    public void setUp(){
        list1 = new LinkedList<>();
        list2 = new LinkedList<>(2);
        list3 = new LinkedList<>(list2);
    }

    @Test
    public void testCreationWithoutArgs() {
        Integer[] result = new Integer[]{};
        Assert.assertArrayEquals("Create list without args", result, list1.toArray());
    }

    @Test
    public void testCreationWithArg() {
        Integer[] result = new Integer[]{2};
        Assert.assertArrayEquals("Create list with arg", result, list2.toArray());
    }

    @Test
    public void testCreationWithArgs() {
        Integer[] result = new Integer[]{2};
        Assert.assertArrayEquals("Create list with args", result, list2.toArray());
    }

    @Test
    public void testAdd() {
        Integer[] result = new Integer[]{2, 5};
        list2.add(5);
        Assert.assertArrayEquals("Add object to list", result, list2.toArray());
    }

    @Test
    public void testRemove() {
        Integer[] result = new Integer[]{};
        list2.remove((Object)2);
        Assert.assertArrayEquals("Add object to list", result, list2.toArray());
    }
}
