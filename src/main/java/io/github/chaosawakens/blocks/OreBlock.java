package io.github.chaosawakens.blocks;

import com.google.common.base.Predicate;

import io.github.chaosawakens.registry.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreBlock extends GenericBlock
{
	
	private DimensionType dimension;
	private int minimumY;
	private int maximumY;
	private int size;
	private int tries;
	private Predicate<IBlockState> blockReplaced;
	private WorldGenMinable worldGenMinable;
	
	/**
	 * 
	 * @param name Unlocalized and registry names
	 * @param material Block material
	 * @param hardness Block hardness
	 * @param resistance Block resistance
	 * @param dimensionType Dimension where the ore will be generated
	 * @param minimumY Minimum Y level for ore generation
	 * @param maximumY Maximum Y level for ore generation
	 * @param size Size of the clumps
	 * @param tries Number of generation attempts
	 * @param blockReplaced Block that will be replaced by ore
	 */
	public OreBlock(String name, BlockSettings settings)
	{
		super(name, settings);
		
		this.dimension = settings.getDimension();
		this.minimumY = settings.getMinimumY();
		this.maximumY = settings.getMaximumY();
		this.size = settings.getSize();
		this.tries = settings.getTries();
		this.blockReplaced = settings.getBlockReplaced();
		this.worldGenMinable = new WorldGenMinable(this.getDefaultState(), settings.getTries(), settings.getBlockReplaced());
		
		ModBlocks.ORES.add(this);
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
	
	public WorldGenMinable getWorldGenMinable()
	{
		return worldGenMinable;
	}
}
