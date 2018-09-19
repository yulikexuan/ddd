//: com.yuli.ddd.domain.supple.StockPaint.java


package com.yuli.ddd.domain.supple;


public final class StockPaint implements IPaint {

    private final double volume;
    private final PigmentColor color;

    private StockPaint(double volume, PigmentColor color) {
        this.volume = volume;
        this.color = PigmentColor.builder().setRed(color.getRed()).setBlue(color.getBlue()).setYellow(color.getYellow()).createPigmentColor();
    }

    public static final Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private double volume;
        private PigmentColor color;

        private Builder() {
        }

        public Builder setVolume(double volume) {
            this.volume = volume;
            return this;
        }

        public Builder setColor(PigmentColor color) {
            this.color = color;
            return this;
        }

        public StockPaint createStockPaint() {
            return new StockPaint(volume, color);
        }
    }

    @Override
    public double getVolume() {
        return this.volume;
    }

    @Override
    public PigmentColor getColor() {
        return PigmentColor.builder().setRed(this.color.getRed()).setYellow(this.color.getYellow()).setBlue(this.color.getBlue()).createPigmentColor();
    }

}///:~