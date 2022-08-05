import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{

    /**
     * Constructor for objects of class End.
     * 
     */
    public End(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 1024, 1); 
        Player John = new Player();
        addObject(John, 100 , 200);
        Crosshair cross = new Crosshair();
        addObject(cross,100,200);

    }
}
