/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice.salestax;

/**
 *
 * @author santhosh
 */
public interface Cart {

    public void addItem(Item item);

    public void removeItem(Item item);

    public void clear();

    public void printBill();
}
