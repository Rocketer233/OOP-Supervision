import java.util.Scanner;

import javax.script.ScriptContext;

public class Game {
    int ans, maxGuess;
    String difficulty;

    static final String prompt1 = "Please enter your name.";
    static final String prompt2 = "Game lost. Do you want one more game?";
    static final String prompt3 = "Game wins. Do you want one more game?";

    static Scanner scanner = new Scanner(System.in);

    public Game(String difficulty){
        this.ans = (int)(Math.random() * 100);
        this.maxGuess = difficulty == "Easy" ? ans : (int)(2 * Math.log(ans) / Math.log(2));
        this.difficulty = difficulty;
    }

    public int doGame(){
        Guess g = new Guess(ans);

        while(maxGuess > 0){
            maxGuess--;

            int response = Integer.parseInt(scanner.nextLine());
            String info = g.check(response);

            if(info == "Correct!"){
                System.out.println(prompt3);
                return 1;
            }
            else if(maxGuess > 0)
                System.out.println(info);
            else System.out.println(prompt2);
        }

        return 0;
    }

    public static void printInfo(String name, int wins1, int wins2){
        System.out.println("Name: " + name);
        System.out.println("Number of wins at easy mode: " + Integer.toString(wins1));
        System.out.println("Number of wins at difficult mode: " + Integer.toString(wins2));
    }

    public static void main(String[] args){
        System.out.println(prompt1);

        int winsEasy = 0, winsDiff = 0;
        String name = scanner.nextLine();
        String mode, response;
        
        do{
            System.out.println("Please pick a mode");

            mode = scanner.nextLine();
            Game game = new Game(mode);

            System.out.println("Please make a guess");

            if(game.doGame() == 1){
                if(mode.equals("Easy"))
                    winsEasy++;
                else winsDiff++;
            }

            printInfo(name, winsEasy, winsDiff);

            response = scanner.nextLine();
        }while(response.equals("Yes"));
    }
}
