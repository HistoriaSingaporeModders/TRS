package me.spyobird.trs.lib;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TRSModItem extends Item
{
	private String texture;
	private String key;
	private String catagory;
	
	public TRSModItem(int id)
    {
	    super(id);
	    this.setCreativeTab(CreativeTabs.tabMisc);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
        itemIcon = register.registerIcon(String.format("%s:%s", References.MODID, this.getTextureName()));
	}
	
	public Item setTextureName(String texture)
	{
		this.texture = texture;
		return this;
	}
	
	public Item setKey(String key)
	{
		this.key = key;
		return this;
	}
	
	public Item setCatagory(String catagory)
	{
		this.catagory = catagory;
		return this;
	}
	
	public String getTextureName()
	{
		return this.texture;
	}
	
	public String getKey()
	{
		return "ITEM_" + this.key;
	}
	
	public String getCatagory()
	{
		return "ITEM_CATAGORY_" + this.catagory;
	}
	
	public String getSimpleUnlocalizedName()
	{
		return this.getUnlocalizedName().substring(5);
	}
	
	public String getSimpleKey()
	{
		return this.key;
	}
	
	public String getSimpleCatagory()
	{
		return this.catagory;
	}
	
	public String getAdvancedID()
	{
		String cat;
		String key;
		if (this.catagory == null)
		{
			cat = "ITEM";
		}
		else
		{
			cat = this.getSimpleCatagory();
		}
		if (this.key == null)
		{
			key = this.getSimpleUnlocalizedName();
		}
		else
		{
			key = this.getSimpleKey();
		}
		return String.format("[%n:%n:%n:#%n]", References.MODID.toUpperCase(), cat, key, this.itemID);
	}
}
