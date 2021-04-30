package io.github.chaosawakens.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModCreativeTabs
{
	
	public static final CreativeTabs BLOCKS = new CreativeTabs("chaos_awakens_blocks_creative_tab") { @Override public ItemStack getTabIconItem() {return new ItemStack(ModBlocks.TITANIUM_BLOCK);} };
	public static final CreativeTabs ITEMS = new CreativeTabs("chaos_awakens_items_creative_tab") { @Override public ItemStack getTabIconItem() {return new ItemStack(ModItems.CORN);} };
	public static final CreativeTabs EQUIPMENT = new CreativeTabs("chaos_awakens_equipment_creative_tab") { @Override public ItemStack getTabIconItem() {return new ItemStack(ModItems.ULTIMATE_AXE);} };
	
	public ModCreativeTabs(){}
}
