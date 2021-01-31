
public class SubstitutionCipher extends EncoderDecoder implements MessageEncoder, MessageDecoder {

    int shift;

    public SubstitutionCipher(int shift) {
        this.shift = shift;
    }

    //This method shift one character and returns it
    private char shifter(char letter) {
        return (char)(letter + this.getShift());
    }
    //It set the shift value from user
    public void setShift(int shift){
        this.shift=shift;
    }

    private int getShift(){return this.shift;}

    @Override
    //This method calls shifter to shift each characters
    // in the string
    public String encode(String plainText) {
        String enc = "";
        for(int i=0;i < plainText.length(); i++)
            enc += shifter(plainText.charAt(i));

        return enc;
    }

    @Override
    //This method subtract the shift value from a character array
    // and type cast to its original value.
    public String decode(String cipherText) {
        String m ="";
        for(int i =0; i < cipherText.length(); i++){
            m+= (char)(cipherText.charAt(i)-shift);
        }
        return m;
    }
}
