//madison davis
//Go board
//4/7/24

import java.util.ArrayList;
import java.util.Scanner;

public class Go {

    static String[][] GoBoard = new String[9][9];

    /*
    static String[][] GoBoard = {
            {null, null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null, null,},
            {null, null, null, null, null, null, null, null, null,}
    };
    */

    //keeps track of first structure, allos us to check if piece is alive or not
    static boolean[][] lives = new boolean[9][9];

    //static boolean[][] territory = new boolean[9][9];
    //static boolean beenChecked = new boolean[9][9];

    //to store pieces once captured
    ArrayList <String> captured = new ArrayList <String>();


    //not working right, won't print char
    static String white = "◯";
    static String black = "●";

    //checks if piece is alive
    static void isAlive(){
        boolean life = True;
        //check surrounding spaces to see if there are liberties

    }

    public static void main (String [] args){
        int moveX;
        int moveY;

        Boolean cont = true;
        Boolean player_turn = true;

        int max_length = GoBoard.length;

        //stones life
        int liberties = 0;

        Scanner user_input = new Scanner(System.in);

        //System.out.println(max_length);

        while (cont){

            System.out.println("0 1 2 3 4 5 6 7 8 9");
            
            for (int i = 0; i < GoBoard.length; i++) {
                // handles columns of board (19)
                System.out.print(i + 1 + " ");

                for (int j = 0; j < GoBoard[i].length; j++) {
                    if(GoBoard[i][j] == null){
                        System.out.print("-|");

                    }
                    else
                        System.out.print(GoBoard[i][j]);
        
                    // GoBoard[i][j] = " ";
                    // System.out.print(GoBoard[i][j]);

                }
                System.out.println();
            }

        //say if black or whites turn
        //System.out.print("It is " + color + "")
        System.out.println("\n" + ((player_turn) ? "Black" : "White") + "'s turn\n\n");
        
        System.out.println("What row would you like to place your piece at " + ((player_turn) ? "Black" : "White") + " (or 00 to pass) ?");
        //black or white piece
        moveX = user_input.nextInt();

        System.out.println("What column would you like to place your piece at " + ((player_turn) ? "Black" : "White") + " (or 00 to pass) ?");
        //black or white piece
        moveY = user_input.nextInt();

        //prints players move
        if (moveY != 00 && moveX != 00){
            System.out.println(((player_turn) ? "Black" : "White") + " you placed your piece at: ");
            //+ where piece moved
            System.out.println(moveX + "," + moveY);
            System.out.println();
        }else{
            System.out.println(((player_turn) ? "Black" : "White") + " has passed on their turn");
            System.out.println();
        }
        
        //passing on players turn
        if (moveY == 00 || moveX == 00){
            player_turn = !player_turn;
            continue;
        
        }else if (moveY > max_length || moveY < 0 || (moveX > max_length || moveX < 0)){
            System.out.println("Out of Bounds");
            System.out.println();
            //System.out.println(max_length);
            //System.out.println();
            continue;

        //works for anything but not zero gives an index error
        } else{
            if ((moveY == 0) || (moveX == 0) ){
                System.out.println("Not a valid move please choose again");
                System.out.println();
                continue;

            }else if (GoBoard[moveY - 1][moveX - 1] == null){
                GoBoard[moveY - 1][moveX - 1] = ((player_turn) ? "-B" : "-W");

            }else {
                System.out.println("There is already a piece there, please choose another space");
                System.out.println();
                continue;
            }
        }
        
        player_turn = !player_turn;
        
        }     
        
        //out of player loop


    }
}

