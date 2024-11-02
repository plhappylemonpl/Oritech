package rearth.oritech.util;

import earth.terrarium.common_storage_lib.storage.base.UpdateManager;
import earth.terrarium.common_storage_lib.storage.base.ValueStorage;
import org.jetbrains.annotations.Nullable;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class DelegatingEnergyStorage implements ValueStorage, UpdateManager<Long> {
    
    protected final Supplier<ValueStorage> backingStorage;
    protected final BooleanSupplier validPredicate;
    
    public DelegatingEnergyStorage(Supplier<ValueStorage> backingStorage, @Nullable BooleanSupplier validPredicate) {
        this.backingStorage = backingStorage;
        this.validPredicate = validPredicate == null ? () -> true : validPredicate;
    }
    
    public DelegatingEnergyStorage(ValueStorage backingStorage, @Nullable BooleanSupplier validPredicate) {
        this(() -> backingStorage, validPredicate);
    }
    
    @Override
    public long getStoredAmount() {
        if (validPredicate.getAsBoolean()) {
            return backingStorage.get().getStoredAmount();
        }
        return 0;
    }
    
    @Override
    public long getCapacity() {
        if (validPredicate.getAsBoolean()) {
            return backingStorage.get().getCapacity();
        }
        return 0;
    }
    
    @Override
    public boolean allowsInsertion() {
        if (validPredicate.getAsBoolean()) {
            return backingStorage.get().allowsInsertion();
        }
        return false;
    }
    
    @Override
    public boolean allowsExtraction() {
        if (validPredicate.getAsBoolean()) {
            return backingStorage.get().allowsExtraction();
        }
        return false;
    }
    
    @Override
    public long insert(long amount, boolean simulate) {
        if (validPredicate.getAsBoolean()) {
            return backingStorage.get().insert(amount, simulate);
        }
        return 0;
    }
    
    @Override
    public long extract(long amount, boolean simulate) {
        if (validPredicate.getAsBoolean()) {
            return backingStorage.get().extract(amount, simulate);
        }
        return 0;
    }
    
    @Override
    public Long createSnapshot() {
        if (validPredicate.getAsBoolean() && backingStorage.get() instanceof UpdateManager<?> manager) {
            return (Long) manager.createSnapshot();
        }
        return 0L;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void readSnapshot(Long snapshot) {
        if (validPredicate.getAsBoolean() && backingStorage.get() instanceof UpdateManager<?> manager) {
            ((UpdateManager<Long>) manager).readSnapshot(snapshot);
        }
    }
    
    @Override
    public void update() {
        if (validPredicate.getAsBoolean() && backingStorage.get() instanceof UpdateManager<?> manager) {
            manager.update();
        }
    }
}
