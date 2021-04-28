package chaosawakens;

//import java.lang.module.Configuration;

import chaosawakens.armour.ArmourSetAluminium;
import chaosawakens.armour.ArmourSetAmethyst;
import chaosawakens.armour.ArmourSetCopper;
import chaosawakens.armour.ArmourSetEmerald;
import chaosawakens.armour.ArmourSetExperience;
import chaosawakens.armour.ArmourSetLapisBlock;
import chaosawakens.armour.ArmourSetLavaEel;
import chaosawakens.armour.ArmourSetMobzilla;
import chaosawakens.armour.ArmourSetMothScale;
import chaosawakens.armour.ArmourSetPeckockFeather;
import chaosawakens.armour.ArmourSetPinkTourmaline;
import chaosawakens.armour.ArmourSetPlatinum;
import chaosawakens.armour.ArmourSetQueen;
import chaosawakens.armour.ArmourSetRoyal;
import chaosawakens.armour.ArmourSetRuby;
import chaosawakens.armour.ArmourSetSilver;
import chaosawakens.armour.ArmourSetTigerEye;
import chaosawakens.armour.ArmourSetTin;
import chaosawakens.armour.ArmourSetUltimate;
import chaosawakens.blocks.AluminiumBlock;
import chaosawakens.blocks.AmethystBlock;
import chaosawakens.blocks.RubyBlock;
import chaosawakens.blocks.TigerEyeBlock;
import chaosawakens.blocks.TitaniumBlock;
import chaosawakens.blocks.UraniumBlock;
import chaosawakens.ingots.Aluminium;
import chaosawakens.ingots.Amethyst;
import chaosawakens.ingots.Copper;
import chaosawakens.ingots.PinkTourmaline;
import chaosawakens.ingots.Platinum;
import chaosawakens.ingots.Ruby;
import chaosawakens.ingots.Silver;
import chaosawakens.ingots.TigerEye;
import chaosawakens.ingots.Tin;
import chaosawakens.ingots.Titanium;
import chaosawakens.ingots.TitaniumNugget;
import chaosawakens.ingots.Uranium;
import chaosawakens.ingots.UraniumNugget;
import chaosawakens.ores.ALUMINIUMWORLDGEN;
import chaosawakens.ores.AMETHYSTWORLDGEN;
import chaosawakens.ores.AluminiumOre;
import chaosawakens.ores.AmethystOre;
import chaosawakens.ores.OILWORLDGEN;
import chaosawakens.ores.OilOre;
import chaosawakens.ores.RUBYWORLDGEN;
import chaosawakens.ores.RubyOre;
import chaosawakens.ores.SALTWORLDGEN;
import chaosawakens.ores.SaltOre;
import chaosawakens.ores.TIGERSEYEWORLDGEN;
import chaosawakens.ores.TITANIUMWORLDGEN;
import chaosawakens.ores.TigerEyeOre;
import chaosawakens.ores.TitaniumOre;
import chaosawakens.ores.URANIUMTWORLDGEN;
import chaosawakens.ores.UraniumOre;
import chaosawakens.tools.amethyst.AmethystAxe;
import chaosawakens.tools.amethyst.AmethystHoe;
import chaosawakens.tools.amethyst.AmethystPickaxe;
import chaosawakens.tools.amethyst.AmethystShovel;
import chaosawakens.tools.amethyst.AmethystSword;
import chaosawakens.tools.emerald.EmeraldAxe;
import chaosawakens.tools.emerald.EmeraldHoe;
import chaosawakens.tools.emerald.EmeraldPickaxe;
import chaosawakens.tools.emerald.EmeraldShovel;
import chaosawakens.tools.emerald.EmeraldSword;
import chaosawakens.tools.optimised.OptimisedPickaxe;
import chaosawakens.tools.optimised.OptimisedShovel;
import chaosawakens.tools.ruby.RubyAxe;
import chaosawakens.tools.ruby.RubyHoe;
import chaosawakens.tools.ruby.RubyPickaxe;
import chaosawakens.tools.ruby.RubyShovel;
import chaosawakens.tools.ruby.RubySword;
import chaosawakens.tools.tigereye.TigerEyeAxe;
import chaosawakens.tools.tigereye.TigerEyeHoe;
import chaosawakens.tools.tigereye.TigerEyePic;
import chaosawakens.tools.tigereye.TigerEyeShovel;
import chaosawakens.tools.tigereye.TigerEyeSword;
import chaosawakens.tools.ultimate.UltimateAxe;
import chaosawakens.tools.ultimate.UltimateHoe;
import chaosawakens.tools.ultimate.UltimatePickaxe;
import chaosawakens.tools.ultimate.UltimateShovel;
import chaosawakens.tools.ultimate.UltimateSword;
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
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraftforge.common.*;
import net.minecraftforge.common.Configuration;
import chaosawakens.items.*;

