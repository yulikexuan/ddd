//: com.yuli.ddd.domain.specifications.ContainerSpecificationTest.java


package com.yuli.ddd.domain.specifications;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class ContainerSpecificationTest {

    private ContainerSpecification explosiveSpecification;
    private ContainerSpecification flammableSpecification;
    private ContainerSpecification toxicSpecification;
    private Container biologicalContainer;
    private Container stableContainer;
    private Container freshAirContainer;
    private Container allPurposeContainer;

    private void createSingleFeatureContainers() {
        this.biologicalContainer = new Container();
        this.biologicalContainer.addFeature(ContainerFeature.BIOLOGICAL);

        this.stableContainer = new Container();
        this.stableContainer.addFeature(ContainerFeature.ARMORED);

        this.freshAirContainer = new Container();
        this.freshAirContainer.addFeature(ContainerFeature.VENTILATED);
    }

    private void createSingleFeatureSpecifications() {
        this.explosiveSpecification = ContainerSpecification.create(ContainerFeature.ARMORED);
        this.flammableSpecification = ContainerSpecification.create(ContainerFeature.VENTILATED);
        this.toxicSpecification = ContainerSpecification.create(ContainerFeature.BIOLOGICAL);
    }

    @Before
    public void setUp() throws Exception {
        this.createSingleFeatureSpecifications();
        this.createSingleFeatureContainers();

        this.allPurposeContainer = new Container();
        this.allPurposeContainer.addFeature(ContainerFeature.ARMORED);
        this.allPurposeContainer.addFeature(ContainerFeature.VENTILATED);
        this.allPurposeContainer.addFeature(ContainerFeature.BIOLOGICAL);
    }

    @Test
    public void is_Always_Satisfied_By_All_Purpose_Containers() {

        // Given
        ISpecification<Container> allFeaturesSpecification = this.explosiveSpecification.and(this.flammableSpecification).and(this.toxicSpecification);

        // When
        boolean satisfied = allFeaturesSpecification.isSatisfiedBy(this.allPurposeContainer);

        // Then
        assertThat(satisfied, is(true));
    }

    @Test
    public void either_Specification() {

        // Given
        ISpecification<Container> eitherSpecification = this.explosiveSpecification.or(this.flammableSpecification);

        // When
        boolean satisfied_1 = eitherSpecification.isSatisfiedBy(this.biologicalContainer);

        boolean satisfied_2 = eitherSpecification.isSatisfiedBy(this.freshAirContainer);

        boolean satisfied_3 = eitherSpecification.isSatisfiedBy(this.stableContainer);

        // Then
        assertThat(satisfied_1, is(false));
        assertThat(satisfied_2, is(true));
        assertThat(satisfied_3, is(true));
    }

    @Test
    public void not_Specification() {

        // Given
        ISpecification<Container> notToxicSpecification = this.toxicSpecification.not().and(this.flammableSpecification).and(this.explosiveSpecification);

        Container notToxicContainer = new Container();
        notToxicContainer.addFeature(ContainerFeature.VENTILATED);
        notToxicContainer.addFeature(ContainerFeature.ARMORED);

        // When
        boolean satisfied_1 = notToxicSpecification.isSatisfiedBy(this.allPurposeContainer);
        boolean satisfied_2 = notToxicSpecification.isSatisfiedBy(this.freshAirContainer);
        boolean satisfied_3 = notToxicSpecification.isSatisfiedBy(this.stableContainer);
        boolean satisfied_0 = notToxicSpecification.isSatisfiedBy(notToxicContainer);

        // Then
        assertThat(satisfied_0, is(true));
        assertThat(satisfied_1, is(false));
        assertThat(satisfied_2, is(false));
        assertThat(satisfied_3, is(false));
    }

}///:~