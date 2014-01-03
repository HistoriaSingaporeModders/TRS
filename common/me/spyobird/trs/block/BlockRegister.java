package me.spyobird.trs.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.Strings;
import net.minecraft.block.Block;

public class BlockRegister
{
	public static Block TinOre;
	
	public static void BlockInit()
	{
		TinOre = new BlockTinOre(IDs.BLOCKTINOREID, Strings.BLOCKTINORE_TEXTURE, Strings.BLOCKTINORE_UNLOCAL);
		
		GameRegistry.registerBlock(TinOre, Strings.BLOCKTINORE_UNLOCAL);
		
		LanguageRegistry.addName(TinOre, Strings.BLOCKTINORE_LOCAL);
	}
}
