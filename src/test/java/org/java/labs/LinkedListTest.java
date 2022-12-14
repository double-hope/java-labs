package org.java.labs;

import org.java.labs.lab7.LinkedList;
import org.java.labs.lab8.IndexNotExistsException;
import org.java.labs.lab8.IndexesOrderException;
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
    public void constructor_passNoArguments_createsEmptyList(){
        Integer[] result = new Integer[]{};
        Assert.assertArrayEquals("Create list without args", result, list1.toArray());
    }

    @Test
    public void constructor_passOneArgument_createsListWithOneArgument() {
        Integer[] result = new Integer[]{2};
        Assert.assertArrayEquals("Create list with arg", result, list2.toArray());
    }

    @Test
    public void constructor_passListOfArgument_createsListWithPassedArguments() {
        Integer[] result = new Integer[]{2};
        Assert.assertArrayEquals("Create list with args", result, list2.toArray());
    }

    @Test
    public void add_addingOneElementInList_elementAdded() {
        Integer[] result = new Integer[]{2, 5};
        list2.add(5);
        Assert.assertArrayEquals("Add object to list", result, list2.toArray());
    }
    @Test
    public void addWithIndex_addingCollectionInTheFirstPlaceOfList_collectionAdded() {
        Integer[] result = new Integer[]{1, 2};
        list2.add(0, 1);
        Assert.assertArrayEquals("Add collection to list", result, list2.toArray());
    }
    @Test
    public void addWithIndex_addingCollectionInTheMiddleOfList_collectionAdded() {
        Integer[] result = new Integer[]{1, 3, 2};
        list2.add(0, 1);
        list2.add(1, 3);
        Assert.assertArrayEquals("Add collection to list", result, list2.toArray());
    }
    @Test
    public void addWithIndex_addingCollectionWithNonExistentIndex_IndexNotExistsException() {
        Assert.assertThrows(IndexNotExistsException.class, () -> list2.add(5, 1));
    }
    @Test
    public void addAll_addingCollectionToList_collectionAdded() {
        Integer[] result = new Integer[]{2, 1, 2};
        list2.addAll(testList);
        Assert.assertArrayEquals("Add collection to list", result, list2.toArray());
    }
    @Test
    public void addAll_addingCollectionToFilledList_collectionAdded() {
        Integer[] result = new Integer[]{2, 1, 2, 1, 2};
        list2.addAll(testList);
        list2.addAll(testList);
        Assert.assertArrayEquals("Add collection to list", result, list2.toArray());
    }
    @Test
    public void addAllWithIndex_addingCollectionInTheFirstPlaceOfList_collectionAdded() {
        Integer[] result = new Integer[]{1, 2, 2};
        list2.addAll(0, testList);
        Assert.assertArrayEquals("Add collection to list", result, list2.toArray());
    }

    @Test
    public void addAllWithIndex_addingCollectionInTheMiddleOfList_collectionAdded() {
        Integer[] result = new Integer[]{1, 1, 2, 2, 2};
        list2.addAll(0, testList);
        list2.addAll(1, testList);
        Assert.assertArrayEquals("Add collection to list", result, list2.toArray());
    }
    @Test
    public void addAllWithIndex_addingCollectionWithNonExistentIndex_IndexNotExistsException() {
        Assert.assertThrows(IndexNotExistsException.class, () -> list2.addAll(5, testList));
    }

    @Test
    public void remove_removeMiddleNodeInList_nodeRemoved() {
        Integer[] result = new Integer[]{2};
        list2.add(3);
        list2.remove(1);
        Assert.assertArrayEquals("Add object to list", result, list2.toArray());
    }
    @Test
    public void remove_removeFirstNodeInList_nodeRemoved() {
        Integer[] result = new Integer[]{};
        list2.remove(0);
        Assert.assertArrayEquals("Remove object from list", result, list2.toArray());
    }
    @Test
    public void removeObject_removeObjectInList_returnTrue() {
        Assert.assertTrue("Remove object from list", list2.remove((Object)2));
    }
    @Test
    public void removeObject_removeObjectInMiddleOfList_returnTrue() {
        list2.add(3);
        Assert.assertTrue("Remove object from list", list2.remove((Object)3));
    }
    @Test
    public void removeObject_removeNonExistentObjectInList_returnFalse() {
        Assert.assertFalse("Remove object from list", list2.remove((Object)4));
    }
    @Test
    public void clear_clearList_listCleaned() {
        Integer[] result = new Integer[]{};
        list2.clear();
        Assert.assertArrayEquals("Add object to list", result, list2.toArray());
    }

    @Test
    public void isEmpty_checkIsListEmpty_returnTrue() {
        Assert.assertTrue("Test list is empty", list1.isEmpty());
    }
    @Test
    public void isEmpty_checkIsListEmpty_returnFalse() {
        Assert.assertFalse("Test list is empty", list2.isEmpty());
    }

    @Test
    public void contains_checkListContainsObject_returnTrue() {
        Assert.assertTrue("Test list contains object", list2.contains(2));
    }

    @Test
    public void contains_checkListContainsObject_returnFalse() {
        Assert.assertFalse("Test list contains object", list2.contains(1));
    }
    @Test
    public void containsAll_checkListContainsAllObjectsFromCollection_returnTrue() {
        Assert.assertTrue("Test list contains collection", list2.containsAll(list3));
    }
    @Test
    public void containsAll_checkListContainsAllObjectsFromCollection_returnFalse() {
        Assert.assertFalse("Test list contains collection", list2.containsAll(testList));
    }
    @Test
    public void set_setFirstElementInList_elementSet() {
        Integer[] result = new Integer[]{3};
        list2.set(0, 3);
        Assert.assertArrayEquals("Set object in list", result, list2.toArray());
    }
    @Test
    public void set_setMiddleElementInList_elementSet() {
        Integer[] result = new Integer[]{3, 2};
        list2.set(0, 3);
        list2.add(0);
        list2.set(1, 2);
        Assert.assertArrayEquals("Set object in list", result, list2.toArray());
    }
    @Test
    public void set_setNonExistentElementInList_IndexNotExistsException() {
        Assert.assertThrows(IndexNotExistsException.class, () -> list2.set(1, 3));
    }

    @Test
    public void get_getFirstObjectInList_returnObject() {
        Integer result = 2;
        Assert.assertEquals("Get object from list", result, list2.get(0));
    }

    @Test
    public void get_getObjectInMiddleOfList_returnObject() {
        list2.add(3);
        Integer result = 3;
        Assert.assertEquals("Get object from list", result, list2.get(1));
    }
    @Test
    public void indexOf_getFirstIndexOfObjectInList_returnFirstIndex() {
        list1.add(1);
        list1.add(2);
        list1.add(1);
        Integer result = 0;
        Integer actual = list1.indexOf(1);
        Assert.assertEquals("Get first index of object in list", result, actual);
    }
    @Test
    public void indexOf_getIndexOfNonExistentObjectInList_returnNegativeIndex() {
        list1.add(1);
        Integer result = -1;
        Integer actual = list1.indexOf(3);
        Assert.assertEquals("Get first index of object in list", result, actual);
    }
    @Test
    public void lastIndexOf_getLastIndexOfObjectInList_returnLastIndex() {
        list1.add(1);
        list1.add(2);
        list1.add(1);
        Integer result = 2;
        Integer actual = list1.lastIndexOf(1);
        Assert.assertEquals("Get first index of object in list", result, actual);
    }
    @Test
    public void lastIndexOf_getLastIndexOfNonExistentObjectInList_returnNegativeIndex() {
        list1.add(1);
        list1.add(2);
        list1.add(1);
        Integer result = -1;
        Integer actual = list1.lastIndexOf(3);
        Assert.assertEquals("Get first index of object in list", result, actual);
    }

    @Test
    public void toArray_createsAnArrayWithTypeT1_returnCreatedArray() {
        Integer[] result = new Integer[list2.size()];
        result = list2.toArray(result);
        Assert.assertArrayEquals("Create array from list", result, list2.toArray());
    }

    @Test
    public void removeAll_removeAllObjectsFromCollection_returnListWithoutObjectsFromCollection() {
        Integer[] result = new Integer[]{3};
        list2.add(3);
        list2.removeAll(list3);
        Assert.assertArrayEquals("Remove all colection from list", result, list2.toArray());
    }

    @Test
    public void retainAll_retainAllObjectsFromCollection_returnRetainedList() {
        Integer[] result = new Integer[]{2};
        list2.add(3);
        list2.retainAll(list3);
        Assert.assertArrayEquals("Remove all collection from list", result, list2.toArray());
    }

    @Test
    public void sublist_createSublistFromList_returnSublist() {
        LinkedList<Integer> result = new LinkedList<>(list2);
        LinkedList<Integer> actual = list2.subList(0, list2.size());
        Assert.assertArrayEquals("Create sublist", result.toArray(), actual.toArray());
    }
    @Test
    public void sublist_createSublistFromListWithNonExistentIndex_IndexNotExistsException() {
        Assert.assertThrows(IndexNotExistsException.class, () -> list2.subList(0, list2.size() + 1));
    }
    @Test
    public void sublist_createSublistFromListWithStartIndexLessThanEndIndex_IndexesOrderException() {
        Assert.assertThrows(IndexesOrderException.class, () -> list2.subList(list2.size(), 0));
    }
}
