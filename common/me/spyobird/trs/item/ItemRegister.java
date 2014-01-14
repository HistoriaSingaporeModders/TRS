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
	public static ItemTinPickaxe TinPickaxe;
	
	public static void ItemInit()
	{
		TinIngot = new ItemTinIngot(IDs.ITEMTININGOTID);
		TinSword = new ItemTinSword(IDs.ITEMTINSWORDID);
		TinPickaxe = new ItemTinPickaxe(IDs.ITEMTINPICKAXEID);
		
		GameRegistry.registerItem(TinIngot, Strings.ITEMTININGOT_KEY);
		GameRegistry.registerItem(TinSword, Strings.ITEMTINSWORD_KEY);
		GameRegistry.registerItem(TinPickaxe, Strings.ITEMTINPICKAXE_KEY);
		
		LanguageRegistry.addName(TinIngot, Strings.ITEMTININGOT_LOCAL);
		LanguageRegistry.addName(TinSword, Strings.ITEMTINSWORD_LOCAL);
		LanguageRegistry.addName(TinPickaxe, Strings.ITEMTINPICKAXE_LOCAL);
	}
}
