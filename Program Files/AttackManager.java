import greenfoot.*;

public class AttackManager extends Actor
{
    int score2 = 0;
    
    public void act() 
    {
        killEnemies();
    }    
    
    public void remove()
    {
       Actor walls = getOneIntersectingObject(Platform.class);
       if(getX() <=1 || getX() >= getWorld().getWidth() -1)
       {
           getWorld().removeObject(this);
        }
        else if(walls != null)
        {
            getWorld().removeObject(this);
        }
    }
    
    public boolean amIshot(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0,0, clss);
        return actor !=null;
    }
    
    public void kill(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0,0, clss);
        if(actor != null)
        {
            getWorld().removeObject(actor);
            score2 = score2 + 10;
        }
    }
    
    public void killEnemies()
    {
        if(amIshot(Enemies.class))
        {
            //kill(Enemies.class);
            //getWorld().removeObject(this);
        }
        else
        {
            remove();
        }
    }
    
    // /**
     // * Holds the score variable to be called by the Scores class for display.
     // */
    // public int getScore()
    // {    
        // return score2;
    // }  
}