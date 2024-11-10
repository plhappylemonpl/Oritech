package rearth.oritech.item.tools.armor;

import dev.architectury.fluid.FluidStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import rearth.oritech.client.init.ParticleContent;
import rearth.oritech.client.renderers.LaserArmRenderer;
import rearth.oritech.init.ComponentContent;
import rearth.oritech.init.FluidContent;
import rearth.oritech.item.tools.util.OritechEnergyItem;
import rearth.oritech.network.NetworkContent;
import rearth.oritech.util.TooltipHelper;

import java.util.List;

import static rearth.oritech.item.tools.harvesting.ChainsawItem.BAR_STEP_COUNT;

public interface BaseJetpackItem extends OritechEnergyItem {
    
    boolean requireUpward();
    int getRfUsage();
    int getFuelUsage();
    long getFuelCapacity();
    float getSpeed();
    
    default void tickJetpack(ItemStack stack, Entity entity, World world) {
        
        if (!(entity instanceof PlayerEntity player)) return;
        
        var isEquipped = player.getEquippedStack(EquipmentSlot.CHEST).equals(stack);
        if (!isEquipped) return;
        
        var client = MinecraftClient.getInstance();
        
        var up = client.options.jumpKey.isPressed();
        var forward = client.options.forwardKey.isPressed();
        var backward = client.options.backKey.isPressed();
        var left = client.options.leftKey.isPressed();
        var right = client.options.rightKey.isPressed();
        
        var horizontal = forward || backward || left || right;
        var upOnly = up && !horizontal;
        
        var isActive = up;
        if (!requireUpward()) isActive = up || horizontal;
        
        if (!isJetpackStarted(player, world, up)) return;
        
        if (!isActive || player.isOnGround() || player.isSubmergedInWater()) return;
        
        var powerMultiplier = getSpeed();
        
        // try using energy/fuel
        if (tryUseFluid(stack)) {
            powerMultiplier *= 2.5f;
        } else if (!tryUseEnergy(stack, getRfUsage(), player)) {
            return;
        }
        
        if (up) {
            processUpwardsMotion(player, powerMultiplier, upOnly);
        } else {
            powerMultiplier *= 0.7f;    // slower forward while not going up
        }
        
        if (forward || backward)
            processForwardMotion(player, forward, powerMultiplier);
        
        if (left || right)
            processSideMotion(player, right, powerMultiplier);
        
        var fluidStack = getStoredFluid(stack);
        var fluid = Registries.FLUID.getId(fluidStack.getFluid());
        
        // this will currently only for instances of this class
        NetworkContent.UI_CHANNEL.clientHandle().send(new NetworkContent.JetpackUsageUpdatePacket(getStoredEnergy(stack), fluid.toString(), fluidStack.getAmount()));
        
        var playerForward = player.getRotationVecClient();
        var playerRight = playerForward.normalize().rotateY(-90);
        var particleCenter = player.getEyePos().add(0, -1.1, 0).subtract(playerForward.multiply(0.2f));
        var particlePosA = particleCenter.add(playerRight.multiply(0.4f));
        var particlePosB = particleCenter.add(playerRight.multiply(-0.4f));
        
        var direction = new Vec3d(0, -1, 0);
        if (forward) direction = playerForward.normalize().multiply(-1).add(0, -1, 0);
        
        ParticleContent.JETPACK_EXHAUST.spawn(world, particlePosA, direction);
        ParticleContent.JETPACK_EXHAUST.spawn(world, particlePosB, direction);
    }
    
    private static boolean isJetpackStarted(PlayerEntity player, World world, boolean up) {
        
        var grounded = player.isOnGround() || player.isSubmergedInWater();
        
        if (grounded) {
            JetpackItem.LAST_GROUND_CONTACT = world.getTime();
            JetpackItem.PRESSED_SPACE = false;
            return false;
        } else {
            var flightTime = world.getTime() - JetpackItem.LAST_GROUND_CONTACT;
            
            if (flightTime < 5) return false;
            if (up) JetpackItem.PRESSED_SPACE = true;
            
            return JetpackItem.PRESSED_SPACE;
        }
    }
    
