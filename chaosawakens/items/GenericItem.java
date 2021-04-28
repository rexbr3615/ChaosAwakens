package chaosawakens.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericItem extends Item{

	protected GenericItem(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	
	
	this.setCreativeTab(CreativeTabs.tabMaterials);
	
	}

	public void registerIcons(IconRegister iconRegister)
	{
	itemIcon = iconRegister.registerIcon("chaosawakens:" + this.getUnlocalizedName());	
	}
	
	
	
	
	
}
