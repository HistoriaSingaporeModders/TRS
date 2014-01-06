package me.spyobird.trs.lib;

import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class ToolMaterial
{
	public static EnumToolMaterial Tin;
	
	public static void ToolMaterialInit()
	{
		Tin = EnumHelper.addToolMaterial(Strings.ENUM_TOOL_MATERIAL_NAME_TIN, 2, 220, 5.5F, 2.0F, 18);
	}
}
