//: com.yuli.ddd.domain.model.ImmutableStudent.java


package com.yuli.ddd.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@EqualsAndHashCode
@ToString
public class ImmutableStudent {

    private final long id;
    private final String name;
    private final Age age;

    public ImmutableStudent(long id, String name, Age age) {

        this.id = id;
        this.name = name;

        // Clone age argument
        this.age = Age.getBuilder()
                .setDay(age.getDay())
                .setMonth(age.getMonth())
                .setYear(age.getYear())
                .createAge();
    }

    public Age getAge() {
        return Age.getBuilder()
                .setDay(this.age.getDay())
                .setMonth(this.age.getMonth())
                .setYear(this.age.getYear())
                .createAge();
    }

}///:~