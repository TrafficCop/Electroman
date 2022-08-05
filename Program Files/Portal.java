import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Drops
{
    GifImage heart = new GifImage("Win.gif");
    /**
     * Act - do whatever the Boss1Drop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(heart.getCurrentImage());
        changeLevels();
        // Add your action code here.
    }    
    public void changeLevels(){
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth);
        Actor P = getOneObjectAtOffset(xDistance, 0,Player.class);
        
        if(P!=null)//isTouching(Platform.class))
        {
            Greenfoot.setWorld(new End(Player.getHealth()));
            
        }
    }
}
