package com.example.myproject.common;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ToStringBuilderTest {
    
    @Test
    public void testBuild() {
        final String expected = "ToStringBuilderTest{key1=value, key2=false, key3=442, key4=false}";
        final String actual = new ToStringBuilder(this)
                .add("key1", "value")
                .add("key2", Boolean.FALSE)
                .add("key3", 442)
                .add("key4", false)
                .build();
        assertEquals(expected, actual);
    }
    
}