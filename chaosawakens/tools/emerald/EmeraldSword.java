package chaosawakens.tools.emerald;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class EmeraldSword extends ItemSword{

	public EmeraldSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(CreativeTabs.tabCombat);
		
	}

//	public EmeraldSword(int par1, EnumToolMaterial tOOL_EMERALD) {
//		// TODO Auto-generated constructor stub
//	}

	public void registerIcons(IconRegister iconRegister)
	{
	itemIcon = iconRegister.registerIcon("chaosawakens:emerald_sword");	
	}
}
