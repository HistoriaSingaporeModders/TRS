package me.spyobird.trs.lib.event;

import me.spyobird.trs.block.BlockKapokSapling;
import me.spyobird.trs.block.BlockRegister;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class EventHandlerBoneMeal
{
	@ForgeSubscribe
	public void doBoneMeal(BonemealEvent event)
	{
		World world = event.world;
		if (event.ID == BlockRegister.KapokSapling.blockID)
		{
			event.setResult(Result.ALLOW);
			if (!world.isRemote)
            {
                if ((double)world.rand.nextFloat() < 0.45D)
                {
                    ((BlockKapokSapling)BlockRegister.KapokSapling).markOrGrowMarked(world, event.X, event.Y, event.Z, world.rand);
                }
            }
		}
	}
}
