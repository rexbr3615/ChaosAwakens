package io.github.chaosawakens.items;

import io.github.chaosawakens.registry.ModCreativeTabs;
import io.github.chaosawakens.registry.ModItems;
import net.minecraft.item.ItemFood;

public class GenericFood extends ItemFood {

	public GenericFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModCreativeTabs.ITEMS);
		ModItems.ITEMS.add(this);
	}

}
