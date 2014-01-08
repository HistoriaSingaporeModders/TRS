package me.spyobird.trs.lib.event;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;

public class EventHandlerOreGen
{
	@ForgeSubscribe
	public void disableVanillaOreGen(GenerateMinable event)
	{
		switch (event.type)
		{
			case COAL:
				event.setResult(Result.DENY);
			case DIAMOND:
				event.setResult(Result.DENY);
			case GOLD:
				event.setResult(Result.DENY);
			case IRON:
				event.setResult(Result.DENY);
			case LAPIS:
				event.setResult(Result.DENY);
			case REDSTONE:
				event.setResult(Result.DENY);
		}
	}
}
