package builder;

public class Pizza {
    private Size size;
    private boolean onion;
    private boolean cheese;
    private boolean olives;
    private boolean tomato;
    private boolean corn;
    private boolean mushroom;
    private Sauce sauceType;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.onion = builder.onion;
        this.cheese = builder.cheese;
        this.olives = builder.olives;
        this.tomato = builder.tomato;
        this.corn = builder.corn;
        this.mushroom = builder.mushroom;
        this.sauceType = builder.sauceType;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", onion=" + onion +
                ", cheese=" + cheese +
                ", olives=" + olives +
                ", tomato=" + tomato +
                ", corn=" + corn +
                ", mushroom=" + mushroom +
                ", sauceType=" + sauceType +
                '}';
    }

    public Size getSize() {
        return size;
    }

    public boolean hasOnion() {
        return onion;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasOlives() {
        return olives;
    }

    public boolean hasTomato() {
        return tomato;
    }

    public boolean hasCorn() {
        return corn;
    }

    public boolean hasMushroom() {
        return mushroom;
    }

    public Sauce getSauceType() {
        return sauceType;
    }

    public static class Builder {
        private Size size;
        private boolean onion;
        private boolean cheese;
        private boolean olives;
        private boolean tomato;
        private boolean corn;
        private boolean mushroom;
        private Sauce sauceType = Sauce.TOMATO_SAUCE;

        public Builder setSize(Size size) {
            this.size = size;
            return this;
        }

        public Builder addOnion() {
            this.onion = true;
            return this;
        }

        public Builder addCheese() {
            this.cheese = true;
            return this;
        }

        public Builder addOlives() {
            this.olives = true;
            return this;
        }

        public Builder addTomato() {
            this.tomato = true;
            return this;
        }

        public Builder addCorn() {
            this.corn = true;
            return this;
        }

        public Builder addMushroom() {
            this.mushroom = true;
            return this;
        }

        public Builder sauceType(Sauce sauceType) {
            this.sauceType = sauceType;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}