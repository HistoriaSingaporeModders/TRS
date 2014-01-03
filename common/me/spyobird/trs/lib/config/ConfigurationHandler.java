package me.spyobird.trs.lib.config;

import java.io.File;

import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.Strings;
import net.minecraftforge.common.Configuration;

public class ConfigurationHandler
{
	public static void ConfigInit(File file)
	{
		Configuration config = new Configuration(file);
		
		config.load();
		
		IDs.BLOCKTINOREID = config.getBlock(Strings.BLOCKTINORE_UNLOCAL, IDs.BLOCKTINOREID_DEFAULT).getInt();
		
		config.save();
	}
}
