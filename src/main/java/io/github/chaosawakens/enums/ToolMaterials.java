package io.github.chaosawakens.enums;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Enum dedicated to storing tool material data
 * @author invalid2
 *
 */
public enum ToolMaterials
{
	EMERALD("emerald", 4, 1600, 9.0F, 5.0F, 12),
	AMETHYST("amethyst", 4, 1800, 10.0F, 6.0F, 14),
	RUBY("ruby", 4, 2000, 11.0F, 7.0F, 16),
	TIGERS_EYE("tigers_eye", 3, 1561, 8.0F, 4.0F, 10),
	OPTIMISED("optimised", 4, 2200, 12.0F, 8.0F, 18),
	EXPERIENCE("experience", 4, 1600, 9.0F, 5.0F, 12), //TODO Change those values and those below
	ULTIMATE("ultimate", 4, 1800, 10.0F, 6.0F, 14),
	FAIRY("fairy", 4, 2000, 11.0F, 7.0F, 16),
	NIGHTMARE("nightmare", 3, 1561, 8.0F, 4.0F, 10),
	POISON("poison", 4, 2200, 12.0F, 8.0F, 18),
	BIG_HAMMER("queen_scale", 4, 2200, 12.0F, 8.0F, 12),
	BATTLE_AXE("queen_scale", 4, 2200, 12.0F, 8.0F, 12),
	QUEEN_SCALE("queen_scale", 4, 20000, 50.0F, 135.0F, 12),
	RAT("rat", 4, 1800, 10.0F, 6.0F, 14),
	BIG_BERTHA("big_bertha", 10, 15000, 35.0F, 86.0F, 16),
	ROYAL_GUARDIAN("royal_guardian", 10, 20000, 50.0F, 146.0F, 16);
	
	private String name;
	private int harvestLevel;
	private int maxUses;
	private float efficiency;
	private float damage;
	private int enchantability;
	private ToolMaterial material;
	
	/**
	 * 
	 * @param name Unlocalized and registry names
	 * @param harvestLevel Harvest level
	 * @param maxUses Durability
	 * @param efficiency efficiency
	 * @param damage Material base damage
	 * @param enchantability Material base enchantability
	 */
	private ToolMaterials(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
		this.name = name;
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.damage = damage;
		this.enchantability = enchantability;
		this.material = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getHarvestLevel()
	{
		return harvestLevel;
	}
	
	public int getMaxUses()
	{
		return maxUses;
	}
	
	public float getEfficiency()
	{
		return efficiency;
	}
	
	public float getDamage()
	{
		return damage;
	}
	
	public int getEnchantability()
	{
		return enchantability;
	}
	
	public ToolMaterial getToolMaterial()
	{
		return material;
	}
}
