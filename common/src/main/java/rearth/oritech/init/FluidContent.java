package rearth.oritech.init;

import dev.architectury.core.block.ArchitecturyLiquidBlock;
import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.core.fluid.ArchitecturyFluidAttributes;
import dev.architectury.core.fluid.SimpleArchitecturyFluidAttributes;
import dev.architectury.core.item.ArchitecturyBucketItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import rearth.oritech.Oritech;

import java.util.List;

public class FluidContent {
    
    public static final ArchitecturyFluidAttributes OIL_ATTRIBUTES = SimpleArchitecturyFluidAttributes.ofSupplier(() -> FluidContent.FLOWING_OIL, () -> FluidContent.STILL_OIL)
                                                                       .blockSupplier(() -> FluidContent.STILL_OIL_BLOCK)
                                                                       .bucketItemSupplier(() -> FluidContent.STILL_OIL_BUCKET)
                                                                       .sourceTexture(Oritech.id("block/fluid/fluid_gas_dark"))
                                                                       .flowingTexture(Oritech.id("block/fluid/fluid_gas_dark"))
                                                                       .color(0x7a7a7a);
    
    public static final ArchitecturyFluidAttributes FUEL_ATTRIBUTES = SimpleArchitecturyFluidAttributes.ofSupplier(() -> FluidContent.FLOWING_FUEL, () -> FluidContent.STILL_FUEL)
                                                                        .blockSupplier(() -> FluidContent.STILL_FUEL_BLOCK)
                                                                        .bucketItemSupplier(() -> FluidContent.STILL_FUEL_BUCKET)
                                                                        .sourceTexture(Oritech.id("block/fluid/fluid_strange_pale_2"))
                                                                        .flowingTexture(Oritech.id("block/fluid/fluid_strange_pale_2"))
                                                                        .color(0x2D3D48);
    
    public static final ArchitecturyFluidAttributes STEAM_ATTRIBUTES = SimpleArchitecturyFluidAttributes.ofSupplier(() -> FluidContent.FLOWING_STEAM, () -> FluidContent.STILL_STEAM)
                                                                         .blockSupplier(() -> FluidContent.STILL_STEAM_BLOCK)
                                                                         .bucketItemSupplier(() -> FluidContent.STILL_STEAM_BUCKET)
                                                                         .sourceTexture(Oritech.id("block/fluid/fluid_steam"))
                                                                         .flowingTexture(Oritech.id("block/fluid/fluid_steam"))
                                                                         .color(0xFFFFFF);

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Oritech.MOD_ID, RegistryKeys.FLUID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Oritech.MOD_ID, RegistryKeys.BLOCK);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Oritech.MOD_ID, RegistryKeys.ITEM);
    public static final List<ArchitecturyFluidAttributes> FLUID_ATTRIBUTES = List.of(OIL_ATTRIBUTES, FUEL_ATTRIBUTES, STEAM_ATTRIBUTES);
    
    // oil
    public static final RegistrySupplier<FlowableFluid> STILL_OIL = FLUIDS.register("still_oil", () -> new ArchitecturyFlowingFluid.Source(OIL_ATTRIBUTES));
    public static final RegistrySupplier<FlowableFluid> FLOWING_OIL = FLUIDS.register("flowing_oil", () -> new ArchitecturyFlowingFluid.Flowing(OIL_ATTRIBUTES));
    public static final RegistrySupplier<FluidBlock> STILL_OIL_BLOCK = BLOCKS.register("still_oil_block", () -> new ArchitecturyLiquidBlock(STILL_OIL, AbstractBlock.Settings.copy(Blocks.WATER)));
    public static final RegistrySupplier<Item> STILL_OIL_BUCKET = ITEMS.register("still_oil_bucket", () -> new ArchitecturyBucketItem(STILL_OIL, new Item.Settings().maxCount(1).recipeRemainder(Items.BUCKET)));
    
    // fuel
    public static final RegistrySupplier<FlowableFluid> STILL_FUEL = FLUIDS.register("still_fuel", () -> new ArchitecturyFlowingFluid.Source(FUEL_ATTRIBUTES));
    public static final RegistrySupplier<FlowableFluid> FLOWING_FUEL = FLUIDS.register("flowing_fuel", () -> new ArchitecturyFlowingFluid.Flowing(FUEL_ATTRIBUTES));
    public static final RegistrySupplier<FluidBlock> STILL_FUEL_BLOCK = BLOCKS.register("still_fuel_block", () -> new ArchitecturyLiquidBlock(STILL_FUEL, AbstractBlock.Settings.copy(Blocks.WATER)));
    public static final RegistrySupplier<Item> STILL_FUEL_BUCKET = ITEMS.register("still_fuel_bucket", () -> new ArchitecturyBucketItem(STILL_FUEL, new Item.Settings().maxCount(1).recipeRemainder(Items.BUCKET)));
    
    // steam
    public static final RegistrySupplier<FlowableFluid> STILL_STEAM = FLUIDS.register("still_steam", () -> new ArchitecturyFlowingFluid.Source(STEAM_ATTRIBUTES));
    public static final RegistrySupplier<FlowableFluid> FLOWING_STEAM = FLUIDS.register("flowing_steam", () -> new ArchitecturyFlowingFluid.Flowing(STEAM_ATTRIBUTES));
    public static final RegistrySupplier<FluidBlock> STILL_STEAM_BLOCK = BLOCKS.register("still_steam_block", () -> new ArchitecturyLiquidBlock(STILL_STEAM, AbstractBlock.Settings.copy(Blocks.WATER)));
    public static final RegistrySupplier<Item> STILL_STEAM_BUCKET = ITEMS.register("still_steam_bucket", () -> new ArchitecturyBucketItem(STILL_STEAM, new Item.Settings().maxCount(1).recipeRemainder(Items.BUCKET)));
    
    
    public static void registerFluids() {
        FLUIDS.register();
    }
    
    public static void registerBlocks() {
        BLOCKS.register();
    }
    
    public static void registerItems() {
        ITEMS.register();
    }
    
    public static void registerItemsToGroups() {
        ItemGroups.add(ItemContent.Groups.components, STILL_OIL_BUCKET.get());
        ItemGroups.add(ItemContent.Groups.components, STILL_FUEL_BUCKET.get());
        ItemGroups.add(ItemContent.Groups.components, STILL_STEAM_BUCKET.get());
    }
    
}
