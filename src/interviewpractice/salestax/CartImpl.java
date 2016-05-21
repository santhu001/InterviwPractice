/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice.salestax;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santhosh
 */
public class CartImpl implements Cart {

    private final List<Item> cart;
    double totalAmount = 0;
    double totalTax = 0;

    public CartImpl() {
        this.cart = new ArrayList<>();
    }

    @Override
    public void addItem(Item item) {
        cart.add(item);
    }

    @Override
    public void removeItem(Item item) {
        cart.remove(item);
    }

    private double getTaxAmount(Item item) {
        switch (item.getItemType()) {
            case OTHERS:
                return (item.getItemPrice() * 10) / 100;
            case IMPORTED:
                return (item.getItemPrice() * 5) / 100;
            default:
                return 0;
        }
    }

    @Override
    public void printBill() {

        cart.stream().forEach((_item) -> {
            System.out.println(_item.getItemDescription() + ":" + _item.getItemPrice() + " : " + _item.getNoOfUnits() + " units");
            System.out.println(_item.getItemDescription() + "  Tax is  :" + getTaxAmount(_item));
            totalAmount += _item.getItemPrice();
            totalTax += getTaxAmount(_item);
        });
        System.out.println("Total : " + totalAmount);
        System.out.println("sales tax :" + totalTax);
        System.out.println("Total Bill :" + (totalAmount + totalTax));
    }

    @Override
    public void clear() {
        cart.clear();
    }
}
