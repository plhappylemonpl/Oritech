package rearth.oritech.item.other;

import dev.architectury.fluid.FluidStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class SmallFluidTankBlockItem extends BlockItem {
    public SmallFluidTankBlockItem(Block block, Settings settings) {
        super(block, settings);
    }
    
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        
        if (!stack.contains(DataComponentTypes.CUSTOM_DATA)) return;
        var nbt = stack.get(DataComponentTypes.CUSTOM_DATA).copyNbt();
        if (nbt.isEmpty()) return;
        
        var candidate = FluidStack.read(context.getRegistryLookup(), nbt);
        if (candidate.isEmpty()) return;
        var fluidStack = candidate.get();
        var variant = fluidStack.getFluid();
        var amount = fluidStack.getAmount() * 1000 / FluidConstants.BUCKET;
        tooltip.add(Text.translatable("tooltip.oritech.fluid_content", amount, amount <= 0
            ? Text.translatable("tooltip.oritech.fluid_empty")
            : FluidVariantAttributes.getName(FluidVariant.of(variant)).getString()));
    }
}
