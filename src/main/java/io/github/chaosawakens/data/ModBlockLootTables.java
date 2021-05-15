package io.github.chaosawakens.data;

import io.github.chaosawakens.registry.CABlocks;
import io.github.chaosawakens.registry.CAItems;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockLootTables extends BlockLootTables
{
    @Override
    protected void addTables()
    {
        // ORES
        registerLootTable(CABlocks.AMETHYST_ORE.get(), (ore) -> droppingItemWithFortune(ore, CAItems.AMETHYST.get()));
        registerLootTable(CABlocks.RUBY_ORE.get(), (ore) -> droppingItemWithFortune(ore, CAItems.RUBY.get()));
        registerLootTable(CABlocks.TIGERS_EYE_ORE.get(), (ore) -> droppingItemWithFortune(ore, CAItems.TIGERS_EYE.get()));
        registerLootTable(CABlocks.SALT_ORE.get(), (ore) -> droppingItemWithFortune(ore, CAItems.SALT.get()));
        registerLootTable(CABlocks.GOLDEN_MELON.get(), (food) -> dropping(CAItems.GOLDEN_MELON_SLICE.get()));
        registerLootTable(CABlocks.ATTACHED_GOLDEN_MELON_STEM.get(), (seeds) -> dropping(CAItems.GOLDEN_MELON_SEEDS.get()));
        registerLootTable(CABlocks.GOLDEN_MELON_STEM.get(), (seeds) -> dropping(CAItems.GOLDEN_MELON_SEEDS.get()));
        registerLootTable(CABlocks.CRYSTAL_GRASS_BLOCK.get(), (food) -> dropping(CABlocks.KYANITE.get()));

        // BLOCKS
        registerDropSelfLootTable(CABlocks.AMETHYST_BLOCK.get());
        registerDropSelfLootTable(CABlocks.RUBY_BLOCK.get());
        registerDropSelfLootTable(CABlocks.TIGERS_EYE_BLOCK.get());
        registerDropSelfLootTable(CABlocks.URANIUM_ORE.get());
        registerDropSelfLootTable(CABlocks.URANIUM_BLOCK.get());
        registerDropSelfLootTable(CABlocks.TITANIUM_ORE.get());
        registerDropSelfLootTable(CABlocks.TITANIUM_BLOCK.get());
        registerDropSelfLootTable(CABlocks.ALUMINIUM_ORE.get());
        registerDropSelfLootTable(CABlocks.ALUMINIUM_BLOCK.get());
        registerDropSelfLootTable(CABlocks.COPPER_ORE.get());
        registerDropSelfLootTable(CABlocks.COPPER_BLOCK.get());
        registerDropSelfLootTable(CABlocks.TIN_ORE.get());
        registerDropSelfLootTable(CABlocks.TIN_BLOCK.get());
        registerDropSelfLootTable(CABlocks.SILVER_ORE.get());
        registerDropSelfLootTable(CABlocks.SILVER_BLOCK.get());
        registerDropSelfLootTable(CABlocks.PLATINUM_ORE.get());
        registerDropSelfLootTable(CABlocks.PLATINUM_BLOCK.get());
        registerDropSelfLootTable(CABlocks.PINK_TOURMALINE_BLOCK.get());
        registerDropSelfLootTable(CABlocks.CATS_EYE_BLOCK.get());
        registerDropSelfLootTable(CABlocks.BROWN_ANT_NEST.get());
        registerDropSelfLootTable(CABlocks.RAINBOW_ANT_NEST.get());
        registerDropSelfLootTable(CABlocks.RED_ANT_NEST.get());
        registerDropSelfLootTable(CABlocks.UNSTABLE_ANT_NEST.get());
        registerDropSelfLootTable(CABlocks.TERMITE_NEST.get());
        registerDropSelfLootTable(CABlocks.FOSSILISED_ENT.get());
        registerDropSelfLootTable(CABlocks.FOSSILISED_HERCULES_BEETLE.get());
        registerDropSelfLootTable(CABlocks.FOSSILISED_RUBY_BUG.get());
        registerDropSelfLootTable(CABlocks.FOSSILISED_EMERALD_GATOR.get());
        registerDropSelfLootTable(CABlocks.GATE_BLOCK.get());
        registerDropSelfLootTable(CABlocks.ENT_DUNGEON_WOOD.get());
        registerDropSelfLootTable(CABlocks.KYANITE.get());
        registerDropSelfLootTable(CABlocks.CRYSTAL_LOG.get());
        registerDropSelfLootTable(CABlocks.CRYSTAL_WOOD.get());
        registerDropSelfLootTable(CABlocks.CRYSTAL_WOOD_PLANKS.get());
        registerDropSelfLootTable(CABlocks.CRYSTAL_CRAFTING_TABLE.get());
        registerDropSelfLootTable(CABlocks.CRYSTAL_FURNACE.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CABlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}