package sellers;

import eatables.*;
//import eatables.*;

public interface IceCreamSeller extends Profitable{
    public Cone orderCone(Flavor[] newFlavour);
    public IceRocket orderIceRocket ();
    public Magnum orderMagnum (MagnumType aMagnumtype);
}
