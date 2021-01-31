

public class ExtDate extends Date {
    private String months;
    private String [] name ={
            "January","February","March","April","May",
            "Jun","July","August","September","October",
            "November","December"
    };
    ExtDate(int month, int day, int year){
        super(month,day,year);
    }

    public void setMonths(){
        this.months= name[super.getMonth()-1];
    }
    public String getMonths(){
        return months;
    }

    public void printAsMonthDayYear(){
        System.out.println(this.getMonths()+
                " "+super.getDay()+" ,"+super.getYear());
    }
    public void printAsMonthYear(){
        System.out.println(this.getMonths()+" "+super.getYear());
    }

    @Override
    public void addDays(int days) {

        super.addDays(days);
        this.setMonths();
        System.out.print("After increment date :" );
        this.printAsMonthDayYear();
    }

}
