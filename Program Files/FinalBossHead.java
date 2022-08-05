import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBossHead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBossHead extends Enemies
{
    GifImage fbh = new GifImage("FinalRoboss2.gif");
    private bossbox z;

    public FinalBossHead(bossbox z){
        this.z=z;
    }
    double health = 100;
    /**
     * Act - do whatever the FinalBossHead wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        delete();
        hitDetection();
        setImage(fbh.getCurrentImage());
        followbox();

        // Add your action code here.
    }    

    public void followbox(){
        int playerX = z.getX();
        int playerY = z.getY();
        int x = playerX;
        int y = playerY;
        setLocation (x,y);
    }

    public void delete(){ 
        Portal portal = new Portal();
        if(health<=0){
            getWorld().addObject(portal, getX(), getY());
            getWorld().removeObject(this);
        }
    }

    public void hitDetection(){
        if (getWorld() == null) return;
        Actor b = getOneIntersectingObject(ShootOverall.class);  
        if(b != null)  
        {  
            getWorld().removeObject(b);
            health-=10;
        }  
    }

}
