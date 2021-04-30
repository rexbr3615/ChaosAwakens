package io.github.chaosawakens.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStairs.EnumHalf;
import net.minecraft.block.BlockStairs.EnumShape;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericStairs extends GenericBlock {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyEnum<EnumHalf> HALF = PropertyEnum.<EnumHalf>create("half", EnumHalf.class);
	public static final PropertyEnum<EnumShape> SHAPE = PropertyEnum.<EnumShape>create("shape", EnumShape.class);
	
	protected static final AxisAlignedBB AABB_SLAB_TOP = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_TOP_WEST = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_TOP_EAST = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_TOP_NORTH = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_QTR_TOP_SOUTH = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_TOP_NW = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_TOP_NE = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_TOP_SW = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 0.5D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_TOP_SE = new AxisAlignedBB(0.5D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_SLAB_BOTTOM = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_EAST = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 0.5D);
	protected static final AxisAlignedBB AABB_QTR_BOT_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_BOT_NW = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_BOT_NE = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 0.5D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_BOT_SW = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 0.5D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_BOT_SE = new AxisAlignedBB(0.5D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);

	public GenericStairs(String name, BlockSettings settings)
	{
		super(name, settings);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(HALF, EnumHalf.BOTTOM).withProperty(SHAPE, EnumShape.STRAIGHT));
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
	{
		if (!isActualState)
		{
			state = this.getActualState(state, worldIn, pos);
		}
		
		for (AxisAlignedBB axisalignedbb : getCollisionBoxList(state))
		{
			addCollisionBoxToList(pos, entityBox, collidingBoxes, axisalignedbb);
		}
	}
	
	private static List<AxisAlignedBB> getCollisionBoxList(IBlockState state) {
		List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
		
		boolean flag = state.getValue(HALF) == EnumHalf.TOP;
		
		list.add(flag ? AABB_SLAB_TOP : AABB_SLAB_BOTTOM);
		
		EnumShape shape = (EnumShape) state.getValue(SHAPE);
		
		if (shape == EnumShape.STRAIGHT || shape == EnumShape.INNER_LEFT || shape == EnumShape.INNER_RIGHT)
		{
			list.add(getCollisionQuarterBlock(state));
		}
		
		if (shape != EnumShape.STRAIGHT)
		{
			list.add(getCollisionEighthBlock(state));
		}
		
		return list;
	}

	private static AxisAlignedBB getCollisionQuarterBlock(IBlockState state)
	{
		boolean flag = state.getValue(HALF) == EnumHalf.TOP;
		
		switch ((EnumFacing) state.getValue(FACING))
		{
			case NORTH:
			default:
				return flag ? AABB_QTR_BOT_NORTH : AABB_QTR_TOP_NORTH;
			case SOUTH:
				return flag ? AABB_QTR_BOT_SOUTH : AABB_QTR_TOP_SOUTH;
			case WEST:
				return flag ? AABB_QTR_BOT_WEST : AABB_QTR_TOP_WEST;
			case EAST:
				return flag ? AABB_QTR_BOT_EAST : AABB_QTR_TOP_EAST;
		}
	}
	
	private static AxisAlignedBB getCollisionEighthBlock(IBlockState state)
	{
		EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
		EnumFacing enumfacing1;
		
		switch ((EnumShape) state.getValue(SHAPE))
		{
		case OUTER_LEFT:
		default:
			enumfacing1 = enumfacing;
			break;
		case OUTER_RIGHT:
			enumfacing1 = enumfacing.rotateY();
			break;
		case INNER_RIGHT:
			enumfacing1 = enumfacing.getOpposite();
			break;
		case INNER_LEFT:
			enumfacing1 = enumfacing.rotateYCCW();
		}
		
		boolean flag = state.getValue(HALF) == EnumHalf.TOP;
		
		switch (enumfacing1)
		{
			case NORTH:
			default:
				return flag ? AABB_OCT_BOT_NW : AABB_OCT_TOP_NW;
			case SOUTH:
				return flag ? AABB_OCT_BOT_SE : AABB_OCT_TOP_SE;
			case WEST:
				return flag ? AABB_OCT_BOT_SW : AABB_OCT_TOP_SW;
			case EAST:
				return flag ? AABB_OCT_BOT_NE : AABB_OCT_TOP_NE;
		}
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		state = this.getActualState(state, worldIn, pos);

		if (face.getAxis() == EnumFacing.Axis.Y)
		{
			return face == EnumFacing.UP == (state.getValue(HALF) == EnumHalf.TOP) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
		}
		else
		{
			EnumShape shape = (EnumShape) state.getValue(SHAPE);
			
			if (shape != EnumShape.OUTER_LEFT && shape != EnumShape.OUTER_RIGHT)
			{
				EnumFacing facing = (EnumFacing) state.getValue(FACING);
				
				switch (shape)
				{
					case INNER_RIGHT:
						return facing != face && facing != face.rotateYCCW() ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
					case INNER_LEFT:
						return facing != face && facing != face.rotateY() ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
					case STRAIGHT:
						return facing == face ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
					default:
						return BlockFaceShape.UNDEFINED;
				}
			}
			else
			{
				return BlockFaceShape.UNDEFINED;
			}
		}
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		this.randomDisplayTick(stateIn, worldIn, pos, rand);
	}
	
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
	{
		this.onBlockClicked(worldIn, pos, playerIn);
	}
	
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
	{
		this.onBlockDestroyedByPlayer(worldIn, pos, state);
	}
	
	@SideOnly(Side.CLIENT)
	public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return this.getPackedLightmapCoords(state, source, pos);
	}
	
	@Override
	public float getExplosionResistance(Entity exploder)
	{
		return this.getExplosionResistance(exploder);
	}
	
	@Override
	public int tickRate(World worldIn)
	{
		return this.tickRate(worldIn);
	}
	
	@Override
	public Vec3d modifyAcceleration(World worldIn, BlockPos pos, Entity entityIn, Vec3d motion)
	{
		return this.modifyAcceleration(worldIn, pos, entityIn, motion);
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return this.getBlockLayer();
	}
	
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	{
		return this.getSelectedBoundingBox(state, worldIn, pos);
	}
	
	@Override
	public boolean isCollidable()
	{
		return this.isCollidable();
	}
	
	@Override
	public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid)
	{
		return this.canCollideCheck(state, hitIfLiquid);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return this.canPlaceBlockAt(worldIn, pos);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		this.neighborChanged(state, worldIn, pos, Blocks.AIR, pos);
		this.onBlockAdded(worldIn, pos, this.getDefaultState());
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		this.breakBlock(worldIn, pos, this.getDefaultState());
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	{
		this.onEntityWalk(worldIn, pos, entityIn);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		this.updateTick(worldIn, pos, state, rand);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		return this.onBlockActivated(worldIn, pos, this.getDefaultState(), playerIn, hand, EnumFacing.DOWN, 0.0F, 0.0F, 0.0F);
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
	{
		this.onBlockDestroyedByExplosion(worldIn, pos, explosionIn);
	}
	
	@Override
	public boolean isTopSolid(IBlockState state)
	{
		return state.getValue(HALF) == EnumHalf.TOP;
	}
	
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		return this.getMapColor(this.getDefaultState(), worldIn, pos);
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		IBlockState state = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer, placer.getActiveHand());
		
		state = state.withProperty(FACING, placer.getHorizontalFacing()).withProperty(SHAPE, EnumShape.STRAIGHT);
		
		return facing != EnumFacing.DOWN && (facing == EnumFacing.UP || (double) hitY <= 0.5D) ? state.withProperty(HALF, EnumHalf.BOTTOM) : state.withProperty(HALF, EnumHalf.TOP);
	}
	
	@Nullable
	public RayTraceResult collisionRayTrace(IBlockState state, World worldIn, BlockPos pos, Vec3d start, Vec3d end)
	{
		List<RayTraceResult> list = Lists.<RayTraceResult>newArrayList();
		
		for (AxisAlignedBB axisalignedbb : getCollisionBoxList(this.getActualState(state, worldIn, pos)))
		{
			list.add(this.rayTrace(pos, start, end, axisalignedbb));
		}
		
		RayTraceResult raytraceresult1 = null;
		double d1 = 0.0D;
		
		for (RayTraceResult raytraceresult : list)
		{
			if (raytraceresult != null)
			{
				double d0 = raytraceresult.hitVec.squareDistanceTo(end);
				
				if (d0 > d1)
				{
					raytraceresult1 = raytraceresult;
					d1 = d0;
				}
			}
		}

		return raytraceresult1;
	}
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState state = this.getDefaultState().withProperty(HALF, (meta & 4) > 0 ? EnumHalf.TOP : EnumHalf.BOTTOM);
		state = state.withProperty(FACING, EnumFacing.getFront(5 - (meta & 3)));
		return state;
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		
		if (state.getValue(HALF) == EnumHalf.TOP) {
			i |= 4;
		}
		
		i = i | 5 - ((EnumFacing) state.getValue(FACING)).getIndex();
		return i;
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		return state.withProperty(SHAPE, getStairsShape(state, worldIn, pos));
	}
	
	private static EnumShape getStairsShape(IBlockState state, IBlockAccess access, BlockPos pos)
	{
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		IBlockState iblockstate = access.getBlockState(pos.offset(facing));
		
		if (isBlockStairs(iblockstate) && state.getValue(HALF) == iblockstate.getValue(HALF))
		{
			EnumFacing enumfacing1 = (EnumFacing) iblockstate.getValue(FACING);
			
			if (enumfacing1.getAxis() != ((EnumFacing) state.getValue(FACING)).getAxis() && isDifferentStairs(state, access, pos, enumfacing1.getOpposite()))
			{
				if (enumfacing1 == facing.rotateYCCW())
				{
					return BlockStairs.EnumShape.OUTER_LEFT;
				}
				
				return BlockStairs.EnumShape.OUTER_RIGHT;
			}
		}
		
		IBlockState iblockstate1 = access.getBlockState(pos.offset(facing.getOpposite()));
		
		if (isBlockStairs(iblockstate1) && state.getValue(HALF) == iblockstate1.getValue(HALF))
		{
			EnumFacing enumfacing2 = (EnumFacing) iblockstate1.getValue(FACING);
			
			if (enumfacing2.getAxis() != ((EnumFacing) state.getValue(FACING)).getAxis() && isDifferentStairs(state, access, pos, enumfacing2))
			{
				if (enumfacing2 == facing.rotateYCCW())
				{
					return EnumShape.INNER_LEFT;
				}
				
				return EnumShape.INNER_RIGHT;
			}
		}
		
		return BlockStairs.EnumShape.STRAIGHT;
	}

	private static boolean isDifferentStairs(IBlockState state, IBlockAccess access, BlockPos pos, EnumFacing facing)
	{
		IBlockState iblockstate = access.getBlockState(pos.offset(facing));
		
		return !isBlockStairs(iblockstate) || iblockstate.getValue(FACING) != state.getValue(FACING) || iblockstate.getValue(HALF) != state.getValue(HALF);
	}
	
	public static boolean isBlockStairs(IBlockState state)
	{
		return state.getBlock() instanceof GenericStairs;
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}
	
	
	@SuppressWarnings("incomplete-switch")
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		BlockStairs.EnumShape shape = (EnumShape) state.getValue(SHAPE);
		
		switch (mirrorIn)
		{
		case LEFT_RIGHT:
			
			if (facing.getAxis() == EnumFacing.Axis.Z)
			{
				switch (shape)
				{
					case OUTER_LEFT:
						return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.OUTER_RIGHT);
					case OUTER_RIGHT:
						return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.OUTER_LEFT);
					case INNER_RIGHT:
						return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE,EnumShape.INNER_LEFT);
					case INNER_LEFT:
						return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.INNER_RIGHT);
					default:
						return state.withRotation(Rotation.CLOCKWISE_180);
				}
			}
			
			break;
		case FRONT_BACK:
			
			if (facing.getAxis() == EnumFacing.Axis.X)
			{
				switch (shape)
				{
					case OUTER_LEFT:
						return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.OUTER_RIGHT);
					case OUTER_RIGHT:
						return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.OUTER_LEFT);
					case INNER_RIGHT:
						return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.INNER_RIGHT);
					case INNER_LEFT:
						return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.INNER_LEFT);
					case STRAIGHT:
						return state.withRotation(Rotation.CLOCKWISE_180);
				}
			}
		}
		
		return super.withMirror(state, mirrorIn);
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { FACING, HALF, SHAPE });
	}
	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		if (ForgeModContainer.disableStairSlabCulling)
			return super.doesSideBlockRendering(state, world, pos, face);
		
		if (state.isOpaqueCube())
			return true;

		state = this.getActualState(state, world, pos);
		
		EnumHalf half = state.getValue(HALF);
		EnumFacing side = state.getValue(FACING);
		EnumShape shape = state.getValue(SHAPE);
		
		if (face == EnumFacing.UP)
			return half == EnumHalf.TOP;
		
		if (face == EnumFacing.DOWN)
			return half == EnumHalf.BOTTOM;
		
		if (shape == EnumShape.OUTER_LEFT || shape == EnumShape.OUTER_RIGHT)
			return false;
		
		if (face == side)
			return true;
		
		if (shape == EnumShape.INNER_LEFT && face.rotateY() == side)
			return true;
		
		if (shape == EnumShape.INNER_RIGHT && face.rotateYCCW() == side)
			return true;
		
		return false;
	}
}
