package me.spyobird.trs.block;

import net.minecraftforge.common.MinecraftForge;
import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.TRSModBlock;
import me.spyobird.trs.lib.TRSModBlockSapling;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegister
{
	public static TRSModBlock TinOre;
	public static TRSModBlock TinBlock;
	public static TRSModBlock Granite;
	public static TRSModBlock KapokLog;
	public static BlockKapokLeaf KapokLeaf;
	public static TRSModBlockSapling KapokSapling;
	
	public static void BlockInit()
	{
		TinOre = new BlockTinOre(IDs.BLOCKTINOREID);
		TinBlock = new BlockTinStorage(IDs.BLOCKTINSTORAGEID);
		Granite = new BlockGranite(IDs.BLOCKGRANITEID);
		KapokLog = new BlockKapokLog(IDs.BLOCKKAPOKLOGID);
		KapokLeaf = new BlockKapokLeaf(IDs.BLOCKKAPOKLEAFID);
		KapokSapling = new BlockKapokSapling(IDs.BLOCKKAPOKSAPLINGID);
		
		GameRegistry.registerBlock(TinOre, Strings.BLOCKTINORE_KEY);
		GameRegistry.registerBlock(TinBlock, Strings.BLOCKTINSTORAGE_KEY);
		GameRegistry.registerBlock(Granite, Strings.BLOCKGRANITE_KEY);
		GameRegistry.registerBlock(KapokLog, Strings.BLOCKKAPOKLOG_KEY);
		GameRegistry.registerBlock(KapokLeaf, Strings.BLOCKKAPOKLEAF_KEY);
		GameRegistry.registerBlock(KapokSapling, Strings.BLOCKKAPOKSAPLING_KEY);
		
		LanguageRegistry.addName(TinOre, Strings.BLOCKTINORE_LOCAL);
		LanguageRegistry.addName(TinBlock, Strings.BLOCKTINSTORAGE_LOCAL);
		LanguageRegistry.addName(Granite, Strings.BLOCKGRANITE_LOCAL);
		LanguageRegistry.addName(KapokLog, Strings.BLOCKKAPOKLOG_LOCAL);
		LanguageRegistry.addName(KapokLeaf, Strings.BLOCKKAPOKLEAF_LOCAL);
		LanguageRegistry.addName(KapokSapling, Strings.BLOCKKAPOKSAPLING_LOCAL);
		
		MinecraftForge.setBlockHarvestLevel(TinOre, Strings.PICKAXE_TOOL_NAME, 1);		
		MinecraftForge.setBlockHarvestLevel(TinBlock, Strings.PICKAXE_TOOL_NAME, 1);
	}
}
