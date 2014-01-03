package me.spyobird.trs.lib;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TRSModBlock extends Block
{
	private String[] textures;
	public Icon[] icons;
	
	public TRSModBlock(int id, Material material, String[] textures, String unlocal)
    {
	    super(id, material);
	    this.textures = textures;
	    this.setUnlocalizedName(unlocal);
	    this.setCreativeTab(CreativeTabs.tabMisc);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.icons = new Icon[textures.length];
		
        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = register.registerIcon(String.format("%n:%n", References.MODID, textures[i]));
        }
	}
	
	@Override
    public int damageDropped(int meta)
    {
        return meta;
    }
	
	@Override
    public void getSubBlocks(int id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < icons.length; i++)
        {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
