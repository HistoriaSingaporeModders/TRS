package me.spyobird.trs.lib.worldgen;

import java.util.Random;

import me.spyobird.trs.block.BlockRegister;
import me.spyobird.trs.lib.Values;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class TRSModWorldGen implements IWorldGenerator
{
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
		switch (world.provider.dimensionId)
		{
	        case -1:
	            generateNether(world, random, chunkX * 16, chunkZ * 16);
	            break;
	        case 0:
	            generateSurface(world, random, chunkX * 16, chunkZ * 16);
	            break;
	        case 1:
	            generateEnd(world, random, chunkX * 16, chunkZ * 16);
	            break;
	        }
		}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
		
	private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
		if (Values.CUSTOMORESPAWNS == true)
		{
			TRSModWorldGenOre.addOreSpawn(BlockRegister.TinOre, world, rand, chunkX, chunkZ, 16, 16, 4, 24, 1, 72);
			TRSModWorldGenOre.addOreSpawn(BlockRegister.Granite, world, rand, chunkX, chunkZ, 16, 16, 24, 16, 12, 128);
		}
		
		for (int chance = 0; chance < 24; chance++)
		{
			int x1 = chunkX + rand.nextInt(16);
			int y1 = rand.nextInt(90);
			int z1 = chunkZ + rand.nextInt(16);
			(new TRSModWorldGenKapokTree(false)).generate(world, rand, x1, y1, z1);
		}
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}
}