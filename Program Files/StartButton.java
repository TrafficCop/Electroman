import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    int up = 20;
    int down = 0;
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setRotation(90);
        clicked();
        am();
        // Add your action code here.
    }    
    public void am(){
        if(up >0 ){
        move(1);
        up--;
        down++;
    }
        if(down >0 && up ==0 ){
        move(-1);
        down--;
    }
        if(down == 0 && up == 0)
        up = 20;
    }
    public void clicked(){
        MouseInfo left = Greenfoot.getMouseInfo();

        if(left!=null)
            if (Greenfoot.mouseClicked(this)) {
                Greenfoot.setWorld(new World1());
            }
    }
}
