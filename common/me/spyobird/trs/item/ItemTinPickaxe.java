package me.spyobird.trs.item;

import me.spyobird.trs.TRS_main;
import me.spyobird.trs.lib.IDs;
import me.spyobird.trs.lib.References;
import me.spyobird.trs.lib.Strings;
import me.spyobird.trs.lib.ToolMaterial;
import me.spyobird.trs.lib.interfaces.IAdvancedID;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTinPickaxe extends ItemPickaxe implements IAdvancedID
{
	private String texture;
	private String key;
	private String catagory;
	private int code;
	
	public ItemTinPickaxe(int id)
    {
		super(id - References.ID_DISPLACEMENT_VALUE, ToolMaterial.Tin);
	    this.setCreativeTab(TRS_main.creativetabs);
	    this.setUnlocalizedName(Strings.ITEMTINPICKAXE_UNLOCAL);
	    this.setTextureName(Strings.ITEMTINPICKAXE_TEXTURE);
	    this.setKey(Strings.ITEMTINPICKAXE_KEY);
	    this.setCatagory(Strings.ITEMTOOL_CATAGORY);
	    this.setCode(IDs.ITEMTINPICKAXE_CODE);
    }
	
	@Override
	public boolean getIsRepairable(ItemStack itemtool, ItemStack itemstack)
	{
		return ItemRegister.TinIngot.itemID == itemstack.itemID ? true : super.getIsRepairable(itemtool, itemstack);
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
	
	@Override
    public boolean setCode(int code)
    {
	    return true;
    }

	@Override
    public int getCode()
    {
	    return code;
    }
	
	@Override
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
		return String.format("[%n:%n:%n:#%n]", References.MODID.toUpperCase(), cat, key, this.itemID + this.getCode());
	}
}