@Mod(modid = "chaosawakens", name = "Chaos Awakening", version = "0,0,6 Alpha")
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
public static Item Oil = new Oil(6028).setUnlocalizedName("oil");
public static Item MobzillaScale = new MobzillaScale(6029).setUnlocalizedName("mobzillaScale");
public static Item QueenScale = new QueenScale(MinItemID + 453).setUnlocalizedName("queenScale");
public static Item MothScale = new MothScale(MinItemID + 156).setUnlocalizedName("mothScale");
public static Item TIN_INGOT = new Tin(6030).setUnlocalizedName("tin_ingot");
public static Item SILVER_INGOT = new Silver(6031).setUnlocalizedName("silver_ingot");
public static Item PLATINUM_INGOT = new Platinum(6032).setUnlocalizedName("platinum_ingot");
public static Item COPPER_INGOT = new Copper(6033).setUnlocalizedName("copper_ingot");
public static Item PinkTourmaline = new PinkTourmaline(MinItemID + 348).setUnlocalizedName("pink_tourmaline_ingot");
public static Item LAVA_EEL = new LAVAEEL(MinItemID + 157).setUnlocalizedName("LAVA_EEL");
public static Item PEACKOCK_FEATHER = new PEACKOCK_FEATHER(MinItemID + 255).setUnlocalizedName("PEACKOCK_FEATHER");
public static Item THUNDER_STAFF = new THUNDER_STAFF(MinItemID + 240).setUnlocalizedName("THUNDER_STAFF");

//Food
public static Item RAW_BACON = new RawBacon(MinItemID + 190,2, true).setUnlocalizedName("RAW_BACON");





// Tool Materials
public static EnumToolMaterial TOOL_EMERALD = EnumHelper.addToolMaterial("TOOL_EMERALD", 5, 2000, 10.0F, 9.0F, 10);
public static EnumToolMaterial TOOL_AMETHYST = EnumHelper.addToolMaterial("TOOL_AMETHYST", 8, 5000, 20.0F, 18.0F, 20);
public static EnumToolMaterial TOOL_RUBY = EnumHelper.addToolMaterial("TOOL_RUBY", 12, 8000, 20.0F, 30.0F, 30);
public static EnumToolMaterial TOOL_TIGERS_EYE = EnumHelper.addToolMaterial("TOOL_TIGERS_EYE", 15, 3500, 15.0F, 10.0F, 15);
public static EnumToolMaterial TOOL_ULTIMATE = EnumHelper.addToolMaterial("TOOL_ULTIMATE", 15, 15000, 30.0F, 50.0F, 45);
public static EnumToolMaterial TOOL_OPTIMISED = EnumHelper.addToolMaterial("TOOL_OPTIMISED", 15, 13000, 75.0F, 8.0F, 45);
public static EnumToolMaterial TOOL_Tin = EnumHelper.addToolMaterial ("TOOL_TIN", 4, 1500, 10.0F, 9.0F, 10);
public static EnumToolMaterial TOOL_Copper = EnumHelper.addToolMaterial ("TOOL_COPPER", 3, 1000, 10.0F, 9.0F, 10);
public static EnumToolMaterial TOOL_Silver = EnumHelper.addToolMaterial ("TOOL_SILVER", 4, 1500, 10.0F, 9.0F, 10);
public static EnumToolMaterial TOOL_Platinum = EnumHelper.addToolMaterial ("TOOL_PLATINUM", 4, 2000, 10.0F, 9.0F, 10);
public static EnumToolMaterial TOOL_Aluminium = EnumHelper.addToolMaterial ("TOOL_ALUMINIUM", 4, 1750, 10.0F, 9.0F, 10);


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
public static EnumArmorMaterial ArmourExperience = EnumHelper.addArmorMaterial("EXPERIENCE", 25, new int [] {3, 6, 8,3}, 20);
public static EnumArmorMaterial ROYAL_GUARDIAN_ARMOUR = EnumHelper.addArmorMaterial("ROYAL_GUARDIAN", 35, new int [] {15, 25, 25, 15}, 17);
public static EnumArmorMaterial QUEEN_SCALE_ARMOUR = EnumHelper.addArmorMaterial("QUEEN_SCALE", 20, new int [] {10, 15, 15,10}, 20);
public static EnumArmorMaterial MOBZILLA_SCALE_ARMOUR = EnumHelper.addArmorMaterial("MOBZILLA_SCALE", 20, new int [] {10, 15, 15,10}, 20);
public static EnumArmorMaterial LAPIS_LAZUI_ARMOUR = EnumHelper.addArmorMaterial("LAPIS", 25, new int [] {4, 10, 10,5}, 20);
public static EnumArmorMaterial LAVA_Eel_ARMOUR = EnumHelper.addArmorMaterial("LAVA_EEL", 20, new int [] {10, 15, 15,10}, 20);
public static EnumArmorMaterial PEACOCK_FEATHER_ARMOUR = EnumHelper.addArmorMaterial("PEACOCK", 50, new int [] {15, 25, 25,15}, 20);
public static EnumArmorMaterial ArmourPinkTourmaline = EnumHelper.addArmorMaterial("PinkTourmaline", 35, new int [] {10, 15, 15,10}, 30);
public static EnumArmorMaterial ArmourTin = EnumHelper.addArmorMaterial("Tin", 35, new int [] {10, 15, 15,10}, 30);
public static EnumArmorMaterial ArmourCopper = EnumHelper.addArmorMaterial("Copper", 15, new int [] {2, 5, 15,10}, 30);
public static EnumArmorMaterial ArmourSilver = EnumHelper.addArmorMaterial("Platinum", 30, new int [] {5, 10, 10,5}, 30);
public static EnumArmorMaterial ArmourPlatinum = EnumHelper.addArmorMaterial("Silver", 20, new int [] {4, 15, 15,10}, 30);
public static EnumArmorMaterial ArmourAluminium = EnumHelper.addArmorMaterial("Aluminium", 18, new int [] {3, 13, 13,8}, 30);
public static EnumArmorMaterial MOTH_SCALE_Armour = EnumHelper.addArmorMaterial("MOTH_SCALE", 18, new int [] {3, 13, 13,8}, 30);






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

