import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Crosshair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crosshair extends Actor
{
    /**
     * Act - do whatever the Crosshair wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followmouse();
    }    
    public void followmouse() { MouseInfo follow = Greenfoot.getMouseInfo(); if(follow != null) setLocation ( follow.getX() , follow.getY() ); }
}
