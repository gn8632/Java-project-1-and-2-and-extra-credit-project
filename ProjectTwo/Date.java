
public class Date {

    private int day;
    private int month;
    private int year;

    Date(){
        day =0;
        month=0;
        year =0;
    }

    Date(int month, int day, int year){
        this.day=day;
        this.month=month;
        this.year = year;
    }

    //Set the date
    void setDate(int month, int day, int year) {
        this.month=month;
        this.day=day;
        this.year=year;
    }



    void setDay(int day){
        if(day > 0 && day < getDaysInTheMonth(getMonth()))
            this.day=day;
        else
            this.day=1;
    }

    void setMonth(int month){
        if(month >= 1 && month <= 12)
            this.month= month;
        else
            this.month = 1;//set to january

    }

    void setYear(int year){
        if (year > 0)
            this.year=year;
        else
            this.year =1;

    }

    int getDay(){return day;}
    int getMonth(){return month;}
    int getYear(){return year;}

    public boolean isLeapYear(){
        return (getYear() % 100 != 0 && getYear()
                % 4 == 0 || getYear() % 400 == 0);
    }


    public  int getDaysInTheMonth(int month){
        switch (month){
            case 1:case 3:
            case 5:case 7:
            case 8:case 10:
            case 12:
                return 31;
            case 2:
                return (isLeapYear()? 29: 28);
            case 4: case 6:
            case 9: case 11:
                return 30;
            default:
                return -1;
        }
    }

    public int daysPassedInYears(){
        int totalDays = 0;
        for(int i= 1; i < getMonth(); i++){
            // add all the days from previous months
            totalDays+= getDaysInTheMonth(i);
        }
        return totalDays+getDay();// return previous + current day
    }


    public int daysRemainingItTheYear(){
        int totalDays = 0;
        for(int i= 1; i < getMonth(); i++){
            totalDays+= getDaysInTheMonth(i);
            //adds all previous days
        }
        // subtract previous days and current day from 365
        return 365 - totalDays - getDay();
    }


    public void addDays(int days){

        int totalDays = days + getDay();

        while(totalDays > getDaysInTheMonth(getMonth())) {
            totalDays -= getDaysInTheMonth(getMonth());
            if(getMonth() == 12) {// if month is december reset to jan
                // also update year to next year
                setMonth(1);
                setYear(getYear()+1);
            }
            else
            {
                //if month > 12 update month
                setMonth(getMonth()+1);
            }
        }
        setDay(totalDays);
    }

    Date CopyOfDate(){
        return new Date(day,month,year);
    }

    public void CopyOfAnotherDate(Date x){
        this.day = x.day;
        this.month= x.month;
        this.year = x.year;
    }

    @Override
    public String toString(){
        return getMonth() +" - "+getDay()+" - "+getYear();
    }

}
