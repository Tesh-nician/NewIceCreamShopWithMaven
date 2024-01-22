package be.intecBrussel.IceCreamShop.sellers;

import be.intecBrussel.IceCreamShop.application.eatables.Cone;
import be.intecBrussel.IceCreamShop.application.eatables.Flavor;
import be.intecBrussel.IceCreamShop.application.eatables.Magnum;
import be.intecBrussel.IceCreamShop.application.eatables.MagnumType;
import be.intecBrussel.IceCreamShop.application.sellers.IceCreamSalon;
import be.intecBrussel.IceCreamShop.application.sellers.PriceList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class IceCreamSalonTest {




    @ParameterizedTest
    @MethodSource("iceCreamSalonFactory")
    public void testIceCreamSalon(IceCreamSalon expectedIceCreamsalon, double ballPrice, double rocketPrice, double magnumStandardPrice) {
        PriceList newPriceList = new PriceList(ballPrice,rocketPrice, magnumStandardPrice);
        IceCreamSalon returnedIceCreamSalon = new IceCreamSalon(newPriceList);
        Assertions.assertEquals(expectedIceCreamsalon,returnedIceCreamSalon);
    }

    public static Stream<Arguments> iceCreamSalonFactory() {

               return Stream.of(
                Arguments.of(new IceCreamSalon(new PriceList(1,1,1)),1,1,1),
                Arguments.of(new IceCreamSalon(new PriceList(0.01,0.01,0.01)),0.01,0.01,0.01),
                Arguments.of(new IceCreamSalon(new PriceList(0,0,0)),0,0,0)

        );


    }





    @ParameterizedTest
    @MethodSource("orderConeFactory")
    public void testOrderCone_WithProfit(Flavor[] newConeWithFlavours, Cone expectedConeWithFlavors, double expectedtotalProfit) {
        PriceList newPriceList = new PriceList(1,1,1);
        IceCreamSalon newIceCreamSalon = new IceCreamSalon(newPriceList);
        Cone returnedCone= newIceCreamSalon.orderCone(newConeWithFlavours);
        double returnedTotalProfit = newIceCreamSalon.getProfit(); //also tests getProfit method!!!


        Assertions.assertEquals(returnedCone,expectedConeWithFlavors);
        Assertions.assertEquals(expectedtotalProfit,returnedTotalProfit);
    }

    public static Stream<Arguments> orderConeFactory() {

        IceCreamSalon freshIceCreamSalon = new IceCreamSalon();

        return Stream.of(
                Arguments.of(new Flavor[]{Flavor.VANILLA}, new Cone(new Flavor[]{Flavor.VANILLA}), 0.25),
                Arguments.of(new Flavor[]{Flavor.VANILLA, Flavor.CHOCOLATE, Flavor.STRACIATELLA, Flavor.STRAWBERRY, Flavor.BANANA, Flavor.PISTACHE}, new Cone(new Flavor[]{Flavor.VANILLA, Flavor.CHOCOLATE, Flavor.STRACIATELLA, Flavor.STRAWBERRY, Flavor.BANANA, Flavor.PISTACHE}), 1.5),
                Arguments.of(null, null, 0)
        );


    }

    @Test
    public void testOrderIceRocket_WithProfit() {

        PriceList newPriceList = new PriceList(1,1,1);
        IceCreamSalon newIceCreamSalon = new IceCreamSalon(newPriceList);
        newIceCreamSalon.orderIceRocket();
        double returnedTotalProfit = newIceCreamSalon.getProfit();

        Assertions.assertEquals(0.20,returnedTotalProfit);
    }


    @ParameterizedTest
    @MethodSource("orderMagnumWithProfitFactory")
    public void testOrderMagnum_WithProfit(MagnumType aMagnum, Magnum expectedMagnum, double expectedTotalProfit) {

        PriceList newPriceList = new PriceList(1,1,1);
        IceCreamSalon newIceCreamSalon = new IceCreamSalon(newPriceList);
        Magnum returnedMagnum = newIceCreamSalon.orderMagnum(aMagnum);
        double returnedTotalProfit = newIceCreamSalon.getProfit(); //also tests getProfit method!!!

        Assertions.assertEquals(returnedMagnum,expectedMagnum);
        Assertions.assertEquals(expectedTotalProfit,returnedTotalProfit);
    }

    public static Stream<Arguments> orderMagnumWithProfitFactory() {

        return Stream.of(
                Arguments.of(MagnumType.MILKCHOCOLATE , new Magnum(MagnumType.MILKCHOCOLATE), 0.01), //0.01/* 1.0
                Arguments.of(MagnumType.WHITECHOCOLATE , new Magnum(MagnumType.WHITECHOCOLATE), 0.012), //0.01/* 1.2
                Arguments.of(MagnumType.BLACKCHOCOLATE , new Magnum(MagnumType.BLACKCHOCOLATE), 0.011), //0.01/* 1.1
                Arguments.of(MagnumType.ALPINENUTS , new Magnum(MagnumType.ALPINENUTS), 0.015), //0.01/* 1.5
                Arguments.of(MagnumType.ROMANTICSTRAWBERRIES , new Magnum(MagnumType.ROMANTICSTRAWBERRIES), 0.016), //0.01/* 1.6
                Arguments.of(null , null, 0)
        );
    }



}
