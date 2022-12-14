package org.java.labs;

import org.java.labs.lab7.LinkedList;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        LinkedList<Integer> list1 = new LinkedList<>();
        System.out.println("Create LinkedList with empty constructor: " + Arrays.toString(list1.toArray()));
        list1.add(3);
        list1.add(10);
        list1.add(21);
        list1.add(3);
        System.out.println("Add 4 elements in LinkedList: " + Arrays.toString(list1.toArray()));

        System.out.println("Get index of Object 3 in LinkedList: " + list1.indexOf(3));
        System.out.println("Get last index of Object 3 in LinkedList: " + list1.lastIndexOf(3));

        list1.remove((Object)3);
        System.out.println("Remove Object 3 from LinkedList: " + Arrays.toString(list1.toArray()));
        System.out.println("Check is LinkedList empty: " + list1.isEmpty());
        System.out.println("Check is LinkedList contains Object 21: " + list1.contains(21));
        System.out.println("Get from LinkedList 1st element: " + list1.get(1));
        System.out.println("LinkedList before setting to 1st element 13 value: " + Arrays.toString(list1.toArray()));
        list1.set(1, 13);
        System.out.println("LinkedList after setting to 1st element 13 value: " + Arrays.toString(list1.toArray()));
        list1.clear();
        System.out.println("Clear LinkedList: " + Arrays.toString(list1.toArray()));

        LinkedList<Integer> list2 = new LinkedList<>(1);
        System.out.println("Create LinkedList2 with constructor with one element: " + Arrays.toString(list2.toArray()));
        list2.add(2);
        list2.add(3);
        list2.add(4);

        list1.add(5);
        list1.addAll(list2);
        System.out.println("LinkedList after adding Object and Collection: " + Arrays.toString(list1.toArray()));
        list1.removeAll(list2);
        System.out.println("LinkedList after removing all in LinkedList2: " + Arrays.toString(list1.toArray()));
        list1.addAll(list2);
        list1.retainAll(list2);
        System.out.println("LinkedList after retaining all in LinkedList2: " + Arrays.toString(list1.toArray()));
        list1.addAll(list2);
        System.out.println("Check is LinkedList contains all Objects from LinkedList2: " + list1.containsAll(list2));

        List<Integer> list3 = list1.subList(0, 1);
        System.out.println("Create sublist from LinkedList: " + Arrays.toString(list3.toArray()));

        System.out.println("Iterate LinkedList:");
        for (Integer i : list1) {
            System.out.println(i);
        }

        System.out.println("Create array from LinkedList:");
        Integer[] a = new Integer[list1.size()];
        a = list1.toArray(a);
        System.out.println(Arrays.toString(a));

        LinkedList<Integer> list4 = new LinkedList<>(list3);
        System.out.println("Create LinkedList4 with constructor with Collection: " + Arrays.toString(list4.toArray()));
    }
}
