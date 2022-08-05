import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bossbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bossbox extends Enemies
{
    /**
     * Act - do whatever the bossbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        wander();
        //deleteselfifgone();
        // Add your action code here.
    }    
    public void wander(){
        move(30);
        if(Greenfoot.getRandomNumber(100)< 25)
        {
            turn(Greenfoot.getRandomNumber(90)-45);
            
        }
        if(getX() <= 5 || getX()>=getWorld().getWidth()-5)
        {
            turn(180);
        }
        if(getY() <= 5 || getY()>=getWorld().getWidth()-5)
        {
            turn(180);
        }
    }
    public void deleteselfifgone(){
        Actor b = getOneIntersectingObject(FinalBossHead.class);  
        if (b.getWorld() == null)
        getWorld().removeObject(this);
    }
}
