package chaosawakens.tools.ultimate;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class UltimateSword extends ItemSword{

	public UltimateSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(CreativeTabs.tabCombat);
		
	}

	public void registerIcons(IconRegister iconRegister)
	{
	itemIcon = iconRegister.registerIcon("chaosawakens:ultimate_sword");	
	}



	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
    	stack.addEnchantment(Enchantment.sharpness, 3);
           // stack.addEnchantment(Enchantment.protection, 1);
           // stack.addEnchantment(Enchantment.blastProtection, 1);
           // stack.addEnchantment(Enchantment.fireProtection, 1);
           // stack.addEnchantment(Enchantment.respiration, 1);
           // stack.addEnchantment(Enchantment.aquaAffinity, 1);
        //	stack.func_111284_a(Enchantment.featherFalling, 5);

    }






}
