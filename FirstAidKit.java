import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FirstAidKit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstAidKit extends Actor
{
    /**
     * Act - do whatever the FirstAidKit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int x;
    public int y;
    public int tileWorldX;
    public int tileWorldY;
    public int healAmount = 1;
    public boolean inChunk;
    public GreenfootImage image = new GreenfootImage("firstaid.png");
    public FirstAidKit(int xCoord, int yCoord, int tileX, int tileY) {
        x = xCoord;
        y = yCoord;
        tileWorldX = tileX;
        tileWorldY = tileY;
        setImage(image);
    }
    public void act() 
    {
        inChunk = tileWorldX == MyWorld.player.tileWorldX && tileWorldY == MyWorld.player.tileWorldY;
        if(inChunk) {
            image.setTransparency(255);
        } else {
            image.setTransparency(0);
        }
        if(MyWorld.player.tileWorldX == tileWorldX && MyWorld.player.tileWorldY == tileWorldY && MyWorld.player.x == x && MyWorld.player.y == y) {
            MyWorld.lives += healAmount;
            MyWorld.livesCounter.score += healAmount;
            MyWorld.livesCounter.update();
            ((MyWorld)getWorld()).removeObject(this);
        }
    }    
}
