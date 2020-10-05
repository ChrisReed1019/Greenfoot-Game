import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Conveyor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Conveyor extends Actor
{
    public int x;
    public int y;
    public int realX;
    public int realY;
    public String direction;
    public boolean isPlaced;
    public int tileWorldId;
    public static GifImage conveyorMid = new GifImage("conveyormid.gif");
    
    public Conveyor() {

    }
    public Conveyor(int xCoord, int yCoord, String dir) {
        realX = xCoord;
        realY = yCoord;
        direction = dir;
        isPlaced = false;
        tileWorldId = MyWorld.loadedChunk;
        if(dir == "East") {
            setRotation(0);
        } else if(dir == "South") {
            setRotation(90);
        } else if(dir == "West") {
            setRotation(180);
        } else if(dir == "North") {
            setRotation(270);
        }
    }
    public void act() 
    {
        if(!isPlaced) {
            GreenfootImage image = new GreenfootImage(conveyorMid.getCurrentImage());
            image.setTransparency(40);
            setImage(image);
        } else {
            setImage(conveyorMid.getCurrentImage());
        }
    }    
    public void setFacing(String dir) {
        if(dir == direction) {
            return;
        } else if(dir == "East") {
            setRotation(0);
            direction = "East";
        } else if(dir == "South") {
            setRotation(90);
            direction = "South";
        } else if(dir == "West") {
            setRotation(180);
            direction = "West";
        } else if(dir == "North") {
            setRotation(270);
            direction = "North";
        }
        return;
    }
    public Conveyor getNextConveyor() {
        if(direction == "East") {
            if(x != 9) {
                for(Conveyor conv : MyWorld.conveyorArray) {
                    if(conv.x == x + 1 && conv.y == y && conv.tileWorldId == tileWorldId) {
                        return conv;
                    }
                }
            } else {
                TileWorld tileWorld = MyWorld.chunkWorld.get(tileWorldId);
                boolean found = false;
                for(TileWorld world : MyWorld.chunkWorld) {
                    if(world.xCoord == tileWorld.xCoord + 1 && world.yCoord == tileWorld.yCoord) {
                        for(Conveyor conv : MyWorld.conveyorArray) {
                            if(conv.tileWorldId == world.id && conv.x == 0 && conv.y == y) {
                                return conv;
                            }
                        }
                        found = true;
                    }
                }
            }
        } else if(direction == "South") {
            for(Conveyor conv : MyWorld.conveyorArray) {
                if(conv.x == x && conv.y == y + 1 && conv.tileWorldId == tileWorldId) {
                    return conv;
                }
            }
        } else if(direction == "West") {
            for(Conveyor conv : MyWorld.conveyorArray) {
                if(conv.x == x - 1 && conv.y == y && conv.tileWorldId == tileWorldId) {
                    return conv;
                }
            }
        } else if(direction == "North") {
            for(Conveyor conv : MyWorld.conveyorArray) {
                if(conv.x == x && conv.y == y - 1 && conv.tileWorldId == tileWorldId) {
                    return conv;
                }
            }
        }
        return null;
    }
}
