package io.github.chaosawakens.registry;

import java.util.ArrayList;
import java.util.List;

import io.github.chaosawakens.blocks.FacingBlock;
import io.github.chaosawakens.blocks.GenericBlock;
import io.github.chaosawakens.blocks.GenericBlock.BlockSettings;
import io.github.chaosawakens.blocks.GenericSlab;
import io.github.chaosawakens.blocks.OreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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
	
	public static final Block AMETHYST_BLOCK = new GenericBlock("amethyst_block", new BlockSettings().material(Material.IRON));
	public static final Block RUBY_BLOCK = new GenericBlock("ruby_block", new BlockSettings().material(Material.IRON));
	public static final Block TIGERS_EYE_BLOCK = new GenericBlock("tigers_eye_block", new BlockSettings().material(Material.IRON));
	public static final Block TITANIUM_BLOCK = new GenericBlock("titanium_block", new BlockSettings().material(Material.IRON));
	public static final Block URANIUM_BLOCK = new GenericBlock("uranium_block", new BlockSettings().material(Material.IRON));
	public static final Block ALUMINUM_BLOCK = new GenericBlock("aluminum_block", new BlockSettings().material(Material.IRON));
	//public static final Block ULTIMATIUM_BLOCK = new GenericBlock("ultimatium_block", new BlockSettings().material(Material.IRON));
	
	public static final Block DRUID_KEYHOLE = new FacingBlock("druid_keyhole", new BlockSettings().material(Material.WOOD).sound(SoundType.WOOD).strength(-1, 18_000_000));
	public static final Block DRUID_BARK_BLOCK = new GenericBlock("druid_bark", new BlockSettings().material(Material.WOOD).sound(SoundType.WOOD).strength(-1, 18_000_000));
	public static final GenericSlab DRUID_BARK_SLAB = new GenericSlab("druid_bark_slab", new BlockSettings().material(Material.WOOD).sound(SoundType.WOOD).strength(-1, 18_000_000).registerItem(false), false);
	public static final GenericSlab DRUID_BARK_SLAB_DOUBLE = new GenericSlab("druid_bark_slab_double", new BlockSettings().material(Material.WOOD).sound(SoundType.WOOD).strength(-1, 18_000_000).registerItem(false), true);
	public static final Block DRUID_GATE = new GenericBlock("druid_gate", new BlockSettings().material(Material.WOOD).sound(SoundType.WOOD).strength(-1, 18_000_000));
	
	public static final Block OIL_ORE = new OreBlock("oil_ore", new BlockSettings().material(Material.IRON).strength( 2, 2).ore(DimensionType.OVERWORLD, 20, 60, 7, 6));
	public static final Block RUBY_ORE = new OreBlock("ruby_ore", new BlockSettings().material(Material.IRON).strength(3, 3).ore(DimensionType.OVERWORLD, 1, 30, 5, 4).drop(ModItems.RUBY, 1));
	public static final Block AMETHYST_ORE = new OreBlock("amethyst_ore", new BlockSettings().material(Material.IRON).strength(4, 4).ore(DimensionType.OVERWORLD, 1, 20, 4, 3).drop(ModItems.AMETHYST, 1));
	public static final Block URANIUM_ORE = new OreBlock("uranium_ore", new BlockSettings().material(Material.IRON).strength( 2, 2).ore(DimensionType.OVERWORLD, 2, 11, 1, 5));
	//public static final Block EMERALD_ORE = new OreBlock("emerald_ore", new BlockSettings().material(Material.IRON).strength( 2, 2).ore(DimensionType.OVERWORLD, 7, 70, 1, 2));
	public static final Block TITANIUM_ORE = new OreBlock("titanium_ore", new BlockSettings().material(Material.IRON).strength( 2, 2).ore(DimensionType.OVERWORLD, 2, 10, 2, 4));
	public static final Block TIGERS_EYE_ORE = new OreBlock("tigers_eye_ore", new BlockSettings().material(Material.IRON).strength( 2, 2).ore(DimensionType.OVERWORLD, 10, 20, 5, 8));
	
	public static final Block DRIED_EMERALD_AlLIGATOR = new OreBlock("dried_emerald_alligator", new BlockSettings().material(Material.IRON).strength(2, 2).ore(DimensionType.OVERWORLD, 10, 60, 4, 6));
	public static final Block DRIED_RUBY_BETTLE = new OreBlock("dried_ruby_beetle", new BlockSettings().material(Material.IRON).strength(2, 2).ore(DimensionType.OVERWORLD, 15, 60, 4, 6));
	public static final Block DRIED_SWARM = new OreBlock("dried_swarm", new BlockSettings().material(Material.IRON).strength(2, 2).ore(DimensionType.OVERWORLD, 15, 60, 4, 6));
	public static final Block DRIED_TREE_MONSTER = new OreBlock("dried_tree_monster", new BlockSettings().material(Material.IRON).strength(2, 2).ore(DimensionType.OVERWORLD, 15, 60, 4, 6));
	
	public ModBlocks() {}
}
