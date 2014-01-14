package me.spyobird.trs.lib.worldgen;

import me.spyobird.trs.item.ItemRegister;
import me.spyobird.trs.lib.Values;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class TRSModDungeonChestGen
{
	public static void GenInit()
	{
		if (Values.ENABLEDUNGEONLOOT == true)
		{
			ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(ItemRegister.TinIngot.itemID, 0, 1, 4, 10));
		}
	}
}
