package net.diadastardly.examplemod.item;

import net.diadastardly.examplemod.ExampleMod;
import net.diadastardly.examplemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);
	
	public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register(
		"tutorial_tab", 
		() -> CreativeModeTab.builder().icon(
			() -> new ItemStack(ModItems.SAPPHIRE.get())
		)
		.title(Component.translatable("creativetab.tutorial_tab"))
		.displayItems((pParameters, pOutput) -> {
			pOutput.accept(ModItems.SAPPHIRE.get());
			pOutput.accept(ModItems.CONFIGURE_STICK.get());
			pOutput.accept(ModItems.EXAMPLE_ADV.get());
			
			pOutput.accept(ModBlocks.AUTOMINER.get());
			pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
			pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
			pOutput.accept(ModBlocks.EXAMPLE_ADV_BLOCK.get());
		})
		.build()
	);
	
	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
}
