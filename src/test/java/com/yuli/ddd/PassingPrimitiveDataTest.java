//: com.yuli.ddd.PassingPrimitiveDataTest.java


package com.yuli.ddd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class PassingPrimitiveDataTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void pass_Primitive_Data_By_Copy() {

        // Given
        int x = 1;
        int y = 2;

        // When
        PassingPrimitiveData.modify(x, y);

        // Then
        assertThat(x, is(1));
        assertThat(y, is(2));
    }

    @Test
    public void passing_Wrappers() {

        // Given
        Integer obj1 = new Integer(1);
        Integer obj2 = new Integer(2);

        Integer x = obj1;
        Integer y = obj2;

        // When
        PassingPrimitiveData.modifyWrappers(x, y);

        // Then
        assertThat(x == obj1, is(true));
        assertThat(y == obj2, is(true));
    }

}///:~