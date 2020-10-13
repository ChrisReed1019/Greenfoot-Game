import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * World object.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static ArrayList<TileWorld> chunkWorld = new ArrayList<TileWorld>(); //all of the world tiles in an array
    public static ArrayList<Conveyor> conveyorArray = new ArrayList<Conveyor>();
    public static Player player = new Player(); // static object of the player
    public static int loadedChunk = 0; // the chunk currently loaded in the world
    public static Score scoreBoard = new Score("Rocks: 0");
    public static String defaultConveyorDirection = "East";
    public static Label mousePos = new Label("", 16);
    public static boolean showMousePos = true;
    
    public MyWorld()
    {    
        super(500, 500, 1);
        setPaintOrder(Label.class, Score.class, Item.class, Player.class, Conveyor.class, Tile.class);
        int i = 0; //index of first chunk insert
        TileWorld chunk1 = new TileWorld(0, 0); // the first chunk is at 0, 0
        chunk1.genWorld(); // generates the chunk's tiles
        chunk1.id = 0;
        chunkWorld.add(chunk1); // adds the chunk to the world
        genChunk(0, 0); // generates the chunk that is at the location of 0, 0
        player.realX = 25;
        player.realY = 25;
        player.x = 0;
        player.y = 0;
        player.tileWorldX = 0;
        player.tileWorldY = 0;
        addObject(player, 25, 25); // add player to world
        addObject(scoreBoard, 250, 14);
        addObject(mousePos, 250, 480);
        loadedChunk = 0;
    }

    public void act() {
        if(Greenfoot.getMouseInfo() != null && showMousePos) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            mousePos.setValue("(" + mouse.getX() + ", " + mouse.getY() + ")");
        }
    }
    // gets tile from arraylist
    public static int getTile(int x, int y) {
        return y + x * 10;
    }
    // draws an existing chunk to the screen if it exists
    // if the chunk doesn't exist, it creates a new chunk.
    public void genChunk(int x, int y) {
        this.unloadChunk();
        TileWorld currChunk;
        for(int i = 0; i < chunkWorld.size(); i++) {
            currChunk = chunkWorld.get(i);
            if(currChunk.xCoord == x && currChunk.yCoord == y) {
                for(Tile tile : chunkWorld.get(i).chunk) {
                    addObject(tile, tile.realX, tile.realY);
                }
                for(Conveyor conv : conveyorArray) {
                    if(conv.tileWorldId == i) {
                        load(conv, conv.realX, conv.realY);
                    }
                }
                loadedChunk = i;
                return;
            }
        }
        currChunk = new TileWorld(x, y);
        currChunk.genWorld();
        chunkWorld.add(currChunk);
        currChunk.id = chunkWorld.size() - 1;
        for(Tile tile : currChunk.chunk) {
            addObject(tile, tile.realX, tile.realY);
        }
        loadedChunk = chunkWorld.size() - 1;
    }
    // generates chunk but does not load it in
    public void genItemChunk(int x, int y) {
        TileWorld currChunk = new TileWorld(x, y);
        currChunk.genWorld();
        chunkWorld.add(currChunk);
        currChunk.id = chunkWorld.size() - 1;
    }
    //unloads all of the current tiles.
    public void unloadChunk() {
        List<Tile> chunk = getObjects(Tile.class);
        removeObjects(chunk);
        List<Conveyor> conveyors = getObjects(Conveyor.class);
        removeObjects(conveyors);
    }
    
    public void load(Actor obj, int xCoord, int yCoord) {
        addObject(obj, xCoord, yCoord);
    }

    public void addConveyor(Conveyor conv) {
        conveyorArray.add(conv);
        chunkWorld.get(MyWorld.loadedChunk).conveyorArray.add(conv);
        load(conv, conv.realX, conv.realY);
    }
}
