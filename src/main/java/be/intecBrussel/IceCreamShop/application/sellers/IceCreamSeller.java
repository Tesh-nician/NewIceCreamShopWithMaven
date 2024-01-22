package be.intecBrussel.IceCreamShop.application.sellers;

import be.intecBrussel.IceCreamShop.application.eatables.*;



public interface IceCreamSeller extends Profitable{
    public Cone orderCone(Flavor[] newFlavour);
    public IceRocket orderIceRocket ();
    public Magnum orderMagnum (MagnumType aMagnumtype);
}
