import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LearnMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LearnMenu extends World
{

    /**
     * Constructor for objects of class LearnMenu.
     * 
     */
    public Button metamorphic = new Button("metamorphic.png");
    public Button sedimentary = new Button("sedimentary.png");
    public Button igneous = new Button("igneous.png");
    public Button exit = new Button("exit.png");
    public Label name = new Label("", 24);
    public Label desc = new Label("", 18);
    public String metamorphicDesc = "";
    public String sedimentaryDesc = "";
    public String igneousDesc = "";
    public LearnMenu()
    {    
        super(500, 550, 1); 
        addObject(metamorphic, 60, 160);
        addObject(sedimentary, 60, 240);
        addObject(igneous, 60, 320);
        addObject(exit, 440, 60);
        name.setFillColor(Color.BLACK);
        name.setLineColor(null);
        desc.setFillColor(Color.BLACK);
        desc.setLineColor(null);
        addObject(name, 155, 60);
        addObject(desc, 120, 120);
    }

    public void act() {
        if(metamorphic.clicked) {
            name.setValue("Metamorphic");
            desc.setValue(metamorphicDesc);
        }
        if(sedimentary.clicked) {
            name.setValue("Sedimentary");
            desc.setValue(sedimentaryDesc);
        }
        if(metamorphic.clicked) {
            name.setValue("Igneous");
            desc.setValue(igneousDesc);
        }
        if(exit.clicked) {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
