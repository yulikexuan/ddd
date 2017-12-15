//: com.yuli.ddd.domain.model.ImmutableStudentTest.java


package com.yuli.ddd.domain.model;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class ImmutableStudentTest {

    private ImmutableStudent student;
    private Age age;

    @Before
    public void setUp() throws Exception {
        this.age = Age.getBuilder()
                .setDay(1)
                .setMonth(1)
                .setYear(1992)
                .createAge();

        this.student = new ImmutableStudent(1, "Alex", this.age);
    }

    @Test
    public void immutability_Test() {

        // Given
        int yearBeforeModification = this.student.getAge().getYear();

        this.age.setYear(1993);

        int yearAfterModification = this.student.getAge().getYear();

        // When
        boolean isStudentImmutable =
                (yearAfterModification == yearBeforeModification);

        // Then
        assertThat(isStudentImmutable, is(true));
    }

    @Test
    public void should_Be_No_Leek_Of_Immutability_From_Any_Method() {

        // Given
        int yearBeforeModification = this.student.getAge().getYear();
        this.student.getAge().setYear(1993);
        int yearAfterModification = this.student.getAge().getYear();

        // When
        boolean isStudentImmutable =
                (yearAfterModification == yearBeforeModification);

        // Then
        assertThat(isStudentImmutable, is(true));
    }

}///:~