public static Item TIN_HELMET = new ArmourSetTin(6008, ArmourTin, 0, 0, "TIN").setUnlocalizedName("tin_helmet"); 
public static Item TIN_CHESTPLATE = new ArmourSetTin(6009, ArmourTin, 0, 1, "TIN").setUnlocalizedName("tin_chestplate"); 
public static Item TIN_LEGGINGS = new ArmourSetTin(6010, ArmourTin, 0, 2, "TIN").setUnlocalizedName("tin_leggings"); 
public static Item TIN_BOOTS = new ArmourSetTin(6011, ArmourTin, 0, 3, "TIN").setUnlocalizedName("tin_boots"); 

public static Item COPPER_HELMET = new ArmourSetCopper(6012, ArmourCopper, 0, 0, "COPPER").setUnlocalizedName("ultimate_helmet"); 
public static Item COPPER_CHESTPLATE = new ArmourSetCopper(6013, ArmourCopper, 0, 1, "COPPER").setUnlocalizedName("ultimate_chestplate"); 
public static Item COPPER_LEGGINGS = new ArmourSetCopper(6014, ArmourCopper, 0, 2, "COPPER").setUnlocalizedName("ultimate_leggings"); 
public static Item COPPER_BOOTS = new ArmourSetCopper(6015, ArmourCopper, 0, 3, "COPPER").setUnlocalizedName("ultimate_boots"); 

public static Item PLATINUM_HELMET = new ArmourSetPlatinum(6016, ArmourPlatinum, 0, 0, "PLATINUM").setUnlocalizedName("platinum_helmet"); 
public static Item PLATINUM_CHESTPLATE = new ArmourSetPlatinum(6017, ArmourPlatinum, 0, 1, "PLATINUM").setUnlocalizedName("platinum_chestplate"); 
public static Item PLATNIUM_LEGGINGS = new ArmourSetPlatinum(6018, ArmourPlatinum, 0, 2, "PLATINUM").setUnlocalizedName("platinum_leggings"); 
public static Item PLATINUM_BOOTS = new ArmourSetPlatinum(6019, ArmourPlatinum, 0, 3, "PLATINUM").setUnlocalizedName("platinum_boots"); 

public static Item SILVER_HELMET = new ArmourSetSilver(6020, ArmourSilver, 0, 0, "SILVER").setUnlocalizedName("silver_helmet"); 
public static Item SILVER_CHESTPLATE = new ArmourSetSilver(6021, ArmourSilver, 0, 1, "SILVER").setUnlocalizedName("silver_chestplate"); 
public static Item SILVER_LEGGINGS = new ArmourSetSilver(6022, ArmourSilver, 0, 2, "SILVER").setUnlocalizedName("silver_leggings"); 
public static Item SILVER_BOOTS = new ArmourSetSilver(6023, ArmourSilver, 0, 3, "SILVER").setUnlocalizedName("silver_boots"); 

public static Item ALUMINIUM_HELMET = new ArmourSetAluminium(6024, ArmourAluminium, 0, 0, "ALUMINIUM").setUnlocalizedName("aluminium_helmet"); 
public static Item ALUMINUM_CHESTPLATE = new ArmourSetAluminium(6025, ArmourAluminium, 0, 1, "ALUMINIUM").setUnlocalizedName("aluminium_chestplate"); 
public static Item ALUMINIUM_LEGGINGS = new ArmourSetAluminium(6026, ArmourAluminium, 0, 2, "ALUMINIUM").setUnlocalizedName("aluminium_leggings"); 
public static Item ALUMINIUM_BOOTS = new ArmourSetAluminium(6027, ArmourAluminium, 0, 3, "ALUMINIUM").setUnlocalizedName("aluminium_boots"); 

public static Item EXPERIENCE_HELMET = new ArmourSetExperience(MinItemID + 290, ArmourExperience, 0, 0, "EXPERIENCE").setUnlocalizedName("experience_helmet"); 
public static Item EXPERIENCE_CHESTPLATE = new ArmourSetExperience(MinItemID + 291, ArmourExperience, 0, 1, "EXPERIENCE").setUnlocalizedName("experience_chestplate"); 
public static Item EXPERIENCE_LEGGINGS = new ArmourSetExperience(MinItemID + 292, ArmourExperience, 0, 2, "EXPERIENCE").setUnlocalizedName("experience_leggings"); 
public static Item EXPERIENCE_BOOTS = new ArmourSetExperience(MinItemID + 293, ArmourExperience, 0, 3, "EXPERIENCE").setUnlocalizedName("experience_boots"); 

