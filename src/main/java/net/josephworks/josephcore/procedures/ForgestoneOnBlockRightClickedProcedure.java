package net.josephworks.josephcore.procedures;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.josephworks.josephcore.JosephCoreVariables;
import net.josephworks.josephcore.JosephCoreElements;

@JosephCoreElements.ModElement.Tag
public class ForgestoneOnBlockRightClickedProcedure extends JosephCoreElements.ModElement {
	public ForgestoneOnBlockRightClickedProcedure(JosephCoreElements instance) {
		super(instance, 23);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ForgestoneOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ForgestoneOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ForgestoneOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ForgestoneOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ForgestoneOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double random = 0;
		String say = "";
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
			if (entity instanceof PlayerEntity && !world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("You must be in survival mode to do this!"))), (true));
			}
		} else {
			random = (double) (Math.random() * 3);
			JosephCoreVariables.WorldVariables
					.get(world).FSRightClicked = (double) ((JosephCoreVariables.WorldVariables.get(world).FSRightClicked) + 1);
			JosephCoreVariables.WorldVariables.get(world).syncData(world);
			if (((JosephCoreVariables.WorldVariables.get(world).FSRandom) == 0)) {
				JosephCoreVariables.WorldVariables.get(world).FSRandom = (double) (Math.random() * 5);
				JosephCoreVariables.WorldVariables.get(world).syncData(world);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				if (((JosephCoreVariables.WorldVariables.get(world).FSRightClicked) == (JosephCoreVariables.WorldVariables.get(world).FSRandom))) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
					if (((random) == 1)) {
						say = (String) "Nice! ";
					}
					if (((random) == 2)) {
						say = (String) "Wow! ";
					}
					if (((random) == 3)) {
						say = (String) "Cool! ";
					}
					if (entity instanceof PlayerEntity && !world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((((say)) + "" + ("It only took ") + ""
								+ ((JosephCoreVariables.WorldVariables.get(world).FSRightClicked)) + "" + (" tries!"))), (true));
					}
					JosephCoreVariables.WorldVariables.get(world).FSRightClicked = (double) 0;
					JosephCoreVariables.WorldVariables.get(world).syncData(world);
					random = (double) 0;
				}
			}
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 2);
		}
	}
}
