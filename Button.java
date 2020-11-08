import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    public GreenfootImage image;
    public boolean clicked = false;
    
    public Button(String imageName) {
        image = new GreenfootImage(imageName);
        setImage(image);
    }
    
    public void act() 
    {
        clicked = Greenfoot.mouseClicked(this);
    }
}
