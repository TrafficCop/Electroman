import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class breacher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class breacher extends EnemyProjectiles
{
        GifImage right = new GifImage("Breachinglaser.gif");
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
        delet();
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
public void delet(){
        if((getX() <= 10 || getX()>1010) || (getY() <= 10 || getY() >= 1010))
            getWorld().removeObject(this);
    }
}
