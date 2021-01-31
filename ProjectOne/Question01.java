
import java.util.Scanner;
public class Question01 {
    public static void main(String[] args) {
        Scanner inputChar = new Scanner(System.in);

        char [][] arr = new char[13][6];
        SeatInitialize(arr);

        System.out.println("This program assigns seats for a commercial airplane.");
        System.out.println("The current seat assignments is as follows.");
        SetAssignments(arr);
        MenuOption(); // Menu options being called

        char YesNo,FlightClass;
        YesNo = inputChar.next().charAt(0);

        //If input is N or n the program will terminate
        while (YesNo != 'N' && YesNo != 'n'){

            //User can assign a seat when entered y or Y
            if(YesNo== 'Y' || YesNo == 'y') {
                System.out.print("Enter ticket type: F/f (first class); (B/b) (business class); E/e (economy class):");
                FlightClass = inputChar.next().charAt(0);
                AssignSeat(arr, FlightClass);

                System.out.println("This program assigns seats for a commercial airplane.");
                System.out.println("The current seat assignments is as follows.");
                SetAssignments(arr);
            }

            MenuOption(); // Menu options being called
            YesNo = inputChar.next().charAt(0);
        }
    }

    //This function initialize table with *
     public static void SeatInitialize(char [][]arr){
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < arr[i].length; j++)
                arr[i][j]='*';
        }
    }


    public static void MenuOption(){
        System.out.println("Rows 1 and 2 are for first class passengers.");
        System.out.println("Rows 3 through 7 are for business class passengers.");
        System.out.println("Rows 8 through 13 are for economy class passengers.");
        System.out.println("To reserve a seat enter Y/y(Yes), N/n(No): ");
    }

    public static void AssignSeat(char [][]arr, char FlightClass){

        switch(FlightClass){
            case 'F': case 'f':
                // Passing row 1 and 2 for first class
                reduceCopyingPastingCode(arr,1,2);
                break;
            case 'B': case 'b':
                // Passing row 3 and 7 for business class
                reduceCopyingPastingCode(arr,3,7);
                break;
            case 'E': case 'e':
                // Passing row 8 and 13 for economy class
                reduceCopyingPastingCode(arr,8,13);
                break;
        }
    }

    //Return true if the seat is empty. Otherwise return false
    public static boolean OccupiedSeats(char [][] arr, int row, char column){
        return arr[row - 1][getColumnIndex(column)] != 'X';
    }

    //When user enters the Seat from A to F. It will return
    //the index of each column
    public static int getColumnIndex(char w){

        if(w== 'A' )
            return 0;
        else if (w== 'B')
            return 1;
        else if (w== 'C')
            return 2;
        else if (w== 'D')
            return 3;
        else if (w== 'E')
            return 4;
        else
            return 5;
    }

    //This function prints the table
    public static void SetAssignments(char [][] arr){

        char [] Arr ={'A', 'B', 'C','D','E','F'};
        String [] strArr = {"Row 1", "Row 2", "Row 3", "Row 4", "Row 5",
                "Row 6", "Row 6", "Row 8", "Row 9", "Row 10", "Row 11", "Row 12", "Row 13"};
        for (char c : Arr) System.out.print("\t\t" + c);
        //It will print the plane seats ex: A   B   C   D   E    F
        System.out.println();

        for(int i=0; i < arr.length; i++){
            System.out.print(strArr[i]); // Print the raw 1
            for(int j=0; j < arr[i].length; j++)
            {
                System.out.print("\t"+arr[i][j] + "\t");
                //Prints the row of the array that we passed to the function.
                //ex: Row 1  *   *    *    *    *   *   *
            }
            System.out.println(); // goes to next line.
            //it will print 13 rows total just like the table
            //in the project.
        }
        System.out.println("* -- available seat");
        System.out.println("X -- occupied seat");
    }


    //First class is from row 1 to 2, business is 3 to 7, and economy is 8 to 13
    //I need three cases ( F/f, B/b, E/e) for each class. The code will be similar for
    // all three cases. I made this function to take an array, start of row [index] ,
    // and end of row[index]
    public static void reduceCopyingPastingCode(char [][] arr, int Start_of_row, int End_of_row){
        Scanner input = new Scanner(System.in);

        int row;
        System.out.print("Enter Row number "+Start_of_row + " - "+End_of_row+ " :");
        row = input.nextInt();
        //The while loop check if the row is from 1 to 2, or 3 to 7,
        //or 8 to 13. Ask again if the row is not from this range
        while(row < Start_of_row || row > End_of_row){
            System.out.print("Enter Row number "+Start_of_row + " - "+End_of_row+ " :");
            row = input.nextInt();
        }

        char column;
        System.out.print("Enter seat number (A - F):");
        column = input.next().charAt(0);
        //It takes only capital letter from A to F
        while (column < 65 || column > 70){
            System.out.print("Enter seat number (A - F):");
            column = input.next().charAt(0);
        }

        //If the seat is already taken, the program will ask user
        //to enter another rows and seats. If the seat is not taken
        //the program will skip the while loop and assign the seat
        // for them.
        while(!OccupiedSeats(arr,row,column)){

            System.out.println("*#*#*#*# This seat is occupied *#*#*#*#");
            System.out.println("Make another selection");
            SetAssignments(arr);

            System.out.print("Enter Row number "+Start_of_row + " - "+End_of_row+ " :");
            row = input.nextInt();
            while(row < Start_of_row || row > End_of_row){
                System.out.print("Enter Row number "+Start_of_row + " - "+End_of_row+ " :");
                row = input.nextInt();
            }

            System.out.print("Enter seat number (A - F):");
            column = input.next().charAt(0);
            while (column < 65 || column > 70){

                System.out.print("Enter seat number (A - F):");
                column = input.next().charAt(0);
            }

        }
        arr[row-1][getColumnIndex(column)] = 'X';
        System.out.println("The seat reserved for you");
        SetAssignments(arr);
    }
}
