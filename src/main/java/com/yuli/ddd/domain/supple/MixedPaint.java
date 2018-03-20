//: com.yuli.ddd.domain.supple.MixedPaint.java


package com.yuli.ddd.domain.supple;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class MixedPaint implements IPaint {

	private final Set<StockPaint> constituents = new HashSet<>();

	public void mixIn(StockPaint stockPaint) {
		this.constituents.add(stockPaint);
	}

	@Override
	public double getVolume() {
		return this.constituents.stream()
				.collect(Collectors.summingDouble(StockPaint::getVolume));
	}

	@Override
	public PigmentColor getColor() {
		return this.constituents.stream()
				.map(StockPaint::getColor)
				.reduce((c1, c2) -> c1.mixedWith(c2, 1))
				.orElseThrow(RuntimeException::new);
	}

}///:~