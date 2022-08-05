import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shrek here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public static int health =11;
    private Atk atk;
    GifImage right = new GifImage("CharacterBoi2.gif");
    GifImage flash = new GifImage("hurtP.gif");
    int acceleration = 1;
    int initialV= 0;
    int fV = 9;
    int delay = 400;
    int jumpSpeed= 0;
    boolean front = false;
    boolean sideLeft = false;
    boolean sideRight = false;
    boolean jumpProg = false;
    boolean back = false;
    int direction = 1;
    int intangibleFrames = 0;
    int shootingCounter = 0;
    
    /**
     * Act - do whatever the Shrek wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){ 
        
        keys();
        contactUp();
        contactDown();
        contactsideRight();
        contactsideLeft();
        shooting();
        shootingCounter--;
        
        health = getHitSide();
        health();
        imaging();
        counterManager();

    }
    public static int getHealth(){
        return health;
    }
    
    public void health(){
        if(health==11){
        H1 h = new H1();
        getWorld().addObject(h, 100, 100);}
        if(health==10){
        H2 h = new H2();
        getWorld().addObject(h, 100, 100);}
        if(health==9){
        H3 h = new H3();
        getWorld().addObject(h, 100, 100);}
        if(health==8){
        H4 h = new H4();
        getWorld().addObject(h, 100, 100);}
        if(health==7){
        H5 h = new H5();
        getWorld().addObject(h, 100, 100);}
        if(health==6){
        H6 h = new H6();
        getWorld().addObject(h, 100, 100);}
        if(health==5){
        H7 h = new H7();
        getWorld().addObject(h, 100, 100);}
        if(health==4){
        H8 h = new H8();
        getWorld().addObject(h, 100, 100);}
        if(health==3){
        H9 h = new H9();
        getWorld().addObject(h, 100, 100);}
        if(health==2){
        H10 h = new H10();
        getWorld().addObject(h, 100, 100);}
        if(health==1){
        H11 h = new H11();
        getWorld().addObject(h, 100, 100);}
        if(health==0){
        H12 h = new H12();
        getWorld().addObject(h, 100, 100);}
    }
    public void counterManager(){
        if(intangibleFrames>0)
        intangibleFrames--;
            if(health<=0){
                health = 11;
            getWorld().removeObject(this);
        }
    }
    public void imaging(){
        if(intangibleFrames>0)
        setImage(flash.getCurrentImage());
        else{
            setImage(right.getCurrentImage());
        }
    }
    public int getHitSide(){
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth);
        Actor plat = getOneIntersectingObject(Enemies.class);
        Actor bullt = getOneIntersectingObject(EnemyProjectiles.class);
        if((plat!=null || bullt!=null) && intangibleFrames <=0)//isTouching(Platform.class))
        {
            intangibleFrames = 30;
            health --;
        }
        else
        {
        }
        return health;
    }
    public boolean shooting()
    {
        MouseInfo left = Greenfoot.getMouseInfo();
        if(left!=null && shootingCounter <= 0)
        if(left.getButton()==1){
            getWorld().addObject(new ShootOverall(), getX(), getY());
            shootingCounter = 25;
            return true;
        }
        return false;
    }

    public void keys()
    {
        if(Greenfoot.isKeyDown("a") && sideLeft == false)
        {
            direction = -1;
            walkLeft();
        }
        if(Greenfoot.isKeyDown("d") && sideRight == false )
        {
            direction = 1;
            walkRight();
        }
        if( Greenfoot.isKeyDown("w") && front == false)
        {
            walkUp();
        }
        if(Greenfoot.isKeyDown("s") && back == false)
        {
            walkDown();
        }
    }

    public void walkLeft()
    {
        setLocation(getX() - fV, getY());
    }

    public void walkRight()
    {
        setLocation(getX() + fV, getY());
    }

    public void walkDown()
    {
        setLocation(getX(), getY()+fV);
    }

    public void walkUp()
    {
        setLocation(getX(), getY()-fV);
    }
    //     public void testFloor(){
    //         Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
    //         {
    //             
    //         }
    //     }
    //     public boolean touchGround()
    //     {
    //         return isTouching(Platform.class);
    // 
    //     }

    public void contactDown()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2);
        Actor plat = getOneObjectAtOffset(0, yDistance,Platform.class);

        if(plat!=null)//isTouching(Platform.class))
        {
            back = true;
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
        }
        else{
            front = false;
        }
    }

    public void contactsideRight()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/2);
        Actor plat = getOneObjectAtOffset(xDistance, 0,Platform.class);

        if(plat!=null)//isTouching(Platform.class))
        {
            sideRight =true;
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
            sideLeft=true;
        }
        else
        {
            sideLeft = false;
        }
    }
}

