package me.spyobird.trs.lib;

import java.util.Random;

import me.spyobird.trs.TRS_main;
import me.spyobird.trs.lib.interfaces.IAdvancedID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TRSModBlockSapling extends BlockFlower implements IAdvancedID
{
	private String texture;
	private String key;
	private String catagory;

	@SideOnly(Side.CLIENT)
	private Icon saplingIcon;
	
	protected TRSModBlockSapling(int id)
    {
        super(id);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(TRS_main.creativetabs);
    }

    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, x, y, z, rand);

            if (world.getBlockLightValue(x, y + 1, z) >= 9 && rand.nextInt(7) == 0)
            {
                this.markOrGrowMarked(world, x, y, z, rand);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
    	return this.saplingIcon;
    }

    public void markOrGrowMarked(World world, int x, int y, int z, Random rand)
    {
        int l = world.getBlockMetadata(x, y, z);

        if ((l & 8) == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
        }
        else
        {
            this.growTree(world, x, y, z, rand);
        }
    }

    public void growTree(World world, int x, int y, int z, Random rand)
    {
    	if (!TerrainGen.saplingGrowTree(world, rand, x, y, z)) return;

        int l = world.getBlockMetadata(x, y, z) & 3;
        Object object = null;
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        if (l == 1)
        {
            object = new WorldGenTaiga2(true);
        }
        else if (l == 2)
        {
            object = new WorldGenForest(true);
        }
        else if (l == 3)
        {
            for (i1 = 0; i1 >= -1; --i1)
            {
                for (j1 = 0; j1 >= -1; --j1)
                {
                    if (this.isSameSapling(world, x + i1, y, z + j1, 3) && this.isSameSapling(world, x + i1 + 1, y, z + j1, 3) && this.isSameSapling(world, x + i1, y, z + j1 + 1, 3) && this.isSameSapling(world, x + i1 + 1, y, z + j1 + 1, 3))
                    {
                        object = new WorldGenHugeTrees(true, 10 + rand.nextInt(20), 3, 3);
                        flag = true;
                        break;
                    }
                }

                if (object != null)
                {
                    break;
                }
            }

            if (object == null)
            {
                j1 = 0;
                i1 = 0;
                object = new WorldGenTrees(true, 4 + rand.nextInt(7), 3, 3, false);
            }
        }
        else
        {
            object = new WorldGenTrees(true);

            if (rand.nextInt(10) == 0)
            {
                object = new WorldGenBigTree(true);
            }
        }

        if (flag)
        {
            world.setBlock(x + i1, y, z + j1, 0, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1, 0, 0, 4);
            world.setBlock(x + i1, y, z + j1 + 1, 0, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1 + 1, 0, 0, 4);
        }
        else
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

    public boolean isSameSapling(World world, int x, int y, int z, int m)
    {
        return world.getBlockId(x, y, z) == this.blockID && (world.getBlockMetadata(x, y, z) & 3) == m;
    }

    public int damageDropped(int m)
    {
        return m;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        this.saplingIcon = register.registerIcon(String.format("%s:%s", References.MODID, this.getTextureName()));
    }
    
    public Block setTextureName(String texture)
	{
		this.texture = texture;
		return this;
	}
	
	public Block setKey(String key)
	{
		this.key = key;
		return this;
	}
	
	public Block setCatagory(String catagory)
	{
		this.catagory = catagory;
		return this;
	}
	
	public String getTextureName()
	{
		return this.texture;
	}
	
	public String getKey()
	{
		return "BLOCK_" + this.key;
	}
	
	public String getCatagory()
	{
		return "BLOCK_CATAGORY_" + this.catagory;
	}
	
	public String getSimpleUnlocalizedName()
	{
		return this.getUnlocalizedName().substring(5);
	}
	
	public String getSimpleKey()
	{
		return this.key;
	}
	
	public String getSimpleCatagory()
	{
		return this.catagory;
	}
	
	@Override
	public String getAdvancedID()
	{
		String cat;
		String key;
		if (this.catagory == null)
		{
			cat = "BLOCK";
		}
		else
		{
			cat = this.getSimpleCatagory();
		}
		if (this.key == null)
		{
			key = this.getSimpleUnlocalizedName();
		}
		else
		{
			key = this.getSimpleKey();
		}
		return String.format("[%n:%n:%n:#%n]", References.MODID.toUpperCase(), cat, key, this.blockID);
	}
}