    private static void processUpwardsMotion(PlayerEntity player, float powerMultiplier, boolean upOnly) {
        var velocity = player.getMovement();
        
        var verticalMultiplier = LaserArmRenderer.lerp(powerMultiplier, 1, 0.6f);
        var power = 0.13f * verticalMultiplier;
        var dampeningFactor = 1.7f;
        
        if (!upOnly) power *= 0.7f;
        
        var speed = Math.max(velocity.y, 0.8);
        var addedVelocity = power / Math.pow(speed, dampeningFactor);
        
        player.setVelocity(velocity.add(0, addedVelocity, 0));
    }
    
    private static void processSideMotion(PlayerEntity player, boolean right, float powerMultiplier) {
        var modifier = right ? 1 : -1;  // either go full speed ahead, or slowly backwards
        var power = 0.04f * powerMultiplier;
        
        // get existing movement
        var movement = player.getMovement();
        var horizontalMovement = new Vec3d(movement.x, 0, movement.z);
        
        // get player facing
        var playerForward = player.getRotationVecClient();
        playerForward = new Vec3d(playerForward.x, 0, playerForward.z).normalize();
        var playerRight = playerForward.rotateY(-90);
        
        // apply forward / back
        horizontalMovement = horizontalMovement.add(playerRight.multiply(modifier * power));
        
        player.setVelocity(horizontalMovement.x, movement.y, horizontalMovement.z);
    }
    
    private static void processForwardMotion(PlayerEntity player, boolean forward, float powerMultiplier) {
        var modifier = forward ? 1f : -0.4;  // either go full speed ahead, or slowly backwards
        var power = 0.06f * powerMultiplier;
        
        // get existing movement
        var movement = player.getMovement();
        var horizontalMovement = new Vec3d(movement.x, 0, movement.z);
        
        // get player facing
        var playerForward = player.getRotationVecClient();
        playerForward = new Vec3d(playerForward.x, 0, playerForward.z).normalize();
        
        // apply forward / back
        horizontalMovement = horizontalMovement.add(playerForward.multiply(modifier * power));
        
        player.setVelocity(horizontalMovement.x, movement.y, horizontalMovement.z);
    }
    
    default boolean tryUseFluid(ItemStack stack) {
        var fluidStack = getStoredFluid(stack);
        if (fluidStack.getAmount() < getFuelUsage() || !isValidFuel(fluidStack.getFluid()))
            return false;
        var res = FluidStack.create(fluidStack.getFluid(), fluidStack.getAmount() - getFuelUsage());
        stack.set(ComponentContent.STORED_FLUID.get(), res);
        return true;
    }
    
    default FluidStack getStoredFluid(ItemStack stack) {
        return stack.getOrDefault(ComponentContent.STORED_FLUID.get(), FluidStack.empty());
    }
    
    default void addJetpackTooltip(ItemStack stack, List<Text> tooltip, boolean includeEnergy) {
        
        var text = Text.translatable("tooltip.oritech.energy_indicator", TooltipHelper.getEnergyText(this.getStoredEnergy(stack)), TooltipHelper.getEnergyText(this.getEnergyCapacity(stack)));
        if (includeEnergy) tooltip.add(text.formatted(Formatting.GOLD));
        
        var container = getStoredFluid(stack);
        var fluidText = Text.translatable("tooltip.oritech.jetpack_fuel", container.getAmount() * 1000 / FluidConstants.BUCKET, getFuelCapacity() * 1000 / FluidConstants.BUCKET, FluidVariantAttributes.getName(FluidVariant.of(container.getFluid())).getString());
        tooltip.add(fluidText);
    }
    
    default int getJetpackBarColor(ItemStack stack) {
        
        var fluidStack = getStoredFluid(stack);
        if (fluidStack.getAmount() > getFuelUsage() && isValidFuel(fluidStack.getFluid())) {
            return 0xbafc03;
        }
        
        return 0xff7007;
    }
    
    default int getJetpackBarStep(ItemStack stack) {
        
        var fluidStack = getStoredFluid(stack);
        if (fluidStack.getAmount() > getFuelUsage() && isValidFuel(fluidStack.getFluid())) {
            var fillPercent = fluidStack.getAmount() * 100 / getFuelCapacity();
            return Math.round(fillPercent * BAR_STEP_COUNT) / 100;
        }
        
        return Math.round((getStoredEnergy(stack) * 100f / this.getEnergyCapacity(stack)) * BAR_STEP_COUNT) / 100;
    }
    
    default boolean isValidFuel(Fluid variant) {
        return variant.matchesType(FluidContent.STILL_FUEL.get());
    }
    
    
}
