import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    private int num;
    
    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Mario(){
        setImage("06.png");
        num=1;//马里奥个数为1
    }
    public void act() 
    {
        move();//移动
        PutBomb();//放炸弹
        Fire();//炸弹引爆
    }
    
    /*
     * 移动
     */
    public void move(){
      
         if(Greenfoot.isKeyDown("up"))
        {
            setImage("04.png");
            if(getY()>0&&checkBrick(getX(),getY()-1)) 
            {setLocation(getX(),getY()-1);return;}
        }
              
        if(Greenfoot.isKeyDown("down"))
        {
            setImage("01.png");
         if(getY()<9&&checkBrick(getX(),getY()+1)) 
            {setLocation(getX(),getY()+1);return;}
        }
       
        if(Greenfoot.isKeyDown("left"))
        {
            setImage("02.png");
            if(getX()>0&&checkBrick(getX()-1,getY())) 
            {setLocation(getX()-1,getY());return;}
            
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            setImage("06.png");
           
             if(getX()<9&&checkBrick(getX()+1,getY())) 
            {setLocation(getX()+1,getY());return;}
           
        }
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
    
    
    /*
     * 放炸弹
     */
    public void PutBomb(){
        List<Bomb> bmobs=getWorld().getObjectsAt(getX(), getY(), Bomb.class);
        if(bmobs.size()>0)return ;
         List<Bomb>bombs2=getWorld().getObjects(Bomb.class);//获取所有炸弹
        if(Greenfoot.isKeyDown("space")&&bombs2.size()==0){
            for(int i=0;i<=15;i++){  
                
                Greenfoot.delay(1);
              
                getWorld().addObject(new Bomb(i),this.getX(),this.getY());
            }           
        }
      
      
    }
    
     /*
       * 炸弹爆炸
       */
      public void Fire(){
          List<Bomb>bombs=getWorld().getObjects(Bomb.class);//获取所有炸弹
         if(bombs.size()>0){
             
          control(15);
          int x=bombs.get(0).getX();
          int y=bombs.get(0).getY();
          getWorld().addObject(new Fire("up"),x,y-1);
          getWorld().addObject(new Fire("up"),x,y);
          getWorld().addObject(new Fire("right"),x+1,y);
          getWorld().addObject(new Fire("left"),x-1,y);
          getWorld().addObject(new Fire("down"),x,y+1);
          control(1);
          
          List<Fire>fires=getWorld().getObjects(Fire.class);
          control(2);
          getWorld().removeObjects(fires);
          getWorld().removeObjects(bombs);
          fireRemove(x+1,y);//右边
          fireRemove(x-1,y);//左边
          fireRemove(x,y);//中间
          fireRemove(x,y-1);//上边
          fireRemove(x,y+1);//下边
        }
     } 
     
     /*
      * 火接触到怪兽，黑砖，马里奥都可以使其消除
      */
     public void fireRemove(int x , int y){
         if(num==1){
         List<Mario> mario=getWorld().getObjectsAt(x,y,Mario.class);
        List<BlackBrick> b_Bricks=getWorld().getObjectsAt(x,y,BlackBrick.class);
         List<Monster> monsters=getWorld().getObjectsAt(x,y,Monster.class);
           if(b_Bricks.size()>0){
             getWorld().removeObject(b_Bricks.get(0));
         }
         
         if(mario.size()>0){
             getWorld().removeObject(mario.get(0));
             num=0;
         }
         
         if(monsters.size()>0){
             getWorld().removeObject(monsters.get(0));
         }
        }
          
         
    
     }
     
     
     
     
     
    /*
     * 用来控制延迟（增加游戏体验）
     */
    public void control(int x){
        for(int i=1;i<=x;i++){
            Greenfoot.delay(5);
            move();
           
        }
            
    }
    
    
    
    
    
    
}
