//: com.yuli.ddd.domain.specifications.ISpecification.java


package com.yuli.ddd.domain.specifications;


public interface ISpecification<T> {

	boolean isSatisfiedBy(T t);

	ISpecification<T> and(ISpecification<T> other);
	ISpecification<T> or(ISpecification<T> other);
	ISpecification<T> not();

}///:~