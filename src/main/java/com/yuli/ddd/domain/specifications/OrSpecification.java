//: com.yuli.ddd.domain.specifications.OrSpecification.java


package com.yuli.ddd.domain.specifications;


import lombok.NonNull;


public final class OrSpecification<T> implements ISpecification<T> {

	private final ISpecification<T> one;
	private final ISpecification<T> other;

	public static final <T> ISpecification<T> create(
			@NonNull ISpecification<T> one, @NonNull ISpecification<T> other) {

		return new OrSpecification<>(one, other);
	}

	private OrSpecification(ISpecification<T> one, ISpecification<T> other) {
		this.one = one;
		this.other = other;
	}

	@Override
	public final boolean isSatisfiedBy(T t) {
		return this.one.isSatisfiedBy(t) || this.other.isSatisfiedBy(t);
	}

}///:~