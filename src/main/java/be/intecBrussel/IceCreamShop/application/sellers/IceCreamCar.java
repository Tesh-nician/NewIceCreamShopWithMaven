package be.intecBrussel.IceCreamShop.application.sellers;



import be.intecBrussel.IceCreamShop.application.Exceptions.NoBallsException;
import be.intecBrussel.IceCreamShop.application.eatables.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;


public class IceCreamCar implements IceCreamSeller {


    //added the new private methods for cones, iceRocket and magnums in the return of the old methods.
    // The new private methods either give an out-of-stock message and return null, or they return the same object.


    PriceList priceList;

    Stock IceCarStock;
    double totalProfit=0;


    public IceCreamCar() {
    }

    public IceCreamCar(PriceList priceList, Stock carStock) {
        this.priceList = priceList;
        this.IceCarStock = carStock;
    }

    @Override
    public double getProfit() {
        BigDecimal resultBigDecimal = new BigDecimal(totalProfit).setScale(4, RoundingMode.HALF_UP);
        double result = resultBigDecimal.doubleValue();
        return result;
    }

    @Override
    public Cone orderCone(Flavor[] newConeWithFlavours) {

        if (newConeWithFlavours ==null) {
            System.out.println("You have no balls!!!");
            return null; //throw new NoBallsException();
        }

            this.totalProfit=this.totalProfit+(newConeWithFlavours.length*priceList.ballPrice*0.25);
            return prepareCone(newConeWithFlavours);

    }

    private Cone prepareCone(Flavor[] newConeWithFlavours) {
        //check stock for enough cones AND balls!!!
        //There is no separate stock for flavours.
        //Presumably people will accept any flavor if they want an ice-cream.
        //Attention: order will be terminated if balls ordered exceeds stock, potentially leaving a few balls in stock.
        if (newConeWithFlavours==null||IceCarStock==null) return null;
        if (IceCarStock.getCones()>0 && (IceCarStock.getBalls()- Arrays.stream(newConeWithFlavours).count()>0)) {
            IceCarStock.setCones(IceCarStock.getCones() - 1);
            IceCarStock.setBalls(IceCarStock.getBalls() - ((int)Arrays.stream(newConeWithFlavours).count()));
            return new Cone(newConeWithFlavours);
        }
        else {
            System.out.println("NOT ENOUGH CONES OR BALLS");
            return null;
        }
    }

    @Override
    public IceRocket orderIceRocket() {

       if (IceCarStock.getIceRockets()>0) return prepareRocket();

       System.out.println("NO MORE ICE ROCKETS");
       return null;
    }

    private IceRocket prepareRocket() {
        //Check stock for enough iceRockets

        IceCarStock.setIceRockets(IceCarStock.getIceRockets() - 1);
        this.totalProfit=this.totalProfit+(0.2*priceList.getRocketPrice());
        return new IceRocket();

    }

    @Override
    public Magnum orderMagnum(MagnumType aMagnumtype) {
        //Check stock for enough magnums.
        // There is no separation by type (UML does not give stock variables for magnum type).
        // The logic is presumably that people will substitute for different types :-)
        if (aMagnumtype ==null) return null;
        if (IceCarStock.getMagni()>0) {
            return prepareMagnum(aMagnumtype);
        }
        System.out.println("NO MORE MAGNUMS");
        return null;
    }

    private Magnum prepareMagnum(MagnumType aMagnumtype) {

        this.totalProfit=this.totalProfit+(0.01*priceList.getMagnumPrice(aMagnumtype));
        IceCarStock.setMagni(IceCarStock.getMagni() - 1);
        return new Magnum(aMagnumtype);

    }

    @Override
    public String toString() {
        return "\n______________________________________________________________________________________________\n"+"IceCreamCar: "
                +"priceList: " + priceList
                +IceCarStock
                +"\nTotalProfit= " + totalProfit
                +"\n______________________________________________________________________________________________\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IceCreamCar that)) return false;
        return Double.compare(totalProfit, that.totalProfit) == 0 && Objects.equals(priceList, that.priceList) && Objects.equals(IceCarStock, that.IceCarStock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceList, IceCarStock, totalProfit);
    }
}
