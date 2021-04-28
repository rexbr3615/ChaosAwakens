package chaosawakens.armour;

import chaosawakens.ChaosAwakens;
import cpw.mods.fml.common.network.Player;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.enchantment.*;


public class ArmourSetLavaEel extends ItemArmor{

	
	public int[] enchantmentLevels;
	public Enchantment[] enchantmentIds;
	
	public ArmourSetLavaEel(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String nameToAdd) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		// TODO Auto-generated constructor stub
	this.setCreativeTab(CreativeTabs.tabCombat);
	this.maxStackSize = 1;
	this.material = par2EnumArmorMaterial;
	this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
	par2EnumArmorMaterial.getDamageReductionAmount(par4);
	nametoadd = nameToAdd;
	
	
	
	}

    public void onCreated(ItemStack stack, World worldIn, Player playerIn) {
            stack.addEnchantment(Enchantment.featherFalling, 5);
            stack.addEnchantment(Enchantment.protection, 5);
            stack.addEnchantment(Enchantment.blastProtection, 5);
            stack.addEnchantment(Enchantment.fireProtection, 5);
            stack.addEnchantment(Enchantment.respiration, 5);
            stack.addEnchantment(Enchantment.aquaAffinity, 5);

    }
	
	
	
	public EnumArmorMaterial material;
	public String nametoadd;
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		if(stack.toString().contains("legginngs")) {
		return "chaosawakens:" + nametoadd + "_2.png";	
		}
		if(stack.toString().contains("Leggings")) if(itemID == chaosawakens.ChaosAwakens.LAVA_EEL_LEGGINGS.itemID)
				{
			return "chaosawakens:" + nametoadd + "_2.png";
				}
		
		return "chaosawakens:" + nametoadd + "_1.png";
		
		
	}
	
		
	public void registerIcons (IconRegister par1iconRegister)
	{
		if (itemID == ChaosAwakens.LAVA_EEL_HELMET.itemID) {
			itemIcon = par1iconRegister.registerIcon("chaosawakens:lava_eel_helmet");
		}
if (itemID == ChaosAwakens.LAVA_EEL_CHESTPLATE.itemID) {
	itemIcon = par1iconRegister.registerIcon("chaosawakens:lava_eel_chestplate");

		}
if (itemID == ChaosAwakens.LAVA_EEL_LEGGINGS.itemID) {
	itemIcon = par1iconRegister.registerIcon("chaosawakens:lava_eel_leggings");

}
if (itemID == ChaosAwakens.LAVA_EEL_BOOTS.itemID) {
	itemIcon = par1iconRegister.registerIcon("chaosawakens:lava_eel_boots");
	
}
		
	}
	
	
	
	
}
