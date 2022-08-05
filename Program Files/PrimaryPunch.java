import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBossPunch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrimaryPunch extends Enemies
{
    private int charge = 0;
    private int stunned = 0;
    private int locktime = 10;
    private int wait = 5;
    /**
     * Act - do whatever the FinalBossPunch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timer();
        face();
        collision();
        // Add your action code here.
    }    

    public void face(){
        if (getWorld().getObjects(Player.class).isEmpty()) return;
        Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
        if(locktime>0 && stunned ==0){
            turnTowards(player.getX(), player.getY());
            wait = 5;
        }
        else
        {
            if(stunned == 0 && wait ==0){
                charge =22;
                smash();
            }
        }
    }

    public void smash(){
        if(locktime == 0 && stunned == 0 && charge >0){
            move(50);
        }
    }

    public void timer(){
        if(wait > 0)
            wait --;
        if(stunned>0)
        {
            stunned--;
        }
        if(charge>0)
        {
            charge--;
        }
        if(locktime>0)
            locktime--;
        if(charge == 0 && locktime == 0 && stunned >0 ){
            charge = 0;
            locktime = 10;
        }
    }

    public void collision(){
        if(stunned==0)
        {if(getX()==0){
                move(50);
                stunned=30;
            }
            if(getX()>1010){
                move(-50);
                stunned=30;
            }
        }
    }
}
