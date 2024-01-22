package be.intecBrussel.IceCreamShop.application.eatables;

import java.util.Objects;

public class Magnum implements Eatable{

    MagnumType type;

    public Magnum() {}

    public Magnum(MagnumType type) {
        this.type = type;
    }
    public MagnumType getType() {    //is niet nodig, maar het staat in de UML.
        return type;
    }

    @Override
    public void eat() {

        System.out.println("You are now eating a Magnum of type "+type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magnum magnum = (Magnum) o;
        return getType() == magnum.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}
