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
    public String displayText;
    public void act() 
    {
        
    }    
    public Score(String display, int scoreNum) {
        displayText = display;
        score = scoreNum;
        GreenfootImage textDisp = new GreenfootImage(displayText + scoreNum, 20, greenfoot.Color.BLACK, new Color(0, 0, 0, 0));
        setImage(textDisp);
        text = displayText + score;
    }
    public void update() {
        text =  displayText + score;
        if(displayText == "Rocks: ") {
            text += "/20";
        }
        GreenfootImage textDisp = new GreenfootImage(text, 20, null, null);
        setImage(textDisp);
        if (score == 20 && displayText == "Rocks: ") {
            new GreenfootSound("Winner.wav").play();
            MyWorld.reset();
            Greenfoot.setWorld(new MainMenu());
            Greenfoot.stop();
        }
        if (score < 0) {
            score = 0;
        }
        if(score <= 0 && displayText == "Lives: ") {
            MyWorld.reset();
            new GreenfootSound("Loser.wav").play();
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
