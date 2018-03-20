//: com.yuli.ddd.domain.supple.PigmentColor.java


package com.yuli.ddd.domain.supple;


import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EqualsAndHashCode
public final class PigmentColor {

	private final int red;
	private final int yellow;
	private final int blue;

	private PigmentColor(int red, int yellow, int blue) {
		this.red = red;
		this.yellow = yellow;
		this.blue = blue;
	}

	public static final Builder builder() {
		return new Builder();
	}

	public final PigmentColor mixedWith(PigmentColor other, double ratio) {
		return builder()
				.setRed((this.red + other.red) / 2)
				.setYellow((this.yellow + other.yellow) / 2)
				.setBlue((this.blue + other.blue) / 2)
				.createPigmentColor();
	}

	public static final class Builder {

		private int red;
		private int yellow;
		private int blue;

		private Builder() {}

		public Builder setRed(int red) {
			this.red = red;
			return this;
		}

		public Builder setYellow(int yellow) {
			this.yellow = yellow;
			return this;
		}

		public Builder setBlue(int blue) {
			this.blue = blue;
			return this;
		}

		public PigmentColor createPigmentColor() {
			return new PigmentColor(red, yellow, blue);
		}
	}

}///:~