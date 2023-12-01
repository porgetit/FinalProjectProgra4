/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Connector.Update;

/**
 *
 * @author Kevin Esguerra Cardona
 */
public class Player {
    private int Id;
    private String Name;
    private String SubscriptionType;
    
    public Player() {
        Id = -1;
        Name = null;
        SubscriptionType = null;        
    }
    
    public Player(int Id, String Name, String SubscriptionType) {
        this.Id = Id;
        this.Name = Name;
        this.SubscriptionType = SubscriptionType;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSubscriptionType() {
        return SubscriptionType;
    }

    public void setSubscriptionType(String SubscriptionType) {
        this.SubscriptionType = SubscriptionType;
    }
    
    public void updateDB() {
        Update.toUpdate(Id, Name, SubscriptionType);
    }

    public Object getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
