import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QuestionMark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuestionMark extends Actor
{
    /**
     * Act - do whatever the QuestionMark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GreenfootImage image = new GreenfootImage("question.png");
    
    public QuestionMark() {
        setImage(image);
    }

    public void act() 
    {
        if (Greenfoot.mouseMoved(this)) {
            MyWorld.help.helpImage.setTransparency(255);
            MyWorld.player.stopped = true;
            MyWorld.enemy.stopped = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            MyWorld.help.helpImage.setTransparency(0);
            MyWorld.player.stopped = false;
            MyWorld.enemy.stopped = false;
        }
    }    
}
