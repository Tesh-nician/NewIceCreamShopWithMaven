package sellers;

import eatables.*;
//import eatables.*;

 public class IceCreamSalon implements IceCreamSeller{
    PriceList priceList;
    double totalProfit;

    public IceCreamSalon() {}

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }


    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public Cone orderCone(Flavor[] newConeWithFlavours) {
        this.totalProfit=this.totalProfit+(newConeWithFlavours.length*priceList.ballPrice*0.25);
        return new Cone(newConeWithFlavours); //return Cone!
    }

    @Override
    public IceRocket orderIceRocket() {
        this.totalProfit=this.totalProfit+(0.2*priceList.getRocketPrice());
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(MagnumType aMagnumtype) {
        this.totalProfit=this.totalProfit+(0.01*priceList.getMagnumPrice(aMagnumtype));
        return new Magnum(aMagnumtype); //return Magnum!!!
    }

    @Override
    public String toString() {
        return "\n______________________________________________________________________________________________\n"+"IceCreamSalon:\n" +
                "    priceList: " + priceList +
                "    totalProfit=" + totalProfit+"\n______________________________________________________________________________________________\n";
    }
}
