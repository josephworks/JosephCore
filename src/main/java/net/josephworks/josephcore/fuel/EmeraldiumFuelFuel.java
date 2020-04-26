
package net.josephworks.josephcore.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.josephworks.josephcore.item.EmeraldiumItem;
import net.josephworks.josephcore.JosephCoreElements;

@JosephCoreElements.ModElement.Tag
public class EmeraldiumFuelFuel extends JosephCoreElements.ModElement {
	public EmeraldiumFuelFuel(JosephCoreElements instance) {
		super(instance, 17);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(EmeraldiumItem.block, (int) (1)).getItem())
			event.setBurnTime(10240);
	}
}
