package me.spyobird.trs.block;

import net.minecraftforge.common.MinecraftForge;
import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegister
{
	public static TRSModBlock TinOre;
	public static TRSModBlock TinBlock;
	public static TRSModBlock Granite;
	
	public static void BlockInit()
	{
		TinOre = new BlockTinOre(IDs.BLOCKTINOREID);
		TinBlock = new BlockTinStorage(IDs.BLOCKTINSTORAGEID);
		Granite = new BlockGranite(IDs.BLOCKGRANITEID);
		
		GameRegistry.registerBlock(TinOre, Strings.BLOCKTINORE_KEY);
		GameRegistry.registerBlock(TinBlock, Strings.BLOCKTINSTORAGE_KEY);
		GameRegistry.registerBlock(Granite, Strings.BLOCKGRANITE_KEY);
		
		LanguageRegistry.addName(TinOre, Strings.BLOCKTINORE_LOCAL);
		LanguageRegistry.addName(TinBlock, Strings.BLOCKTINSTORAGE_LOCAL);
		LanguageRegistry.addName(Granite, Strings.BLOCKGRANITE_LOCAL);
		
		MinecraftForge.setBlockHarvestLevel(TinOre, Strings.PICKAXE_TOOL_NAME, 1);		
		MinecraftForge.setBlockHarvestLevel(TinBlock, Strings.PICKAXE_TOOL_NAME, 1);
	}
}
