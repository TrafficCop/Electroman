import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossBody here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossBody extends Enemies
{
    GifImage right = new GifImage("FinalBossBody.gif");
    /**
     * Act - do whatever the BossBody wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(right.getCurrentImage());
        // Add your action code here.
    }    
}
