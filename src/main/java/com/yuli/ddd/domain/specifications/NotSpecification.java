//: com.yuli.ddd.domain.specifications.NotSpecification.java


package com.yuli.ddd.domain.specifications;


import lombok.NonNull;


public class NotSpecification<T> implements ISpecification<T> {

    private final ISpecification<T> origin;

    public static final <T> ISpecification<T> create(@NonNull ISpecification<T> origin) {

        return new NotSpecification<>(origin);
    }

    private NotSpecification(ISpecification<T> origin) {
        this.origin = origin;
    }

    @Override
    public final boolean isSatisfiedBy(T t) {
        return !this.origin.isSatisfiedBy(t);
    }

}///:~