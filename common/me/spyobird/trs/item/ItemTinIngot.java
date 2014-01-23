package me.spyobird.trs.item;

import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModItem;

public class ItemTinIngot extends TRSModItem
{
	public ItemTinIngot(int id)
    {
	    super(id);
	    this.setUnlocalizedName(Strings.ITEMTININGOT_UNLOCAL);
	    this.setTextureName(Strings.ITEMTININGOT_TEXTURE);
	    this.setKey(Strings.ITEMTININGOT_KEY);
	    this.setCatagory(Strings.ITEMMATERIAL_CATAGORY);
    }
}
