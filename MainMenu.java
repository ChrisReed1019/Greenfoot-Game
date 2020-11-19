import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    public Button start = new Button("startButton.png");
    public Button learn = new Button("learnButton.png");
    public Button playerWhite = new Button("player.png");
    public Button playerBlue = new Button("playerBlue.png");
    public Button playerGold = new Button("playerGold.png");
    public Button playerPurple = new Button("playerPurple.png");
    public Button playerRed = new Button("playerRed.png");
    public Button title = new Button("titleCard.png");
    public String color = "player.png";

    public MainMenu()
    {    
        super(500, 550, 1); 
        addObject(start, 250, 255);
        addObject(learn, 250, 420);
        addObject(title, 250, 110);
        addObject(playerWhite, 80, 340);
        addObject(playerBlue, 165, 340);
        addObject(playerGold, 250, 340);
        addObject(playerPurple, 335, 340);
        addObject(playerRed, 420, 340);
    }
    
    public void act() {
        if(start.clicked) {
            Greenfoot.setWorld(new MyWorld(color));
        }
        if(learn.clicked) {
            Greenfoot.setWorld(new LearnMenu());
        }
        if(playerWhite.clicked) {
            color = "player.png";
        }
        if(playerBlue.clicked) {
            color = "playerBlue.png";
        }
        if(playerGold.clicked) {
            color = "playerGold.png";
        }
        if(playerPurple.clicked) {
            color = "playerPurple.png";
        }
        if(playerRed.clicked) {
            color = "playerRed.png";
        }
    }
}
