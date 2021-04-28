package chaosawakens.armour;

import java.util.List;

import chaosawakens.ChaosAwakens;
import cpw.mods.fml.common.network.Player;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.enchantment.*;


public class ArmourSetExperience extends ItemArmor{

	
	public int[] enchantmentLevels = {1, 1, 1, 1, 1, 1};
	public Enchantment[] enchantmentIds = {Enchantment.featherFalling, Enchantment.protection, Enchantment.blastProtection, Enchantment.fireProtection, Enchantment.respiration, Enchantment.aquaAffinity};
	public ItemStack stack;
	
	public ArmourSetExperience(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String nameToAdd) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		// TODO Auto-generated constructor stub
	this.setCreativeTab(CreativeTabs.tabCombat);
	this.maxStackSize = 1;
	this.material = par2EnumArmorMaterial;
	this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
	par2EnumArmorMaterial.getDamageReductionAmount(par4);
	nametoadd = nameToAdd;
	
	
	
	//  stack.addEnchantment(Enchantment.featherFalling, 5);
      //stack.addEnchantment(Enchantment.protection, 5);
      //stack.addEnchantment(Enchantment.blastProtection, 5);
      //stack.addEnchantment(Enchantment.fireProtection, 5);
      //stack.addEnchantment(Enchantment.respiration, 5);
      //stack.addEnchantment(Enchantment.aquaAffinity, 5);
	
      
//      for (int i = 0; i < enchantmentIds.length; i++) {
       //   stack.addEnchantment(enchantmentIds[i], enchantmentLevels[i]);
  //    }
	//
	}

    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
    	stack.addEnchantment(Enchantment.featherFalling, 1);
            stack.addEnchantment(Enchantment.protection, 1);
            stack.addEnchantment(Enchantment.blastProtection, 1);
            stack.addEnchantment(Enchantment.fireProtection, 1);
            stack.addEnchantment(Enchantment.respiration, 1);
            stack.addEnchantment(Enchantment.aquaAffinity, 1);
        //	stack.func_111284_a(Enchantment.featherFalling, 5);

    }
//	
    public NBTTagList func_92110_g(ItemStack par1ItemStack)
    {
        return par1ItemStack.stackTagCompound != null && par1ItemStack.stackTagCompound.hasKey("StoredEnchantments") ? (NBTTagList)par1ItemStack.stackTagCompound.getTag("StoredEnchantments") : new NBTTagList();
    }

    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
        NBTTagList var5 = this.func_92110_g(par1ItemStack);

        if (var5 != null)
        {
            for (int var6 = 0; var6 < var5.tagCount(); ++var6)
            {
                short var7 = ((NBTTagCompound)var5.tagAt(var6)).getShort("id");
                short var8 = ((NBTTagCompound)var5.tagAt(var6)).getShort("lvl");

                if (Enchantment.enchantmentsList[var7] != null)
                {
                    par3List.add(Enchantment.enchantmentsList[var7].getTranslatedName(var8));
                }
            }
        }
    }
    public void onArmorTickUpdate(World world, Player player, ItemStack itemStack) {
        
    	 for (int i = 0; i < enchantmentIds.length; i++) {
    	    	stack.addEnchantment(Enchantment.featherFalling, 1);
         }
    	
      }
      
    
    
    
    
    
    
    
    
    
    
//    
//  public void inventoryTick(ItemStack stack, World worldInD, Entity entityIn, int itemSlot, boolean isSelected) {
//            for (int i = 0; i < enchantmentIds.length; i++) {
//                stack.addEnchantment(enchantmentIds[i], enchantmentLevels[i]);
//            }
//    }
//    
	
	
  
  
  
	public EnumArmorMaterial material;
	public String nametoadd;
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		if(stack.toString().contains("legginngs")) {
		return "chaosawakens:" + nametoadd + "_2.png";	
		}
		if(stack.toString().contains("Leggings")) if(itemID == chaosawakens.ChaosAwakens.EXPERIENCE_LEGGINGS.itemID)
				{
			return "chaosawakens:" + nametoadd + "_2.png";
				}
		
		return "chaosawakens:" + nametoadd + "_1.png";
		
		
	}
	
		
	public void registerIcons (IconRegister par1iconRegister)
	{
		if (itemID == ChaosAwakens.EXPERIENCE_HELMET.itemID) {
			itemIcon = par1iconRegister.registerIcon("chaosawakens:experience_helmet");
		}
if (itemID == ChaosAwakens.EXPERIENCE_CHESTPLATE.itemID) {
	itemIcon = par1iconRegister.registerIcon("chaosawakens:experience_chestplate");

		}
if (itemID == ChaosAwakens.EXPERIENCE_LEGGINGS.itemID) {
	itemIcon = par1iconRegister.registerIcon("chaosawakens:experience_leggings");

}
if (itemID == ChaosAwakens.EXPERIENCE_BOOTS.itemID) {
	itemIcon = par1iconRegister.registerIcon("chaosawakens:experience_boots");
	
}
		
	}
	
	
	
	
}
