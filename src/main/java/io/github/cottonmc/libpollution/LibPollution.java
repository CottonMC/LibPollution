package io.github.cottonmc.libpollution;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.World;

public class LibPollution implements ModInitializer {
	public static final Registry<PollutionType> POLLUTION_TYPE = new SimpleRegistry<>();

	@Override
	public void onInitialize() {
		Registry.register(POLLUTION_TYPE, new Identifier("libpollution", "exhaust"), new PollutionType());
	}

	public static PollutionArea getPollutionArea(ServerWorld world, BlockPos pos) {
		return world.getPersistentStateManager().getOrCreate(PollutionState::new, "pollution").getPollution(world.getChunk(pos).getPos());
	}
}
