import java.util.Scanner;

public class test {
    public static void main(String[] args) {
       ShuffleCipher shuffle = new ShuffleCipher(2);
       SubstitutionCipher substitute = new SubstitutionCipher(3);

        Scanner input = new Scanner(System.in);

       System.out.println("Welcome to The Cipher program");
       System.out.println("Enter y/Y to join and n/N to exit Cipher program: ");
       char yesNO= input.next().charAt(0);
       while(yesNO != 'N' && yesNO != 'n'){
           message();
           int i= input.nextInt();
           switch(i){
               case 1:
                   System.out.println("What is the key (shift amount) for your code?");
                   int x= input.nextInt();
                   ((SubstitutionCipher)substitute).setShift(x);
                   System.out.println("Enter a message to be encoded or decoded.");
                   input.nextLine();
                   String m = input.nextLine();
                   System.out.println("Encode (E) or Decode (D)");
                   char w = input.next().charAt(0);
                   if(w=='D')
                       System.out.println("Decodes to :"+((SubstitutionCipher)substitute).decode(m));
                   else if(w=='E')
                       System.out.println("Encodes to :"+((SubstitutionCipher)substitute).encode(m));
                   break;
               case 2:
                   System.out.println("What is the key (shuffle amount) for your code?");
                   int t= input.nextInt();
                   ((ShuffleCipher)shuffle).setN(t);
                   System.out.println("Enter a message to be encoded or decoded.");
                   input.nextLine();
                   String tt = input.nextLine();
                   System.out.println("Encode (E) or Decode (D)");
                   char ttt = input.next().charAt(0);
                   if(ttt=='D')
                       System.out.println("Decodes to :"+((ShuffleCipher)shuffle).decode(tt));
                   else if(ttt=='E')
                       System.out.println("Encodes to :"+((ShuffleCipher)shuffle).encode(tt));
                   break;

           }
           System.out.println("Do you want to do another message (Y)");
           yesNO= input.next().charAt(0);
       }

    }


    public static void message(){
        System.out.println("Type 1 for Substitution Cipher.");
        System.out.println("Type 2 for Shuffle Cipher.");
    }
}
