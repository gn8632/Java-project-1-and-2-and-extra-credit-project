
import java.util.*;
public class ShuffleCipher extends EncoderDecoder implements MessageEncoder, MessageDecoder {
    int n;


    public ShuffleCipher(int n) {
        this.n = n;
    }
    //This method set the shuffle amount from user
    public void setN(int N){
        this.n=N;
    }
    private int getN(){return this.n;}


    @Override
    //This method calls the shuffle and shuffle N times
    public String encode(String plainText) {
        String cipherText = plainText;
        for(int i=0; i<this.getN(); i++){
            cipherText = shuffle(cipherText);
        }
        return cipherText;
    }

    //This method shuffle the string once.
    private String shuffle(String message) {

        String add="";
        //make string into a character array.
        char [] m = message.toCharArray();
        if(m.length==2) {
            //if length is two we just change the order
            for (int i=1; i >=0; i--)
                add+=m[i];
        }

        //divide the array into half. Add the first character from first
        // half and second half. Then second character from first and second half,
        // and continue until it reach the end.
        int j = 1 + (m.length - 1) / 2 ;
        for (int i = 0; i <= (m.length - 1) / 2; i++) {
            add += m[i];
            if (j < m.length) {
                add += m[j++];
            }
        }

        return add;
    }

    @Override
    //This method calls unShuffle and un-shuffle N times
    public String decode(String cipherText) {
        String x = cipherText;
        for(int i=0; i < this.getN(); i++){
            x=unShuffle(x);
        }
        return x;
    }

    //This method unShuffle the string once. It copes the
    // value into string and returns as a string
    private String unShuffle(String s){

        char [] ar= s.toCharArray();
        char [] x= new char[ar.length];
        int j=0;
        for(int i=0; i < ar.length;i=i+2)
            x[j++]=ar[i];
        for(int i=1; i <ar.length;i=i+2)
            x[j++]=ar[i];

       return new String(x);
    }
}
