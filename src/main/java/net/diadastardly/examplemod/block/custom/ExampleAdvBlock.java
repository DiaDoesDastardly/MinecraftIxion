package net.diadastardly.examplemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ExampleAdvBlock extends Block{

	public ExampleAdvBlock(Properties p_49795_) {
		super(p_49795_);
		// TODO Auto-generated constructor stub
	}
	
	public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
		if(pEntity.isCrouching()) {
			pEntity.teleportTo(pPos.getX()+10, pPos.getX()+10, pPos.getZ()+10);			
		}
    }
	
	public void testInteract(Player player) {
		player.sendSystemMessage(Component.literal("You talkin to me? "));
	}
}
