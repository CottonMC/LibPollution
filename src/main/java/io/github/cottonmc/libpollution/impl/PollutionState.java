package io.github.cottonmc.libpollution.impl;

import io.github.cottonmc.libpollution.api.PollutionArea;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.PersistentState;

public class PollutionState extends PersistentState {
	private Long2ObjectMap<PollutionArea> chunkMap = new Long2ObjectOpenHashMap<>();

	public PollutionState() {
		super("pollution");
	}

	@Override
	public void fromTag(CompoundTag tag) {
		chunkMap.clear();
		for (String key : tag.getKeys()) {
			long chunk = Long.parseLong(key);
			PollutionArea area = new PollutionArea();
			area.fromTag(tag.getCompound(key));
			chunkMap.put(chunk, area);
		}
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		for (long key : chunkMap.keySet()) {
			PollutionArea area = chunkMap.get(key);
			tag.put(Long.toString(key), area.toTag());
		}
		return tag;
	}

	public PollutionArea getPollution(ChunkPos pos) {
		long key = pos.toLong();
		if (!chunkMap.containsKey(key)) {
			chunkMap.put(key, new PollutionArea());
			markDirty();
		}
		return chunkMap.get(key);
	}

	public void setPollution(ChunkPos pos, PollutionArea pollution) {
		chunkMap.put(pos.toLong(), pollution);
		markDirty();
	}
}
