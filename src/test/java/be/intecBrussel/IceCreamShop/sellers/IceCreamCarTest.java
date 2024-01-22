package be.intecBrussel.IceCreamShop.sellers;

import be.intecBrussel.IceCreamShop.application.eatables.*;
import be.intecBrussel.IceCreamShop.application.sellers.IceCreamCar;
import be.intecBrussel.IceCreamShop.application.sellers.IceCreamSalon;
import be.intecBrussel.IceCreamShop.application.sellers.PriceList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class IceCreamCarTest {


    @ParameterizedTest
    @MethodSource("iceCreamCarFactory")
    public void testIceCreamCar(IceCreamCar expectedIceCreamCar, double ballPrice, double rocketPrice, double magnumStandardPrice,int iceRockets, int cones, int balls, int magni) {
        PriceList newPriceList = new PriceList(ballPrice,rocketPrice, magnumStandardPrice);
        Stock newStock = new Stock(iceRockets, cones, balls, magni);
        IceCreamCar returnedIceCreamCar = new IceCreamCar(newPriceList, newStock);
        Assertions.assertEquals(expectedIceCreamCar,returnedIceCreamCar);
    }

    public static Stream<Arguments> iceCreamCarFactory() {

               return Stream.of(
                Arguments.of(new IceCreamCar(new PriceList(1,1,1),new Stock(1,1,1,1)),1,1,1,1,1,1,1),
                Arguments.of(new IceCreamCar(new PriceList(0,0,0),new Stock(0,0,0,0)),0,0,0,0,0,0,0),
                Arguments.of(new IceCreamCar(new PriceList(-1,-1,-1),new Stock(-1,-1,-1,-1)),-1,-1,-1,-1,-1,-1,-1),
                Arguments.of(new IceCreamCar(new PriceList(1,1,1),new Stock(1000000,1000000,1000000,1000000)),1,1,1,1000000,1000000,1000000,1000000),
                Arguments.of(new IceCreamCar(new PriceList(1,1,1),new Stock(-1000000,-1000000,-1000000,-1000000)),1,1,1,-1000000,-1000000,-1000000,-1000000)
                );
    }

    @ParameterizedTest
    @MethodSource("orderConeFactory")
    public void testOrderCone_WithProfitAndStock(Flavor[] newConeWithFlavours, Cone expectedConeWithFlavors, Stock newStock, PriceList newPriceList, double expectedTotalProfit, int expectedStockballs, int expectedStockCones) {

        IceCreamCar newIceCreamCar = new IceCreamCar(newPriceList,newStock);
        Cone returnedCone= newIceCreamCar.orderCone(newConeWithFlavours);
        double returnedTotalProfit = newIceCreamCar.getProfit(); //also tests getProfit method!!!
        int returnedStockBalls = newStock.getBalls();
        int returnedStockCones = newStock.getCones();

        Assertions.assertEquals(expectedConeWithFlavors,returnedCone);
        Assertions.assertEquals(expectedTotalProfit,returnedTotalProfit);
        Assertions.assertEquals(expectedStockballs,returnedStockBalls);
        Assertions.assertEquals(expectedStockCones,returnedStockCones);
    }

    public static Stream<Arguments> orderConeFactory() {

        return Stream.of(
                Arguments.of(new Flavor[]{Flavor.VANILLA}, new Cone(new Flavor[]{Flavor.VANILLA}), new Stock(10,10,10,10),new PriceList(1,1,1), 0.25,9,9),
                Arguments.of(new Flavor[]{Flavor.VANILLA}, new Cone(new Flavor[]{Flavor.VANILLA}), new Stock(10,10,10,10),new PriceList(1,1,1), 0.25,9,9),
                Arguments.of(new Flavor[]{Flavor.VANILLA}, new Cone(new Flavor[]{Flavor.VANILLA}), new Stock(10,10,10,10),new PriceList(-1,-1,-1), -0.25,9,9),
                Arguments.of(new Flavor[]{Flavor.VANILLA,Flavor.CHOCOLATE,Flavor.BANANA,Flavor.STRACIATELLA,Flavor.STRAWBERRY,Flavor.LEMON,Flavor.PISTACHE,Flavor.MOKKA}, new Cone(new Flavor[]{Flavor.VANILLA,Flavor.CHOCOLATE,Flavor.BANANA,Flavor.STRACIATELLA,Flavor.STRAWBERRY,Flavor.LEMON,Flavor.PISTACHE,Flavor.MOKKA}), new Stock(10,10,10,10),new PriceList(1,1,1), 2,2,9),
                Arguments.of(null, null, new Stock(0,0,0,0),null, 0,0,0),
                Arguments.of(null, null, null,null, 0,0,0)

        );


    }



    @ParameterizedTest
    @MethodSource("orderMagnumWithProfitFactory")
    public void testOrderMagnum_WithProfitAndStock(MagnumType aMagnum, Magnum expectedMagnum, Stock newStock, double expectedTotalProfit, int expectedMagnumStockAfter) {

        PriceList newPriceList = new PriceList(1,1,1);
        IceCreamCar newIceCreamCar = new IceCreamCar(newPriceList,newStock);
        Magnum returnedMagnum = newIceCreamCar.orderMagnum(aMagnum);
        double returnedTotalProfit = newIceCreamCar.getProfit(); //also tests getProfit method!!!
        int returnedMagnumStock = newStock.getMagni();

        Assertions.assertEquals(expectedMagnum,returnedMagnum);
        Assertions.assertEquals(expectedTotalProfit,returnedTotalProfit);
        Assertions.assertEquals(expectedMagnumStockAfter,returnedMagnumStock);

    }

    public static Stream<Arguments> orderMagnumWithProfitFactory() {

        return Stream.of(
                Arguments.of(MagnumType.MILKCHOCOLATE , new Magnum(MagnumType.MILKCHOCOLATE), new Stock (1,1,1,1) ,0.01,0), //0.01/* 1.0
                Arguments.of(MagnumType.WHITECHOCOLATE , new Magnum(MagnumType.WHITECHOCOLATE),new Stock (1,1,1,1), 0.012,0), //0.01/* 1.2
                Arguments.of(MagnumType.BLACKCHOCOLATE , new Magnum(MagnumType.BLACKCHOCOLATE), new Stock (1,1,1,1),0.011,0), //0.01/* 1.1
                Arguments.of(MagnumType.ALPINENUTS , new Magnum(MagnumType.ALPINENUTS),new Stock (1,1,1,1) ,0.015,0), //0.01/* 1.5
                Arguments.of(MagnumType.ALPINENUTS , null,new Stock (0,0,0,0) ,0,0), //kan niets aanmaken dus geen magnum returned en geen profit
                Arguments.of(MagnumType.ROMANTICSTRAWBERRIES , new Magnum(MagnumType.ROMANTICSTRAWBERRIES), new Stock (1,1,1,1000000),0.016,999999), //0.01/* 1.6
                Arguments.of(null , null, new Stock (0,0,0,0),0,0)
        );
    }



    @ParameterizedTest
    @MethodSource("orderIceRocketWithProfitFactory")

    public void testOrderIceRocket_WithProfitAndStock(int iceRocketStockBefore, int iceRocketStockExpectedAfter, double iceRocketPrice, double expectedProfit) {

        PriceList newPriceList = new PriceList(1,iceRocketPrice,1);
        Stock newStock = new Stock(iceRocketStockBefore,1,1,1);
        IceCreamCar newIceCreamCar = new IceCreamCar(newPriceList,newStock);
        newIceCreamCar.orderIceRocket();
        double returnedTotalProfit = newIceCreamCar.getProfit();
        int returnedIceRocketStockAfter= newStock.getIceRockets();

        Assertions.assertEquals(expectedProfit,returnedTotalProfit);
        Assertions.assertEquals(iceRocketStockExpectedAfter,returnedIceRocketStockAfter);
    }

    public static Stream<Arguments> orderIceRocketWithProfitFactory() {

        return Stream.of(
                Arguments.of(10,9,1,0.20),
                Arguments.of(10,9,1,0.20),
                Arguments.of(10,9,0,0),
                Arguments.of(0,0,1,0) //geen in stock, dus wordt er geen aangemaakt en dus ook geen profit

        );
    }



}
