import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BigBois here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigBois extends EnemyProjectiles
{
    GifImage an = new GifImage("BulletLeft clone.gif");
    /**
     * Act - do whatever the BigBois wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(an.getCurrentImage());
        delet();
        move(35);
        
        // Add your action code here.
    }    

    public void delet(){
        if((getX() <= 10 || getX()>1010) || (getY() <= 10 || getY() >= 1010))
            getWorld().removeObject(this);
    }
}
