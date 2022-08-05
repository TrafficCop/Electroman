import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaterFallPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterFallPlatform extends Platform
{
    GifImage platform = new GifImage("Waterfall PLat.gif"); //image is in 640x640 size
    /**
     * Act - do whatever the WaterFallPlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(platform.getCurrentImage());
        // Add your action code here.
    }    
}
