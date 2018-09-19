//: com.yuli.ddd.domain.specifications.ISpecification.java


package com.yuli.ddd.domain.specifications;


public interface ISpecification<T> {

    boolean isSatisfiedBy(T t);

    default ISpecification<T> and(ISpecification<T> other) {
        return AndSpecification.create(this, other);
    }

    default ISpecification<T> or(ISpecification<T> other) {
        return OrSpecification.create(this, other);
    }

    default ISpecification<T> not() {
        return NotSpecification.create(this);
    }

}///:~