package io.github.chaosawakens.blocks;

import java.util.Random;

import io.github.chaosawakens.ModBlocks;
import io.github.chaosawakens.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * Generic block class aka any block with no special behavior
 * @author invalid2
 */
public class GenericBlock extends Block
{
	
	private Item drop;
	
	/**
	 * 
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 * @param tab Creative tab
	 * @param hardness Block hardness
	 * @param resistance Block resistance
	 */
	public GenericBlock(String name, Material material, CreativeTabs tab, float hardness, float resistance, Item drop, SoundType soundType)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setSoundType(soundType);
		
		setHardness(hardness);
		setResistance(resistance);
		
		this.drop = drop == null ? Item.getItemFromBlock(this) : drop;
		
		ModBlocks.BLOCKS.add(this);
		
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public GenericBlock(String name, Material material, float hardness, float resistance, Item drop, SoundType soundType)
	{
		this(name, material, CreativeTabs.BUILDING_BLOCKS, hardness, resistance, drop, soundType);
	}
	
	public GenericBlock(String name, Material material, float hardness, float resistance, Item drop)
	{
		this(name, material, CreativeTabs.BUILDING_BLOCKS, hardness, resistance, drop, SoundType.STONE);
	}
	
	/**
	 * 
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 * @param tab Creative tab
	 * @param hardsistance Block hardness and resistance
	 */
	public GenericBlock(String name, Material material, CreativeTabs tab, float hardsistance, SoundType soundType)
	{
		this(name, material, tab, hardsistance, hardsistance, null, soundType);
	}
	
	/**
	 * 
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 * @param tab Creative tab
	 * @param hardsistance Block hardness and resistance
	 */
	public GenericBlock(String name, Material material, CreativeTabs tab, float hardsistance)
	{
		this(name, material, tab, hardsistance, hardsistance, null, SoundType.STONE);
	}
	
	/**
	 * Tab defaults to CreativeTabs.BUILDING_BLOCKS
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 * @param tab Creative tab
	 * @param hardsistance Block hardness and resistance
	 */
	public GenericBlock(String name, Material material, float hardness, float resistance)
	{
		this(name, material, CreativeTabs.BUILDING_BLOCKS, hardness, resistance, null, SoundType.STONE);
	}
	
	/**
	 * Hardness and resistance default to 1.0f
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 * @param tab Creative tab
	 */
	public GenericBlock(String name, Material material, CreativeTabs tab, Item drop)
	{
		this(name, material, tab, 1.0f, 1.0f, drop, SoundType.STONE);
	}
	
	/**
	 * Hardness and resistance default to 1.0f
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 * @param tab Creative tab
	 */
	public GenericBlock(String name, Material material, CreativeTabs tab, SoundType soundType)
	{
		this(name, material, tab, 1.0f, 1.0f, null, soundType);
	}
	
	/**
	 * Tab defaults to CreativeTabs.BUILDING_BLOCKS, hardness and resistance default to 1.0f
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 */
	public GenericBlock(String name, Material material, Item drop, SoundType soundType)
	{
		this(name, material, CreativeTabs.BUILDING_BLOCKS, 1.0f, 1.0f, drop, soundType);
	}
	
	/**
	 * Hardness and resistance default to 1.0f
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 * @param tab Creative tab
	 */
	public GenericBlock(String name, Material material, CreativeTabs tab)
	{
		this(name, material, tab, 1.0f, 1.0f, null, SoundType.STONE);
	}
	
	/**
	 * Tab defaults to CreativeTabs.BUILDING_BLOCKS, hardness and resistance default to 1.0f
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 */
	public GenericBlock(String name, Material material, Item drop)
	{
		this(name, material, CreativeTabs.BUILDING_BLOCKS, 1.0f, 1.0f, drop, SoundType.STONE);
	}
	
	/**
	 * Tab defaults to CreativeTabs.BUILDING_BLOCKS, hardness and resistance default to 1.0f
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 */
	public GenericBlock(String name, Material material, SoundType soundType)
	{
		this(name, material, CreativeTabs.BUILDING_BLOCKS, 1.0f, 1.0f, null, soundType);
	}
	
	/**
	 * Tab defaults to CreativeTabs.BUILDING_BLOCKS, hardness and resistance default to 1.0f
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 */
	public GenericBlock(String name, Material material)
	{
		this(name, material, CreativeTabs.BUILDING_BLOCKS, 1.0f, 1.0f, null, SoundType.STONE);
	}
	
	/**
	 * Tab defaults to CreativeTabs.BUILDING_BLOCKS, material defaults to Material.ROCK,
	 * hardness and resistance default to 1.0f
	 * @param name Unlocalized and registry names
	 */
	public GenericBlock(String name)
	{
		this(name, Material.ROCK, CreativeTabs.BUILDING_BLOCKS, 1.0f, 1.0f, null, SoundType.STONE);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return drop;
	}
}
