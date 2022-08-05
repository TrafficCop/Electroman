import greenfoot.*;

public class ShootLeft extends AttackManager
{
    private int shootingSpeed = 4;
    GifImage BL = new GifImage("BulletLeft.gif");
    public void act() 
    {
        setImage(BL.getCurrentImage());
        setLocation(getX() - shootingSpeed, getY());
        killEnemies();
    }    
}