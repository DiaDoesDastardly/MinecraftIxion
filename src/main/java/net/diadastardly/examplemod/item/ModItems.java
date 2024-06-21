package net.diadastardly.examplemod.item;

import net.diadastardly.examplemod.ExampleMod;
import net.diadastardly.examplemod.item.custom.ExampleAdvItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);
	
	public static final RegistryObject<Item> SAPPHIRE = ITEMS.register(
			"sapphire", 
			() -> new Item(new Item.Properties())
	);
	
	public static final RegistryObject<Item> EXAMPLE_ADV = ITEMS.register(
			"example_adv", 
			() -> new ExampleAdvItem(new Item.Properties().durability(100))
	);
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
