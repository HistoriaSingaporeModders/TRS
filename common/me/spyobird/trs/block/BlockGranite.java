package me.spyobird.trs.block;

import net.minecraft.block.material.Material;
import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModBlock;

public class BlockGranite extends TRSModBlock
{
	public BlockGranite(int id)
    {
	    super(id, Material.rock, IDs.BLOCKGRANITE_CODE);
	    this.setUnlocalizedName(Strings.BLOCKGRANITE_UNLOCAL);
	    this.setTextureName(Strings.BLOCKGRANITE_TEXTURE);
	    this.setKey(Strings.BLOCKGRANITE_KEY);
	    this.setHardness(2.0F);
	    this.setResistance(6.0F);
    }
	
}
