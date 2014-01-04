package me.spyobird.trs.block;

import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegister
{
	public static TRSModBlock TinOre;
	
	public static void BlockInit()
	{
		TinOre = new BlockTinOre(IDs.BLOCKTINOREID);
		
		GameRegistry.registerBlock(TinOre, TinOre.getAdvancedID());
		
		LanguageRegistry.addName(TinOre, Strings.BLOCKTINORE_LOCAL);
	}
}
