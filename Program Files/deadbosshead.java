import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class deadbosshead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class deadbosshead extends Enemies
{
    GifImage dead = new GifImage("deadbosshead.gif");
    int duration = 100;
    /**
     * Act - do whatever the deadbosshead wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(dead.getCurrentImage());
        counter();
        // Add your action code here.
    }    
    public void counter(){
        if(duration>0)
        {
            duration--;
        }
        //Actor player = (Actor)getWorld().getObjects(Player.class).get(0); // gets reference to tank
        if(duration ==0)
        {
            Greenfoot.setWorld(new BossLevel2final(Player.getHealth()));
        }
    }
}
