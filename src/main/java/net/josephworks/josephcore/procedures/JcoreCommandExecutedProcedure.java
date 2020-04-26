package net.josephworks.josephcore.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.Entity;

import net.josephworks.josephcore.gui.MainGuiGui;
import net.josephworks.josephcore.JosephCoreVariables;
import net.josephworks.josephcore.JosephCoreElements;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

@JosephCoreElements.ModElement.Tag
public class JcoreCommandExecutedProcedure extends JosephCoreElements.ModElement {
	public JcoreCommandExecutedProcedure(JosephCoreElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure JcoreCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure JcoreCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure JcoreCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure JcoreCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure JcoreCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure JcoreCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		World world = (World) dependencies.get("world");
		double cligui = 0;
		cligui = (double) 1;
		if (((cligui) == 1)) {
			if (entity instanceof PlayerEntity && !world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						(("JosephCore Help\n") + "" + ("/jcore - shows this text\n") + "" + ("/jcore help - shows this text\n") + ""
								+ ("/jcore version - reports jcore version\n") + "" + ("/jcore cheats - shows cheat commands\n") + "" + (""))),
						(false));
			}
		}
		if (((cligui) == 2)) {
			if (entity instanceof ServerPlayerEntity)
				NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("MainGui");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new MainGuiGui.GuiContainerMod(id, inventory,
								new PacketBuffer(Unpooled.buffer()).writeBlockPos(new BlockPos(x, y, z)));
					}
				}, new BlockPos(x, y, z));
		}
		/*---CLI Starts Here---*/if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("help"))) {
			if (entity instanceof PlayerEntity && !world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent((("JosephCore Help") + "" + ("/jcore - shows this text") + "" + ("/jcore help - shows this text") + ""
								+ ("/jcore version - reports jcore version") + "" + ("/jcore cheats - shows cheat commands") + "" + (""))),
						(false));
			}
		}
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("version"))) {
			if (entity instanceof PlayerEntity && !world.isRemote) {
				((PlayerEntity) entity)
						.sendStatusMessage(new StringTextComponent((("JosephCore is running ") + "" + ((JosephCoreVariables.version)))), (false));
			}
		}
		/*---CHEATS---*/if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("cheats"))) {
			if (entity instanceof PlayerEntity && !world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						(("JosephCore Help - Cheats") + "" + ("/jcore cheats - shows this text") + "" + ("/jcore cheat - shows this text") + ""
								+ ("/jcore cheat xp - spawns in 200XP at your location") + "" + ("") + "" + (""))),
						(false));
			}
		}
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("cheat"))) {
			if (entity instanceof PlayerEntity && !world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						(("JosephCore Help - Cheats") + "" + ("/jcore cheats - shows this text") + "" + ("/jcore cheat - shows this text") + ""
								+ ("/jcore cheat xp - spawns in 200XP at your location") + "" + ("") + "" + (""))),
						(false));
			}
		}
		if (((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("cheat")) && (((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("2");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("xp")))) {
			for (int index0 = 0; index0 < (int) (Math.round((y / 2))); index0++) {
				if (!world.isRemote) {
					world.addEntity(new ExperienceOrbEntity(world, x, y, z, (int) 200));
				}
				if (entity instanceof PlayerEntity && !world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("JCore - Spawned 200XP"))), (true));
				}
			}
		}
	}
}
