package rearth.oritech.util;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public class SimpleCraftingInventory extends SimpleInventory implements RecipeInput {
    
    public SimpleCraftingInventory(ItemStack ... items) {
        super(items);
    }
    @Override
    public ItemStack getStackInSlot(int slot) {
        return slot >= 0 && slot < this.heldStacks.size() ? this.heldStacks.get(slot) : ItemStack.EMPTY;
    }
    
    @Override
    public int getSize() {
        return this.size();
    }
}
