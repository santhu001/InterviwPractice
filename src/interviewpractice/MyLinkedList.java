/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice;

/**
 *
 * @author santhosh
 */
public class MyLinkedList<T> {

    transient int size = 0;
    transient Node<T> first;
    transient Node<T> last;

    public MyLinkedList() {
    }

    public void add(T element) {
        linkLast(element);
    }

    public void linkLast(T element) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public void linkFirst(T element) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(null, element, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    void linkBefore(T e, Node<T> succ) {
        final Node<T> pred = succ.prev;
        final Node<T> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    public void add(int index, T element) {
        //checkPositionIndex(index);

        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    public int size() {
        return size;
    }

    Node<T> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    public T get(int index) {
        return node(index).item;
    }
   public void reverse(){
    
     
       
   }
    private static class Node<T> {

        T item;
        Node<T> prev;
        Node<T> next;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
