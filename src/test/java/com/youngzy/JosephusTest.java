package com.youngzy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JosephusTest {

    @Test
    public void test() {
        Josephus josephus = new Josephus();
        String result = josephus.solve(2, 7);
        assertEquals("1 3 5 0 4 2 6 ", result);
    }
}