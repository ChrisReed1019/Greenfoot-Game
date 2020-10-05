import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Scoreboard for the player.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public String text;
    public int score;
    public void act() 
    {
        
    }    
    public Score(String str) {
        GreenfootImage textDisp = new GreenfootImage(str, 20, greenfoot.Color.BLACK, new Color(0, 0, 0, 0));
        setImage(textDisp);
        text = str;
    }
    public void update() {
        text = "Rocks: " + score;
        GreenfootImage textDisp = new GreenfootImage(text, 20, null, null);
        setImage(textDisp);
    }
}
