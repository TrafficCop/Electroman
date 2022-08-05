import greenfoot.*;

public class ShootRight extends AttackManager
{
    private int shootingSpeed = 4;
    GifImage BR = new GifImage("BulletRight.gif");
    public void act() 
    {
        setImage(BR.getCurrentImage());
        setLocation(getX() + shootingSpeed, getY());
        killEnemies();
    }    
}