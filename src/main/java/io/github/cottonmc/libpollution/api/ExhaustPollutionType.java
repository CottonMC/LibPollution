package io.github.cottonmc.libpollution.api;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

public class ExhaustPollutionType extends PollutionType {

	public ExhaustPollutionType() {
		super(3);
	}

	@Override
	public void affectEntity(LivingEntity entity) {
		entity.addPotionEffect(new StatusEffectInstance(StatusEffects.POISON, 200));
	}

	@Override
	public void affectWorld(World world, ChunkPos pos) {

	}
}
