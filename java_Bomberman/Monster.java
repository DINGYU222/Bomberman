import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    private int dir;
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Monster(){
        for(int i=0;i<4;i++){
            setImage("D"+i+".png");
            Greenfoot.delay(5);
            }
    }
    
    public void act() 
    {
       Greenfoot.delay(15);
       dir=Greenfoot.getRandomNumber(4);
       switch(dir)
       {
           case 0: 
                if(getY()>0&&checkBrick(getX(),getY()-1)) 
                         {setLocation(getX(),getY()-1);}  break; 
          
           case 1:if(getY()<9&&checkBrick(getX(),getY()+1)) 
            {setLocation(getX(),getY()+1);}break;
           case 2:if(getX()>0&&checkBrick(getX()-1,getY())) 
            {setLocation(getX()-1,getY());}break;
            
           case 3:   if(getX()<9&&checkBrick(getX()+1,getY())) 
            {setLocation(getX()+1,getY());}break;
            
            
        }
        removeTouching(Mario.class);
    }  
     public boolean checkBrick(int x,int y){
        List<WhiteBrick> w_bricks=getWorld().getObjectsAt(x, y, WhiteBrick.class);
        List<BlackBrick> b_bricks=getWorld().getObjectsAt(x, y, BlackBrick.class);
       List<Bomb> bmobs=getWorld().getObjectsAt(x, y, Bomb.class);
        if(w_bricks.size()>0||b_bricks.size()>0 ||bmobs.size()>0)
            return false;
         else 
            return true;
    }
}
