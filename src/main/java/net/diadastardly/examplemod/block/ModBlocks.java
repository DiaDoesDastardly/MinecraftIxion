package net.diadastardly.examplemod.block;

import java.util.function.Supplier;

import net.diadastardly.examplemod.ExampleMod;
import net.diadastardly.examplemod.block.custom.AutoMiner;
import net.diadastardly.examplemod.block.custom.ExampleAdvBlock;
import net.diadastardly.examplemod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);
	
	public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", 
			() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
	);
	
	public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore", 
			() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
	);
	
	public static final RegistryObject<Block> EXAMPLE_CRAFTER_BLOCK = registerBlock("example_crafter", 
			() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
	);
	
	public static final RegistryObject<Block> EXAMPLE_ADV_BLOCK = registerBlock("example_adv_block", 
			() -> new ExampleAdvBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
	);
	
	public static final RegistryObject<Block> AUTOMINER = registerBlock("autominer", 
			() -> new AutoMiner(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
	);
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
