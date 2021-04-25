package chaosawakens;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraftforge.common.*;

@Mod(modid = "chaosawakens", name = "Chaos Awakening", version = "0,0,1 Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class ChaosAwakens {
@SidedProxy (clientSide = "chaosawakens.ClientProxy", serverSide = "chaosawakens.CommonProxy")
	public static CommonProxy proxy;
public static int MinBlockID = 2700;
public static int MinItemID = 9000;

//public void registerIcons(IconRegister iconRegister)
//{
//itemIcon = iconRegister.registerIcon("chaosawakens:" + this.getUnlocalizedName());	
//}
	
//Blocks	
public static Block AMETHYST_BLOCK = new AmethystBlock(MinBlockID + 110, Material.iron).setUnlocalizedName("amethyst_block");
public static Block RUBY_BLOCK = new RubyBlock(MinBlockID + 109, Material.iron).setUnlocalizedName("ruby_block");
public static Block TIGERS_EYE_BLOCK = new TigerEyeBlock(MinBlockID + 218, Material.iron).setUnlocalizedName("tigers_eye_block");
public static Block TITANIUM_BLOCK = new TitaniumBlock(MinBlockID + 108, Material.iron).setUnlocalizedName("titanium_block");
public static Block URANIUM_BLOCK = new UraniumBlock(MinBlockID + 107, Material.iron).setUnlocalizedName("uranium_block");
public static Block ALUMINIUM_BLOCK = new AluminiumBlock(1601, Material.iron).setUnlocalizedName("aluminium_block");





//Items
public static Item AMETHYST = new Amethyst(MinItemID + 260).setUnlocalizedName("amethyst");
public static Item RUBY = new Ruby(MinItemID + 270).setUnlocalizedName("ruby");
public static Item TIGERS_EYE = new TigerEye(MinItemID + 358).setUnlocalizedName("tigers_eye");
public static Item TITANIUM_INGOT = new Titanium(MinItemID + 151).setUnlocalizedName("titanium_ingot");
public static Item TITANIUM_NUGGET = new TitaniumNugget(MinItemID + 153).setUnlocalizedName("titanium_nugget");
public static Item URANIUM_INGOT = new Uranium(MinItemID + 152).setUnlocalizedName("uranium_ingot");
public static Item URANIUM_NUGGET = new UraniumNugget(MinItemID + 150).setUnlocalizedName("uranium_nugget");
public static Item ALUMINIUM_INGOT = new Aluminium(MinItemID + 1602).setUnlocalizedName("aluminium_ingot");
//public static Item Oil = new GenericItem(ItemID + 260).setUnlocalizedName("amethyst");


// Tool Materials
public static EnumToolMaterial TOOL_EMERALD = EnumHelper.addToolMaterial("TOOL_EMERALD", 2, 2000, 10.0F, 9.0F, 10);
public static EnumToolMaterial TOOL_AMETHYST = EnumHelper.addToolMaterial("TOOL_AMETHYST", 8, 5000, 20.0F, 18.0F, 20);
public static EnumToolMaterial TOOL_RUBY = EnumHelper.addToolMaterial("TOOL_RUBY", 12, 8000, 20.0F, 30.0F, 30);
public static EnumToolMaterial TOOL_TIGERS_EYE = EnumHelper.addToolMaterial("TOOL_TIGERS_EYE", 15, 3500, 15.0F, 10.0F, 15);
public static EnumToolMaterial TOOL_ULTIMATE = EnumHelper.addToolMaterial("TOOL_ULTIMATE", 15, 15000, 30.0F, 50.0F, 45);
public static EnumToolMaterial TOOL_OPTIMISED = EnumHelper.addToolMaterial("TOOL_OPTIMISED", 15, 13000, 75.0F, 8.0F, 45);


//Tools
public static Item EMERALD_SWORD = new EmeraldSword(MinItemID + 280, TOOL_EMERALD).setUnlocalizedName("emerald_sword");
public static Item EMERALD_PICKAXE = new EmeraldPickaxe(MinItemID + 281, TOOL_EMERALD).setUnlocalizedName("emerald_pickaxe");
public static Item EMERALD_SHOVEL = new EmeraldShovel(MinItemID + 282, TOOL_EMERALD).setUnlocalizedName("emerald_shovel");
public static Item EMERALD_HOE = new EmeraldHoe(MinItemID + 283, TOOL_EMERALD).setUnlocalizedName("emerald_hoe");
public static Item EMERALD_AXE = new EmeraldAxe(MinItemID + 284, TOOL_EMERALD).setUnlocalizedName("emerald_axe");


public static Item AMETHYST_SWORD = new AmethystSword(MinItemID + 261, TOOL_AMETHYST).setUnlocalizedName("ametheyst_sword");
public static Item AMETHYST_PICKAXE = new AmethystPickaxe(MinItemID + 262, TOOL_AMETHYST).setUnlocalizedName("amethyst_pickaxe");
public static Item AMETHYST_SHOVEL = new AmethystShovel(MinItemID + 263, TOOL_AMETHYST).setUnlocalizedName("amethyst_shovel");
public static Item AMETHYST_HOE = new AmethystHoe(MinItemID + 264, TOOL_AMETHYST).setUnlocalizedName("anethyst_hoe");
public static Item AMETHYST_AXE = new AmethystAxe(MinItemID + 265, TOOL_AMETHYST).setUnlocalizedName("anethyst_axe");


public static Item RUBY_SWORD = new RubySword(MinItemID + 271, TOOL_RUBY).setUnlocalizedName("ruby_sword");
public static Item RUBY_PICKAXE = new RubyPickaxe(MinItemID + 272, TOOL_RUBY).setUnlocalizedName("ruby_pickaxe");
public static Item RUBY_SHOVEL = new RubyShovel(MinItemID + 273, TOOL_RUBY).setUnlocalizedName("ruby_shovel");
public static Item RUBY_HOE = new RubyHoe(MinItemID + 274, TOOL_RUBY).setUnlocalizedName("ruby_hoe");
public static Item RUBY_AXE = new RubyAxe(MinItemID + 275, TOOL_RUBY).setUnlocalizedName("ruby_axe");


public static Item TIGERS_EYE_SWORD = new TigerEyeSword(MinItemID + 349, TOOL_TIGERS_EYE).setUnlocalizedName("tigers_eye_sword");
public static Item TIGERS_EYE_PICKAXE = new TigerEyePic(MinItemID + 350, TOOL_TIGERS_EYE).setUnlocalizedName("tigers_eye_pickaxe");
public static Item TIGERS_EYE_SHOVEL = new TigerEyeShovel(MinItemID + 351, TOOL_TIGERS_EYE).setUnlocalizedName("tigers_eye_shovel");
public static Item TIGERS_EYE_HOE = new TigerEyeHoe(MinItemID + 352, TOOL_TIGERS_EYE).setUnlocalizedName("tigers_eye_hoe");
public static Item TIGERS_EYE_AXE = new TigerEyeAxe(MinItemID + 353, TOOL_TIGERS_EYE).setUnlocalizedName("tigers_eye_axe");

public static Item ULTIMATE_SWORD = new UltimateSword(MinItemID + 302, TOOL_ULTIMATE).setUnlocalizedName("ultimate_sword");
public static Item ULTIMATE_PICKAXE = new UltimatePickaxe(MinItemID + 305, TOOL_ULTIMATE).setUnlocalizedName("ultimate_pickaxe");
public static Item ULTIMATE_SHOVEL = new UltimateShovel(MinItemID + 306, TOOL_ULTIMATE).setUnlocalizedName("ultimate_shovel");
public static Item ULTIMATE_HOE = new UltimateHoe(MinItemID + 307, TOOL_ULTIMATE).setUnlocalizedName("ultimate_hoe");
public static Item ULTIMATE_AXE = new UltimateAxe(MinItemID + 308, TOOL_ULTIMATE).setUnlocalizedName("ultimate_axe");


public static Item OPTIMISED_PICKAXE = new OptimisedPickaxe(6003, TOOL_OPTIMISED).setUnlocalizedName("optimised_pickaxe");
public static Item OPTIMISED_SHOVEL = new OptimisedShovel(6004, TOOL_OPTIMISED).setUnlocalizedName("opimised_shovel");

//Armour Materials
public static EnumArmorMaterial ArmourEmerald = EnumHelper.addArmorMaterial("EMERALD", 25, new int [] {5, 10, 10, 5}, 20);
public static EnumArmorMaterial ArmourAmethyst = EnumHelper.addArmorMaterial("AMETHYST", 25, new int [] {10, 20, 20, 10}, 20);
public static EnumArmorMaterial ArmourRuby = EnumHelper.addArmorMaterial("RUBY", 50, new int [] {15, 25, 25, 15}, 60);
public static EnumArmorMaterial ArmourTigerEye = EnumHelper.addArmorMaterial("TIGEREYE", 35, new int [] {10, 15, 15,10}, 30);
public static EnumArmorMaterial UltimateArmour = EnumHelper.addArmorMaterial("ULTIMATE", 35, new int [] {10, 15, 15,10}, 30);


//Armour
public static Item EMERALD_HELMET = new ArmourSetEmerald(MinItemID + 285, ArmourEmerald, 0, 0, "EMERALD").setUnlocalizedName("emerald_helmet"); 
public static Item EMERALD_CHESTPLATE = new ArmourSetEmerald(MinItemID + 286, ArmourEmerald, 0, 1, "EMERALD").setUnlocalizedName("emerald_chestplate"); 
public static Item EMERALD_LEGGINGS = new ArmourSetEmerald(MinItemID + 287, ArmourEmerald, 0, 2, "EMERALD").setUnlocalizedName("emerald_leggings"); 
public static Item EMERALD_BOOTS = new ArmourSetEmerald(MinItemID + 288, ArmourEmerald, 0, 3, "EMERALD").setUnlocalizedName("emerald_boots"); 


public static Item AMETHYST_HELMET = new ArmourSetAmethyst(MinItemID + 266, ArmourAmethyst, 0, 0, "AMETHYST").setUnlocalizedName("amethyst_helmet"); 
public static Item AMETHYST_CHESTPLATE = new ArmourSetAmethyst(MinItemID + 267, ArmourAmethyst, 0, 1, "AMETHYST").setUnlocalizedName("amethyst_chestplate"); 
public static Item AMETHYST_LEGGINGS = new ArmourSetAmethyst(MinItemID + 268, ArmourAmethyst, 0, 2, "AMETHYST").setUnlocalizedName("amethyst_leggings"); 
public static Item AMETHYST_BOOTS = new ArmourSetAmethyst(MinItemID + 269, ArmourAmethyst, 0, 3, "AMETHYST").setUnlocalizedName("amethyst_boots"); 

public static Item TIGERS_EYE_HELMET = new ArmourSetTigerEye(MinItemID + 354, ArmourTigerEye, 0, 0, "TIGERS_EYE").setUnlocalizedName("tigers_eye_helmet"); 
public static Item TIGERS_EYE_CHESTPLATE = new ArmourSetTigerEye(MinItemID + 355, ArmourTigerEye, 0, 1, "TIGERS_EYE").setUnlocalizedName("tigers_eye_chestplate"); 
public static Item TIGERS_EYE_LEGGINGS = new ArmourSetTigerEye(MinItemID + 356, ArmourTigerEye, 0, 2, "TIGERS_EYE").setUnlocalizedName("tigers_eye_leggings"); 
public static Item TIGERS_EYE_BOOTS = new ArmourSetTigerEye(MinItemID + 357, ArmourTigerEye, 0, 3, "TIGERS_EYE").setUnlocalizedName("tigers_eye_boots"); 

public static Item RUBY_HELMET = new ArmourSetRuby(MinItemID + 276, ArmourRuby, 0, 0, "RUBY").setUnlocalizedName("ruby_helmet"); 
public static Item RUBY_CHESTPLATE = new ArmourSetRuby(MinItemID + 277, ArmourRuby, 0, 1, "RUBY").setUnlocalizedName("ruby_chestplate"); 
public static Item RUBY_LEGGINGS = new ArmourSetRuby(MinItemID + 278, ArmourRuby, 0, 2, "RUBY").setUnlocalizedName("ruby_leggings"); 
public static Item RUBY_BOOTS = new ArmourSetRuby(MinItemID + 279 , ArmourRuby, 0, 3, "RUBY").setUnlocalizedName("ruby_boots"); 

public static Item ULTIMATE_HELMET = new ArmourSetUltimate(MinItemID + 309, UltimateArmour, 0, 0, "ULTIMATE").setUnlocalizedName("ultimate_helmet"); 
public static Item ULTIMATE_CHESTPLATE = new ArmourSetUltimate(MinItemID + 310, UltimateArmour, 0, 1, "ULTIMATE").setUnlocalizedName("ultimate_chestplate"); 
public static Item ULTIMATE_LEGGINGS = new ArmourSetUltimate(MinItemID + 311, UltimateArmour, 0, 2, "ULTIMATE").setUnlocalizedName("ultimate_leggings"); 
public static Item ULTIMATE_BOOTS = new ArmourSetUltimate(MinItemID + 312, UltimateArmour, 0, 3, "ULTIMATE").setUnlocalizedName("ultimate_boots"); 

//Ores
public static Block AMETHYST_ORE = new AmethystOre(MinBlockID + 103, Material.iron).setUnlocalizedName("amethyst_ore");
public static Block RUBY_ORE = new RubyOre(MinBlockID + 104, Material.iron).setUnlocalizedName("ruby_ore");
public static Block TIGERS_EYE_ORE = new TigerEyeOre(1607, Material.iron).setUnlocalizedName("tigers_eye_ore");
public static Block TITANIUM_ORE = new TitaniumOre(MinBlockID + 102, Material.iron).setUnlocalizedName("titanium_ore");
public static Block URANIUM_ORE = new UraniumOre(MinBlockID + 101, Material.iron).setUnlocalizedName("uranium_ore");
public static Block ALUMINIUM_ORE = new AluminiumOre(1606, Material.iron).setUnlocalizedName("aluminium_ore");
public static Block UNPROCESSED_OIL_ORE = new OilOre(1605, Material.rock).setUnlocalizedName("Unprocessed_oil_ore");
public static Block SALT_ORE = new SaltOre(MinBlockID + 100, Material.rock).setUnlocalizedName("salt_ore");

//WorldGen
public static AMETHYSTWORLDGEN AmethystWorldGen = new AMETHYSTWORLDGEN();
public static RUBYWORLDGEN RubyWorldGen = new RUBYWORLDGEN();
public static TIGERSEYEWORLDGEN TigersEyeWorldGen = new TIGERSEYEWORLDGEN();
public static TITANIUMWORLDGEN TitaniumWorldGen = new TITANIUMWORLDGEN();
public static URANIUMTWORLDGEN UraniumWorldGen = new URANIUMTWORLDGEN();
public static ALUMINIUMWORLDGEN AluminiumWorldGen = new ALUMINIUMWORLDGEN();
public static OILWORLDGEN OilWorldGen = new OILWORLDGEN();
public static SALTWORLDGEN SALTWorldGen = new SALTWORLDGEN();

@Init
public void load(FMLInitializationEvent event)
{
proxy.registerRenderInformation();	
}


	public ChaosAwakens ()
	{
		GameRegistry.registerBlock(AMETHYST_BLOCK);
LanguageRegistry.addName(AMETHYST_BLOCK, "Amethyst Block");
	
GameRegistry.registerBlock(RUBY_BLOCK);
LanguageRegistry.addName(RUBY_BLOCK, "Ruby Block");
	
	
GameRegistry.registerBlock(TIGERS_EYE_BLOCK);
LanguageRegistry.addName(TIGERS_EYE_BLOCK, "Tiger's Eye Block");
	
GameRegistry.registerBlock(TITANIUM_BLOCK);
LanguageRegistry.addName(TITANIUM_BLOCK, "Titanium Block");
	
GameRegistry.registerBlock(URANIUM_BLOCK);
LanguageRegistry.addName(URANIUM_BLOCK, "Uranium Block");
	
GameRegistry.registerBlock(ALUMINIUM_BLOCK);
LanguageRegistry.addName(ALUMINIUM_BLOCK, "ALUMINIUM Block");
	


GameRegistry.registerBlock(AMETHYST_ORE);
GameRegistry.registerBlock(TIGERS_EYE_ORE);
GameRegistry.registerBlock(RUBY_ORE);
GameRegistry.registerBlock(TITANIUM_ORE);
GameRegistry.registerBlock(URANIUM_ORE);
GameRegistry.registerBlock(UNPROCESSED_OIL_ORE);
GameRegistry.registerBlock(SALT_ORE);
GameRegistry.registerBlock(ALUMINIUM_ORE);

LanguageRegistry.addName(AMETHYST_ORE, "Amethyst Ore");
LanguageRegistry.addName(TIGERS_EYE_ORE, "Tiger's Eye Ore");
LanguageRegistry.addName(RUBY_ORE, "Ruby Ore");
LanguageRegistry.addName(TITANIUM_ORE, "Titanium");
LanguageRegistry.addName(URANIUM_ORE, "Uranium");
LanguageRegistry.addName(UNPROCESSED_OIL_ORE, "Unprocessed Oil Ore");
LanguageRegistry.addName(SALT_ORE, "Salt Ore");
LanguageRegistry.addName(ALUMINIUM_ORE, "Aluminium");



LanguageRegistry.addName(AMETHYST, "Amethyst");
LanguageRegistry.addName(RUBY, "Ruby");
LanguageRegistry.addName(TIGERS_EYE, "Tiger's Eye");
LanguageRegistry.addName(TITANIUM_INGOT, "Titanium Ingot");
LanguageRegistry.addName(TITANIUM_NUGGET, "Titanium Nugget");
LanguageRegistry.addName(URANIUM_INGOT, "Uranium Ingot");
LanguageRegistry.addName(URANIUM_NUGGET, "Uranium Nugget");
LanguageRegistry.addName(ALUMINIUM_INGOT, "Aluminium Ingot");


	

LanguageRegistry.addName(EMERALD_SWORD , "Emerald Sword");
LanguageRegistry.addName(EMERALD_PICKAXE , "Emerald Pickaxe");
LanguageRegistry.addName(EMERALD_SHOVEL , "Emerald Shovel");
LanguageRegistry.addName(EMERALD_HOE , "Emerald Hoe");
LanguageRegistry.addName(EMERALD_AXE , "Emerald Axe");


LanguageRegistry.addName(AMETHYST_SWORD , "Amethyst Sword");
LanguageRegistry.addName(AMETHYST_PICKAXE , "Amethyst Pickaxe");
LanguageRegistry.addName(AMETHYST_SHOVEL , "Amethyst Shovel");
LanguageRegistry.addName(AMETHYST_HOE , "Amethyst Hoe");
LanguageRegistry.addName(AMETHYST_AXE , "Amethyst Axe");


LanguageRegistry.addName(RUBY_SWORD , "Ruby Sword");
LanguageRegistry.addName(RUBY_PICKAXE , "Ruby Pickaxe");
LanguageRegistry.addName(RUBY_SHOVEL , "Ruby Shovel");
LanguageRegistry.addName(RUBY_HOE , "Ruby Hoe");
LanguageRegistry.addName(RUBY_AXE , "Ruby Axe");


LanguageRegistry.addName(TIGERS_EYE_SWORD , "Tiger's Eye Sword");
LanguageRegistry.addName(TIGERS_EYE_PICKAXE , "Tiger's Eye Pickaxe");
LanguageRegistry.addName(TIGERS_EYE_SHOVEL , "Tiger's Eye Shovel");
LanguageRegistry.addName(TIGERS_EYE_HOE , "Tiger's Eye Hoe");
LanguageRegistry.addName(TIGERS_EYE_AXE , "Tiger's Eye Axe");

LanguageRegistry.addName(ULTIMATE_SWORD , "Ultimate Sword");
LanguageRegistry.addName(ULTIMATE_PICKAXE ,"Ultimate Pickaxe");
LanguageRegistry.addName(ULTIMATE_SHOVEL , "Ultimate Shovel");
LanguageRegistry.addName(ULTIMATE_HOE , "Ultimate Hoe");
LanguageRegistry.addName(ULTIMATE_AXE, "Ultimate Axe");


LanguageRegistry.addName(OPTIMISED_PICKAXE , "Optimised Miner's Pickaxe");
LanguageRegistry.addName(OPTIMISED_SHOVEL , "Optimised Trench Digger's Shovel Spade");


//Armour
LanguageRegistry.addName(EMERALD_HELMET,"Emerald Helmet");
LanguageRegistry.addName(EMERALD_CHESTPLATE, "Emerald Chestplate");
LanguageRegistry.addName(EMERALD_LEGGINGS, "Emerald Leggings");
LanguageRegistry.addName(EMERALD_BOOTS, "Emerald boots");
LanguageRegistry.addName(TIGERS_EYE_HELMET, "Tiger's Eye Helmet");
LanguageRegistry.addName(TIGERS_EYE_CHESTPLATE, "Tiger's Eye Chestplate");
LanguageRegistry.addName(TIGERS_EYE_LEGGINGS, "Tiger's Eye Leggings");
LanguageRegistry.addName(TIGERS_EYE_BOOTS, "Tiger's Eye boots");


LanguageRegistry.addName(AMETHYST_HELMET,"Amethyst Helmet");
LanguageRegistry.addName(AMETHYST_CHESTPLATE, "Amethyst Chestplate");
LanguageRegistry.addName(AMETHYST_LEGGINGS, "Amethyst Leggings");
LanguageRegistry.addName(AMETHYST_BOOTS, "Amethyst boots");

LanguageRegistry.addName(RUBY_HELMET, "Ruby Helmet");
LanguageRegistry.addName(RUBY_CHESTPLATE, "Ruby Chestplate");
LanguageRegistry.addName(RUBY_LEGGINGS, "Ruby Leggings");
LanguageRegistry.addName(RUBY_BOOTS, "Ruby boots");

LanguageRegistry.addName(ULTIMATE_HELMET, "Ultimate Helmet");
LanguageRegistry.addName(ULTIMATE_CHESTPLATE, "Ultimate Chestplate");
LanguageRegistry.addName(ULTIMATE_LEGGINGS, "Ultimate Leggings");
LanguageRegistry.addName(ULTIMATE_BOOTS, "Ultimate boots");


	}
	
	
	
	
	
	
	
}
