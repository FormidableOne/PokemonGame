package com.cryosoftdesigns.PokemonGame;
import javax.swing.JOptionPane;

public class PlayerTwo{
   private int hp, attack;
   private String type, name;
   
   public void setupPokemon(String t, String n){
      setHp(100);
      setAttack(10);
      setType(t);
      setName(n);
   }
   public void setHp(int h){
      hp = h;
   }
   public int getHp(){
      return hp;
   }
   public void setAttack(int a){
      attack = a;
   }
   public int getAttack(){
      return attack;
   }
   public void setType(String t){
      type = t;
   }
   public String getType(){
      return type;
   }
   public void setName(String n){
      name = n;
   }
   public String getName(){
      return name;
   }
   public void getPokemonInfo(){
      JOptionPane.showMessageDialog(null, "Rival's Pokemon Name: " + getName() + "\nPokemon Type: " + getType() + "\nHP: " + getHp() + "\nAttack: " + getAttack());
      //System.out.printf("%nRival's Pokemon Name: %s%nPokemon Type: %s%nHP: %d%nAttack: %d%n", getName(), getType(), getHp(), getAttack());
   }
}
