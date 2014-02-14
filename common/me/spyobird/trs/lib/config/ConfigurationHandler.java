package me.spyobird.trs.lib.config;

import java.io.File;

import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.Values;
import net.minecraftforge.common.Configuration;

public class ConfigurationHandler
{
	public static void ConfigInit(File file)
	{
		Configuration config = new Configuration(file);
		
		config.load();
		
		IDs.BLOCKTINOREID = config.getBlock(Strings.BLOCKTINORE_KEY, IDs.BLOCKTINOREID_DEFAULT).getInt();
		IDs.BLOCKTINSTORAGEID = config.getBlock(Strings.BLOCKTINSTORAGE_KEY, IDs.BLOCKTINSTORAGEID_DEFAULT).getInt();
		IDs.BLOCKGRANITEID = config.getBlock(Strings.BLOCKGRANITE_KEY, IDs.BLOCKGRANITEID_DEFAULT).getInt();
		IDs.BLOCKKAPOKLOGID = config.getBlock(Strings.BLOCKKAPOKLOG_KEY, IDs.BLOCKKAPOKLOGID_DEFAULT).getInt();
		IDs.BLOCKKAPOKLEAFID = config.getBlock(Strings.BLOCKKAPOKLEAF_KEY, IDs.BLOCKKAPOKLEAFID_DEFAULT).getInt();
		IDs.BLOCKKAPOKSAPLINGID = config.getBlock(Strings.BLOCKKAPOKSAPLING_KEY, IDs.BLOCKKAPOKSAPLINGID_DEFAULT).getInt();
		
		IDs.ITEMTININGOTID = config.getItem(Strings.ITEMTININGOT_KEY, IDs.ITEMTININGOTID_DEFAULT).getInt();
		IDs.ITEMTINSWORDID = config.getItem(Strings.ITEMTINSWORD_KEY, IDs.ITEMTINSWORDID_DEFAULT).getInt();
		IDs.ITEMTINPICKAXEID = config.getItem(Strings.ITEMTINPICKAXE_KEY, IDs.ITEMTINPICKAXEID_DEFAULT).getInt();
		
		Values.ENABLEDUNGEONLOOT = config.get(Strings.UTIL_CONFIG_NAME, "ENABLEDUNGEONLOOT", Values.ENABLEDUNGEONLOOT_DEFAULT).getBoolean(Values.ENABLEDUNGEONLOOT_DEFAULT);
		Values.DISABLEOREGEN = config.get(Strings.UTIL_CONFIG_NAME, "DISABLEOREGEN", Values.DISABLEOREGEN_DEFAULT).getBoolean(Values.DISABLEOREGEN_DEFAULT);
		Values.CUSTOMMOBSPAWNS = config.get(Strings.UTIL_CONFIG_NAME, "CUSTOMMOBSPAWNS", Values.CUSTOMMOBSPAWNS_DEFAULT).getBoolean(Values.CUSTOMMOBSPAWNS_DEFAULT);
		Values.CUSTOMORESPAWNS = config.get(Strings.UTIL_CONFIG_NAME, "CUSTOMORESPAWNS", Values.CUSTOMORESPAWN_DEFAULT).getBoolean(Values.CUSTOMORESPAWN_DEFAULT);
		
		config.save();
	}
}
