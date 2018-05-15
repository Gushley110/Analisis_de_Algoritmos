import java.util.Scanner;
import java.math.BigInteger;
public class permutacion {

    /*
    int[][] permutar(){
        int P[][];

        return P;
    }
*/
    public static String toHex(String arg){
        return String.format("%x", new BigInteger(1,arg.getBytes()));
    }

    public static void main(String[] args) {
        String palabra, hexP, binP;
        int binPal[]={};

        Scanner sc = new Scanner(System.in);
        System.out.println("Permutation and De-Permutation");
        System.out.println("Please, give me the 4 character word you want to permute:");
        palabra = sc.nextLine();
        if (palabra.length() != 4) {
            System.out.println("Your word must have 4 characters.");
            System.exit(0);
        }
        hexP = toHex(palabra);
        System.out.println("The HEX code is: "+hexP);

        binP = Integer.toBinaryString(Integer.parseInt(hexP,16));
        for (int i=0; i<binP.length(); i++){
            if((i+1)%8==0){
                //binPal[i]=Integer.parseInt(binP.charAt(i));
                System.out.print(binP.charAt(i));
                System.out.println("");
            }else{
                System.out.print(binP.charAt(i));
            }
        }






    }
}