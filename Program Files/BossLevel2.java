import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossLevel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossLevel2 extends World
{
    GifImage backgroundGif = new GifImage("FinalBossBattle.gif");
    /**
     * Constructor for objects of class BossLevel2.
     * 
     */
    public BossLevel2(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 1024, 1); 
        Player player = new Player();
        addObject(player, 0,512);
        BossBody boss = new BossBody();
        addObject(boss, 924, 512);
        bosshead head = new bosshead(boss);
        addObject(head, 700, 512);
        Crosshair cross = new Crosshair();
        addObject(cross,0,512);
        Barrier1 barr = new Barrier1();
        addObject(barr, 200, 512);
        Barrier1 barr1 = new Barrier1();
        addObject(barr1, 325, 206);
        Barrier1 barr2 = new Barrier1();
        addObject(barr2, 325, 818);
    }
    private void Animation(){
        setBackground(backgroundGif.getCurrentImage());
    }
    public void act(){
        Animation();
    }
}
