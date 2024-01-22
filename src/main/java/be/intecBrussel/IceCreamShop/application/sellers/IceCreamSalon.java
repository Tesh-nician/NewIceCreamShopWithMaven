package be.intecBrussel.IceCreamShop.application.sellers;

import be.intecBrussel.IceCreamShop.application.eatables.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;


public class IceCreamSalon implements IceCreamSeller{
    PriceList priceList;
    double totalProfit;

    public IceCreamSalon() {}

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }


    @Override
    public double getProfit() {
        BigDecimal resultBigDecimal = new BigDecimal(totalProfit).setScale(4, RoundingMode.HALF_UP);
        double result = resultBigDecimal.doubleValue();
        return result;
    }

    @Override
        public Cone orderCone(Flavor[] newConeWithFlavours) {

            if (newConeWithFlavours != null) {
                this.totalProfit = this.totalProfit + (newConeWithFlavours.length * priceList.ballPrice * 0.25);
                return new Cone(newConeWithFlavours); //return Cone!
                }


        return null;
    }

    @Override
    public IceRocket orderIceRocket() {
        this.totalProfit=this.totalProfit+(0.2*priceList.getRocketPrice());
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(MagnumType aMagnumtype) {

        if (aMagnumtype!=null) {
        this.totalProfit=this.totalProfit+(0.01*priceList.getMagnumPrice(aMagnumtype));
        return new Magnum(aMagnumtype); //return Magnum!!!
        }

        return null;
    }

    @Override
    public String toString() {
        return "\n______________________________________________________________________________________________\n"+"IceCreamSalon:\n" +
                "    priceList: " + priceList +
                "    totalProfit=" + totalProfit+"\n______________________________________________________________________________________________\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCreamSalon that = (IceCreamSalon) o;
        return Double.compare(totalProfit, that.totalProfit) == 0 && Objects.equals(priceList, that.priceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceList, totalProfit);
    }
}
