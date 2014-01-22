package me.spyobird.trs.lib;

import net.minecraft.util.DamageSource;

public class TRSModDamageSource extends DamageSource
{
	public static DamageSource Kapok;
	
	protected TRSModDamageSource(String id)
    {
	    super(id);
    }

	public static void init()
	{
		Kapok = (new TRSModDamageSource("Kapok")).setDamageBypassesArmor();
	}
}
