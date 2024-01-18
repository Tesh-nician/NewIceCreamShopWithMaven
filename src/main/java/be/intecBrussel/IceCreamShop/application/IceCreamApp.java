package application;

import eatables.Eatable;
import eatables.Flavor;
import eatables.MagnumType;
import sellers.IceCreamSalon;
import sellers.IceCreamSeller;
import sellers.PriceList;
import eatables.Flavor.*;

import static eatables.Flavor.*;

public class IceCreamApp {
    public static void main(String[] args) {



    //Maak een PriceList instantie aan = OK
        PriceList salonPriceList = new PriceList(2.00, 3.00, 3.50);


    //Maak een IceCreamSalon instantie aan met behulp van de price list en steek deze in een
    //IceCreamSeller variabele.
        IceCreamSalon newIceCreamSalon = new IceCreamSalon(salonPriceList);
        IceCreamSeller iceCreamSellerVar = newIceCreamSalon;
        System.out.println(newIceCreamSalon);

    //Bestel enkele ijsjes (order methoden), steek deze in een array van Eatable = OK
        System.out.println("Now making orders ...\n");

        Eatable[] myEatables = new Eatable[]{
                        newIceCreamSalon.orderCone(new Flavor[]{VANILLA,CHOCOLATE,PISTACHE,STRAWBERRY}),
                        newIceCreamSalon.orderIceRocket(),
                        newIceCreamSalon.orderCone(new Flavor[]{STRAWBERRY,PISTACHE,STRAWBERRY}),
                        newIceCreamSalon.orderMagnum(MagnumType.MILKCHOCOLATE),
                        newIceCreamSalon.orderMagnum(MagnumType.ALPINENUTS),
                        newIceCreamSalon.orderMagnum(MagnumType.ROMANTICSTRAWBERRIES),
                        newIceCreamSalon.orderMagnum(MagnumType.WHITECHOCOLATE)
        };

    //Roep van deze ijsjes de eat methode aan = OK
        System.out.println("Now eating ...");

        for (Eatable e:myEatables) { e.eat(); }

    //Aan het einde van je applicatie print je de profit af van de icecreamseller = OK

        System.out.println("\nTotal profit voor deze icecreamseller: "+iceCreamSellerVar.getProfit());




    }
}
