import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Manbearpig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Manbearpig extends Actor
{
    /**
     * Act - do whatever the Manbearpig wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int x;
    public int y;
    public int tick = 0;
    public int realX = 475;
    public int realY = 475;
    public int tileWorldX = 0;
    public int tileWorldY = 0;
    public GreenfootImage image = new GreenfootImage("manbearpig.png");
    public Manbearpig() {
        setImage(image);
        x = 9;
        y = 9;
    }
    
    public void act() 
    {
        if(tileWorldX == MyWorld.player.tileWorldX && tileWorldY == MyWorld.player.tileWorldY) {
            image.setTransparency(255);
        } else {
            image.setTransparency(0);
            if(tick % 100 == 0) {
                left();
            }
        }
        tick++;
    }
    
    public void up() {
        if(y != 0) {
            realY -= 50;
            y -= 1;
        } else {
            //((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord + 1);
            y = 9;
            realY = 475;
            tileWorldY++;
        }
        setLocation(realX, realY);
    }
    
    public void down() {
        if(y != 9) {
            realY += 50;
            y += 1;
        } else {
            //((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord - 1);
            y = 0;
            realY = 25;
            tileWorldY--;
        }
        setLocation(realX, realY);
    }
    
    public void left() {
        if(x != 0) {
            realX -= 50;
            x -= 1;
        } else {
            //((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord - 1, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord);
            x = 9;
            realX = 475;
            tileWorldX--;
        }
        setLocation(realX, realY);
    }
    
    public void right() {
        if(x != 9) {
            realX += 50;
            x += 1;
        } else {
            //((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord + 1, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord);
            x = 0;
            realX = 25;
            tileWorldX++;
        }
        setLocation(realX, realY);
    }
    
}
