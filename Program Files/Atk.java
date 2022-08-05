import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Atk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Atk extends Actor
{
    
    private Player player;
    public Atk(Player player){
        this.player=player;
    }
    int frame = 0;
    GifImage nostop = new GifImage("nostop.gif");
    public boolean touch = false;

    /**
     * Act - do whatever the Atk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
           //setImage(nostop.getCurrentImage());
           int playerX = player.getX();
           int playerY = player.getY();
           int xOffset = 0;
           int yOffset = -30;
           int x = playerX+xOffset;
           int y = playerY+yOffset;
           setLocation (x,y);
        // Add your action code here.
    }    
}
