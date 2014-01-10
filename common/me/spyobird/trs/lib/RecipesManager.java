package me.spyobird.trs.lib;

import me.spyobird.trs.block.BlockRegister;
import me.spyobird.trs.item.ItemRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesManager
{
	public static void Recipes()
	{
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegister.TinBlock, 1), new Object[]
		{
			"XXX",
			"XXX",
			"XXX",
			'X', ItemRegister.TinIngot
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegister.TinSword, 1), new Object[]
		{
			"X",
			"X",
			"S",
			'X', ItemRegister.TinIngot, 'S', Item.stick
		});
	}
	
	public static void FurnaceRecipes()
	{
		GameRegistry.addSmelting(BlockRegister.TinOre.blockID, new ItemStack(ItemRegister.TinIngot, 1), 0.7F);
	}
}