public static Item ROYAL_GUARDIAN_HELMET = new ArmourSetRoyal(MinItemID + 402, ROYAL_GUARDIAN_ARMOUR, 0, 0, "ROYAL_GUARDIAN").setUnlocalizedName("royal_guardian_helmet"); 
public static Item ROYAL_GUARDIAN_CHESTPLATE = new ArmourSetRoyal(MinItemID + 403, ROYAL_GUARDIAN_ARMOUR, 0, 1, "ROYAL_GUARDIAN").setUnlocalizedName("royal_guardian_chestplate"); 
public static Item ROYAL_GUARDIAN_LEGGINGS = new ArmourSetRoyal(MinItemID + 404, ROYAL_GUARDIAN_ARMOUR, 0, 2, "ROYAL_GUARDIAN").setUnlocalizedName("royal_guardian_leggings"); 
public static Item ROYAL_GUARDIAN_BOOTS = new ArmourSetRoyal(MinItemID + 405, ROYAL_GUARDIAN_ARMOUR, 0, 3, "ROYAL_GUARDIAN").setUnlocalizedName("royal_guardian_boots"); 

public static Item QUEEN_SCALE_HELMET = new ArmourSetQueen(MinItemID + 454, QUEEN_SCALE_ARMOUR, 0, 0, "QUEEN_SCALE").setUnlocalizedName("queen_scale_helmet"); 
public static Item QUEEN_SCALE_CHESTPLATE = new ArmourSetQueen(MinItemID + 455, QUEEN_SCALE_ARMOUR, 0, 1, "QUEEN_SCALE").setUnlocalizedName("queen_scale_chestplate"); 
public static Item QUEEN_SCALE_LEGGINGS = new ArmourSetQueen(MinItemID + 456, QUEEN_SCALE_ARMOUR, 0, 2, "QUEEN_SCALE").setUnlocalizedName("queen_scale_leggings"); 
public static Item QUEEN_SCALE_BOOTS = new ArmourSetQueen(MinItemID + 457, QUEEN_SCALE_ARMOUR, 0, 3, "QUEEN_SCALE").setUnlocalizedName("queen_scale_boots"); 

public static Item MOBZILLA_SCALE_HELMET = new ArmourSetMobzilla(MinItemID + 395, MOBZILLA_SCALE_ARMOUR, 0, 0, "MOBZILLA_SCALE").setUnlocalizedName("mobzilla_scale_helmet"); 
public static Item MOBZILLA_SCALE_CHESTPLATE = new ArmourSetMobzilla(MinItemID + 396, MOBZILLA_SCALE_ARMOUR, 0, 1, "MOBZILLA_SCALE").setUnlocalizedName("mobzilla_scale_chestplate"); 
public static Item MOBZILLA_SCALE_LEGGINGS = new ArmourSetMobzilla(MinItemID + 397, MOBZILLA_SCALE_ARMOUR, 0, 2, "MOBZILLA_SCALE").setUnlocalizedName("mobzilla_scale_leggings"); 
public static Item MOBZILLA_SCALE_BOOTS = new ArmourSetMobzilla(MinItemID + 398, MOBZILLA_SCALE_ARMOUR, 0, 3, "MOBZILLA_SCALE").setUnlocalizedName("mobzilla_scale_boots"); 

public static Item LAPIS_LAZUI_HELMET = new ArmourSetLapisBlock(MinItemID + 450, LAPIS_LAZUI_ARMOUR, 0, 0, "LAPIS_BLOCK").setUnlocalizedName("lapis_block_helmet"); 
public static Item LAPIS_LAZUI_CHESTPLATE = new ArmourSetLapisBlock(MinItemID + 451, LAPIS_LAZUI_ARMOUR, 0, 1, "LAPIS_BLOCK").setUnlocalizedName("lapis_block_chestplate"); 
public static Item LAPIS_LAZUI_LEGGINGS = new ArmourSetLapisBlock(MinItemID + 452, LAPIS_LAZUI_ARMOUR, 0, 2, "LAPIS_BLOCK").setUnlocalizedName("lapis_block_leggings"); 
public static Item LAPIS_LAZUI_BOOTS = new ArmourSetLapisBlock(MinItemID + 453, LAPIS_LAZUI_ARMOUR, 0, 3, "LAPIS_BLOCK").setUnlocalizedName("lapis_block_boots"); 

public static Item LAVA_EEL_HELMET = new ArmourSetLavaEel(MinItemID + 298, LAVA_Eel_ARMOUR, 0, 0, "LAVA_EEl").setUnlocalizedName("lava_eel_helmet"); 
public static Item LAVA_EEL_CHESTPLATE = new ArmourSetLavaEel(MinItemID + 299, LAVA_Eel_ARMOUR, 0, 1, "LAVA_EEl").setUnlocalizedName("lava_eel_chestplate"); 
public static Item LAVA_EEL_LEGGINGS = new ArmourSetLavaEel(MinItemID + 300, LAVA_Eel_ARMOUR, 0, 2, "LAVA_EEl").setUnlocalizedName("lava_eel_leggings"); 
public static Item LAVA_EEL_BOOTS = new ArmourSetLavaEel(MinItemID + 301, LAVA_Eel_ARMOUR, 0, 3, "LAVA_EEl").setUnlocalizedName("lava_eel_boots"); 

