package rearth.oritech.util;

import earth.terrarium.common_storage_lib.context.ItemContext;
import earth.terrarium.common_storage_lib.data.DataManager;
import earth.terrarium.common_storage_lib.energy.impl.SimpleValueStorage;
import net.minecraft.component.ComponentType;

public class SimpleEnergyStorage extends SimpleValueStorage {
    private final long maxInsert;
    private final long maxExtract;
    
    public SimpleEnergyStorage(long capacity, long maxInsert, long maxExtract) {
        super(capacity);
        this.maxInsert = maxInsert;
        this.maxExtract = maxExtract;
    }
    
    public SimpleEnergyStorage(ItemContext context, ComponentType<Long> componentType, long capacity, long maxInsert, long maxExtract) {
        super(context, componentType, capacity);
        this.maxInsert = maxInsert;
        this.maxExtract = maxExtract;
    }
    
    public SimpleEnergyStorage(Object entityOrBlockEntity, DataManager<Long> dataManager, long capacity, long maxInsert, long maxExtract) {
        super(entityOrBlockEntity, dataManager, capacity);
        this.maxInsert = maxInsert;
        this.maxExtract = maxExtract;
    }
    
    @Override
    public long insert(long amount, boolean simulate) {
        return super.insert(Math.min(amount, maxInsert), simulate);
    }
    
    public long insertIgnoringLimit(long amount, boolean simulate) {
        return super.insert(amount, simulate);
    }
    
    @Override
    public long extract(long amount, boolean simulate) {
        return super.extract(Math.min(maxExtract, amount), simulate);
    }
    
    public long extractIgnoringLimit(long amount, boolean simulate) {
        return super.extract(amount, simulate);
    }
}