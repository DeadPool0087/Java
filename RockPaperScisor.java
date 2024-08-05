import java.util.Random;
import java.util.Scanner;
public class RockPaperScisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random R = new Random();
        while(true){
            System.out.println("Enter your move (rock, paper, scissors. To exit game type 'exit': ");
            String userMove = sc.nextLine().toLowerCase();
            if(userMove.equals("exit")){
                break;
            }
            if(!userMove.equals("rock")&&!userMove.equals("paper")&&!userMove.equals("scissors")){
                System.out.println("Invalid move, Please try again!!");
                continue;
            }
            int Computer = R.nextInt(3);
            String computerMove = "";
            switch (Computer) {
                case 0 -> computerMove="rock";
                case 1 -> computerMove="paper";
                case 2 -> computerMove="scissors";
                }
            if(userMove.equals(computerMove)){
                System.out.println("your move "+userMove+" Computer move "+computerMove);
                System.out.println("It's a tie !");
            }
            else if (userMove.equals("rock") && computerMove.equals("scissors") || userMove.equals("paper") && computerMove.equals("rock") || userMove.equals("scissors") && computerMove.equals("paper")) {
                System.out.println("your move "+userMove+" Computer move "+computerMove);
                System.out.println("You win!!");
            }
            else {
                System.out.println("your move "+userMove+" Computer move "+computerMove);
                System.out.println("You loss!!");
            }
        }
        System.out.println("Game over!!");
    }
}
