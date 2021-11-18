package SA_game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Player {

    public void players(){

        Ladder ladder = new Ladder();
       Snake snake = new Snake();

        Map<String, String> boardLadders = new HashMap<>();
        boardLadders.put("9", "31");
        boardLadders.put("18", "64");
        boardLadders.put("16", "45");
        boardLadders.put("48", "66");
        boardLadders.put("50", "93");
        boardLadders.put("63", "81");

        Map<String, String> boardSnakes = new HashMap<>();
        boardSnakes.put("5", "32");
        boardSnakes.put("22", "74");
        boardSnakes.put("39", "99");
        boardSnakes.put("51", "86");


        Scanner scanner = new Scanner(System.in);

        int userPosition = 0;
        int rollDice = 0;

        System.out.print("You need to roll a 6 to start the game, press Enter to roll?");
        String scan = scanner.nextLine();
        scan += "y";
        if (scan.equalsIgnoreCase("y")) {
            
            rollDice = (int) (Math.random() * 6) + 1;
            if (rollDice == 6) {
                userPosition = rollDice;
                System.out.println("Game Started!");
                while (userPosition < 100) {
                    System.out.println("you are on " + userPosition + ",\nWould you like to roll? (yes/no)");
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("yes")) {
                        rollDice = (int) (Math.random() * 6) + 1;
                        System.out.println(rollDice);
                        userPosition += rollDice;
                        if (ladder.ladders(userPosition, boardLadders) == 0 && snake.snakes(userPosition, boardSnakes) == 0) {
                            System.out.println("You advanced to " + userPosition);
                        } else {
                            if (ladder.ladders(userPosition, boardLadders) != 0) {
                                userPosition = ladder.ladders(userPosition, boardLadders);
                                System.out.println("You climbed a ladder to " + userPosition);
                            } else {
                                userPosition = snake.snakes(userPosition, boardSnakes);
                                System.out.println("You were swallowed by a snake and pooped at " + userPosition);

                            }
                        }
                    } else {
                        break;
                    }
                    System.out.println(userPosition);
                }
            } else {
                System.out.println("You rolled a " + rollDice);
            }
        } else {
            System.out.println("buh bye");
        }
        scanner.close();
    }
    }

