package me.spyobird.trs.lib.worldgen;

import java.util.Random;

import me.spyobird.trs.block.BlockRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class TRSModWorldGenKapokTree extends WorldGenerator
{
    private final int minTreeHeight;
    private final int metaWood;
    private final int metaLeaves;
    private final boolean vinesGrow;

    public TRSModWorldGenKapokTree(boolean dbn)
    {
        this(dbn, 6, 0, 0, false);
    }

    public TRSModWorldGenKapokTree(boolean dbn, int height, int metaW, int metaL, boolean vines)
    {
        super(dbn);
        this.minTreeHeight = height;
        this.metaWood = metaW;
        this.metaLeaves = metaL;
        this.vinesGrow = vines;
    }

    public boolean generate(World world, Random random, int x, int y, int z)
    {
        int l = random.nextInt(2) + this.minTreeHeight;
        boolean flag = true;

        if (y >= 1 && y + l + 1 <= 256)
        {
            int i1;
            byte b0;
            int j1;
            int k1;

            for (i1 = y; i1 <= y + 1 + l; ++i1)
            {
                b0 = 1;

                if (i1 == y)
                {
                    b0 = 0;
                }

                if (i1 >= y + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (int l1 = x - b0; l1 <= x + b0 && flag; ++l1)
                {
                    for (j1 = y - b0; j1 <= y + b0 && flag; ++j1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            k1 = world.getBlockId(l1, i1, j1);

                            Block block = Block.blocksList[k1];
                            boolean isAir = world.isAirBlock(l1, i1, j1);

                            if (!isAir &&
                               !block.isLeaves(world, l1, i1, j1) &&
                                k1 != Block.grass.blockID &&
                                k1 != Block.dirt.blockID &&
                               !block.isWood(world, l1, i1, j1))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                i1 = world.getBlockId(x, y - 1, z);
                Block soil = Block.blocksList[i1];
                boolean isSoil = (soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling)Block.sapling));

                if (isSoil && y < 256 - l - 1)
                {
                    soil.onPlantGrow(world, x, y - 1, z, x, y, z);
                    b0 = 3;
                    byte b1 = 0;
                    int i2;
                    int j2;
                    int k2;

                    for (j1 = y - b0 + l; j1 <= y + l; ++j1)
                    {
                        k1 = j1 - (y + l);
                        i2 = b1 + 1 - k1 / 2;

                        for (j2 = x - i2; j2 <= x + i2; ++j2)
                        {
                            k2 = j2 - x;

                            for (int l2 = z - i2; l2 <= z + i2; ++l2)
                            {
                                int i3 = l2 - z;

                                if (Math.abs(k2) != i2 || Math.abs(i3) != i2 || random.nextInt(2) != 0 && k1 != 0)
                                {
                                    int j3 = world.getBlockId(j2, j1, l2);
                                    Block block = Block.blocksList[j3];

                                    if (block == null || block.canBeReplacedByLeaves(world, j2, j1, l2))
                                    {
                                        this.setBlockAndMetadata(world, j2, j1, l2, BlockRegister.KapokLeaf.blockID, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (j1 = 0; j1 < l; ++j1)
                    {
                        k1 = world.getBlockId(x, y + j1, z);

                        Block block = Block.blocksList[k1];

                        if (k1 == 0 || block == null || block.isLeaves(world, x, y + j1, z))
                        {
                            this.setBlockAndMetadata(world, x, y + j1, z, BlockRegister.KapokLog.blockID, this.metaWood);

                            if (this.vinesGrow && j1 > 0)
                            {
                                if (random.nextInt(3) > 0 && world.isAirBlock(x - 1, y + j1, z))
                                {
                                    this.setBlockAndMetadata(world, x - 1, y + j1, z, Block.vine.blockID, 8);
                                }

                                if (random.nextInt(3) > 0 && world.isAirBlock(x + 1, y + j1, z))
                                {
                                    this.setBlockAndMetadata(world, x + 1, y + j1, z, Block.vine.blockID, 2);
                                }

                                if (random.nextInt(3) > 0 && world.isAirBlock(x, y + j1, z - 1))
                                {
                                    this.setBlockAndMetadata(world, x, y + j1, z - 1, Block.vine.blockID, 1);
                                }

                                if (random.nextInt(3) > 0 && world.isAirBlock(x, y + j1, z + 1))
                                {
                                    this.setBlockAndMetadata(world, x, y + j1, z + 1, Block.vine.blockID, 4);
                                }
                            }
                        }
                    }

                    if (this.vinesGrow)
                    {
                        for (j1 = y - 3 + l; j1 <= y + l; ++j1)
                        {
                            k1 = j1 - (y + l);
                            i2 = 2 - k1 / 2;

                            for (j2 = x - i2; j2 <= x + i2; ++j2)
                            {
                                for (k2 = z - i2; k2 <= z + i2; ++k2)
                                {
                                    Block block = Block.blocksList[world.getBlockId(j2, j1, k2)];
                                    if (block != null && block.isLeaves(world, j2, j1, k2))
                                    {
                                        if (random.nextInt(4) == 0 && world.isAirBlock(j2 - 1, j1, k2))
                                        {
                                            this.growVines(world, j2 - 1, j1, k2, 8);
                                        }

                                        if (random.nextInt(4) == 0 && world.isAirBlock(j2 + 1, j1, k2))
                                        {
                                            this.growVines(world, j2 + 1, j1, k2, 2);
                                        }

                                        if (random.nextInt(4) == 0 && world.isAirBlock(j2, j1, k2 - 1))
                                        {
                                            this.growVines(world, j2, j1, k2 - 1, 1);
                                        }

                                        if (random.nextInt(4) == 0 && world.isAirBlock(j2, j1, k2 + 1))
                                        {
                                            this.growVines(world, j2, j1, k2 + 1, 4);
                                        }
                                    }
                                }
                            }
                        }

                        if (random.nextInt(5) == 0 && l > 5)
                        {
                            for (j1 = 0; j1 < 2; ++j1)
                            {
                                for (k1 = 0; k1 < 4; ++k1)
                                {
                                    if (random.nextInt(4 - j1) == 0)
                                    {
                                        i2 = random.nextInt(3);
                                        this.setBlockAndMetadata(world, x + Direction.offsetX[Direction.rotateOpposite[k1]], y + l - 5 + j1, z + Direction.offsetZ[Direction.rotateOpposite[k1]], Block.cocoaPlant.blockID, i2 << 2 | k1);
                                    }
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private void growVines(World par1World, int par2, int par3, int par4, int par5)
    {
        this.setBlockAndMetadata(par1World, par2, par3, par4, Block.vine.blockID, par5);
        int i1 = 4;

        while (true)
        {
            --par3;

            if (!par1World.isAirBlock(par2, par3, par4) || i1 <= 0)
            {
                return;
            }

            this.setBlockAndMetadata(par1World, par2, par3, par4, Block.vine.blockID, par5);
            --i1;
        }
    }
}
