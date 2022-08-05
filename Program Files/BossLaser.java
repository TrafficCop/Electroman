import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossLaser extends EnemyProjectiles
{
    GifImage right = new GifImage("BossLazer.gif");
    int check = 1;
    boolean up = false;
    boolean down = false;
    /**
     * Act - do whatever the BossLaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(right.getCurrentImage());
        attack();
        killEnemies();
        // Add your action code here.
    }    
    public void attack(){
        if (getWorld().getObjects(Player.class).isEmpty()) return;
        Actor Player = (Actor)getWorld().getObjects(Player.class).get(0);
            if(check>0){
              turnTowards(Player.getX(), Player.getY()); // turn toward tank
            // if(Player.getY()<this.getY()){
                // up = true;
                // setLocation(getX(), getY()-30);
            // }
            // if(Player.getY()>this.getY()){
                // down = true;
                // setLocation(getX(), getY()+30);
            // }
            check--;
        }
        if(down == true)
        setLocation(getX() - 30, getY()+30); 
        if(up == true)
        setLocation(getX() - 30, getY()-30); 
        if(!up == true && !down == true){
            move(30); 
        }
        }
    }
