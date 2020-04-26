
package net.josephworks.josephcore.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.josephworks.josephcore.block.ForgestoneBlock;
import net.josephworks.josephcore.JosephCoreElements;

@JosephCoreElements.ModElement.Tag
public class ForgestoneFuelFuel extends JosephCoreElements.ModElement {
	public ForgestoneFuelFuel(JosephCoreElements instance) {
		super(instance, 22);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(ForgestoneBlock.block, (int) (1)).getItem())
			event.setBurnTime(5120);
	}
}