public static Item PEACOCK_FEATHER_HELMET = new ArmourSetPeckockFeather(MinItemID + 359, PEACOCK_FEATHER_ARMOUR, 0, 0, "PEACOCK_FEATHER").setUnlocalizedName("peacock_feather_helmet"); 
public static Item PEACOCK_FEATHER_CHESTPLATE = new ArmourSetPeckockFeather(MinItemID + 360, PEACOCK_FEATHER_ARMOUR, 0, 1, "PEACOCK_FEATHER").setUnlocalizedName("peacock_feather_chestplate"); 
public static Item PEACOCK_FEATHER_LEGGINGS = new ArmourSetPeckockFeather(MinItemID + 370, PEACOCK_FEATHER_ARMOUR, 0, 2, "PEACOCK_FEATHER").setUnlocalizedName("peacock_feather_leggings"); 
public static Item PEACOCK_FEATHER_BOOTS = new ArmourSetPeckockFeather(MinItemID + 371, PEACOCK_FEATHER_ARMOUR, 0, 3, "PEACOCK_FEATHER").setUnlocalizedName("peacock_feather_boots"); 


public static Item PINK_TOURMALINE_HELMET = new ArmourSetPinkTourmaline(MinItemID + 344, ArmourPinkTourmaline, 0, 0, "PINK_TOURMALINE").setUnlocalizedName("pink_tourmaline_helmet"); 
public static Item PINK_TOURMALINE_CHESTPLATE = new ArmourSetPinkTourmaline(MinItemID + 345, ArmourPinkTourmaline, 0, 1, "PINK_TOURMALINE").setUnlocalizedName("pink_tourmaline_chestplate"); 
public static Item PINK_TOURMALINE_LEGGINGS = new ArmourSetPinkTourmaline(MinItemID + 346, ArmourPinkTourmaline, 0, 2, "PINK_TOURMALINE").setUnlocalizedName("pink_tourmaline_leggings"); 
public static Item PINK_TOURMALINE_BOOTS = new ArmourSetPinkTourmaline(MinItemID + 347, ArmourPinkTourmaline, 0, 3, "PINK_TOURMALINE").setUnlocalizedName("pink_tourmaline_boots"); 

public static Item MOTH_SCALE_HELMET = new ArmourSetMothScale(MinItemID + 294, MOTH_SCALE_Armour, 0, 0, "MOTH_SCALE").setUnlocalizedName("moth_scale_helmet"); 
public static Item MOTH_SCALE_CHESTPLATE = new ArmourSetMothScale(MinItemID + 295, MOTH_SCALE_Armour, 0, 1, "MOTH_SCALE").setUnlocalizedName("moth_scale_chestplate"); 
public static Item MOTH_SCALE_LEGGINGS = new ArmourSetMothScale(MinItemID + 296, MOTH_SCALE_Armour, 0, 2, "MOTH_SCALE").setUnlocalizedName("moth_scale_leggings"); 
public static Item MOTH_SCALE_BOOTS = new ArmourSetMothScale(MinItemID + 297, MOTH_SCALE_Armour, 0, 3, "MOTH_SCALE").setUnlocalizedName("moth_scale_boots"); 



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




LanguageRegistry.addName(ALUMINIUM_HELMET, "Aluminium Helmet");
LanguageRegistry.addName(ALUMINUM_CHESTPLATE, "Aluminium Chestplate");
LanguageRegistry.addName(ALUMINIUM_LEGGINGS, "Aluminium Leggings");
LanguageRegistry.addName(ALUMINIUM_BOOTS, "Aluminium boots");

LanguageRegistry.addName(TIN_HELMET, "Tin Helmet");
LanguageRegistry.addName(TIN_CHESTPLATE, "Tin Chestplate");
LanguageRegistry.addName(TIN_LEGGINGS, "Tin Leggings");
LanguageRegistry.addName(TIN_BOOTS, "Tin boots");

LanguageRegistry.addName(COPPER_HELMET, "Copper Helmet");
LanguageRegistry.addName(COPPER_CHESTPLATE, "Copper Chestplate");
LanguageRegistry.addName(COPPER_LEGGINGS, "Copper Leggings");
LanguageRegistry.addName(COPPER_BOOTS, "Copper boots");

LanguageRegistry.addName(PLATINUM_HELMET, "Platinum Helmet");
LanguageRegistry.addName(PLATINUM_CHESTPLATE, "Platinum Chestplate");
LanguageRegistry.addName(PLATNIUM_LEGGINGS, "Platinum Leggings");
LanguageRegistry.addName(PLATINUM_BOOTS, "Platinum boots");

LanguageRegistry.addName(SILVER_HELMET, "Silver Helmet");
LanguageRegistry.addName(SILVER_CHESTPLATE, "Silver Chestplate");
LanguageRegistry.addName(SILVER_LEGGINGS, "Silver Leggings");
LanguageRegistry.addName(SILVER_BOOTS, "Silver boots");

