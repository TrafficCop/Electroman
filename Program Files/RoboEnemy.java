import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoboEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoboEnemy extends Enemies
{
    GifImage beegbeegYoshi = new GifImage("RoboMan59WeirdWalkLol.gif");
    GifImage roller = new GifImage("RobossRoll.gif");
    int frame = 0;
    //GifImage nostop = new GifImage("nostop.gif");
    public boolean touch = false;
    int hitCounter = 0;
    int RandomAttackCounter = 0;
    int fV = 9;
    int movementspeed = 3;
    int health = 100;
    int jumpSpeed= 0;
    double attackValue = 0;
    int roll = 0;
    boolean front = false;
    boolean sideLeft = false;
    boolean sideRight = false;
    boolean back = false;
    int direction = 1;
    int shootingCounter = 0;
    /**
     * Act - do whatever the Atk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        health = contactsideRight();
        //follow();
        goToPlayer();
        contactwall();
        contactUp();
        contactsideLeft();
        contactDown();
        counterManager();
        imaging();
        deleteifDead();
    }    

    public void counterManager(){
        if (getWorld().getObjects(Player.class).isEmpty()) return;
        if(hitCounter>0)
            hitCounter--;
        if(roll>0){
            movementspeed = 10;
            roll--;
        }
        if(roll <=0)
            movementspeed = 3;
        if(RandomAttackCounter>0){
            RandomAttackCounter--;
        }
        if(RandomAttackCounter<=0){
            attackValue=Math.random()*2;
            if(attackValue>1){
                roll = 20;
                rollAtack();
            }
            if(attackValue<1){
            }
            RandomAttackCounter = 70;
        }
    }

    public void rollAtack(){
        if (getWorld().getObjects(Player.class).isEmpty()) return;
        if(roll>0){
            movementspeed = 10;
            Actor Player = (Actor)getWorld().getObjects(Player.class).get(0);
            if(Player.getX()>this.getX()){
                setLocation(getX() + movementspeed, getY());
            }
            if(Player.getY()<this.getY()){
                setLocation(getX(), getY()-movementspeed);
            }
            if(Player.getX()<this.getX()){
                setLocation(getX() - movementspeed, getY());
            }
            if(Player.getY()>this.getY()){
                setLocation(getX(), getY()+movementspeed);
            }
        }
    }

    public void imaging(){
        if(hitCounter>0){
            setImage(new GreenfootImage("hurt.png"));
        }
        else
            setImage(beegbeegYoshi.getCurrentImage());
        if(roll>0){
            setImage(roller.getCurrentImage());
        }
        
    }
    // public void follow(){
    // move(2);
    // if (getWorld().getObjects(Player.class).isEmpty()) return; // skips following if the tank is not in world
    // Actor tank = (Actor)getWorld().getObjects(Player.class).get(0); // gets reference to tank
    // turnTowards(tank.getX(), tank.getY()); // turn toward tank
    // }
    public void goToPlayer(){
        if (getWorld().getObjects(Player.class).isEmpty()) return;
        Actor Player = (Actor)getWorld().getObjects(Player.class).get(0);
        if(Player.getX()>this.getX()){
            setLocation(getX() + movementspeed, getY());
        }
        if(Player.getY()<this.getY()){
            setLocation(getX(), getY()-movementspeed);
        }
        if(Player.getX()<this.getX()){
            setLocation(getX() - movementspeed, getY());
        }
        if(Player.getY()>this.getY()){
            setLocation(getX(), getY()+movementspeed);
        }
    }

    public void deleteifDead(){ 
        Boss1Drop boss = new Boss1Drop();
        if(health<=0){
            getWorld().addObject(boss, getX(), getY());
            getWorld().removeObject(this);
        }
    }
    public boolean wall()
    {
        Actor b = getOneIntersectingObject(Platform.class);  
        if(b!=null)//isTouching(Platform.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void back(){
        if(wall()==true)
        setLocation(getX()-20, getY());
    }

    public int contactsideRight()
    {
        Actor b = getOneIntersectingObject(ShootOverall.class);  
        if(b!=null)//isTouching(Platform.class))
        {
            hitCounter=20;
            getWorld().removeObject(b);
            health -=20; 
        }
        else
        {
            sideRight = false;
        }
        return health;
    }
        public void contactDown()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2);
        Actor plat = getOneObjectAtOffset(0, yDistance,Platform.class);

        if(plat!=null)//isTouching(Platform.class))
        {
            back = true;
            setLocation(getX(), getY()+20);
        }
        else{
            back = false;
        }
    }

    public void contactUp()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/-2);
        Actor plat = getOneObjectAtOffset(0, yDistance,Platform.class);

        if(plat!=null)//isTouching(Platform.class))
        {
            front = true;
            setLocation(getX(), getY()-20);
        }
        else{
            front = false;
        }
    }

    public void contactwall()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/2);
        Actor plat = getOneObjectAtOffset(xDistance, 0,Platform.class);

        if(plat!=null)//isTouching(Platform.class))
        {
            setLocation(getX()-20, getY());
        }
        else
        {
            sideRight = false;
        }
    }

    public void contactsideLeft()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/-2);
        Actor plat = getOneObjectAtOffset(xDistance, 0,Platform.class);

        if(plat!=null)//isTouching(Platform.class))
        {
            setLocation(getX()+20, getY());
            sideLeft=true;
        }
        else
        {
            sideLeft = false;
        }
    }
}
