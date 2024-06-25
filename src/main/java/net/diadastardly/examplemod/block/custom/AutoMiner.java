package net.diadastardly.examplemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class AutoMiner extends Block{

	public AutoMiner(Properties p_49795_) {
		super(p_49795_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult pHitResult) {
		Block foundBlock;
		//Item testItem = Items.IRON_INGOT;
	    if (!level.isClientSide()){
	    	for(int i = 0; i <= pos.getY()+64; i++) {
		    	foundBlock = level.getBlockState(pos.below(i)).getBlock();
	    		if(foundBlock == Blocks.IRON_ORE || foundBlock == Blocks.DEEPSLATE_IRON_ORE) {
	    			player.spawnAtLocation(Items.IRON_INGOT);
	    			level.removeBlock(pos.below(i), false);
	    		}
	    		if(foundBlock == Blocks.GOLD_ORE || foundBlock == Blocks.DEEPSLATE_GOLD_ORE) {
	    			player.spawnAtLocation(Items.GOLD_INGOT);
	    			level.removeBlock(pos.below(i), false);
	    		}
	    		if(foundBlock == Blocks.REDSTONE_ORE || foundBlock == Blocks.DEEPSLATE_REDSTONE_ORE) {
	    			player.spawnAtLocation(Items.REDSTONE);
	    			level.removeBlock(pos.below(i), false);
	    		}
	    		if(foundBlock == Blocks.DIAMOND_ORE || foundBlock == Blocks.DEEPSLATE_DIAMOND_ORE) {
	    			player.spawnAtLocation(Items.DIAMOND);
	    			level.removeBlock(pos.below(i), false);
	    		}
	    		if(foundBlock == Blocks.EMERALD_ORE || foundBlock == Blocks.DEEPSLATE_EMERALD_ORE) {
	    			player.spawnAtLocation(Items.EMERALD);
	    			level.removeBlock(pos.below(i), false);
	    		}
	    	}
	    	
	    }
	    return InteractionResult.SUCCESS;
	}	
	/*
	@Override
    public boolean onBlockActivated(Level world, BlockPos pos, BlockState state, Player player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if (!world.isClientSide()){
	
	        EntityItem droppedFruit = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.fruit, 1));
	        worldIn.spawnEntity(droppedFruit);
	        
	
	        worldIn.setBlockState(pos, this.baseLeaves.getDefaultState());
	
	        return true;
        
		}
		
		return false;
    }
	*/
}
