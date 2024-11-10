package rearth.oritech.neoforge.client;

import net.minecraft.util.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;
import rearth.oritech.Oritech;
import rearth.oritech.OritechClient;
import rearth.oritech.init.FluidContent;

@Mod(value = Oritech.MOD_ID, dist = Dist.CLIENT)
public class OritechClientNeoForge {
    
    public OritechClientNeoForge(IEventBus eventBus) {
        
        eventBus.register(new EventHandler());
        
        OritechClient.initialize();
    }
    
    static class EventHandler {
        
        @SubscribeEvent
        public void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            OritechClient.registerRenderers();
        }
        
        @SubscribeEvent
        public void initializeClient(RegisterClientExtensionsEvent event) {
            
            FluidContent.FLUID_ATTRIBUTES.forEach(attribute -> event.registerFluidType(new IClientFluidTypeExtensions() {
                @Override
                public @NotNull Identifier getStillTexture() {
                    return attribute.getSourceTexture();
                }
                
                @Override
                public @NotNull Identifier getFlowingTexture() {
                    return attribute.getFlowingTexture();
                }
                
                @Override
                public int getTintColor() {
                    return attribute.getColor();
                }
            }, attribute.getSourceFluid().getFluidType()));
            
        }
        
    }
    
}
