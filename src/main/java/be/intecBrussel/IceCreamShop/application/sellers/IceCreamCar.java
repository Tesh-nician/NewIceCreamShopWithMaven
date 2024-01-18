package sellers;



import eatables.*;

import java.util.Arrays;

public class IceCreamCar implements IceCreamSeller {


    //added the new private methods for cones, iceRocket and magnums in the return of the old methods.
    // The new private methods either give an out-of-stock message and return null, or they return the same object.


    PriceList priceList;

    Stock IceCarStock;
    double totalProfit;


    public IceCreamCar() {
    }

    public IceCreamCar(PriceList priceList, Stock carStock) {
        this.priceList = priceList;
        this.IceCarStock = carStock;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public Cone orderCone(Flavor[] newConeWithFlavours) {
        this.totalProfit=this.totalProfit+(newConeWithFlavours.length*priceList.ballPrice*0.25);
        return prepareCone(newConeWithFlavours);
    }

    private Cone prepareCone(Flavor[] newConeWithFlavours) {
        //check stock for enough cones AND balls!!!
        //There is no separate stock for flavours.
        //Presumably people will accept any flavor if they want an ice-cream.
        //Attention: order will be terminated if balls ordered exceeds stock, potentially leaving a few balls in stock.
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
        this.totalProfit=this.totalProfit+(0.2*priceList.getRocketPrice());
        return prepareRocket();
    }

    private IceRocket prepareRocket() {
        //Check stock for enough iceRockets
       if (IceCarStock.getIceRockets()>0) {
           IceCarStock.setIceRockets(IceCarStock.getIceRockets() - 1);
           return new IceRocket();
       }
       else {
           System.out.println("NO MORE ICE ROCKETS");
           return null;
       }

    }

    @Override
    public Magnum orderMagnum(MagnumType aMagnumtype) {
        this.totalProfit=this.totalProfit+(0.01*priceList.getMagnumPrice(aMagnumtype));
        return prepareMagnum(aMagnumtype);
    }

    private Magnum prepareMagnum(MagnumType aMagnumtype) {
        //Check stock for enough magnums.
        // There is no separation by type (UML does not give stock variables for magnum type).
        // The logic is presumably that people will substitute for different types :-)

        if (IceCarStock.getMagni()>0) {
            IceCarStock.setMagni(IceCarStock.getMagni() - 1);
            return new Magnum(aMagnumtype);
        }
        else {
            System.out.println("NO MORE MAGNUMS");
            return null;
        }

    }

    @Override
    public String toString() {
        return "\n______________________________________________________________________________________________\n"+"IceCreamCar: "
                +"priceList: " + priceList
                +IceCarStock
                +"\nTotalProfit= " + totalProfit
                +"\n______________________________________________________________________________________________\n";
    }
}
