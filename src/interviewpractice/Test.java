/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author santhosh
 */
public class Test {

    transient Node first;
    transient int size = 0;
    transient Node last;

    private class Node {

        Node left;
        Node right;
        int val;

        public Node(Node left, int val, Node right) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

    }

    public static void main(String[] args) {
        MyLinkedList<String> list=new MyLinkedList<>();
        list.add("HI");
        list.add("Santhu");
        list.add(0,"Bye");
        System.out.println(list.size());
        System.out.println(list.get(2));
        list.reverse();
        System.out.println(list.get(2));
//        System.out.println(list.get(1));
// Test t=new Test();
//        int start = 0;
//        Scanner scanner = new Scanner(System.in);
//        int len = scanner.nextInt();
//        int[] list = new int[len];
//        while (start < len && scanner.hasNextInt()) {
//            list[start] = scanner.nextInt();
//            start++;
//        }
//        start = 0;
//        Arrays.sort(list);
////        int half = len % 2 == 0 ? (len / 2) : ((len / 2) + 1);
//        int[] tmp = new int[len];
//        int index = len - 1;
////        System.arraycopy(list, 0, tmp, 0, half - 1);
//        int pos = 0;
//        while (start < len) {
//            tmp[start] = list[pos];
//            if (start + 1 < len) {
//                tmp[start + 1] = list[index];
//            }
//            start = start + 2;
//            index--;
//            pos++;
//        }
//        start = 1;
//        int sum = 0;
//        while (start < len) {
//            sum += tmp[start] < tmp[start - 1] ? tmp[start - 1] - tmp[start] : tmp[start] - tmp[start - 1];
//            start++;
//        }
//        System.out.println(sum);
    }
//
//    private int getmaxsum() {
//        int sum = 0;
//        Scanner scanner = new Scanner(System.in);
//        int len = scanner.nextInt();
//        while (size < len && scanner.hasNextInt()) {
//            int input = scanner.nextInt();
//            final Node newNode = new Node(first, input, first);
//            final Node l = last;
//            last = newNode;
//            if (l == null) {
//                first = newNode;
//                size++;
//            } else if (input > l.val) {
//                linkLast(input,l);
//            } else {
//                linkFirst(input,l);
//            }
//
//        }
//        return sum;
//    }
//
//    public void linkLast(int input,Node next) {
//        final Node l = next.right;
//        final Node newNode = new Node(l, input, null);
//        last = newNode;
//        if (l == null) {
//            next.right = newNode;
//        } else if (input > l.val) {
//            l.right = newNode;
//        } else {
//            l.right = newNode;
//        }
//        size++;
//    }
//
//    public void linkFirst(int input, Node prev) {
//        final Node f = prev.left;
//        final Node newNode = new Node(null, input, f);
//        first = newNode;
//        if (f == null) {
//            prev.left = newNode;
//        } else if (input > f.val) {
//            f.right = newNode;
//        } else {
//            f.right = newNode;
//        }
//        size++;
//    }

    private static void getMaxIndex(int[] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[index] < arr[i]) {
                index = i;
            }

        }
        int max = arr[index];
        arr[index] = arr[arr.length / 2];
        arr[arr.length / 2] = max;

    }
}
