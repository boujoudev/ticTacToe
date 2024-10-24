import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {


        char[][] grid = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        PrintGride(grid);
        Scanner scanner=new Scanner(System.in);
         Vector<Integer> PlayerPos =new Vector<>();
         Vector<Integer> ComputerPoss = new Vector<>();
        boolean game=true;
        while (game) {
            boolean SamePose;
            Random rand=new Random();


            System.out.println(" ur turn choose a position");


            int pos = scanner.nextInt();
            int ComputerPos= rand.nextInt(9)+1;



             SamePose=true;
            while (SamePose){
                if (!PlayerPos.contains(pos)&&!ComputerPoss.contains(pos))
                {
                    PlaceSymbols(pos, grid, "player");
                    break;
                }

                else {
                    System.out.println("STOP CHEATING");
                    pos=scanner.nextInt();

                }
            }
            PlayerPos.add(pos);
            if (WinCheck(PlayerPos)){
                win(game);
                break;
            }



            if (PlayerPos.size()+ComputerPoss.size()==9){
                game=false;
                System.out.println("tie");
                break;

            }


            SamePose=true;
            while (SamePose){
                if (!PlayerPos.contains(ComputerPos)&&!ComputerPoss.contains(ComputerPos))
                {
                PlaceSymbols(ComputerPos, grid, "computer");
                break;
                }
                ComputerPos=rand.nextInt(9)+1;
            }


            ComputerPoss.add(ComputerPos);
            if (WinCheck(ComputerPoss)){
                loose(game);
                break;
            }




            if (PlayerPos.size()+ComputerPoss.size()==9){
                tie(game);
                break;


            }
        }
    }


    public static void tie(boolean game){
        game=false;
        System.out.println("tie");


    }
    public static void win(boolean game){
        game=false;
        System.out.println("WINNER WINNER CHICKEN DINNER");

    }
    public static void loose(boolean game){
        game=false;
        System.out.println("U suck 7abacha");

    }
    public static boolean WinCheck(Vector<Integer> PosList){
        if ((PosList.contains(1)&&PosList.contains(2)&&PosList.contains(3))||(PosList.contains(4)&&PosList.contains(5)&&PosList.contains(6))||(PosList.contains(7)&&PosList.contains(8)&&PosList.contains(9))||
        (PosList.contains(1)&&PosList.contains(4)&&PosList.contains(7))||(PosList.contains(2)&&PosList.contains(5)&&PosList.contains(8))||(PosList.contains(3)&&PosList.contains(6)&&PosList.contains(9))||
                (PosList.contains(1)&&PosList.contains(5)&&PosList.contains(9))||(PosList.contains(3)&&PosList.contains(5)&&PosList.contains(7))
        )
        { return true;

        }else return false;
    }




















    public static void PrintGride(char[][] grid) {
        for (char[] line : grid) {
            for (char c:line){
                System.out.print(c);
            }
            System.out.println();


        }

    }












    public  static void PlaceSymbols(int pos,char[][] grid,String user){
        char symbol='X';
        if (user=="player"){
            symbol='X';
        } else if (user=="computer") {
            symbol='O';
        }
        switch (pos){
        case 1:grid[0][0]=symbol;
            break;
        case 2:grid[0][2]=symbol;
            break;
        case 3:grid[0][4]=symbol;
            break;
        case 4:grid[2][0]=symbol;
            break;
        case 5:grid[2][2]=symbol;
            break;
        case 6:grid[2][4]=symbol;
            break;
        case 7:grid[4][0]=symbol;
            break;
        case 8:grid[4][2]=symbol;
            break;
        case 9:grid[4][4]=symbol;
            break;
        default: break;

    }

        PrintGride(grid);
    }



}