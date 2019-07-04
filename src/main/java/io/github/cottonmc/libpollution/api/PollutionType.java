package io.github.cottonmc.libpollution.api;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

public abstract class PollutionType {
    public int getPollutionSpreadRate() {
        return 0;
    }

    public abstract void affectEntity(LivingEntity entity);

    public abstract void affectWorld(World world, ChunkPos pos);
}