LanguageRegistry.addName(ROYAL_GUARDIAN_HELMET, "Royal Guardian Helmet");
LanguageRegistry.addName(ROYAL_GUARDIAN_CHESTPLATE, "Royal Guardian Chestplate");
LanguageRegistry.addName(ROYAL_GUARDIAN_LEGGINGS, "Royal Guardian Leggings");
LanguageRegistry.addName(ROYAL_GUARDIAN_BOOTS, "Royal Guardian Boots");

LanguageRegistry.addName(EXPERIENCE_HELMET, "Experience Helmet");
LanguageRegistry.addName(EXPERIENCE_CHESTPLATE, "Experience Chestplate");
LanguageRegistry.addName(EXPERIENCE_LEGGINGS, "Experience Leggings");
LanguageRegistry.addName(EXPERIENCE_BOOTS, "Experience Boots");

LanguageRegistry.addName(QUEEN_SCALE_HELMET, "Queen Scale Helmet");
LanguageRegistry.addName(QUEEN_SCALE_CHESTPLATE, "Queen Scale Chestplate");
LanguageRegistry.addName(QUEEN_SCALE_LEGGINGS, "Queen Scale Leggings");
LanguageRegistry.addName(QUEEN_SCALE_BOOTS, "Queen Scale Boots");

LanguageRegistry.addName(MOBZILLA_SCALE_HELMET, "Mobzilla Scale Helmet");
LanguageRegistry.addName(MOBZILLA_SCALE_CHESTPLATE, "Mobzilla Scale Chestplate");
LanguageRegistry.addName(MOBZILLA_SCALE_LEGGINGS, "Mobzilla Scale Leggings");
LanguageRegistry.addName(MOBZILLA_SCALE_BOOTS, "Mobzilla boots");

LanguageRegistry.addName(LAPIS_LAZUI_HELMET, "Lapis Block Helmet");
LanguageRegistry.addName(LAPIS_LAZUI_CHESTPLATE, "Lapis Block Chestplate");
LanguageRegistry.addName(LAPIS_LAZUI_LEGGINGS, "Lapis Block Leggings");
LanguageRegistry.addName(LAPIS_LAZUI_BOOTS, "Lapis Block boots");

LanguageRegistry.addName(LAVA_EEL_HELMET, "Lava Eel Helmet");
LanguageRegistry.addName(LAVA_EEL_CHESTPLATE, "Lava Eel Chestplate");
LanguageRegistry.addName(LAVA_EEL_LEGGINGS, "Lava Eel Leggings");
LanguageRegistry.addName(LAVA_EEL_BOOTS, "Lava Eel boots");

LanguageRegistry.addName(PEACOCK_FEATHER_HELMET, "Peacock Feather Helmet");
LanguageRegistry.addName(PEACOCK_FEATHER_CHESTPLATE, "Peacock Feather Chestplate");
LanguageRegistry.addName(PEACOCK_FEATHER_LEGGINGS, "Peacock Feather Leggings");
LanguageRegistry.addName(PEACOCK_FEATHER_BOOTS, "Peacock Feather boots");

LanguageRegistry.addName(PINK_TOURMALINE_HELMET, "Pink Tourmaline Helmet");
LanguageRegistry.addName(PINK_TOURMALINE_CHESTPLATE, "Pink Tourmaline Chestplate");
LanguageRegistry.addName(PINK_TOURMALINE_LEGGINGS, "Pink Tourmaline Leggings");
LanguageRegistry.addName(PINK_TOURMALINE_BOOTS, "Pink Tourmaline boots");


LanguageRegistry.addName(MOTH_SCALE_HELMET, "Ultimate Helmet");
LanguageRegistry.addName(MOTH_SCALE_CHESTPLATE, "Ultimate Chestplate");
LanguageRegistry.addName(MOTH_SCALE_LEGGINGS, "Ultimate Leggings");
LanguageRegistry.addName(MOTH_SCALE_BOOTS, "Ultimate boots");

LanguageRegistry.addName(Oil, "Oil");


//ItemStack experienceboots = new ItemStack(ChaosAwakens.EXPERIENCE_BOOTS);
//experienceboots.addEnchantment(Enchantment.fireAspect, 2);




GameRegistry.registerFuelHandler(new Fuels());
	
	

//Crafting Recepies

//Armour Recepies
GameRegistry.addRecipe(new ItemStack (MOBZILLA_SCALE_HELMET, 1), new Object [] {
"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.MobzillaScale		
});
GameRegistry.addRecipe(new ItemStack (MOBZILLA_SCALE_CHESTPLATE, 1), new Object [] {
"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.MobzillaScale		
});
GameRegistry.addRecipe(new ItemStack (MOBZILLA_SCALE_LEGGINGS, 1), new Object [] {
"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.MobzillaScale		
});
GameRegistry.addRecipe(new ItemStack (MOBZILLA_SCALE_BOOTS, 1), new Object [] {
"X X", "X X", "   ", 'X', chaosawakens.ChaosAwakens.MobzillaScale		
});
	
GameRegistry.addRecipe(new ItemStack (MOBZILLA_SCALE_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.MobzillaScale		
});



