package de.faifer.codecate.payone;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: juliafaifer
 */
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public class Checkout {

    /**
     * @param rules Rules HashMap
     * @param items Items HashMap
     */
    @NonNull private Map<Character, PricePolicy> rules;
    private Map<Character, Integer> items;

    /**
     * Constructor
     * @param rules The given rules
     * */
    public Checkout(Map<Character, PricePolicy> rules){
       this.rules = rules;
       this.items = new HashMap<Character, Integer>();
    }

     /**
      * Scans the item and adds to the items Map
      * @param item New item
      **/
     protected void scan (Character item){

        if (items.containsKey(item))
            items.put(item, items.get(item) + 1);
        else
            items.put(item,1);

     }

     /**
      * Calculate total price
      * @return total price
      * */
     protected int total(){
         int memo = 0;

         //Calculate price for the given item and given quantity
         for (Map.Entry<Character, Integer> entry : items.entrySet()) {
             memo  = memo + price_for(entry.getKey(), entry.getValue());
         }

         return memo;
     }

     /**
      * Calculate price for the given item
      * and given quantity
      * @param item Given item
      * @param quantity    Given quantity
      * */
      private int price_for(Character item, int quantity){

        if (rules.containsKey(item))
            return rules.get(item).price_for(quantity);
        else
            System.err.print("Invalid item " + item);

        return 0;
      }

}
