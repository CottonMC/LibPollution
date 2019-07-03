package io.github.cottonmc.libpollution;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;

public class PollutionArea {
    private final Object2IntMap<PollutionType> pollutions = new Object2IntOpenHashMap<>();

    public PollutionArea() {
    }

    public void pollute(PollutionType type, int amount) {
        if (!pollutions.containsKey(type)) pollutions.put(type, amount);
        else {
            int existing = pollutions.getInt(type);
            pollutions.put(type, existing + amount);
        }
    }

    public int getPollution(PollutionType type) {
        return pollutions.getOrDefault(type, 0);
    }

    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();
        for (PollutionType type : pollutions.keySet()) {
            String key = LibPollution.POLLUTION_TYPE.getId(type).toString();
            tag.putInt(key, pollutions.getInt(type));
        }
        return tag;
    }

    public void fromTag(CompoundTag tag) {
        pollutions.clear();
        for (String key : tag.getKeys()) {
            PollutionType type = LibPollution.POLLUTION_TYPE.get(new Identifier(key));
            int value = tag.getInt(key);
            pollutions.put(type, value);
        }
    }
}
