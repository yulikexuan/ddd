//: com.yuli.ddd.domain.specifications.ContainerSpecification.java


package com.yuli.ddd.domain.specifications;


import lombok.NonNull;

import java.util.Arrays;
import java.util.EnumSet;


public class ContainerSpecification implements ISpecification<Container> {

	private final EnumSet<ContainerFeature> requiredFeatures =
			EnumSet.noneOf(ContainerFeature.class);

	public static ContainerSpecification create(
			@NonNull ContainerFeature... feature) {
		return new ContainerSpecification(feature);
	}

	private ContainerSpecification(ContainerFeature... feature) {
		this.requiredFeatures.addAll(Arrays.asList(feature));
	}

	@Override
	public boolean isSatisfiedBy(@NonNull Container container) {
		return container.containsFeatures(this.requiredFeatures);
	}

}///:~