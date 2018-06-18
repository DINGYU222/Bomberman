import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public MarioGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(10, 10, 50); 
         /*
        * 添加绿砖
        */
       for(int i =0;i<10;i++){
           for(int j=0;j<10;j++)
            addObject(new GreenBrick(),i,j);
        }
        /*
         * 添加马里奥
         */
        addObject(new Mario(),0,0);
        /*
         添加白砖
         */
        for(int i =0 ;i <=10 ; i++){
            addObject(new WhiteBrick(),i,10);
            addObject(new WhiteBrick(),10,i);
        }
       for(int i=1;i<=7;i+=2){
           for(int j=1;j<=7;j+=2)
                addObject(new WhiteBrick(),i,j);
        }
      /*
       * 添加黑砖
       */
      
     addObject(new BlackBrick(),2,0);
      addObject(new BlackBrick(),3,0);
      addObject(new BlackBrick(),4,0);
      addObject(new BlackBrick(),5,0);
      addObject(new BlackBrick(),6,0);
      addObject(new BlackBrick(),8,0);
      addObject(new BlackBrick(),2,1);
      addObject(new BlackBrick(),4,1);
      addObject(new BlackBrick(),6,1);
      addObject(new BlackBrick(),8,1);
      for(int j=2;j<8;j+=2)
        for(int i=0 ; i<9 ; i++) 
            addObject(new BlackBrick(),i,j);
      for(int j=3;j<9;j+=2)
        for(int i=0;i<9;i+=2)
           addObject(new BlackBrick(),i,j);
     /* addObject(new BlackBrick(),0,8);
      addObject(new BlackBrick(),2,8);
      addObject(new BlackBrick(),3,8);
      addObject(new BlackBrick(),4,8);
      addObject(new BlackBrick(),6,8);
      addObject(new BlackBrick(),8,8);*/
     /*
      * 添加怪兽
      */
     addObject(new Monster(),7,8);
     
    }
}
