
@RedisHash("#scrumblr#-room:luna25-cards")
public class CardRedis implements Serializable {
 
    private String id;
    private String text;
    private String color;
    private String x;
    private String y;
  
  public void setId(){this.id=id;}
  public void setText(){this.text=text;}
  public void setcolor(){this.color=color;}
  public void setX(){this.x =x;}
  public void setY(){this.y=y;}

  public String getId(){ return id;}
  public String getText(){ return text;}
  public String getColor(){ return color;}
  public String getX(){ return x;}
  public String getY(){ return y;}
  public CardRedis ();
}
