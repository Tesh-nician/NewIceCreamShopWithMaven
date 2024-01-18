package application;

import eatables.Eatable;
import eatables.Flavor;
import eatables.MagnumType;
import eatables.Stock;
import sellers.IceCreamCar;
import sellers.IceCreamSeller;
import sellers.PriceList;

import static eatables.Flavor.*;

public class IceCreamCarApp {
    public static void main(String[] args) {


    //Maak een PriceList instantie aan = OK
        PriceList CarPriceList = new PriceList(2.00, 3.00, 3.50);

    //Maak een IceCreamCar instantie aan met behulp van de pricelist en steek deze in een
    // IceCreamSeller variabele = OK

        Stock newStock = new Stock(3, 6, 8, 5);
        IceCreamCar newIceCreamCar = new IceCreamCar(CarPriceList, newStock);
        IceCreamSeller iceCreamSellerVar = newIceCreamCar;

        System.out.println(newIceCreamCar);


    //Bestel enkele ijsjes (order methoden), steek deze in een array van Eatable = OK
    //Bestel nu meer raketijsjes dan er in je stock zitten = OK

        System.out.println("Now making orders ...\n");

        Eatable[] myEatables = new Eatable[]{
                newIceCreamCar.orderIceRocket(),
                newIceCreamCar.orderIceRocket(),
                newIceCreamCar.orderIceRocket(),
                newIceCreamCar.orderIceRocket(), //één meer dan stock = OK
                newIceCreamCar.orderCone(new Flavor[]{STRAWBERRY,PISTACHE,STRAWBERRY}),
                newIceCreamCar.orderCone(new Flavor[]{VANILLA,PISTACHE,STRAWBERRY}),
                newIceCreamCar.orderCone(new Flavor[]{STRAWBERRY,PISTACHE,STRACIATELLA}), //één meer dan stock = OK
                newIceCreamCar.orderMagnum(MagnumType.MILKCHOCOLATE),
                newIceCreamCar.orderMagnum(MagnumType.ALPINENUTS),
                newIceCreamCar.orderMagnum(MagnumType.ROMANTICSTRAWBERRIES),
                newIceCreamCar.orderMagnum(MagnumType.WHITECHOCOLATE) //één meer dan stock = OK
        };

     //Roep van deze ijsjes de eat methode aan = OK
        System.out.println("\nNow eating ...");

        for (Eatable e : myEatables) {
            if (e != null) { e.eat() ;}
        }


    //Print stock to check method = OK
        System.out.println(newStock);


    //Aan het einde van je applicatie print je de profit af van de icecreamseller = OK
        System.out.println("Total profit voor deze icecreamseller: " + iceCreamSellerVar.getProfit());


    }
}
