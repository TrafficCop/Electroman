import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Splash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Splash extends World
{

    /**
     * Constructor for objects of class Splash.
     * 
     */
    public Splash()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 1024, 1);
        StartButton x = new StartButton();
        addObject(x, 765, 475);
    }
}
