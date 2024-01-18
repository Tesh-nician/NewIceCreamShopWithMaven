package eatables;

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

}
