package be.intecBrussel.IceCreamShop.application.eatables;

import java.util.Arrays;

public class Cone implements Eatable{
    Flavor[] balls;

    public Cone() {}

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {

        System.out.println("You are now eating a cone with flavours "+Arrays.toString(this.balls));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone cone = (Cone) o;
        return Arrays.equals(balls, cone.balls);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(balls);
    }
}

