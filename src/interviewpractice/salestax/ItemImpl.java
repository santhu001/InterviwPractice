/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice.salestax;

import java.util.Objects;

/**
 *
 * @author santhosh
 */
public class ItemImpl implements Item {

    private final String name;
    private final ItemType itemType;
    private final double itemPrice;
    private int noOfUnits=1;

    @Override
    public int getNoOfUnits() {
        return noOfUnits;
    }

    public ItemImpl setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
        return this;
    }

    public ItemImpl(String name, ItemType itemType, double itemPrice) {
        this.name = name;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
    }

    @Override
    public String getItemDescription() {
        return name;
    }

    @Override
    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public double getItemPrice() {
        return itemPrice*noOfUnits;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemImpl other = (ItemImpl) obj;
        if (Double.doubleToLongBits(this.itemPrice) != Double.doubleToLongBits(other.itemPrice)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return this.itemType == other.itemType;
    }

}
