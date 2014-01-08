package me.spyobird.trs.lib.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class EventHandlerMobSpawn
{
	@ForgeSubscribe
	public void MobSpawn(LivingSpawnEvent event)
	{
		if (event.entity instanceof EntityCow || event.entity instanceof EntityHorse || event.entity instanceof EntitySheep || event.entity instanceof EntityMooshroom || event.entity instanceof EntityZombie || event.entity instanceof EntitySkeleton || event.entity instanceof EntityCreeper || event.entity instanceof EntityEnderman)
		{
			Entity mob = event.entity;
			if (mob.isEntityAlive() == true)
			{
				mob.setInvisible(true);
				mob.setDead();
			}
		}
	}
}
