/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author 57312
 */
public class Player {
    private int Id;
    private String Name;
    private String SubscriptionType;
    
    public Player() {
        
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

    @Override
    public String toString() {
        return "Player{" + "Id=" + Id + ", Name=" + Name + ", SubscriptionType=" + SubscriptionType + '}';
    }
    
}
