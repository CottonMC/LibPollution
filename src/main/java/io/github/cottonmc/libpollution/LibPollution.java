package io.github.cottonmc.libpollution;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;

public class LibPollution implements ModInitializer {
	public static final Registry<PollutionType> POLLUTION_TYPE = new SimpleRegistry<>();

	@Override
	public void onInitialize() {
		Registry.register(POLLUTION_TYPE, "libpollution:exhaust", new PollutionType());
		Registry.register(POLLUTION_TYPE, "libpollution:radiation", new PollutionType());
	}
}
