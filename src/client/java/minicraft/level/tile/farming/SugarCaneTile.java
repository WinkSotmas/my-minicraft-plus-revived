package minicraft.level.tile.farming;

import minicraft.gfx.Screen;
import minicraft.gfx.SpriteLinker.LinkedSprite;
import minicraft.gfx.SpriteLinker.SpriteType;
import minicraft.level.Level;
import minicraft.level.tile.Tiles;

public class SugarCaneTile extends CropTile {
	private final LinkedSprite[] spritStages = new LinkedSprite[] {
		new LinkedSprite(SpriteType.Tile, "sugar_cane_stage0"),
		new LinkedSprite(SpriteType.Tile, "sugar_cane_stage1"),
		new LinkedSprite(SpriteType.Tile, "sugar_cane_stage2"),
		new LinkedSprite(SpriteType.Tile, "sugar_cane_stage3"),
		new LinkedSprite(SpriteType.Tile, "sugar_cane_stage4"),
		new LinkedSprite(SpriteType.Tile, "sugar_cane_stage5")
	};

	public SugarCaneTile(String name) {
		super(name, null);
	}

	@Override
    	public void render(Screen screen, Level level, int x, int y) {
        	int age = (level.getData(x, y) >> 3) & maxAge;
        	Tiles.get("Farmland").render(screen, level, x, y);
        	int stage = (int) ((float) age / maxAge * 5);
        	screen.render(x << 4, y << 4, spritStages[stage]);
    }

	
}
