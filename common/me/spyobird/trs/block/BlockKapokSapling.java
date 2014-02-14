package me.spyobird.trs.block;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModBlockSapling;
import me.spyobird.trs.lib.worldgen.TRSModWorldGenKapokTree;

public class BlockKapokSapling extends TRSModBlockSapling
{
	protected BlockKapokSapling(int id)
    {
	    super(id);
	    this.setUnlocalizedName(Strings.BLOCKKAPOKSAPLING_UNLOCAL);
	    this.setTextureName(Strings.BLOCKKAPOKSAPLING_TEXTURE);
	    this.setKey(Strings.BLOCKKAPOKSAPLING_KEY);
	    this.setCatagory(Strings.BLOCKSAPLING_CATAGORY);
    }
	
	@Override
	public void growTree(World world, int x, int y, int z, Random rand)
    {
        if (!TerrainGen.saplingGrowTree(world, rand, x, y, z)) return;

        int l = world.getBlockMetadata(x, y, z) & 0;
        Object object = null;
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        if (l == 0)
        {
            object = new TRSModWorldGenKapokTree(true);
        }

        if (!flag)
        {
        	world.setBlock(x, y, z, 0, 0, 4);
        }

        if (!((WorldGenerator)object).generate(world, rand, x + i1, y, z + j1))
        {
            if (flag)
            {
                world.setBlock(x + i1, y, z + j1, this.blockID, l, 4);
                world.setBlock(x + i1 + 1, y, z + j1, this.blockID, l, 4);
                world.setBlock(x + i1, y, z + j1 + 1, this.blockID, l, 4);
                world.setBlock(x + i1 + 1, y, z + j1 + 1, this.blockID, l, 4);
            }
            else
            {
                world.setBlock(x, y, z, this.blockID, l, 4);
            }
        }
    }
}
