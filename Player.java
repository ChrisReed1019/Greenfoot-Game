import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Class for the player character.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int x;
    public int y;
    public int realX;
    public int realY;
    public int tileWorldX;
    public int tileWorldY;
    public String key;
    public Boolean isSetting = false;
    public Boolean inMenu = false;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // attempted input lag optimization
        key = Greenfoot.getKey();
        if(key != null) {
            checkMove();
        }
    }    
    public Player() {
        setImage(new GreenfootImage("player.png"));
    }

    // checks for singular movements from keyboard
    public void checkMove() {
        //check for singular movements from keyboard
        if(!isSetting && !inMenu) {
            if("w".equals(key)) {
                if(y != 0) {
                    realY -= 50;
                    y -= 1;
                } else {
                    ((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord + 1);
                    y = 9;
                    realY = 475;
                    tileWorldY++;
                }
                setLocation(realX, realY);
            } else if("a".equals(key)) {
                if(x != 0) {
                    realX -= 50;
                    x -= 1;
                } else {
                    ((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord - 1, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord);
                    x = 9;
                    realX = 475;
                    tileWorldX--;
                }
                setLocation(realX, realY);
            } else if("s".equals(key)) {
                if(y != 9) {
                    realY += 50;
                    y += 1;
                } else {
                    ((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord - 1);
                    y = 0;
                    realY = 25;
                    tileWorldY--;
                }
                setLocation(realX, realY);
            } else if("d".equals(key)) {
                if(x != 9) {
                    realX += 50;
                    x += 1;
                } else {
                    ((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord + 1, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord);
                    x = 0;
                    realX = 25;
                    tileWorldX++;
                }
                setLocation(realX, realY);
            } else if("e".equals(key)) {
                Tile currTile = getCurrentTile();
                if(currTile.type == "rock") {
                    currTile.setImage("grass" + Greenfoot.getRandomNumber(5) + ".png");
                    currTile.type = "grass";
                    MyWorld.scoreBoard.score++;
                    MyWorld.scoreBoard.update();
                }
                else if (currTile.type == "hut"){
                    currTile.setImage("grass" + Greenfoot.getRandomNumber(5) + ".png");
                    currTile.type = "grass";
                    MyWorld.scoreBoard.score=0;
                    MyWorld.scoreBoard.update();
                } else if (currTile.type == "obsidian") {
                    
                }
            } /* else if("c".equals(key)) {
                boolean found = false;
                for(Conveyor conveyorB : MyWorld.conveyorArray) {
                    if(conveyorB.x == x && conveyorB.y == y) {
                       found = true;
                       break; 
                    }
                }
                if(!found) {
                    Conveyor conveyor = new Conveyor(realX, realY, MyWorld.defaultConveyorDirection);
                    ((MyWorld)getWorld()).addConveyor(conveyor);
                    isSetting = true;
                }
            } */ /*else if("i".equals(key) &&  MyWorld.scoreBoard.score>=1) {
                Conveyor currConveyor = null;
                MyWorld.scoreBoard.score--;
                MyWorld.scoreBoard.update();
                for(Conveyor conv : MyWorld.conveyorArray) {
                    System.out.println(MyWorld.conveyorArray.indexOf(conv));
                    if(getX() == conv.getX() && getY() == conv.getY() && MyWorld.loadedChunk == conv.tileWorldId) {
                        currConveyor = conv;
                    }
                }
                Item item = new Item(currConveyor, MyWorld.loadedChunk, getX(), getY());
                ((MyWorld)getWorld()).load(item, getX(), getY());
            } */
        } else if(isSetting) {
            Conveyor current = MyWorld.conveyorArray.get(MyWorld.conveyorArray.size() - 1);
            if("c".equals(key)) {
                MyWorld.defaultConveyorDirection = current.direction;
                current.x = x;
                current.y = y;
                current.isPlaced = true;
                isSetting = false;
                List<Item> items = ((MyWorld)getWorld()).getObjects(Item.class);
                for(Item item : items) {
                    if(item.conv == null) {
                        if(item.getX() == getX() && item.getY() == getY() && item.chunk == MyWorld.loadedChunk) {
                            item.conv = current;
                        }
                    }
                }
            } else if("r".equals(key)) {
                if(current.direction == "North") {
                    current.setFacing("East");
                } else if(current.direction == "East") {
                    current.setFacing("South");
                } else if(current.direction == "South") {
                    current.setFacing("West");
                } else if(current.direction == "West") {
                    current.setFacing("North");
                }
            }
        } else if (inMenu) {
            
        }
    }
    //returns the current tile the player is standing on.
    public Tile getCurrentTile() {
        return MyWorld.chunkWorld.get(MyWorld.loadedChunk).chunk.get(MyWorld.getTile(x, y));
    }
}
