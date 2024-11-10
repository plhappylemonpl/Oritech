package rearth.oritech.block.entity.machines;

import earth.terrarium.common_storage_lib.energy.EnergyProvider;
import earth.terrarium.common_storage_lib.storage.base.ValueStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import rearth.oritech.block.blocks.MachineCoreBlock;
import rearth.oritech.init.BlockEntitiesContent;
import rearth.oritech.util.*;

import java.util.Objects;

public class MachineCoreEntity extends BlockEntity implements InventoryProvider, EnergyProvider.BlockEntity, FluidProvider {
    
    private BlockPos controllerPos = BlockPos.ORIGIN;
    private MultiblockMachineController controllerEntity;
    private final DelegatingEnergyStorage delegatedStorage = new DelegatingEnergyStorage(this::getMainStorage, this::isEnabled);
    
    public MachineCoreEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesContent.MACHINE_CORE_ENTITY, pos, state);
    }
    
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("controller_x", controllerPos.getX());
        nbt.putInt("controller_y", controllerPos.getY());
        nbt.putInt("controller_z", controllerPos.getZ());
    }
    
    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        controllerPos = new BlockPos(nbt.getInt("controller_x"), nbt.getInt("controller_y"), nbt.getInt("controller_z"));
    }
    
    public BlockPos getControllerPos() {
        return controllerPos;
    }
    
    public void setControllerPos(BlockPos controllerPos) {
        this.controllerPos = controllerPos;
        this.controllerEntity = null;    // forces cache reload
        this.markDirty();
    }
    
    public MultiblockMachineController getCachedController() {
        if (!this.getCachedState().get(MachineCoreBlock.USED)) return null;
        
        if (controllerEntity == null)
            controllerEntity = (MultiblockMachineController) Objects.requireNonNull(world).getBlockEntity(getControllerPos());
        
        return controllerEntity;
    }
    
    private ValueStorage getMainStorage() {
        
        var isUsed = this.getCachedState().get(MachineCoreBlock.USED);
        if (!isUsed) return null;
        
        var controllerEntity = getCachedController();
        if (controllerEntity == null) return new SimpleEnergyStorage(100, 0, 0);
        return controllerEntity.getEnergyStorageForLink();
    }
    
    private Storage<FluidVariant> getMainFluidStorage(Direction direction) {
        
        var isUsed = this.getCachedState().get(MachineCoreBlock.USED);
        if (!isUsed) return null;
        
        var controllerEntity = getCachedController();
        if (!(controllerEntity instanceof FluidProvider fluidProvider)) return null;
        return fluidProvider.getFluidStorage(direction);
    }
    
    public boolean isEnabled() {
        return this.getCachedState().get(MachineCoreBlock.USED);
    }
    
    @Override
    public ValueStorage getEnergy(Direction direction) {
        if (getCachedController() == null || getCachedController().getEnergyStorageForLink() == null) {
            return null;
        } else {
            return delegatedStorage;
        }
    }
    
    @Override
    public InventoryStorage getInventory(Direction direction) {
        
        var isUsed = this.getCachedState().get(MachineCoreBlock.USED);
        if (!isUsed || getCachedController() == null || getCachedController().getInventoryForLink() == null) return null;
        
        return getCachedController().getInventoryForLink().getInventory(direction);
    }
    
    @Override
    public Storage<FluidVariant> getFluidStorage(Direction direction) {
        return getMainFluidStorage(direction);
    }
}
