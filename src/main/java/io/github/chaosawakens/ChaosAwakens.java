package io.github.chaosawakens;

import io.github.chaosawakens.registry.ModBlocks;
import io.github.chaosawakens.registry.ModCreativeTabs;
import io.github.chaosawakens.registry.ModItems;
import io.github.chaosawakens.registry.ModRecipes;
import io.github.chaosawakens.worldgenerators.OreWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ChaosAwakens.MODID, name = ChaosAwakens.NAME, version = ChaosAwakens.VERSION)
public class ChaosAwakens
{
	
	public static final String MODID = "chaosawakens";
	public static final String NAME = "Chaos Awakens";
	public static final String VERSION = "1,0";
	public static final String CLIENT = "io.github.chaosawakens.ClientProxy";
	public static final String COMMON = "io.github.chaosawakens.CommonProxy";
	
	@Instance
	public static ChaosAwakens instance;
	
	@SidedProxy(clientSide = CLIENT, serverSide = COMMON)
	public static CommonProxy proxy;
	
	//Items class holding ALL the items
	ModItems items = new ModItems();
	
	//Blocks class holding ALL the blocks
	ModBlocks blocks = new ModBlocks();
	
	//Recipes class holding ALL the coded recipes
	ModRecipes recipes;
	//Class holding ALL the loot tables
	//LootTables tables;
	
	CreativeTabDebug debugTab;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		debugTab = new CreativeTabDebug("creative_debug_tab");
		
		ModCreativeTabs tabs = new ModCreativeTabs();
		//tables = new LootTables();
		
		GameRegistry.registerWorldGenerator( new OreWorldGenerator(), 0);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		recipes = new ModRecipes();
    }
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event)
	{

	}
	
}
