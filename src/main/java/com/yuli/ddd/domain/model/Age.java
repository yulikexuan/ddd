//: com.yuli.ddd.domain.model.Age.java


package com.yuli.ddd.domain.model;


import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Age {

    private int day;
    private int month;
    private int year;

    private Age(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private int day;
        private int month;
        private int year;

        public Builder setDay(int day) {
            this.day = day;
            return this;
        }

        public Builder setMonth(int month) {
            this.month = month;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Age createAge() {
            return new Age(day, month, year);
        }
    }

}///:~