package at.campus02.swd.game.factory;

import at.campus02.swd.game.factory.TileType;
import at.campus02.swd.game.gameobjects.*;

public class IslandBuilder {
    private final int islandWidth;
    private final int islandHeight;
    private final TileType leftTopTileType;
    private final TileType topTileType;
    private final TileType rightTopTileType;
    private final TileType leftBotTileType;
    private final TileType botTileType;
    private final TileType rightBotTileType;

    private final TileFactory tileFactory;

    public IslandBuilder(
        int islandWidth,
        int islandHeight,
        TileType leftTopTileType,
        TileType topTileType,
        TileType rightTopTileType,
        TileType leftBotTileType,
        TileType botTileType,
        TileType rightBotTileType
    ) {
        this.islandWidth = islandWidth;
        this.islandHeight = islandHeight;
        this.leftTopTileType = leftTopTileType;
        this.topTileType = topTileType;
        this.rightTopTileType = rightTopTileType;
        this.leftBotTileType = leftBotTileType;
        this.botTileType = botTileType;
        this.rightBotTileType = rightBotTileType;

        this.tileFactory = new TileFactory();
    }

    public IslandTile createIslandTile(int x, int y) {

        // Erstellen der 3x2 Insel
        //for (int row = 0; row < islandHeight; row++) {
        // for (int col = 0; col < islandWidth; col++) {
        TileType tileType = getTileType(x, y);
        String tilePath = getTilePath(tileType); // Erhalten des Dateipfads basierend auf dem Tile-Typ
        IslandTile islandTile = new IslandTile(tilePath);

        // Bestimmen der Größe des Tiles
                float tileWidth = 48;
                float tileHeight = 48;
                float tileX = 0;
                float tileY = 0;
                if(x == 0 && y == 0)
                {
                    // Setzen der Position des Tiles in der oberen Seite der Insel
                    tileX = tileWidth - tileWidth;
                    tileY = tileHeight;

                }
                else if (x == 0 && y == 1)
                {
                    // Setzen der Position des Tiles in der unteren Seite der Insel
                    tileX = tileWidth;
                    tileY = tileHeight;

                }
                else if (x == 0 && y == 2)
                {
                    // Setzen der Position des Tiles in der unteren Seite der Insel
                    tileX = tileWidth*2;
                    tileY = tileHeight;

                }
                else if (x == 1 && y == 0)
                {
                    // Setzen der Position des Tiles in der unteren Seite der Insel
                    tileX = tileWidth - tileWidth;
                    tileY = tileHeight - tileHeight;

                }
                else if (x == 1 && y == 1)
                {
                    // Setzen der Position des Tiles in der unteren Seite der Insel
                    tileX = tileWidth;
                    tileY = tileHeight - tileHeight;

                }
                else if (x == 1 && y == 2)
                {
                    // Setzen der Position des Tiles in der unteren Seite der Insel
                    tileX = tileWidth*2;
                    tileY = tileHeight - tileHeight;

                }

                islandTile.setPosition(tileX + tileWidth*4, tileY + tileHeight*4);
                //islandTile.addTile(islandTile);
           // }
        //}

        return islandTile; // Rückgabe der erstellten Insel
    }

    private TileType getTileType(int row, int col) {
        if (row == 0 && col == 0) {
            return leftTopTileType;
        } else if (row == 0 && col == islandWidth - 1) {
            return rightTopTileType;
        } else if (row == islandHeight - 1 && col == 0) {
            return leftBotTileType;
        } else if (row == islandHeight - 1 && col == islandWidth - 1) {
            return rightBotTileType;
        } else if (row == 0) {
            return topTileType;
        } else if (row == islandHeight - 1) {
            return botTileType;
        } else {
            return TileType.WATER; // Default Tile-Typ für das Innere der Insel
        }
    }

    private String getTilePath(TileType tileType) {
        switch (tileType) {
            case LEFT_TOP:
                return "tiles/tropical/Terrain/Desertwater/Desertwaterlefttop1.png";
            case TOP:
                return "tiles/tropical/Terrain/Desertwater/Desertwatertop1.png";
            case RIGHT_TOP:
                return "tiles/tropical/Terrain/Desertwater/Desertwaterrighttop1.png";
            case LEFT_BOTTOM:
                return "tiles/tropical/Terrain/Desertwater/Desertwaterleftbot1.png";
            case BOTTOM:
                return "tiles/tropical/Terrain/Desertwater/Desertwaterbot1.png";
            case RIGHT_BOTTOM:
                return "tiles/tropical/Terrain/Desertwater/Desertwaterrightbot1.png";
            case RIGHT:
                return "tiles/tropical/Terrain/Desertwater/Desertwaterright1.png";
            case LEFT:
                return "tiles/tropical/Terrain/Desertwater/Desertwaterleft1.png";
            case MIDDLE:
                return "tiles/tropical/Terrain/Desertwater/Desertwatermiddle1.png";
            default:
                return "tiles/tropical/Terrain/DeepWater/Deepwater/Watermiddle4.png"; // Pfad für den Standard-Tile-Typ (z. B. Wasser)
        }


    }


}