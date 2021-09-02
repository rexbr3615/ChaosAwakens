package io.github.chaosawakens.data;

import io.github.chaosawakens.common.registry.CAItems;
import io.github.chaosawakens.common.registry.CALootTables;
import net.minecraft.data.loot.GiftLootTables;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiConsumer;

public class CAGiftLootTable extends GiftLootTables {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(CALootTables.GAMEPLAY_HERO_OF_THE_VILLAGE_ODDITIES_PURVEYOR_GIFT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantRange.exactly(1))
                                .add(ItemLootEntry.lootTableItem(Items.EMERALD))
                                .add(ItemLootEntry.lootTableItem(CAItems.TIN_LUMP.get()))
                                .add(ItemLootEntry.lootTableItem(CAItems.COPPER_LUMP.get()))
                                .add(ItemLootEntry.lootTableItem(CAItems.PINK_TOURMALINE_INGOT.get()))
                                .add(ItemLootEntry.lootTableItem(CAItems.CATS_EYE_INGOT.get()))
                                .add(ItemLootEntry.lootTableItem(CAItems.PLATINUM_LUMP.get()))));
    }
}