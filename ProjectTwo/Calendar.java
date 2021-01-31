
public class Calendar {
    private ExtDate e= new ExtDate(0,0,0);
    private Day d =new Day();


    //For the Gregorian calender
    public int firstDayOfMonth(){
        double q= 0;
        double a = (13 * (this.getMonth()+1))/5d;
        double k = this.getYear() %100;
        double b = k/4d;
        double j = this.getYear()/100d;
        double c= (j /4d)-2 *j;
        return (int)(q + a + k + b + c) % 7;
    }

    public void  setMonth(int m){
        e.setMonth(m);
        e.setMonths();
    }
    public void setYear(int y){
        e.setYear(y);
    }
    public void setDay(int d){
        e.setDay(d);
    }

    public int getMonth(){
        return e.getMonth();
    }

    public int getYear(){
        return e.getYear();
    }



    public int getDay(){
        return e.getDay();
    }
    public String getStringMonth(){
        return e.getMonths();
    }


    public void printCalendar(){

        // prints month year
        System.out.println("   " + this.getStringMonth()+ " " + this.getYear());
        //prints days sun - mon ..... sat
        System.out.println("Sun Mon Tue Wed Thr Fri Sat");

        int firstDay= this.firstDayOfMonth();//gets the index of first day
        //of month
        for(int i =0; i < firstDay; i++)
            System.out.print("    "); // fill up with blank spaces before
        //the first day
        for (int i = 1; i <= e.getDaysInTheMonth(this.getMonth()); i++) {
            System.out.printf("%4d", i);
            if (( i+ firstDay) % 7 == 0)// reset the day when it length 7
                System.out.println();
        }
    }



}



