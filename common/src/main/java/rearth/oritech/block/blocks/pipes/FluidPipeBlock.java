package rearth.oritech.block.blocks.pipes;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.apache.commons.lang3.function.TriFunction;
import rearth.oritech.block.entity.pipes.GenericPipeInterfaceEntity;
import rearth.oritech.init.BlockContent;

import java.util.HashMap;

public class FluidPipeBlock extends GenericPipeBlock {
    
    public static HashMap<Identifier, GenericPipeInterfaceEntity.PipeNetworkData> FLUID_PIPE_DATA = new HashMap<>();
    public static final BooleanProperty EXTRACT = FluidPipeConnectionBlock.EXTRACT;
    
    public FluidPipeBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(EXTRACT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(EXTRACT);
    }
    
    @Override
    public TriFunction<World, BlockPos, Direction, Boolean> apiValidationFunction() {
        return ((world, pos, direction) -> FluidStorage.SIDED.find(world, pos, direction) != null);
    }
    
    @Override
    public BlockState getConnectionBlock() {
        return BlockContent.FLUID_PIPE_CONNECTION.getDefaultState();
    }
    
    @Override
    public BlockState getNormalBlock() {
        return BlockContent.FLUID_PIPE.getDefaultState();
    }
    
    @Override
    public String getPipeTypeName() {
        return "fluid";
    }
    
    // to connect when a neighboring block emits a block update (e.g. the centrifuge getting a fluid addon)
    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
        
        world.setBlockState(pos, getStateForNeighborUpdate(state, null, null, world, pos, sourcePos), Block.NOTIFY_LISTENERS, 0);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        var baseState = super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);

        return baseState.with(EXTRACT, state.get(EXTRACT));
    }
    
    @Override
    public boolean connectToOwnBlockType(Block block) {
        return block instanceof FluidPipeBlock || block instanceof FluidPipeConnectionBlock;
    }
    
    @Override
    public GenericPipeInterfaceEntity.PipeNetworkData getNetworkData(World world) {
        return FLUID_PIPE_DATA.computeIfAbsent(world.getRegistryKey().getValue(), data -> new GenericPipeInterfaceEntity.PipeNetworkData());
    }
}
