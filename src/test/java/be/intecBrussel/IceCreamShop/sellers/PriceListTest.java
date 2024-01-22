package be.intecBrussel.IceCreamShop.sellers;

import be.intecBrussel.IceCreamShop.application.eatables.MagnumType;
import be.intecBrussel.IceCreamShop.application.sellers.IceCreamSalon;
import be.intecBrussel.IceCreamShop.application.sellers.PriceList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PriceListTest {



    @ParameterizedTest
    @MethodSource("getBallPricesFactory")
    public void testGetBallPrices(double price, double expectedPrice) {
        PriceList newPriceList = new PriceList(price,1,1);
        double returnedPrice= newPriceList.getBallPrice();
        Assertions.assertEquals(expectedPrice,returnedPrice);
    }

    public static Stream<Arguments> getBallPricesFactory() {
        return Stream.of(
                Arguments.of(1,1),
                Arguments.of(0,0),
                Arguments.of(0.3,0.3),
                Arguments.of(0.001,0.001),
                Arguments.of(-0.0001,-0.0001),
                Arguments.of(1000000,1000000)


        );
    }

    @ParameterizedTest
    @MethodSource("getRocketPricesFactory")
    public void testGetRocketPrices(double price, double expectedPrice) {
        PriceList newPriceList = new PriceList(1,price,1);
        double returnedPrice= newPriceList.getRocketPrice();
        Assertions.assertEquals(expectedPrice,returnedPrice);
    }

    public static Stream<Arguments> getRocketPricesFactory() {
        return Stream.of(
                Arguments.of(1,1),
                Arguments.of(0,0),
                Arguments.of(0.3,0.3),
                Arguments.of(0.0001,0.0001),
                Arguments.of(-0.0001,-0.0001),
                Arguments.of(1000000,1000000)


        );
    }


    @ParameterizedTest
    @MethodSource("getSpecialMagnumPricesFactory")
    public void testGetMagnumPrices(double price, double expectedPrice) {
        PriceList newPriceList = new PriceList(1,1,price);

        double returnedPrice= newPriceList.getMagnumPrice(MagnumType.ALPINENUTS);
        Assertions.assertEquals(expectedPrice,returnedPrice);
    }

    public static Stream<Arguments> getSpecialMagnumPricesFactory() {
        return Stream.of(
                Arguments.of(1,1.5),
                Arguments.of(0,0),
                Arguments.of(0.3,0.44999999999999996),
                Arguments.of(1000000,1500000)


        );
    }






}
