import java.util.*;
import java.math.BigInteger;

public class square_of_big_num
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        int n = a.toString().length();
        a = get_square(a,n);
        System.out.println(a);
        sc.close();
    }

    public static BigInteger get_square(BigInteger num,int n)
    {
        if(n == 1)
            return num.multiply(num);

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ZERO;

        int n1,n2;
        n2 = (int)n/2;
        n1 = n-n2;

        BigInteger i = BigInteger.ONE;
        while(n2 != 0)
        {
            b = b.add(num.mod(BigInteger.TEN).multiply(i));
            num = num.divide(BigInteger.TEN);
            i = i.multiply(BigInteger.TEN);
            n2--;
        }
        n2 = n/2;
        a = num;
        
        BigInteger c = num.multiply(BigInteger.TWO).multiply(b).multiply(BigInteger.TEN.pow(n2));
        
        a = get_square(a,n1).multiply(BigInteger.TEN.pow(n2+n2));
        a = a.add(get_square(b,n2));
        a = a.add(c);
        return  a;
    }
}


