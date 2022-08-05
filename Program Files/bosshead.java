import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bosshead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bosshead extends Enemies
{
    private BossBody body;

    public bosshead(BossBody body){
        this.body=body;
    }
    GifImage right = new GifImage("bosshead.gif");
    double attackValue = 0;
    int RandomAttackCounter =  30;
    int hitCounter = 0;
    int shoot = 0;
    int health = 100;
    /**
     * Act - do whatever the bosshead wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        setImage(right.getCurrentImage());
        appendtobody();
        headtrack();
        countermanager();
        health = contactsideRight();
        deleteifDead();
        // Add your action code here.
    }    

    public void headtrack(){
        Actor Player = (Actor)getWorld().getObjects(Player.class).get(0);
        turnTowards(Player.getX(), Player.getY());
    }

    public void countermanager(){
        if (getWorld().getObjects(Player.class).isEmpty()) return;
        if(hitCounter>0)
            hitCounter--;
        if(RandomAttackCounter>0){
            RandomAttackCounter--;
        }
        if(shoot>20){
            shoot();
            shoot--;}
        if(RandomAttackCounter<=0){
            attackValue=Math.random()*2;
            if(attackValue>1){
                shoot = 20;
                shoot();
            }
            if(attackValue<1){
                shoot = 20;
                breachlaser();
            }
            RandomAttackCounter = 30;
        }
    }

    public void appendtobody(){
        int playerX = body.getX();
        int playerY = body.getY();
        int xOffset = -160;
        int yOffset = -65;
        int x = playerX+xOffset;
        int y = playerY+yOffset;
        setLocation (x,y);
    }

    public void breachlaser(){
        if(shoot>0)
            getWorld().addObject(new breacher(), getX(), getY());
    }

    public void shoot(){
        if(shoot>0)
            getWorld().addObject(new BossLaser(), getX(), getY());
    }
    public void deleteifDead(){ 
        deadbosshead boss = new deadbosshead();
        if(health<=0){
            getWorld().addObject(boss, getX(), getY());
            getWorld().removeObject(this);
        }
    }
    public int contactsideRight()
    {
        Actor b = getOneIntersectingObject(ShootOverall.class);
        if(b!=null)//isTouching(Platform.class))
        {
            hitCounter=20;
            getWorld().removeObject(b);
            health -=10; 
        }
        else
        {
        }
        return health;
    }
}
