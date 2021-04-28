package chaosawakens;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RawBacon extends ItemFood{

	public RawBacon(int par1, int par2, boolean par3) {
		super(par1, par2, par3);
		// TODO Auto-generated constructor stub

		this.setCreativeTab(CreativeTabs.tabFood);
		
	}

	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 600, 4));
		
		
	}	
	
	public void registerIcons(IconRegister iconRegister)
	{
	itemIcon = iconRegister.registerIcon("chaosawakens:raw_bacon");	
	}
	
	
	
	
	
	
}
