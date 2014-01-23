package me.spyobird.trs.block;

import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModBlock;
import net.minecraft.block.material.Material;

public class BlockGranite extends TRSModBlock
{
	public BlockGranite(int id)
    {
	    super(id, Material.rock);
	    this.setUnlocalizedName(Strings.BLOCKGRANITE_UNLOCAL);
	    this.setTextureName(Strings.BLOCKGRANITE_TEXTURE);
	    this.setKey(Strings.BLOCKGRANITE_KEY);
	    this.setHardness(2.0F);
	    this.setResistance(6.0F);
    }
	
}
