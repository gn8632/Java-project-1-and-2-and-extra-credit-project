
public class Day {
    private String days;
    private String [] d ={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday",
            "Saturday"};

    Day(){}
    Day(String d){this.days=d;}
    public void setDays(String d){
        this.days=d;
    }
    public String getDays(){return days;}

    public void printDay(){
        System.out.println(this.getDays());
    }


    public String nextDay(){
        int i=0;
        for(i=0; i < d.length; i++){
            if(getDays().equals(d[i]) ) {
                break;
            }
        }
        //next day is i + 1, if i+1 reach end of week
        //we should reset the day
        return d[((i+1)%7)];

    }

    public String previousDay(){

        int i=0;
        for(i=0; i < d.length; i++){
            if(getDays().equals(d[i]) )
                break;
        }
        if(i==0)//if it sunday, then previous day is saturday
            //index is 6
            return d[6];
        return d[i-1];// or return previous day
    }

    public String addDays(int day){
        int i=0;
        for(i=0; i < d.length; i++){
            if(getDays().equals(d[i]) )
                break;
        }
        // reset the day if the total days > 7
        return d[(i+day)%7];
    }

}