GameRegistry.addRecipe(new ItemStack (QUEEN_SCALE_HELMET, 1), new Object [] {
"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.QueenScale		
});
GameRegistry.addRecipe(new ItemStack (QUEEN_SCALE_CHESTPLATE, 1), new Object [] {
"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.QueenScale	
});
GameRegistry.addRecipe(new ItemStack (QUEEN_SCALE_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.QueenScale	
});
GameRegistry.addRecipe(new ItemStack (QUEEN_SCALE_BOOTS, 1), new Object [] {
"X X", "X X", "   ", 'X', chaosawakens.ChaosAwakens.QueenScale	
});
	
GameRegistry.addRecipe(new ItemStack (MOTH_SCALE_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.MothScale	
});

GameRegistry.addRecipe(new ItemStack (MOTH_SCALE_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.MothScale		
});
GameRegistry.addRecipe(new ItemStack (MOTH_SCALE_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.MothScale	
});
GameRegistry.addRecipe(new ItemStack (MOTH_SCALE_BOOTS, 1), new Object [] {
"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.MothScale	
});




GameRegistry.addRecipe(new ItemStack (PEACOCK_FEATHER_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.PEACKOCK_FEATHER	
});

GameRegistry.addRecipe(new ItemStack (PEACOCK_FEATHER_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.PEACKOCK_FEATHER		
});
GameRegistry.addRecipe(new ItemStack (PEACOCK_FEATHER_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.PEACKOCK_FEATHER	
});
GameRegistry.addRecipe(new ItemStack (PEACOCK_FEATHER_BOOTS, 1), new Object [] {
"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.PEACKOCK_FEATHER	
});




GameRegistry.addRecipe(new ItemStack (PINK_TOURMALINE_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.PinkTourmaline	
});
	
GameRegistry.addRecipe(new ItemStack (PINK_TOURMALINE_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.PinkTourmaline	
});


GameRegistry.addRecipe(new ItemStack (PINK_TOURMALINE_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.PinkTourmaline	
});
	
GameRegistry.addRecipe(new ItemStack (PINK_TOURMALINE_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.PinkTourmaline	
});

GameRegistry.addRecipe(new ItemStack (LAVA_EEL_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.LAVA_EEL	
});
	
GameRegistry.addRecipe(new ItemStack (LAVA_EEL_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.LAVA_EEL		
});


GameRegistry.addRecipe(new ItemStack (LAVA_EEL_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.LAVA_EEL		
});
	
GameRegistry.addRecipe(new ItemStack (LAVA_EEL_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.LAVA_EEL	
});






GameRegistry.addRecipe(new ItemStack (LAPIS_LAZUI_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', Block.blockLapis	
});
	
GameRegistry.addRecipe(new ItemStack (LAPIS_LAZUI_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', Block.blockLapis			
});


GameRegistry.addRecipe(new ItemStack (LAPIS_LAZUI_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', Block.blockLapis			
});
	
GameRegistry.addRecipe(new ItemStack (LAPIS_LAZUI_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', Block.blockLapis	
});




GameRegistry.addRecipe(new ItemStack (ALUMINIUM_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.ALUMINIUM_INGOT	
});
	
GameRegistry.addRecipe(new ItemStack (ALUMINUM_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.ALUMINIUM_INGOT			
});


GameRegistry.addRecipe(new ItemStack (ALUMINIUM_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.ALUMINIUM_INGOT			
});
	
GameRegistry.addRecipe(new ItemStack (ALUMINIUM_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.ALUMINIUM_INGOT		
});



GameRegistry.addRecipe(new ItemStack (COPPER_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.COPPER_INGOT	
});
	
GameRegistry.addRecipe(new ItemStack (COPPER_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.COPPER_INGOT			
});


GameRegistry.addRecipe(new ItemStack (COPPER_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.COPPER_INGOT			
});
	
GameRegistry.addRecipe(new ItemStack (COPPER_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.COPPER_INGOT		
});




GameRegistry.addRecipe(new ItemStack (SILVER_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.SILVER_INGOT	
});
	
GameRegistry.addRecipe(new ItemStack (SILVER_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.SILVER_INGOT			
});


GameRegistry.addRecipe(new ItemStack (SILVER_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.SILVER_INGOT			
});
	
GameRegistry.addRecipe(new ItemStack (SILVER_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.SILVER_INGOT		
});




GameRegistry.addRecipe(new ItemStack (TIN_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.TIN_INGOT	
});
	
GameRegistry.addRecipe(new ItemStack (TIN_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.TIN_INGOT			
});


GameRegistry.addRecipe(new ItemStack (TIN_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.TIN_INGOT			
});
	
GameRegistry.addRecipe(new ItemStack (TIN_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.TIN_INGOT		
});





GameRegistry.addRecipe(new ItemStack (PLATINUM_HELMET, 1), new Object [] {
"X X", "X X", "   ", 'X', chaosawakens.ChaosAwakens.PLATINUM_INGOT	
});
	
GameRegistry.addRecipe(new ItemStack (PLATINUM_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.PLATINUM_INGOT			
});


GameRegistry.addRecipe(new ItemStack (PLATNIUM_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.PLATINUM_INGOT			
});
	
GameRegistry.addRecipe(new ItemStack (PLATINUM_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.PLATINUM_INGOT		
});




GameRegistry.addRecipe(new ItemStack (RUBY_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.RUBY	
});
	
GameRegistry.addRecipe(new ItemStack (RUBY_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.RUBY			
});


