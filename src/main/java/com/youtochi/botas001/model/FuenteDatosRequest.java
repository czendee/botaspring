package com.youtochi.aprende001.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class FuenteDatosRequest {
  @XmlElement
  private String login;
  @XmlElement
  private String password;
  
  public FuenteDatosRequest() { }
  public String getLogin() { return login; }
  public void setLogin(String login) { this.login = login; }
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
}
