package io.github.chaosawakens.registry;

//made by meme man
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes
{
	public ModRecipes()
	{
		GameRegistry.addSmelting(ModBlocks.AMETHYST_ORE, new ItemStack(ModItems.AMETHYST, 1), 0.2f);
		
		GameRegistry.addSmelting(ModBlocks.RUBY_ORE, new ItemStack(ModItems.RUBY, 1), 0.3f);
		
		GameRegistry.addSmelting(ModBlocks.TITANIUM_ORE, new ItemStack(ModItems.TITANIUM_INGOT, 1), 0.5f);
		
		GameRegistry.addSmelting(ModBlocks.URANIUM_ORE, new ItemStack(ModItems.URANIUM_INGOT, 1), 0.7f);
		
		GameRegistry.addSmelting(ModBlocks.TIGERS_EYE_ORE, new ItemStack(ModItems.TIGERS_EYE, 1), 0.4f);
		
	}
}