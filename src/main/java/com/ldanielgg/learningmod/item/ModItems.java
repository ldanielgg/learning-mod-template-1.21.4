package com.ldanielgg.learningmod.item;

import com.ldanielgg.learningmod.LearningMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item SUSPICIOUS_SUBSTANCE = registerItem(
            "suspicious_substance", Item::new, new Item.Settings());

    public static final Item CHEESE = registerItem(
            "cheese", Item::new, new Item.Settings().food(ModFoodComponents.CHEESE));

    public static final Item PINK_GARNET = registerItem(
            "pink_garnet", Item::new, new Item.Settings());

    public static final Item RAW_PINK_GARNET = registerItem(
            "raw_pink_garnet", Item::new, new Item.Settings());

    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LearningMod.MOD_ID, name));

        // Create the item instance
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register item
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(fabricItemGroupEntries -> {
                    fabricItemGroupEntries.add(ModItems.SUSPICIOUS_SUBSTANCE);
                    fabricItemGroupEntries.add(ModItems.PINK_GARNET);
                    fabricItemGroupEntries.add(ModItems.RAW_PINK_GARNET);
                });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((fabricItemGroupEntries -> fabricItemGroupEntries.add(ModItems.CHEESE)));
    }


}
