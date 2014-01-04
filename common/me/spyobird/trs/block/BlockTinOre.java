package me.spyobird.trs.block;

import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModBlock;
import net.minecraft.block.material.Material;

public class BlockTinOre extends TRSModBlock
{
	public BlockTinOre(int id)
    {
	    super(id, Material.rock);
	    this.setUnlocalizedName(Strings.BLOCKTINORE_UNLOCAL);
	    this.setTextureName(Strings.BLOCKTINORE_TEXTURE);
	    this.setKey(Strings.BLOCKTINORE_KEY);
	    this.setCatagory(Strings.BLOCKTINORE_CATAGORY);
    }
}
