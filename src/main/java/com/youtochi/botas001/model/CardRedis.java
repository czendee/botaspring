package com.youtochi.botas001.model;

import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("#scrumblr#-room:/luna25-cards")
//@RedisHash("scrumblr-room:luna25-cards")
//@RedisHash("luna25-cards")
//@RedisHash("scrumblr-room")
public class CardRedis implements Serializable {
 
    private String id;
    private String text;
    private String colour;
    private double x;
    private double y;
  
  public void setId(){this.id=id;}
  public void setText(){this.text=text;}
  public void setColour(){this.colour=colour;}
  public void setX(){this.x =x;}
  public void setY(){this.y=y;}

  public String getId(){ return id;}
  public String getText(){ return text;}
  public String getColour(){ return colour;}
  public double getX(){ return x;}
  public double getY(){ return y;}

}
