package me.spyobird.trs.block;

import net.minecraft.block.material.Material;
import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModBlock;

public class BlockTinStorage extends TRSModBlock
{
	public BlockTinStorage(int id)
    {
	    super(id, Material.iron, IDs.BLOCKTINSTORAGE_CODE);
	    this.setUnlocalizedName(Strings.BLOCKTINSTORAGE_UNLOCAL);
	    this.setTextureName(Strings.BLOCKTINSTORAGE_TEXTURE);
	    this.setKey(Strings.BLOCKTINSTORAGE_KEY);
	    this.setCatagory(Strings.BLOCKSTORAGE_CATAGORY);
	    this.setHardness(4.0F);
    }
}
