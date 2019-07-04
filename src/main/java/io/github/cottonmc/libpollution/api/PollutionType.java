package io.github.cottonmc.libpollution.api;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

public abstract class PollutionType {
    //TODO: figure out what this rate means code-wise
    protected int spreadRate;

    public PollutionType(int spreadRate) {
        this.spreadRate =  spreadRate;
    }

    public int getPollutionSpreadRate() {
        return spreadRate;
    }

    public abstract void affectEntity(LivingEntity entity);

    public abstract void affectWorld(World world, ChunkPos pos);
}
