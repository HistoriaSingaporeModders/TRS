package me.spyobird.trs.lib;

import me.spyobird.trs.item.ItemRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TRSModCreativeTabs extends CreativeTabs
{
	public TRSModCreativeTabs(int id, String label)
    {
	    super(id, label);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack()
    {
        return new ItemStack(ItemRegister.TinIngot, 1);
    }
}
