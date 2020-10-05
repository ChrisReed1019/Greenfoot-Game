import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    public int x;
    public int y;
    public int realX;
    public int realY;
    public int index;
    public String type;

    public Tile(String img, String tileType) {
        setImage(new GreenfootImage(img));
        type = tileType;
    }

    public void act() 
    {
        
    }
    
    public void changeImage(String img) {
        setImage(new GreenfootImage(img));
    }
}
