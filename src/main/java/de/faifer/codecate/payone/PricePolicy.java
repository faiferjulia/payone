package de.faifer.codecate.payone;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * The class represents price policy
 * Created by IntelliJ IDEA.
 * User: juliafaifer
 */
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PricePolicy {

    /**
     * @param start_price New start_price
     * @param discounts Discounts
     */
    private int start_price;
    Discount discounts;

    /**
     * Constructor
     * @param start_price The new start_price
     * */
    public PricePolicy(int start_price){
        this.start_price = start_price;
    }

    /**
     * Calculate price for the given quantity
     * @param quantity New quantity
     * */
    protected int price_for(int quantity){
        return  quantity * this.start_price - discount_for(quantity);
    }

    /**
     * Calculate discount for the given quantity
     * @param quantity New quantity
     * @return discount value
     * */
    protected int discount_for(int quantity){
        try {
            return discounts.calculate_for(quantity);
        }catch (java.lang.NullPointerException e){ }

        return 0;
    }

}
