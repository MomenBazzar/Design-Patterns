# Builder Design Pattern

## problem:
Let's say we want to create an object that represents a pizza, and the pizza has several properties such as 
Size size, Boolean onion, Boolean cheese, Boolean olives, Boolean tomato, Boolean corn, Boolean mushroom, Sauce sauceType.
We could create a Pizza class with all of these properties and their corresponding setters, but this would result 
in a large and unwieldy class

Also, the constructor might look like this:
```
Pizza(Size size, Boolean onion, Boolean cheese, Boolean olives, Boolean tomato, Boolean corn, Boolean mushroom, Sauce sauceType);
```
In addition to being annoying, the parameters maybe easily mixed up by the developers. Usually, most of the parameters 
are not even mandatory, but in this constructor, the user forced to set value for each of the parameters.  
What will happen when new ingredients will be added?  
Should this constructor be extended with even more parameters?

for those cases, when a lot of parameters needed to build the object — Builder design pattern is used

## definition
The builder design pattern is a creational design pattern that allows you to create complex objects by separating the 
construction of the object from its representation. This pattern is particularly useful when you need to create objects 
that have a large number of parameters, or when you want to provide a more flexible way of constructing objects.

The implementation below uses Builder class to build the pizza while using only the required parameters, this way you 
can freely add parameters with less code modifications, which will not damage the previous built pizza instances.

```java
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
```