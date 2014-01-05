package me.spyobird.trs;

import me.spyobird.trs.block.BlockRegister;
import me.spyobird.trs.item.ItemRegister;
import me.spyobird.trs.lib.CommonProxy;
import me.spyobird.trs.lib.References;
import me.spyobird.trs.lib.config.ConfigurationHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class TRS_main
{
	@Instance(References.MODID)
	public static TRS_main instance;
	
	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		ConfigurationHandler.ConfigInit(event.getSuggestedConfigurationFile());
		BlockRegister.BlockInit();
		ItemRegister.ItemInit();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public static void postLoad(FMLPostInitializationEvent event)
	{
		System.out.println("Mod is fully loaded");
	}
}
