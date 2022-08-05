import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PointerL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PointerL extends EnemyProjectiles
{
    GifImage an = new GifImage("Lazar.gif");
    /**
     * Act - do whatever the PointerL wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(an.getCurrentImage());
        delet();
        move(45);
        // Add your action code here.
    }   
    public void delet(){
        if((getX() <= 10 || getX()>1010) || (getY() <= 10 || getY() >= 1010))
            getWorld().removeObject(this);
    }
}
