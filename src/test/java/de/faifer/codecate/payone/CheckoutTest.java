package de.faifer.codecate.payone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;


class CheckoutTest {

    @org.junit.jupiter.api.Test
    int price(String goods){
        Rules rules = new Rules();
        Checkout co = new Checkout (rules.getRules());

        char[] charArray = goods.toCharArray();
        for (char item : charArray) {
            co.scan(item);
        }
        return co.total();
    }

    @org.junit.jupiter.api.Test
    void scan() {

        assertEquals(  0, price(""));
        assertEquals( 50, price("A"));
        assertEquals( 80, price("AB"));
        assertEquals(115, price("CDBA"));

        assertEquals(100, price("AA"));
        assertEquals(130, price("AAA"));
        assertEquals(180, price("AAAA"));
        assertEquals(230, price("AAAAA"));
        assertEquals(260, price("AAAAAA"));

        assertEquals(160, price("AAAB"));
        assertEquals(175, price("AAABB"));
        assertEquals(190, price("AAABBD"));
        assertEquals(190, price("DABABA"));
    }

    @org.junit.jupiter.api.Test
    void testIncremental(){
        Rules rules = new Rules();
        Checkout co = new Checkout (rules.getRules());

        co.scan('A'); assertEquals( 50, co.total());
        co.scan('B'); assertEquals( 80, co.total());
        co.scan('A'); assertEquals( 130, co.total());
        co.scan('A'); assertEquals( 160, co.total());
        co.scan('B'); assertEquals( 175, co.total());
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }


}