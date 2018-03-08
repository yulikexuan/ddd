//: com.yuli.ddd.domain.specifications.Container.java


package com.yuli.ddd.domain.specifications;


import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;


public class Container {

	private final EnumSet<ContainerFeature> features = EnumSet.noneOf(
			ContainerFeature.class);

	public void addFeature(ContainerFeature feature) {
		this.features.add(feature);
	}

	public boolean removeFeature(ContainerFeature feature) {
		return (feature == null) ? false : this.features.remove(feature);
	}

	public Set<ContainerFeature> getFeatures() {
		return Collections.unmodifiableSet(this.features);
	}

	public boolean hasFeature(ContainerFeature feature) {
		return this.features.contains(feature);
	}

	public boolean containsFeatures(Set<ContainerFeature> features) {
		return (features == null) ? false : this.features.containsAll(features);
	}

}///:~