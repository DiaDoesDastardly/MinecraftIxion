package net.diadastardly.examplemod.item.custom;

import net.diadastardly.examplemod.block.ModBlocks;
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

public class ConfigureStick extends Item{
	private int currentMode;
	private String[] modeNames;
	public ConfigureStick(Properties pProperties) {
		super(pProperties);
		currentMode = 0;
		modeNames = new String[] {
			"Block identifier",
			"Adjust Adv Block",
			"Ore finder"
		};
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		if(!pContext.getLevel().isClientSide()) {
			Player player = pContext.getPlayer();
			BlockPos positionClicked = pContext.getClickedPos();
			BlockState state = pContext.getLevel().getBlockState(positionClicked);
			if(player.isCrouching()) {
				currentMode++;
				if(currentMode >= modeNames.length) {
					currentMode = 0;
				}
				player.sendSystemMessage(Component.literal("["+currentMode+"]: "+modeNames[currentMode]));
			}else {
				if(currentMode == 0) {
					//player.sendSystemMessage(Component.literal("Clicking on mode 0"));
					player.sendSystemMessage(Component.literal(state.getBlock().getName().getString()));
					if(state.getBlock() == ModBlocks.EXAMPLE_ADV_BLOCK.get()) {
						player.sendSystemMessage(Component.literal("Compatable Mod Block"));
					}
				}
				if(currentMode == 1) {
					player.sendSystemMessage(Component.literal("Clicking on mode 1"));
				}
				if(currentMode == 2) {
					for(int i = 0; i <= positionClicked.getY()+64; i++) {
						state = pContext.getLevel().getBlockState(positionClicked.below(i));
						if(state.getBlock() == Blocks.IRON_ORE){
							player.sendSystemMessage(Component.literal("Found Iron"));
						}
					}
				}
			}
			
			/*
			player.changeDimension(null)
			if(player.isCrouching()) {
				testCount--;
				player.sendSystemMessage(Component.literal(testCount+""));
			}else {
				testCount++;
				player.sendSystemMessage(Component.literal(testCount+""));
			}
			*/
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
