package com.ldanielgg.learningmod.item;

import com.ldanielgg.learningmod.LearningMod;
import com.ldanielgg.learningmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> PINK_GARNET_ITEMS_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(LearningMod.MOD_ID, "pink_garnet_items"));
    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.PINK_GARNET))
            .displayName(Text.translatable("itemGroup.learning_mod.pink_garnet_items"))
            .build();

    public static final RegistryKey<ItemGroup> PINK_GARNET_BLOCKS_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(LearningMod.MOD_ID, "pink_garnet_blocks"));
    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
            .displayName(Text.translatable("itemGroup.learning_mod.pink_garnet_blocks"))
            .build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, PINK_GARNET_ITEMS_GROUP_KEY, PINK_GARNET_ITEMS_GROUP);
        ItemGroupEvents.modifyEntriesEvent(PINK_GARNET_ITEMS_GROUP_KEY).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModItems.PINK_GARNET);
            fabricItemGroupEntries.add(ModItems.RAW_PINK_GARNET);
        });

        Registry.register(Registries.ITEM_GROUP, PINK_GARNET_BLOCKS_GROUP_KEY, PINK_GARNET_BLOCKS_GROUP);
        ItemGroupEvents.modifyEntriesEvent(PINK_GARNET_BLOCKS_GROUP_KEY).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });
    }
}
