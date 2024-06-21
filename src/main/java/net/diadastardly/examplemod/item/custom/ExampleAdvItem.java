package net.diadastardly.examplemod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class ExampleAdvItem extends Item{
	private int testCount;
	public ExampleAdvItem(Properties pProperties) {
		super(pProperties);
		testCount = 0;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		if(!pContext.getLevel().isClientSide()) {
			Player player = pContext.getPlayer();
			testCount++;
			player.sendSystemMessage(Component.literal(testCount+""));
			/*
			BlockPos positionClicked = pContext.getClickedPos();
			Player player = pContext.getPlayer();
			BlockState state = pContext.getLevel().getBlockState(positionClicked.below());
			
			player.sendSystemMessage(Component.literal(
				positionClicked.getX()+", "+
				positionClicked.getY()+", "+
				positionClicked.getZ()
			));
			
			if(state.getBlock() != Blocks.AIR) {
				player.teleportTo(positionClicked.getX(), positionClicked.getY()+1, positionClicked.getZ());				
			}
			
			pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), 
				player.getSlotForHand(null)
			);
			*/
		}
		
		return InteractionResult.SUCCESS;
	}
}
