package rearth.oritech.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import rearth.oritech.OritechClient;

public final class OritechFabricModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        
        OritechClient.initialize();
        OritechClient.registerRenderers();
        
    }
}
