package com.platypus.testing_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RLE_Test {
    private RLE rle;

    @BeforeEach
    void setUp(){
        rle = new RLE();
    }

    @Test
    void encode(){
        String encoded = rle.encode("AAABBC");
        Assertions.assertEquals("3A2B1C", encoded);
    }

    @Test
    void decode(){
        String decoded = rle.decode("3A2B1C");
        Assertions.assertEquals("AAABBC", decoded);
    }

    @Test
    void incorrect_input(){
        String input1_encode = "3AA2B";
        String input2_encode = "";
        String input1_decode = "0A1B";
        String input2_decode = "";

        Assertions.assertThrows(IllegalArgumentException.class, () -> rle.encode(input1_encode));
        Assertions.assertThrows(IllegalArgumentException.class, () -> rle.encode(input2_encode));
        Assertions.assertThrows(IllegalArgumentException.class, () -> rle.encode(input1_decode));
        Assertions.assertThrows(IllegalArgumentException.class, () -> rle.encode(input2_decode));

    }
}
