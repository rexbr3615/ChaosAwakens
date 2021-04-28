package chaosawakens;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

public class Fuels implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel)
	{
	if(fuel.itemID == ChaosAwakens.Oil.itemID) //Item.appleRed.itemID being the item you are adding a fuel value to
	return 10 * 20; //10 * 20 because it is 20 ticks in a second * 10 for 10 seconds of fuel per apple

	return 0;
	}

		
}
