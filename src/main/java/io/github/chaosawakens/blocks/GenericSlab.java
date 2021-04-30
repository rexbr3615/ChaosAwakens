/**
 * 
 */
package io.github.chaosawakens.blocks;

import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

/**
 * @author invalid2
 *
 */
public class GenericSlab extends GenericBlock
{
	public static final PropertyEnum<EnumBlockHalf> HALF = PropertyEnum.<EnumBlockHalf>create("half", EnumBlockHalf.class);
	private static final AxisAlignedBB AABB_BOTTOM = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
	private static final AxisAlignedBB AABB_TOP = new AxisAlignedBB(0.0, 0.5, 0.0, 1.0, 1.0, 1.0);
	private boolean isDouble;
	
	/**
	 * @param name
	 * @param material
	 * @param tab
	 * @param hardness
	 * @param resistance
	 * @param drop
	 * @param soundType
	 */
	public GenericSlab(String name, BlockSettings settings, boolean isDouble)
	{
		super(name, settings);
		this.fullBlock = isDouble;
		this.setLightOpacity(255);
		this.isDouble = isDouble;
	}
	
	@Override
	public boolean canSilkHarvest()
	{
		return false;
	}
	
	@Override
	public boolean isTopSolid(IBlockState state)
	{
		return ((GenericSlab)state.getBlock()).isDouble() || state.getValue(HALF) == EnumBlockHalf.TOP;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return this.isDouble() ? 2 : 1;
	}
	
	@Override
	public BlockStateContainer createBlockState()
	{
		return this.isDouble() ? new BlockStateContainer(this) : new BlockStateContainer(this, new IProperty[] {HALF});
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		IBlockState state = this.getDefaultState().withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
		if(this.isDouble())
		{
			return state;
		}
		else
		{
			return facing != EnumFacing.DOWN && (facing == EnumFacing.UP || (double)hitY <= 0.5D) ? state : state.withProperty(HALF, BlockSlab.EnumBlockHalf.TOP);
		}
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		if(((GenericSlab) state.getBlock()).isDouble())
		{
			return BlockFaceShape.SOLID;
		}
		else if( face == EnumFacing.UP && state.getValue(HALF) == EnumBlockHalf.TOP)
		{
			return BlockFaceShape.SOLID;
		}
		else
		{
			return face == EnumFacing.DOWN && state.getValue(HALF) == BlockSlab.EnumBlockHalf.BOTTOM ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
		}
	}
	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		if (ForgeModContainer.disableStairSlabCulling)
			return super.doesSideBlockRendering(state, world, pos, face);
		
		if(state.isOpaqueCube())
			return true;
		
		EnumBlockHalf side = state.getValue(HALF);
		return (side == EnumBlockHalf.TOP && face == EnumFacing.UP) || (side == EnumBlockHalf.BOTTOM && face == EnumFacing.DOWN);
	}
	
	//@SideOnly(Side.CLIENT)
	//public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		int value = 0;
		if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
			return value |= 8;
		
		return value;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		if(!this.isDouble())
			return this.getDefaultState().withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
		
		return this.getDefaultState();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState blockState)
	{
		return this.isDouble();
	}
	
	@Override
	public boolean isFullCube(IBlockState blockState)
	{
		return this.isDouble();
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos position)
	{
		if(this.isDouble())
		{
			return FULL_BLOCK_AABB;
		}
		else
		{
			return blockState.getValue(HALF) == EnumBlockHalf.TOP ? AABB_TOP : AABB_BOTTOM;
		}
	}
	
	public boolean isDouble()
	{
		return this.isDouble;
	}
}
