import java.util.Scanner;
import java.util.Random;

public class Jep {
  public static void main(String[] args) {
    /*
     * rock > scissor
     * scissor > paper
     * paper > rock
     */
    String[] handMove = {"Rock", "Paper", "Scissor"};
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    int user_input;
    int cp_num, win = 0;
    boolean game = true;

    while (game) {
      try {

        System.out.print("\nSelect move [0 - Rock, 1 - Paper, 2 - Scissor]: ");
        user_input = scan.nextInt();

        while ( user_input >= 3 ) {
          System.out.print("\nPlease select from 0-2 only!\n\nSelect move [0 - Rock, 1 - Paper, 2 - Scissor]: ");
          user_input = scan.nextInt();
        }

        cp_num = rand.nextInt(3) + 0;//will return 0 - 2 random numbers
        System.out.println("YOU (" + handMove[user_input] + ")" + " VS CP (" + handMove[cp_num] + ")");

        handMove[user_input] = handMove[user_input];
        handMove[cp_num] = handMove[cp_num];

        //compare move
        if (handMove[user_input] == handMove[cp_num]) {
          System.out.println("\n--It's a draw!--");
        } else if (handMove[user_input] == "Rock" && handMove[cp_num] == "Scissor") {
          win++;
          System.out.println("\n--Win " + win + "--");
        } else if (handMove[user_input] == "Scissor" && handMove[cp_num] == "Paper") {
          win++;
          System.out.println("\n--Win " + win + "--");
        } else if (handMove[user_input] == "Paper" && handMove[cp_num] == "Rock") {
          win++;
          System.out.println("\n--Win " + win + "--");
        } else {
          System.out.println("You lose!");
          System.out.println("\nYour final score is " + win);
          game = false;
        }

      } catch (Exception e) {
        System.out.println("Oops, error on input:\n\"" + e + "\"");
        break;
      }
    }
    


  }
}
