package chaosawakens.ores;

import java.util.Random;

import chaosawakens.ChaosAwakens;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TitaniumOre extends Block{

	public TitaniumOre(int p_i2273_1_, Material p_i2273_2_) {
		super(p_i2273_1_, p_i2273_2_);
		// TODO Auto-generated constructor stub
	
	this.setCreativeTab(CreativeTabs.tabBlock);
	this.setLightValue(0.8F);
	this.setHardness(4);
	this.setResistance(5);
	
	}
public void registerIcons(IconRegister iconRegister)
{
blockIcon = iconRegister.registerIcon("chaosawakens:titanium_ore");	
}
	
public int idDropped(int par1, Random par2Random, int par3)
{
	return chaosawakens.ChaosAwakens.TITANIUM_ORE.blockID;
}
public int quantityDropped(Random parlRandom)
{
	return 1;
}

	
	
}
