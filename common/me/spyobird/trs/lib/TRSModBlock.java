package me.spyobird.trs.lib;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TRSModBlock extends Block
{
	private String texture;
	
	public TRSModBlock(int id, Material material, String texture, String unlocal)
    {
	    super(id, material);
	    this.texture = texture;
	    this.setUnlocalizedName(unlocal);
	    this.setCreativeTab(CreativeTabs.tabMisc);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
        blockIcon = register.registerIcon(String.format("%s:%s", References.MODID, texture));
	}
}
