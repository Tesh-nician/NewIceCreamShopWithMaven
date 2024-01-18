package eatables;

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
}
