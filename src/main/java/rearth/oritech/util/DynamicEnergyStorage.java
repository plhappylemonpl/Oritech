package rearth.oritech.util;

import earth.terrarium.common_storage_lib.storage.base.UpdateManager;
import earth.terrarium.common_storage_lib.storage.base.ValueStorage;

public class DynamicEnergyStorage implements ValueStorage, UpdateManager<Long> {
    public long amount;
    public long capacity;
    public long maxInsert;
    public long maxExtract;
    private final Runnable onUpdate;
    
    public DynamicEnergyStorage(long capacity, long maxInsert, long maxExtract, Runnable onUpdate) {
        this.capacity = capacity;
        this.maxInsert = maxInsert;
        this.maxExtract = maxExtract;
        this.onUpdate = onUpdate;
    }
    
    @Override
    public long getStoredAmount() {
        return amount;
    }
    
    @Override
    public long getCapacity() {
        return capacity;
    }
    
    public void set(long amount) {
        this.amount = amount;
    }
    
    @Override
    public boolean allowsInsertion() {
        return true;
    }
    
    @Override
    public boolean allowsExtraction() {
        return true;
    }
    
    @Override
    public long insert(long amount, boolean simulate) {
        long inserted = Math.min(Math.min(maxInsert, amount), capacity - this.amount);
        if (!simulate) {
            this.amount += inserted;
        }
        return inserted;
    }
    
    public long insertIgnoringLimit(long amount, boolean simulate) {
        long inserted = Math.min(amount, capacity - this.amount);
        if (!simulate) {
            this.amount += inserted;
        }
        return inserted;
    }
    
    @Override
    public long extract(long amount, boolean simulate) {
        long extracted = Math.min(Math.min(amount, maxExtract), this.amount);
        if (!simulate) {
            this.amount -= extracted;
        }
        return extracted;
    }
    
    @Override
    public Long createSnapshot() {
        return amount;
    }
    
    @Override
    public void readSnapshot(Long snapshot) {
        this.amount = snapshot;
    }
    
    @Override
    public void update() {
        onUpdate.run();
    }
}