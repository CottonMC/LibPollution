package io.github.cottonmc.libpollution;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PollutionArea {
    private final World world;
    private final BlockPos pos;

    public PollutionArea(World world, BlockPos pos) {
        this.world = world;
        this.pos = pos;
    }

    public void pollute(PollutionType pollutionType, int amount) {
    }

    public int getPollution(PollutionType pollutionType) {
        return 0;
    }
}
