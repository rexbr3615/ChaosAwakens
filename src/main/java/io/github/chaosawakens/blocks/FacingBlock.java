package io.github.chaosawakens.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FacingBlock extends GenericBlock
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public FacingBlock(String name, Material material, CreativeTabs tab, float hardness, float resistance, Item drop, SoundType soundType) {
		super(name, material, tab, hardness, resistance, drop, soundType);
	}
	
	public FacingBlock(String name, Material material, float hardness, float resistance, Item drop, SoundType soundType)
	{
		super(name, material, hardness, resistance, drop, soundType);
	}
	
	public FacingBlock(String name, Material material, float hardness, float resistance, Item drop)
	{
		super(name, material, hardness, resistance, drop);
	}
	
	public FacingBlock(String name, Material material, CreativeTabs tab, float hardsistance, SoundType soundType)
	{
		super(name, material, tab, hardsistance, soundType);
	}
	
	public FacingBlock(String name, Material material, CreativeTabs tab, float hardsistance)
	{
		super(name, material, tab, hardsistance);
	}
	
	public FacingBlock(String name, Material material, float hardness, float resistance)
	{
		super(name, material, hardness, resistance);
	}
	
	public FacingBlock(String name, Material material, CreativeTabs tab, Item drop)
	{
		super(name, material, tab, drop);
	}
	
	public FacingBlock(String name, Material material, CreativeTabs tab, SoundType soundType)
	{
		super(name, material, tab, soundType);
	}
	
	public FacingBlock(String name, Material material, Item drop, SoundType soundType)
	{
		super(name, material, drop, soundType);
	}
	
	public FacingBlock(String name, Material material, CreativeTabs tab)
	{
		super(name, material, tab);
	}
	
	public FacingBlock(String name, Material material, Item drop)
	{
		super(name, material, drop);
	}
	
	public FacingBlock(String name, Material material, SoundType soundType)
	{
		super(name, material, soundType);
	}
	
	public FacingBlock(String name, Material material)
	{
		super(name, material);
	}
	
	public FacingBlock(String name)
	{
		super(name);
	}
	
	@Override
	public BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rotation)
	{
		return state.withProperty(FACING, rotation.rotate((EnumFacing) state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return 0 | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}
}