GameRegistry.addRecipe(new ItemStack (RUBY_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.RUBY			
});

GameRegistry.addRecipe(new ItemStack (RUBY_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.RUBY
});


GameRegistry.addRecipe(new ItemStack (AMETHYST_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.AMETHYST	
});
	
GameRegistry.addRecipe(new ItemStack (AMETHYST_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.AMETHYST			
});


GameRegistry.addRecipe(new ItemStack (AMETHYST_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.AMETHYST			
});
	
GameRegistry.addRecipe(new ItemStack (AMETHYST_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.AMETHYST
});







GameRegistry.addRecipe(new ItemStack (TIGERS_EYE_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', chaosawakens.ChaosAwakens.TIGERS_EYE	
});
	
GameRegistry.addRecipe(new ItemStack (TIGERS_EYE_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', chaosawakens.ChaosAwakens.TIGERS_EYE			
});


GameRegistry.addRecipe(new ItemStack (TIGERS_EYE_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', chaosawakens.ChaosAwakens.TIGERS_EYE			
});
	
GameRegistry.addRecipe(new ItemStack (TIGERS_EYE_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', chaosawakens.ChaosAwakens.TIGERS_EYE
});



GameRegistry.addRecipe(new ItemStack (EMERALD_HELMET, 1), new Object [] {
		"XXX", "X X", "   ", 'X', Item.emerald	
});
	
GameRegistry.addRecipe(new ItemStack (EMERALD_CHESTPLATE, 1), new Object [] {
		"X X", "XXX", "XXX", 'X', Item.emerald			
});


GameRegistry.addRecipe(new ItemStack (EMERALD_LEGGINGS, 1), new Object [] {
		"XXX", "X X", "X X", 'X', Item.emerald		
});
	
GameRegistry.addRecipe(new ItemStack (EMERALD_BOOTS, 1), new Object [] {
"   ", "X X", "X X", 'X', Item.emerald
});









//Tool Recipies

GameRegistry.addRecipe(new ItemStack (EMERALD_PICKAXE, 1), new Object [] {
"XXX", " Y ", " Y ", 'X', Item.emerald, 'Y', Item.stick	
});
	
GameRegistry.addRecipe(new ItemStack (EMERALD_SWORD, 1), new Object [] {
" X ", " X ", " Y ", 'X', Item.emerald, 'Y', Item.stick			
});


GameRegistry.addRecipe(new ItemStack (EMERALD_HOE, 1), new Object [] {
"XX ", " Y ", " Y ", 'X', Item.emerald, 'Y', Item.stick			
});
	
GameRegistry.addRecipe(new ItemStack (EMERALD_AXE, 1), new Object [] {
"XX ", "XY ", " Y ", 'X', Item.emerald, 'Y', Item.stick	
});

GameRegistry.addRecipe(new ItemStack (EMERALD_SHOVEL, 1), new Object [] {
" X ", " Y ", " Y ", 'X', Item.emerald, 'Y', Item.stick	
});



GameRegistry.addRecipe(new ItemStack (AMETHYST_PICKAXE, 1), new Object [] {
"XXX", " Y ", " Y ", 'X', ChaosAwakens.AMETHYST, 'Y', Item.stick	
});
	
GameRegistry.addRecipe(new ItemStack (AMETHYST_SWORD, 1), new Object [] {
" X ", " X ", " Y ", 'X', ChaosAwakens.AMETHYST, 'Y', Item.stick			
});


GameRegistry.addRecipe(new ItemStack (AMETHYST_HOE, 1), new Object [] {
"XX ", " Y ", " Y ", 'X', ChaosAwakens.AMETHYST, 'Y', Item.stick			
});
	
GameRegistry.addRecipe(new ItemStack (AMETHYST_AXE, 1), new Object [] {
"XX ", "XY ", " Y ", 'X', ChaosAwakens.AMETHYST, 'Y', Item.stick	
});

GameRegistry.addRecipe(new ItemStack (AMETHYST_SHOVEL, 1), new Object [] {
" X ", " Y ", " Y ", 'X', ChaosAwakens.AMETHYST, 'Y', Item.stick	
});



GameRegistry.addRecipe(new ItemStack (RUBY_PICKAXE, 1), new Object [] {
"XXX", " Y ", " Y ", 'X', ChaosAwakens.RUBY, 'Y', Item.stick	
});
	
GameRegistry.addRecipe(new ItemStack (RUBY_SWORD, 1), new Object [] {
" X ", " X ", " Y ", 'X', ChaosAwakens.RUBY, 'Y', Item.stick			
});


GameRegistry.addRecipe(new ItemStack (RUBY_HOE, 1), new Object [] {
"XX ", " Y ", " Y ", 'X', ChaosAwakens.RUBY, 'Y', Item.stick			
});
	
GameRegistry.addRecipe(new ItemStack (RUBY_AXE, 1), new Object [] {
"XX ", "XY ", " Y ", 'X', ChaosAwakens.RUBY, 'Y', Item.stick	
});

GameRegistry.addRecipe(new ItemStack (RUBY_SHOVEL, 1), new Object [] {
" X ", " Y ", " Y ", 'X', ChaosAwakens.RUBY, 'Y', Item.stick	
});











	}
	
	
	
	
	
	
}
