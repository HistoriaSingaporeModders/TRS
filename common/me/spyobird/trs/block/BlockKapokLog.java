package me.spyobird.trs.block;

import me.spyobird.trs.lib.References;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModBlock;
import me.spyobird.trs.lib.TRSModDamageSource;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockKapokLog extends TRSModBlock
{
	@SideOnly(Side.CLIENT)
    private Icon texture_side;
    @SideOnly(Side.CLIENT)
    private Icon texture_top;
	
	public BlockKapokLog(int id)
    {
	    super(id, Material.wood);
	    this.setUnlocalizedName(Strings.BLOCKKAPOKLOG_UNLOCAL);
	    this.setTextureName(Strings.BLOCKKAPOKLOG_TEXTURE);
	    this.setKey(Strings.BLOCKKAPOKLOG_KEY);
	    this.setHardness(2.0F);
	    this.setResistance(3.34F);
    }

	@Override
	public int getRenderType()
    {
        return 31;
    }

	@Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitx, float hity, float hitz, int meta)
    {
        byte b0 = 0;
        switch (side)
        {
            case 0:
            case 1:
                b0 = 0;
                break;
            case 2:
            case 3:
                b0 = 1;
                break;
            case 4:
            case 5:
                b0 = 2;
                break;
        }
        
        return b0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata)
    {
        int k = metadata & 3;
        return k == 0 && (side == 1 || side == 0) ? this.texture_top : (k == 1 && (side == 2 || side == 3) ? this.texture_top : (k == 2 && (side == 5 || side == 6) ? this.texture_top : this.texture_side));
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        this.texture_side = register.registerIcon(String.format("%s:%s", References.MODID, this.getTextureName()));
        this.texture_top = register.registerIcon(String.format("%s:%s", References.MODID, this.getTextureName()) + "_Top");
    }
    
    @Override
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(World world, int x, int y, int z)
    {
        return true;
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        entity.attackEntityFrom(TRSModDamageSource.Kapok, 1.0F);
    }
}
