package com.cryosoftdesigns.PokemonGame;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 * @author KJ
 */
public class Main{
   public static void main(String[] args){
	   Random randHash = new Random();
	      Random rand = new Random(randHash.nextInt(99999999));
	      PlayerOne p1 = new PlayerOne(); //creating new Pokemon object for the user, but not initialized with values
	      PlayerTwo p2 = new PlayerTwo(); // creating new Pokemon object for the comp, but not initialized with values
	      String[] pokeName = {"Charmander", "Squirtle", "Bulbasaur"}; //Array with all of the Pokemon name values initialized
	      
	      JOptionPane.showMessageDialog(null, "Welcome to the 2014 Pokemon Battle Simulator\nPlease choose your starting Pokemon from the following list.");
	      
	      /**
	       * This for loop fails due to printf in Eclipse but not in jGrasp
	       */
	      
	      for(int i = 0; i < 3; i++){   //create loop to display the pokemon list to the user in the console
	    	  //System.out.printf("%d - %s%n", i + 1, pokeName[i]);
	    	  System.out.println(pokeName[i]);
	      }
	      
	      JOptionPane.showMessageDialog(null, "1 - " + pokeName[0] + "\n2 - " + pokeName[1] + "\n3 - " + pokeName[2]);
	      String userChoice = JOptionPane.showInputDialog(null, "Please Enter Your Choice (1, 2, or 3):"); 
	      
	      if(Integer.parseInt(userChoice) == 1){  //verifies which pokemon the user picked and sets up the object with parameters (HP, Attack power, etc)
	         p1.setupPokemon("fire", pokeName[0]); 
	      } else if(Integer.parseInt(userChoice) == 2){
	         p1.setupPokemon("water", pokeName[1]);
	      } else if(Integer.parseInt(userChoice) == 3){
	         p1.setupPokemon("grass", pokeName[2]);
	      } else {
	         JOptionPane.showMessageDialog(null, "Invalid Pokemon Selection. Please restart and try again.");
	         System.exit(0);
	      }
	      p1.getPokemonInfo();
	      
	      JOptionPane.showMessageDialog(null, "Now let's find out who your rival has chosen!\nYour rival chose....");
	      
	      int randnum = rand.nextInt(3) + 1;
	      if(randnum == 1){ // uses the random number generated to assign a random Pokemon to the computer and sets up the object with the appropriate parameters
	         p2.setupPokemon("fire", pokeName[0]);
	      } else if(randnum == 2){
	         p2.setupPokemon("water", pokeName[1]);
	      } else if(randnum == 3){
	         p2.setupPokemon("grass", pokeName[2]);
	      } else {
	         JOptionPane.showMessageDialog(null, "An error has occurred, please restart and try again!");
	      }
	      p2.getPokemonInfo();
	      
	      System.out.println();
	      
	      int confirm = JOptionPane.showConfirmDialog(null, "Are you ready to begin your battle?");
	      
	      if(confirm == JOptionPane.NO_OPTION){
	         JOptionPane.showMessageDialog(null, "Thank you for playing, please come again!");
	         System.exit(0);
	      }
	      nextRound(p1, p2); // runs the nextRound method until one user's HP reaches 0
   }
   
   public static void nextRound(PlayerOne p1, PlayerTwo p2){
      //Random rand = new Random();
      //int userTurn = rand.nextInt(9) + 1;
      
	   if((p1.getType() == "fire" && p2.getType() == "grass") || (p1.getType() == "water" && p2.getType() == "fire") || (p1.getType() == "grass" && p2.getType() == "water")){
         p1.setAttack(p1.getAttack() * 2);
	   } else if((p1.getType() == "fire" && p2.getType() == "water") || (p1.getType() == "water" && p2.getType() == "grass") || (p1.getType() == "grass" && p2.getType() == "fire")){
         p2.setAttack(p2.getAttack() * 2);
	   } // if/else used to find out if the opposing pokemon is weak to the user's pokemon and vice versa.
      
	   while(p1.getHp() > 0 && p2.getHp() > 0){ // The actual battle 'while' loop is used to produce the battle until one user hits HP level 0
	      p2.setHp(p2.getHp() - p1.getAttack());
	      System.out.println("P2's " + p2.getName() + " was hit for " + p1.getAttack() + " hp");
	      p1.setHp(p1.getHp() - p2.getAttack());
	      System.out.println("P1's " + p1.getName() + " was hit for " + p2.getAttack() + " hp");
	      
	      JOptionPane.showMessageDialog(null, p1.getName() + " was hit for " + p2.getAttack() + " hp.\nP1's " +
	    		  p1.getName() + "\'s Remaining HP: " + p1.getHp() + " hp.\n\n" + p2.getName() + " was hit for " + 
	    		  p1.getAttack() + " hp.\nP2's " + p2.getName() + "\'s Remaining HP: " + p2.getHp() + " hp.");
	      
	      System.out.println("P1's " + p1.getName() + " has " + p1.getHp() + " hp remaining.");
	      System.out.println("P2's " + p2.getName() + " has " + p2.getHp() + " hp remaining.");
	      System.out.println();
	   }
	   if(p1.getHp() == 0 && p2.getHp() == 0){ // displays the final results from the battle
	      JOptionPane.showMessageDialog(null, "STALEMATE\nBoth yours and your rival's Pokemon have knocked one another out.\nTrain up and try again!");
	   } else if(p1.getHp() == 0){
	      JOptionPane.showMessageDialog(null, "YOU LOST!\nYour Pokemon has been knocked out.\nPlease train some more so you may come back and battle again!");
	   } else if(p2.getHp() == 0){
	      JOptionPane.showMessageDialog(null, "YOU WON!\nYou have defeated your rival's Pokemon!\nTrain some more and be prepared for more challengers in the future.");
	   }
   }
   
}
