//: com.yuli.ddd.domain.specifications.ContainerSpecification.java


package com.yuli.ddd.domain.specifications;


import lombok.NonNull;

import java.util.EnumSet;


public class ContainerSpecification implements ISpecification<Container> {

	private final EnumSet<ContainerFeature> requiredFeatures = EnumSet
			.of(ContainerFeature.ARMORED, ContainerFeature.VENTILATED);

	@Override
	public boolean isSatisfiedBy(@NonNull Container container) {
		return container.containsFeatures(this.requiredFeatures);
	}

	@Override
	public ISpecification<Container> and(ISpecification<Container> other) {
		return null;
	}

	@Override
	public ISpecification<Container> or(ISpecification<Container> other) {
		return null;
	}

	@Override
	public ISpecification<Container> not() {
		return null;
	}

}///:~