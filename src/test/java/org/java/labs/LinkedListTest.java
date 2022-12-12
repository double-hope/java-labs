package org.java.labs;

import org.java.labs.lab7.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
    LinkedList<Integer> list1;
    LinkedList<Integer> list2;
    LinkedList<Integer> list3;
    LinkedList<Integer> testList;

    @Before
    public void setUp(){
        list1 = new LinkedList<>();
        list2 = new LinkedList<>(2);
        list3 = new LinkedList<>(list2);

        testList = new LinkedList<>();
        testList.add(1);
        testList.add(2);
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
        list2.remove(0);
        Assert.assertArrayEquals("Add object to list", result, list2.toArray());
    }
    @Test
    public void testRemoveObject() {
        Integer[] result = new Integer[]{};
        list2.remove((Object)2);
        Assert.assertArrayEquals("Add object to list", result, list2.toArray());
    }

    @Test
    public void testClear() {
        Integer[] result = new Integer[]{};
        list2.clear();
        Assert.assertArrayEquals("Add object to list", result, list2.toArray());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue("Test list is empty", list1.isEmpty());
        Assert.assertFalse("Test list is empty", list2.isEmpty());
    }

    @Test
    public void testContains() {
        Assert.assertTrue("Test list contains object", list2.contains(2));
        Assert.assertFalse("Test list contains object", list2.contains(1));
    }

    @Test
    public void testSet() {
        Integer[] result = new Integer[]{3};
        list2.set(0, 3);
        Assert.assertArrayEquals("Set object in list", result, list2.toArray());

        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list2.set(1, 3));
    }

    @Test
    public void testAddAll() {
        Integer[] result = new Integer[]{2, 1, 2};
        list2.addAll(testList);

        Assert.assertArrayEquals("Add collection to list", result, list2.toArray());
    }
    @Test
    public void testAddWithIndex() {
        Integer[] result = new Integer[]{1, 2};
        list2.add(0, 1);

        Assert.assertArrayEquals("Add collection to list", result, list2.toArray());
    }
    @Test
    public void testGet() {
        Integer result = 2;
        Assert.assertEquals("Get object from list", result, list2.get(0));
    }
    @Test
    public void testIndexOf() {
        list1.add(1);
        list1.add(2);
        list1.add(1);
        Integer result = 0;
        Integer actual = list1.indexOf(1);
        Assert.assertEquals("Get first index of object in list", result, actual);
    }
    @Test
    public void testLastIndexOf() {
        list1.add(1);
        list1.add(2);
        list1.add(1);
        Integer result = 2;
        Integer actual = list1.lastIndexOf(1);
        Assert.assertEquals("Get first index of object in list", result, actual);
    }
}
