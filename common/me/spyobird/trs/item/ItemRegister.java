package me.spyobird.trs.item;

import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModItem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemRegister
{
	public static TRSModItem TinIngot;
	public static ItemTinSword TinSword;
	
	public static void ItemInit()
	{
		TinIngot = new ItemTinIngot(IDs.ITEMTININGOTID);
		TinSword = new ItemTinSword(IDs.ITEMTINSWORDID);
		
		GameRegistry.registerItem(TinIngot, Strings.ITEMTININGOT_KEY);
		GameRegistry.registerItem(TinSword, Strings.ITEMTINSWORD_KEY);
		
		LanguageRegistry.addName(TinIngot, Strings.ITEMTININGOT_LOCAL);
		LanguageRegistry.addName(TinSword, Strings.ITEMTINSWORD_LOCAL);
	}
}
