package io.github.chaosawakens;

import java.util.ArrayList;
import java.util.List;

import io.github.chaosawakens.blocks.GenericBlock;
import io.github.chaosawakens.blocks.OreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.DimensionType;

/**
 * Class for block creation, such that the main class is not unreadable
 * @author invalid2
 */
public class ModBlocks
{
	
	/**
	 * List holding ALL mod blocks
	 */
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	/**
	 * List holding ALL mod blocks
	 */
	public static final List<OreBlock> ORES = new ArrayList<OreBlock>();
	
	public static final Block RUBY_BLOCK = new GenericBlock("ruby_block", Material.IRON);
	public static final Block TIGERS_EYE_BLOCK = new GenericBlock("tigers_eye_block", Material.IRON);
	public static final Block TITANIUM_BLOCK = new GenericBlock("titanium_block", Material.IRON);
	public static final Block URANIUM_BLOCK = new GenericBlock("uranium_block", Material.IRON);
	public static final Block ALUMINIUM_BLOCK = new GenericBlock("aluminum_block", Material.IRON);
	
	public static final Block DRUID_KEYHOLE = new GenericBlock("druid_keyhole", Material.WOOD, SoundType.WOOD);
	
	public static final Block OIL_ORE = new OreBlock("oil_ore", Material.IRON, 2, DimensionType.OVERWORLD, 20, 60, 7, 6);
	public static final Block RUBY_ORE = new OreBlock("ruby_ore", Material.IRON, 3, DimensionType.OVERWORLD, 1, 30, 5, 4, ModItems.RUBY);
	public static final Block AMETHYST_ORE = new OreBlock("amethyst_ore", Material.IRON, 4, DimensionType.OVERWORLD, 1, 20, 4, 3, ModItems.AMETHYST);
	
	public static final Block DRIED_EMERALD_AlLIGATOR = new OreBlock("dried_emerald_alligator", Material.IRON, 2, DimensionType.OVERWORLD, 10, 60, 4, 6);
	public static final Block DRIED_RUBY_BETTLE = new OreBlock("dried_ruby_beetle", Material.IRON, 2, DimensionType.OVERWORLD, 15, 60, 4, 6);
	public static final Block DRIED_SWARM = new OreBlock("dried_swarm", Material.IRON, 2, DimensionType.OVERWORLD, 15, 60, 4, 6);
	public static final Block DRIED_TREE_MONSTER = new OreBlock("dried_tree_monster", Material.IRON, 2, DimensionType.OVERWORLD, 15, 60, 4, 6);
	
	public ModBlocks()
	{
		
	}
}
