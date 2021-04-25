package chaosawakens;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class TigerEyeSword extends ItemSword{

	public TigerEyeSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(CreativeTabs.tabCombat);
		
	}

	public void registerIcons(IconRegister iconRegister)
	{
	itemIcon = iconRegister.registerIcon("chaosawakens:tigers_eye_sword");	
	}
}
