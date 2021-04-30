package io.github.chaosawakens.items;

import io.github.chaosawakens.blocks.GenericSlab;
import io.github.chaosawakens.registry.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGenericSlab extends ItemBlock {

	private final GenericSlab singleSlab;
	private final GenericSlab doubleSlab;

	public ItemGenericSlab(Block block, GenericSlab singleSlab, GenericSlab doubleSlab) {
		super(block);
		this.setRegistryName(block.getRegistryName());
		
		this.singleSlab = singleSlab;
		this.doubleSlab = doubleSlab;
		this.setMaxDamage(0);
		
		ModItems.ITEMS.add(this);
	}

	public int getMetadata(int damage) {
		return damage;
	}

	public String getUnlocalizedName(ItemStack stack) {
		return this.singleSlab.getUnlocalizedName();
	}

	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		
		if (!itemstack.isEmpty() && player.canPlayerEdit(pos.offset(facing), facing, itemstack))
		{
			IBlockState stateHalf = worldIn.getBlockState(pos);
			
			if (stateHalf.getBlock() == this.singleSlab)
			{
				EnumBlockHalf blockHalf = (BlockSlab.EnumBlockHalf) stateHalf.getValue(BlockSlab.HALF);
				
				if ((facing == EnumFacing.UP && blockHalf == BlockSlab.EnumBlockHalf.BOTTOM || facing == EnumFacing.DOWN && blockHalf == BlockSlab.EnumBlockHalf.TOP))
				{
					
					IBlockState stateDouble = this.doubleSlab.getDefaultState();
					AxisAlignedBB axisalignedbb = stateDouble.getCollisionBoundingBox(worldIn, pos);
					if (axisalignedbb != Block.NULL_AABB && worldIn.checkNoEntityCollision(axisalignedbb.offset(pos)) && worldIn.setBlockState(pos, stateDouble, 11))
					{
						SoundType soundtype = this.doubleSlab.getSoundType(stateDouble, worldIn, pos, player);
						worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
						itemstack.shrink(1);
						
						if (player instanceof EntityPlayerMP)
						{
							CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos, itemstack);
						}
					}
					
					return EnumActionResult.SUCCESS;
				}
			}
			
			return this.tryPlace(player, itemstack, worldIn, pos.offset(facing)) ? EnumActionResult.SUCCESS : super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
		}
		else
		{
			return EnumActionResult.FAIL;
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack)
	{
		BlockPos blockpos = pos;
		IBlockState iblockstate = worldIn.getBlockState(pos);
		
		if (iblockstate.getBlock() == this.singleSlab)
		{
			boolean flag = iblockstate.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP;
			
			if ((side == EnumFacing.UP && !flag || side == EnumFacing.DOWN && flag))
			{
				return true;
			}
		}
		
		pos = pos.offset(side);
		IBlockState iblockstate1 = worldIn.getBlockState(pos);
		return iblockstate1.getBlock() == this.singleSlab ? true : super.canPlaceBlockOnSide(worldIn, blockpos, side, player, stack);
	}

	private boolean tryPlace(EntityPlayer player, ItemStack stack, World worldIn, BlockPos pos)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos);
		
		if (iblockstate.getBlock() == this.singleSlab)
		{
			IBlockState stateDouble = this.doubleSlab.getDefaultState();
			AxisAlignedBB axisalignedbb = stateDouble.getCollisionBoundingBox(worldIn, pos);
			
			if (axisalignedbb != Block.NULL_AABB && worldIn.checkNoEntityCollision(axisalignedbb.offset(pos)) && worldIn.setBlockState(pos, stateDouble, 11))
			{
				SoundType soundtype = this.doubleSlab.getSoundType(stateDouble, worldIn, pos, player);
				worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
				stack.shrink(1);
			}
			return true;
			
		}
		
		return false;
	}
}
