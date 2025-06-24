package com.ldanielgg.learningmod.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CHEESE = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .build();

}
