package chaosawakens.items;

import chaosawakens.ChaosAwakens;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;

public class Oil extends Item {

	public Oil(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(CreativeTabs.tabMisc);
	
	
	}
	public void registerIcons(IconRegister iconRegister)
	{
	itemIcon = iconRegister.registerIcon("chaosawakens:oil");	
	}
	
	
	



}
