package rearth.oritech.block.entity.machines.accelerator;

import earth.terrarium.common_storage_lib.energy.EnergyProvider;
import earth.terrarium.common_storage_lib.storage.base.ValueStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import rearth.oritech.Oritech;
import rearth.oritech.init.BlockEntitiesContent;
import rearth.oritech.util.SimpleEnergyStorage;

public class AcceleratorMotorBlockEntity extends BlockEntity implements EnergyProvider.BlockEntity {
    
    // TODO check if we actually want the version with the data manager here
    private final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(this, Oritech.ENERGY_CONTENT, 5_000_000, 5_000_000, 5_000_000);
    
    public AcceleratorMotorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesContent.ACCELERATOR_MOTOR_BLOCK_ENTITY, pos, state);
    }
    
    @Override
    public ValueStorage getEnergy(Direction direction) {
        return energyStorage;
    }
    
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putLong("energy", energyStorage.getStoredAmount());
    }
    
    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        energyStorage.set(nbt.getLong("energy"));
    }
}
