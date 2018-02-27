package de.faifer.codecate.payone;

public class Main {

    public static void main(String[] args) {
        Rules rules = new Rules();
        Checkout co = new Checkout(rules.getRules());
        String goods = "AAABBD";
        char[] charArray = goods.toCharArray();
        char[] var5 = charArray;
        int var6 = charArray.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            char item = var5[var7];
            System.out.println("Character " + item);
            co.scan(item);
        }

        System.out.println("Total price " + co.total());
    }
}
