import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends Actor
{
    /**
     * Act - do whatever the Item wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Conveyor conv;
    public Conveyor prevConv;
    public int x;
    public int y;
    public int tileWorldX;
    public int tileWorldY;
    public int chunk;
    public GreenfootImage image = new GreenfootImage("item.png");
    public int moveSpeed = 3; // larger = slower
    public int tick = 0;
    public Item(Conveyor currConv, int currChunk, int xCoord, int yCoord) {
        conv = currConv;
        x = xCoord;
        y = yCoord;
        chunk = currChunk;
        setImage(image);
    }
    public void act()
    {
        checkEdge();
        move();
        checkConveyor();
        //check if object is in current chunk
        if(chunk == MyWorld.loadedChunk) {
            image.setTransparency(255);
        } else {
            image.setTransparency(0);
        }

        if(conv == null) {
            for(Conveyor conveyor : MyWorld.conveyorArray) {
                if(getX() == conveyor.x && getY() == conveyor.y && chunk == conveyor.tileWorldId) {
                    conv = conveyor;
                }
            }
        }
        tick++;
    }
    
    public void checkConveyor() {
        if(conv != null) {
            if((x % 25 == 0 && x % 50 != 0 && (conv.direction == "East" || conv.direction == "West")) || (y % 25 == 0 && y % 50 != 0 && ((conv.direction == "North" || conv.direction == "South")))) {
                conv = conv.getNextConveyor();
                move();
            }
        }
    }
    
    public void move() {
        if(tick % moveSpeed == 0 && conv != null) {
            if(conv.direction == "North") {
                y -= 1;
            } else if(conv.direction == "East") {
                x += 1;
            } else if(conv.direction == "South") {
                y += 1;
            } else if(conv.direction == "West") {
                x -= 1;
            }
        }
        setLocation(x, y);
    }
    
    public void checkEdge() {
        if(getX() == 499) {
            TileWorld currChunk = MyWorld.chunkWorld.get(chunk);
            for(TileWorld world : MyWorld.chunkWorld) {
                if(currChunk.xCoord == world.xCoord + 1 && currChunk.yCoord == world.yCoord) {
                    x = 1;
                    chunk = MyWorld.chunkWorld.indexOf(world);
                    setLocation(x, y);
                    return;
                }
            }
            ((MyWorld)getWorld()).genItemChunk(currChunk.xCoord + 1, currChunk.yCoord);
            x = 1;
            chunk = MyWorld.chunkWorld.size() - 1;
            setLocation(x, y);
        }
        /*
        if(getX() == 0) {
            TileWorld currChunk = MyWorld.chunkWorld.get(chunk);
            for(TileWorld world : MyWorld.chunkWorld) {
                if(currChunk.xCoord == world.xCoord - 1 && currChunk.yCoord == world.yCoord) {
                    x = 500;
                    chunk = MyWorld.chunkWorld.indexOf(world);
                    setLocation(x, y);
                    return;
                }
            }
            ((MyWorld)getWorld()).genItemChunk(currChunk.xCoord - 1, currChunk.yCoord);
            x = 500;
            chunk = MyWorld.chunkWorld.size() - 1;
            setLocation(x, y);
        }
        if(getY() == 499) {
            TileWorld currChunk = MyWorld.chunkWorld.get(chunk);
            for(TileWorld world : MyWorld.chunkWorld) {
                if(currChunk.xCoord == world.xCoord && currChunk.yCoord == world.yCoord - 1) {
                    y = 0;
                    chunk = MyWorld.chunkWorld.indexOf(world);
                    setLocation(x, y);
                    return;
                }
            }
            ((MyWorld)getWorld()).genItemChunk(currChunk.xCoord, currChunk.yCoord - 1);
            y = 0;
            chunk = MyWorld.chunkWorld.size() - 1;
            setLocation(x, y);
        }
        if(getY() == 0) {
            TileWorld currChunk = MyWorld.chunkWorld.get(chunk);
            for(TileWorld world : MyWorld.chunkWorld) {
                if(currChunk.xCoord == world.xCoord && currChunk.yCoord == world.yCoord + 1) {
                    y = 500;
                    chunk = MyWorld.chunkWorld.indexOf(world);
                    setLocation(x, y);
                    return;
                }
            }
            ((MyWorld)getWorld()).genItemChunk(currChunk.xCoord, currChunk.yCoord + 1);
            y = 500;
            chunk = MyWorld.chunkWorld.size() - 1;
            setLocation(x, y);
        }
        */
    }
}
