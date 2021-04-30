package io.github.chaosawakens.blocks;

import java.util.Random;

import com.google.common.base.Predicate;

import io.github.chaosawakens.registry.ModBlocks;
import io.github.chaosawakens.registry.ModCreativeTabs;
import io.github.chaosawakens.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.feature.WorldGenMinable;

/**
 * Generic block class aka any block with no special behavior
 * @author invalid2
 */
public class GenericBlock extends Block
{
	private Item drop;
	private int dropQuantity;
	
	public GenericBlock(String name, BlockSettings settings)
	{
		super(settings.getMaterial());
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(settings.getTab());
		setSoundType(settings.getSound());
		
		setHardness(settings.getHardness());
		setResistance(settings.getResistance());
		
		this.drop = settings.getDrop() == null ? Item.getItemFromBlock(this) : settings.getDrop();
		this.dropQuantity = settings.getDropQuantity();
		
		ModBlocks.BLOCKS.add(this);
		
		if(settings.getRegisterItem())
			ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return drop;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return dropQuantity;
	}
	
	public static class BlockSettings
	{
		//Normal block stuff
		private Material material;
		private CreativeTabs tab;
		private SoundType sound;
		private Item drop;
		private float hardness;
		private float resistance;
		private int dropQuantity;
		
		//Ore stuff
		private DimensionType dimension;
		private int minimumY;
		private int maximumY;
		private int size;
		private int tries;
		private Predicate<IBlockState> blockReplaced;
		private WorldGenMinable worldGenMinable;
		private boolean registerItem;
		
		public BlockSettings()
		{
			this.material = Material.ROCK;
			this.registerItem = true;
			this.hardness = 1.0f;
			this.resistance = 1.0f;
			this.tab = ModCreativeTabs.BLOCKS;
			this.sound = SoundType.STONE;
			this.drop = null;
			this.dropQuantity = 1;
		}
		
		public BlockSettings registerItem(boolean register)
		{
			this.registerItem = register;
			return this;
		}
		
		public BlockSettings material(Material material)
		{
			this.material = material;
			return this;
		}
		
		public BlockSettings creativeTab(CreativeTabs tab)
		{
			this.tab = tab;
			return this;
		}
		
		public BlockSettings sound(SoundType sound)
		{
			this.sound = sound;
			return this;
		}
		
		public BlockSettings hardness(float hardness)
		{
			this.hardness = hardness;
			return this;
		}
		
		public BlockSettings resistance(float resistance)
		{
			this.resistance = resistance;
			return this;
		}
		
		public BlockSettings strength(float hardness, float resistance)
		{
			this.hardness = hardness;
			this.resistance = resistance;
			return this;
		}
		
		public BlockSettings drop(Item drop, int quantity)
		{
			this.drop = drop;
			this.dropQuantity = quantity;
			return this;
		}
		
		public BlockSettings ore(DimensionType dimension, int minimumY, int maximumY, int size, int tries, Predicate<IBlockState> blockReplaced)
		{
			this.dimension = dimension;
			this.minimumY = minimumY; 
			this.maximumY = maximumY;
			this.size = size;
			this.tries= tries;
			this.blockReplaced = blockReplaced;
			return this;
		}
		
		public BlockSettings ore(DimensionType dimension, int minimumY, int maximumY, int size, int tries)
		{
			this.dimension = dimension;
			this.minimumY = minimumY; 
			this.maximumY = maximumY;
			this.size = size;
			this.tries= tries;
			this.blockReplaced = BlockMatcher.forBlock(Blocks.STONE);
			
			return this;
		}
		
		public Material getMaterial()
		{
			return material;
		}
		
		public CreativeTabs getTab()
		{
			return tab;
		}
		
		public boolean getRegisterItem()
		{
			return registerItem;
		}
		
		public SoundType getSound()
		{
			return sound;
		}
		
		public Item getDrop()
		{
			return drop;
		}
		
		public float getHardness()
		{
			return hardness;
		}
		
		public float getResistance()
		{
			return resistance;
		}
		
		public int getDropQuantity()
		{
			return dropQuantity;
		}
		
		public DimensionType getDimension()
		{
			return dimension;
		}
		
		public int getMinimumY()
		{
			return minimumY;
		}
		
		public int getMaximumY()
		{
			return maximumY;
		}
		
		public int getSize()
		{
			return size;
		}
		
		public int getTries()
		{
			return tries;
		}
		
		public Predicate<IBlockState> getBlockReplaced()
		{
			return blockReplaced;
		}
		
		public WorldGenMinable getWorldGenMinable()
		{
			return worldGenMinable;
		}
		
	}
}