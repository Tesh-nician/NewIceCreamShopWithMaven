package be.intecBrussel.IceCreamShop.application.sellers;

import be.intecBrussel.IceCreamShop.application.eatables.MagnumType;

import java.util.Objects;

public class PriceList {
    double ballPrice;
    double rocketPrice;
    double magnumStandardPrice; //use to multiply magnum prices!!!

    public PriceList() {
    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public double getMagnumPrice(MagnumType magnumType) {

        //create method that uses MagnumType to return the price, using multiplication factor of
        //magnumStandardPrice. Provides differentiation in magnum prices.

        double returnPrice=1.00; //initialised as a safety measure, not normally necessary.
        switch (magnumType) {

            case MILKCHOCOLATE -> {
                returnPrice= 1.00;
                break;
            }
            case WHITECHOCOLATE -> {
                returnPrice= 1.20;
                break;
            }
            case BLACKCHOCOLATE -> {
                returnPrice= 1.10;
                break;
            }
            case ALPINENUTS -> {
                returnPrice= 1.50;
                break;
            }

            case ROMANTICSTRAWBERRIES -> {
                returnPrice= 1.60;
                break;
            }

            default -> getMagnumPrice(magnumType); //Traps any errors, runs the same method again. Very small risk of endless loop, should not normally be necessary.
        }

        return returnPrice*magnumStandardPrice; //multiplication by magnumStandardPrice, use for changing ALL magnum prices!!!!

    }

    @Override
    public String toString() {
        return  "each ball= " + ballPrice +
                ", rocket ice-lolly= " + rocketPrice +
                ", magnum (standard)= " + magnumStandardPrice
                +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceList priceList = (PriceList) o;
        return Double.compare(getBallPrice(), priceList.getBallPrice()) == 0 && Double.compare(getRocketPrice(), priceList.getRocketPrice()) == 0 && Double.compare(magnumStandardPrice, priceList.magnumStandardPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBallPrice(), getRocketPrice(), magnumStandardPrice);
    }
}

