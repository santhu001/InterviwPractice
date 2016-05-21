/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice;

import interviewpractice.salestax.Cart;
import interviewpractice.salestax.CartImpl;
import interviewpractice.salestax.Item;
import interviewpractice.salestax.ItemImpl;
import interviewpractice.salestax.ItemType;

/**
 *
 * @author santhosh
 */
public class SalesTaxEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Item item1=new ItemImpl("Book", ItemType.TAX_EXEEMPTED, 12.49);
        Item item2=new ItemImpl("Music CD", ItemType.OTHERS, 14.99);
        
        Item item3=new ItemImpl("Chocolate bar", ItemType.TAX_EXEEMPTED, .85);
        Cart cart=new CartImpl();
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.printBill();
    }
    
}
