package eatables;

public class IceRocket implements Eatable {
    public IceRocket() {}

    @Override
    public void eat() {
        System.out.println("You are now eating an IceRocket");
    }

}
