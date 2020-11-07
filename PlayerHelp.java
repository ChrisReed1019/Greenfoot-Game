import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerHelp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerHelp extends Actor
{
    /**
     * Act - do whatever the PlayerHelp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GreenfootImage helpImage = new GreenfootImage("help.png");
    
    public PlayerHelp() {
        setImage(helpImage);
        helpImage.setTransparency(0);
    }
    
    public void act() 
    {
        
    }    
}
