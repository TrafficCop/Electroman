import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Worlddd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends World
{
    //private Atk a = new Atk();
    /**
     * Constructor for objects of class Worlddd.
     * 
     */
    public World1()
    {    
        super(1024, 1024, 1); 
        Greenfoot.setSpeed(45);

        //Platforms
        // Platform WTF = new WaterFallPlatform();
        // addObject(WTF, 200 , 500);
        // Platform GP = new GenericPlatform();
        // addObject(GP, 500 , 450);

        //Player
        Player John = new Player();
        addObject(John, 100 , 200);
        RoboEnemy Roboss = new RoboEnemy();
        addObject(Roboss, 500, 800);
        Crosshair cross = new Crosshair();
        addObject(cross,100,200);
        barrierw1 w = new barrierw1();
        addObject(w, 512,590);
        w.setRotation(90);
        barrierw1 l = new barrierw1();
        addObject(l, 512,390);
        l.setRotation(90);
        barrierw1 a = new barrierw1();
        addObject(a, 420,480);
        barrierw1 b = new barrierw1();
        addObject(b, 603,480);
    }
}
