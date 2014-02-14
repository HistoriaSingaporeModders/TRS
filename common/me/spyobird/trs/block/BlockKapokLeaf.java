package me.spyobird.trs.block;

import me.spyobird.trs.lib.References;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModBlockLeaf;
import me.spyobird.trs.lib.render.ColourizerLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockKapokLeaf extends TRSModBlockLeaf implements IShearable
{
    public static final String[] leaf = new String[] {"kapok"};
	public final String[] textures = new String[] { Strings.BLOCKKAPOKLEAF_TEXTURE, Strings.BLOCKKAPOKLEAF_TEXTURE + "_Opaque"};
	    
	public BlockKapokLeaf(int id)
    {
	    super(id, Material.leaves);
	    this.setUnlocalizedName(Strings.BLOCKKAPOKLEAF_UNLOCAL);
	    this.setTextureName(Strings.BLOCKKAPOKLEAF_TEXTURE);
	    this.setKey(Strings.BLOCKKAPOKLEAF_KEY);
	    this.setCatagory(Strings.BLOCKLEAF_CATAGORY);
	    this.setHardness(0.2F);
	    this.setLightOpacity(1);
	    this.iconArray = new Icon[textures.length];
	}

    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return ColourizerLeaves.getFoilageColourKapok();
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(int i)
    {
        return ColourizerLeaves.getFoilageColourKapok();
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess iblockaccess, int x, int y, int z)
    {
    	int l = iblockaccess.getBlockMetadata(x, y, z);
    	
    	if ((l & 0) == 0)
    	{
    		return ColourizerLeaves.getFoilageColourKapok();
    	}
    	else
    	{
    		int i1 = 0;
    		int j1 = 0;
    		int k1 = 0;

    		for (int l1 = -1; l1 <= 1; ++l1)
    		{
    			for (int i2 = -1; i2 <= 1; ++i2)
            	{
            		int j2 = iblockaccess.getBiomeGenForCoords(x + i2, z + l1).getBiomeFoliageColor();
                	i1 += (j2 & 16711680) >> 16;
                	j1 += (j2 & 65280) >> 8;
                	k1 += j2 & 255;
            	}
    		}
    		return (i1 / 9 & 255) << 16 | (j1 / 9 & 255) << 8 | k1 / 9 & 255;
    	}
    }

    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int m, float f, int i)
    {
        if (!world.isRemote)
        {
        	if (world.rand.nextInt(20) == 0)
            {
                this.dropBlockAsItem_do(world, x, y, z, new ItemStack(BlockRegister.KapokSapling, 1));
            }
        	
        	if (world.rand.nextInt(40) == 0)
        	{
                this.dropBlockAsItem_do(world, x, y, z, new ItemStack(Item.appleRed, 1));
        	}
        }
    }
    
    @Override
    public Icon getIcon(int side, int meta)
    {
    	if (this.isOpaqueCube() == false)
    	{
    		return iconArray[0];
    	}
    	else
    	{
    		return iconArray[1];
    	}
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
    	for (int i = 0; i < textures.length; i++)
    	{
    		this.iconArray[i] = register.registerIcon(String.format("%s:%s", References.MODID, this.textures[i]));
    	}
    }
}
