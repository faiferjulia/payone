package de.faifer.codecate.payone;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * The class represents discount
 * Created by IntelliJ IDEA.
 * User: juliafaifer
 */
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Discount {

    /**
     * @param value New value for this Discount
     * @param quantity New quantity for this Discount
     */
     private int value;
     private int quantity;

    /**
     * Calculate discount for the given quantity
     * @param quantity New quantity
     * */
    protected int calculate_for(int quantity){
        return java.lang.Math.floorDiv(quantity , this.quantity) * value;
    }

}
