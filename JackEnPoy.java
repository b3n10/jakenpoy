import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class JackEnPoy {
  private String[] handMove = {
    "Rock", 
    "Paper", 
    "Scissor"
  };
  private int wins = 0;
  private Random rand = new Random();
  private Scanner scan = new Scanner(System.in);
  private boolean gameOver = false;

  public void startGame() {
    //Welcome message
    System.out.println("Rock Paper Scissors Game !");

    while (!gameOver) {
      System.out.print("\nSelect move [0 - Rock, 1 - Paper, 2 - Scissor]: ");
      gameOver = compareMove( getUserInput(), computerInput() );
    }
  }

  public int getUserInput() throws InputMismatchException {
    int user_input;

    try {
      user_input = scan.nextInt();

      //if input is more than 2 or negative
      while (user_input >= 3 || user_input < 0) {
        System.out.println("Please select only from 0-2.");
        System.out.print("\nSelect move [0 - Rock, 1 - Paper, 2 - Scissor]: ");
        user_input = scan.nextInt();
      }

      return user_input;
    } catch (InputMismatchException e) {
      //stop the whole game if input is not int
      throw new InputMismatchException();
    }

  }

  public int computerInput() {
    //random from 0 - 2
    return rand.nextInt(3) + 0;
  }

  public boolean compareMove(int x, int y) {

    //print user selected move and computer's move
    System.out.println("YOU (" + handMove[x] + ")" + " VS CP (" + handMove[y] + ")");

    if (handMove[x] == handMove[y]) {
      System.out.println("\n--It's a draw!--");
    } else if (handMove[x] == "Rock" && handMove[y] == "Scissor") {
      wins++;
      System.out.println("\n--Win " + wins + "--");
    } else if (handMove[x] == "Scissor" && handMove[y] == "Paper") {
      wins++;
      System.out.println("\n--Win " + wins + "--");
    } else if (handMove[x] == "Paper" && handMove[y] == "Rock") {
      wins++;
      System.out.println("\n--Win " + wins + "--");
    } else {
      System.out.println("\n--You lose!--");
      System.out.println("\nYour final score is " + wins);
      return true;
    }

    //continue playing until not lose
    return false;

  }

}
