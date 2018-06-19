import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private String show;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Button(String s){
        setImage("bot.png");
        show=s;
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)&&show=="play"){
            DisplayGame();
        }
        if(Greenfoot.mouseClicked(this)&&show=="help"){
          // new GreenfootImage(10,10).clear();
            getWorld().addObject(new Help(),7,7);
           //setImage("help2.png");
         
          getWorld().addObject(new Button("play"),6,9);
        }
    } 
    
    
    public void DisplayGame(){
       /*
        * 添加绿砖
        */
       for(int i =0;i<10;i++){
           for(int j=0;j<10;j++)
            getWorld(). addObject(new GreenBrick(),i,j);
        }
        /*
         * 添加马里奥
         */
      getWorld(). addObject(new Mario(),0,0);
        /*
         添加白砖
         */
        for(int i =0 ;i <=10 ; i++){
           getWorld(). addObject(new WhiteBrick(),i,10);
           getWorld(). addObject(new WhiteBrick(),10,i);
        }
       for(int i=1;i<=7;i+=2){
           for(int j=1;j<=7;j+=2)
              getWorld().  addObject(new WhiteBrick(),i,j);
        }
      /*
       * 添加黑砖
       */
      
    getWorld(). addObject(new BlackBrick(),2,0);
     getWorld(). addObject(new BlackBrick(),3,0);
     getWorld(). addObject(new BlackBrick(),4,0);
     getWorld(). addObject(new BlackBrick(),5,0);
     getWorld(). addObject(new BlackBrick(),6,0);
     getWorld(). addObject(new BlackBrick(),8,0);
     getWorld(). addObject(new BlackBrick(),2,1);
     getWorld(). addObject(new BlackBrick(),4,1);
      
     getWorld(). addObject(new BlackBrick(),8,1);
      for(int j=2;j<8;j+=2)
        for(int i=0 ; i<9 ; i++) 
          getWorld().  addObject(new BlackBrick(),i,j);
      for(int j=3;j<9;j+=2)
        for(int i=0;i<9;i+=2)
          getWorld(). addObject(new BlackBrick(),i,j);
    getWorld(). addObject(new BlackBrick(),0,8);
     getWorld(). addObject(new BlackBrick(),2,8);
     getWorld(). addObject(new BlackBrick(),3,8);
     getWorld(). addObject(new BlackBrick(),4,8);
    
     getWorld(). addObject(new BlackBrick(),8,8);
     /*
      * 添加怪兽
      */
    getWorld(). addObject(new Monster(),7,8);
    }
     
}
