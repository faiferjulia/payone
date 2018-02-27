package de.faifer.codecate.payone;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * The class represents rules of price policy with discounts for the checkout process
 * Created by IntelliJ IDEA.
 * User: juliafaifer
 */
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public class Rules {


    private Map<Character, PricePolicy> rules = new HashMap<Character, PricePolicy>();

    /**
     * Constructor
     * */
    public Rules(){
        rules.put('A', new PricePolicy(50, new Discount(20,3)));
        rules.put('B', new PricePolicy(30, new Discount(15,2)));
        rules.put('C', new PricePolicy(20));
        rules.put('D', new PricePolicy(15));
    }

}
