package me.spyobird.trs.item;

import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModItem;

public class ItemTinIngot extends TRSModItem
{
	public ItemTinIngot(int id)
    {
	    super(id, IDs.ITEMTININGOT_CODE);
	    this.setUnlocalizedName(Strings.ITEMTININGOT_UNLOCAL);
	    this.setTextureName(Strings.ITEMTININGOT_TEXTURE);
	    this.setKey(Strings.ITEMTININGOT_KEY);
	    this.setCatagory(Strings.ITEMMATERIAL_CATAGORY);
    }
}
