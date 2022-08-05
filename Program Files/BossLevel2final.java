import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossLevel2final here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossLevel2final extends World
{

    /**
     * Constructor for objects of class BossLevel2final.
     * 
     */
    public BossLevel2final(int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 1024, 1); 
        Player player = new Player();
        addObject(player, 0,512);
        Crosshair cross = new Crosshair();
        addObject(cross,0,512);
        bossbox z = new bossbox();
        addObject(z, 700,512);
        FinalBossHead boss = new FinalBossHead(z);
        addObject(boss, 700,512);
        PrimaryPunch punch = new PrimaryPunch();
        addObject(punch, 500, 512);
        secondarypunchbox p = new secondarypunchbox();
        addObject(p, 500, 712);
        SecondaryPunch paunch = new SecondaryPunch(p);
        addObject(paunch, 500, 712);
    }
}
