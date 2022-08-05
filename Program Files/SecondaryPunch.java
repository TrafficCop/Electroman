import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SecondaryPunch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondaryPunch extends Enemies
{
    int randomAttackCounter = 0;
    int animationcounter = 0;
    double attackValue = 0;
    int snapduration = 0;
    int pointertime = 0;
    int locktime = 0;
    private secondarypunchbox p;
    public SecondaryPunch(secondarypunchbox p){
        this.p=p;
    }
    /**
     * Act - do whatever the FinalBossPunch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        counter();
        Animation();
        Snap();
        followbox();
        point();
        animate();
        // Add your action code here.
    }    
    public void followbox(){
        int playerX = p.getX();
        int playerY = p.getY();
        int x = playerX;
        int y = playerY;
        setLocation (x,y);
    }
    public void counter(){
        if(randomAttackCounter>0 && snapduration ==0 && pointertime == 0){
            randomAttackCounter--;
        }
        if(pointertime >0)
        pointertime --;
        if(pointertime == 0)
        setRotation(0);
        if(locktime > 0 )
        locktime --;
        if(randomAttackCounter<=0){
            attackValue=Math.random()*3;
            if(attackValue>1.75){
                snapduration = 30;
            }
            if(attackValue<1.75){
                locktime = 5;
                pointertime = 30;
                face();
            }
            randomAttackCounter = 30;
        }
        if(snapduration >0)
            snapduration--;
    }
    public void animate(){
        if(snapduration>0)
        return;
        if(pointertime>0)
        setImage(new GreenfootImage("Pointer clone-1.png.png"));
        else
        setImage(new GreenfootImage("SecondPunchP.png"));
    }
    public void point(){
        turn(Greenfoot.getRandomNumber(3));
        if(pointertime>0){
            PointerL p = new PointerL();
            getWorld().addObject(p, getX(), getY());
            p.setRotation(getRotation());
        }
    }
    public void face(){

        if (getWorld().getObjects(Player.class).isEmpty()) return;
        Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
        if(locktime>0){
            turnTowards(player.getX(), player.getY());
        }
    }

    public void Animation(){
        if(snapduration>20){
            setImage(new GreenfootImage("Snap1.png"));
        }
        if(snapduration < 20 && snapduration >=10){
            setImage(new GreenfootImage("Snap2.png"));
        }
        if(snapduration <10 && snapduration>=7){
            setImage(new GreenfootImage("Snap3.png"));
        }
        if(snapduration <7 && snapduration>=4){
            setImage(new GreenfootImage("Snap4.png"));
        }
        if(snapduration <4 && snapduration>=1){
            setImage(new GreenfootImage("Snap5.png"));
        }
    }

    public void Snap(){
        if (getWorld().getObjects(Player.class).isEmpty()) return; 
        if(snapduration ==9){
            Actor player = (Actor)getWorld().getObjects(Player.class).get(0); 
            BigBois blc = new BigBois();
            BigBois tlc = new BigBois();
            BigBois brc = new BigBois();
            BigBois trc = new BigBois();
            BigBois a = new BigBois();
            BigBois b = new BigBois();
            BigBois c = new BigBois();
            BigBois d = new BigBois();
            BigBois e = new BigBois();
            getWorld().addObject(blc, getX(), getY());
            blc.setRotation(45);
            getWorld().addObject(tlc, getX(), getY());
            tlc.setRotation(135);
            getWorld().addObject(brc, getX(), getY());
            brc.setRotation(225);
            getWorld().addObject(trc, getX(), getY());
            trc.setRotation(315);
            getWorld().addObject(a, getX(), getY());
            a.setRotation(0);
            getWorld().addObject(b, getX(), getY());
            b.setRotation(90);
            getWorld().addObject(c, getX(), getY());
            c.setRotation(180);
            getWorld().addObject(d, getX(), getY());
            d.setRotation(270);
            getWorld().addObject(e, getX(), getY());
            e.setRotation(360);
        }
    }
}
