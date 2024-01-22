package be.intecBrussel.IceCreamShop.application.eatables;

import be.intecBrussel.IceCreamShop.application.Exceptions.NoBallsException;

import java.util.Objects;

public class Stock  {
    int iceRockets=0;
    int cones=0;
    int balls=0; //No separate stock for flavours!
    int magni=0; //No separate stock for magnum types!

    public Stock(int iceRockets, int cones, int balls, int magni) {
        this.iceRockets = iceRockets;
        this.cones = cones;
        this.balls = balls;
        this.magni = magni;
    }

    public int getIceRockets() {
        return iceRockets;
    }

    public void setIceRockets(int iceRockets) {
        this.iceRockets = iceRockets;
    }

    public int getCones() {
        return cones;
    }

    public void setCones(int cones) {
        this.cones = cones;
    }

    public int getBalls() throws NoBallsException {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getMagni() {
        return magni;
    }

    public void setMagni(int magni) {
        this.magni = magni;
    }

    @Override
    public String toString() {
        return "\nIceCreamCar stock at this moment is:\n" +
                "  iceRockets=" + iceRockets +
                "  cones=" + cones +
                "  balls=" + balls +
                "  magni=" + magni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock stock)) return false;
        return getIceRockets() == stock.getIceRockets() && getCones() == stock.getCones() && getBalls() == stock.getBalls() && getMagni() == stock.getMagni();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIceRockets(), getCones(), getBalls(), getMagni());
    }
}
