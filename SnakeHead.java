import greenfoot.*; 
import java.util.ArrayList;

public class SnakeHead extends Actor implements IFoodPublisher
{
    private final int RIGHT = 0;
    private final int DOWN = 90;
    private final int LEFT = 180;
    private final int UP = 270;
    
    private int SPEED = 5;
    private int counter = 0; 
    private int speedDivision = 0;
    
    private int AppleConsumed = 0;
    
    
    private ArrayList<IFoodListner> listner;
    
    public SnakeHead(){
        listner = new ArrayList<>();
        renderSnakeHead();
    }
    
    public void renderSnakeHead(){
       GreenfootImage img = new GreenfootImage(20,20);
       img.setColor(Color.LIGHT_GRAY);
       img.fill();
       setImage(img);
       setRotation(Greenfoot.getRandomNumber(4)*90); 
    }

    /**
     * Attach a Key Pad Observer
     * 
     * @param obj Observer
     */
    public void attach(IFoodListner obj) {
        listner.add(obj);
    }

    /**
     * Remove Key Pad Observer
     * 
     * @param obj Observer
     */
    public void removeObserver(IFoodListner obj) {
        int i = listner.indexOf(obj);
        if (i >= 0)
            listner.remove(i);
    }
    
    /**
     * Notify all Observers of Update Event
     */
    public void notifyListner() {
        for (int i = 0; i < listner.size(); i++) {
            IFoodListner listner = this.listner.get(i);
            listner.addFoodToWorld();
            
        }
    }
    
    
    public void act()
    {
        crawl();
        
        //If the SnakeHead is touch the Apple then the following will be true and run the code which hides the Apple.
        if(isTouching(Food.class)) {
            removeTouching(Food.class);
            
            AppleConsumed++;
            notifyListner();
            speedDivision++;  
            //Greenfoot.playSound("bite.mp3"); 
        }
        
       if(isTouching(SnakeBody.class)){
       Greenfoot.stop();
       //Greenfoot.playSound("gameOver.mp3");
        }
        
       if(speedDivision == 5) {
            speedDivision = 0;
            SPEED = SPEED - 1;
            //Greenfoot.playSound("speedup.mp3");
          }
        
       if (getX() < 0) {
           setLocation(getWorld().getWidth(), getY());
           //Greenfoot.playSound("jump.mp3");
        }
        
       if (getX() > getWorld().getWidth()) {
           setLocation(0, getY());
           //Greenfoot.playSound("jump.mp3");
        }
        
       if (getY() < 0 ){
           setLocation(getX(), getWorld().getHeight());
          // Greenfoot.playSound("jump.mp3");
        }
        
       if (getY() > getWorld(). getHeight()) {
           setLocation(getX(), 0);
           //Greenfoot.playSound("jump.mp3");
        }
   
      
    }
    
    //Function to check if facing edge of the world up, down, left or right.
    private boolean touchingEdge()
    {
        switch(getRotation()) {
            case UP: return getY()==0;
            case RIGHT: return getX()==getWorld().getWidth()-1;
            case DOWN: return getY()==getWorld().getHeight()-1;
            case LEFT: return getX()==0;
        }
        return false;
    }
    
    public void crawl()
    {
        if(++counter==SPEED) {
            getWorld().addObject(new SnakeBody(AppleConsumed*SPEED), getX(), getY());
            move(1);
            counter = 0;
        } 
 
        if( Greenfoot.isKeyDown("up") ) {
            setRotation(UP);
        }
   
        if( Greenfoot.isKeyDown("right") ) {
            setRotation(RIGHT);
        }

        if( Greenfoot.isKeyDown("down") ) {
            setRotation(DOWN);
        }

        if( Greenfoot.isKeyDown("left") ) {
            setRotation(LEFT);
        }

    }
}
