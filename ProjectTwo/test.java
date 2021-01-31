
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Calendar c = new Calendar();

        ExtDate e = new ExtDate(0,0,0);

        //Set date for calendar and ExtDate class
        System.out.println("Enter month, day, and year");
        int m = input.nextInt();
        int d = input.nextInt();
        int y = input.nextInt();
        c.setDay(d);
        c.setMonth(m);
        c.setYear(y);

        e.setDate(m,d,y);
        e.setMonths();

        //----------------------------------------------//
        message();
        int x = input.nextInt();

        while(x !=9 ){
            switch (x){
                case 1:
                    e.printAsMonthDayYear();
                    break;
                case 2:
                    e.printAsMonthYear();
                    break;
                case 3:
                    System.out.println("Number of days in a month: "+e.getDaysInTheMonth(m));
                    break;
                case 4:
                    System.out.println("Days left in the Year: "+e.daysRemainingItTheYear());
                    break;
                case 5:
                    System.out.println("Days gone in the year: "+e.daysPassedInYears());
                    break;
                case 6:
                    System.out.println("Enter the number of days to be added :");
                    int w= input.nextInt();
                    e.addDays(w);
                    break;
                case 7:
                    c.printCalendar();
                case 8:
                    SaveInFile(e);
                    break;
                case 9:
                    break;
            }
            message();
            x = input.nextInt();
        }

    }
    public static void message(){
        System.out.println("Welcome to the Calendar program.");
        System.out.println("Choose among the following options:");
        System.out.println("1: Print date as month-day-year");
        System.out.println("2: Print date as month-year");
        System.out.println("3: Print number of days in a month");
        System.out.println("4: Print number of days left in a year");
        System.out.println("5: Print number of days gone in a year");
        System.out.println("6: Add number of days and print new date");
        System.out.println("7: Print Calendar");
        System.out.println("8: Save the date in a file");
        System.out.println("9: Terminate the program");
    }
    public static void SaveInFile( ExtDate ex) {

        try {
            java.io.File file = new java.io.File("date.txt");
            if (file.exists()) {
                System.out.println("The file exists");
            }
            java.io.PrintWriter output = new java.io.PrintWriter(file);

            output.println(ex.getMonths() +" "+ex.getDay()+" , "+ex.getYear());

            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
