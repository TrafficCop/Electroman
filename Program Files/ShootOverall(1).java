import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShootOverall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShootOverall extends AttackManager
{
    /**
     * Act - do whatever the ShootOverall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int shootingSpeed = 18;
    GifImage PBR = new GifImage("PlayerUnstableBullet.gif");
    private int tracktime = 4;
    public void act() 
    {
        counter();
        setImage(PBR.getCurrentImage());
        move(shootingSpeed);
        killEnemies();
        // Add your action code here.
    } 

    public void counter(){
        if(tracktime > 0)
        {
            follow();
            tracktime --;
        }
    }

    public void follow(){
        if (getWorld().getObjects(Crosshair.class).isEmpty()) return; // skips following if the tank is not in world
        Actor cross = (Actor)getWorld().getObjects(Crosshair.class).get(0); // gets reference to tank
        turnTowards(cross.getX(), cross.getY()); // turn toward tank
    }

}
