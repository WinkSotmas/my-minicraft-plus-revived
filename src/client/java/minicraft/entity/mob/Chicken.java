package minicraft.entity.mob;

import minicraft.core.io.Settings;
import minicraft.gfx.SpriteLinker.LinkedSprite;
import minicraft.item.Items;
import minicraft.level.tile.GrassTile;
import minicraft.level.tile.Tile;
import minicraft.level.tile.Tiles;

public class Chicken extends PassiveMob {
	private static final LinkedSprite[][] sprites = Mob.compileMobSpriteAnimations(0, 0, "chicken");

	/**
	 * Creates a chicken.
	 */
	public Chicken() {
		super(sprites, 3);
	}

	@Override
	public void die() {
		int min = 0, max = 0;
		if (Settings.get("diff").equals("minicraft.settings.difficulty.easy")) {
			min = 1;
			max = 3;
		}
		if (Settings.get("diff").equals("minicraft.settings.difficulty.normal")) {
			min = 1;
			max = 2;
		}
		if (Settings.get("diff").equals("minicraft.settings.difficulty.hard")) {
			min = 0;
			max = 1;
		}

		// Chickens currently do not have a dedicated drop item defined in the game,
		// so they simply fall through to their normal death behavior.
		super.die();
	}
}
