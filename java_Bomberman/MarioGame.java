import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarioGame extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public int n;//马里奥个数
    public MarioGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(10, 10, 50); 
        n=1;//个数为1
        setBackground("Fondo1.png");
        addObject(new Button("help"),1,9);
        addObject(new Button("play"),9,9);
    
    }
    
    public void started(){
        setBackground("Fondo1.png");
    }
    
    public void act(){
        
      
    }
    
}
