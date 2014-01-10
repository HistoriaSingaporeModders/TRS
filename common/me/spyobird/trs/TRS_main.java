package me.spyobird.trs;

import me.spyobird.trs.block.BlockRegister;
import me.spyobird.trs.item.ItemRegister;
import me.spyobird.trs.lib.CommonProxy;
import me.spyobird.trs.lib.RecipesManager;
import me.spyobird.trs.lib.References;
import me.spyobird.trs.lib.ToolMaterial;
import me.spyobird.trs.lib.config.ConfigurationHandler;
import me.spyobird.trs.lib.event.EventHandlerMobSpawn;
import me.spyobird.trs.lib.event.EventHandlerOreGen;
import me.spyobird.trs.lib.worldgen.TRSModWorldGenOre;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = References.MODID)
public class TRS_main
{
	@Instance(References.MODID)
	public static TRS_main instance;
	
	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
	public static CommonProxy proxy;
	
	EventHandlerOreGen oregen = new EventHandlerOreGen();
	EventHandlerMobSpawn mobspawn = new EventHandlerMobSpawn();
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		ConfigurationHandler.ConfigInit(event.getSuggestedConfigurationFile());
		ToolMaterial.ToolMaterialInit();
		BlockRegister.BlockInit();
		ItemRegister.ItemInit();
		
		GameRegistry.registerWorldGenerator(new TRSModWorldGenOre());
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		MinecraftForge.ORE_GEN_BUS.register(oregen);
		MinecraftForge.EVENT_BUS.register(mobspawn);
	}
	
	@EventHandler
	public static void postLoad(FMLPostInitializationEvent event)
	{
		RecipesManager.Recipes();
		RecipesManager.FurnaceRecipes();
		System.out.println("Mod is fully loaded");
	}
}
